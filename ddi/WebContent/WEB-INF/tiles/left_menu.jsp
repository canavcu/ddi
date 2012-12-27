<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="sidetree">
	<div class="treeheader">&nbsp;</div>
	<div id="sidetreecontrol"></div>
	<ul id="tree">
		<li class="expandable"><a href="#"><strong>Metin
					Normalizasyon</strong></a>
			<ul>
				<li><a href="./jsp/Ascii.jsp">Asciification</a></li>
				<li><a href="./jsp/Deascii.jsp">Deasciification</a></li>
			</ul></li>
		<li class="expandable"><a href="#"><strong>Biçimbilimsel
					Çözümleyiciler</strong></a>
			<ul>
				<li><a href="./jsp/morfKO.jsp">Kemal O. M.Ç.</a></li>
				<li><a href="./zemberek.html">Zemberek</a></li>
				<li><a href="/jsp/morfHS.jsp">Haşim S. M.Ç.</a></li>
			</ul></li>

		<li class="last"><a href="#"><strong>Biçimbilimsel
					Belirsizlik Gidericiler</strong></a>
			<ul>
				<li><a href="./jsp/disbgD.jsp">Deniz</a></li>
			</ul></li>
	</ul>
</div>