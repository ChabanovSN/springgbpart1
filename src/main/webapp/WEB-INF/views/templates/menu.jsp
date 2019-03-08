<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="label_home_page" var="labelHome" />
<spring:message code="label_create_article" var="labelCreate" />
<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<div id="templatemo_menu">

    <ul>
        <li><a href="${contextPath}">${labelHome}</a></li>
        <li><a href="${contextPath}/articles/add">${labelCreate}</a></li>
    </ul>
</div> <!-- end of templatemo_menu -->