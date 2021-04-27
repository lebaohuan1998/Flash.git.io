<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="layoutSidenav">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">

					<c:if test="${role==2}">
						<div class="sb-sidenav-menu-heading">Admin Opera management</div>
						<a class="nav-link collapsed quanly-1" href="#" data-toggle="collapse"
							data-target="#menu6">
							<div class="sb-nav-link-icon"></div> Quản lý người dùng
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<div class="quanly1" id="menu6" data-parent="#sidenavAccordion" >
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Employee">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Danh sách nhân viên</span>
								</a> <a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Verification"> 
									<i class="fa fa-plus" aria-hidden="true"></i><span
									class="pl-1"></span> <span class="pl-1">Xác minh photographer</span>
								</a>
							</nav>
						</div>
						<a class="nav-link collapsed quanly-2" href="#" data-toggle="collapse"
							data-target="#menu7">
							<div class="sb-nav-link-icon"></div> Quản lý gói dịch vụ
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<div class="quanly2" id="menu7" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=ServicePackage">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Xem tất cả gói dịch vụ</span>
								</a>
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Image">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Xem tất cả ảnh của gói dịch vụ</span>
								</a>
							</nav>
						</div>
						<a class="nav-link collapsed quanly-3" href="#" data-toggle="collapse"
							data-target="#menu8">
							<div class="sb-nav-link-icon"></div> Quản lý bài viết
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<div class="quanly3" id="menu8" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Article">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Xem tất cả bài viết</span>
								</a>
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Comment">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Xem tất cả bình luận</span>
								</a>
							</nav>
						</div>
						<a class="nav-link collapsed quanly-4" href="#" data-toggle="collapse"
							data-target="#menu9">
							<div class="sb-nav-link-icon"></div> Quản lý đơn hàng
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<div class="quanly4" id="menu9" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=BookingStatus">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Quản lý trạng thái đơn hàng</span>
								</a>
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Booking">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Quản lý đơn hàng</span>
								</a>
							</nav>
						</div>
						<a class="nav-link collapsed quanly-5" href="#" data-toggle="collapse"
							data-target="#menu10">
							<div class="sb-nav-link-icon"></div>Quản lý khiếu nại - phản hồi
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<div class="quanly5" id="menu10" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Feedback">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Xem tất cả các phản hồi</span>
								</a>
							</nav>
						</div>
						<a class="nav-link collapsed quanly-6" href="#" data-toggle="collapse"
							data-target="#menu11">
							<div class="sb-nav-link-icon"></div>Quản lý hệ thống
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<div class=" quanly6" id="menu11" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Maintenance">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Trạng thái hoạt động</span>
								</a>
							</nav>
						</div>
					</c:if>
					<c:if test="${role==1}">
						<div class="sb-sidenav-menu-heading">Admin managerment</div>
						<a class="nav-link collapsed" href="#" data-toggle="collapse"
							data-target="#menu6">
							<div class="sb-nav-link-icon"></div> Quản lý
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="menu6" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminSystem?cmd=Employee">
									<i class="fa fa-plus" aria-hidden="true"></i> <span
									class="pl-1"></span> <span class="pl-1">Danh sách nhân viên</span>
								</a> <a class="nav-link"
									href="${pageContext.request.contextPath}/ManagermentAdminSystem?cmd=Maintenance"> <i
									class="fa fa-list" aria-hidden="true"></i><span
									class="pl-1"></span> <span class="pl-1">Bảo Trì</span>
								</a>
							</nav>
						</div>
						
					</c:if>
				</div>
			</div>
		</nav>
	</div>
	
	<script type="text/javascript">
	$('document').ready(function () {
		$(".quanly1").hide();
		$(".quanly2").hide();
		$(".quanly3").hide();
		$(".quanly4").hide();
		$(".quanly5").hide();
		$(".quanly6").hide();
		
	})
	$(".quanly-1").click(function () {
		$(".quanly1").show();
	})
	$(".quanly-2").click(function () {
		$(".quanly1").hide();
		$(".quanly2").show();
	})
	$(".quanly-3").click(function () {
		$(".quanly2").hide();
		$(".quanly3").show();
	})
	$(".quanly-4").click(function () {
		$(".quanly3").hide();
		$(".quanly4").show();
	})
	$(".quanly-5").click(function () {
		$(".quanly4").hide();
		$(".quanly5").show();
	})
	$(".quanly-6").click(function () {
		$(".quanly5").hide();
		$(".quanly6").show();
	})
	</script>