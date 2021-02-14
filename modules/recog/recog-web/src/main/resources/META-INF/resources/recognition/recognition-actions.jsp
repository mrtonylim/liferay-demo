<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="hong.recog.model.Recognition" %>
<%@ page import="static hong.recog.constants.RecognitionPageMode.VIEW" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.RECOGNITION_JSP" %>
<%@include file="../init.jsp" %>

<%
  ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
  Recognition recognition = (Recognition) row.getObject();
%>


<liferay-ui:icon-menu>
  <portlet:renderURL var="recognitionUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="mvcPath" value='<%=RECOGNITION_JSP%>'/>
    <portlet:param name="mode" value="<%=VIEW%>"/>
    <portlet:param name="recognitionId" value="<%=String.valueOf(recognition.getRecognitionId())%>"/>
  </portlet:renderURL>
  <aui:button onClick="${recognitionUrl}" value="Recognition Details" useDialog="true"/>
</liferay-ui:icon-menu>
