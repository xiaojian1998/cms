<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resource/js/cms.js"></script>

</head>
<body>
               <!--   个人主页不可选状态 -->
               
      
	<div class="container-fluid">
		<form id="mform1">
		
		    <input type="hidden" name="id" value="${sessionScope.user.id }">
		     <input type="hidden" name="username" value="${sessionScope.user.username }">
			<div class="form-group">
				<label for="nickname">昵称:</label> <input type="text"
					class="form-control" name="nickname" id="nickname"
					value="${sessionScope.user.nickname }" disabled="disabled">
					
				
			</div>

			<div class="form-group">
				<label for="gender">性别:</label> <input class="radio" type="radio"
					class="form-control" name="gender" id="gender" value="1"
					${sessionScope.user.gender==1?"checked":"" } checked="checked"   disabled="disabled">先生
				<input type="radio" class="radio" name="gender" class="form-control"
					id="gender" value="2" ${sessionScope.user.gender==2?"checked":"" }       disabled="disabled">女士
			</div>
			<div class="form-group">
				<label for="birthday">出生日期:</label> <input type="date"
					class="form-control" name="birthday" id="birthday"
					value='<fmt:formatDate value="${sessionScope.user.birthday }" pattern="yyyy-MM-dd"/>'disabled="disabled">
			
			</div>
			<div class="form-group">
				<label for="phone">手机号:</label> <input type="text"
					class="form-control" name="phone" id="phone"
					value="${sessionScope.user.phone }" onblur="checkPhone(this)" disabled="disabled">
					
			</div>
			<div class="form-group">
				<label for="email">邮箱:</label> <input type="text"
					class="form-control" name="email" id="email"
					value="${sessionScope.user.email }" onblur="checkEmail(this)" disabled="disabled">
					
			</div>
			<div class="form-group">
				<label for="address">地址:</label> <input type="text"
					class="form-control" name="address" id="address"
					value="${sessionScope.user.address }" disabled="disabled">
				
			</div>
			<div class="form-group">
				<label for="star">星座:</label> <input type="text"
					class="form-control" name="star" id="star"
					value="${sessionScope.user.star }" disabled="disabled">
			</div>
			<div class="form-group">
				<label for="motto">座右铭:</label> <input type="text"
					class="form-control" name="motto" id="motto"
					value="${sessionScope.user.motto }" disabled="disabled"> 
			</div>

		</form>
	</div>

</body>
</html>