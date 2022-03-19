<%@ page import="uk.ac.ucl.model.BookFolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Book Folder</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Books:</h2>
    <ul>
        <%
            BookFolder bookFolder = (BookFolder) request.getAttribute("bookFolder");
            for (int i = 0; i < bookFolder.getSize(); i++) {
                String cover = bookFolder.get(i).getCover();
        %>
        <li>
            <p><<%= bookFolder.get(i).getId() %>></p>
            <a href="book.html?id=<%= bookFolder.get(i).getId() %>" >
                <img alt="Something went wrong" src=<%= "data/"+cover %>
                     width=300" height="400">
            </a>
        </li>
        <% } %>
    </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
