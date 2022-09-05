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

<c:forEach items="${filelist}" var="file">
<h3><a href="poseresult?image=${file}">${file}</a></h3>
<img src="http://localhost:8083/naverai/${file}" width=200 height=200>
<hr>
</c:forEach>


</body>
</html>