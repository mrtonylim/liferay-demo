<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.VIEW_JSP" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.RECOGNITION_JSP" %>
<%@ page import="static hong.recog.constants.RecognitionPageMode.VIEW" %>
<%@ page import="hong.recog.model.Recognition" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.RECOGNITION_ACTION" %>
<%@ page import="java.util.List" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.RECOGNITION_LIST_JSP" %>
<%@ page import="static hong.recog.constants.RecognitionValue.FRIENDSHIP" %>
<%@ page import="static hong.recog.constants.RecognitionValue.PERFORMANCE" %>
<%@ include file="../init.jsp" %>

<portlet:renderURL var="viewUrl">
  <portlet:param name="mvcPath" value="<%=VIEW_JSP%>"/>
</portlet:renderURL>
<liferay-ui:header backURL="${viewUrl}" title="back"/>

<%
  String value = ParamUtil.getString(request, "value");
  List<Recognition> recognitions = (List<Recognition>) renderRequest.getAttribute("recognitions");
%>

<portlet:renderURL var="searchURL">
  <portlet:param name="mvcPath" value="<%=RECOGNITION_LIST_JSP%>"/>
  <portlet:param name="value" value="<%=value%>"/>
</portlet:renderURL>

<portlet:renderURL var="performanceRecognitionListUrl">
  <portlet:param name="mvcPath" value="<%=RECOGNITION_LIST_JSP%>"/>
  <portlet:param name="value" value="<%=PERFORMANCE%>"/>
</portlet:renderURL>

<portlet:renderURL var="friendshipRecognitionListUrl">
  <portlet:param name="mvcPath" value="<%=RECOGNITION_LIST_JSP%>"/>
  <portlet:param name="value" value="<%=FRIENDSHIP%>"/>
</portlet:renderURL>

<aui:nav cssClass="nav-tabs">
  <aui:nav-item cssClass='<%=PERFORMANCE.equals(value) ? "active" : ""%>' label="Performance" href="${performanceRecognitionListUrl}"/>
  <aui:nav-item cssClass='<%=FRIENDSHIP.equals(value) ? "active" : ""%>' label="Friendship" href="${friendshipRecognitionListUrl}"/>
</aui:nav>

<aui:form action="${searchURL}" name="fm">
  <div class="row">
    <div class="col-md-4">
      <aui:input label="" inlineLabel="left" name="keywords" placeholder="Search recognition" size="128"/>
    </div>
    <div class="col-md-2">
      <aui:button type="submit" value="search"/>
    </div>
  </div>
</aui:form>

<liferay-ui:search-container total="<%=recognitions.size()%>">
  <liferay-ui:search-container-results results="<%=recognitions%>"/>
  <liferay-ui:search-container-row className="hong.recog.model.Recognition" modelVar="recognition">
    <portlet:renderURL var="recognitionUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
      <portlet:param name="mvcPath" value='<%=RECOGNITION_JSP%>'/>
      <portlet:param name="mode" value="<%=VIEW%>"/>
      <portlet:param name="recognitionId" value="<%=String.valueOf(recognition.getRecognitionId())%>"/>
    </portlet:renderURL>
    <liferay-ui:search-container-column-jsp path="<%=RECOGNITION_ACTION%>" align="center"/>
    <liferay-ui:search-container-column-text name="Subject" property="subject"/>
    <liferay-ui:search-container-column-text name="Recognizer" property="userName"/>
    <liferay-ui:search-container-column-text name="Recognized Colleague" property="toUserName"/>
    <liferay-ui:search-container-column-text name="Date" property="createDate"/>
  </liferay-ui:search-container-row>
  <liferay-ui:search-iterator/>
</liferay-ui:search-container>
