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
<h1>Edit author: </h1>
<form method="POST">
    <input type="hidden" name="command" value="add_book"/>
    <label for="fullName">Full name: </label>
    <input type="text" id="fullName" name="fullName" required value="${author.fullName}"/>
    <label for="birthYear">Birth year: </label>
    <input type="number" id="birthYear" name="birthYear" required value="${author.birthYear}"/>
    <label for="birthCountry">Birth country: </label>
    <input type="text" id="birthCountry" name="birthCountry" required value="${author.birthCountry}"/>
    <label for="biography">Biography: </label>
    <textarea id="biography" name="biography" required>${author.biography}</textarea>
    <button type="submit">Submit</button>
</form>
</body>
</html>
