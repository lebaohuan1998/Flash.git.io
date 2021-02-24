<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><c:if test="${param.flag =='1'}">
		Quản lý hồ sơ
	</c:if> <c:if test="${param.flag !='1'}">
		Quản lý tài khoản
	</c:if></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<link rel="stylesheet" href="public/css/style.css">
<link rel="stylesheet" href="public/css/csshomepage.css">
<link rel="stylesheet" href="public/css/bootstrap.min.css">

</head>

<body>
	<%@ include file="include/navbar.jsp"%>
	<div class="bg-light ">
		<c:if test="${param.update =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> bạn đã cập nhật thông tin.
			</div>
		</c:if>
		<c:if test="${param.err =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> bạn đã thay đổi mật khẩu.
			</div>
		</c:if>
		<c:if test="${param.errdupplicate =='true'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Mật khẩu mới không được trùng với
				mật khẩu cũ.
			</div>
		</c:if>
		<c:if test="${param.err =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Sai mật khẩu.
			</div>
		</c:if>

		<div class=" row container mx-auto ">

			<%@ include file="include/menu.jsp"%>
			<c:if test="${param.flag =='1'}">
				<%@ include file="quanlihoso-photo.jsp"%>
			</c:if>
			<c:if test="${para.flag =='2'}">

			</c:if>
		</div>
		<br> <br> <br>
	</div>

	<%@ include file="include/footer.jsp"%>
	<script
		src="${pageContext.request.contextPath}/public/js/validate/infousernor.js"></script>
</body>

</html>