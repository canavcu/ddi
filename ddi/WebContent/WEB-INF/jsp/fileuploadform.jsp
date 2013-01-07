<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
 
<body>
	<h2>Spring MVC file upload example</h2>
 
	<form method="get" ACTION="fileuploadform.html" enctype="multipart/form-data">
 
		
 
		Please select a file to upload : <input type="file" name="file" />
		<input type="submit" value="upload" />
		<span>
		</span> ${msg}
 
	</form>
 
</body>
</html>