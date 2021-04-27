<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

	
<div class="container-fluid col-9"
	style="margin-left: -10px; margin-right: -100px;">
	<h4 class="text-center"
		style="margin: 0 0 10px 0; border-bottom: 1px solid rgba(0, 0, 0, 0.15); padding-bottom: 10px;">Quản
		lý đơn hàng đặt chụp</h4>
		
		
		<c:if test="${hideAll=='yes'}">
		<p style="text-align: center;margin-top:50px;color: red; font-size: 30px;" >${notificationNoBooking}</p>
			</c:if>
			<c:if test="${hideAll=='no'}">
		<form id="searchByStatus" name="searchByStatus"  action="${pageContext.request.contextPath}/ManageBookingPhotographer?flag=6&command=SEARCH" method="post"> 
		
		
		
	<div class="form-block_datchupphoto" style="border: none;">
		<div class="form-inline" style="margin-top: 0px;">
		
					<c:if test="${checkRadioReturn=='0'}">
			<input type="radio" checked  name="checkRadio"  value="0" style="margin: 0 5px 0 20px; " />
			<label style="font-size:16px" >Theo ngày ĐẶT CHỤP sớm nhất</label> 
			
			<input type="radio" name="checkRadio" value="1" 	style="margin: 0 5px 0 20px;" />
			<label style="font-size:16px">Theo ngày CHỤP sớm nhất </label>
			</c:if>
			
			<c:if test="${checkRadioReturn=='1'}">
			<input type="radio"  name="checkRadio"  value="0" style="margin: 0 5px 0 20px; " />
			<label style="font-size:16px" >Theo ngày ĐẶT CHỤP sớm nhất</label> 
			
			<input type="radio" checked  name="checkRadio" value="1" 	style="margin: 0 5px 0 20px;" />
			<label style="font-size:16px">Theo ngày CHỤP sớm nhất </label>
			</c:if>
			
			<c:if test="${checkRadioReturn=='null'}">
			<input type="radio"  name="checkRadio"  value="0" style="margin: 0 5px 0 20px; " />
			<label style="font-size:16px" >Theo ngày ĐẶT CHỤP sớm nhất</label> 
			
			<input type="radio"  name="checkRadio" value="1" 	style="margin: 0 5px 0 20px;" />
			<label style="font-size:16px">Theo ngày CHỤP sớm nhất </label>
			</c:if>

				
			
			<div class="dropdown" style="display: inline-block; font-weight: bold; margin-left:60px; margin: 10px 20px 10px 50px">
			<select name="itemCategory" class="form-control"> 
					<option value="0" class="" style="font-weight: normal; margin-left: 20px;">Trạng thái khả dụng</option>
					
				
					
					<c:if test="${returnValue=='0'}">
					<option value="1" >Chờ xác nhận</option>
					<option value="2">Chờ đặt cọc</option>
					<option value="3" > Chờ chụp</option>
					<option value="4">Chờ hậu kì</option>
					<option value="5">Hoàn thành</option>
					<option value="6">Hủy đặt chụp</option>
					</c:if>
					<c:if test="${returnValue=='1'}">
					<option value="1" selected="selected">Chờ xác nhận</option>
					<option value="2">Chờ đặt cọc</option>
					<option value="3" > Chờ chụp</option>
					<option value="4">Chờ hậu kì</option>
					<option value="5">Hoàn thành</option>
					<option value="6">Hủy đặt chụp</option>
					</c:if>
					
					<c:if test="${returnValue=='2'}">
					<option value="1" >Chờ xác nhận</option>
					<option value="2" selected="selected">Chờ đặt cọc</option>
					<option value="3" > Chờ chụp</option>
					<option value="4">Chờ hậu kì</option>
					<option value="5">Hoàn thành</option>
					<option value="6">Hủy đặt chụp</option>
					</c:if>
					
					<c:if test="${returnValue=='3'}">
					<option value="1" >Chờ xác nhận</option>
					<option value="2" >Chờ đặt cọc</option>
					<option value="3" selected="selected" > Chờ chụp</option>
					<option value="4">Chờ hậu kì</option>
					<option value="5">Hoàn thành</option>
					<option value="6">Hủy đặt chụp</option>
					</c:if>
					
					<c:if test="${returnValue=='4'}">
					<option value="1" >Chờ xác nhận</option>
					<option value="2" ">Chờ đặt cọc</option>
					<option value="3" > Chờ chụp</option>
					<option value="4" selected="selected" >Chờ hậu kì</option>
					<option value="5">Hoàn thành</option>
					<option value="6">Hủy đặt chụp</option>
					</c:if>
					
						<c:if test="${returnValue=='5'}">
					<option value="1" >Chờ xác nhận</option>
					<option value="2" ">Chờ đặt cọc</option>
					<option value="3" > Chờ chụp</option>
					<option value="4" >Chờ hậu kì</option>
					<option value="5" selected="selected" >Hoàn thành</option>
					<option value="6">Hủy đặt chụp</option>
					</c:if>
					
					
						<c:if test="${returnValue=='6'}">
					<option value="1" >Chờ xác nhận</option>
					<option value="2" ">Chờ đặt cọc</option>
					<option value="3" > Chờ chụp</option>
					<option value="4" >Chờ hậu kì</option>
					<option value="5"  >Hoàn thành</option>
					<option value="6" selected="selected">Hủy đặt chụp</option>
					</c:if>
					
				</select>
				</div>
			
			
			
			
			<button class="btn btn-primary form-control" type="submit"
				style="width: 40px; height: calc(2.25rem + 2px);">
				<i class="fa fa-search" style="color: white;"></i>
			</button>
		</div>
	</div>
	
	</form>
	
	<div class="form-block_datchupphoto" style="background: #ebebe0">
		<div class="form-inline" style="margin: 10px 0;">
			<span style="margin-left: 30px;">Gói dịch vụ</span> <span
				style="margin-left: 160px;">Mã đơn hàng</span><span
				style="margin-left: 10px;">Ngày đặt</span> <span
				style="margin-left: 30px;">Ngày chụp</span> <span
				style="margin-left: 17px;">Tiền đặt cọc</span> <span
				style="margin-left: 11px;">Trạng thái</span>

		</div>
	</div>
	<div class="form-block_datchupphoto">
	
	
		<div class="form-inline" style="margin-top: 5px;">
			<div class="col-sm-12">
			
				<c:forEach items="${listAll}" var="list">	
			
			<form id="AcceptForm" >
				<div class="form-inline datchup_photo">
					<div class="col-md-4" style="margin-left: -10px;">
						<div class="hover_danhgia hover-1_danhgia">
							<img src="images/${list.servicePackage.photographerID}${rolePhotographer}/albums/${list.servicePackage.servicepackageName}/${list.servicePackage.coverImage}" alt="">
							<div class="hover-overlay_danhgia"></div>
							<div class="hover-1-noidung_danhgia">
								<div class="form-inline col-16">
									<span
										style="margin-left: 13px; font-weight: normal; margin-bottom: -62px;"><span class="fas fa-map-marker-alt" style="margin-right: 7px;"></span>${list.servicePackage.provinceName}</span>
									<h5 class=""
										style="margin-bottom: 20px; margin-left: 130px; font-size: 16px;">${list.convertPrice}.đ</h5>
								</div>
									<div class="font-weight-light py-0">
									<div class="form-inline col-sm-12"></div>
									<div class="" style="">
										<span class="fa fa-user" style="margin-left: 13px;margin-right: 10px;"><a href="${pageContext.request.contextPath}/user?userId=${list.user.id}" style="color: white;margin-left: 7px;">${list.user.fullName} </a>
										</span><span style="margin-left: 20px;"><a class="btn btn-sm" style="color: blue;font-size: 11px;margin-left: 1px;" href="${pageContext.request.contextPath}/servicePackage?spID=${list.servicePackage.id}">Xem chi tiết</a>				</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tdc_photo" style="margin: 0 0 0 13px;">
						<table class=""
							style="border: none; padding-bottom: 100px; border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
							<thead>
								<tr class="bang1_photo" style="padding-bottom: 30px;">
									<th style="padding-bottom: 30px;">${list.id}</th>
									<th style="padding-left: 4px; padding-bottom: 30px;">${list.convertCreatedDate}</th>
									<th style="padding-bottom: 30px;">${list.convertTaketDate}</th>
									<th style="padding-left: 5px; padding-bottom: 30px;">${list.convertDeposit}đ</th>
									<th style="padding-bottom: 30px;"><b>${list.statusBooking}</b></th>
								</tr>
							</thead>
						</table>
						
						
						
						
						<div class="form-inline" style="margin-top: 20px;">
						
						
						
							<c:if test="${list.statusBookingId=='1'}">

							
											<a style="margin-right: 8px;" type="button" class="btn btn-outline-primary"
												data-toggle="modal" data-target="#discribe${list.id}"> Xem yêu cầu
												</a>

											<!-- Modal -->
											<div class="modal fade" id="discribe${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">
															Xem yêu cầu khách hàng</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">${list.description}</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															
														</div>
													</div>
												</div>
											</div>

							
							
										<c:url var="CancelBooking" value="/ManageBookingPhotographer?flag=6">
												<c:param name="command" value="CANCEL" />
												<c:param name="bookingId" value="${list.id}" />
										
											</c:url>


									<button type="button" style ="margin-right: 5px;"class="btn btn-outline-secondary"	data-toggle="modal" data-target="#Cancel${list.id}">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
  <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"></path>
