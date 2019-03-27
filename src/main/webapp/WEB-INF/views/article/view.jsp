<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:message code="label_date" var="labelDate" />
<spring:message code="label_author" var="labelAuthor" />
<spring:message code="label_category" var="labelCategory" />
<spring:message code="label_edit" var="labelEdit" />
<spring:message code="label_delete" var="labelDelete" />

<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath"  />
<c:if test="${not empty article}">


    <h2><a class='article__title' href='' ></a>${article.title}</h2>
    <strong>${labelDate}: </span></strong><span class='article__date'><fmt:formatDate pattern="yyyy-MM-dd"
                                                                                      value="${article.publishedDate}" /></span> | <strong>${labelAuthor}: </strong> <span class='article__author'>${article.author.firstname}</span>
    <div class="cleaner"></div>
    <p><div class='article__content view'>${article.content}</div>
    <div class='cleaner'></div>
    <p><div class='category view'><b>${labelCategory}:</b> <span>${article.category.name}</span></div>
    <sec:authorize access="hasAuthority('admin')"><p><p><a href='${contextPath}/articles/${article.id}/edit' class='edit'>${labelEdit}</a><a href='${contextPath}/articles/${article.id}/delete' class='delete'>${labelDelete}</a></sec:authorize>
    <div class='cleanerEnd'></div>
</c:if>