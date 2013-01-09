<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div id="tabs">
<FORM METHOD="POST" enctype="multipart/form-data;charset=UTF-8">
       
    <ul>
        <li><a href="#tabs-1">Zemberek ASCII Demo</a></li>
        
    </ul>
    <div id="tabs-1" style="min-height:250px;min-width:600px;">
         <textarea  NAME="text" style="width: 100%; height:100%; min-height:250px;min-width:600px;" cols="40" rows="10"></textarea>
            <BR>
            <div><INPUT TYPE="SUBMIT" value="Çözümle" ></div>
            <div style="border: 0 solid; ">
            <textarea  NAME="text2" style="width: 100%; height: 100%; min-height:250px; min-width:400px;" >${message}</TEXTAREA></div></div>
   </FORM>
  
</div>