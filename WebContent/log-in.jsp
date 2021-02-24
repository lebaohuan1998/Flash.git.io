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
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet" href="public/fontawesome-free-5.15.1-web/css/all.min.css">

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
			<c:if test="${param.Register =='success'}">
				<div class="alert alert-success in">
					<strong>Thành công!</strong> bạn đã đăng ký thành công, hãy vào
					mail để xác thực email của bạn
				</div>
			</c:if>
			<c:if test="${param.acc =='notactive'}">
				<div class="alert alert-warning">
					<strong>Không thành công!</strong> Tài khoản bạn chưa được xác thực
					email!
				</div>
			</c:if>
			<c:if test="${param.login =='false' }">
				<div class="alert alert-warning">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Không thành công!</strong> Sai email hoặc mật khẩu!
				</div>
			</c:if>
			<div class="row justify-content-center half">
				<div class="col-md-12">
					<!-- <div class="bg order-1 order-md-2 bg1"> </div> -->
					<div class="form-block mx-auto">
						<div class="form-group text-center mb-5">
							<h1>Đăng nhập</h1>
						</div>
						<form id="login-form" class="form"
							action="${pageContext.request.contextPath}/LoginServlet"
							method="POST">
							<div class="form-group">
								<label for="email">Email</label> <input type="text"
									class="form-control" name="username" id="username"
									placeholder="Nhập email">
							</div>
							<div class="form-group">
								<label for="password" class="label">Mật khẩu</label> <input
									type="password" class="form-control" name="password"
									id="password" placeholder="Nhập mật khẩu"> <span
									id="password_error"></span>
							</div>
							<div class="form-group">
								<label class="label">Bạn là</label>
							</div>
							<div class="form-group  align-items-center">
								<input name="user" type="radio" value="1" class="mr-3"
									checked="checked" />Người dùng <input name="user" type="radio"
									value="2" class="mr-3" />Thợ ảnh
							</div>

							<div class="form-group d-sm-flex mb-5 align-items-center">
								<span class="ml-auto"><a href="quenpassword.jsp" class="forgot-pass">Quên
										mật khẩu</a></span>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-info btn-block my-3">Đăng
									nhập</button>
							</div>
						</form>

						<div class="form-group">
							<span class="text-center my-3 d-block">or</span>
							<div class="">
								<a href="#" class="btn btn-block py-2 btn-facebook"> <i
									class="fa fa-facebook-square"></i>Đăng nhập với facebook
								</a> <a
									href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Flash/GoogleLogin&response_type=code
                                          &client_id=457798901989-9ujt0a30a9t04709cotfav8er631bbf0.apps.googleusercontent.com&approval_prompt=force"
									class="btn btn-block py-2 btn-google"> <i
									class="fa fa-google-plus-square"></i> Đăng nhập Google
								</a>
							</div>
							<span class="text-center my-3 d-block ">Nếu bạn chưa có
								tài khoản <a
								href="${pageContext.request.contextPath}/RegisterServlet">Tại
									đây</a>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
	<%@ include file="form/include/footer.jsp"%>
	</div>
	<script
		src="${pageContext.request.contextPath}/public/js/validate/Login.js"></script>
</body>

</html>