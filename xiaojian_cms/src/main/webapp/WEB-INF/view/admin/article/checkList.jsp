<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<script type="text/javascript">
$(function(){
	
	
	
	$(".form-control-sm").change(function(){
		
		$("#content-wrapper").load("/article/checkList?status="+$(this).val())
	})
	//下拉框回显
	$(".form-control-sm").val('${status}')
})


//查看文章详情
function toDetail(id){
	$("#content-wrapper").load("/article/get?id="+id)
	
}

</script>


</head>
<body>
<div class="container-fluid">

		<div>
		     文章状态
			  <select class="form-control-sm" >
			    <option value="">全部</option>
			    <option value="0">待审核</option>
			    <option value="1">已审核</option>
			    <option value="-1">审核未通过</option>
			  
			  
			  </select>
		
		</div>

		<table class="table table-sm  table-hover table-bordered ">
			<thead class="thead-light">
				<tr align="center">
					<td>序号</td>
					<td>作者</td>
					<td>标题</td>
					<td>当前状态</td>
					<td>热点</td>
					<td>发布时间</td>
					<td>栏目</td>
					<td>分类</td>
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach items="${list }" var="a" varStatus="index">
				<tr align="center">
					<td>${index.index+1 }</td>
					<td>${a.username}</td>
					<td>${a.title}</td>
					<td>${a.status==0?"待审核":a.status==1?"已审核":"未通过" }</td>
					<c:if test="${a.status==0}">
						<td>
							待审核通过
						</td>
					</c:if>
					<c:if test="${a.status==1}">
						<td>
							
								<button type="button" class="btn btn-success" onclick="upd('${a.id}',this)">${a.hot=="1"?"热点":"非热点"}</button>
							
						</td>
					</c:if>
					
					
					<td>${a.created}</td>
					<td>${a.name}</td>
					<td>${a.catname}</td>
					<td><button type="button" class="btn btn-info" onclick="toDetail(${a.id})">详情</button> </td>
				</tr>

			</c:forEach>

		</table>
		<div>
		  ${pageInfo}
		</div>
	</div>
</body>
<script type="text/javascript">
$(function() {
	$(function(){
	      $('.page-link').click(function (e) {
	      	  //获取点击的的url
	          var url = $(this).attr('data');
	         //在中间区域显示地址的内容
	        
	        $('#content-wrapper').load(url);
	      });
		
	})
})
function upd(aid,obj){
	
	$.ajax({
		type:"post",
		data:{id:aid,hot:$(obj).text()=="非热点"?1:0},
		url:"/article/hot",
		success:function(flag){
		  	if(flag){
			 $(obj).text($(obj).text()=="热点"?"非热点":"热点");
		  	}
		}
		
	}) 
	


		
}
function upd1(id){
	
	location.href="/article/hot1?id="+id;
		
}
</script>
</html>