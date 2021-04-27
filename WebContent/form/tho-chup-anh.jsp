<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><c:if test="${param.flag =='1'}">
		Quản lý tài khoản
	</c:if> <c:if test="${param.flag =='3'}">
		Gói dịch vụ -Lịch bận
	</c:if><c:if test="${param.flag =='4'}">
		Sửa gói dịch vụ
	</c:if> <c:if test="${param.flag =='2'}">
		Tạo gói dịch vụ
	</c:if> <c:if test="${param.flag =='5'}">
		Mô tả thợ ảnh
	</c:if>
	 <c:if test="${param.flag =='6'}">
		Đơn hàng
	</c:if></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script
	src="${pageContext.request.contextPath}/public/js/ckeditor/ckeditor.js"></script>
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<link rel="stylesheet" href="public/css/style.css">

<link rel="stylesheet" href="public/css/csshomepage.css">
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="public/css/dichvu_lichban.css">
<link rel="stylesheet" href="public/css/menuver2.css">
<link rel="stylesheet" href="public/css/danhgiaalbum.css">
<link rel="stylesheet" href="public/css/donhangdatchup_photo.css">
<style type="text/css">
#map {
	height: 400px;
	width: 460px;
}
</style>
</head>
<body>
	<c:url var="APIurl" value="/GoiDichVuLichBan" />
	<c:url var="APIurl1" value="/TaoSuaGoiDichVu" />
	<c:url var="APIurl2" value="/LocationGGMap" />
	<c:url var="APIurl3" value="/ProfilePhoto" />

	<%@ include file="include/navbar.jsp"%>
	<div class="bg-light">
		<c:if test="${param.updateShow =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Bạn đã cập nhật thông tin.
			</div>
		</c:if>
		<c:if test="${param.updateInfo =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Bạn đã cập nhật thông tin.
			</div>
		</c:if>
		<c:if test="${param.updateInfor =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Bạn chưa cập nhật thành công thông
				tin cá nhân
			</div>
		</c:if>
		<c:if test="${param.updatecmt =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Bạn đã gửi ảnh xác minh, đợi chúng tôi
				xác minh.
			</div>
		</c:if>
		<c:if test="${param.updatecmt =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Bạn phải gửi đồng thời cả 3 ảnh để
				chúng tôi xác minh
			</div>
		</c:if>
		<c:if test="${param.err =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> bạn đã thay đổi mật khẩu.
			</div>
		</c:if>
		<c:if test="${param.errdupplicate =='true'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Mật khẩu mới không được trùng với
				mật khẩu cũ.
			</div>
		</c:if>
		<c:if test="${param.err =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Sai mật khẩu.
			</div>
		</c:if>
		<c:if test="${param.updatealbum =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Bạn đã thêm 1 album mới.
			</div>
		</c:if>
		<c:if test="${param.updatealbum1 =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Bạn đã cập nhật thông tin thành công.
			</div>
		</c:if>
		<c:if test="${param.messdelete =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Bạn đã xóa 1 ảnh trong album.
			</div>
		</c:if>
		<c:if test="${param.delete =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Bạn đã xóa album.
			</div>
		</c:if>
		<c:if test="${param.messupdatecoverimage =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Thay đổi ảnh bìa thành công.
			</div>
		</c:if>
		<c:if test="${param.deletedate =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Xóa thành công ngày bận
			</div>
		</c:if>
		<c:if test="${param.deleAllDate =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Xóa thành công tất cả các ngày bận
			</div>
		</c:if>
		<c:if test="${param.addDate =='true'}">
			<div class="alert alert-success in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Thành công!</strong> Thêm thành công lịch bận
			</div>
		</c:if>
		<c:if test="${param.addDateFuture =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Bạn phải chọn ngày trong tương lai
			</div>
		</c:if>
		<c:if test="${param.addDate =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Bạn chưa chọn ngày
			</div>
		</c:if>
		<c:if test="${param.duplicateName =='true'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Tên Album đã tồn tại
			</div>
		</c:if>
		<c:if test="${param.imageinalbum =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Album có tối thiểu 1 ảnh và tối đa
				20 ảnh
			</div>
		</c:if>
		<c:if test="${param.messdelete =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Xóa ảnh thất bại
			</div>
		</c:if>
		<c:if test="${param.messupdatecoverimage =='false'}">
			<div class="alert alert-warning">
				<strong>Không thành công</strong> Thay đổi ảnh bìa thất bại.
			</div>
		</c:if>

		<div class=" row container mx-auto ">

			<%@ include file="include/menuver2.jsp"%>
			<c:if test="${param.flag =='1'}">
				<%@ include file="quanlihoso-photo.jsp"%>
			</c:if>
			<c:if test="${param.flag =='2'}">
				<%@ include file="taovasuagoidichvu-photo.jsp"%>
			</c:if>
			<c:if test="${param.flag =='4'}">
				<%@ include file="suagoidichvu.jsp"%>
			</c:if>
			<c:if test="${param.flag =='3'}">
				<%@ include file="goidichvu-lichban-photo.jsp"%>
			</c:if>
			<c:if test="${param.flag =='5'}">
				<%@ include file="DescribePhotographer.jsp"%>
			</c:if>
			<c:if test="${param.flag =='6'}">
				<%@ include file="donhangdatchup_photo.jsp"%>
			</c:if>
			<c:if test="${param.flag =='7'}">
				<%@ include file="thongbao_photo.jsp"%>
			</c:if>
		</div>
		<br>
	</div>

	<%@ include file="include/footer.jsp"%>
	<script>
		$("#btnDelete").click(function() {
			var data = {};
			var dataArray = $('input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			$.ajax({
				url : '${APIurl}?command=DELETE',
				type : 'GET',
				contentType : 'application/json',
				data : {
					arr : JSON.stringify(dataArray)
				},
				success : function(result) {
					window.location.href = "${APIurl}?flag=3&delete=true";
				},
				error : function(error) {
					console.log(error);
				}
			});
		});

		$("#btnUpdate").click(function() {
			var data = {};
			var dataArray = $('input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			console.log(dataArray);
			$.ajax({
				url : '${APIurl1}?flag=4&command=SHOW',
				type : 'GET',
				contentType : 'application/json',
				data : {
					arr : JSON.stringify(dataArray)
				},
				success : function(result) {
					window.location.href = "${APIurl1}?flag=4&command=SHOW";
				},
				error : function(error) {
					console.log(error);
				}
			});
		});
		$("input[name='price']").on('input', function(e) {
			var number = $(this).val();
			console.log(number);
			$(this).val(formatCurrency(this.value.replace(/[.VNĐ]/g, '')));
		}).on('keypress', function(e) {
			if (!$.isNumeric(String.fromCharCode(e.which)))
				e.preventDefault();
		}).on('paste', function(e) {
			var cb = e.originalEvent.clipboardData || window.clipboardData;
			if (!$.isNumeric(cb.getData()))
				e.preventDefault();
		});
		function formatCurrency(number) {
			var n = number.split('').reverse().join("");
			var n2 = n.replace(/\d\d\d(?!$)/g, "$&.");
			return n2.split('').reverse().join('');
		}
		$("#btnaddlichban")
				.click(
						function() {
							var data = {};
							var dataArray = $('input[type=checkbox]:checked')
									.map(function() {
										return $(this).val();
									}).get();
							var lichban = document
									.getElementById("scheduleDate").value;
							console.log(dataArray);
							var today = new Date();
							var datetime = today.getFullYear() + '-'
									+ (today.getMonth() + 1) + '-'
									+ today.getDate();

							if (lichban == "") {
								window.location.href = "${APIurl}?flag=3&addDate=false";
							} else {
								if (parseDate(lichban).getTime() < parseDate(
										datetime).getTime()) {
									window.location.href = "${APIurl}?flag=3&addDateFuture=false";

								} else if (parseDate(lichban).getTime() >= parseDate(
										datetime).getTime()) {
									$
											.ajax({
												url : '${APIurl}?command=ADDDATE',
												type : 'GET',
												contentType : 'application/json',
												data : {
													arr : JSON
															.stringify(dataArray),
													scheduleDate : lichban
												},
												success : function(result) {
													window.location.href = "${APIurl}?flag=3&addDate=true";
												},
												error : function(error) {
													console.log(error);
												}
											});
								}

							}
						});
		function parseDate(str) {
			var mdy = str.split('-');
			return new Date(mdy[2], mdy[1], mdy[0]);
		}

		$("#btnhideshow").click(function() {
			var data = {};
			var dataArray = $('input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			$.ajax({
				url : '${APIurl}?command=HideShow',
				type : 'GET',
				contentType : 'application/json',
				data : {
					arr : JSON.stringify(dataArray),
				},
				success : function(result) {
					window.location.href = "${APIurl}?flag=3";
				},
				error : function(error) {
					console.log(error);
				}
			});
		});

		$("#btnDeleteAllDate").click(function() {
			var data = {};
			var dataArray = $('input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			console.log(dataArray);
			$.ajax({
				url : '${APIurl}?command=DELETEALLDATE',
				type : 'GET',
				contentType : 'application/json',
				data : {
					arr : JSON.stringify(dataArray),
				},
				success : function(result) {
					window.location.href = "${APIurl}?flag=3&deleAllDate=true";
				},
				error : function(error) {
					console.log(error);
				}
			});
		});

		$("input[name='tengoi']")
				.on(
						'input',
						function() {
							var c = this.selectionStart, r = /[^a-zA-ZaAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ0-9 ]/gi, v = $(
									this).val();
							if (r.test(v)) {
								$(this).val(v.replace(r, ''));
								c--;
							}
							this.setSelectionRange(c, c);
						});
		$("input[type=checkbox]:checked").click(function() {
			$("#btndeledate").hide();
		});
		$("input[type=checkbox]").click(function() {
			var dataArray = $('input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			console.log(dataArray);
			console.log(dataArray.length);
			if (dataArray.length > 0) {
				$("#btndeledate").show();
				$("#btnhideshow").show();
				$("#btndele").show();
				$("#btnUpdate").show();
				$("#btnaddlichban").show();
				if (dataArray.length > 1) {
					$("#btnUpdate").hide();
				}
			} else {
				$("#btndeledate").hide();
				$("#btnhideshow").hide();
				$("#btndele").hide();
				$("#btnUpdate").hide();
				$("#btnaddlichban").hide();
			}
		});
		function fileValidation() {
			var fileInput = document.getElementById('file');
			var filePath = fileInput.value;//lấy giá trị iyynput theo id
			var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;//các tập tin cho phép
			//Kiểm tra định dạng
			for (var i = 0; i < fileInput.files.length; i++) {
				console.log(fileInput.files[i].size);
				if(fileInput.files[i].size> 5*1024*1024){
					alert('Vui lòng không tải ảnh quá 5Mb');
					fileInput.value = '';
					return false;
				}else{
					if (!allowedExtensions.exec(fileInput.files[i].name)) {
						alert('Vui lòng chỉ tải ảnh lên');
						fileInput.value = '';
						return false;
					}
				}
				
			}
			
		}
		const inputElement = document.getElementById("file");
		var countImage = document.getElementById("countimage");
		if (countImage != null) {
			countImage = document.getElementById("countimage").value;
		}
		inputElement.addEventListener("change", handleFiles, false);
		function handleFiles() {
			const fileList = this.files; /* now you can work with the file list */
			if (countImage == null) {
				var x = Number(fileList.length);
			} else {
				var x = Number(fileList.length) + Number(countImage);
			}

			if (fileList.length > 20 || x > 20) {
				if(countImage==null){
					alert('Chỉ được tải lên tối đa 20 ảnh');
					inputElement.value = '';
				}else{
					alert('Chỉ được tải lên tối đa 20 ảnh, hiện tại đã có '
							+ countImage + ' ảnh');
					inputElement.value = '';
				}
				
				return false;
			}
		}
		function validateSelectBox(obj) {
			var price = document.getElementById("price").value;
			var arr = price.split(".");
			price = 0;
			for (var i = 0; i < arr.length; i++) {
				price = price + arr[i]
			}
			console.log(price);
			// Lấy danh sách các options
			var options = obj.children;
			// lặp qua từng option và kiểm tra thuộc tính selected
			for (var i = 0; i < options.length; i++) {
				if (options[i].selected) {
					console.log(options[i].value + "|" + price);
					var tiencoc = Number(price)
							* Number(options[i].value * 1000);
					var tiencocConvert = (parseInt(tiencoc / 1000)) * 1000;

					console.log(tiencocConvert);
					document.getElementById('tiencoc').innerHTML = tiencocConvert
							+ ".đ";
				}
			}
		}
	</script>
	<script
		src="${pageContext.request.contextPath}/public/js/validate/infophoto.js"></script>
	<script
		src="${pageContext.request.contextPath}/public/js/validate/goidichvu.js"></script>
</body>

</html>