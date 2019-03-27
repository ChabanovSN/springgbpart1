<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="label_create_article" var="labelCreate" />
<spring:message code="label_category" var="labelCategory" />
<spring:message code="label_choice_category" var="labelChCategory" />
<spring:message code="label_title" var="labelTitle" />
<spring:message code="label_author_info" var="labelAuthorInfo" />
<spring:message code="label_last_name" var="labelLastName" />
<spring:message code="label_button_publish" var="labelPublish" />

<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath"  />
<c:if test="${not empty message}">
    <span class="error">${message}</span>
</c:if>
<div class="post_section">
    <form:form modelAttribute="article" class="add_article_form" method="POST" action="${reff}">
        <h2 class="message">${labelCreate}</h2>

        <strong class="add_category">${labelCategory}*</strong>
        <select id="categoryId" name="categoryId" class="cd-select">
            <c:if test="${not empty categories}">
                <option value="0" selected>${labelChCategory}</option>
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </c:if>
        </select>
        <p><form:label path="name" class="add_title">${labelTitle}*</form:label><form:input type="text" path="name" class="add_title_input"  />
        <p><form:errors path="name" cssClass="error" />
        <p style="padding-top:50px;">
                <form:textarea path="content" id="content"  class="contentarea"></form:textarea>
                <form:errors path="content" cssClass="error" />
        <div class="author_add">
            <span class="author_info_title">${labelAuthorInfo}*</span>

            <form:input path="company.name" type="text" placeholder="${labelLastName}" name="add_author_lastname" />
            <form:errors path="company.name" cssClass="error" />
        </div>

        <input type="submit"  class="button_sub" value="${labelPublish}" />
    </form:form>
</div>

<script src="${resPath}/assets/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        CKEDITOR.replace('content');
        CKEDITOR.config.width="100%";
        CKEDITOR.config.height=600;
    });
</script>