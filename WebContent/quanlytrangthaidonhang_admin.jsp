<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid container"
	style="margin-top: 10px; padding-left: 8rem; padding-right: -30rem;">
	<div class="card mb-4" style="margin-right: -120px;">
		<h2 style="text-align: center;">Quản lý trạng thái đơn hàng</h2>
		<div class="form-inline">
			<c:if test="${role ==1}">
				<div class="form-inline"
					style="margin-bottom: 20px; margin-top: 20px; margin-left: 10px;">
					<select name="cars" id="cars" class="btn btn-outline-dark"
						onchange="validateSelectBox(this)"  style="width: 200px;">
						<option value="2">Trạng thái đơn hàng</option>
						<option value="3">Đã tiếp nhận</option>
						<option value="3">Chưa xử lý</option>
						<option value="4">Xử lý xong</option>
					</select>
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
			<button id="changerole" class="btn btn-info"
						style="margin-left: 10px;">Lọc</button>
			<div class="form-inline"
				style="margin-left: 100px;">
				<input class="btn nav-item" type="text"
					style="height: 40px; width: 180px; border: 1px solid rgba(0, 0, 0, 0.15);"
					placeholder="Tìm kiếm đơn hàng" />
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit"
						style="height: 40px; width: 50px; margin-left: 10px;">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="tab-content"
			style="margin-left: 0.5rem; margin-right: 0.5rem;"></div>
		<div id="baiviet" class="tab-pane <c:if test="">active </c:if>">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead style="background-color: #3385ff;">
					<tr>
						<th style="color: white; text-align: center;">ID đơn hàng</th>
						<th style="color: white; text-align: center;">Khách hàng</th>
						<th style="color: white; text-align: center;">Gói dịch vụ</th>
						<th style="color: white; text-align: center;">Tiền đặt cọc</th>
						<th style="color: white; text-align: center;">Tiền nhận cọc</th>
						<th style="color: white; text-align: center;">Thời gian tiếp nhận</th>
						<th style="color: white; text-align: center;">Thời gian xử lý</th>
						<th style="color: white; text-align: center;">Người tiếp nhận</th>
						<th style="color: white; text-align: center;">Trạng thái</th>
				</thead>
				<thead style="font-weight: normal;">
					<tr>
						<th style="vertical-align: top;">25081998</th>
						<th style="vertical-align: top;">locbnse</th>
						<th>Chụp ảnh cưới</th>
						<th>500.000 VNĐ</th>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="tiencoc" value="" /></th>
						<th style="vertical-align: top;">10h 20/02/2021</th>
						<th>10h 21/02/2021</th>
						<th style="vertical-align: top;">tunv</th>
						<th>Đang xử lý</th>
					</tr>
					<tr>
						<th style="vertical-align: top;">25081998</th>
						<th style="vertical-align: top;">locbnse</th>
						<th>Chụp ảnh cưới</th>
						<th>500.000 VNĐ</th>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="tiencoc" value="" /></th>
						<th style="vertical-align: top;">10h 20/02/2021</th>
						<th>10h 21/02/2021</th>
						<th style="vertical-align: top;">tunv</th>
						<th>Đang xử lý</th>
					</tr>
					<tr>
						<th style="vertical-align: top;">25081998</th>
						<th style="vertical-align: top;">locbnse</th>
						<th>Chụp ảnh cưới</th>
						<th>500.000 VNĐ</th>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="tiencoc" value="" /></th>
						<th style="vertical-align: top;">10h 20/02/2021</th>
						<th>10h 21/02/2021</th>
						<th style="vertical-align: top;">tunv</th>
						<th>Đang xử lý</th>
					</tr>
					<tr>
						<th style="vertical-align: top;">25081998</th>
						<th style="vertical-align: top;">locbnse</th>
						<th>Chụp ảnh cưới</th>
						<th>500.000 VNĐ</th>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="tiencoc" value="" /></th>
						<th style="vertical-align: top;">10h 20/02/2021</th>
						<th>10h 21/02/2021</th>
						<th style="vertical-align: top;">tunv</th>
						<th>Đang xử lý</th>
					</tr>
					<tr>
						<th style="vertical-align: top;">25081998</th>
						<th style="vertical-align: top;">locbnse</th>
						<th>Chụp ảnh cưới</th>
						<th>500.000 VNĐ</th>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="tiencoc" value="" /></th>
						<th style="vertical-align: top;">10h 20/02/2021</th>
						<th>10h 21/02/2021</th>
						<th style="vertical-align: top;">tunv</th>
						<th>Đang xử lý</th>
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
