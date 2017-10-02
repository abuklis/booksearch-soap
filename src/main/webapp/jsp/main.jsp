<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/authors/add" var="addAuthorUrl" />
<spring:url value="/books/add" var="addBookUrl" />
<spring:url value="/books" var="booksUrl" />
<spring:url value="/authors" var="authorsUrl" />
<html>
<head>
    <title>Main</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <nav>
        <button onclick="location.href='${booksUrl}'">Books</button>
        <button onclick="location.href='${authorsUrl}'">Authors</button>
        <button onclick="location.href='${addBookUrl}'">Add book</button>
        <button onclick="location.href='${addAuthorUrl}'">Add author</button>
    </nav>
    <c:if test="${not empty books}">
        <h2>Books: </h2>
        <ul>
        <c:forEach items="${books}" var="book">
            <li>${book.title} - ${book.author.fullName} , ${book.publishingYear}
                <spring:url value="/books/${book.bookId}" var="bookUrl" />
                <button onclick="location.href='${bookUrl}'">View</button>
            </li>
        </c:forEach>
        </ul>
    </c:if>

    <c:if test="${not empty authors}">
        <h2>Authors: </h2>
        <ul>
            <c:forEach items="${authors}" var="author">
                <li>${author.authorId} - ${author.fullName} , ${author.birthCountry}
                    <spring:url value="/authors/${author.authorId}" var="authorUrl" />
                    <button onclick="location.href='${authorUrl}'">View</button>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
