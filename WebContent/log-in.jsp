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
	<c:url var="APIurl" value="/GoogleLogin" />
	<div class="bg-light">
		<div class="container-fluid ">
			<c:if test="${param.Register =='success'}">
				<div class="alert alert-success in">
					<strong>Thành công!</strong> bạn đã đăng ký thành công, hãy vào
					mail để xác thực email của bạn
				</div>
			</c:if>
			<c:if test="${param.noti =='success'}">
				<div class="alert alert-success in">
					<strong>Thành công!</strong> bạn đã thay đổi thành công mật khẩu
					mới.
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
					<div class="form-block mx-auto"
						style="border: 1px solid rgba(0, 0, 0, 0.15); padding: 0px 40px;">
						<div class="form-group text-center">
							<h1>Đăng nhập</h1>
						</div>
						<form id="login-form" class="form"
							action="${pageContext.request.contextPath}/LoginServlet"
							method="POST">
							<div class="form-group">
								<label for="email">Email</label> <input type="text"
									class="form-control" name="username" id="username"
									placeholder="Nhập email"
									style="font-family: 'Helvetica', serif;">
							</div>
							<div class="form-group" style="font-family: 'Helvetica', serif;">
								<label for="password" class="label">Mật khẩu</label> <input
									type="password" class="form-control" name="password"
									id="password" placeholder="Nhập mật khẩu"> <span
									id="password_error"></span>
							</div>
							<div class="form-group  align-items-center">
								<input id="user" name="user" type="radio" value="1"
									class="gender mr-1" checked="checked" /><label>Người
									dùng </label><input id="user" name="user" type="radio" value="2"
									class="gender female mr-1" /><label>Thợ ảnh</label>
							</div>

							<div class="form-group d-sm-flex">
								<span class="ml-auto"><a href="quenpassword.jsp"
									class="forgot-pass">Quên mật khẩu</a></span>
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-info btn-block my-3">Đăng
									nhập</button>
							</div>
						</form>

						<div class="form-group">
							<div class="">
								<a id="log"
									href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Flash/GoogleLogin&response_type=code&client_id=457798901989-9ujt0a30a9t04709cotfav8er631bbf0.apps.googleusercontent.com&approval_prompt=force"
									class="btn btn-block py-2 btn-google"> <i
									class="fa fa-google-plus-square"></i> Đăng nhập Google
								</a>
							</div>
							<span class="text-center my-3 d-block "
								style="font-family: 'Helvetica', serif;">Nếu bạn chưa có
								tài khoản, hãy đăng ký tài khoản <a
								href="${pageContext.request.contextPath}/RegisterServlet"
								>Tại đây</a>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<%@ include file="form/include/footer.jsp"%>
	</div>
	<script type="text/javascript">
		$("#log").click(function() {
			var role = $("input[name='user']:checked").map(function() {
				return $(this).val();
			}).get();
			var x = role[0];
			$.ajax({
				url : '${APIurl}',
				type : 'GET',
				contentType : 'application/json',
				data : {
					role : x,
				},
				error : function(error) {
					console.log(error);
				}
			});
		});
	</script>
	<script
		src="${pageContext.request.contextPath}/public/js/validate/Login.js"></script>
</body>

</html>