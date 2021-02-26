<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="   border-top border-right col-3  bg-light form-block">
	<div class="">
		<c:if test="${role =='1'}">
			<a class="dropdown-item btn  "
				href="${pageContext.request.contextPath}/ProfileUser?flag=1">Thông
				Tin tài Khoản</a>
			<br>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/ProfileUser?flag=2">Album
				Yêu Thích</a>
			<br>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/ProfileUser?flag=3">Thợ
				Chụp Ảnh Yêu Thích</a>
			<br>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/ProfileUser?flag=4">Trang
				Chủ</a>
		</c:if>
		<c:if test="${role =='2'}">
			<a class="dropdown-item btn  "
				href="${pageContext.request.contextPath}/ProfilePhoto?flag=1">Thông
				Tin tài Khoản</a>
			<br>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/ProfilePhoto?flag=2">Tạo, sửa gói dịch vụ</a>
			<br>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/GoiDichVu_LichBan?flag=3">Gói dịch vụ- Lịch bận</a>
			<br>
			<a class="dropdown-item btn "
				href="${pageContext.request.contextPath}/ProfilePhoto?flag=4">Trang
				Chủ</a>
		</c:if>
	</div>
</div>