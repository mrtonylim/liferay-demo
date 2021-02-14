package hong.recog.portlet;

import static hong.recog.constants.RecognitionPortletKeys.RECOGNITION;
import static hong.recog.constants.RecognitionPortletPath.RECOGNITION_JSP;
import static hong.recog.constants.RecognitionPortletPath.RECOGNITION_LIST_JSP;
import static hong.recog.constants.RecognitionPortletPath.SELECT_COLLEAGUE_JSP;
import static hong.recog.constants.RecognitionPortletPath.SELECT_VALUE_JSP;
import static hong.recog.constants.RecognitionValue.FRIENDSHIP;
import static hong.recog.constants.RecognitionValue.PERFORMANCE;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.PortletServlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import hong.recog.constants.RecognitionPageMode;
import hong.recog.model.FriendshipRecognition;
import hong.recog.model.PerformanceRecognition;
import hong.recog.model.Recognition;
import hong.recog.service.AddRecognitionResult;
import hong.recog.service.FriendshipRecognitionLocalService;
import hong.recog.service.PerformanceRecognitionLocalService;
import hong.recog.service.RecognitionLocalService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author hong
 */
@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.social",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.display-name=Recognition",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/recognition/view.jsp",
        "javax.portlet.name=" + RECOGNITION,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class RecognitionPortlet extends MVCPortlet {

  private static final Log log = LogFactoryUtil.getLog(RecognitionPortlet.class);

  @Reference
  private RecognitionLocalService recognitionLocalService;

  @Reference
  private PerformanceRecognitionLocalService performanceRecognitionLocalService;

  @Reference
  private FriendshipRecognitionLocalService friendshipRecognitionLocalService;

  @Reference
  private UserLocalService userLocalService;

  public void addPerformanceRecognition(ActionRequest request, ActionResponse response)
      throws PortalException {
    addRecognition(request, response, recognitionId ->
        performanceRecognitionLocalService.addPerformanceRecognition(
            recognitionId,
            ParamUtil.getString(request, "detail1"),
            ParamUtil.getString(request, "detail2")));
  }

  public void addFriendshipRecognition(ActionRequest request, ActionResponse response)
      throws PortalException {
    addRecognition(request, response, recognitionId ->
        friendshipRecognitionLocalService.addFriendshipRecognition(
            recognitionId,
            ParamUtil.getString(request, "detailA"),
            ParamUtil.getString(request, "detailB"),
            ParamUtil.getString(request, "detailC")
        ));
  }

  private void addRecognition(
      ActionRequest request,
      ActionResponse response,
      Function<Long, Object> detailsFunction)
      throws PortalException {

    AddRecognitionResult result = recognitionLocalService.addRecognition(
        ParamUtil.getLong(request, "toUserId"),
        ParamUtil.getString(request, "value"),
        ParamUtil.getString(request, "subject"),
        ServiceContextFactory.getInstance(Recognition.class.getName(), request));
    Recognition recognition = result.getRecognition();

    request.setAttribute("recognition", recognition);
    request.setAttribute("managerName",
        result.getManagers()
            .stream()
            .map(User::getFullName)
            .collect(Collectors.joining(", "))
    );
    response.getRenderParameters().setValue("mvcPath", RECOGNITION_JSP);
    response.getRenderParameters().setValue("mode", "done");

    Object details = detailsFunction.apply(recognition.getRecognitionId());
    request.setAttribute(recognition.getValue() + "Recognition", details);
  }

  @Override
  public void render(RenderRequest request, RenderResponse response)
      throws IOException, PortletException {
    try {
      doRender(request);
    } catch (PortalException e) {
      throw new PortletException(e);
    }
    super.render(request, response);
  }

  private void doRender(RenderRequest request) throws PortalException {

    ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

    String mvcPath = ParamUtil.getString(request, "mvcPath");
    if (SELECT_COLLEAGUE_JSP.equals(mvcPath)) {
      renderSelectColleague(request, serviceContext);
    } else if (SELECT_VALUE_JSP.equals(mvcPath)) {
      renderSelectValue(request);
    } else if (RECOGNITION_JSP.equals(mvcPath)) {
      renderRecognition(request);
    } else if (RECOGNITION_LIST_JSP.equals(mvcPath)) {
      renderRecognitionList(request);
    }
  }

  private void renderSelectColleague(RenderRequest request, ServiceContext serviceContext)
      throws PortalException {

    String keywords = ParamUtil.getString(request, "keywords", "");
    List<User> users = Collections.emptyList();
    if (!keywords.isEmpty()) {
      User currentUser = userLocalService.getUserById(serviceContext.getUserId());
      users = userLocalService
          .searchUsers(currentUser.getCompanyId(), keywords, 0, null, 0, 10, new Sort[]{})
          .getBaseModels();
    }
    request.setAttribute("users", users);
  }

  private void renderSelectValue(RenderRequest renderRequest) throws PortalException {
    renderForToUser(renderRequest);
  }

  private void renderRecognition(RenderRequest request) throws PortalException {
    String mode = ParamUtil.getString(request, "mode");
    if (RecognitionPageMode.ADD.equals(mode)) {
      renderForToUser(request);
    } else if (RecognitionPageMode.VIEW.equals(mode)) {
      long recognitionId = ParamUtil.getLong(request, "recognitionId");
      Recognition recognition = recognitionLocalService.getRecognition(recognitionId);
      request.setAttribute("recognition", recognition);
      if (PERFORMANCE.equals(recognition.getValue())) {
        PerformanceRecognition performanceRecognition = performanceRecognitionLocalService
            .getPerformanceRecognition(recognitionId);
        request.setAttribute("performanceRecognition", performanceRecognition);
      } else if (FRIENDSHIP.equals(recognition.getValue())) {
        FriendshipRecognition friendshipRecognition = friendshipRecognitionLocalService
            .getFriendshipRecognition(recognitionId);
        request.setAttribute("friendshipRecognition", friendshipRecognition);
      }
    }
  }

  private void renderForToUser(RenderRequest request) throws PortalException {
    long toUserId = ParamUtil.getLong(request, "toUserId", 0);
    if (toUserId > 0) {
      request.setAttribute("toUser", userLocalService.getUser(toUserId));
    }
  }

  private void renderRecognitionList(RenderRequest request) throws PortalException {

    String value = ParamUtil.getString(request, "value");
    String keywords = ParamUtil.getString(request, "keywords", "");
    SearchContext searchContext = SearchContextFactory.getInstance((
        HttpServletRequest) request.getAttribute(PortletServlet.PORTLET_SERVLET_REQUEST));

    searchContext.setKeywords(keywords);
    searchContext.setAttribute("paginationType", "more");
    searchContext.setAttribute("value", value);
    searchContext.setStart(0);
    searchContext.setEnd(50);

    Indexer<Recognition> indexer = IndexerRegistryUtil.getIndexer(Recognition.class);
    Hits hits = indexer.search(searchContext);

    List<Recognition> recognitions = new ArrayList<>();

    for (int i = 0; i < hits.getDocs().length; i++) {
      Document doc = hits.doc(i);
      long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
      Recognition entry = recognitionLocalService.getRecognition(entryId);
      if (entry.getValue().equals(value)) {
        recognitions.add(entry);
      }
    }
    request.setAttribute("recognitions", recognitions);
  }
}
