<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Đăng nhập</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">

<link rel="stylesheet" href="public/css/style.css">
<link rel="stylesheet" href="public/css/bootstrap.min.css">

</head>

<body>
	<!--navbar-->
	<nav class="navbar navbar-expand-xl bg-dark sticky-top ">
		<a class="navbar-brand mr-5"
			href="${pageContext.request.contextPath}/HomePageServlet"><img
			src="form/pic/logo.png" class="" height="60px"></a>
	</nav>
	<div class="bg-light">
		<div class="container-fluid ">
			<c:if test="${param.find =='false' }">
				<div class="alert alert-warning">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Không thành công!</strong> Sai email hoặc email của bạn chưa được đăng ký
				</div>
			</c:if>
			<c:if test="${param.find =='true' }">
				<div class="alert alert-success in">
					<strong>Thành công!</strong> Hãy vào email của bạn để thực hiện thay đổi mật khẩu, hãy bảo vệ mật khẩu một cách an toàn.
				</div>
			</c:if>
			<c:if test="${param.noti =='timeout' }">
				<div class="alert alert-success in">
					<strong>Không thành công!</strong> vui lòng thực hiện lại.
				</div>
			</c:if>
			
			<div class="row justify-content-center half">
				<div class="col-md-12">
					<!-- <div class="bg order-1 order-md-2 bg1"> </div> -->
					<div class="form-block mx-auto" style="padding: 0px 40px 40px 40px;">
						<div class="form-group text-center">
							<h1>Nhập Email</h1>
						</div>
						<form id="login-form" class="form"
							action="${pageContext.request.contextPath}/ResetPass" method="POST">
							<div class="form-group">
								<input type="text" class="form-control" name="username"
									id="username" placeholder="Nhập email">
							</div>
							<div class="form-group">
								<label class="label">Tài khoản của bạn là</label>
							</div>
							<div class="form-group  align-items-center">
								<input id="user" name="user" type="radio" value="1"
									class="gender mr-1" checked="checked" /><label>Người
									dùng </label><input id="user" name="user" type="radio" value="2"
									class="gender female mr-1" /><label>Thợ ảnh</label>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-block my-3">Gửi về email</button>
							</div>
						</form>


					</div>
				</div>
			</div>
		</div>
		<br> <br> <br>
		<%@ include file="form/include/footer.jsp"%>
	</div>
	<script
		src="${pageContext.request.contextPath}/public/js/validate/Login.js"></script>
</body>

</html>