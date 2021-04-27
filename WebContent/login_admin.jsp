<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
 <script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="public/css/style.css">
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
			<c:if test="${param.login =='false' }">
				<div class="alert alert-warning">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Không thành công!</strong> Sai email hoặc mật khẩu!
				</div>
			</c:if>
			<div class="row justify-content-center half">
				<div class="col-md-12">
					<div class="form-block mx-auto " style="padding: 0px 40px 40px 40px;">
						<div class="form-group text-center">
							<h1>Đăng nhập</h1>
						</div>
						<form id="login-form" class="form"
							action="${pageContext.request.contextPath}/admin"
							method="POST">
							<div class="form-group">
								<label for="email">Email</label> <input type="text"
									class="form-control" name="username" id="username"
									placeholder="Nhập tên">
							</div>
							<div class="form-group">
								<label for="password" class="label">Mật khẩu</label> <input
									type="password" class="form-control" name="password"
									id="password" placeholder="Nhập mật khẩu"> <span
									id="password_error"></span>
							</div>
							<div class="form-group">
								<div class="form-group">
								<button type="submit" class="btn-info btn  btn-block my-3">Đăng
									nhập</button>
							</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br>
		<%@ include file="form/include/footer.jsp"%>
	</div>
</body>


</html>