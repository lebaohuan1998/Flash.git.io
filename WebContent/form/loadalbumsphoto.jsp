<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:forEach items="${listA}" var="list">
	<!--  -->
	<div class="input-group dv_lb">
		<!--  -->
		<div class="">
			<input type="checkbox" style="margin-top: 80px;" class="btn-check"
				name="checkbox" id="btncheck_${list.id}" value="${list.id }" />
		</div>
		<div class=" col-5">
			<div class="hover hover-1 rounded ">
				<img class=""
					src="images/${id}${role}/albums/${list.servicepackageName}/${list.coverImage}"
					alt="">
				<div class="hover-overlay"></div>
				<c:if test="${list.servicePackStatus=='1'}">
					<div class="hover-1-noidung  ">
						<div class="form-inline ">
							<!-- <span class="fa fa-bookmark bookmark px-3 py-5 "
							style="margin-bottom: 80px; font-size: 24px;"></span> -->
							<%-- 	 <span style="margin-left: 20px;font-weight: normal;margin-bottom: -20px;">${list.categoryName }</span> --%>
							<h5 class=" "
								style="margin-bottom: 10px; margin-left: 180px; font-size: 16px;">${list.price}đ</h5>
						</div>
						<div class="font-weight-light py-0">
							<div class="form-inline col-sm-10">
								<h6 class="conten px-1" style="width: 230px;">
									<i class="fa fa-map-marker-alt mr-1" style="padding-right: 5px;"></i><span
										class="font-weight-light ">${list.provinceName}</span> <br>
									<i class="fa fa-camera mr-1"
										style="margin-left: -2px; padding-right: 3px;"></i><span
										style="font-weight: normal; margin-bottom: -20px;">${list.categoryName }</span>
									<a href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}" class=""  target="_blank"
										style="margin-left: 10px; text-decoration: none; color: #17a2b8;">Xem
										Thử</a>
								</h6>
							</div>

						</div>
					</div>
				</c:if>
				<c:if test="${list.servicePackStatus=='0'}">
					<div class="hover-1-noidung  ">
						<div class="form-inline ">
							<h5 class=" "
								style="margin-bottom: 55px; margin-left: 60px; font-size: 20px;">Gói
								chụp đã bị ẩn</h5>
						</div>

					</div>
				</c:if>
			</div>
			<%-- <div class="input-group">

				<div class="form-group">
					<a href="#" class="btn btn-outline-dark mr-5">Xem Thử</a>
				</div>
				<div class="form-group">
					<h4 class="">${list.categoryName }</h4>
				</div>

			</div> --%>
		</div>

			<div class="scheduledate" style="margin-left: 40px;">
				<div style="margin-bottom: -20px;">
					<h5 class="text-info">Lịch làm việc :</h5>
				</div>
				<br>
				<div class="" style="overflow: auto; height: 130px; width: 170px;">
					<c:forEach items="${list.date}" var="listd">
						<c:url var="deleteLink" value="/GoiDichVuLichBan">
							<c:param name="command" value="DELETEDATE" />
							<c:param name="idDate" value="${listd.id}" />
						</c:url>
						<div class="input-group">
							<div class="form-group" style="margin-top: 2px;">
								<h6 class=" mr-3">${listd.date }</h6>
							</div>
							<div class="form-group">
								<b><a data-toggle="modal"
									data-target="#deleteModal${listd.id}" class="text-info">Xóa</a></b>
							</div>
							<div class="modal fade" id="deleteModal${listd.id}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Xóa Lịch
												Bận</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">Bạn Muốn xóa lịch bận?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Đóng</button>
											<a class="btn btn-primary" href="${deleteLink}">Xóa</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
	</div>
	<br>
</c:forEach>