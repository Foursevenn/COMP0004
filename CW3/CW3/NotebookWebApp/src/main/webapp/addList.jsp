<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add List</title>
</head>
<body>
<form method="POST" action="/addList.html">
    <p>ID refers to the unique number of a noteboook/list/book/video type. It's in < ></p>
    <p>index refers to the index starting from 0 of an item in a list. It's in ( ):</p>
    <p>Please select the added list type:</p>
    <div>
        <input type="radio" id="choice1"
               name="newType" value="notebook">
        <label for="choice1">Notebook</label>

        <input type="radio" id="choice2"
               name="newType" value="list">
        <label for="choice2">List</label>

        <input type="radio" id="choice3"
               name="newType" value="book">
        <label for="choice3">Book</label>

        <input type="radio" id="choice4"
               name="newType" value="video">
        <label for="choice4">Video</label>
    </div>
    <p>e.g. "(List)  Alfred Adler,Adler.jpg,14,15,16"</p>
    <p>     "(Book)  title, author, year, cover, link"</p>
    <p>     "(Video) title, author, platform, year, link"</p>
    <p>Please enter added list items separated by comma in the form of "listName,item1,item2...":</p>
    <div>
        <label for="newValue">New List Items: </label>
        <input type="text" name="newString" id="newValue">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>

