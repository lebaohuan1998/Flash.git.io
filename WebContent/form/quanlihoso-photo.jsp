
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container col-9 mx-auto form-block">
	<div class=" justify-content-center half">
		<div class="col-md-12">
			<div class=" ">
				<div class="">
					<h1 class=" mr-3" style="font-size: 32px;">
						Tình trạng:
						<c:if test="${hide =='no'}">
							<a href="#CMND" class="btn btn-outline-dark "> Chưa xác minh</a>
						</c:if>
						<c:if test="${hide =='yes'&&statusxm !='3'}">
							 Đang chờ xác minh
						</c:if>
						<c:if test="${statusxm =='3'&&hide =='yes'}">
							 Xác minh thành công
						</c:if>
					</h1>
				</div>
			</div>
			<!-- Kinh nghiệm , nơi chụp -->
			<form id="show" class="form "
				action="${pageContext.request.contextPath}/ProfilePhoto?cmd=show"
				method="post" enctype="multipart/form-data">
				<div class=" mx-auto mb-0">
					<!-- <div class="form-group"> -->
					<div class="form-group up1">
						<label class="up">Thợ Chụp Ảnh: ${user}</label>
					</div>
					<div>
						<c:if test="${imgname==null}">
							<img src="form/pic/anhchandung.png" id="myImg" src="#"
								alt="your image" style="height: 130px; width: 190px;">
						</c:if>
						<c:if test="${imgname!=null}">
							<img class="rounded" src="images/${id}${role}/${imgname}"
								id="myImg" src="#" alt="your image"
								style="height: 130px; width: 190px;">
						</c:if>
						<input id="file_photographer" type="file" class="btn" name="file"
							style="display: none;" accept="image/x-png,image/gif,image/jpeg"
							onchange="loadFile(event)"> <input type="button"
							value="Tải lên"
							onclick="document.getElementById('file_photographer').click();" />
					</div>
					<!-- </div> -->
					<div class=" ">
						<br>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Tên Studio/ Nghệ danh:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input id="nickname" type="text" class="form-control"
									value="${nghedanh}" name="nghedanh">
							</div>
						</div>
						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="form-group">Quy mô:</label>
							</div>
							<div class="col-sm-8 form-group">
								<input name="quymo" type="radio" value="Cá nhân" class="gender"
									${quymo=='Cá nhân'?'checked':''} /> Cá nhân <input
									name="quymo" type="radio" value="Nhóm" class="gender female"
									${quymo=='Nhóm'?'checked':''} /> Nhóm <input name="quymo"
									type="radio" value="Studio" class="gender female"
									${quymo=='Studio'?'checked':''} /> Studio
							</div>
						</div>

						<div class="input-group">
							<div class="col-sm-2 form-group">
								<label class="">Địa Chỉ Làm Việc:</label>
							</div>

							<div class="col-sm-8 form-group">
								<input type="text" class=" form-group form-control"
									value="${workPlace}" name="workplace"> <select
									id="province" class="btn btn-outline-dark" name="diadiem">
									<c:forEach items="${listLocation}" var="listLocation">
										<option
											${listLocation.locationId==locationId? 'selected="selected"' : ''}
											value="${listLocation.locationId} ${listLocation.locationx} ${listLocation.locationy}">
											${listLocation.locationName}</option>
									</c:forEach>
								</select> <input id="locationx" class="collapse"
									value="${mapphoto.locationx}"> <input id="locationy"
									class="collapse" value="${mapphoto.locationy}">
								<button type="button" class="btn btn-info" id="openmap"
									data-toggle="modal" data-target="#mapphotographer">Map</button>
								<div class="modal fade" id="mapphotographer" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">Hãy chọn vị trí của bạn để
												chúng tôi tìm thấy bạn</div>
											<div class="modal-body">
												<div id="map"></div>
											</div>
											<div class="modal-footer">
												<a type="button" id="btnaddressmap" class="btn btn-info"
													data-dismiss="modal">Lưu</a>
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Đóng</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<button class="btn btn-info ">Cập nhật</button>
				</div>
			</form>
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
									class="form-control"  max="2100-12-31" min="1900-12-31">
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
					<button class="btn btn-info ">Cập nhật</button>
				</div>
			</form>
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
							<img id="i1" src="form/pic/anhchandung.png" class="cmnd1"
								alt="your image" height=130 width=190> <input id="file_p1"
								class="btn" style="display: none;" type="file"
								accept="image/x-png,image/gif,image/jpeg"
								onchange="loadFile1(event)" name="file1"> <input
								type="button" value="Tải lên"
								onclick="document.getElementById('file_p1').click();" />
						</div>

					</div>
					<div class="input-group">
						<div class="form-group">
							<label class="form-group">CMND/CCCD mặt sau:</label>
						</div>
						<div class="form-group col-7">
							<img id="i2" src="form/pic/anhchandung.png" class="cmnd1"
								alt="your image" height=130 width=190> <input id="file_p2"
								class="btn" style="display: none;" type="file"
								accept="image/x-png,image/gif,image/jpeg"
								onchange="loadFile2(event)" name="file2"> <input
								type="button" value="Tải lên"
								onclick="document.getElementById('file_p2').click();" />
						</div>

					</div>
					<div class="input-group">
						<div class="form-group">
							<label class="">Hình chân dung:</label>
						</div>
						<div class="form-group col-7">
							<img id="i3" src="form/pic/anhchandung.png" class="cmnd1"
								alt="your image" height=130 width=190> <input id="file_p3"
								class="btn" style="display: none;" type="file"
								accept="image/x-png,image/gif,image/jpeg"
								onchange="loadFile3(event)" name="file3"> <input
								type="button" value="Tải lên"
								onclick="document.getElementById('file_p3').click();" />
						</div>
					</div>
					<div class="">
						<button class="btn btn-info ">Cập nhật</button>
					</div>


				</div>
			</form>
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
									id="password" placeholder="Mật khẩu ít từ 8-16 ký tự">
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
				<button class="btn btn-info ">Cập nhật</button>
			</form>
			<!-- <div class="clear"></div> -->
		</div>
	</div>
