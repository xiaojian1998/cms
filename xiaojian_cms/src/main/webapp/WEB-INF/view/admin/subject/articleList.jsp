<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<script type="text/javascript" src="/resource/js/cms.js"></script>
<script type="text/javascript">
//查看文章详情
function toDetail(id){
	$("#content-wrapper").load("/article/get?id="+id)
	
}

function query(){
	var cid=$("#channel").val();
	var catid=$("#category").val();
	$("#content-wrapper").load("/subject/toAddArticle?cid="+cid+"&catid="+catid)
	
}



//如果文章已经属于某个专题,则选中
$(function(){
	$.get("/subject/selectArtilceListBySid",{sid:'${sid}'},function(list){
		for(var i in list){
			$(".ids").each(function(){
					if($(this).val()==list[i].id)
					$(this).prop("checked",true);
			})
		}
	})
	
	
	
})

function add(){
var ids = new Array();
 $(".ids:checked").each(function(i){
	 ids[i] =$(this).val();
 })
 if(ids.length==0){
	 alert("请至少选中一个文章")
	 return ;
 }

 
 //向专题中添加文章,需要传递两个参数,  ids:文章ID 的数组    .sid:专题的主键
 $.post("/subject/add",{ids:ids,sid:'${sid}'},function(obj){
	 if(obj){
		 alert("添加成功!")
	 }else{
		 alert("添加失败!")
	 }
 })
}



$(function(){

	
	
	//自动加载文章的栏目
	$.ajax({
		type:"get",
		url:"/channel/listChannle",
		success:function(list){
			$("#channel").empty();
			for(var i in list){
				$("#channel").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>")
			}
			$("#channel").val('${cid}')
		}
		
	})
	//为栏目添加绑定事件
	$("#channel").change(function(){
		 //先清空原有的栏目下的分类
			 $("#category").empty();
			var cid =$(this).val();//获取当前的下拉框的id
			//根据ID 获取栏目下的分类
			 $.get("/channel/listCategory",{cid:cid},function(list){
				
			 for(var i in list){
			  $("#category").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>")
	
			 }
			 $("#category").val('${catid}')
		 
	 })
	})
})


</script>
</head>
<body>
	<div class="container-fluid">
		<div>
			<button class="btn btn-info" type="button" onclick="add()">添加文章</button>

		</div>
		
		<!--  根据文章栏目查询 和 文章分类查询 -->
		 <div style="float: right">
		<form class="form-inline" >
			<div class="form-group">
				<label for="channel">文章栏目</label>  <object>请选择</object> <select
					class="form-control" id="channel"
					name="channelId">
					<option></option>
				</select> <label for="category">文章分类</label> <object>请选择</object><select
					class="form-control" id="category"
					name="categoryId">
				</select>
				<button class="btn btn-info"  type="button" onclick="query()">查询</button>
				
			</div>
			
			</form>
		</div>  

		<table class="table table-sm  table-hover table-bordered ">
			<thead class="thead-light">
				<tr align="center">
					<td></td>
					<td>文章ID</td>
					<td>作者</td>
					<td>文章标题</td>
					<td>发布时间</td>
				    <td>栏目</td> 
					<td>分类</td> 
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach items="${list }" var="a" varStatus="index">
				<tr align="center">
					<td><input type="checkbox" class="ids" value="${a.id }">
					</td>
					<td>${index.index+1 }</td>
					<td>${a.username}</td>
					<td>${a.title}</td>
					<td>${a.created}</td>
					<td>${a.cname}</td> 
					<td>${a.catname}</td> 
					<td><button type="button" class="btn btn-info"
							onclick="toDetail(${a.id})">详情</button></td>
				</tr>

			</c:forEach>
             
		</table>
		
		
	</div>
</body>
</html>