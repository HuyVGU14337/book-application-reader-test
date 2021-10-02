<%@ page import="com.mysql.cj.xdevapi.JsonArray" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bookapp.model.Book" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<%
    ObjectMapper objectMapper = new ObjectMapper();
    String bookListJSON = (String) request.getAttribute("bookListJSON");
    List<Book> bookList = objectMapper.readValue(bookListJSON, new TypeReference<List<Book>>() {});
    System.out.println(bookListJSON);
%>

<% for(Book book : bookList) { %>
    <%
        int code = book.getCode();
        String title = book.getBookName();
        String author = book.getAuthorName();
    %>
    <a href="<%="/get?bcode=" + code%>"> <%=title + "-" + author%></a> <br/>
<% } %>
</body>
</html>
