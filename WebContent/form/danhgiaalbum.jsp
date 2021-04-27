<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Chi tiết</title>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

<script async defer crossorigin="anonymous"
	src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v10.0&appId=282640996385552&autoLogAppEvents=1"
	nonce="25v1Vk9y"></script>




<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 	<link href="https://fonts.googleapis.com/css?family=Raleway:200,100,400" rel="stylesheet" type="text/css" /> -->

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link
	href="${pageContext.request.contextPath}/public/js/jQueryStar/css/star-rating.css"
	media="all" rel="stylesheet" type="text/css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/public/js/jQueryStar/js/star-rating.js"
	type="text/javascript"></script>






<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<link rel="stylesheet" href="public/css/style.css">
<link rel="stylesheet" href="public/css/menuver2.css">
<link rel="stylesheet" href="public/css/csshomepage.css">
<link rel="stylesheet" href="public/css/danhgiaalbum.css">
<link rel="stylesheet" href="public/css/bootstrap.min.css">

<!-- <link rel="stylesheet" href="public/css/chitietgoichup.css"> -->
<link rel="stylesheet" href="public/css/danhsachyeuthich.css">


<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css"
	rel="stylesheet" />
<script src="public/js/jquery.popup.lightbox.js"></script>
<link href="public/css/popup-lightbox.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="include/navbar.jsp"%>
	<div class="container-fluid  container mx-auto  ">
		<div class=" justify-content-center half">



			<form class="form-block_trangdanhgia"">

				<div class="form-inline " style="margin-left: 20px;">
					<div class="form-group ">
						<c:if test="${pom.avata==null}">
							<img src="form/pic/anhchandung.png" id="myImg" class="rounded"
								alt="your image" height=130 width=190>
						</c:if>

						<c:if test="${pom.avata!=null}">
							<img
								src="images/${album.photographerID}${rolePhotographer}/${pom.avata}"
								id="myImg" class="rounded" alt="your image" height=130 width=190>
						</c:if>

						<%-- 						<c:if test="${pom.avata!=null}"> --%>
						<%-- 							<img src="images/${pom.email}${rolePhotographer}/${pom.avata}" --%>
						<!-- 								class="rounded" alt="your image" style="height=130px; width=190px"> -->

						<%-- 						<c:if test="${pom.avata==null}"> --%>
						<!-- 							<img src="form/pic/anhchandung.png" class="rounded" -->
						<!-- 								alt="your image" -->
						<!-- 								style="height=130px; width=190px"> -->
						<%-- 										</c:if> --%>


					</div>
					<div class="content-photo px-3" style="margin-top: 5px;">
						<h6 class="font-weight-bold ">
							<a class="" style="font-weight: normal; padding-left: 5px;"
								href="${pageContext.request.contextPath}/photographer?photographerId=${album.photographerID}">${pom.nickName}</a>
						</h6>
						<h6 class="font-weight-bold">
							<i class="fa fa-users" aria-hidden="true"></i> <span class=""
								style="font-weight: normal;">${pom.organize}</span>
						</h6>
						<h6 class="font-weight-bold">
							<i class="fa fa-map-marker" style="margin-right: 3px;"></i><span
								class="" style="font-weight: normal;">
								${pom.provinceName}</span>
						</h6>
						<h6 class="font-weight-bold">
							<i class="far fa-thumbs-up" aria-hidden="true"
								style="margin-right: 3px;"></i><span class=""
								style="font-weight: normal;"> ${pom.countFollower} người
								theo dõi </span>
						</h6>
					</div>
					<div class="col-sm-1 iconshare"
						style="margin-top: -100px; margin-left: 260px;"></div>
					<div style="padding-top: 10px;">
						<div>
							<br>
							<c:if test="${showFollowed=='yes' }">
								<button id="btnfollow" type="summit"
									class="btn btn-sm btn-outline-secondary">
									<svg xmlns="http://www.w3.org/2000/svg" width="30" height="16"
										fill="currentColor" class="bi bi-bookmark-heart"
										viewBox="0 0 16 16">
  <path fill-rule="evenodd"
											d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
											d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
									Theo dõi ngay
								</button>

								<input id="iduser" class="collapse" value="${id}">
								<input id="idphoto" class="collapse" value="${idPhoto}">
							</c:if>
							<c:if test="${showFollowed=='no' }">
								<button id="btnfollow" type="summit"
									class="btn btn-sm btn-outline-secondary" disabled>
									<svg xmlns="http://www.w3.org/2000/svg" width="30" height="16"
										fill="currentColor" class="bi bi-bookmark-heart"
										viewBox="0 0 16 16">
  <path fill-rule="evenodd"
											d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
											d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
									Đã theo dõi
								</button>

								<input id="iduser" class="collapse" value="${id}">
								<input id="idphoto" class="collapse" value="${idPhoto}">
							</c:if>


							<br> <br>


							<button type="button" class="btn btn-outline-secondary">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-chat-dots" viewBox="0 0 16 16">
  <path
										d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"></path>
  <path
										d="M2.165 15.803l.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z"></path>
