<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid container"
	style="margin-top: 10px; padding-left: 8rem; padding-right: -30rem;">
	<div class="card mb-4" style="margin-right: -120px;">
		<h2 style="text-align: center;">Quản lý đơn hàng</h2>
		<div class="form-inline">
			<div class="form-inline" style="margin-left: 20px;">
				<label>Tra cứu đơn hàng</label>
				<input class="btn nav-item" type="text"
					style="margin-left: 20px; height: 40px; width: 200px; border: 1px solid rgba(0, 0, 0, 0.15);"
					placeholder="Tìm kiếm mã đơn hàng" />
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit"
						style="height: 40px; width: 50px; margin-left: 10px;">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
			<div class="form-inline" style="margin-left: 100px;">
				<input type="radio" id="" name="radio" value=""> 
				<label for="male">Thời gian đặt</label>
				<input style="margin-left: 50px;" type="radio" id="" name="radio" value=""> 
				<label for="female">Thời gian chụp dự kiến</label>
			</div>
		</div>
		<div class="form-inline">
			<c:if test="${role ==1}">
				<div class="form-inline"
					style="margin-bottom: 20px; margin-top: 20px; margin-left: 10px;">
					<select name="cars" id="cars" class="btn btn-outline-dark"
						onchange="validateSelectBox(this)" style="width: 200px;">
						<option value="2">Tất cả trạng thái</option>
						<option value="3">Hoàn thành</option>
						<option value="3">Chưa hoàn thành</option>
					</select>
				</div>
				<div class="form-inline"
					style="margin-bottom: 20px; margin-top: 20px; margin-left: 10px;">
					<select name="cars" id="cars" class="btn btn-outline-dark"
						onchange="validateSelectBox(this)" style="width: 200px;">
						<option value="2">Trạng thái tiền cọc</option>
						<option value="3">Đã gửi</option>
						<option value="3">Chưa gửi</option>
					</select>
				</div>
			</c:if>
			<div class="form-inline">
				<label for="birthday" style="margin-left: 100px;">Từ:</label> <input
					type="date" id="birthday1" name="birthday"
					style="height: 40px; width: 150px; border-radius: 5px; margin-left: 5px;">
				<label for="birthday" style="margin-left: 20px;">Đến:</label> <input
					type="date" id="birthday2" name="birthday"
					style="height: 40px; width: 150px; border-radius: 5px; margin-left: 5px;">
			</div>
			<button id="changerole" class="btn btn-info"
				style="margin-left: 10px;">Lọc</button>

		</div>
		<div class="tab-content"
			style="margin-left: 0.5rem; margin-right: 0.5rem;"></div>
		<div id="baiviet" class="tab-pane <c:if test="">active </c:if>">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead style="background-color: #3385ff;">
					<tr>
						<th style="color: white; text-align: center;">ID đơn hàng</th>
						<th style="color: white; text-align: center;">Khách đặt hàng</th>
						<th style="color: white; text-align: center;">ID gói dịch vụ</th>
						<th style="color: white; text-align: center;">Nhiếp ảnh gia</th>
						<th style="color: white; text-align: center; vertical-align: top;">Thời gian đặt</th>
						<th style="color: white; text-align: center;">Thời gian dự kiến</th>
						<th style="color: white; text-align: center;">Thời gian hoàn thành</th>
						<th style="color: white; text-align: center;">Trạng thái đơn</th>
						<th style="color: white; text-align: center;">Trạng thái cọc</th>
				</thead>
				<thead style="font-weight: normal;">
					<tr>
						<th style="vertical-align: top;">00001998</th>
						<th style="vertical-align: top;">LocBN</th>
						<th style="vertical-align: top;">001</th>
						<th style="vertical-align: top;">Dũng</th>
						<th>17h 19/02/2021</th>
						<th style="vertical-align: top;">2 ngày</th>
						<th style="vertical-align: top;">21/02/2021</th>
						<th style="vertical-align: top;">Đang xử lý</th>
						<th style="vertical-align: top;">Đã gửi</th>
					</tr>
					<tr>
						<th style="vertical-align: top;">00001998</th>
						<th style="vertical-align: top;">LocBN</th>
						<th style="vertical-align: top;">001</th>
						<th style="vertical-align: top;">Dũng</th>
						<th>17h 19/02/2021</th>
						<th style="vertical-align: top;">2 ngày</th>
						<th style="vertical-align: top;">21/02/2021</th>
						<th style="vertical-align: top;">Đang xử lý</th>
						<th style="vertical-align: top;">Đã gửi</th>
					</tr>
					<tr>
						<th style="vertical-align: top;">00001998</th>
						<th style="vertical-align: top;">LocBN</th>
						<th style="vertical-align: top;">001</th>
						<th style="vertical-align: top;">Dũng</th>
						<th>17h 19/02/2021</th>
						<th style="vertical-align: top;">2 ngày</th>
						<th style="vertical-align: top;">21/02/2021</th>
						<th style="vertical-align: top;">Đang xử lý</th>
						<th style="vertical-align: top;">Đã gửi</th>
					</tr>
					<tr>
						<th style="vertical-align: top;">00001998</th>
						<th style="vertical-align: top;">LocBN</th>
						<th style="vertical-align: top;">001</th>
						<th style="vertical-align: top;">Dũng</th>
						<th>17h 19/02/2021</th>
						<th style="vertical-align: top;">2 ngày</th>
						<th style="vertical-align: top;">21/02/2021</th>
						<th style="vertical-align: top;">Đang xử lý</th>
						<th style="vertical-align: top;">Đã gửi</th>
					</tr>
					<tr>
						<th style="vertical-align: top;">00001998</th>
						<th style="vertical-align: top;">LocBN</th>
						<th style="vertical-align: top;">001</th>
						<th style="vertical-align: top;">Dũng</th>
						<th>17h 19/02/2021</th>
						<th style="vertical-align: top;">2 ngày</th>
						<th style="vertical-align: top;">21/02/2021</th>
						<th style="vertical-align: top;">Đang xử lý</th>
						<th style="vertical-align: top;">Đã gửi</th>
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
