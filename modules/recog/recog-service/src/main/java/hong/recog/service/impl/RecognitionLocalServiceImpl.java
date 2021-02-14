/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package hong.recog.service.impl;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.social.SocialActivityManagerUtil;
import hong.recog.model.Recognition;
import hong.recog.service.AddRecognitionResult;
import hong.recog.service.base.RecognitionLocalServiceBaseImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the recognition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the <code>hong.recog.service.RecognitionLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hong
 * @see RecognitionLocalServiceBaseImpl
 */
@Component(
    property = "model.class.name=hong.recog.model.Recognition",
    service = AopService.class
)
public class RecognitionLocalServiceImpl extends RecognitionLocalServiceBaseImpl {

  @Reference
  private RoleLocalService roleLocalService;

  @Reference
  private UserGroupRoleLocalService userGroupRoleLocalService;

  @Indexable(type = IndexableType.REINDEX)
  public AddRecognitionResult addRecognition(
      long toUserId,
      String value,
      String subject,
      ServiceContext serviceContext) throws PortalException {

    long userId = serviceContext.getUserId();
    User user = userLocalService.getUserById(userId);
    User toUser = userLocalService.getUserById(toUserId);
    Date now = new Date();
    long recognitionId = counterLocalService.increment();

    Recognition recognition = recognitionPersistence.create(recognitionId);
    recognition.setUserId(serviceContext.getUserId());
    recognition.setUserName(user.getFullName());
    recognition.setGroupId(serviceContext.getScopeGroupId());
    recognition.setCreateDate(serviceContext.getCreateDate(now));
    recognition.setModifiedDate(serviceContext.getModifiedDate(now));
    recognition.setToUserId(toUserId);
    recognition.setToUserName(toUser.getFullName());
    recognition.setValue(value);
    recognition.setSubject(subject);
    recognition.setExpandoBridgeAttributes(serviceContext);
    recognitionPersistence.update(recognition);

    if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {
      resourceLocalService.addResources(
          recognition.getCompanyId(), recognition.getGroupId(), recognition.getUserId(),
          Recognition.class.getName(), recognition.getRecognitionId(), false,
          serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
    } else {
      resourceLocalService.addModelResources(
          recognition.getCompanyId(), recognition.getGroupId(), recognition.getUserId(),
          Recognition.class.getName(), recognition.getRecognitionId(),
          serviceContext.getModelPermissions());
    }

    JSONObject extraDataJSONObject = JSONUtil.put(
        "title", recognition.getSubject());
    SocialActivityManagerUtil.addActivity(
        userId, recognition, 2,
        extraDataJSONObject.toString(), 0);

    List<User> managers = findManagers(toUser);
    try {
      sendMail(recognition, user, toUser, managers);
    } catch (AddressException e) {
      throw new PortalException(e);
    }

    AddRecognitionResult result = new AddRecognitionResult();
    result.setRecognition(recognition);
    result.setManagers(managers);

    return result;
  }

  private List<User> findManagers(User toUser) throws PortalException {
    Role managerRole = roleLocalService.getRole(toUser.getCompanyId(), "Organization Manager");
    List<User> managers = new ArrayList<>();
    for (Organization organization : toUser.getOrganizations()) {
      List<UserGroupRole> userGroupRoles = userGroupRoleLocalService
          .getUserGroupRolesByGroupAndRole(organization.getGroupId(), managerRole.getRoleId());
      for (UserGroupRole userGroupRole : userGroupRoles) {
        if (userGroupRole.getUserId() != toUser.getUserId()) {
          managers.add(userGroupRole.getUser());
        }
      }
    }
    return managers;
  }

  private void sendMail(Recognition recognition, User user, User toUser, List<User> managers)
      throws AddressException {
    InternetAddress fromAddress = new InternetAddress("recognition_notification@x.com");
    List<InternetAddress> toAddresses = new ArrayList<>();
    toAddresses.add(new InternetAddress(toUser.getEmailAddress()));
    for (User manager : managers) {
      toAddresses.add(new InternetAddress(manager.getEmailAddress()));
    }
    MailMessage mailMessage = new MailMessage();
    mailMessage.setFrom(fromAddress);
    mailMessage.setTo(toAddresses.toArray(new InternetAddress[0]));
    mailMessage.setSubject(
        String.format("Recognition From %s - %s", user.getFullName(), recognition.getSubject()));
    mailMessage.setBody(
        String.format("%s received a recognition from %s on %s!!!", toUser.getFullName(),
            user.getFullName(), recognition.getValue()));
    MailServiceUtil.sendEmail(mailMessage);
  }

  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never reference this class directly. Use <code>hong.recog.service.RecognitionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>hong.recog.service.RecognitionLocalServiceUtil</code>.
   */
}