<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->




<div class="container-fluid  container mx-auto col-9"
	style="margin-left: -10px;">
	<div class=" justify-content-center half">
		<h4 class="text-center"
			style="margin: 10px 0 10px 0; border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 20px;">Đơn
			hàng đặt chụp</h4>

		<c:if test="${hideAll=='yes'}">
			<p
				style="text-align: center; margin-top: 50px; color: red; font-size: 30px;">${notificationNoBooking}</p>
		</c:if>
		<c:if test="${hideAll=='no'}">
			<form id="searchByStatus" name="searchByStatus"
				action="${pageContext.request.contextPath}/manageBooking?flag=4&command=SEARCH"
				method="post">
				<div class="form-block_trangdatchup form-inline"
					style="border: none;">

					<!-- 			<p style="margin-left: 5px;"> Sắp xếp: </p> -->
					<c:if test="${checkRadioReturn=='0'}">
						<input type="radio" checked name="checkRadio" value="0"
							style="margin: 0 5px 0 20px;" />
						<label style="font-size: 16px">Theo ngày ĐẶT CHỤP sớm nhất</label>

						<input type="radio" name="checkRadio" value="1"
							style="margin: 0 5px 0 20px;" />
						<label style="font-size: 16px">Theo ngày CHỤP sớm nhất </label>
					</c:if>

					<c:if test="${checkRadioReturn=='1'}">
						<input type="radio" name="checkRadio" value="0"
							style="margin: 0 5px 0 20px;" />
						<label style="font-size: 16px">Theo ngày ĐẶT CHỤP sớm nhất</label>

						<input type="radio" checked name="checkRadio" value="1"
							style="margin: 0 5px 0 20px;" />
						<label style="font-size: 16px">Theo ngày CHỤP sớm nhất </label>
					</c:if>

					<c:if test="${checkRadioReturn=='null'}">
						<input type="radio" name="checkRadio" value="0"
							style="margin: 0 5px 0 20px;" />
						<label style="font-size: 16px">Theo ngày ĐẶT CHỤP sớm nhất</label>

						<input type="radio" name="checkRadio" value="1"
							style="margin: 0 5px 0 20px;" />
						<label style="font-size: 16px">Theo ngày CHỤP sớm nhất </label>
					</c:if>


					<div class="dropdown"
						style="display: inline-block; font-weight: bold; margin-left: 60px; margin: 10px 20px 10px 50px">
						<select name="itemCategory" class="form-control">
							<option value="0" class=""
								style="font-weight: normal; margin-left: 20px;">Tất cả
								trạng thái</option>



							<c:if test="${returnValue=='0'}">
								<option value="1">Chờ xác nhận</option>
								<option value="2">Chờ đặt cọc</option>
								<option value="3">Chờ chụp</option>
								<option value="4">Chờ hậu kì</option>
								<option value="5">Hoàn thành</option>
								<option value="6">Hủy đặt chụp</option>
							</c:if>
							<c:if test="${returnValue=='1'}">
								<option value="1" selected="selected">Chờ xác nhận</option>
								<option value="2">Chờ đặt cọc</option>
								<option value="3">Chờ chụp</option>
								<option value="4">Chờ hậu kì</option>
								<option value="5">Hoàn thành</option>
								<option value="6">Hủy đặt chụp</option>
							</c:if>

							<c:if test="${returnValue=='2'}">
								<option value="1">Chờ xác nhận</option>
								<option value="2" selected="selected">Chờ đặt cọc</option>
								<option value="3">Chờ chụp</option>
								<option value="4">Chờ hậu kì</option>
								<option value="5">Hoàn thành</option>
								<option value="6">Hủy đặt chụp</option>
							</c:if>

							<c:if test="${returnValue=='3'}">
								<option value="1">Chờ xác nhận</option>
								<option value="2">Chờ đặt cọc</option>
								<option value="3" selected="selected">Chờ chụp</option>
								<option value="4">Chờ hậu kì</option>
								<option value="5">Hoàn thành</option>
								<option value="6">Hủy đặt chụp</option>
							</c:if>

							<c:if test="${returnValue=='4'}">
								<option value="1">Chờ xác nhận</option>
								<option value="2"">Chờ đặt cọc</option>
								<option value="3">Chờ chụp</option>
								<option value="4" selected="selected">Chờ hậu kì</option>
								<option value="5">Hoàn thành</option>
								<option value="6">Hủy đặt chụp</option>
							</c:if>

							<c:if test="${returnValue=='5'}">
								<option value="1">Chờ xác nhận</option>
								<option value="2"">Chờ đặt cọc</option>
								<option value="3">Chờ chụp</option>
								<option value="4">Chờ hậu kì</option>
								<option value="5" selected="selected">Hoàn thành</option>
								<option value="6">Hủy đặt chụp</option>
							</c:if>


							<c:if test="${returnValue=='6'}">
								<option value="1">Chờ xác nhận</option>
								<option value="2"">Chờ đặt cọc</option>
								<option value="3">Chờ chụp</option>
								<option value="4">Chờ hậu kì</option>
								<option value="5">Hoàn thành</option>
								<option value="6" selected="selected">Hủy đặt chụp</option>
							</c:if>

						</select>
					</div>


					<button class="btn btn-primary form-control" type="submit"
						style="width: 40px; height: calc(2.25rem + 2px);">
						<i class="fa fa-search" style="color: white;"></i>
					</button>

				</div>
			</form>
			<hr>

			<div class="form-block_trangdatchup" style="background: #ebebe0">
				<div class="form-inline" style="margin: 10px 0;">
					<span style="margin-left: 30px;">Gói dịch vụ |</span> <span
						style="margin-left: 140px;">Mã đặt chụp |</span><span
						style="margin-left: 15px;">Ngày đặt |</span> <span
						style="margin-left: 15px;">Ngày chụp |</span> <span
						style="margin-left: 15px;">Tiền đặt cọc |</span> <span
						style="margin-left: 15px;">Trạng thái |</span>

				</div>
			</div>


			<div class="form-block_trangdatchup">
				<div class="form-inline">
					<div class="col-sm-12">

						<c:forEach items="${listAll}" var="list">

							<div class="form-inline datchup">
								<div class="col-md-4" style="margin-left: -20px;">
									<div class="hover_danhgia hover-1_danhgia">
										<img
											src="images/${list.servicePackage.photographerID}${rolePhotographer}/albums/${list.servicePackage.servicepackageName}/${list.servicePackage.coverImage}"
											alt="">

										<div class="hover-overlay_danhgia"></div>
										<div class="hover-1-noidung_danhgia">
											<div class="form-inline col-16">
												<!-- 										<span class="fa fa-bookmark bookmark px-3 bk_1" -->
												<!-- 											style="margin-bottom: 32px;"></span> -->
												<p
													style="margin-left: 129px; float: right; text-align: right;"
													class="hover-1-trichdan_danhgia font-weight-light">${list.servicePackage.convertPrice}.đ</p>
											</div>
											<div class="font-weight-light py-0">
												<div class="form-inline col-sm-12">
													<div class="div1_danhgia">
														<c:if test="${list.servicePackage.avatar!=null}">
															<img
																src="images/${list.servicePackage.photographerID}${rolePhotographer}/${list.servicePackage.avatar}"
																style="margin-left: 10px">
														</c:if>
														<c:if test="${list.servicePackage.avatar==null}">
															<img src="form/pic/anhchandung.png"
																style="margin-left: 10px">
														</c:if>
													</div>
													<h6 style="font-size: 14px; margin-left: 40px;"
														class="conten_1 px-1">
														<a href="#" style="color: white;">${list.servicePackage.nickName}</a><br>
														<span class="font-weight-light ">${list.servicePackage.provinceName}
														</span>
													</h6>
												</div>




												<div class="" style="margin-left: 10px;">

													<c:if test="${list.servicePackage.pointRating ==0}">
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>

													</c:if>
													<c:if
														test="${list.servicePackage.pointRating <1.5&&list.servicePackage.pointRating >0}">
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
													</c:if>

													<c:if
														test="${list.servicePackage.pointRating<2.5&&list.servicePackage.pointRating>=1.5}">
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>

													</c:if>

													<c:if
														test="${list.servicePackage.pointRating <3.5&&list.servicePackage.pointRating>=2.5}">
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>

													</c:if>
													<c:if
														test="${list.servicePackage.pointRating<4.5&&list.servicePackage.pointRating>=3.5}">
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star star " style="font-size: 12px;"></span>

													</c:if>

													<c:if test="${list.servicePackage.pointRating>=4.5}">
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>
														<span class="fa fa-star checked " style="font-size: 12px;"></span>

													</c:if>
													<a class="btn btn-default btn-sm"
														style="font-size: 11px; margin-left: 1px;"
														href="${pageContext.request.contextPath}/servicePackage?spID=${list.servicePackage.id}">Xem
														chi tiết</a>
												</div>


											</div>
										</div>
									</div>
								</div>

								<div class="tdc" style="margin: 0 0 0 13px;">
									<table class=""
										style="border: none; margin-bottom: 20px; border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
										<thead>
											<tr class="bang1" style="padding-bottom: 30px;">
												<th style="padding-bottom: 30px;">FL0${list.id }</th>
												<th style="padding-left: 10px; padding-bottom: 30px;">${list.convertCreatedDate}</th>
												<th style="padding-bottom: 30px;">${list.convertTaketDate}</th>
												<th style="padding-left: 10px; padding-bottom: 30px;">${list.convertDeposit}đ</th>
												<th style="padding-bottom: 30px; color: red">${list.statusBooking}</th>
											</tr>
										</thead>
									</table>

									<div class="form-inline">


										<c:if test="${ list.statusBookingId=='2'}">


											<c:url var="CancelBooking" value="/manageBooking?flag=4">
												<c:param name="command" value="CANCEL" />
												<c:param name="bookingId" value="${list.id}" />
												<!--<c:param name="statusId" value="3" /> -->
											</c:url>

											<div>





												<button type="button" class="btn btn-outline-primary"
													data-toggle="modal" data-target=".bd-example-modal-lg">Thanh
													toán cọc</button>

												<div class="modal fade bd-example-modal-lg" tabindex="-1"
													role="dialog" aria-labelledby="myLargeModalLabel"
													aria-hidden="true">
													<div class="modal-dialog modal-lg">
														<div class="modal-content ">
															<div class="form-inline">
																<div class=""
																	style="width: 40%; box-sizing: border-box; padding-bottom: 310px; padding-top: 20px; border-right: 1px solid rgba(0, 0, 0, 0.15);">
																	<div style="margin-left: 20px;">
																		<label style="font-size: 24px; font-weight: bold;">Chọn
																			phương thức thanh toán:</label>
																	</div>
																	<div class="form-inline"
																		style="margin: 30px 0px 30px 20px;">
																		<input type="radio" name="nganhang" value="nganhang"
																			id="check"
																			style="margin-right: 5px; width: 22px; height: 22px;" /><img
																			src="form/pic/atm.png"
																			style="width: 35px; height: 35px; margin-right: 5px;" />
																		<label style="font-size: 17px;">Thanh toán
																			ngân hàng</label>
																	</div>
																	<div class="form-inline"
																		style="margin: 30px 0px 30px 20px;">
																		<input type="radio" name="nganhang" value="momo"
																			id="noCheck"
																			style="margin-right: 5px; width: 22px; height: 22px;" />
																		<img src="form/pic/momo.png"
																			style="width: 35px; height: 35px; margin-right: 5px;"
																			alt=""> <label for="female"
																			style="font-size: 17px;">Thanh toán momo</label>
																	</div>
																</div>
																<div class="" style="width: 60%;">
																	<div class=""
																		style="width: 87%; margin-left: 30px; padding: 20px 0 100px 0;"
																		id="yes">
																		<div
																			style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 20px;">
																			<span
																				style="color: lightslategray; font-size: 24px; margin: 0 5px 0 0; font-weight: bold;">Vui
																				lòng chuyển khoản theo thông tin thanh toán sau:</span>
																		</div>
																		<div
																			style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 20px;">
																			<div>

																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;"><span
																					style="font-weight: bold;">Ngân hàng:</span>
																					VietCombank</span>
																			</div>
																			<div>
																				<span class=""
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Tên
																					chủ tài khoản:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">Nguyễn
																					Tiến Dũng</span>
																			</div>
																			<div>
																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Số
																					tài khoản:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">04239429384834</span>
																			</div>
																			<div>
																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Chi
																					nhánh:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">Chi
																					nhánh Hồ Chí Minh</span>
																			</div>
																		</div>
																		<div
																			style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 20px;">
																			<div>
																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;"><span
																					style="font-weight: bold;">Ngân hàng:</span>
																					ViettinBank</span>
																			</div>
																			<div>
																				<span class=""
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Tên
																					chủ tài khoản:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">Nguyễn
																					Tiến Dũng</span>
																			</div>
																			<div>
																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Số
																					tài khoản:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">04239429384834</span>
																			</div>
																			<div>
																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Chi
																					nhánh:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">Chi
																					nhánh Hồ Chí Minh</span>
																			</div>
																		</div>
																		<div
																			style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 20px;">
																			<div>
																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;"><span
																					style="font-weight: bold;">Ngân hàng:</span>
																					Agribank</span>
																			</div>
																			<div>
																				<span class=""
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Tên
																					chủ tài khoản:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">Nguyễn
																					Tiến Dũng</span>
																			</div>
																			<div>
																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Số
																					tài khoản:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">04239429384834</span>
																			</div>
																			<div>
																				<span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;">Chi
																					nhánh:</span><span
																					style="color: lightslategray; font-size: 17px; margin-right: 5px;">Chi
																					nhánh Hồ Chí Minh</span>
																			</div>
																		</div>
																	</div>
																	<div class=""
																		style="width: 87%; margin-left: 30px; padding-bottom: 330px;"
																		id="no">
																		<div
																			style="border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 20px;">
																			<span
																				style="color: lightslategray; font-size: 24px; margin: 0 5px 0 0; font-weight: bold;">Thông
																				tin thanh toán</span>
																		</div>
																		<div
																			style="margin-bottom: 20px; border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 20px;">
																			<span
																				style="color: lightslategray; font-size: 17px; margin-right: 5px; font-weight: bold;"><br>Số
																				tiền cọc:</span> <span
																				style="color: lightslategray; font-size: 17px; margin-right: 5px;">500.000.000đ</span>
																		</div>
																		<div>
																			<button class="btn btn-outline-warning"
																				style="width: 100%;">Thanh toán ngay</button>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>





											<button type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Cancel${list.id}">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-x-circle"
													viewBox="0 0 16 16">
  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
  <path
														d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"></path>
