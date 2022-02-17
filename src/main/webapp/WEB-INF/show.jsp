<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>BOOK</h2>
	<h3>Title: ${book.title}</h3>
	<p>Description: ${book.description}</p>
	<p>Language: ${book.language}</p>
	<p>Number of Pages: ${book.numberOfPages}</p>
	
	<a href="/books">Go Back</a>

</body>
</html>