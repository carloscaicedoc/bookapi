<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Publish Book</h2>
	<form:form action="/books" method="POST" modelAttribute="book">
		<div>
			<form:label path="title"> Title </form:label>
			<form:input type="text" path="title" />
			<form:errors path="title" />
		</div>
		<div>
			<form:label path="description"> Description </form:label>
			<form:input type="text" path="description" />
			<form:errors path="description" />
		</div>
		<div>
			<form:label path="language"> Language </form:label>
			<form:input type="text" path="language" />
			<form:errors path="language" />
		</div>
		<div>
			<form:label path="numberOfPages"> Number of Pages </form:label>
			<form:input type="number" step="1" path="numberOfPages" />
			<form:errors path="numberOfPages" />
		</div>
		<button> Submit</button>
	</form:form>

</body>
</html>