<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid container"
	style="margin-top: 10px; padding-left: 8rem; padding-right: -30rem;">
	<div class="card mb-4" style="margin-right: -120px;">
		<h2 style="text-align: center;">Quản lý bài viết</h2>
		<div class="form-inline">
			<ul class="nav nav-tabs"
				style="margin-top: 20px; border-bottom: 1px solid #dee2e6;; color: black;">
				<li class="nav-item"><a
					class=" nav-link <c:if test="${show =='3'||show ==null}">active</c:if>"
					data-toggle="tab" href="#tatcabaiviet" style="margin-right: 10px;"><b>Tất
							cả (5)</b></a></li>
				<li class="nav-item"><a
					class=" nav-link <c:if test="${show =='1'}">active</c:if>"
					data-toggle="tab" href="#baivietkhoa" style="margin-right: 10px;"><b>Đã
							khoá (0)</b></a></li>
			</ul>
			<div class="form-inline"
				style="margin-left: 470px; margin-top: 20px;">
				<input class="btn nav-item" type="text"
					style="height: 40px; width: 150px; border: 1px solid rgba(0, 0, 0, 0.15);"
					placeholder="Tìm kiếm bài viết" />
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit"
						style="height: 40px; width: 50px; margin-left: 10px;">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="form-inline">
			<c:if test="${role ==1}">
				<div class="form-inline"
					style="margin-bottom: 20px; margin-top: 20px; margin-left: 10px;">
					<select name="cars" id="cars" class="btn btn-outline-dark"
						onchange="validateSelectBox(this)" style="width: 150px;">
						<option value="2">Hiện</option>
						<option value="3">Ẩn</option>
						<option value="4">Xoá</option>
					</select>
					<button id="changerole" class="btn btn-info"
						style="margin-left: 10px;">Áp dụng</button>
				</div>
			</c:if>
			<div class="form-inline">
				<label for="birthday" style="margin-left: 20px;">Từ:</label> <input
					type="date" id="birthday1" name="birthday"
					style="height: 40px; width: 150px; border-radius: 5px; margin-left: 5px;">
				<label for="birthday" style="margin-left: 20px;">Đến:</label> <input
					type="date" id="birthday2" name="birthday"
					style="height: 40px; width: 150px; border-radius: 5px; margin-left: 5px;">
			</div>
			<c:if test="${role == 1}">
				<div class="form-inline"
					style="margin-bottom: 20px; margin-top: 20px; margin-left: 40px;">
					<select name="cars" id="cars" class="btn btn-outline-dark"
						onchange="validateSelectBox(this)">
						<option value="2">Bài viết theo xu hướng</option>
						<option value="3">Bài viết theo địa điểm</option>
						<option value="4">Bài viết theo công nghệ</option>
						<option value="5">Bài viết theo thông tin</option>
						<option value="3">Nháp</option>
					</select>
					<button id="changerole" class="btn btn-info"
						style="margin-left: 10px;">Lọc</button>
				</div>
			</c:if>
		</div>
		<div class="tab-content"
			style="margin-left: 0.5rem; margin-right: 0.5rem;"></div>
		<div id="baiviet" class="tab-pane <c:if test="">active </c:if>">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead style="background-color: #3385ff;">
					<tr>
						<th style="color: white; text-align: center;">Chọn</th>
						<th style="color: white; text-align: center;">Tác giả</th>
						<th style="color: white; text-align: center;">Chuyên mục</th>
						<th style="color: white; text-align: center;">Thời gian</th>
					</tr>
				</thead>
				<thead style="font-weight: normal;">
					<tr>
						<th style="text-align: center;"><input type="checkbox" name="vechicle" value="" /></th>
						<th>Huân Rose</th>
						<th>(Địa điểm)Chùa Tam Chúc Hà Nam, thiên đường check in chốn
							tâm linh</th>
						<th>17/02/2021 lúc 10h30</th>
					</tr>
					<tr>
						<th style="text-align: center;"><input type="checkbox" name="vechicle" value="" /></th>
						<th>Huân Rose</th>
						<th>(Địa điểm)Chùa Tam Chúc Hà Nam, thiên đường check in chốn
							tâm linh</th>
						<th>17/02/2021 lúc 10h30</th>
					</tr>
					<tr>
						<th style="text-align: center;"><input type="checkbox" name="vechicle" value="" /></th>
						<th>Huân Rose</th>
						<th>(Địa điểm)Chùa Tam Chúc Hà Nam, thiên đường check in chốn
							tâm linh</th>
						<th>17/02/2021 lúc 10h30</th>
					</tr>
					<tr>
						<th style="text-align: center;"><input type="checkbox" name="vechicle" value="" /></th>
						<th>Huân Rose</th>
						<th>(Địa điểm)Chùa Tam Chúc Hà Nam, thiên đường check in chốn
							tâm linh</th>
						<th>17/02/2021 lúc 10h30</th>
					</tr>
					<tr>
						<th style="text-align: center;"><input type="checkbox" name="vechicle" value="" /></th>
						<th>Huân Rose</th>
						<th>(Địa điểm)Chùa Tam Chúc Hà Nam, thiên đường check in chốn
							tâm linh</th>
						<th>17/02/2021 lúc 10h30</th>
					</tr>
				</thead>
			</table>

			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link btn-outline-dark"
						href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
</div>
