<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Book</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <p>
        <h2>0)<%= request.getAttribute("title") %></h2>
    </p>
    <p>
        1)
        <img src=<%= "data/"+request.getAttribute("cover") %>>
    </p>
    <p>
        2)
        <%= request.getAttribute("author") %>
    </p>
    <p>
        3)
        <%= request.getAttribute("year") %>
    </p>
    <p>
        4)
        <a href=<%= request.getAttribute("link")%>>Purchase Link</a>
    </p>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
