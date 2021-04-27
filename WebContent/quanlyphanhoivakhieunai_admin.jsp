	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid container"
	style="margin-top: 10px; padding-left: 8rem; padding-right: -30rem;">
	<div class="card mb-4" style="margin-right: -120px;">
		<h2 style="text-align: center;">Quản lý phản hồi</h2>
		<div class="form-inline">
			<div class="form-inline" style="margin-bottom: 20px; margin-top: 20px; margin-left: 10px;">
				<input class="btn nav-item" type="text"
					style="height: 40px; width: 180px; border: 1px solid rgba(0, 0, 0, 0.15);"
					placeholder="Tìm kiếm phản hồi" />
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit"
						style="height: 40px; width: 50px; margin-left: 10px;">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
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
						<th style="color: white; text-align: center; vertical-align: top;">Xoá</th>
						<th style="color: white; text-align: center; vertical-align: top;">Tiêu đề</th>
						<th style="color: white; text-align: center; vertical-align: top;">Nội dung</th>
						<th style="color: white; text-align: center; vertical-align: top;">Người gửi</th>
						<th style="color: white; text-align: center; vertical-align: top;">Thời gian</th>
						<th style="color: white; text-align: center; vertical-align: top;">Trạng thái</th>
				</thead>
				<thead style="font-weight: normal;">
					<tr>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="vechicle" value="" /></th>
						<th style="vertical-align: top;">Tại sao tôi không thể đăng ký tài khoản</th>
						<th style="vertical-align: top;">Không thể đăng ký tài khoản bằng email hiện tại</th>
						<th style="vertical-align: top;">locbn</th>
						<th style="vertical-align: top;">10h 19/02/2021</th>
						<th style="vertical-align: top;">Đã đọc</th>
					</tr>
					<tr>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="vechicle" value="" /></th>
						<th style="vertical-align: top;">Tại sao tôi không thể đăng ký tài khoản</th>
						<th style="vertical-align: top;">Không thể đăng ký tài khoản bằng email hiện tại</th>
						<th style="vertical-align: top;">locbn</th>
						<th style="vertical-align: top;">10h 19/02/2021</th>
						<th style="vertical-align: top;">Đã đọc</th>
					</tr>
					<tr>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="vechicle" value="" /></th>
						<th style="vertical-align: top;">Tại sao tôi không thể đăng ký tài khoản</th>
						<th style="vertical-align: top;">Không thể đăng ký tài khoản bằng email hiện tại</th>
						<th style="vertical-align: top;">locbn</th>
						<th style="vertical-align: top;">10h 19/02/2021</th>
						<th style="vertical-align: top;">Đã đọc</th>
					</tr>
					<tr>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="vechicle" value="" /></th>
						<th style="vertical-align: top;">Tại sao tôi không thể đăng ký tài khoản</th>
						<th style="vertical-align: top;">Không thể đăng ký tài khoản bằng email hiện tại</th>
						<th style="vertical-align: top;">locbn</th>
						<th style="vertical-align: top;">10h 19/02/2021</th>
						<th style="vertical-align: top;">Đã đọc</th>
					</tr>
					<tr>
						<th style="text-align: center; vertical-align: middle;"><input type="checkbox" name="vechicle" value="" /></th>
						<th style="vertical-align: top;">Tại sao tôi không thể đăng ký tài khoản</th>
						<th style="vertical-align: top;">Không thể đăng ký tài khoản bằng email hiện tại</th>
						<th style="vertical-align: top;">locbn</th>
						<th style="vertical-align: top;">10h 19/02/2021</th>
						<th style="vertical-align: top;">Đã đọc</th>
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
