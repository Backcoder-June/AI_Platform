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

	let poseresult = '${poseresult}';
	let jsonresult = JSON.parse(poseresult); 
	
	
	let mycanvas = document.getElementById("mycanvas");
	let pencil = mycanvas.getContext("2d");
	
	var myimage = new Image();
	myimage.src= "http://localhost:8083/naverai/${param.image}"
	
	
	
	var colors = ['red', 'blue', 'green', 'purple', 'pink', 'yellow', 'navy', 'lime'];
	var bodyinforms = ['코', '목', '오어깨', '오팔꿈치', '오손목', '왼어깨', '왼팔꿈치', '왼손목'];
	
	
	// 이미지 크기 조절
	if(myimage.width > mycanvas.width){
		mycanvas.width = myimage.width;
	}
	if(myimage.height> mycanvas.height){
		mycanvas.height = myimage.height;
	}
	
	myimage.onload = function(){
		pencil.drawImage(myimage, 0,0, myimage.width, myimage.height);
		
		  /* for(var p =0; p< jsonresult.length; p++){
		   */
			for(var j = 0; j<8; j++){
		let x = jsonresult.predictions[0][j].x * myimage.width; 
		let y = jsonresult.predictions[0][j].y * myimage.height; 
		
		pencil.fillStyle=colors[j]; 
		pencil.fillText(bodyinforms[j], x,y);
		pencil.fillRect(x,y,10,10);
		
		//양손목 연결 
		if(bodyinforms[j].indexOf("왼손목")>=0){
			var leftx = jsonresult.predictions[0][j].x*myimage.width; 
			var lefty = jsonresult.predictions[0][j].y*myimage.height; 
		}
		if(bodyinforms[j].indexOf("오손목")>=0){
			var rightx = jsonresult.predictions[0][j].x*myimage.width; 
			var righty = jsonresult.predictions[0][j].y*myimage.height; 
		}
		
		pencil.beginPath();
		pencil.moveTo(leftx,lefty);
		pencil.lineTo(rightx, righty);
		pencil.closePath();
		
		pencil.strokeStyle="orange";
		pencil.lineWidth= 5; 
		pencil.stroke(); // 그어라 
		
		
		
			} //for 
 		
		
		  
/* 		  } */
		 
	} // onload function
	
	
	
	
});
</script>



</head>
<body>

<div id="here">여기</div>
<img src="http://localhost:8083/naverai/${param.image}">
<hr>


<canvas id="mycanvas" width=500 height=500 style="border:2px solid yellow">
</canvas>

</body>
</html>