</svg>
												Hủy đặt chụp
											</button>


											<!-- Modal -->
											<div class="modal fade" id="Cancel${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Hủy
																lịch đặt chụp</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">Bạn sẽ KHÔNG được hoàn tiền
															đặt cọc. Chọn XÁC NHẬN nếu bạn vẫn muốn hủy chụp!</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															<a type="button" href="${CancelBooking}"
																class="btn btn-primary">Xác nhận</a>
														</div>
													</div>
												</div>
											</div>



										</c:if>

										<c:if test="${ list.statusBookingId=='3'}">



											<c:url var="CancelBooking" value="/manageBooking?flag=4">
												<c:param name="command" value="CANCEL" />
												<c:param name="bookingId" value="${list.id}" />
												<!--<c:param name="statusId" value="3" /> -->
											</c:url>

											<button disabled class="btn btn-outline-success">
												<svg xmlns="http://www.w3.org/2000/svg" width="18"
													height="18" fill="currentColor"
													class="bi bi-check-circle-fill" viewBox="0 0 16 16">
  <path
														d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
</svg>

												Đã cọc
											</button>

											<button type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Cancel${list.id}">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-x-circle"
													viewBox="0 0 16 16">
  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
  <path
														d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"></path>
</svg>
												Hủy đặt chụp
											</button>


											<!-- Modal -->
											<div class="modal fade" id="Cancel${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Hủy
																lịch đặt chụp</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">Bạn sẽ KHÔNG được hoàn tiền
															đặt cọc. Chọn XÁC NHẬN nếu bạn vẫn muốn hủy chụp!</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															<a type="button" href="${CancelBooking}"
																class="btn btn-primary">Xác nhận</a>
														</div>
													</div>
												</div>
											</div>




											<c:url var="ComplainBooking" value="/manageBooking?flag=4">
												<c:param name="command" value="COMPLAIN" />
												<c:param name="bookingId" value="${list.id}" />
												<c:param name="phoneNumber" value="${phoneNumber}" />
												<c:param name="title" value="${titleM}" />
												<c:param name="content" value="${messageText}" />
											</c:url>


