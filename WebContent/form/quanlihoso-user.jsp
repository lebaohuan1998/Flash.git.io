<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container col-9 mx-auto form-block ">
	<div class="row justify-content-center half">
		<div class="col-md-12">
			<form id="update-form" class="form "
				action="${pageContext.request.contextPath}/ProfileUser?cmd=ChangeInfo"
				method="post" enctype="multipart/form-data">
				<div class="form-block1 mx-auto"
					style="border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
					<div class="input-group">
						<div class="col-sm-3">
							<div class="form-group">
								<c:if test="${imgname==null}">
									<img src="form/pic/anhchandung.png" id="myImg" src="#"
										alt="your image" height=130 width=190>
								</c:if>
								<c:if test="${imgname!=null}">
									<img class="rounded" src="images/${id}${role}/${imgname}"
										id="myImg" src="#" alt="your image" height=130 width=190>
								</c:if>

								<input type="file" class="btn" id="file_user" name="file"
									accept="image/x-png,image/gif,image/jpeg"
									style="display: none;" onchange="loadFile(event)"> <input
									type="button" value="Tải lên"
									onclick="document.getElementById('file_user').click();"
									style="margin: 10px 0 0 60px;" />
							</div>
						</div>


						<div class="col-sm-8">
							<div class="form-group ">
								<h4 class="col-sm-6" style="border: none;">${user}</h4>
								<h4 class="col-sm-6" style="border: none;">${gender}</h4>
								<h4 class="col-sm-6" style="border: none;">${bod}</h4>
								<h4 class="col-sm-6" style="border: none;">${address}</h4>
							</div>
						</div>
					</div>
				</div>
				<!-- <label type="text" class=" up">Cập nhật tài khoản</label> -->

				<div class="form-block1 mx-auto mb-0"
					style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 10px;">
					<!-- <div class="form-block mx-auto"> -->
					<div class="form-group up1">
						<label type="text" class="up">Thông tin cá nhân</label>
					</div>
					<div class="row">
						<div class="col-sm-2">
							<div class="form-group ">
								<label class="form-group">Email:</label>
							</div>
							<div class="form-group">
								<label class="form-group">Họ và Tên:</label>
							</div>
							<div class="form-group">
								<label class="">Ngày sinh:</label>
							</div>
							<div class="form-group">
								<label class="">Địa chỉ:</label>
							</div>
							<div class="form-group">
								<label class="">Số điện thoại:</label>
							</div>
							<div class="form-group">
								<label class="">Giới tính:</label>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group ">
								<input type="text" class="form-control" value="${email}"
									disabled="disabled">
							</div>
							<div class="form-group">
								<input type="text" class="form-control " value="${user}"
									name="user">
							</div>
							<div class="form-group">
								<input type="date" class="form-control " name="dob"
									value="${bod}" max="2100-12-31" min="1900-12-31">
							</div>
							<div class="form-group">
								<input type="text" class="form-control " name="address"
									value="${address}">
							</div>
							<div class="form-group">
								<input type="text" class="form-control " value="${phone}"
									name="phone">
							</div>
							<div class="form-group ">
								<input name="gender" type="radio" value="Nam" class="gender"
									${gender=='Nam'?'checked':''} /> Nam <input name="gender"
									type="radio" value="Nữ" class="gender female"
									${gender=='Nữ'?'checked':''} /> Nữ
							</div>
							<button type="submit" class="btn btn-info">Lưu</button>

						</div>
					</div>
			</form>
		</div>
		<form id="update-pass" class="form "
			action="${pageContext.request.contextPath}/ProfileUser?cmd=ChangePassword"
			method="post">
			<div class="form-block1 mx-auto"
				style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 10px;">
				<div class="form-group up1">
					<label type="text" class="up">Đổi mật khẩu</label>
				</div>
				<div class="row">
					<div class="col-sm-2">
						<div class="form-group">
							<label for="email" class="form-group"> Mật khẩu cũ :</label>
						</div>
						<div class="form-group">
							<label class="form-group">Mật khẩu mới:</label>
						</div>
						<div class="form-group">
							<label for="email" class="">Nhập lại Mật khẩu mới:</label>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group ">
							<input type="password" class="form-control " name="oldpass">
							<c:if test="${param.err =='false'}">
								<p id="password_error" class="alert alert-danger p-1 my-1">
									Sai mật khẩu</p>
							</c:if>
						</div>
						<div class="form-group">
							<input type="password" id="password" class="form-control"
								id="password" placeholder="Mật khẩu ít từ 8-16 ký tự"
								name="newpass">
						</div>
						<div class="form-group">
							<input type="password" class="form-control"
								placeholder="Mật khẩu ít từ 8-16 ký tự" name="renewpass">
						</div>
						<c:if test="${param.errdupplicate =='true'}">
							<p id="password_error" class="alert alert-danger p-1 my-1">
								Mật khẩu mới không được giống mật khẩu cũ</p>
						</c:if>
						<button type="submit" class="btn btn-info">Thay đổi mật
							khẩu</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	var loadFile = function(event) {
		var a = document.getElementById('file_user');
		var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;//các tập tin cho phép
		//Kiểm tra định dạng
		console.log(a.files[0].size);
		if (a.files[0].size > 5 * 1024 * 1024) {
			alert('Vui lòng không tải ảnh quá 5Mb');
			a.value = '';
			return false;
		} else {
			if (!allowedExtensions.exec(a.value)) {
				alert('Vui lòng chỉ tải ảnh lên');
				a.value = '';
				return false;
			} else {
				var fileInput = document.getElementById('myImg');
				fileInput.src = URL.createObjectURL(event.target.files[0]);
				fileInput.onload = function() {
					URL.revokeObjectURL(fileInput.src) // free memory
				}
			}
		}

	};
</script>