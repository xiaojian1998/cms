<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">

function myopen(id){
	//alert(id)
	window.open("/article/getDetail?id="+id,"_blank");
	
}
$(function() {
	var uid = $(a.user_id)
	//alert(uid)
	location.href("/user/asss?id="+uid);
})
</script>
</head>
<body>

	<c:forEach items="${list}" var="a">
		<dl>
			<dt><a href="javascript:myopen(${a.id })">${a.title }</a></dt>
			<dd>作者:${user.nickname},发布时间:${a.created} 
			<span style="float: right"><a class="channel" href="javascript:void(0)" data="/article/toUpdate?id=${a.id }">编辑</a></span>
			</dd>
		</dl>
		<hr>


	</c:forEach>


</body>
<script type="text/javascript" src="/resource/js/cms.js"></script>
</html>