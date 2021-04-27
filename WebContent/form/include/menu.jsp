<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="   border-top border-right col-3 border-info form-block">
	<div class="">
		<c:if test="${role =='3'||role =='2'}">
			<a class="dropdown-item btn  "
				href="${pageContext.request.contextPath}/ProfileUser?flag=1">Thông
				Tin tài Khoản</a>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/followServicePackage?flag=2">Gói
				chụp Yêu Thích</a>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/followPhotographer?flag=3">Thợ
				Chụp Ảnh Yêu Thích</a>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/booking?flag=4">Quản lý
				đặt chụp</a>

		</c:if>
		<c:if test="${role =='4'}">
			<a class="dropdown-item btn  "
				href="${pageContext.request.contextPath}/ProfilePhoto?flag=1">Cập
				nhập hồ sơ & tài Khoản</a>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/GoiDichVuLichBan?flag=3">Quản
				lý Gói dịch vụ</a>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/DescribePhotographer?flag=5">Mô
				tả thợ ảnh</a>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/ManageBookingPhotographer?flag=6">Quản
				lý gói chụp tả thợ ảnh</a>
		</c:if>
	</div>
</div>