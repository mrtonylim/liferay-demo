<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.RECOGNITION_JSP" %>
<%@ page import="static hong.recog.constants.RecognitionPageMode.ADD" %>
<%@ page import="static hong.recog.constants.RecognitionValue.PERFORMANCE" %>
<%@ page import="static hong.recog.constants.RecognitionValue.FRIENDSHIP" %>
<%@include file="../init.jsp" %>

<%
  User toUser = (User) renderRequest.getAttribute("toUser");
  List<String> values = Arrays.asList(PERFORMANCE, FRIENDSHIP);
%>

<clay:stripe message='<%="Select a value for recognizing your colleague: " + (toUser.getFullName())%>'/>

<clay:container-fluid>
  <liferay-ui:search-container total='<%=values.size()%>'>
    <liferay-ui:search-container-results results="<%=values%>"/>
    <liferay-ui:search-container-row className="java.lang.String" modelVar="value" escapedModel="<%=true%>">
      <portlet:renderURL var="addRecognitionUrl">
        <portlet:param name="mvcPath" value='<%=RECOGNITION_JSP%>'/>
        <portlet:param name="mode" value="<%=ADD%>"/>
        <portlet:param name="toUserId" value='<%=String.valueOf(toUser.getUserId())%>'/>
        <portlet:param name="value" value="${value}"/>
      </portlet:renderURL>
      <liferay-ui:search-container-column-text value="<%=value%>" href='${addRecognitionUrl}'/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
  </liferay-ui:search-container>
</clay:container-fluid>