</div>
<script type="text/javascript" charset="utf-8"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAk8Xn53w2vnsRoQ_Zvuyl3NuhuYNvsHWE&callback=initMap"
	async defer></script>
<script type="text/javascript">
	var str;
	function initMap() {
		var location = document.getElementById("province").value;
		 var splitted = location.split(" ", 3);
		var x = document.getElementById("locationx").value;
		var y = document.getElementById("locationy").value;
		console.log(x+""+y);
		  var myLatlng = { lat: Number(x), lng: Number(y) };
		  if(Number(x)==0&& Number(y)==0){
			  myLatlng = { lat:  Number(splitted[1]), lng:  Number(splitted[2]) };
			  const map = new google.maps.Map(document.getElementById("map"), {
				    zoom: 12,
				    center: myLatlng,
				  });
				  // Create the initial InfoWindow.
				  var marker;
				  let infoWindow;
				  infoWindow = new google.maps.InfoWindow({
				    content: "Chọn vị trí của bạn",
				    position: myLatlng,
				  });
				  infoWindow.open(map);
					
				  // Configure the click listener.
				  map.addListener("click", (mapsMouseEvent) => {
				    // Close the current InfoWindow.
				    infoWindow.close();
				    
				    infoWindow = new google.maps.InfoWindow({
				      position: mapsMouseEvent.latLng,
				    });
				    infoWindow.setContent(
				    		document.getElementById("nickname").value
				    );
				    str =JSON.stringify(mapsMouseEvent.latLng.toJSON(), null, 2);
				    infoWindow.open(map);
				  });
		  } if(Number(x)!=0&& Number(y)!=0){
		  const map = new google.maps.Map(document.getElementById("map"), {
		    zoom: 12,
		    center: myLatlng,
		  });
		  // Create the initial InfoWindow.
		  var marker;
		  let infoWindow;
		  infoWindow = new google.maps.InfoWindow({
		  });

		  marker = new google.maps.Marker({
		    	position: myLatlng,
	    	    map : map,
	    	});

		  infoWindow.open(map);
		
		  // Configure the click listener.
		  map.addListener("click", (mapsMouseEvent) => {
		    // Close the current InfoWindow.
		    infoWindow.close();
		    
		    infoWindow = new google.maps.InfoWindow({
		      position: mapsMouseEvent.latLng,
		    });
		    infoWindow.setContent(
		    		document.getElementById("nickname").value
		    );
		    str =JSON.stringify(mapsMouseEvent.latLng.toJSON(), null, 2);
		    infoWindow.open(map);
		  });
		  }
		}
	$("#btnaddressmap").click(function() {
		console.log(str);
		$.ajax({
			url : '${APIurl2}?cmd=ADDCURRENTLOCATION',
			type : 'GET',
			contentType : 'application/json',
			data : {
				arr : str
			},
			success : function(result) {
				window.location.href = "${APIurl3}?flag=1";
			},
			error : function(error) {
				console.log(error);
			}
		});
	});
	var loadFile = function(event) {
		var a = document.getElementById('file_photographer');
		var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;//các tập tin cho phép
		//Kiểm tra định dạng
			console.log(a.files[0].size);
			if(a.files[0].size> 5*1024*1024){
				alert('Vui lòng không tải ảnh quá 5Mb');
				a.value = '';
				return false;
			}else{
				if (!allowedExtensions.exec(a.value)) {
					alert('Vui lòng chỉ tải ảnh lên');
					a.value = '';
					return false;
				}else{
					 var fileInput = document.getElementById('myImg');
					    fileInput.src = URL.createObjectURL(event.target.files[0]);
					    fileInput.onload = function() {
					      URL.revokeObjectURL(fileInput.src) // free memory
					    }
				}
			}
	   
	  };
	var loadFile1= function(event) {
		var a = document.getElementById('file_p1');
		var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;//các tập tin cho phép
		//Kiểm tra định dạng
			console.log(a.files[0].size);
			if(a.files[0].size> 5*1024*1024){
				alert('Vui lòng không tải ảnh quá 5Mb');
				a.value = '';
				return false;
			}else{
				if (!allowedExtensions.exec(a.value)) {
					alert('Vui lòng chỉ tải ảnh lên');
					a.value = '';
					return false;
				}else{
					 var fileInput = document.getElementById('i1');
					    fileInput.src = URL.createObjectURL(event.target.files[0]);
					    fileInput.onload = function() {
					      URL.revokeObjectURL(fileInput.src) // free memory
					    }
				}
			}
		  };
	var loadFile2 = function(event) {
		var a = document.getElementById('file_p2');
		var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;//các tập tin cho phép
		//Kiểm tra định dạng
			console.log(a.files[0].size);
			if(a.files[0].size> 5*1024*1024){
				alert('Vui lòng không tải ảnh quá 5Mb');
				a.value = '';
				return false;
			}else{
				if (!allowedExtensions.exec(a.value)) {
					alert('Vui lòng chỉ tải ảnh lên');
					a.value = '';
					return false;
				}else{
					 var fileInput = document.getElementById('i2');
					    fileInput.src = URL.createObjectURL(event.target.files[0]);
					    fileInput.onload = function() {
					      URL.revokeObjectURL(fileInput.src) // free memory
					    }
				}
			}
			  };
	var loadFile3 = function(event) {
		var a = document.getElementById('file_p3');
		var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;//các tập tin cho phép
		//Kiểm tra định dạng
			console.log(a.files[0].size);
			if(a.files[0].size> 5*1024*1024){
				alert('Vui lòng không tải ảnh quá 5Mb');
				a.value = '';
				return false;
			}else{
				if (!allowedExtensions.exec(a.value)) {
					alert('Vui lòng chỉ tải ảnh lên');
					a.value = '';
					return false;
				}else{
					 var fileInput = document.getElementById('i3');
					    fileInput.src = URL.createObjectURL(event.target.files[0]);
					    fileInput.onload = function() {
					      URL.revokeObjectURL(fileInput.src) // free memory
					    }
				}
			}
				  };
	  
	</script>