</svg>
								Liên hệ
							</button>


							<br> <br>
							<!-- <p style="font-size: 14px"></p> -->
						</div>
					</div>
				</div>

			</form>




			<div class="form-block_trangdanhgia container"
				style="border-bottom: none;">
				<div class=" row">



					<div
						style="border-bottom: 0px solid rgba(0, 0, 0, 0.15); margin-top: 10px;"
						class="col-sm-8">
						<div class="container1 px-3"
							style="margin-top: 0px; padding-top: 0px; margin-bottom: 0px;">
							<div class="img-container1">


								<c:forEach items="${listImages}" var="listI">
									<img class="img-fluid"
										src="images/${album.photographerID}${rolePhotographer}/albums/${album.servicepackageName}/${listI.imageName}"
										alt="${album.servicepackageName} ( Thể loại: ${album.categoryName} )" />


								</c:forEach>
							</div>
						</div>



					</div>





					<div class="container2 dgal col-sm-4"
						style="padding-top: 5px; margin-top: 5px;">
						<div style="margin-top: 2px; margin-left: 20px;">



							<c:if test="${clickBooking=='noUser'}">
								<a href="${pageContext.request.contextPath}/LoginServlet"
									target="_blank" class="btn btn-outline-danger"
									style="margin-right: 13px;">Đặt chụp ngay</a>

							</c:if>



							<c:if test="${clickBooking=='disable'}">
								<button href="#" class="btn btn-outline-danger" disabled
									style="margin-right: 13px;">Đặt chụp ngay</button>

							</c:if>

							<c:if test="${clickBooking=='enable'}">
								<button type="button" class="btn btn-outline-danger"
									data-toggle="modal" data-target="#exampleModal">Đặt
									chụp ngay</button>
							</c:if>
							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">


								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Đặt chụp</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>


										<div class="modal-body">

											<form id="bookingForm">
												<div class="form-group">
													<div class="col-10 form-inline">
														<label style="margin-left: -19px;"message-text">Ngày
															đặt chụp (*): </label> <input onchange="checkDate()" required
															type="date" style="margin-left: 10px;" class="datepicker"
															id="datepicker" />

													</div>
												</div>
												<br>
												<div class="form-group">


													<label style="margin-left: 0px;"message-text">Số
														điện thoại (*): </label> <input type="text"
														style="margin-left: 10px;" class="phoneNumber"
														id="phoneNumber" name="phoneNumber" value="${phoneNumber}" />
												</div>
												<div class="form-group">
													<label for="message-text" class="col-form-label">Ghi
														chú thêm:</label>
													<textarea maxlength="400" class="form-control"
														id="message-text"></textarea>
												</div>

												<p id="loadlen">${bookingNoti}</p>
												<div style="color: red;" id="chatbox"></div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Đóng lại</button>
											<button type="button" id="booking" name="booking"
												class="btn btn-warning">Đặt Chụp</button>
										</div>

										<input id="iduser" class="collapse" value="${id}"> <input
											id="idServicePackage" class="collapse"
											value="${idServicePackage}">

										</form>
									</div>
								</div>

							</div>







							<c:if test="${showSaved=='yes' }">
								<a href="#" id="btnSave"
									style="margin-top: 0px; margin-left: 15px;"
									class="btn btn-outline-warning"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-bookmarks"
										viewBox="0 0 16 16"> 
						<path
											d="M2 4a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v11.5a.5.5 0 0 1-.777.416L7 13.101l-4.223 2.815A.5.5 0 0 1 2 15.5V4zm2-1a1 1 0 0 0-1 1v10.566l3.723-2.482a.5.5 0 0 1 .554 0L11 14.566V4a1 1 0 0 0-1-1H4z"></path> <path
											d="M4.268 1H12a1 1 0 0 1 1 1v11.768l.223.148A.5.5 0 0 0 14 13.5V2a2 2 0 0 0-2-2H6a2 2 0 0 0-1.732 1z">
						</path> </svg> Lưu gói chụp
								</a>
							</c:if>

							<c:if test="${showSaved=='no' }">
								<button disabled href="#" id="btnSave"
									style="margin-top: 0px; margin-left: 10px;"
									class="btn btn-outline-warning">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-bookmarks"
										viewBox="0 0 16 16"> 
						<path
											d="M2 4a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v11.5a.5.5 0 0 1-.777.416L7 13.101l-4.223 2.815A.5.5 0 0 1 2 15.5V4zm2-1a1 1 0 0 0-1 1v10.566l3.723-2.482a.5.5 0 0 1 .554 0L11 14.566V4a1 1 0 0 0-1-1H4z"></path> <path
											d="M4.268 1H12a1 1 0 0 1 1 1v11.768l.223.148A.5.5 0 0 0 14 13.5V2a2 2 0 0 0-2-2H6a2 2 0 0 0-1.732 1z">
						</path> </svg>
									Đã lưu gói chụp
								</button>
							</c:if>


							<input id="iduser" class="collapse" value="${id}"> <input
								id="idServicePackage" class="collapse"
								value="${idServicePackage}">









						</div>



						<div class="dgal1" style="">

							<h5 class="font-weight-bold" style="margin: 0px 10px 10px 20px;">
								<div class="dgal2" style="padding-top: 10px;">

									<span class="font-weight-light" style="margin-top: 10px;"><i
										class="fa fa-dollar fa-lg fa-fw" style="color: #c7bcbc"></i></span> <span
										style="font-size: 20px; font-weight: normal; margin-bottom: 10px">Giá:
										${album.convertPrice}đ</span>
								</div>
								<div class="dgal2">
									<span class="font-weight-light "><i
										class="fa fa-credit-card" style="color: #556955"></i></span> <span
										style="font-weight: normal;"> Đặt cọc:
										${album.convertDeposit} đ</span>
								</div>
								<div class="dgal2">
									<span class="font-weight-light"><i
										class='fas fa-map-marker-alt' style="color: #838392"></i></span><span
										style="font-weight: normal;"> ${album.shootingLocation}</span><br>
								</div>
								<div class="dgal2">
									<span class="font-weight-light "><i
										class="far fa-calendar-alt"></i>Lịch chụp:</span>

									<!-- <a href="#img1" style="padding-left:10px; normal;"> Xem lịch</a> -->

									<c:if test="${hideDate!='yes'}">

										<!-- Button trigger modal -->
										<button type="button" style="padding-left: 10px;"
											class="btn btn-sm btn-outline-secondary" data-toggle="modal"
											data-target="#exampleModalLong">Xem Lịch</button>


										<!-- Modal -->
										<div class="modal fade" id="exampleModalLong" tabindex="-1"
											role="dialog" aria-labelledby="exampleModalLongTitle"
											aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLongTitle">Lịch
															làm việc:</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>

													<c:forEach items="${dateWork}" var="listDate">
														<div class="modal-body">${listDate.date}<br>
														</div>
													</c:forEach>


													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Đóng lại</button>
														<!--         <button type="button" class="btn btn-primary">Save changes</button> -->
													</div>
												</div>
											</div>
										</div>
									</c:if>

									<c:if test="${hideDate=='yes'}">

										<span class="font-weight-light " style="color: blue;">Liên
											hệ</span>
									</c:if>

								</div>

								<div
									style="padding-bottom: 1px; padding-left: 10px; padding-top: 13px;">

									<c:if test="${album.pointRating ==0}">
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>

									</c:if>
									<c:if test="${album.pointRating<1.5&&album.pointRating>0}">
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
									</c:if>

									<c:if test="${album.pointRating<2.5&&album.pointRating>=1.5}">
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>

									</c:if>

									<c:if test="${album.pointRating<3.5&&album.pointRating>=2.5}">
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>

									</c:if>
									<c:if test="${album.pointRating<4.5&&album.pointRating>=3.5}">
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star star " style="font-size: 20px;"></span>
									</c:if>
									<c:if test="${album.pointRating>=4.5}">
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>
										<span class="fa fa-star checked " style="font-size: 20px;"></span>

									</c:if>
									<span class="font-weight-light mr-2 text-dark"
										style="font-size: 20px;"> (<b>
											${album.convertPoint} </b>)<br>(Có <b>${countComment}</b>
										người đánh giá)
									</span>
								</div>
								<hr>
								<div class="dgal2">
									<div
										style="padding-bottom: 1px; padding-left: 10px; padding-top: 13px;">
										<span class="font-weight-light mr-2 text-dark"
											style="font-size: 20px;">
											<div class="fb-share-button"
												data-href="${pageContext.request.contextPath}/servicePackage?spID=${servicePackageID}"
												data-layout="button_count" data-size="small">
												<a target="_blank"
													href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2F2e56908405d7.ngrok.io%2FFlash.Huan%2FservicePackage%3FspID%3D25&amp;src=sdkpreparse"
													class="fb-xfbml-parse-ignore">Chia sẻ</a>
											</div> <span class="fa fa-flag"
											style="margin-left: 20px; font-size: 30px;"
											aria-hidden="true"></span>
										</span>
									</div>
								</div>
							</h5>
						</div>
						<div>
							<h5 class=" dgal1_1" style="margin-left: 16px; height: 280px">
								<div class="dgal2" style="background-color: #ccccb3;">
									<span style="">Mô tả thêm gói chụp: </span>
								</div>
								<div class="dgal2">
									<span class="" style="font-weight: normal; line-height: 1.5;">${album.description}</span>
								</div>
							</h5>
						</div>
					</div>
				</div>
			</div>



			<form class="form-block_trangdanhgia container">
				<div
					style="margin-top: 10px; margin-bottom: 20px; margin-left: 5px; border: 1px;">
					<h4 class="text-left">Gói dịch vụ nổi bật</h4>
					<div class="col-sm-13">
						<div class="form-inline" style="margin-top: 10px;">
						<c:forEach items="${listServiecPakage}" var="art_albm">
								<div class="col-3" style="padding-left: 0px; margin-top: 20px;">
									<div class="hover_danhgia hover-1_danhgia">
										<img
											src="images/${art_albm.photographerID}4/albums/${art_albm.servicepackageName}/${art_albm.coverImage}"
											alt="clgt">
										<div class="hover-overlay_danhgia"></div>
										<div class="hover-1-noidung_danhgia">
											<div class="form-inline col-16">
												<span class="fa fa-bookmark bookmark px-3 bk_1"
													style="margin-bottom: 45px; font-size: 24px;"></span>
												<p class="hover-1-trichdan_danhgia font-weight-light"
													style="margin-left: 120px;">${art_albm.price}.đ</p>
											</div>
											<div class="font-weight-light py-0">
												<div class="form-inline col-sm-12">
													<div class="div1_danhgia">
														<img src="images/${art_albm.photographerID}4/avata.jpg"
															style="margin-left: 10px;" />
													</div>
													<h6 style="font-size: 14px; margin-left: 40px;"
														class="conten_1 px-1">
														<a
															href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${art_albm.photographerID}"
															style="color: white;">${art_albm.nickName}</a><br> <span
															class="font-weight-light ">${art_albm.shootingLocation}</span>
													</h6>
												</div>
												<div class="" style="margin-left: 10px;">
													<c:if test="${art_albm.pointRating ==0}">
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>

													</c:if>
													<c:if
														test="${art_albm.pointRating<1.5&&art_albm.pointRating>0}">
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
													</c:if>

													<c:if
														test="${art_albm.pointRating<2.5&&art_albm.pointRating>=1.5}">
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>

													</c:if>

													<c:if
														test="${art_albm.pointRating<3.5&&art_albm.pointRating>=2.5}">
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>

													</c:if>
													<c:if
														test="${art_albm.pointRating<4.5&&art_albm.pointRating>=3.5}">
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star star " style="font-size: 10px;"></span>

													</c:if>

													<c:if test="${art_albm.pointRating>=4.5}">
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>
														<span class="fa fa-star checked " style="font-size: 10px;"></span>

													</c:if>
													<a class=""
														href="${pageContext.request.contextPath}/servicePackage?spID=${art_albm.id}">xem
														chi tiết</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>


						</div>
					</div>




				</div>



			</form>

			<form id="rating" class="form-block_trangdanhgia"
				style="margin-top: 15px"
				action="${pageContext.request.contextPath}/servicePackage?spID=${servicePackageID}&command=rating"
				method="post">
				<h2 class="text" style="margin-top: 5px; margin-left: 80px">Đánh
					giá sản phẩm</h2>
				<h6 class="text"
					style="margin-left: 80px; padding-bottom: 10px; border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
					<p>
						(Có <b>${countComment}</b> bình luận trong gói chụp này )
					</p>
				</h6>




				<div class="form-inline for">
					<c:if test="${hideRating =='no'}">


						<div
							style="margin-left: 135px; margin-top: 5px; margin-bottom: 5px">
							<span>Đánh giá gói dịch vụ</span><br> <input
								id="input-9Rating" name="input-9Rating" class="rating"
								data-stars="5" data-step="1" required placeholder="Enter Name"
								oninvalid="this.setCustomValidity('Bạn chưa bầu chọn')"
								onchange="this.setCustomValidity('')" type="text" />

							<div class="form-group" style="margin-top: -20px">

								<hr>
							</div>

						</div>

						<div class="form-inline"
							style="margin-top: 0px; margin-left: 90px;">

							<div class="danhgiacanhan" style="margin-top: -35px;">

								<c:if test="${userDetail.avata!=null}">
									<img src="images/${userID}${roleUser}/${userDetail.avata}"
										style="">
								</c:if>
								<c:if test="${userDetail.avata==null}">
									<img src="form/pic/anhchandung.png" style="">
								</c:if>


							</div>

							<div style="font-size: 15px;">
								<textarea maxlength="400" id="inputComment" name="inputComment"
									rows="5" cols="104"
									placeholder=" Bạn có thể để lại lời bình luận (tối đa 400 ký tự)"
									oninvalid="this.setCustomValidity('Bình luận không được trống')"
									oninput="this.setCustomValidity('')" type="text"
									required="required"></textarea>
								<button class="btn btn-primary"
									style="margin-left: 75%; margin-top: 10px;">Đăng bình
									luận</button>
							</div>

						</div>

					</c:if>
				</div>

				<c:forEach items="${listComment}" var="listC">
					<div class="form-inline"
						style="margin-left: 90px; margin-top: 20px; margin-right: 90px;">
						<div class="danhgiacanhan">

							<c:if test="${listC.avata!=null}">
								<img src="images/${listC.userID}${roleUser}/${listC.avata}"
									style="">
							</c:if>
							<c:if test="${listC.avata==null}">
								<img src="form/pic/anhchandung.png" style="">
							</c:if>
						</div>
						<div class="content-comment">
							<div style="font-size: 24px;">
								<div style="margin-left: 20px; font-size: 15px;">
									<a href="/user?userId=${listC.userID}"
										style="font-weight: bold;" data-toggle="modal"
										data-target="#exampleModalCenter">${listC.fullName}</a>
									<div class="modal fade" id="exampleModalCenter" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalCenterTitle"
										aria-hidden="true">
										<div class="modal-dialog modal-dialog-centered"
											role="document">
											<div class="modal-content">
												<div class="modal-body input-group">
													<img src="form/pic/6.jpg"
														style="width: 150px; height: 150px; border-radius: 5px;">
													<div style="padding-top: 30px; margin-left: 20px;">
														<p style="font-weight: normal;">Nguyễn Tiến Dũng</p>
														<p style="font-weight: normal;">
															Số lượng đặt thành công: <span style="color: red;">30</span>
														</p>
														<p style="font-weight: normal;">
															Số lần đánh giá thành công: <span style="color: red;">20</span>
														</p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<span class="tgdangbai">${listC.convertDate}</span><br>

									<c:if test="${listC.pointStar==1}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
									</c:if>

									<c:if test="${listC.pointStar==2}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${listC.pointStar==3}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${listC.pointStar==4}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${listC.pointStar==5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>

									</c:if>
									<br> <span style="margin-bottom: 20px;">${listC.content}</span>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>



				<c:if test="${hidePageComment =='no'}">
					<div
						style="margin-left: 85%; margin-top: 10px; margin-bottom: 20px">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								
								<c:forEach items="${page}" var="list">
									<li class="page-item"><a
										class="page-link <c:if test="${param.page ==list}">text-white bg-dark</c:if> 
							<c:if test="${param.page ==null&&list==1}">text-white bg-dark</c:if>"
										href="${pageContext.request.contextPath}/servicePackage?spID=${servicePackageID}&page=${list}">${list}</a></li>
								</c:forEach>
								
							</ul>
						</nav>
					</div>
				</c:if>
			</form>

			<%-- 			<c:if test="${hide !='yes'}"> --%>
			<%-- 			<form id="rating-form2" class="form-block_trangdanhgia" action="${pageContext.request.contextPath}/servicePackage?spID=${photographerID}" --%>
			<!-- 				method="post">> -->
			<!-- 						<div style="margin-left: 135px; margin-top: 20px; margin-bottom:20px"> -->
			<!-- 						<span>Đánh giá gói dịch vụ</span><br>  -->
			<!-- 						<input id="input-9Rating" name="input-9Rating" class="rating" data-stars="5" data-step="1" 						required placeholder="Enter Name" -->
			<!--    oninvalid="this.setCustomValidity('Bạn chưa bầu chọn')"  -->
			<!-- onchange="this.setCustomValidity('')" type="text" /> -->

			<!-- 						<div class="form-group" style="margin-top: 10px"> -->

			<!-- 							<hr> -->
			<!-- 						</div> -->

			<!-- 					</div> -->

			<!-- 				<div class="form-inline" -->
			<!-- 					style="margin-top: 20px; margin-left: 90px;"> -->

			<!-- 					<div class="danhgiacanhan" style="margin-top: -65px;"> -->
			<!-- 						<img src="form/pic/theloai/chandung1.jpg" /> -->
			<!-- 					</div> -->

			<!-- 					<div style="font-size: 15px;"> -->
			<!-- 						<textarea id="inputComment"name="inputComment" rows="5" cols="104"  -->
			<!-- 							placeholder="Bạn có thể để lại lời bình luận hay câu hỏi ở đây"  -->
			<!-- 							 oninvalid="this.setCustomValidity('Bạn chưa bầu chọn')"  -->
			<!-- oninput="this.setCustomValidity('')" type="text" -->

			<!-- 							 required ></textarea> -->
			<!-- 						<button class="btn btn-primary" -->
			<!-- 							style="margin-left: 75%; margin-top: 10px;">Đăng bình -->
			<!-- 							luận</button> -->
			<!-- 					</div> -->

			<!-- 				</div> -->

			<!-- 			</form> -->

			<%-- </c:if> --%>



			<c:if test="${hidePageComment !='yes'}">
				<form class="form-block_trangdanhgia">
					<br>


				</form>
			</c:if>
		</div>
	</div>
	<%@ include file="include/footer.jsp"%>
	<script src="${pageContext.request.contextPath}/public/js/danhgia.js"></script>



	<script type="text/javascript">
		$('#myModal').on('shown.bs.modal', function() {
			$('#myInput').trigger('focus')
		});
	</script>

	<script type="text/javascript">
		$("#btnfollow").click(function() {
			var idPhoto = document.getElementById("idphoto").value;
			var idUser = document.getElementById("iduser").value;
			console.log(idUser);
			$.ajax({
				url : '${APIurl}?command=FOLLOW',
				type : 'GET',
				data : {
					id1 : idPhoto,
					id2 : idUser,
				},
				success : function(result) {
					window.location.reload();
				},
				error : function(error) {
					console.log(error);
				}
			});
		});
		$("#btnSave").click(function() {
			var idServicePackage = document.getElementById("idServicePackage").value;
			var idUser = document.getElementById("iduser").value;
			console.log(idUser);
			$.ajax({
				url : '${APIurl}?command=SaveServicePackage',
				type : 'GET',
				data : {
					id1 : idServicePackage,
					id2 : idUser,
				},
				success : function(result) {
					window.location.reload();
				},
				error : function(error) {
					console.log(error);
				}
			});
		});

	</script>



	<script type="text/javascript">
