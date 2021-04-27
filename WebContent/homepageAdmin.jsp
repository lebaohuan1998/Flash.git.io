<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="public/js/jquery.min.js"></script>
<script src="public/js/jquery.js"></script>
<!---->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="public/css/danhgiaalbum.css">
<link rel="stylesheet" href="public/css/xemanhgoidichvu_admin.css">
<link rel="stylesheet" href="public/css/csshomepage.css">
<%@ include file="form/include/header.jsp"%>
<%@ include file="form/include/sidebarAdmin.jsp"%>

<c:url var="APIurl" value="/ManagermentAdminSystem" />
<c:if test="${not empty param.message}">
	<span class="row alert alert-danger"> ${param.message} </span>
</c:if>
<c:if test="${not empty param.success}">
	<span class="row alert alert-success"> ${param.success} </span>
</c:if>
<c:if
	test="${param.cmd =='Employee'||param.cmd ==null||param.cmd =='LOCKUSER'||param.cmd =='LOCKADMIN'||param.cmd =='LOCKPHOTO'}">
	<%@ include file="quanlynhanvien_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='Verification'}">
	<%@ include file="xacminhphoto_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='ServicePackage'}">
	<%@ include file="xemgoidichvu_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='Image'}">
	<%@ include file="xemanhgoidichvu_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='Article'}">
	<%@ include file="xembaiviet_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='Comment'}">
	<%@ include file="xembinhluan_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='BookingStatus'}">
	<%@ include file="quanlytrangthaidonhang_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='Booking'}">
	<%@ include file="quanlydonhang_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='Feedback'}">
	<%@ include file="quanlyphanhoivakhieunai_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='Maintenance'}">
	<%@ include file="quanlyhethong_admin.jsp"%>
</c:if>
<c:if test="${param.cmd =='InsertArticle'}">
	<%@ include file="thembaiviet_admin.jsp"%>
</c:if>
<!--footer-->
<script type="text/javascript">
	

	$("#changerole").click(function() {
		var dataArray = $('input[type=checkbox]:checked').map(function() {
			return $(this).val();
		}).get();
		var role = document.getElementById("managermentrole").value;
		console.log(dataArray);
		console.log(role);
		console.log("huan")
		if (dataArray.length == 0) {
			alert('Bạn cần phải chọn đối tượng');
		} else {
			$.ajax({
				url : '${APIurl}?cmd=ROLE',
				type : 'GET',
				contentType : 'application/json',
				data : {
					arr : JSON.stringify(dataArray),
					role : role
				},
				success : function(result) {
					window.location.reload();
				},
				error : function(error) {
					console.log(error);
				}
			});
		}

	});
</script>
<!--footer -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js "></script>
</head>

</html>