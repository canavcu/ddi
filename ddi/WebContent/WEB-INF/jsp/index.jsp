<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="tr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="./js/jquery.js" type="text/javascript"></script>
<script src="./js/jquery.treeview.js" type="text/javascript"></script>
<script src="./js/jquery.cookie.js" type="text/javascript"></script>
<script src="./js/demo.js" type="text/javascript"></script>
<link rel="stylesheet" href="./css/jquery.treeview.css" />
<link rel="stylesheet" href="./css/screen.css" />
<link rel="stylesheet" href="./css/main.css" />
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
</head>
<body>
	
	<tiles:insertDefinition name="ddiportal.homepage"/>

</body>
</html>