<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="public/js/jquery.popup.lightbox.js"></script>
<link href="public/css/popup-lightbox.css" rel="stylesheet" />
<div class="container-fluid container"
	<c:url var="APIurl" value="/ManagermentAdminOperator" />
	style="margin-top: 10px; padding-left: 8rem; padding-right: -30rem;">
	<div class="card mb-4" style="margin-right: -120px;">
		<h2 style="text-align: center;">Xác minh thông tin thợ ảnh</h2>
		<div class="form-inline">
			<c:if test="${role == 2}">
				<div class="form-inline"
					style="margin-bottom: 20px; margin-top: 20px; margin-left: 10px;">
					<select name="status" id="status" class="btn btn-outline-dark"
						onchange="validateSelectBox(this)">
						<option ${status==1? 'selected="selected"' : ''} value="1">Tất
							cả</option>
						<option ${status==2? 'selected="selected"' : ''} value="2">Chờ
							xác minh thông tin</option>
						<option ${status==3? 'selected="selected"' : ''} value="3">Đã
							xác minh thông tin</option>
					</select>

				</div>
			</c:if>
			<form action="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Search" method="POST">
				<div class="form-inline" style="margin-left: 400px;">
					<input name ="txtsearch" class="btn nav-item" type="text"
						style="height: 46px; width: 200px; border: 1px solid rgba(0, 0, 0, 0.15);"
						placeholder="tìm kiếm photographer" />
					<div class="input-group-append">
						<button class="btn btn-primary" type="submit"
							style="height: 46px; width: 50px;">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>

		<div class="tab-content"
			style="margin-left: 0.5rem; margin-right: 0.5rem;"></div>
		<div id="nhiepanhgia" class="tab-pane <c:if test="">active</c:if>">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead style="background-color: #007bff;">
					<tr>
						<th style="color: white; text-align: center;">id</th>
						<th style="color: white; text-align: center;">Tên CCCD</th>
						<th style="color: white; text-align: center;">Số CCCD</th>
						<th style="color: white; text-align: center;">Địa chỉ CCCD</th>
						<th style="color: white; text-align: center;">Trạng thái</th>
						<th style="color: white; text-align: center;">Ảnh</th>
						<th style="color: white; text-align: center;">Xác minh</th>
						<th style="color: white; text-align: center;">Xác minh bởi</th>
					</tr>
				</thead>
				<c:forEach items="${listPhoto1}" var="list">
					<thead style="font-weight: normal;">
						<tr>
							<th>${list.id}</th>
							<th>${list.fullName}</th>
							<th>${list.identityCardNumber}</th>
							<th>${list.addressOfId}</th>
							<th>${list.gender}</th>
							<th style="cursor: pointer;"><span target="blank"
								onclick="document.getElementById('id02_admin${list.id}').style.display='block'">Link</span></th>
							<th><c:if test="${list.identityVerifyId !='3'}">
									<button id="yes" value="${list.id}|${id}"
										class="btn btn-success btn-sm mr-1" onclick="yidentity(this)">Có</button>
									<button id="no" value="${list.id}|${id}"
										class="btn btn-danger btn-sm" onclick="nidentity(this)">Không</button>
								</c:if> <c:if test="${list.identityVerifyId =='3'}">Hoàn thành</c:if></th>
							<th>${list.dateOfBirth}<div id="id02_admin${list.id}"
									class="modal" style="overflow: auto;">
									<form class="modal-content animate" style="width: 80%;">
										<div style="padding: 30px 30px;" class="input-group">
											<div class="col-4">
												<img class="img-fluid"
													src="images/${list.id}4/idcard/${list.frontPhoto}"
													style="width: 100%;" /><br> <span class="text-center">Mặt
													sau</span>
											</div>
											<div class="col-4">
												<img class="img-fluid"
													src="images/${list.id}4/idcard/${list.backPhoto}"
													style="width: 100%;" /><br> <span class="text-center">Mặt
													sau</span>
											</div>
											<div class="col-4">
												<img class="img-fluid"
													src="images/${list.id}4/idcard/${list.fullPhoto}"
													style="width: 100%;" /><br> <span class="text-center">Mặt
													sau</span>
											</div>
										</div>

										<span
											onclick="document.getElementById('id02_admin${list.id}').style.display='none'"
											class="close" title="Close Modal">&times;</span>

									</form>
								</div></th>
						</tr>

					</thead>

				</c:forEach>

			</table>

			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:forEach items="${listPage}" var="list">
						<li class="page-item"><a
							class="page-link <c:if test="${param.page ==list+1}">text-white bg-dark</c:if><c:if test="${param.page ==null&&list==0}">text-white bg-dark</c:if>"
							href="${pageContext.request.contextPath}/ManagermentAdminOperator?cmd=Verification&page=${list+1}&status=${status}&textSearch=">${list+1}</a></li>
					</c:forEach>
				</ul>
			</nav>

		</div>
	</div>
</div>
<script type="text/javascript">
	var modal = document.getElementById('id01_admin');
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	$(document).ready(function() {
		$(".img-container1").popupLightbox({
			width : 700,
			height : 500
		});
	});
</script>
<script type="text/javascript">
	function validateSelectBox(obj) {
		var status = document.getElementById('status').value;
		console.log(status);
		$.ajax({
			url : '${APIurl}?cmd=Verification',
			type : 'GET',
			contentType : 'application/json',
			data : {
				status : status,
			},
			success : function(result) {
				window.location.href = "${APIurl}?cmd=Verification";
			},
			error : function(error) {
				console.log(error);
			}
		});
	}
</script>
<script type="text/javascript">
	function yidentity(obj) {
		console.log("huan");
		var status = obj.value;
		console.log(status);
		var splitted = status.split("|", 2);
		$.ajax({
			url : '${APIurl}?cmd=YIDENTITY',
			type : 'GET',
			contentType : 'application/json',
			data : {
				idPhotographer : splitted[0],
				idAdmin : splitted[1]
			},
			success : function(result) {
				window.location.reload();
			},
			error : function(error) {
				console.log(error);
			}
		});
	}
	function nidentity(obj) {
		console.log("huan");
		var status = obj.value;
		console.log(status);
		var splitted = status.split("|", 2);
		$.ajax({
			url : '${APIurl}?cmd=NIDENTITY',
			type : 'GET',
			contentType : 'application/json',
			data : {
				idPhotographer : splitted[0],
				idAdmin : splitted[1]
			},
			success : function(result) {
				window.location.reload();
			},
			error : function(error) {
				console.log(error);
			}
		});
	}
</script>

