<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="label_date" var="labelDate" />
<spring:message code="label_author" var="labelAuthor" />
<spring:message code="label_category" var="labelCategory" />
<spring:message code="label_button_read" var="labelRead" />

<script>
    var number=4;
    //порядок сортировки
    var order="DESC";
    //поле для сортировки
    var orderBy="publishedDate";
    //счетчик страниц(блоков)
    var pageCounter=0;
    var articleBody="<div class='post_section'>"+"<h2><a class='article__title' href='' ></a></h2>"+"<strong>${labelDate}: </span></strong><span class='article__date'></span>|<strong>${labelAuthor}: </strong><span class='article__author'></span>"
        +"<p><div class='article__content'></div>"
        +"<div class='cleaner'></div>"
        +"<p><div class='category'>${labelCategory}: <span class='article__category'></span></div> <div class='button float_r'><a href=' ' class='more'>${labelRead}</a></div>"+"<div class='cleaner'></div>"
        +"</div><div class='cleaner_h40'></div>";
</script>