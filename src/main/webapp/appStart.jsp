<%--
  GameAppクラス作成後、下記の記述が必要です。
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題4</title>
<style>
body {
	border: solid 2px #000080;
	padding: 5px;
}

.result {
	background: #fffacd;
	display: inline-block;
	margin: 5px;
	padding: 10px;
}
</style>
</head>
<body>

	<h1>Java応用 - 演習問題4</h1>

	<h2>ゲームアプリ実行ページ</h2>

	<c:if test="${not empty result}">
		<div class="result">
			<h3>アプリの実行結果</h3>
			<p>${fn:escapeXml(result)}</p>
		</div>
	</c:if>
	<form action="StartAppServlet" method="post">
		<label>名前：</label> 
		<input type="text" name="name"> 
		<br>
		 <label>アプリ：</label>
		<label> <input type="radio" name="appType" value="card" checked /> トランプ</label> 
		<label> <input type="radio" name="appType" value="darts" /> ダーツ </label>
		<label> <input type="radio" name="appType" value="clock" /> 時計 </label>
		<label> <input type="radio" name="appType" value="others" /> その他 </label>
		<br>
		<button type="submit">実行</button>
	</form>
</body>
</html>
