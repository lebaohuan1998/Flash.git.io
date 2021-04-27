<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/public\css\styles.css"
	rel="stylesheet" />
<link rel="stylesheet" href="public/css/csshomepage.css">
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<!--  -->
<script src="public/js/jquery.min.js"></script>
<script src="public/js/jquery.js"></script>
<!---->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<link rel="stylesheet" href="public/css/bootstrap.min.css">
</head>
<body class="sb-nav-fixed">
	<nav class="navbar navbar-expand-xl bg-dark sticky-top ">
		<a class="navbar-brand mr-5"
			href="${pageContext.request.contextPath}/HomePageServlet"><img
			src="form/pic/logo.png" class="" height="60px"></a>
		<button class="navbar-toggler bg-light btn-outline-dark" type="button"
			data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fa fa-bars" aria-hidden="true"></i></span>
		</button>

		<div class="collapse navbar-collapse menu "
			id="navbarSupportedContent">
			<div class="side-1">
				<ul class="navbar-nav   ">
					<li class="nav-item ">
						<div class="dropdown show">
							<a class="btn btn-outline-dark dropdown-toggle" role="button"
								id="dropdownMenuLink" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> <i
								class="fa fa-user mr-2"></i>${user}
							</a>
							
								<div class="dropdown-menu bg-dark"
									aria-labelledby="dropdownMenuLink">
									<c:if test="${role =='3'}">
									<a class="dropdown-item btn "
										href="${pageContext.request.contextPath}/ProfileUser?flag=1"><i
										class="fa fa-info mr-1"></i>Thông tin cá nhân</a>
									</c:if>	 
								    <a
										class="dropdown-item btn"
										href="${pageContext.request.contextPath}/LogOut"><i
										class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
								</div>
							
						</div>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	</nav>