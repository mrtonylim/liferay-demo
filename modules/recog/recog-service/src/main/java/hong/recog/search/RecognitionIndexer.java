package hong.recog.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery.PerformActionMethod;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.search.query.QueryHelper;
import hong.recog.model.Recognition;
import hong.recog.service.RecognitionLocalService;
import java.util.Locale;
import java.util.Map;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    service = Indexer.class
)
public class RecognitionIndexer extends BaseIndexer<Recognition> {

  public RecognitionIndexer() {
    setDefaultSelectedFieldNames(
        Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
        Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
        Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID,
        "userName", "toUserName", "subject");
    setPermissionAware(false);
    setFilterSearch(true);
  }

  @Override
  protected void doDelete(Recognition recognition) throws Exception {
    deleteDocument(recognition.getCompanyId(), recognition.getRecognitionId());
  }

  @Override
  protected Document doGetDocument(Recognition recognition) {
    Document document = getBaseModelDocument(getClassName(), recognition);
    document.addDate(Field.MODIFIED_DATE, recognition.getModifiedDate());
    document.addKeyword("toUserName", recognition.getToUserName());
    document.addKeyword("subject", recognition.getSubject());
    document.addText("value", recognition.getValue());
    return document;
  }

  @Override
  protected Summary doGetSummary(Document document, Locale locale, String snippet,
      PortletRequest portletRequest, PortletResponse portletResponse) {
    Summary summary = createSummary(document);
    summary.setMaxContentLength(200);
    return summary;
  }

  @Override
  protected void doReindex(String className, long classPK) throws Exception {
    Recognition recognition = recognitionLocalService.getRecognition(classPK);
    doReindex(recognition);
  }

  @Override
  protected void doReindex(String[] ids) throws Exception {
    long companyId = GetterUtil.getLong(ids[0]);
    reindexRecognitions(companyId);
  }

  protected void reindexRecognitions(long companyId) throws PortalException {

    final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
        recognitionLocalService.getIndexableActionableDynamicQuery();

    indexableActionableDynamicQuery.setCompanyId(companyId);

    indexableActionableDynamicQuery.setPerformActionMethod(
        (PerformActionMethod<Recognition>) recognition -> {
          try {
            Document document = getDocument(recognition);
            indexableActionableDynamicQuery.addDocuments(document);
          } catch (PortalException pe) {
            if (log.isWarnEnabled()) {
              log.warn("Unable to index recognition " + recognition.getRecognitionId(), pe);
            }
          }
        });
    indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
    indexableActionableDynamicQuery.performActions();
  }

  @Override
  protected void doReindex(Recognition object) throws Exception {
    Document document = getDocument(object);
    indexWriterHelper.updateDocument(
        getSearchEngineId(),
        object.getCompanyId(),
        document,
        isCommitImmediately());
  }

  @Override
  protected Map<String, Query> addSearchKeywords(BooleanQuery searchQuery,
      SearchContext searchContext) throws Exception {
    queryHelper.addSearchTerm(searchQuery, searchContext, "toUserName", false);
    queryHelper.addSearchTerm(searchQuery, searchContext, "subject", false);
    return super.addSearchKeywords(searchQuery, searchContext);
  }

  @Override
  public String getClassName() {
    return Recognition.class.getName();
  }

  private static final Log log = LogFactoryUtil.getLog(RecognitionIndexer.class);

  @Reference
  private IndexWriterHelper indexWriterHelper;

  @Reference
  private RecognitionLocalService recognitionLocalService;

  @Reference
  private QueryHelper queryHelper;

}
