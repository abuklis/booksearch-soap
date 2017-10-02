<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/authors/add" var="addAuthorUrl" />
<spring:url value="/books/add" var="addBookUrl" />
<spring:url value="/books" var="booksUrl" />
<spring:url value="/authors" var="authorsUrl" />
<html>
<head>
    <title>Add book</title>
</head>
<body>
<nav>
    <button onclick="location.href='${booksUrl}'">Books</button>
    <button onclick="location.href='${authorsUrl}'">Authors</button>
    <button onclick="location.href='${addBookUrl}'">Add book</button>
    <button onclick="location.href='${addAuthorUrl}'">Add author</button>
</nav>
<h1>Adding book: </h1>
<form method="POST">
    <input type="hidden" name="command" value="add_book"/>
    <label for="title">Title: </label>
    <input type="text" id="title" name="title" required/>
    <label for="authorId">AuthorID: </label>
    <input type="number" id="authorId" name="authorId" required/>
    <label for="publishingYear">Publishing year: </label>
    <input type="number" id="publishingYear" name="publishingYear" required/>
    <label for="genre">Genre: </label>
    <input type="text" id="genre" name="genre" required/>
    <label for="description">Description: </label>
    <textarea id="description" name="description" required></textarea>
    <button type="submit">Submit</button>
</form>
</body>
</html>
