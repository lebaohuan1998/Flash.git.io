<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-xl bg-dark sticky-top ">
	<a class="navbar-brand mr-5"
		href="${pageContext.request.contextPath}/HomePageServlet"><img
		src="form/pic/logo.png" class="" height="60px"> </a>
	<button class="navbar-toggler bg-light btn-outline-dark" type="button"
		data-toggle="collapse" data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<i class="fa fa-bars" aria-hidden="true"></i>
	</button>

	<div class="collapse navbar-collapse   " id="navbarSupportedContent">
		<div class="side-1 ">
			<ul class="navbar-nav  ">
				<li class="nav-item  mr-4 ">
					<div class="dropdown show ">
						<c:if test="${role =='2'||role =='3'||role =='1'||role =='4'}">
							<a class="btn btn-outline-dark dropdown-toggle" role="button"
								id="dropdownMenuLink" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> <i
								class="fa fa-user mr-2"></i>${user}
							</a>
						</c:if>
						<div class="dropdown-menu bg-dark"
							aria-labelledby="dropdownMenuLink">
							<c:if test="${role =='2'||role =='3'}">
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/ProfileUser?flag=1"><i
									class="fa fa-info mr-1"></i>Thông tin Tài khoản</a>
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/followServicePackage?flag=2"><i
									class="fa fa-info mr-1"></i>Gói chụp yêu thích</a>
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/followPhotographer?flag=3"><i
									class="fa fa-info mr-1"></i>Thợ chụp ảnh yêu thích</a>
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/manageBooking?flag=4"><i
									class="fa fa-info mr-1"></i>Quản lý đặt chụp</a>
								<a class="dropdown-item btn"
									href="${pageContext.request.contextPath}/LogOut"><i
									class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
							</c:if>
							<c:if test="${role =='4'}">
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/ProfilePhoto?flag=1"><i
									class="fa fa-info mr-1"></i>Thông tin tài khoản</a>
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/GoiDichVuLichBan?flag=3"><i
									class="fa fa-info mr-1"></i>Quản lý gói dịch vụ</a>
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/DescribePhotographer?flag=5"><i
									class="fa fa-info mr-1"></i>Mô tả thợ ảnh</a>
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/ManageBookingPhotographer?flag=6"><i
									class="fa fa-info mr-1"></i>Quản lý gói chụp tả thợ ảnh</a>
								<a class="dropdown-item btn"
									href="${pageContext.request.contextPath}/LogOut"><i
									class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
							</c:if>
							<c:if test="${role =='1'}">
								<a class="dropdown-item btn"
									href="${pageContext.request.contextPath}/LogOut"><i
									class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
							</c:if>
						</div>
					</div>
				</li>
				<li>
				<c:if test="${role =='3'}">
				<div id="spoiler" style="position: relative; display: block" class="dropdown show ">
					<body onLoad="loadByUser()">
						<a onclick="clickh()"
							href="${pageContext.request.contextPath}/ManageNotification?flag=5">
							<i class="fa fa-bell" style="font-size: 24px; color: #fff; margin-top: 7px; position: absolute;"></i>
							<div id="NotificationBadge" style="color: white; display: none; position: absolute; border-radius: 50%; background: red; width: 23px; height: 23px; z-index: 999; text-align: center; margin-left: 10px; box-sizing: border-box;">
								<span style="font-size: 15px; color: white;"></span>
							</div>
						</a>
					</body>
				</div>
				</c:if>
				<c:if test="${role =='4'}">
				<div id="spoiler" style="position: relative; display: block" class="dropdown show ">
					<body onLoad="toggle()">
						<a onclick="clickh()"
							href="${pageContext.request.contextPath}/ManageNotificationPhotographer?flag=7">
							<i class="fa fa-bell" style="font-size: 24px; color: #fff; margin-top: 7px; position: absolute;"></i>
							<div id="NotificationBadge" style="color: white; display: none; position: absolute; border-radius: 50%; background: red; width: 23px; height: 23px; z-index: 999; text-align: center; margin-left: 10px; box-sizing: border-box;">
								<span style="font-size: 15px; color: white;"></span>
							</div>
						</a>
					</body>
				</div>
				</c:if>
				</li>
			</ul>
		</div>
	</div>
</nav>
