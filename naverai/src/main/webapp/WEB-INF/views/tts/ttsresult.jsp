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
document.getElementById("myaudio").play();
	
});
</script>

</head>
<body>
${param.image} 텍스트를 ${ttsresult} 파일로 전환했습니다. 
<audio id="myaudio" src="/naverai/${ttsresult}" controls></audio>


</body>
</html>

