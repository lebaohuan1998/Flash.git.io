<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="bg-dark text-lg-start foot">
	<div class="container p-4 ctn">
		<div class="row">
			<div class="col-sm-4 mb-md-0 cot1">
				<h5 class="text-uppercase text-white" style="font-size: 13px;">Hỗ
					trợ khách hàng</h5>

				<ul class="list-unstyled ">

					<div class="form-group mb-0">
						<a href="#!" class="text-white">Các câu hỏi thường gặp</a>
					</div>
					<li><a href="#!" class="text-white">Hỗ trợ khách hàng:
							hotro@flash.vn</a></li>

				</ul>
			</div>

			<div class="col-sm-3 mb-md-0 cot1">
				<h5 class="text-uppercase text-white" style="font-size: 13px;">Về
					Flash</h5>

				<ul class="list-unstyled mb-0">
					<li><a href="${pageContext.request.contextPath}/gioithieu" class="text-white">Giới thiệu Flash-dịch vụ nhiếp ảnh</a></li>
					<li><a href="#!" class="text-white">Chính sách bảo mật
							thanh toán</a></li>
					<li><a href="#!" class="text-white">Chính sách giải quyết
							khiếu nại</a></li>
					<li><a href="#!" class="text-white">Điều khoản sử dụng</a></li>
				</ul>
			</div>
			<!--Grid column-->

			<!--Grid column-->
			<div class="col-sm-3 mb-md-0 cot1">
				<h5 class="text-uppercase text-white " style="font-size: 13px;">Hợp
					tác và liên kết</h5>
			</div>

			<div class="col-sm-2 mb-md-0 cot1">
				<h5 class="text-uppercase text-white" style="font-size: 13px;">Phương
					thức thanh toán</h5>

				<div class="form-row">
					<div class="form-group col-sm-4 ">
						<i class="fab fa-cc-visa" style="font-size: 40px; color: white;"></i>
					</div>
					<div class="form-group col-sm-4">
						<i class="fab fa-cc-paypal" style="font-size: 40px; color: white;"></i>
					</div>
					<div class="form-group col-sm-4">
						<i class="fab fa-cc-discover"
							style="font-size: 40px; color: white;"></i>
					</div>
				</div>

			</div>

			<div class="col-sm-10 mb-md-0 cot1"></div>
			<div class="col-sm-4 mb-md-0 cot1">


				<div class="form-group text-white">
					<span> Địa chỉ văn phòng:<br>Đại học FPT-Khu Công Nghệ
						Cao Hòa Lạc<br>

					</span>
				</div>
			</div>
		</div>
	</div>

</footer>
<script type="text/javascript">
	function toggle() {

		var counter = 0;
		var NotificationBadge = document.getElementById('NotificationBadge');
		if (NotificationBadge.style.display == "block") {
			NotificationBadge.style.display = "block";
		} else {
			NotificationBadge.style.display = "none";
		}

		$
				.ajax({

					url : 'ManageNotificationPhotographer?command=ReLoad',
					type : "GET",
					datatype : "html",
					data : {
						id1 : counter,

					},
					success : function(data) {
						var tempDiv = $("<div/>");
						tempDiv.append(data);
						var myValue = tempDiv.find("input[name='tu']").val();
						var a = parseInt(myValue);
						if (a != 0) {

							if (NotificationBadge.style.display == "none") {
								NotificationBadge.style.display = "block";
								localStorage.setItem('show', 'true');
							} else {
								NotificationBadge.style.display = "block";
								localStorage.setItem('show', 'true');
							}
						}
						if (a == 0) {

							if (NotificationBadge.style.display == "block") {
								NotificationBadge.style.display = "none";
								localStorage.setItem('show', 'false');
							} else {
								NotificationBadge.style.display = "none";
								localStorage.setItem('show', 'false');
							}
						}

						if (a > 9) {
							myValue = '9+';
						}
						//document.getElementById("NotificationBadge").innerHTML =myValue;
						document.getElementById("NotificationBadge").innerHTML = myValue;

						return data;

					},
					error : function(error) {
						alert("Đã lâu bạn không hoạt động.Vui lònng tải lại trang");
					}
				});

	}
</script>

