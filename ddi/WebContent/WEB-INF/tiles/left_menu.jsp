<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="sidetree">
	<div class="treeheader">&nbsp;</div>
	<div id="sidetreecontrol"></div>
	<ul id="tree">
		<li class="expandable"><a href="#"><strong>Metin Normalizasyon</strong></a>
			<ul>
				<li class="expandable"><a href="#">Asciification</a>
					<ul>
						<li>
							<a href="/ddi/zemascii">Zemberek</a>
						</li>
					</ul>
				</li>
				<li class="expandable"><a href="#">Deasciification</a>
					<ul>
						<li>
							<a href="/ddi/zemdeascii">Zemberek</a>
						</li>
					</ul>
				</li>
			</ul>
		</li>
		<li class="expandable"><a href="#"><strong>BiÃ§imbilimsel ÃÃ¶zÃ¼mleyiciler</strong></a>
			<ul>
				<li><a href="./jsp/morfKO.jsp">Kemal O. M.Ã.</a></li>
				<li><a href="/ddi/zemberek">Zemberek</a></li>
				<li><a href="/jsp/morfHS.jsp">HaÅim S. M.Ã.</a></li>
			</ul></li>

		<li class="last"><a href="#"><strong>BiÃ§imbilimsel
					Belirsizlik Gidericiler</strong></a>
			<ul>
				<li><a href="./jsp/disbgD.jsp">Deniz</a></li>
			</ul></li>
	</ul>
</div>