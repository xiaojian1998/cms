<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>