<c:if test="${list.checkComplaint=='2'}">
									
											<button disabled style="margin-left:5px;" type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Đã xử lý khiếu nại </button>

</c:if>






<c:if test="${list.checkComplaint=='1'}">
									
											<button disabled style="margin-left:5px;" type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Đang khiếu nại </button>

</c:if>

<c:if test="${list.checkComplaint=='0'}">

											<a type="button" style="margin-left:5px;" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Khiếu nại </a>
</c:if>
											<div class="modal fade" id="Complain${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">


												<div class="modal-dialog " role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Gửi
																khiếu nại</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>


														<div class="modal-body">

															<form id="bookingForm"	action="${pageContext.request.contextPath}/manageBooking?flag=4&command=COMPLAINT&bookingId=${list.id}"
																method="post">
																<div class="form-group">
																	<div class="col-10 form-inline">
																		<label style="margin-left: -21px;"message-text">Mã
																			đặt chụp (*): </label> <input style="margin-left: 37px;"
																			readonly="readonly" disabled type="text"
																			style="margin-left:10px;" value="${list.id}" />

																	</div>
																</div>

																<br>
																<div class="form-group">


																	<label style="margin-left: 0px;"message-text">Số
																		điện thoại (*): </label> <input type="text"
																		style="margin-left: 10px;" class="phoneNumber"
																		id="phoneNumber" name="phoneNumber"
																		value="${list.phoneUser}" />
																</div>
																<br>
																<div class="form-group">


																	<label style="margin-left: 0px;"message-text">Tiêu
																		đề (*): </label> <input style="margin-left: 51px;" type="text"
																		size="40" style=" margin-left:20px;" class=""
																		id="titleM" name="titleM" />


																</div>
																<br>
																<div class="form-inline">
																	<label for="message-text" class="col-form-label">Nội
																		dung khiếu nại (*):</label><br> <textarea type="text" cols="120"
																		style="margin-left: 50px;" class="" name="messageText"
																		id="messageText" /></textarea>
																</div>

																<p id="loadlen">${bookingNoti}</p>
																<div style="color: red;" id="chatbox"></div>
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng lại</button>
															<button type="submit" id="booking" name="booking"
																class="btn btn-warning">Gửi khiếu nại</button>
														</div>

														

														</form>
													</div>
												</div>

											</div>




											<button class="btn danger">Liên hệ</button>
										</c:if>

										<c:if test="${ list.statusBookingId=='4'}">

											<button disabled class="btn btn-outline-success">
												<svg xmlns="http://www.w3.org/2000/svg" width="18"
													height="18" fill="currentColor"
													class="bi bi-check-circle-fill" viewBox="0 0 16 16">
  <path
														d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