</svg>      Từ chối chụp
              </button>

											<!-- Modal -->
											<div class="modal fade" id="Cancel${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Từ chối đặt chụp</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">Không thể hoàn lại tác vụ này! Bạn có chắc chắn hủy lịch chụp?</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															<a  type="button" href="${CancelBooking}"
																class="btn btn-primary" >Xác nhận</a>
														</div>
													</div>
												</div>
											</div>

															
								
<!-- 									<c:url var="AcceptBooking" value="/ManageBookingPhotographer?flag=6"> -->
<!-- 												<c:param name="command" value="ACCEPT" /> -->
<%-- 												<c:param name="bookingId" value="${list.id}" /> --%>
<%-- <%-- 												<c:param name="photographerId" value="${list.photographerId}" /> --%> --%>
<!-- 												<c:param name="statusId" value="3" /> -->
<!-- 											</c:url> -->
											<c:url var="AcceptBooking" value="/ManageBookingPhotographer?flag=6">
												<c:param name="command" value="ACCEPT" />
												<c:param name="bookingId" value="${list.id}" />
										
											</c:url>

											<button  type="button" class="btn btn-outline-success"
												data-toggle="modal" data-target="#accept${list.id}">
												Đồng ý chụp</button>
										
											<!-- Modal -->
											<div class="modal fade" id="accept${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">Đồng ý chụp</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">Không thể hoàn lại tác vụ này! Bạn có chắc chắn ĐỒNG Ý chụp?</div>
														<div style="margin-left:25px;color: red;" id="chatbox" ></div>
														<div class="modal-footer">
															<a type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</a>
