<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>专题列表</title>
<script type="text/javascript" src="/resource/js/cms.js"></script>
<script type="text/javascript">

function toAdd(sid){
	 //在中间区域显示地址的内容
    $('#content-wrapper').load("/subject/toAddArticle?sid="+sid);
}



</script>
</head>
<body>
         
	<div class="container-fluid">
          
 </div>
 
 
		<table class="table table-sm  table-hover table-bordered ">
			<thead class="thead-light">
				<tr align="center">
				     <h5></h5>
					<td>序号</td>
					<td>专题名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach items="${subList }" var="s" varStatus="index">
				<tr align="center">
					<td>${index.index+1 }</td>
					<td>${s.name}</td>
					<td><button onclick="toAdd(${s.id})" type="button" style="color: red"> 添加文章</button> </td>
				</tr>

			</c:forEach>

		</table>
	</div>
	
	
<script>
var h1 = document.getElementsByTagName("h5")[0]													    
var count = 0   //计数器
var str = "后台文章专题  管理系统 ....." 
		 h1.style.background=""  //背景颜色
		 h1.style.color="red"
	 setInterval(fun,400)    // 间歇调用													
function fun(){
	count++
		 if(count>str.length){													        
			 count=0    //如果大于 重下标0开始 
			}													   
	var newStr = str.substr(0,count) 
		h1.innerHTML= newStr   // 输出到页面
			 }                
</script>




</body>
</html>