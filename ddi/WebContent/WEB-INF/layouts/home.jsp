<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

