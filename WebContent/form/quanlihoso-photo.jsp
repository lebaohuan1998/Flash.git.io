
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container col-9 mx-auto form-block">
	<div class="row justify-content-center half">
		<div class="col-md-12">
			<div class=" mx-auto">
				<div class="form-inline">
					<div class="form-group xacminh">
						<h1 class="sty mr-3">Tình trạng:</h1>
						<a href="#CMND" class="btn btn-outline-dark "> Chưa xác minh</a>
					</div>
				</div>
			</div>
			<br> <br>
			<!-- Kinh nghiệm , nơi chụp -->
			<form id="show" class="form "
				action="${pageContext.request.contextPath}/ProfilePhoto?flag=1&cmd=show"
				method="post" enctype="multipart/form-data">
				<div class=" mx-auto mb-0" id="myaccordion">
					<!-- <div class="form-group"> -->
					<div class="form-group up1">
						<label type="text" class="up">Thợ Chụp Ảnh: ${user}</label>
					</div>
					<div>
						<img src="images/anhchandung.PNG" id="myImg" alt="your image"
							name='filename' height=130 width=190><br> <input
							class="btn " type='file' id='buttonid1' type='button'>
					</div>
					<!-- </div> -->
					<br>
					<div class=" ">
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Tên Studio/ Nghệ danh:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control" placeholder="Nhập">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Quy mô:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input name="quymo" type="radio" value="Nam" class="gender"
									${gender=='Nam'?'checked':''} /> Cá nhân <input name="quymo"
									type="radio" value="Nữ" class="gender female"
									${gender=='Nữ'?'checked':''} /> Nhóm <input name="quymo"
									type="radio" value="Nữ" class="gender female"
									${gender=='Nữ'?'checked':''} /> Studio
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Địa chỉ:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control" placeholder="Nhập">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="">Địa điểm chụp:</label>
							</div>
							<div class="col-sm-8 form-group">
								<select class="btn btn-outline-dark">
									<option>An Giang</option>
									<option>Bà Rịa-Vũng Tàu</option>
									<option>Bạc Liêu</option>
									<option>Bắc Kạn</option>
									<option>Bắc Giang</option>
									<option>Bắc Ninh</option>
									<option>Bến Tre</option>
									<option>Bình Dương</option>
									<option>Bình Định</option>
									<option>Bình Phước</option>
									<option>Bình Thuận</option>
									<option>Cà Mau</option>
									<option>Cao Bằng</option>
									<option>Cần Thơ</option>
									<option>Đà Nẵng</option>
									<option>Đắk Lắk</option>
									<option>Đắk Nông</option>
									<option>Điện Biên</option>
									<option>Đồng Nai</option>
									<option>Đồng Tháp</option>
									<option>Gia Lai</option>
									<option>Hà Giang</option>
									<option>Hà Nam</option>
									<option selected>Hà Nội</option>
									<option>Hà Tây</option>
									<option>Hà Tĩnh</option>
									<option>Hải Dương</option>
									<option>Hải Phòng</option>
									<option>Hòa Bình</option>
									<option>Hồ Chí Minh</option>
									<option>Hậu Giang</option>
									<option>Ba vì</option>
									<option>Hải Phòng</option>
									<option>Hồ Chí Minh</option>
									<option selected>Hà Nội</option>
									<option>Nam Định</option>
									<option>Ba vì</option>
									<option>Hải Phòng</option>
									<option>Hồ Chí Minh</option>
									<option selected>Hà Nội</option>
									<option>Nam Định</option>
									<option>Ba vì</option>
									<option>Hải Phòng</option>
									<option>Hồ Chí Minh</option>
									<option selected>Hà Nội</option>
									<option>Nam Định</option>
									<option>Ba vì</option>
									<option>Hải Phòng</option>
									<option>Hồ Chí Minh</option>
									<option selected>Hà Nội</option>
									<option>Nam Định</option>
									<option>Ba vì</option>
									<option>Hải Phòng</option>
									<option>Hồ Chí Minh</option>
									<option selected>Hà Nội</option>
									<option>Nam Định</option>
									<option>Ba vì</option>
									<option>Hải Phòng</option>
									<option>Hồ Chí Minh</option>
									<option selected>Hà Nội</option>
									<option>Nam Định</option>
									<option>Ba vì</option>
									<option>Hải Phòng</option>
									<option>Hồ Chí Minh</option>
									<option selected>Hà Nội</option>
									<option>Nam Định</option>
									<option>Ba vì</option>
									<option>Hải Phòng</option>
									<option>Hồ Chí Minh</option>

								</select>
							</div>
						</div>

					</div>
					<button class="btn btn-outline-dark ">Cập nhật</button>
				</div>
			</form>
			<br> <br>

			<!-- Cập nhật thông tin cá nhân -->
			<form id="updateinfo-form" class="form "
				action="${pageContext.request.contextPath}/ProfilePhoto?flag=1&cmd=updateinfo"
				method="post" enctype="multipart/form-data">
				<div class=" mx-auto">
					<div class="form-group up1">
						<label type="text" class="up">Cập nhật thông tin cá nhân</label>
					</div>
					<div class="">
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Họ và tên:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control" value="${user }"
									placeholder="Nhập họ tên">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Ngày sinh:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="date" value="${bod}" class="form-control">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="">Địa chỉ:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control " name="address"
									value="${address}">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Số điện thoại:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control " value="${phone}"
									name="phone">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Thẻ căn cước/CMND:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control " value="${tcc}"
									name="phone">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Giới tính:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input name="gender" type="radio" value="Nam" class="gender"
									${gender=='Nam'?'checked':''} /> Nam <input name="gender"
									type="radio" value="Nữ" class="gender female"
									${gender=='Nữ'?'checked':''} /> Nữ
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="">Email:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control" disabled="true"
									value="${email }">
							</div>
						</div>

					</div>
					<br>
					<button class="btn btn-outline-dark ">Cập nhật</button>
				</div>
			</form>
			<br> <br>
			<!-- xac minh chứng  minh thư -->
			<form id="updatecmt-form" class="form "
				action="${pageContext.request.contextPath}/ProfilePhoto?flag=1&cmd=updatecmt"
				method="post" enctype="multipart/form-data">
				<div class=" mx-auto" id="myaccordion1">
					<div class="form-group ">
						<label type="text" class="up" id="CMND">Xác minh CMND/CCCD</label>
					</div>
					<div class="input-group">
						<div class="form-group">
							<label for="email" class="form-group">CMND/CCCD mặt
								trước:</label>
						</div>
						<div class="form-group col-7">
							<img src="images/anhchandung.PNG" class="cmnd1" src="#"
								alt="your image" name='filename' height=130 width=190> <input
								class="btn" type='file' id='buttonid1' type='button'>
						</div>

					</div>
					<div class="input-group">
						<div class="form-group">
							<label class="form-group">CMND/CCCD mặt sau:</label>
						</div>
						<div class="form-group col-7">
							<img src="images/anhchandung.PNG" class="cmnd1" src="#"
								alt="your image" name='filename' height=130 width=190> <input
								class="btn" type='file' id='buttonid1' type='button'>
						</div>

					</div>
					<div class="input-group">
						<div class="form-group">
							<label for="email" class="">Hình chân dung:</label>
						</div>
						<div class="form-group col-7">
							<img src="images/anhchandung.PNG" class="cmnd1" src="#"
								alt="your image" name='filename' height=130 width=190> <input
								class="btn" type='file' id='buttonid1' type='button'>
						</div>
					</div>
					<br>
					<div class="form-inline">
						<button class="btn btn-outline-dark ">Cập nhật</button>
					</div>


				</div>
			</form>
			<br> <br>
			<!-- Đổi pass -->
			<form id="updatepass-form" class="form "
				action="${pageContext.request.contextPath}/ProfilePhoto?flag=1&cmd=updatepass"
				method="post" enctype="multipart/form-data">
				<div class=" mx-auto">
					<div class="form-group up1">
						<label type="text" class="up">Đổi mật khẩu</label>
					</div>
					<div class="input-group">
						<div class="col-sm-3.5">
							<div class="form-group">
								<label for="email" class="form-group">Mật khẩu cũ:</label>
							</div>
							<div class="form-group">
								<label class="form-group">Mật khẩu mới:</label>
							</div>
							<div class="form-group">
								<label for="email" class="">Nhập lại mật khẩu mới:</label>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group ">
								<input type="password" class="form-control ">
							</div>
							<div class="form-group">
								<input type="password" class="form-control"
									placeholder="Mật khẩu ít từ 8-16 ký tự">
							</div>
							<div class="form-group">
								<input type="password" class="form-control"
									placeholder="Mật khẩu ít từ 8-16 ký tự">
							</div>

						</div>

					</div>
					<br>
					<button class="btn btn-outline-dark ">Cập nhật</button>

				</div>
			</form>
			<!-- <div class="clear"></div> -->
		</div>
	</div>
</div>