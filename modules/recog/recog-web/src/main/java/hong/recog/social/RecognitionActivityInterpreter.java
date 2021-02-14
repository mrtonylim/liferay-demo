package hong.recog.social;

import static hong.recog.constants.RecognitionPageMode.VIEW;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.social.kernel.model.BaseSocialActivityInterpreter;
import com.liferay.social.kernel.model.SocialActivity;
import com.liferay.social.kernel.model.SocialActivityInterpreter;
import hong.recog.constants.RecognitionPortletKeys;
import hong.recog.constants.RecognitionPortletPath;
import hong.recog.model.Recognition;
import hong.recog.service.RecognitionLocalService;
import javax.portlet.PortletURL;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    property = "javax.portlet.name=" + RecognitionPortletKeys.RECOGNITION,
    service = SocialActivityInterpreter.class
)
public class RecognitionActivityInterpreter extends BaseSocialActivityInterpreter {

  @Override
  protected ResourceBundleLoader getResourceBundleLoader() {
    return resourceBundleLoader;
  }

  @Override
  public String[] getClassNames() {
    return new String[]{Recognition.class.getName()};
  }

  @Reference
  private volatile ResourceBundleLoader resourceBundleLoader;

  @Override
  protected boolean hasPermissions(PermissionChecker permissionChecker, SocialActivity activity,
      String actionId, ServiceContext serviceContext) throws Exception {
    return true;
  }

  @Override
  protected String getTitle(SocialActivity activity, ServiceContext serviceContext)
      throws Exception {
    Recognition recognition = recognitionLocalService.getRecognition(activity.getClassPK());
    String userName = getUserName(recognition.getUserId(), serviceContext);
    String toUserName = getUserName(recognition.getToUserId(), serviceContext);
    return String.format("%s recognized %s on %s - %s.",
        userName, toUserName, recognition.getValue(),
        wrapLink(getLink(activity, serviceContext), recognition.getSubject()));
  }

  @Override
  protected String getPath(
      SocialActivity activity, ServiceContext serviceContext) throws PortalException {
    Recognition recognition = recognitionLocalService.getRecognition(activity.getClassPK());
    PortletURL portletURL = serviceContext.getLiferayPortletResponse()
        .createRenderURL(RecognitionPortletKeys.RECOGNITION);
    portletURL.setParameter("mvcPath", RecognitionPortletPath.RECOGNITION_JSP);
    portletURL.setParameter("mode", VIEW);
    portletURL.setParameter("recognitionId", String.valueOf(recognition.getRecognitionId()));
    portletURL.setParameter("back", "1");
    return portletURL.toString();
  }

  @Reference
  private RecognitionLocalService recognitionLocalService;
}
