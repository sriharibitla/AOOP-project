<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Books</title>
    <link rel="stylesheet" type="text/css" href="style.css"> <!-- Link to your CSS file -->
</head>
<body>
    <h1>Library Management System</h1>
    <form action="searchBook" method="get">
        <label for="searchTerm">Enter Book Title or Author:</label>
        <input type="text" id="searchTerm" name="searchTerm" required>
        <input type="submit" value="Search">
    </form>
</body>
</html>
