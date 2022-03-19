<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
<form method="POST" action="/addItem.html">
    <p>ID refers to the unique number of a noteboook/list/book/video type. It's in < ></p>
    <p>index refers to the index starting from 0 of an item in a list. It's in ( ):</p>
    <p>Notice that Book and Video's item cannot be added because their items are fixed.</p>
    <div>
        <label for="listId">List ID: </label>
        <input type="text" name="listId" id="listId">
    </div>
    <p>Please select the added item type:</p>
    <div>
        <input type="radio" id="choice1"
               name="newType" value="object">
        <label for="choice1">list, book or video</label>

        <input type="radio" id="choice2"
               name="newType" value="other">
        <label for="choice2">Other</label>
    </div>
    <p>Please enter an existing ID if it's the first type:</p>
    <div>
        <label for="newValue">New Item Value: </label>
        <input type="text" name="newString" id="newValue">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
