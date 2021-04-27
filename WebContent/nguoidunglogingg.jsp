<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cập nhật thôn tin người dùng</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
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
		<div class="container-fluid  ">
			<div class="row justify-content-center">
				<div class="">
					<div class="form-block mx-auto" style="padding: 0px 40px 40px 40px;">
						<div class="form-group text-center ">
							<h2>Cập nhật thông tin người dùng</h2>
						</div>
						<form id="register-form" class="form"
							action="${pageContext.request.contextPath}/LoginUserGoogle"
							method="post">
							<div class="form-group">
								<label class="email">Email</label> <input type="email"
									id="email" name="email" class="form-control"
									placeholder="Nhập email"  value="${email}"  readonly="readonly">
							</div>
							<div class="form-group" >
								<div class="form-group ">
									<label class="label">Họ và Tên(*)</label> <input type=""
										class="form-control" name="fullName"
										placeholder="Nhập họ và tên"  />
								</div>
								<div class="form-group " >
									<label class="label">SĐT(*)</label> <input type="phone"
										class="form-control" name="phone" placeholder="Nhập số điện thoại" />
								</div>
							</div>
							<div class="form-group" >
								<label class="label" >Mật khẩu(*)</label> <input type="password"
									id="password" class="form-control" name="password"
									placeholder="nhập mật khẩu" />
							</div>
							<div class="form-group">
								<label class="label" >Nhập lại mật khẩu(*)</label> <input
									type="password" id="repassword" class="form-control"
									name="repassword" placeholder="nhập lại mật khẩu" />
							</div>
							<div class="form-group" >
								<button type="submit" class="btn btn-info btn-block">Cập nhật thông tin</button>
							</div>
						</form>
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