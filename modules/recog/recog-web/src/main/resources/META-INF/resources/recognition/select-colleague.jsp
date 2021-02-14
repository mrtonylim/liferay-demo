<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.SELECT_COLLEAGUE_JSP" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.SELECT_VALUE_JSP" %>
<%@ include file="../init.jsp" %>

<%
  List<User> users = (List<User>) renderRequest.getAttribute("users");
%>

<clay:stripe message="Select a colleague to recognize."/><br/>

<clay:container-fluid>
  <portlet:renderURL var="selectColleagueUrl">
    <portlet:param name="mvcPath" value="<%=SELECT_COLLEAGUE_JSP%>"/>
  </portlet:renderURL>

  <aui:form action="${selectColleagueUrl}" name="fm">
    <div class="row">
      <div class="col-md-4">
        <aui:input label="" inlineLabel="left" name="keywords" placeholder="Search colleague" size="128"/>
      </div>
      <div class="col-md-2">
        <aui:button type="submit" value="search"/>
      </div>
    </div>
  </aui:form>

  <liferay-ui:search-container delta="10" total="<%= users.size() %>">
    <liferay-ui:search-container-results results="<%= users %>"/>
    <liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" keyProperty="userId" modelVar="user" escapedModel="<%=true%>">
      <portlet:renderURL var="selectValueUrl">
        <portlet:param name="toUserId" value="<%=String.valueOf(user.getUserId())%>"/>
        <portlet:param name="mvcPath" value="<%=SELECT_VALUE_JSP%>"/>
      </portlet:renderURL>
      <liferay-ui:search-container-column-text name="Colleague" property="fullName" href="${selectValueUrl}"/>
      <liferay-ui:search-container-column-text name="Email Address" property="emailAddress"/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
  </liferay-ui:search-container>
</clay:container-fluid>