<script type="text/javascript">
	var interval = 5000; // 1000 = 1 second, 3000 = 3 seconds
	function doAjax() {
		$
				.ajax({
					type : 'GET',
					url : 'ManageNotificationPhotographer?command=ReLoad',
					data : $(this).serialize(),
					dataType : 'html',
					success : function(data) {
						var tempDiv = $("<div/>");
						tempDiv.append(data);
						var myValue = tempDiv.find("input[name='tu']").val();
						var a = parseInt(myValue);
						if (a != 0) {

							if (NotificationBadge.style.display == "none") {
								NotificationBadge.style.display = "block";
								localStorage.setItem('show', 'true');
							} else {
								NotificationBadge.style.display = "block";
								localStorage.setItem('show', 'true');
							}
						}
						if (a == 0) {

							if (NotificationBadge.style.display == "block") {
								NotificationBadge.style.display = "none";
								localStorage.setItem('show', 'false');
							} else {
								NotificationBadge.style.display = "none";
								localStorage.setItem('show', 'false');
							}
						}

						if (a > 9) {
							myValue = '9+';
						}
						document.getElementById("NotificationBadge").innerHTML = myValue;
						return data;
					},
					complete : function(data) {
						// Schedule the next
						setTimeout(doAjax, interval);
					}
				});
	}
	setTimeout(doAjax, interval);
</script>


<script type="text/javascript">
	function loadByUser() {

		var counter = 0;
		var NotificationBadge = document.getElementById('NotificationBadge');
		//         if(NotificationBadge.style.display == "block"){
		//       	NotificationBadge.style.display= "block";
		//         }
		//       	else {
		//          	NotificationBadge.style.display = "none";
		//         }

		$
				.ajax({

					url : 'ManageNotification?command=ReLoad',
					type : "GET",
					datatype : "html",
					data : {
						id1 : counter,

					},
					success : function(data) {
						var tempDiv = $("<div/>");
						tempDiv.append(data);
						var myValue = tempDiv.find("input[name='tu']").val();
						var a = parseInt(myValue);
						if (a != 0) {

							if (NotificationBadge.style.display == "none") {
								NotificationBadge.style.display = "block";
								localStorage.setItem('show', 'true');
							} else {
								NotificationBadge.style.display = "block";
								localStorage.setItem('show', 'true');
							}
						}
						if (a == 0) {

							if (NotificationBadge.style.display == "block") {
								NotificationBadge.style.display = "none";
								localStorage.setItem('show', 'false');
							} else {
								NotificationBadge.style.display = "none";
								localStorage.setItem('show', 'false');
							}
						}

						if (a > 9) {
							myValue = '9+';
						}

						document.getElementById("NotificationBadge").innerHTML = myValue;

						return data;

					},
					error : function(error) {
						alert("Đã lâu bạn không hoạt động.Vui lòng tải lại trang");
					}
				});

	}
</script>


<script>
	$(document).ready(function() {
		var show = localStorage.getItem('show');
		if (show === 'true') {
			$('#NotificationBadge').show();
		}
		if (show === 'false') {
			$('#NotificationBadge').hide();
		}

	});
</script>

<script type="text/javascript">
	var interval = 5000; // 1000 = 1 second, 3000 = 3 seconds
	function doAjax() {
		$
				.ajax({
					type : 'GET',
					url : 'ManageNotification?command=ReLoad',
					data : $(this).serialize(),
					dataType : 'html',
					success : function(data) {
						var tempDiv = $("<div/>");
						tempDiv.append(data);
						var myValue = tempDiv.find("input[name='tu']").val();
						var a = parseInt(myValue);
						if (a != 0) {

							if (NotificationBadge.style.display == "none") {
								NotificationBadge.style.display = "block";
								localStorage.setItem('show', 'true');
							} else {
								NotificationBadge.style.display = "block";
								localStorage.setItem('show', 'true');
							}
						}
						if (a == 0) {

							if (NotificationBadge.style.display == "block") {
								NotificationBadge.style.display = "none";
								localStorage.setItem('show', 'false');
							} else {
								NotificationBadge.style.display = "none";
								localStorage.setItem('show', 'false');
							}
						}

						if (a > 9) {
							myValue = '9+';
						}
						document.getElementById("NotificationBadge").innerHTML = myValue;
						return data;
					},
					complete : function(data) {
						// Schedule the next
						setTimeout(doAjax, interval);
					}
				});
	}
	setTimeout(doAjax, interval);
</script>