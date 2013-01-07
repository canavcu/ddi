<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Upload Example</title>
    </head>
    <body>//modelAttribute,enctype="multipart/form-data"
        <form:form  modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Upload Fields</legend>
 
                <p>
                    <form:label for="name" path="name">Name</form:label><br/>
                    <form:input path="name"/>
                </p>
                <p>
                    <form:label for="fileData" path="fileData">File</form:label><br/>
                    <form:input path="fileData" type="file"/>
                </p>
                <p>
                    <input type="submit" />
                    ${msg}
                </p>
            </fieldset>
        </form:form>
    </body>
</html>