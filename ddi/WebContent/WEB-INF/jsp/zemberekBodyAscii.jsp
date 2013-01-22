<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div id="tabs">
<FORM METHOD="POST" >
       
    <ul>
        <li><a href="#tabs-1">Zemberek ASCII Demo</a></li>
        <li><a href="#tabs-2">Zemberek ASCII Dosya</a></li>
    </ul>
    <div id="tabs-1" style="min-height:250px;min-width:600px;">
         <textarea  NAME="text" style="width: 100%; height:100%; min-height:250px;min-width:600px;" cols="40" rows="10"></textarea>
            <BR>
            <div><INPUT TYPE="SUBMIT" value="Çözümle" ></div>
            <div style="border: 0 solid; ">
            <textarea  NAME="text2" style="width: 100%; height: 100%; min-height:250px; min-width:400px;" >${message}</TEXTAREA></div>
            <h2>çözümlemek --> cozumlemek</h2>
            </div>
</FORM>
<form:form action="zemascii/out" modelAttribute="uploadItem" METHOD="POST" enctype="multipart/form-data" accept-charset="UTF-8">

    <div id="tabs-2" style="min-height:250px;min-width:600px;">
		<label for="file">Dosya :</label>
		
		<form:input path="fileData" type="file" size="80" /> <br />
		<form:errors path="fileData" cssClass="error" />
		<input type="submit" value="Çözümle"/>
		<p>Note: The file encoding format must be UTF-8. </p>		
       </div>
       
    
	</form:form>
</div>