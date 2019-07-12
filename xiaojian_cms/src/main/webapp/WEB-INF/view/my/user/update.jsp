<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<script type="text/javascript" src="/resource/js/cms.js"></script>
<script type="text/javascript">
  var flag=0;//校验通过标注 ,0:通过. 1:不通过
	function  checkPhone(obj){
		
		$.get("/user/validatePhone",{src:$(obj).val()},function(result){
			if(result){
				flag=0;
				$("#mphone").text("")
			
			}else{
				flag=1
				$("#mphone").text("请输入正确手机号码格式");
			}
		})
	}
	function  checkNickname(obj){
		
		$.get("/user/validateNickname",{src:$(obj).val()},function(result){
			if(result){
				flag=0;
				$("#mnickname").text("");
			}else{
				flag=1;
				$("#mnickname").text("昵称不能为空")
			}
		})
	}
	function  checkEmail(obj){
		
		$.get("/user/validateEmail",{src:$(obj).val()},function(result){
			if(result){
				flag=0;
				$("#memail").text("")
			}else{
				flag=1;
				$("#memail").text("请输入正确邮箱格式");
			}
		})
	}
	
	function update(){
		if(flag!=0){
			alert("请完成输入要求,再修改");
			return ;
		}
		
		$.post("/user/updateUser",$("#mform1").serialize(),function(obj){
			
			if(obj){
				alert("修改成功");
				
			}else{
				alert("修改失败");
			}
		})
		
	}
	
</script>
</head>
<body>

	<div class="container-fluid">
		<form id="mform1">
		
		    <input type="hidden" name="id" value="${sessionScope.user.id }">
		     <input type="hidden" name="username" value="${sessionScope.user.username }">
			<div class="form-group">
				<label for="nickname">昵称:</label> <input type="text"
					class="form-control" name="nickname" id="nickname"
					value="${sessionScope.user.nickname }" onblur="checkNickname(this)"  placeholder="请输入昵称">
					<span  id="mnickname"
					style="color: red">
					
					
					</span>
				
			</div>

			<div class="form-group">
				<label for="gender">性别:</label> <input class="radio" type="radio"
					class="form-control" name="gender" id="gender" value="1"
					${sessionScope.user.gender==1?"checked":"" } checked="checked">先生
				<input type="radio" class="radio" name="gender" class="form-control"
					id="gender" value="2" ${sessionScope.user.gender==2?"checked":"" }>女士
			</div>
			<div class="form-group">
				<label for="birthday">出生日期:</label> <input type="date"
					class="form-control" name="birthday" id="birthday"
					value='<fmt:formatDate value="${sessionScope.user.birthday }" pattern="yyyy-MM-dd"/>' placeholder="请输入出生日期">
			
			</div>
			<div class="form-group">
				<label for="phone">手机号:</label> <input type="text"
					class="form-control" name="phone" id="phone"
					value="${sessionScope.user.phone }" onblur="checkPhone(this)" placeholder="请输入手机号">
					<span id="mphone" style="color: red"></span>
			</div>
			<div class="form-group">
				<label for="email">邮箱:</label> <input type="text"
					class="form-control" name="email" id="email"
					value="${sessionScope.user.email }" onblur="checkEmail(this)" placeholder="请输入邮箱">
					<span id="memail"
					style="color: red"></span> 
			</div>
			<div class="form-group">
				<label for="address">地址:</label> <input type="text"
					class="form-control" name="address" id="address"
					value="${sessionScope.user.address }" placeholder="请输入地址">
				
			</div>
			<div class="form-group">
				<label for="star">星座:</label> <input type="text"
					class="form-control" name="star" id="star"
					value="${sessionScope.user.star }" placeholder="请输入星座">
			</div>
			<div class="form-group">
				<label for="motto">座右铭:</label> <input type="text"
					class="form-control" name="motto" id="motto"
					value="${sessionScope.user.motto }" placeholder="请输入座右铭"> 
			</div>
			<div class="form-group">
			
				<button type="button" class="btn btn-info" onclick="update()">保存</button>
			</div>

		</form>
	</div>

</body>
</html>