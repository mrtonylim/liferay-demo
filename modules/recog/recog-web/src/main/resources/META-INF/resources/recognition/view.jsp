<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ include file="../init.jsp" %>

<clay:container-fluid>
  Decided to recognize your colleague?

  <aui:button-row>
    <portlet:renderURL var="selectColleagueUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
      <portlet:param name="mvcPath" value="/recognition/select-colleague.jsp"/>
    </portlet:renderURL>
    <aui:button onClick="<%=selectColleagueUrl%>" useDialog="true" value="Recognize My Colleague"/>

    <portlet:renderURL var="recognitionListUrl">
      <portlet:param name="mvcPath" value="/recognition/recognition-list.jsp"/>
      <portlet:param name="value" value="performance"/>
    </portlet:renderURL>
    <aui:button onClick="<%=recognitionListUrl%>" value="View Recognitions"/>
  </aui:button-row>
</clay:container-fluid>