<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-3 form-block"
	style="max-width: 23%;padding-top: 30px; border: 1px solid rgba(0, 0, 0, 0.15);">
	<div class="">
		<h1
			style="font-size: 24px; font-weight: 700; line-height: 29px; padding-bottom: 10px; border-bottom: 1px solid rgba(0, 0, 0, 0.15);">Danh
			mục</h1>
		<c:if test="${role =='3'||role =='2'}">
			<div style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 10px;">
				<a class="dropdown-item btn  "
					href="${pageContext.request.contextPath}/ProfileUser?flag=1">Thông
					Tin tài Khoản</a>
			</div>
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn "
					href="${pageContext.request.contextPath}/followServicePackage?flag=2">Gói
					chụp Yêu Thích</a>
			</div>
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn "
					href="${pageContext.request.contextPath}/followPhotographer?flag=3">Thợ
					Chụp Ảnh Yêu Thích</a>
			</div>
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn "
					href="${pageContext.request.contextPath}/manageBooking?flag=4">Quản
					lý đặt chụp</a>
			</div>
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn "
					href="${pageContext.request.contextPath}/ManageNotification?flag=5">Thông báo của tôi</a>
			</div>

		</c:if>
		<c:if test="${role =='4'}">
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn  "
					href="${pageContext.request.contextPath}/ProfilePhoto?flag=1">Cập
					nhập hồ sơ & tài Khoản</a>
			</div>
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn "
					href="${pageContext.request.contextPath}/GoiDichVuLichBan?flag=3">Quản
					lý Gói dịch vụ</a>
			</div>
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn "
					href="${pageContext.request.contextPath}/DescribePhotographer?flag=5">Mô
					tả thợ ảnh</a>
			</div>
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn "
					href="${pageContext.request.contextPath}/ManageBookingPhotographer?flag=6">Quản lý gói chụp
					tả thợ ảnh</a>
			</div>
			<div style="font-size: 24px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); font-weight: 700; padding-bottom: 20px; padding-top: 20px;">
				<a class="dropdown-item btn "
					href="${pageContext.request.contextPath}/ManageNotificationPhotographer?flag=7">Thông báo của tôi</a>
			</div>
		</c:if>
	</div>
</div>