</svg>

												Đã chụp
											</button>


<c:if test="${list.checkComplaint=='2'}">
									
											<button disabled style="margin-left:5px;" type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Đã xử lý khiếu nại </button>

</c:if>






<c:if test="${list.checkComplaint=='1'}">
									
											<button disabled style="margin-left:5px;" type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Đang khiếu nại </button>

</c:if>

<c:if test="${list.checkComplaint=='0'}">

											<a type="button" style="margin-left:5px;" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Khiếu nại </a>
</c:if>
											<div class="modal fade" id="Complain${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">


												<div class="modal-dialog " role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Gửi
																khiếu nại</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>


														<div class="modal-body">

															<form id="bookingForm"	action="${pageContext.request.contextPath}/manageBooking?flag=4&command=COMPLAINT&bookingId=${list.id}"
																method="post">
																<div class="form-group">
																	<div class="col-10 form-inline">
																		<label style="margin-left: -21px;"message-text">Mã
																			đặt chụp (*): </label> <input style="margin-left: 37px;"
																			readonly="readonly" disabled type="text"
																			style="margin-left:10px;" value="${list.id}" />

																	</div>
																</div>

																<br>
																<div class="form-group">


																	<label style="margin-left: 0px;"message-text">Số
																		điện thoại (*): </label> <input type="text"
																		style="margin-left: 10px;" class="phoneNumber"
																		id="phoneNumber" name="phoneNumber"
																		value="${list.phoneUser}" />
																</div>
																<br>
																<div class="form-group">


																	<label style="margin-left: 0px;"message-text">Tiêu
																		đề (*): </label> <input style="margin-left: 51px;" type="text"
																		size="40" style=" margin-left:20px;" class=""
																		id="titleM" name="titleM" />


																</div>
																<br>
																<div class="form-inline">
																	<label for="message-text" class="col-form-label">Nội
																		dung khiếu nại (*):</label><br> <textarea type="text" cols="120"
																		style="margin-left: 50px;" class="" name="messageText"
																		id="messageText" /></textarea>
																</div>

																<p id="loadlen">${bookingNoti}</p>
																<div style="color: red;" id="chatbox"></div>
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng lại</button>
															<button type="submit" id="booking" name="booking"
																class="btn btn-warning">Gửi khiếu nại</button>
														</div>

														

														</form>
													</div>
												</div>

											</div>

											
											
											<button class="btn danger">Liên hệ</button>
										</c:if>


										<c:if test="${ list.statusBookingId=='5'}">

											<a target="_blank"
												href="${list.productLink }"
												type="button" class="btn btn-outline-warning"> <svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-folder"
													viewBox="0 0 16 16">
  <path
														d="M.54 3.87.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3h3.982a2 2 0 0 1 1.992 2.181l-.637 7A2 2 0 0 1 13.174 14H2.826a2 2 0 0 1-1.991-1.819l-.637-7a1.99 1.99 0 0 1 .342-1.31zM2.19 4a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4H2.19zm4.69-1.707A1 1 0 0 0 6.172 2H2.5a1 1 0 0 0-1 .981l.006.139C1.72 3.042 1.95 3 2.19 3h5.396l-.707-.707z"></path>