<%-- 																<a type="button" href="${AcceptBooking}"  class="btn btn-secondary"	>Xác nhận</a> --%>
															<button onclick="window.location.href='${AcceptBooking}'" type="button" id ="acceptx"  href="${AcceptBooking}"
																class="btn btn-primary">Xác nhận</button>
																
          				<input id="bokingIdvl${list.id}" class="collapse" value="${list.id}">
																
														</div>
													</div>
												</div>
											</div>
											</form>
							
							
							
							<button class="btn btn-outline-danger" style="margin-left: 10px;">Liên
								hệ</button>
								</c:if>
										<c:if test="${list.statusBookingId=='2'}">
										
											<a style="margin-right: 8px;" type="button" class="btn btn-outline-primary"
												data-toggle="modal" data-target="#discribe${list.id}"> Xem yêu cầu
												</a>

											<!-- Modal -->
											<div class="modal fade" id="discribe${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">
															Xem yêu cầu khách hàng</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">${list.description}</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															
														</div>
													</div>
												</div>
											</div>
											
													

										</c:if>
										
										
										<c:if test="${list.statusBookingId=='3'}">
										
											<a style="margin-right: 8px;" type="button" class="btn btn-outline-primary"
												data-toggle="modal" data-target="#discribe${list.id}"> Xem yêu cầu
												</a>

											<!-- Modal -->
											<div class="modal fade" id="discribe${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">
															Xem yêu cầu khách hàng</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">${list.description}</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															
														</div>
													</div>
												</div>
											</div>

<button disabled class="btn btn-outline-success">					
<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
</svg>

	Đã đặt cọc</button>	
	
	
	
							<c:url var="taken" value="/ManageBookingPhotographer?flag=6">
												<c:param name="command" value="TAKEN" />
												<c:param name="bookingId" value="${list.id}" />
										
											</c:url>
	
										
											<button style="margin-left: 5px;" type="button" class="btn btn-outline-primary"
												data-toggle="modal" data-target="#taken${list.id}"> Xác nhận đã chụp
												</button>

											<!-- Modal -->
											<div class="modal fade" id="taken${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">
															Xác nhận chụp xong</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">Bạn có xác nhận chụp xong? </div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
																<a  type="button" id ="taken"  href="${taken}"
																class="btn btn-primary">Xác nhận</a>
															
														</div>
													</div>
												</div>
											</div>
	
	
	
	
	

							<button class="btn btn-outline-danger" style="margin-left: 10px;">Liên
								hệ</button>
										</c:if>
										
										
										
										<c:if test="${list.statusBookingId=='4'}">
										
											<a style="margin-right: 8px;" type="button" class="btn btn-outline-primary"
												data-toggle="modal" data-target="#discribe${list.id}"> Xem yêu cầu
												</a>

											<!-- Modal -->
											<div class="modal fade" id="discribe${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabelx">
															Xem yêu cầu khách hàng</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">${list.description}</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															
														</div>
													</div>
												</div>
											</div>
											
											
											<button disabled style="margin-right:7px;" class="btn btn-outline-success">					
