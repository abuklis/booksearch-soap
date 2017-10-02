<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/authors/${author.authorId}/edit" var="editAuthorUrl"/>
<spring:url value="/authors/${author.authorId}/delete" var="deleteAuthorUrl"/>
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
${author.authorId} - ${author.fullName} , ${author.birthCountry}

<button onclick="location.href='${editAuthorUrl}'">Edit</button>

<button onclick="location.href='${deleteAuthorUrl}'">Delete</button>
</body>
</html>