</svg> Xem ảnh
											</a>

<c:if test="${list.checkComplaint=='2'}">
									
											<button disabled style="margin-left:5px;" type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Đã xử lý khiếu nại </button>

</c:if>






<c:if test="${list.checkComplaint=='1'}">
									
											<button disabled style="margin-left:5px;" type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Đang khiếu nại </button>

</c:if>

<c:if test="${list.checkComplaint=='0'}">

											<a type="button" style="margin-left:5px;" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Complain${list.id}"><svg
													xmlns="http://www.w3.org/2000/svg" width="16" height="16"
													fill="currentColor" class="bi bi-exclamation-circle"
													viewBox="0 0 16 16">  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>  <path
														d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z"></path></svg>
												Khiếu nại </a>
</c:if>
											<div class="modal fade" id="Complain${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">


												<div class="modal-dialog " role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Gửi
																khiếu nại</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>


														<div class="modal-body">

															<form id="bookingForm"	action="${pageContext.request.contextPath}/manageBooking?flag=4&command=COMPLAINT&bookingId=${list.id}"
																method="post">
																<div class="form-group">
																	<div class="col-10 form-inline">
																		<label style="margin-left: -21px;"message-text">Mã
																			đặt chụp (*): </label> <input style="margin-left: 37px;"
																			readonly="readonly" disabled type="text"
																			style="margin-left:10px;" value="${list.id}" />

																	</div>
																</div>

																<br>
																<div class="form-group">


																	<label style="margin-left: 0px;"message-text">Số
																		điện thoại (*): </label> <input type="text"
																		style="margin-left: 10px;" class="phoneNumber"
																		id="phoneNumber" name="phoneNumber"
																		value="${list.phoneUser}" />
																</div>
																<br>
																<div class="form-group">


																	<label style="margin-left: 0px;"message-text">Tiêu
																		đề (*): </label> <input style="margin-left: 51px;" type="text"
																		size="40" style=" margin-left:20px;" class=""
																		id="titleM" name="titleM" />


																</div>
																<br>
																<div class="form-inline">
																	<label for="message-text" class="col-form-label">Nội
																		dung khiếu nại (*):</label><br> <textarea type="text" cols="120"
																		style="margin-left: 50px;" class="" name="messageText"
																		id="messageText" /></textarea>
																</div>

																<p id="loadlen">${bookingNoti}</p>
																<div style="color: red;" id="chatbox"></div>
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng lại</button>
															<button type="submit" id="booking" name="booking"
																class="btn btn-warning">Gửi khiếu nại</button>
														</div>

														

														</form>
													</div>
												</div>

											</div>




											<button class="btn danger">Liên hệ</button>
									

