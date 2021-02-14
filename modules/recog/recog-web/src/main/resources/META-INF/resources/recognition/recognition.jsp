<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="static hong.recog.constants.RecognitionPageMode.ADD" %>
<%@ page import="static hong.recog.constants.RecognitionPageMode.DONE" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="hong.recog.model.FriendshipRecognition" %>
<%@ page import="hong.recog.model.PerformanceRecognition" %>
<%@ page import="hong.recog.model.Recognition" %>
<%@ page import="static hong.recog.constants.RecognitionPortletPath.VIEW_JSP" %>
<%@ page import="static hong.recog.constants.RecognitionPageMode.VIEW" %>
<%@ page import="java.util.Optional" %>
<%@ page import="static hong.recog.constants.RecognitionValue.FRIENDSHIP" %>
<%@ page import="static hong.recog.constants.RecognitionValue.PERFORMANCE" %>
<%@ include file="../init.jsp" %>

<%
  String mode = ParamUtil.getString(renderRequest, "mode");
  String value = "";
  long toUserId = 0;
  String toUserName = "";
  String actionUrl = "";

  Optional<Recognition> recognition = Optional.empty();
  Optional<PerformanceRecognition> performanceRecognition = Optional.empty();
  Optional<FriendshipRecognition> friendshipRecognition = Optional.empty();
%>

<c:choose>
  <c:when test="<%=ADD.equals(mode)%>">
    <%
      value = ParamUtil.getString(renderRequest, "value");
      User toUser = (User) renderRequest.getAttribute("toUser");
      toUserId = toUser.getUserId();
      toUserName = toUser.getFullName();
      if (PERFORMANCE.equals(value)) {
        actionUrl = "addPerformanceRecognition";
      } else if (FRIENDSHIP.equals(value)) {
        actionUrl = "addFriendshipRecognition";
      }
    %>
    <clay:stripe message="Input performance details for recognition."/>
  </c:when>
  <c:otherwise>
    <%
      recognition = Optional.of((Recognition) renderRequest.getAttribute("recognition"));
      value = recognition.get().getValue();
      toUserName = recognition.get().getToUserName();
      if (PERFORMANCE.equals(value)) {
        performanceRecognition = Optional.of((PerformanceRecognition) renderRequest.getAttribute("performanceRecognition"));
      } else if (FRIENDSHIP.equals(value)) {
        friendshipRecognition = Optional.of((FriendshipRecognition) renderRequest.getAttribute("friendshipRecognition"));
      }
    %>
    <c:if test="<%=DONE.equals(mode)%>">
      <%
        String managerName = (String) renderRequest.getAttribute("managerName");
        String message = String.format("Hooray! You have recognized your colleague - %s in %s. He/She ",
            recognition.get().getToUserName(), recognition.get().getValue());
        if (Validator.isNotNull(managerName)) {
          message += String.format("and his/her manager - %s have ", managerName);
        } else {
          message += "has ";
        }
        message += "been noticed via email.";
      %>
      <clay:stripe
          message="<%=message%>"/>
    </c:if>
  </c:otherwise>
</c:choose>

<c:if test='<%=ParamUtil.getInteger(renderRequest, "back", 0) == 1%>'>
  <portlet:renderURL var="viewUrl">
    <portlet:param name="mvcPath" value="<%=VIEW_JSP%>"/>
  </portlet:renderURL>
  <liferay-ui:header backURL="${viewUrl}" title="back"/>
</c:if>

<portlet:actionURL name="<%=actionUrl%>" var="addRecognitionUrl"/>

<br/>
<clay:container-fluid>
  <aui:form action='<%=ADD.equals(mode) ? addRecognitionUrl : ""%>' name="fm">
    <aui:fieldset>
      <c:if test="<%=VIEW.equals(mode)%>">
        <aui:input name="userName" label="Recognizer Name" value="<%=recognition.get().getUserName()%>" disabled="true"/>
      </c:if>
      <aui:input name="toUserId" type="hidden" value="<%=toUserId%>"/>
      <aui:input name="toUserName" label="Colleague's Name" value="<%=toUserName%>" disabled="true"/>
      <aui:input name="value" type="hidden" value="<%=value%>"/>
      <aui:input name="value" value="<%=value%>" disabled="true"/>
      <aui:input name="subject"
                 type="text"
                 value='<%=recognition.map(Recognition::getSubject).orElse("")%>'
                 disabled="<%=recognition.isPresent()%>"/>
      <c:if test='<%=PERFORMANCE.equals(value)%>'>
        <aui:input name="detail1"
                   type="textarea"
                   value='<%=performanceRecognition.map(PerformanceRecognition::getDetail1).orElse("")%>'
                   disabled="<%=performanceRecognition.isPresent()%>"/>
        <aui:input name="detail2"
                   type="textarea"
                   value='<%=performanceRecognition.map(PerformanceRecognition::getDetail2).orElse("")%>'
                   disabled="<%=performanceRecognition.isPresent()%>"/>
      </c:if>
      <c:if test='<%=FRIENDSHIP.equals(value)%>'>
        <aui:input name="detailA"
                   type="textarea"
                   value='<%=friendshipRecognition.map(FriendshipRecognition::getDetailA).orElse("")%>'
                   disabled="<%=friendshipRecognition.isPresent()%>"/>
        <aui:input name="detailB"
                   type="textarea"
                   value='<%=friendshipRecognition.map(FriendshipRecognition::getDetailB).orElse("")%>'
                   disabled="<%=friendshipRecognition.isPresent()%>"/>
        <aui:input name="detailC"
                   type="textarea"
                   value='<%=friendshipRecognition.map(FriendshipRecognition::getDetailC).orElse("")%>'
                   disabled="<%=friendshipRecognition.isPresent()%>"/>
      </c:if>
    </aui:fieldset>
    <c:if test="<%=ADD.equals(mode)%>">
      <aui:button-row>
        <aui:button type="submit"/>
      </aui:button-row>
    </c:if>
  </aui:form>
</clay:container-fluid>
