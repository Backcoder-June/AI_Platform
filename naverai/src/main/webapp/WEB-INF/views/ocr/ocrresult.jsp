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
	var ocr = '${ocrresult}';
	var jsoncr = JSON.parse(ocr);
	
	$("#text").html("텍스트 인식 결과 : <br>"); 
	for(var a = 0; a<jsoncr.images[0].fields.length; a++){
	$("#text").append(jsoncr.images[0].fields[a].inferText);
	
	if(jsoncr.images[0].fields[a].lineBreak == true){
	$("#text").append("<br>");
	}
	
	}//for 
	
	
	
	
	
	var mycanvas = document.getElementById("mycanvas");
	var pencil = mycanvas.getContext("2d");
	var myimage = new Image(); 
	myimage.src = "/naverai/${param.textimage}";
	myimage.onload = function(){
		pencil.drawImage(myimage,0,0, myimage.width, myimage.height);
		
		
		
		for(var a =0; a<jsoncr.images[0].fields.length; a++){
			var x1 = jsoncr.images[0].fields[a].boundingPoly.vertices[0].x;
			var y1 = jsoncr.images[0].fields[a].boundingPoly.vertices[0].y;
			var width1 = jsoncr.images[0].fields[a].boundingPoly.vertices[1].x - x1;
			var height1 = jsoncr.images[0].fields[a].boundingPoly.vertices[3].y - y1;
			
			
			
	  		pencil.strokeStyle = "red";
	 		pencil.lineWidth = 1;
	 		pencil.strokeRect(x1,y1,width1, height1);
	  
	 		pencil.font="15px";
	 		pencil.fillStyle="navy";
			pencil.fillText(jsoncr.images[0].fields[a].inferText, x1, y1);
			
			}
	} // onload 
	
});
</script>

</head>
<body>
<canvas id="mycanvas" width=600 height=600 style="border:2px solid yellow"></canvas>

${param.textimage} 파일에서 다음과 같은 텍스트를 읽어왔습니다.<br> 
<h3 id="text" style="border:2px solid silver"></h3>




</body>
</html>

