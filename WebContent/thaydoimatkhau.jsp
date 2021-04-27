<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Thay đổi mật khẩu</title>
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
					<div class="form-block mx-auto" style="padding: 0px 40px 40px 40px;">
						<div class="form-group text-center ">
							<h1>Mật Khẩu Mới</h1>
						</div>
						<form id="register-form" class="form"
							action="${pageContext.request.contextPath}/UpdatePass"
							method="post">
							<div class="form-group" >
								<label class="label" >Nhập mật
									khẩu(*)</label> <input type="password" id="password"
									class="form-control" name="password"
									placeholder="nhập mật khẩu"
									 />
							</div>
							<div class="form-group" >
								<label class="label" >Nhập
									lại mật khẩu(*)</label> <input type="password" id="repassword"
									class="form-control" name="repassword"
									placeholder="nhập lại mật khẩu"
									 />
							</div>
							<div class="form-group" >
								<button type="submit" class="btn btn-info btn-block" >Cập nhật mật khẩu mới</button>
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