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
String speakers[] = 
{"mijin", "jinho", "clara", "matt", "shinji", "meimei", "liangliang", "jose",
		"carmen", "nnaomi", "nhajun", "ndain"};

String[] speakerinforms = {
		"미진:한국어, 여성음색", "진호:함국어, 남성음색", 
		"클라라 : 영어, 여성 음색", "매트 : 영어, 남성 음색",
		"신지: 일본어, 남성 음색", "메이메이 : 중국어, 여성 음색",
		"량량 : 중국어, 남성 음색", "호세 : 스페인어, 남성 음색",
		"카르멘 : 스페인어, 여성 음색", 	"나오미 : 일본어, 여성 음색",
		"하준 : 한국어, 아동 음색 (남)", "다인 : 한국어, 아동음색 (여)"
		};
%>

<!-- service 에 보낼 파라미터 두개 : image / lang -->
<form action="ttsresult">

AI인물 선택 : <br> 
<% for(int i =0; i<speakers.length; i++){%>
<input type="radio" name="speaker" value=<%=speakers[i]%> > <%=speakerinforms[i] %>
<%} %>
<br>
텍스트 파일 선택 :  <select name="image">
<% // mp3 확장자만 골라오기 
String[] filelist = (String[])request.getAttribute("filelist");

for(int i= 0; i< filelist.length; i++){
	
	String file_split[] = filelist[i].split("\\.");
	String ext = file_split[file_split.length-1];
	
	if(ext.equals("txt")){ %>
	<option value="<%=filelist[i] %>"> <%=filelist[i] %> </option>
	<%}//if 
	
}//for 
%>
</select>

<input type=submit value="음성으로변환">
</form>






</body>
</html>