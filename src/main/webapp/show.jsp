<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<script type="text/javascript">
	function remove(id){
		document.myform.action="${pageContext.request.contextPath }/empC/emp/"+id;
		document.myform.submit();
	}
</script>
</head>
<body>
	<form name="myform" action="" method="post">
		<!-- 表单中隐藏提交的方式(移除资源) -->
		<input type="hidden" name="_method" value="delete"/>
	</form>
	<table class="table table-striped table-hover">
		<caption><a href="${pageContext.request.contextPath }/stuC/change">添加</a></caption>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>班级</th>
			<th>年龄</th>
			<th>性别</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pageStu }" var="si">
			<tr>
				<td>${si.sid }</td>
				<td>${si.sname }</td>
				<td>${si.cinfo.cname}</td>
				<td>${si.age }</td>
				<td>${si.sex }</td>
				<td>${si.address }</td>
				<td>
					<a href="${pageContext.request.contextPath }/">编辑</a>
					<a href="javascript:remove()">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" style="text-align: center;">
				共${total }条数据&nbsp;&nbsp;&nbsp;第${pageNum }/${pages }页
				<a href="${pageContext.request.contextPath }/stuC/stu?pageNo=1">首页</a>
				<a href="${pageContext.request.contextPath }/stuC/stu?pageNo=${pageNum<=1?1:pageNum-1}">上一页</a>
				<a href="${pageContext.request.contextPath }/stuC/stu?pageNo=${pageNum<pages?pageNum+1:pages}">下一页</a>
				<a href="${pageContext.request.contextPath }/stuC/stu?pageNo=${pages}">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>