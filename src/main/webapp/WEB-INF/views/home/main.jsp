<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath"  />
<c:if test="${not empty message}">
    <span class="success">${message}</span>
</c:if>
<script>
    var url="./articles/articles_ajax";
    var contextPath="${contextPath}";
</script>
<script src="${resPath}/assets/getData.js"></script>