<a href="${pageContext.request.contextPath}/servicePackage?spID=${list.servicePackage.id}"   type="button" style="margin-left:5px" class="btn btn-outline-danger">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"></path>
</svg>
               Đánh giá
              </a>
         	</c:if>     
										<c:if test="${list.statusBookingId=='6'}">
											<p Style="text-align: center; color: blue">
												Đã hủy lúc "${list.modifyDate}" bởi <b>${ list.modifyBy}</b>
											</p>


<c:if test="${list.statusBeforeCancel=='3'}">

<a href="${pageContext.request.contextPath}/servicePackage?spID=${list.servicePackage.id}" style="margin-left:5px"   type="button" class="btn btn-outline-danger">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"></path>
</svg>
               Đánh giá
              </a>
</c:if>





										</c:if>
										<c:if test="${list.statusBookingId=='1'}">


											<c:url var="CancelBooking" value="/manageBooking?flag=4">
												<c:param name="command" value="CANCEL" />
												<c:param name="bookingId" value="${list.id}" />
												<!--<c:param name="statusId" value="3" /> -->
											</c:url>


											<button type="button" class="btn btn-outline-secondary"
												data-toggle="modal" data-target="#Cancel${list.id}">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-x-circle"
													viewBox="0 0 16 16">
  <path
														d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
  <path
														d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"></path>
