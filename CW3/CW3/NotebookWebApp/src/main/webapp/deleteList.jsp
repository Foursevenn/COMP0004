<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete List</title>
</head>
<body>
<form method="POST" action="/deleteList.html">
    <p>ID refers to the unique number of a noteboook/list/book/video type. It's in < ></p>
    <p>index refers to the index starting from 0 of an item in a list. It's in ( ):</p>
    <div>
        <label for="listId">List ID: </label>
        <input type="text" name="listId" id="listId">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>