<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
</svg>

	Đã chụp</button>	
	
	
	
	
	
	<c:url var="addFolder" value="ManageBookingPhotographer?flag=6">
												<c:param name="command" value="AddFolder" />
												<c:param name="bookingId" value="${list.id}" />
												<c:param name="folderImage" value="${folderImage}" />
												<c:param name="checkDone" value="${checkDone}" />
												
											</c:url>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
<button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#addFolder${list.id}">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-plus" viewBox="0 0 16 16">
  <path d="M8 6.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V11a.5.5 0 0 1-1 0V9.5H6a.5.5 0 0 1 0-1h1.5V7a.5.5 0 0 1 .5-.5z"></path>
  <path d="M14 4.5V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h5.5L14 4.5zm-3 0A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h-2z"></path>
</svg>
               Thêm thư mục ảnh
              </button>
	 					
	 					
	 <div class="modal fade" id="addFolder${list.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  		<div class="modal-dialog" role="document">
    <div class="modal-content">
    

    
      <div class="modal-header">
        <h5 class="modal-title" id="addFolder${list.id}">Gửi ảnh cho khách hàng</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
     
            <div class="modal-body">
           <form id="bookingForm" role="form" method="post"  action="${pageContext.request.contextPath}/ManageBookingPhotographer?flag=6&command=AddFolder&bookingId=${list.id}" >  
  
         

  <div class="form-group">
    
  <label  style ="margin-left: 10px;font-size:18px; for="message-text">Thư mục ảnh khách hàng (*): </label>
  
    <input required placeholder="https://drive.google.com/drive... " 	oninvalid="this.setCustomValidity('Bạn chưa có đường dẫn ảnh')"
								onchange="this.setCustomValidity('')"    style ="margin-left:21px;margin-top: 10px;"   type="text" size="50" style=" margin-left:10px;" class=""  name="folderImage"   />
    
    
  </div>
  
       <div class="form-inline">
    <input required="required" oninvalid="this.setCustomValidity('Bạn cần xác nhận')"
								onchange="this.setCustomValidity('')"  type="checkbox" class="form-check-input"  name="checkDone">
    <br>
    <label style ="text-align:left; 0px;font-size: 18px; class="form-check-label" for="exampleCheck1"> Xác nhận hoàn thành </label>
  </div>      
        <input id="bookingId" name="bookingId" class="collapse" value="${list.id}">
               
   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng lại</button>
        <button type="submit"   name="command" id ="command" value="AddFolder" class="btn btn-warning">Gửi ảnh </button>
       </div>  
     
    </form>
  
    </div>
  </div>
   
</div>

							<button class="btn btn-outline-danger" style="margin-left: 10px;">Liên
								hệ</button>
										</c:if>
										
										
										
										
										
										<c:if test="${list.statusBookingId=='5'}">
										
											<a style="margin-right: 8px;" type="button" class="btn btn-outline-primary"
												data-toggle="modal" data-target="#discribe${list.id}"> Xem yêu cầu
												</a>

											<!-- Modal -->
											<div class="modal fade" id="discribe${list.id}" tabindex="-1"
												role="dialog" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">
															Xem yêu cầu khách hàng</h5>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">${list.description}</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
															
														</div>
													</div>
												</div>
											</div>





<button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#updateFolder${list.id}">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-plus" viewBox="0 0 16 16">
  <path d="M8 6.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V11a.5.5 0 0 1-1 0V9.5H6a.5.5 0 0 1 0-1h1.5V7a.5.5 0 0 1 .5-.5z"></path>
  <path d="M14 4.5V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h5.5L14 4.5zm-3 0A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h-2z"></path>
