<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid container"
	style="border: 1px solid rgba(0, 0, 0, 0.15); margin-top: 10px; margin-left: 250px; padding-left: 1rem; padding-right: -30rem; width: 80%;">
	<div style="width: 100%; height: 100%; margin-left: 100px;">
		<h2 class=""
			style="margin-left: 300px; margin-bottom: 20px; margin-top: 20px;">Tạo
			bài viết</h2>
		<div class="form-inline" style="margin-bottom: 20px;">
			<span style="margin-right: 50px;">Tiêu đề</span> <input
				class="form-control" type="text" style="width: 60%;" />
		</div>
		<div class="form-inline" style="margin-bottom: 20px;">
			<span style="margin-right: 52px;">Tác giả</span> <input
				class="form-control" type="text" style="width: 60%;" />
		</div>
		<div class="input-group" style="margin-bottom: 20px;">
			<span style="margin-right: 46px;padding-top: 5p*x
			;">Thể loại</span>
			<div class="dropdown">
				<select class="form-control" name="category" style="width: 635px;"></i>
					<option value="0" class="" selected>Tất cả thể loại</option>
					<option value="1">Chân dung</option>
					<option value="2">Sự kiện</option>
					<option value="3">Đám cưới</option>
					<option value="4">Kỷ yếu</option>
					<option value="5">Gia đình và bé</option>
					<option value="6">Chụp sản phẩm</option>
					<option value="7">Khác</option>
				</select>
			</div>
		</div>
		<div class="form-inline" style="margin-bottom: 20px;">
			<span style="margin-right: 19px;">Ảnh tiêu đề</span> <input
				class="form-control" type="text" style="width: 60%;" />
		</div>
		<div class="form-inline" style="margin-bottom: 20px;">
			<span style="margin-right: 33px;">Nôi dung</span>
			<textarea class="form-control" rows="4" cols="100"></textarea>
		</div>
		<button class="btn btn-outline-info"
			style="margin-bottom: 20px; margin-left: 65%;">Tạo bài viết</button>
	</div>
</div>