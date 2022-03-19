<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <form method="POST" action="/edit.html">
        <p>ID refers to the unique number of a noteboook/list/book/video type. It's in < ></p>
        <p>index refers to the index starting from 0 of an item in a list. It's in ( ):</p>
        <div>
            <label for="listId">List ID: </label>
            <input type="text" name="listId" id="listId">
        </div>
        <div>
            <label for="oldIndex">Old Item Index: </label>
            <input type="text" name="oldIndex" id="oldIndex">
        </div>
        <p>Please select the new item type:</p>
        <div>
            <input type="radio" id="choice1"
                   name="newType" value="object">
            <label for="choice1">List, book or video</label>

            <input type="radio" id="choice2"
                   name="newType" value="other">
            <label for="choice2">Other</label>
        </div>
        <p>Please enter an ID if it's the first type:</p>
        <div>
            <label for="newValue">Or New Item Value: </label>
            <input type="text" name="newString" id="newValue">
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>
    </form>
</body>
</html>
