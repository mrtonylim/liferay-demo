package hong.recog.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import hong.recog.constants.RecognitionConstants;
import hong.recog.model.Recognition;
import hong.recog.service.RecognitionLocalService;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class RecognitionModelResourcePermissionRegistrar {

  @Activate
  public void activate(BundleContext bundleContext) {
    Dictionary<String, Object> properties = new HashMapDictionary<>();

    properties.put("model.class.name", Recognition.class.getName());

    serviceRegistration = bundleContext.registerService(
        ModelResourcePermission.class,
        ModelResourcePermissionFactory.create(
            Recognition.class, Recognition::getRecognitionId,
            recognitionLocalService::getRecognition, _portletResourcePermission,
            (modelResourcePermission, consumer) -> {
              consumer.accept(
                  new StagedModelPermissionLogic<>(
                      stagingPermission, "hong_recog_RecognitionPortlet",
                      Recognition::getRecognitionId));
              consumer.accept(
                  new WorkflowedModelPermissionLogic<>(
                      workflowPermission, modelResourcePermission,
                      groupLocalService, Recognition::getRecognitionId));
            }),
        properties);
  }

  @Deactivate
  public void deactivate() {
    serviceRegistration.unregister();
  }

  @Reference
  private RecognitionLocalService recognitionLocalService;

  @Reference(target = "(resource.name=" + RecognitionConstants.RESOURCE_NAME + ")")
  private PortletResourcePermission _portletResourcePermission;

  private ServiceRegistration<ModelResourcePermission> serviceRegistration;

  @Reference
  private StagingPermission stagingPermission;

  @Reference
  private WorkflowPermission workflowPermission;

  @Reference
  private GroupLocalService groupLocalService;
}
