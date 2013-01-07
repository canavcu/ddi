<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./js/jquery.js" type="text/javascript"></script>
<script src="./js/jquery.treeview.js" type="text/javascript"></script>
<script src="./js/jquery.cookie.js" type="text/javascript"></script>
<script src="./js/demo.js" type="text/javascript"></script>
<link rel="stylesheet" href="./css/jquery.treeview.css" />
<link rel="stylesheet" href="./css/screen.css" />
<link rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
function tabselect2(){
	$( "#tabs" ).tabs( "option", "selected", 1 );
}
</script>
<script>
function myFunction()
{
	var prmstr = window.location.search.substr(1);
	var prmarr = prmstr.split ("&");
	var params = {};

	for ( var i = 0; i < prmarr.length; i++) {
	    var tmparr = prmarr[i].split("=");
	    params[tmparr[0]] = tmparr[1];
	}
	if(params.submit == "Ekle"){
		tabselect2();
	} 

}
</script>
<script type="text/javascript">
function insertParam(key, value)
{
    key = escape(key); value = escape(value);

    var kvp = document.location.search.substr(1).split('&');

    var i=kvp.length; var x; while(i--) 
    {
    	x = kvp[i].split('=');

    	if (x[0]==key)
    	{
    		x[1] = value;
    		kvp[i] = x.join('=');
    		break;
    	}
    }

    if(i<0) {kvp[kvp.length] = [key,value].join('=');}

    //this will reload the page, it's likely better to store this until finished
    document.location.search = kvp.join('&'); 
}
</script>
<script type="text/javascript">
function tabselect3(){
	$('#element').attr( 'title', 'foo' );
}
</script>
    <script>
    $(function() {
        $( "#tabs" ).tabs();
    });
    </script>
<script type="text/javascript">
			$(function() {
				$("#tree").treeview({
					collapsed: true,
					animated: "medium",
					control:"#sidetreecontrol",
					persist: "location"
				});
			})
		</script>
		<title></title>
</head>
<body onload="myFunction()">
<div id="main">
	<div id="menu1">
		
		<div id="main_left">
		<a href="./index.html">Ana Sayfa </a>
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="main_right">
		<tiles:insertAttribute name="body" />
		</div>
	</div>
</div>
</body>
</html>