</svg>
               Cập nhập thư mục ảnh
              </button>
	 					
	 					
	 <div class="modal fade" id="updateFolder${list.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  		<div class="modal-dialog" role="document">
    <div class="modal-content">
    

    
      <div class="modal-header">
        <h5 class="modal-title" id="updateFolder${list.id}">Cập nhập thư mục ảnh khách hàng</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
     
            <div class="modal-body">
           <form id="bookingForm" role="form" method="post"  action="${pageContext.request.contextPath}/ManageBookingPhotographer?flag=6&command=AddFolder&bookingId=${list.id}" >  
  
         

  <div class="form-group">
    
  <label  style ="margin-left: 10px;font-size:18px; for="message-text">Thư mục ảnh (*): </label>
  
    <input required value="${list.productLink}"	oninvalid="this.setCustomValidity('Bạn chưa có đường dẫn ảnh')"
								onchange="this.setCustomValidity('')"    style ="margin-left:12px;margin-top: 10px;"   type="text" size="46" style=" margin-left:10px;" class=""  name="folderImage"   />
    <a style="margin-left: 10px;margin-top: 5px;" target="_blank" href="${list.productLink}"> Xem thử</a>
    
  </div>
  
       
        <input id="bookingId" name="bookingId" class="collapse" value="${list.id}">
               
   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng lại</button>
        <button type="submit"   name="command" id ="command" value="UpdateFolder" class="btn btn-warning">Cập nhập </button>
       </div>  
     
    </form>
  
    </div>
  </div>
   
</div>













							<button class="btn btn-outline-danger" style="margin-left: 10px;">Liên
								hệ</button>
										</c:if>
										
										
										
						
								<c:if test="${list.statusBookingId=='6'}">
								<p Style="text-align: center; color:blue"> Đơn đặt chụp đã hủy lúc "${list.modifyDate}" bởi <b>${ list.modifyBy}</b></p>
								</c:if>
					
						</div>
						
						
						
						
					</div>
				</div>
				
				</form>
				
				</c:forEach>
				
			
				
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
									href="${pageContext.request.contextPath}/ManageBookingPhotographer?flag=6&page=${list}&checkRadio=${checkRadioReturn}&returnValue=${returnValue}">${list}</a></li>
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


<script>
$(document).ready(function(){
	$('[data-tooltip="tooltip"]').tooltip({html: true});
});
</script>
<script type="text/javascript"> 

$("#acceptx").click(function() {
	
	    $("#acceptx").attr("disabled", true);
  
   
    setTimeout(function(){
    	  $('#chatbox').html("Bạn đã chấp nhận chụp thành công!");
    }, 4000)    

    setTimeout(function(){
    	 window.location.reload();
    }, 8000)     
             
});

 </script>
 
 
 
	<script type="text/javascript">
	$(document).ready(function() {
	
	$("#bookingForm").validate({
	
	errorElement: 'div',
	errorPlacement: function(label, element) {
		label.addClass('alert alert-danger p-1 my-1');	
		label.insertAfter(element);
	},
	
	
	  rules: {
		  phoneNumber: {
	      required: true,
	      digits: true,
	      minlength: 10,
	      maxlength:10
	    }
	  },
	  messages: {
		  phoneNumber: {
			  required: "Nhập số điện thoại",
	        digits: "Ký tự là số",
          minlength: "Số điện thoại gồm 10 số",
			maxlength: "Số điện thoại gồm 10 số"
	    }
	  }
	});
 
	});
	</script>
		
 
 
 
 
 
 
 <script type="text/javascript">
$(document).ready(
	function() {
		$.validator.addMethod("notNumb", function(value) {
			var reg = /^\D*$/;
			return value.trim().match(reg);
		},
		);

		$("#AddFolder").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');
				label.insertAfter(element);
			},
			rules: {
				folderImage: {
					required: true,
					maxlength: 100,
					minlength:5,
				},
			
				checkDone: {
					required: true,
					
				},
			},
			messages: {

				folderImage: {
					required: "Nhập tên gói dịch vụ ",
					maxlength: "Tên tối đa 100 ký tự",
					minlength: "Tên tối đa 5 ký tự",
				},
				
				price: {
					required: "Nhập giá tiền",
					maxlength: "Nhập tối đa 11 số",
				},
			},
		});	
	});
</script>
	
 
 
 
 
<script type="text/javascript">
    function AddFolderxxx($val) {
    	
    	 if($("#addFolder").valid()){ 
    	
        $.ajax({
          
            url:  '${APIurl}?command=AddFolder',
            type: "GET",  
            data : {
    			id1 : $val,
    			
    		},
            success: function(result) {
            	alert("dung cmnr");
            	window.location.reload();
               
            }
            ,
    		error : function(error) {
    			alert("sai cmnr");
    		}
        });
        
    	 } else {
	        	alert("Vui lòng kiểm tra thông tin số điện thoại");
	        	 
	        }
    });
    }               
</script>
 
 
 
 
 
