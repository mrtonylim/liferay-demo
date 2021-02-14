package hong.recog.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;
import hong.recog.constants.RecognitionConstants;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class RecognitionPortletResourcePermissionRegistrar {

  @Activate
  public void activate(BundleContext bundleContext) {
    Dictionary<String, Object> properties = new HashMapDictionary<>();

    properties.put("resource.name", RecognitionConstants.RESOURCE_NAME);

    _serviceRegistration = bundleContext.registerService(
        PortletResourcePermission.class,
        PortletResourcePermissionFactory.create(
            RecognitionConstants.RESOURCE_NAME,
            new StagedPortletPermissionLogic(
                _stagingPermission, "hong_recog_RecognitionPortlet")),
        properties);
  }

  @Deactivate
  public void deactivate() {
    _serviceRegistration.unregister();
  }

  private ServiceRegistration<PortletResourcePermission> _serviceRegistration;

  @Reference
  private StagingPermission _stagingPermission;
}