document.getElementById('datepicker').valueAsDate = new Date();

</script>




	<script type="text/javascript">			
function checkDate() {
	   var selectedText = document.getElementById('datepicker').value;
	   var selectedDate = new Date(selectedText);
	   var now = new Date();
	   if (selectedDate <= now) {
	    alert("Không thể chọn ngày trong quá khứ");
	    document.getElementById('datepicker').valueAsDate = new Date();
	   }
	 }
			
 </script>












	<script type="text/javascript">

		function checkInp()
		{
			var str = document.getElementById("phoneNumber").value;
		    var n = str.length;
		    
		    if (n<10 || n>10) // this is the code I need to change
		    {
		        alert("Số điện thoại gồm 10 số");
		        
		        return false;
		    }
		    if (n=0) // this is the code I need to change
		    {
		        alert("Số điện thoại gồm 10 số");
		        document.getElementById("phoneNumber").value="";
		        return false;
		    }
		    
		}	

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
	
	
	 $("#booking").click(function(){  // capture the click
	        if($("#bookingForm").valid()){   // test for validity
	        	
	        	
	        	 $("#booking").attr("disabled", true);
					 $("#datepicker").attr("disabled", true);
					 $("#message-text").attr("disabled", true);
					 $("#phoneNumber").attr("disabled", true);
	        	 $('#chatbox').html("Bạn đặt chụp thành công! Vui lòng theo dõi trạng thái đơn hàng");
	 			
	 			var takeDate = document.getElementById('datepicker').value;
	 			
	 			var text = document.getElementById("message-text").value;
	 			var phone= document.getElementById("phoneNumber").value;
	 			var idServicePackage = document.getElementById("idServicePackage").value;
	 			var idUser = document.getElementById("iduser").value;
	 			console.log(text);
	 			$.ajax({
	 				url : '${APIurl}?command=booking',
	 				type : 'GET',
	 				data : {
	 					idDate : takeDate,
	 					idText : text,
	 					idPhone: phone,
	 					idServicePackagex: idServicePackage,
	 					idUserx: idUser,
	 				},
	 				success : function(result) {
	 					 $("#booking").attr("disabled", true);
	 					 $("#datepicker").attr("disabled", true);
	 					 $("#message-text").attr("disabled", true);
	 					 $("#phoneNumber").attr("disabled", true);
	 				
	 				},
	 				error : function(error) {
	 					console.log(error);
	 					$('#chatbox').html("có lỗi gì đó");
	 				}
	 			});
	        	
	        	
	        } else {
	        	alert("Vui lòng kiểm tra thông tin số điện thoại");
	        	 
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

		$("#ratingx").validate({
			errorElement: 'div',
			errorPlacement: function(label, element) {
				label.addClass('alert alert-danger p-1 my-1');
				label.insertAfter(element);
			},
			rules: {
				inputComment: {
					required: true,
					maxlength: 50,
				},
				mota: {
					required: true,
					maxlength: 500,
				},
				price: {
					required: true,
					maxlength: 11,
				},
			},
			messages: {

				tengoi: {
					required: "Nhập tên gói dịch vụ ",
					maxlength: "Tên tối đa 50 ký tự",
				},
				mota: {
					required: "Mô tả gói dịch vụ",
					maxlength: "Nội dung tối đa 500 ký tự",
				},
				price: {
					required: "Nhập giá tiền",
					maxlength: "Nhập tối đa 11 số",
				},
			},
		});	
	});
</script>



	<%-- 		<script src="${pageContext.request.contextPath}/public/js/validate/checkBooking.js"></script> --%>


</body>