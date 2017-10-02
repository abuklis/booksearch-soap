<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/books/${book.bookId}/edit" var="editBookUrl" />
<spring:url value="/books/${book.bookId}/delete" var="deleteBookUrl" />
<spring:url value="/authors/add" var="addAuthorUrl" />
<spring:url value="/books/add" var="addBookUrl" />
<spring:url value="/books" var="booksUrl" />
<spring:url value="/authors" var="authorsUrl"/>
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
<div>
    <h2>${book.title} - ${book.author.fullName}, ${book.publishingYear}</h2>
    <div>${book.description}</div>
</div>

<button onclick="location.href='${editBookUrl}'">Edit</button>
<button onclick="location.href='${deleteBookUrl}'">Delete</button>
</body>
</html>
