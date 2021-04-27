<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-fluid col-9 form-block" style="padding-top: 0px;">
	<!-- <div class=" justify-content-center half"> -->
	<div class="col-md-12">
		<div class="form-block3 mx-auto border">
			<div class="input-group"
				style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); height: 130px; margin-bottom: 20px;">
				<div class=" ">
					<div style="border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
						<h2 class="container mx-auto">Lọc gói theo thể loại</h2>
					</div>
					<br>
					<form id="tao_sua-form" class="form "
						action="${pageContext.request.contextPath}/GoiDichVuLichBan?flag=3&command=SEARCH"
						method="post">
						<div class="input-group">
							<div class="col-7 ">
								<select class="form-control" name="theloaichup"
									id="selectioncategory">
									<option ${theloai=='0'? 'selected="selected"' : ''} value="0">Tất
											cả thể loại</option>
									<c:forEach items="${listC}" var="list">
										<option  ${list.categoryId==theloai? 'selected="selected"' : ''} value="${list.categoryId }">${list.categoryName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="">
								<button class="btn btn-outline-dark ">
									Tìm Kiếm <i class="fa fa-search"></i>
								</button>
							</div>

						</div>
					</form>
					<br> <br>

				</div>

				<!-- lich ban -->
				<div class="" style="margin-left: 50px;">
					<div class="" style="border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
						<h2 class="container mx-auto">Thêm Lịch Làm Việc</h2>
					</div>
					<br>
					<div class="input-group">
						<div class="mr-3" style="margin-left: 15px;">
							<input type="date" class=" form-control" id="scheduleDate"
								name="scheduleDate" style="height: calc(2.25rem + 2px);" max="2100-12-31" min="1900-12-31">
						</div>
						<div class="">
							<button id="btnaddlichban" class="btn btn-info collapse">Thêm
								lịch làm việc</button>
						</div>
					</div>
				</div>


			</div>
			<!-- load albums -->

			<%@ include file="loadalbumsphoto.jsp"%>

			<!-- end -->

			<!-- </div> -->
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:forEach items="${page}" var="list">
						<li class="page-item"><a
							class="page-link <c:if test="${param.page ==list}">text-white bg-dark</c:if> <c:if test="${param.page ==null&&list==1}">text-white bg-dark</c:if>"
							href="${pageContext.request.contextPath}/GoiDichVuLichBan?flag=3&page=${list}<c:if test="${theloai !=null}">&categoryId=${theloai}</c:if>">${list}</a></li>
					</c:forEach>
				</ul>
			</nav>
			<br>
			<div>
				<a
					href="${pageContext.request.contextPath}/TaoSuaGoiDichVu?flag=2&command=CREATE"
					class="btn btn-info ">Tạo</a>
				<button id="btnUpdate" type="button" class="btn btn-info collapse">Sửa</button>
				<button type="button" class="btn btn-info collapse " id="btndele"
					data-toggle="modal" data-target="#deleteModal1">Xóa</button>
				<div class="modal fade" id="deleteModal1" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Xóa Album</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">Bạn muốn xóa Album này?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Đóng</button>
								<button id="btnDelete" type="button" class="btn btn-primary">Xóa</button>
							</div>
						</div>
					</div>
				</div>
				<button id="btnhideshow" class="btn btn-info collapse ">Ẩn/hiện</button>

				<button type="button" id="btndeledate"
					class="btn btn-info collapse " data-toggle="modal"
					data-target="#deleteModal2">Xóa hết lịch bận</button>

				<div class="modal fade" id="deleteModal2" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Xóa Lịch Bận</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">Bạn muốn xóa tất cả lịch bận</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Đóng</button>
								<button id="btnDeleteAllDate" type="button"
									class="btn btn-primary">Xóa</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- </div> -->
</div>