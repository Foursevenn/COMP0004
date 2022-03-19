<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Item</title>
</head>
<body>
<form method="POST" action="/deleteItem.html">
    <p>ID refers to the unique number of a noteboook/list/book/video type. It's in < ></p>
    <p>index refers to the index starting from 0 of an item in a list. It's in ( ):</p>
    <div>
        <label for="listId">List ID: </label>
        <input type="text" name="listId" id="listId">
    </div>
    <div>
        <label for="itemIndex">Item Index: </label>
        <input type="text" name="itemIndex" id="itemIndex">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>