</svg>
												Hủy đặt chụp
											</button>


											<!-- Modal -->
											<div class="modal fade" id="Cancel${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Hủy
																lịch đặt chụp</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">Bạn sẽ KHÔNG được hoàn tiền
															đặt cọc. Chọn XÁC NHẬN nếu bạn vẫn muốn hủy chụp!</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>


															<a type="button" href="${CancelBooking}"
																class="btn btn-primary">Xác nhận</a>
														</div>
													</div>
												</div>
											</div>


										</c:if>

									</div>

								</div>
							</div>

						</c:forEach>








					</div>
				</div>
				<c:if test="${hidePageBooking =='no'}">
					<div style="margin-left: 45%; margin-top: 10px;">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link btn-outline-dark"
									href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach items="${page}" var="list">
									<li class="page-item"><a
										class="page-link <c:if test="${param.page ==list}">text-white bg-dark</c:if> 
							<c:if test="${param.page ==null&&list==1}">text-white bg-dark</c:if>"
										href="${pageContext.request.contextPath}/manageBooking?flag=4&page=${list}&checkRadio=${checkRadioReturn}&returnValue=${returnValue}">${list}</a></li>
								</c:forEach>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</c:if>
			</div>
	</div>

	</c:if>


</div>

<script type="text/javascript">
	/* $('document').ready(function() {
		$(".video_btn").hide();
		$(".cntk").hide();
		$("#no").hide();

	});
	$(".show").on('click', function() {
		$(".cntk").show();
		$(".video_btn").show();
		$(".show").hide();
	});
	$('button.hidden').on('click', function() {
		$(".video_btn").hide();
		$(".cntk").hide();
		$(".show").show();
	});
	$("#check").on('click', function() {
		$("#yes").show();
		$("#no").hide();
	});
	$("#noCheck").on('click', function() {
		$("#yes").hide();
		$("#no").show();
	}); */
</script>




<script type="text/javascript">
	$(document).ready(function() {

		$("#bookingForm").validate({

			errorElement : 'div',
			errorPlacement : function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');
				label.insertAfter(element);
			},

			rules : {
				phoneNumber : {
					required : true,
					digits : true,
					minlength : 10,
					maxlength : 10
				},
				titleM : {
					required : true,

					minlength : 5,
					maxlength : 50
				},
				titleM : {
					required : true,

					minlength : 5,
					maxlength : 50
				},
				messageText : {
					required : true,

					minlength : 20,
					maxlength : 400
				}
			},
			messages : {
				phoneNumber : {
					required : "Nhập số điện thoại",
					digits : "Ký tự là số",
					minlength : "Số điện thoại gồm 10 số",
					maxlength : "Số điện thoại gồm 10 số"
				},
				titleM : {
					required : "Nhập tiêu đề",

					minlength : "Ít nhất 5 kí tự",
					maxlength : "Nhiếu nhất 50 kí tự"
				},

				messageText : {
					required : "Nhập nội dung khiếu nại",

					minlength : "Ít nhất 20 kí tự",
					maxlength : "Nhiếu nhất 400 kí tự"
				}
			}
		});
	});
</script>
<script>
	function updateAcctView($val) {
		$.ajax({
			type : "GET",
			url : "/acctView/" + $val,
			success : function(response) {
				$("#account-view").html(response);
			}
		});
	}
</script>

