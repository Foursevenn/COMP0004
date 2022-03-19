<%@ page import="uk.ac.ucl.model.ListFolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>List Folder</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Notebooks:</h2>
    <ul>
        <%
            ListFolder listFolder = (ListFolder) request.getAttribute("listFolder");
            for (int i = 0; i < listFolder.getSize(); i++) {
                String name = listFolder.get(i).getTitle();
        %>
        <li>
            <p><<%= listFolder.get(i).getId() %>></p>
            <a href="list.html?id=<%= listFolder.get(i).getId() %>" ><%= name %>></a>
        </li>
        <% } %>
    </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

