<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js" ></script>
<script>
$(document).ready(function(){

});
</script>



</head>
<body>
<%
String[] languages = {"Kor", "Jpn", "Eng", "Chn"};
String[] lang_names = {"한국어","일본어","영어","중국어"};
%>

<!-- service 에 보낼 파라미터 두개 : image / lang -->
<form action="sttresult">

<% for(int i =0; i<languages.length; i++){%>
<input type="radio" name="lang" value=<%=languages[i]%> > <%=lang_names[i] %>
<%} %>
<br>
mp3파일 선택 :  <select name="image">
<% // mp3 확장자만 골라오기 
String[] filelist = (String[])request.getAttribute("filelist");

for(int i= 0; i< filelist.length; i++){
	
	String file_split[] = filelist[i].split("\\.");
	String ext = file_split[file_split.length-1];
	
	if(ext.equals("mp3") || ext.equals("m4a")){ %>
	<option value="<%=filelist[i] %>"> <%=filelist[i] %> </option>
	<%}//if 
	
}//for 
%>
</select>

<input type=submit value="텍스트로변환">
</form>




<c:forEach items="${filelist}" var="file">
<h3><a href="sttresult?image=${file}">${file}</a></h3>
<img src="http://localhost:8083/naverai/${file}" width=200 height=200>
<hr>
</c:forEach>


</body>
</html>