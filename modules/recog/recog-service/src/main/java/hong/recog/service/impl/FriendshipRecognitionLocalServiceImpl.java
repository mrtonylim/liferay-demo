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

import com.liferay.portal.aop.AopService;
import hong.recog.model.FriendshipRecognition;
import hong.recog.service.base.FriendshipRecognitionLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the friendship recognition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the <code>hong.recog.service.FriendshipRecognitionLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hong
 * @see FriendshipRecognitionLocalServiceBaseImpl
 */
@Component(
    property = "model.class.name=hong.recog.model.FriendshipRecognition",
    service = AopService.class
)
public class FriendshipRecognitionLocalServiceImpl extends
    FriendshipRecognitionLocalServiceBaseImpl {

  public FriendshipRecognition addFriendshipRecognition(long recognitionId, String detailA,
      String detailB, String detailC) {
    FriendshipRecognition friendshipRecognition = createFriendshipRecognition(recognitionId);
    friendshipRecognition.setDetailA(detailA);
    friendshipRecognition.setDetailB(detailB);
    friendshipRecognition.setDetailC(detailC);
    friendshipRecognitionPersistence.update(friendshipRecognition);
    return friendshipRecognition;
  }

  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never reference this class directly. Use <code>hong.recog.service.FriendshipRecognitionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>hong.recog.service.FriendshipRecognitionLocalServiceUtil</code>.
   */
}