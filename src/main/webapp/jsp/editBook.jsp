<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/authors/add" var="addAuthorUrl" />
<spring:url value="/books/add" var="addBookUrl" />
<spring:url value="/books" var="booksUrl" />
<spring:url value="/authors" var="authorsUrl" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav>
    <button onclick="location.href='${booksUrl}'">Books</button>
    <button onclick="location.href='${authorsUrl}'">Authors</button>
    <button onclick="location.href='${addBookUrl}'">Add book</button>
    <button onclick="location.href='${addAuthorUrl}'">Add author</button>
</nav>
<h1>Edit book: </h1>
<form method="POST">
    <label for="title">Title: </label>
    <input type="text" id="title" name="title" required value="${book.title}"/>
    <label for="authorId">AuthorID: </label>
    <input type="number" id="authorId" name="authorId" required value="${book.author.authorId}"/>
    <label for="publishingYear">Publishing year: </label>
    <input type="number" id="publishingYear" name="publishingYear" required value="${book.publishingYear}"/>
    <label for="genre">Genre: </label>
    <input type="text" id="genre" name="genre" required value="${book.genre}"/>
    <label for="description">Description: </label>
    <textarea id="description" name="description" required >${book.description}</textarea>
    <button type="submit">Submit</button>
</form>
</body>
</html>
