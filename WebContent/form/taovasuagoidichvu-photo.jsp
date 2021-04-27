<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="form-block col-9 mx-auto">
	<div class="container-fluid">
		<div class="text-center">
			<h2 class="display">Tạo và sửa gói dịch vụ</h2>
		</div>
	</div>
	<br> <br>
	<div class="input-group">
		<div class="">
			<form id="tao_sua-form1" class="form "
				action="${pageContext.request.contextPath}/TaoSuaGoiDichVu?flag=2&cmd=CREATE"
				method="post" enctype="multipart/form-data">
				<div class=" ">

					<div class="">
						<div class="form-group">
							<label>Tên gói chụp:</label>
						</div>
						<div class=" form-group">
							<input type="text" name="tengoi" value="${albumName}"
								<c:if test="${hide =='yes'}">disabled="disabled" </c:if>>
						</div>

						<div class=" form-group">
							<textarea class="" placeholder="Mô tả gói" rows="4" cols="45"
								id="floatingTextarea" name="mota"
								<c:if test="${hide =='yes'}">disabled="disabled" </c:if>>${mota}</textarea>

						</div>
						<c:if test="${hide !='yes'}">
							<div class=" form-group">
								<div class="form-outline">
									<label>Chọn Ảnh Album :</label>
								</div>
							</div>
							<div class=" form-group">
								<div class="form-outline">
									<input type="file" class="btn " id="file" name="file"
										accept="image/x-png,image/gif,image/jpeg" multiple="multiple"
										onchange="return fileValidation()">
								</div>
							</div>
						</c:if>

					</div>
					<div class="">

						<div class="col-5 form-group">
							<label>Thể loại album:</label>
						</div>
						<div class="col-5 form-group">
							<select class="btn btn-outline-dark" name="theloaichup"
								<c:if test="${hide =='yes'}">disabled="disabled" </c:if>>

								<option ${theloai=='1'? 'selected="selected"' : ''} value="1">Chụp
									chân dung</option>
								<option ${theloai=='2'? 'selected="selected"' : ''} value="2">Chụp
									ảnh sự kiện</option>
								<option ${theloai=='3'? 'selected="selected"' : ''} value="3">Chụp
									ảnh cưới</option>
								<option ${theloai=='4'? 'selected="selected"' : ''} value="4">Chụp
									kỷ yếu</option>
								<option ${theloai=='5'? 'selected="selected"' : ''} value="5">Chụp
									ảnh gia đình và bé</option>
								<option ${theloai=='6'? 'selected="selected"' : ''} value="6">Chụp
									sản phẩm</option>
								<option ${theloai=='7'? 'selected="selected"' : ''} value="7">Chụp
									Khác.</option>
							</select>
						</div>
						<div class="col-5 form-group">
							<label>Địa điểm chụp:</label>
						</div>
						<div class=" col-5  form-group">
							<select class="btn btn-outline-dark" name="diadiem"
								<c:if test="${hide =='yes'}">disabled="disabled" </c:if>>
								<c:forEach items="${listLocation}" var="listLocation">
									<option
										${listLocation.locationId==locationId? 'selected="selected"' : ''}
										value="${listLocation.locationId}">
										${listLocation.locationName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-5 form-group">
							<label>Giá:</label>
						</div>
						
							<!-- <!-- <div class="col-5 "> -->
							<div style="margin: 0px 0px 0px 12px;">
								<input type="text" name="price" id="price" value="${price}"
									<c:if test="${hide =='yes'}">disabled="disabled" </c:if>
									class="mr-1" style="text-align: right;">
							</div>
							<!-- </div> -->
							<div style="margin-left: 200px;margin-top: -28px;">
								.000đ
							</div>
					

						<c:if test="${hide !='yes'}">
							<div class="col-5 form-group">
								<label>Đặt cọc:</label>
							</div>

							<div class="col-5 form-group">
								<select class="btn btn-outline-dark " name="datcoc"
									onchange="validateSelectBox(this)">
									<option value="0">0%</option>
									<option value="0.05">5%</option>
									<option value="0.1">10%</option>
									<option value="0.15">15%</option>
									<option value="0.2">20%</option>
								</select>

							</div>
						</c:if>
						<div class="col-5 form-group">
							<label>Tiền cọc:</label> <span id="tiencoc" class="">${deposite}.đ</span>
						</div>


					</div>
				</div>

				<button type="submit"
					class="btn btn-info <c:if test="${hide =='yes'}">collapse</c:if>">Tạo</button>
				<c:if test="${hide =='yes'}">
					<c:url var="updateLink" value="/TaoSuaGoiDichVu">
						<c:param name="flag" value="4" />
						<c:param name="command" value="SHOW" />
					</c:url>
					<a type="submit" href="${updateLink}" class="btn btn-info ">Sửa</a>
				</c:if>
				<a href="${pageContext.request.contextPath}/GoiDichVuLichBan?flag=3"
					class="btn btn-info">Quay Lại</a>
			</form>
		</div>


		<div class="col-5">
			<div class="">
				<label>Ảnh Bìa</label>
			</div>
			<div>
				<c:if test="${coverimage!=null}">
					<img class="rounded"
						src="images/${id}${role}/albums/${albumName}/${coverimage}"
						height=220 width=400 />
				</c:if>
				<c:if test="${coverimage==null}">
					<img class="rounded" src="form/pic/anhchandung.png" height=220
						width=400 />
				</c:if>

			</div>
			<br>
			<div class="">
				<label>Ảnh Album</label>
			</div>
			<div class="">
				<div class="form-image ">
					<div class="scroll">
						<c:forEach items="${listImages}" var="listI">

							<div class="  ">
								<div class="hover hover-1 rounded ">
									<img class="img-fluid "
										src="images/${id}${role}/albums/${albumName}/${listI.imageName}" />
									<div class="hover-overlay"></div>
									<div class="hover-1-noidung  px-5  py-3">
										<div class=" hover-1-trichdan font-weight-light  mb-0"></div>
									</div>
								</div>
							</div>
							<!-- Modal -->

							<br>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>