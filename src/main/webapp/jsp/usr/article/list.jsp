<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ll.exam.dto.ArticleDto" %>
<%@ page import="java.util.List" %>

<%
List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>

<h1> 게시물 리스트 </h1>

<ul>
<% for ( ArticleDto article : articles ) { %>
<li><%=article.getId()%>. <%=article.getTitle()%></li>
<% } %>
</ul>