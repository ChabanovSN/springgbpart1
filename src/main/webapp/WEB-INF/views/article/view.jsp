<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="label_date" var="labelDate" />
<spring:message code="label_author" var="labelAuthor" />
<spring:message code="label_category" var="labelCategory" />

<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath"  />
<c:if test="${not empty article}">


    <h2><a class='article__title' href='' ></a>${article.name}</h2>
    <strong>${labelDate}: </span></strong><span class='article__date'><fmt:formatDate pattern="yyyy-MM-dd"
                                                                                      value="${article.publishedDate}" /></span> | <strong>${labelAuthor}: </strong> <span class='article__author'>${article.company.name}</span>
    <div class="cleaner"></div>
    <p><div class='article__content view'>${article.content}</div>
    <div class='cleaner'></div>
    <p><div class='category view'>${labelCategory}: <span>${article.categories.name}</span></div>
</c:if>