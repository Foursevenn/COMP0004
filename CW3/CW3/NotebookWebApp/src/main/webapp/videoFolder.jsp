<%@ page import="uk.ac.ucl.model.VideoFolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Video Folder</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Videos:</h2>
    <ul>
        <%
            VideoFolder videoFolder = (VideoFolder) request.getAttribute("videoFolder");
            for (int i = 0; i < videoFolder.getSize(); i++) {
                String title = videoFolder.get(i).getTitle();
        %>
        <p><<%= videoFolder.get(i).getId() %>></p>
        <li>
            <a href="video.html?id=<%= videoFolder.get(i).getId() %>" ><%= title %>></a>
        </li>
        <% } %>
    </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

