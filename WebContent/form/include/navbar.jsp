<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<div class="collapse navbar-collapse   " id="navbarSupportedContent">
		<div class="side-1 input-group">
			<ul class="navbar-nav   ">
				<li class="nav-item ">
					<div class="dropdown ">
						<a class="btn btn-outline-dark dropdown-toggle" role="button"
							id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fa fa-user mr-2"></i>${user}
						</a>
						<div class="dropdown-menu bg-dark"
							aria-labelledby="dropdownMenuLink">
							<c:if test="${role =='1'}">
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/ProfileUser?flag=1"><i
									class="fa fa-info mr-1"></i>Thông tin cá nhân</a>
								<a class="dropdown-item btn"
									href="${pageContext.request.contextPath}/LogOut"><i
									class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
							</c:if>
							<c:if test="${role =='2'}">
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/ProfilePhoto?flag=1"><i
									class="fa fa-info mr-1"></i>Thông tin cá nhân</a>
								<a class="dropdown-item btn "
									href="${pageContext.request.contextPath}/GoiDichVu_LichBan?flag=3"><i
									class="fa fa-info mr-1"></i>Gói dịch vụ, lịch bận</a>
								<a class="dropdown-item btn"
									href="${pageContext.request.contextPath}/LogOut"><i
									class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
							</c:if>
						</div>
					</div>
				</li>
				<li class="nav-item "><a class="nav-link btn btn-outline-light"
					href="#">Đặt ngay</a></li>
			</ul>
		</div>
	</div>
</nav>
