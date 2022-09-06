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
	$("#ajxbtn").on("click", function(e){
		
		$.ajax({
			url : "mapresult",
			type : "get",
			dataType : "json",
			data : {'text': $("#text").val(), 'speaker' : $("#speaker").val() },
				
			success : function(resp){
				$("#response").html("응답내용 : " + resp.result2 + "<br>");
				$("#mp3").attr("src","/naverai/" + resp.mp3);
				
				document.getElementById("mp3").play();
			} // success 
			
			
			
		}); //ajax
		
		
		
	});//onclick

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





<form id="mapform" action="mapresult">

AI인물 선택 : <br> 
<% for(int i =0; i<speakers.length; i++){%>
<input type="radio" id="speaker" name="speaker" value=<%=speakers[i]%> > <%=speakerinforms[i] %>
<%} %>
<br>


대화입력 : <input type="text" name="text" id="text">
<input type="button" value="대화전송" id="ajxbtn">
</form>

<div id="response">

</div>
<audio id="mp3" src="" controls></audio>


</body>
</html>