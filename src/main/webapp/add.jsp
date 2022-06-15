<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/stuC/stu" method="post">
		姓名：<input type="text" name="sname"/><br /><br />
		年龄：<input type="text" name="age"/><br /><br />
		性别：
			<input type="radio" name="sex" value="男" checked="checked"/>男
			<input type="radio" name="sex" value="女"/>女<br /><br />
		班级：
			<select name="cinfo.cid">
				<c:forEach items="${clist }" var="ci">
					<option value="${ci.cid }">${ci.cname }</option>
				</c:forEach>
			</select><br /><br />
		地址：<input type="text" name="address"/><br /><br />
		<input type="submit" value="提交"/>
	</form>
</body>
</html>