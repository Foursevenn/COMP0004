<%@ page import="uk.ac.ucl.model.MyList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uk.ac.ucl.model.Book" %>
<%@ page import="uk.ac.ucl.model.Video" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Search result</title>
  <%
    ArrayList<Object> result= (ArrayList<Object>) request.getAttribute("result");
  %>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <ul>
    <%
      for (Object item : result) {
        if (item.getClass() == String.class) {
          String s = item.toString();
          if (s.endsWith(".jpg") || s.endsWith(".jpeg") || s.endsWith(".png")) {
    %>
    <li>
      <img src=<%= "data/"+s %>>
    </li>
    <%
    } else {
    %>
    <li>
      <p><%= s %>
      </p>
    </li>
    <%
      }
    } else if (item.getClass() == Book.class) {
      Book book = (Book) item;
    %>
    <li>
      <p><<%= book.getId() %>></p>
      <a href="book.html?id=<%= book.getId() %>"><%= book.getTitle() %>
      </a>
    </li>
    <% } else if (item.getClass() == Video.class) {
      Video video = (Video) item;
    %>
    <li>
      <p><<%= video.getId() %>></p>
      <a href="video.html?id=<%= video.getId() %>"><%= video.getTitle() %>
      </a>
    </li>
    <% } else if (item.getClass() == MyList.class) {
      MyList myList1 = (MyList) item;
    %>
    <li>
      <p><<%= myList1.getId() %>></p>
      <a href="list.html?id=<%= myList1.getId() %>"><%= myList1.getTitle() %>
      </a>
    </li>
    <%
        }
      }
    %>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>