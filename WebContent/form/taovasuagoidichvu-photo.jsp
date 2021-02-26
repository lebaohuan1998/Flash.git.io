<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="form-block col-9 mx-auto">
	<div class=" ">
		<div class="container-fluid">
			<div class="text-center">
				<h2 class="display">Tạo và sửa gói dịch vụ</h2>
			</div>
		</div>
		<div class="left" style="width: 40%; float: left">
			<div class="form-group">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="5" placeholder="Tổng quan về gói dịch vụ"></textarea>
			</div>
			<div class="input-group">
				<div class="form-outline">
					<input type="text" id="form1" class="form-text" />
					<button type="submit" class="btn-outline-dark">Thêm ảnh</button>
				</div>
			</div>
			<br>
			<div class="navbar-tab">
				<ul class="nav nav-tabs  mx-auto ">
					<!-- <li class="active"><a href="#">Home</a></li> -->
					<li class="col-3"><a href="#">Xoá ảnh</a></li>
					<li class="col-5"><a href="#">Chọn làm ảnh bìa</a></li>
					<li class="col-2"><a href="#">Lên</a></li>
					<li class="col-2"><a href="#">Xuống</a></li>
				</ul>
			</div>

			<div class="group-image">
				<form>
					<div class="form-image">
						<input type="checkbox" id="myCheckbox1" /> <label
							for="myCheckbox1"><img src="images/anhchandung.PNG" /></label> <label
							for="myCheckbox1">Album 1</label> <br> <br> <input
							type="checkbox" id="myCheckbox2" /> <label for="myCheckbox2"><img
							src="images/anhchandung.PNG" /></label> <label for="myCheckbox2">Album
							2</label> <br> <br> <input type="checkbox" id="myCheckbox3" />
						<label for="myCheckbox3"><img src="images/anhchandung.PNG" /></label>
						<label for="myCheckbox3">Album 3</label>
					</div>
				</form>
			</div>
		</div>

		<div style="width: 40%; float: right">
			<div class="group-info">
				<div class="group-info-detail">
					<label for="albums">Thể loại album:</label> <select
						class="btn btn-outline-dark">
						<option value="0">Vui lòng chọn thể loại chụp</option>
						<option value="1">Album chụp chân dung</option>
						<option value="2">Album chụp ảnh sự kiện</option>
						<option value="3">Album chụp ảnh cưới</option>
						<option value="4">...</option>
					</select> <br> <br> <label for="albums">Địa điểm chụp:</label> <select
						class="btn btn-outline-dark" name="workplace">
						<option ${workplace=='An Giang'? 'selected="selected"' : ''}>An
							Giang</option>
						<option
							${workplace=='Bà Rịa-Vũng Tàu'? 'selected="selected"' : ''}>Bà
							Rịa-Vũng Tàu</option>
						<option ${workplace=='Bạc Liêu'? 'selected="selected"' : ''}>Bạc
							Liêu</option>
						<option ${workplace=='Bắc Kạn'? 'selected="selected"' : ''}>Bắc
							Kạn</option>
						<option ${workplace=='Bắc Giang'? 'selected="selected"' : ''}>Bắc
							Giang</option>
						<option ${workplace=='Bắc Ninh'? 'selected="selected"' : ''}>Bắc
							Ninh</option>
						<option ${workplace=='Bến Tre'? 'selected="selected"' : ''}>Bến
							Tre</option>
						<option ${workplace=='Bình Dương'? 'selected="selected"' : ''}>Bình
							Dương</option>
						<option ${workplace=='>Bình Định'? 'selected="selected"' : ''}>Bình
							Định</option>
						<option ${workplace=='Bình Thuận'? 'selected="selected"' : ''}>Bình
							Phước</option>
						<option ${workplace=='Bình Dương'? 'selected="selected"' : ''}>Bình
							Thuận</option>
						<option ${workplace=='Cà Mau'? 'selected="selected"' : ''}>Cà
							Mau</option>
						<option ${workplace=='Cao Bằng'? 'selected="selected"' : ''}>Cao
							Bằng</option>
						<option ${workplace=='Cần Thơ'? 'selected="selected"' : ''}>Cần
							Thơ</option>
						<option ${workplace=='Đà Nẵng'? 'selected="selected"' : ''}>Đà
							Nẵng</option>
						<option ${workplace=='Đắk Lắk'? 'selected="selected"' : ''}>Đắk
							Lắk</option>
						<option ${workplace=='Đắk Nông'? 'selected="selected"' : ''}>Đắk
							Nông</option>
						<option ${workplace=='Điện Biên'? 'selected="selected"' : ''}>Điện
							Biên</option>
						<option ${workplace=='Đồng Nai'? 'selected="selected"' : ''}>Đồng
							Nai</option>
						<option ${workplace=='Đồng Tháp'? 'selected="selected"' : ''}>Đồng
							Tháp</option>
						<option ${workplace=='Gia Lai'? 'selected="selected"' : ''}>Gia
							Lai</option>
						<option ${workplace=='Hà Giang'? 'selected="selected"' : ''}>Hà
							Giang</option>
						<option ${workplace=='Hà Nam'? 'selected="selected"' : ''}>Hà
							Nam</option>
						<option ${workplace=='Hà Nội'? 'selected="selected"' : ''}>Hà
							Nội</option>
						<option ${workplace=='Hà Tây'? 'selected="selected"' : ''}>Hà
							Tây</option>
						<option ${workplace=='Hà Tĩnh'? 'selected="selected"' : ''}>Hà
							Tĩnh</option>
						<option ${workplace=='Hải Dương'? 'selected="selected"' : ''}>Hải
							Dương</option>
						<option ${workplace=='Hải Phòng'? 'selected="selected"' : ''}>Hải
							Phòng</option>
						<option ${workplace=='Hòa Bình'? 'selected="selected"' : ''}>Hòa
							Bình</option>
						<option ${workplace=='Hồ Chí Minh'? 'selected="selected"' : ''}>Hồ
							Chí Minh</option>
						<option ${workplace=='Hậu Giang'? 'selected="selected"' : ''}>Hậu
							Giang</option>
						<option ${workplace=='Hưng Yên'? 'selected="selected"' : ''}>Hưng
							Yên</option>
						<option ${workplace=='Khánh Hòa'? 'selected="selected"' : ''}>Khánh
							Hòa</option>
						<option ${workplace=='Kiên Giang'? 'selected="selected"' : ''}>Kiên
							Giang</option>
						<option ${workplace=='Kon Tum'? 'selected="selected"' : ''}>Kon
							Tum</option>
						<option ${workplace=='Lai Châu'? 'selected="selected"' : ''}>Lai
							Châu</option>
						<option ${workplace=='Lào Cai'? 'selected="selected"' : ''}>Lào
							Cai</option>
						<option ${workplace=='Lạng Sơn'? 'selected="selected"' : ''}>Lạng
							Sơn</option>
						<option ${workplace=='Lâm Đồng'? 'selected="selected"' : ''}>Lâm
							Đồng</option>
						<option ${workplace=='Long An'? 'selected="selected"' : ''}>Long
							An</option>
						<option ${workplace=='Nam Định'? 'selected="selected"' : ''}>Nam
							Định</option>
						<option ${workplace=='Nghệ An'? 'selected="selected"' : ''}>Nghệ
							An</option>
						<option ${workplace=='Ninh Bình'? 'selected="selected"' : ''}>Ninh
							Bình</option>
						<option ${workplace=='Ninh Thuận'? 'selected="selected"' : ''}>Ninh
							Thuận</option>
						<option ${workplace=='Phú Thọ'? 'selected="selected"' : ''}>Phú
							Thọ</option>
						<option ${workplace=='Phú Yên'? 'selected="selected"' : ''}>Phú
							Yên</option>
						<option ${workplace=='Quảng Bình'? 'selected="selected"' : ''}>Quảng
							Bình</option>
						<option ${workplace=='Quảng Nam'? 'selected="selected"' : ''}>Quảng
							Nam</option>
						<option ${workplace=='Quảng Ngãi'? 'selected="selected"' : ''}>Quảng
							Ngãi</option>
						<option ${workplace=='Quảng Ninh'? 'selected="selected"' : ''}>Quảng
							Ninh</option>
						<option ${workplace=='Quảng Trị'? 'selected="selected"' : ''}>Quảng
							Trị</option>
						<option ${workplace=='Sóc Trăng'? 'selected="selected"' : ''}>Sóc
							Trăng</option>
						<option ${workplace=='Sơn La'? 'selected="selected"' : ''}>Sơn
							La</option>
						<option ${workplace=='Tây Ninh'? 'selected="selected"' : ''}>Tây
							Ninh</option>
						<option ${workplace=='Thái Bình'? 'selected="selected"' : ''}>Thái
							Bình</option>
						<option ${workplace=='Thái Nguyên'? 'selected="selected"' : ''}>Thái
							Nguyên</option>
						<option ${workplace=='Thanh Hóa'? 'selected="selected"' : ''}>Thanh
							Hóa</option>
						<option
							${workplace=='Thừa Thiên – Huế'? 'selected="selected"' : ''}>Thừa
							Thiên – Huế</option>
						<option ${workplace=='Tiền Giang'? 'selected="selected"' : ''}>Tiền
							Giang</option>
						<option ${workplace=='Trà Vinh'? 'selected="selected"' : ''}>Trà
							Vinh</option>
						<option ${workplace=='Tuyên Quang'? 'selected="selected"' : ''}>Tuyên
							Quang</option>
						<option ${workplace=='Vĩnh Long'? 'selected="selected"' : ''}>Vĩnh
							Long</option>
						<option ${workplace=='Vĩnh Phúc'? 'selected="selected"' : ''}>Vĩnh
							Phúc</option>
						<option ${workplace=='Yên Bái'? 'selected="selected"' : ''}>Yên
							Bái</option>
					</select> <br> <br> <label for="albums">Giá:</label> <input
						type="text" name="price"> <br> <br> <label
						for="albums">Đặt cọc:</label> <select class="btn btn-outline-dark">
						<option value="0">Chọn cọc theo gói album</option>
						<option value="1">0%</option>
						<option value="2">5%</option>
						<option value="3">10%</option>
						<option value="4">15%</option>
						<option value="5">20%</option>
						<option value="6">...</option>
					</select>
				</div>
			</div>
			<br> <br>

		</div>

	</div>
	<button type="submit" class="btn btn-outline-dark ">Lưu lại</button>
</div>