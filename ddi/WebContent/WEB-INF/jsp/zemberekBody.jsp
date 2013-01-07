<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="tabs">
<FORM action="zemberek/demo" METHOD="POST" >
       
    <ul>
        <li><a href="#tabs-1">Zemberek Demo</a></li>
        <li><a href="#tabs-2">Zemberek Dosya</a></li>
    </ul>
    <div id="tabs-1" style="min-height:250px;min-width:600px;">
         <TEXTAREA  NAME="text" style="width: 100%; height:100%; min-height:250px;min-width:600px;"cols="40" rows="10"></TEXTAREA>
            <BR>
            <div><INPUT TYPE="SUBMIT" value="Çözümle" ></div>
            <div style="border: 0 solid; ">
            <textarea  NAME="text2" style="width: 100%; height: 100%; min-height:250px; min-width:400px;" >${message}</TEXTAREA></div></div>
   </FORM>
   <form:form action="zemberek/out" modelAttribute="uploadItem" METHOD="POST" enctype="multipart/form-data">
   <fieldset>
    <div id="tabs-2" style="min-height:250px;min-width:600px;">
		<label for="file">Dosya :</label>
		
		<form:input path="fileData" type="file"  />
		<input type="submit" />
		
       </div>
       </fieldset>
</form:form>
</div>
