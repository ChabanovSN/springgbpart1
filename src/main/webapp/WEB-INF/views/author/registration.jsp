<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="label_author_reg" var="authorReg" />
<spring:message code="label_login" var="labelLogin" />
<spring:message code="label_password" var="labelPass" />
<spring:message code="label_email" var="labelAuthorEmail" />
<spring:message code="label_first_name" var="labelFirstName" />
<spring:message code="label_last_name" var="labelLastName" />
<spring:message code="label_button_reg" var="labelBreg" />
<c:set value="${pageContext.request.contextPath}" var="contextPath" />

  <section class="container">
    <div class="login">
      <h1>${authorReg}</h1>
      <c:if test="${not empty message}">
        <span class="error">${message}</span>
        <p/>
      </c:if>
      <form:form modelAttribute="author" action="${contextPath}/registration" method='POST'>
      
        <p>${labelFirstName}: <form:input  path="firstname"  value="" placeholder="${labelFirstName}" /></p>
                <form:errors path="firstname" cssClass="error" />
        <p>${labelLastName}: <form:input  path="lastname"  value="" placeholder="${labelLastName}" /></p>
                    <form:errors path="lastname" cssClass="error" />
        <p>${labelAuthorEmail}: <form:input  path="email"  value="" placeholder="${labelAuthorEmail}" /></p>
                     <form:errors path="email" cssClass="error" />
        <p>${labelLogin}: <form:input path="login"  type="text"  placeholder="${labelLogin}" /></p>
                  <form:errors path="login" cssClass="error" />
        <p>${labelPass}: <form:input path="password" type="password" placeholder="${labelPass}" /></p>
		           <form:errors path="password" cssClass="error" />
        <p class="submit"><input type="submit" name="commit" value="${labelBreg}" /></p>
      </form:form>
    </div>
  </section>