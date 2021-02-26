
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container col-9 mx-auto form-block">
	<div class="row justify-content-center half">
		<div class="col-md-12">
			<div class=" mx-auto">
				<div class="form-inline">
					<div class="form-group xacminh">
						<h1 class=" mr-3">Tình trạng:</h1>
						<c:if test="${hide =='no'}">
							<a href="#CMND" class="btn btn-outline-dark "> Chưa xác minh</a>
						</c:if>
						<c:if test="${hide =='yes'}">
							<h4> Đang chờ xác minh</h4>
						</c:if>
						<c:if test="${statusxm =='active'}">
							<h4> Xác minh thành công</h4>
						</c:if>
					</div>
				</div>
			</div>
			<br> <br>
			<!-- Kinh nghiệm , nơi chụp -->
			<form id="show" class="form "
				action="${pageContext.request.contextPath}/ProfilePhoto?&cmd=show"
				method="post" enctype="multipart/form-data">
				<div class=" mx-auto mb-0">
					<!-- <div class="form-group"> -->
					<div class="form-group up1">
						<label class="up">Thợ Chụp Ảnh: ${user}</label>
					</div>
					<div>
						<c:if test="${imgname==null}">
							<img src="images/anhchandung.PNG" id="myImg" src="#"
								alt="your image" height=130 width=190>
						</c:if>
						<c:if test="${imgname!=null}">
							<img src="images/${email}${role}/${imgname}" id="myImg" src="#"
								alt="your image" height=130 width=190>
						</c:if>
						<input type="file" class="btn" name="file">
					</div>
					<!-- </div> -->
					<br>
					<div class=" ">
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Tên Studio/ Nghệ danh:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control" value="${nghedanh}"
									name="nghedanh">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Quy mô:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input name="quymo" type="radio" value="canhan" class="gender"
									${quymo=='canhan'?'checked':''} /> Cá nhân <input name="quymo"
									type="radio" value="nhom" class="gender female"
									${quymo=='nhom'?'checked':''} /> Nhóm <input name="quymo"
									type="radio" value="studio" class="gender female"
									${quymo=='studio'?'checked':''} /> Studio
							</div>
						</div>

						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="">Địa Chỉ Làm Việc:</label>
							</div>
							<div class="col-sm-8 form-group">
								<select class="btn btn-outline-dark" name="workplace">
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
				action="${pageContext.request.contextPath}/ProfilePhoto?cmd=updateinfo"
				method="post">
				<div class=" mx-auto">
					<div class="form-group up1">
						<label class="up">Cập nhật thông tin cá nhân</label>
					</div>
					<div class="">
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Họ và tên:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" class="form-control" name="user"
									value="${user}">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Địa chỉ CMT/CCCD:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="text" name="address" class="form-control"
									value="${address}">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Ngày sinh:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="date" value="${bod}" name="dob"
									class="form-control">
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
									name="tcc">
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
								<input type="text" class="form-control" name="email"
									disabled="true" value="${email }">
							</div>
						</div>

					</div>
					<br>
					<button class="btn btn-outline-dark ">Cập nhật</button>
				</div>
			</form>
			<br> <br>
			<!-- xac minh chứng  minh thư -->
			<form id="updatecmt-form"
				class="form <c:if test="${hide =='yes'}">collapse</c:if> "
				action="${pageContext.request.contextPath}/ProfilePhoto?cmd=updatecmt"
				method="post" enctype="multipart/form-data">
				<div class=" mx-auto" id="myaccordion1">
					<div class="form-group ">
						<label class="up" id="CMND">Xác minh CMND/CCCD</label>
					</div>
					<div class="input-group">
						<div class="form-group">
							<label class="form-group">CMND/CCCD mặt trước:</label>
						</div>
						<div class="form-group col-7">
							<img src="images/anhchandung.PNG" class="cmnd1" src="#"
								alt="your image" height=130 width=190> <input class="btn"
								type="file" name="file1">
						</div>

					</div>
					<div class="input-group">
						<div class="form-group">
							<label class="form-group">CMND/CCCD mặt sau:</label>
						</div>
						<div class="form-group col-7">
							<img src="images/anhchandung.PNG" class="cmnd1" src="#"
								alt="your image" height=130 width=190> <input class="btn"
								type="file" name="file2">
						</div>

					</div>
					<div class="input-group">
						<div class="form-group">
							<label class="">Hình chân dung:</label>
						</div>
						<div class="form-group col-7">
							<img src="images/anhchandung.PNG" class="cmnd1" src="#"
								alt="your image" height=130 width=190> <input class="btn"
								type="file" name="file3">
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
			<form id="updatepass-form" class="form"
				action="${pageContext.request.contextPath}/ProfilePhoto?cmd=updatepass"
				method="post">
				<div class=" mx-auto">
					<div class="form-group up1">
						<label class="up">Đổi mật khẩu</label>
					</div>
					<div class="">
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="">Mật khẩu cũ:</label>
							</div>
							<div class="col-sm-8 form-group ">
								<input type="password" class="form-control " name="oldpassword">
								<c:if test="${param.err =='false'}">
									<p id="password_error" class="alert alert-danger p-1 my-1">
										Sai mật khẩu</p>
								</c:if>
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="">Mật khẩu mới:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="password" class="form-control" name="newpass"
									placeholder="Mật khẩu ít từ 8-16 ký tự">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="">Nhập lại mật khẩu mới:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input type="password" class="form-control" name="renewpass"
									placeholder="Mật khẩu ít từ 8-16 ký tự">
							</div>
						</div>
					</div>
				</div>
				<br>
				<button class="btn btn-outline-dark ">Cập nhật</button>
			</form>
			<!-- <div class="clear"></div> -->
		</div>
	</div>
</div>