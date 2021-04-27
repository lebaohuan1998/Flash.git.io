<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Đăng ký người dùng</title>
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
		</div>
	</nav>
	<div class="bg-light">
		<div class="container-fluid  ">
			<c:if test="${param.err =='false'}">
				<div class="alert alert-warning">
					<strong>Không thành công</strong> Email đã tồn tại.
				</div>
			</c:if>
			<div class="row justify-content-center">
				<div class="">
					<div class="form-block mx-auto" style="padding: 0px 40px;border: 1px solid rgba(0,0,0,0.15);">
						<div class="form-group text-center ">
							<h1>Đăng ký Tài Khoản Flash</h1>
						</div>
						<form id="register-form" class="form"
							action="${pageContext.request.contextPath}/RegisterServlet"
							method="post">
							<div class="form-group" style="font-family: 'Helvetica', serif;">
								<label class="email" style="font-family: 'Helvetica', serif;">Email(*)</label> <input type="email"
									id="email" name="email" class="form-control"
									placeholder="Nhập email" style="font-family: 'Helvetica', serif;">
							</div>
							<div class="form-group" style="font-family: 'Helvetica', serif;">
								<div class="form-group ">
									<label class="label" style="font-family: 'Helvetica', serif;">Họ và Tên(*)</label> <input type=""
										class="form-control" name="fullName"
										placeholder="Nhập họ và tên" style="font-family: 'Helvetica', serif;" />
								</div>
								<div class="form-group " style="font-family: 'Helvetica', serif;">
									<label class="label">SĐT(*)</label> <input type="phone"
										class="form-control" name="phone" placeholder="Nhập số điện thoại"/>
								</div>
							</div>
							<div class="form-group" style="font-family: 'Helvetica', serif;">
								<label class="label" style="font-family: 'Helvetica', serif;">Mật khẩu(*)</label> <input type="password"
									id="password" class="form-control" name="password"
									placeholder="nhập mật khẩu" style="font-family: 'Helvetica', serif;"/>
							</div>
							<div class="form-group" style="font-family: 'Helvetica', serif;">
								<label class="label" style="font-family: 'Helvetica', serif;">Nhập lại mật khẩu(*)</label> <input
									type="password" id="repassword" class="form-control"
									name="repassword" placeholder="nhập lại mật khẩu" style="font-family: 'Helvetica', serif;" />
							</div>
							<div class="form-group" >
								<button type="submit" class="btn btn-info btn-block" style="font-family: 'Helvetica', serif;">Tạo
									tài khoản</button>
							</div>
						</form>

						<div class="form-group mb-0" style="font-family: 'Helvetica', serif;">
							<span class="my-3 d-block">Khi bạn nhấn Đăng ký, bạn đã
								đồng ý thực hiện mọi giao dịch mua bán theo điều kiện sử dụng và
								chính sách của Flash.</span>
						</div>
						<div class="form-group mb-0" style="font-family: 'Helvetica', serif;">
							<span class="my-3 d-block">Nếu bạn muốn đăng ký là người
								chụp ảnh<a
								href="${pageContext.request.contextPath}/RegisterPhotographerOrModel" style="font-family: 'Helvetica', serif;">tại
									đây</a>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<%@ include file="form/include/footer.jsp"%>
	</div>
	<script
		src="${pageContext.request.contextPath}/public/js/validate/registeruser.js"></script>
</body>

</html>