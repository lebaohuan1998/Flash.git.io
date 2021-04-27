<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tổng quan album</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<link rel="stylesheet" href="public/css/style.css">
<link rel="stylesheet" href="public/css/csshomepage.css">
<link rel="stylesheet" href="public/css/tongquanalbum.css">
<link rel="stylesheet" href="public/css/Loctheloaialbum.css">
<link rel="stylesheet" href="public/css/danhgiaalbum.css">
<link rel="stylesheet" href="public/css/danhsachyeuthich.css">
<link rel="stylesheet" href="public/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css"
	rel="stylesheet" />
</head>

<body>
	<c:url var="APIurl" value="/photographer" />
	<%@ include file="include/navbar.jsp"%>
	<div class="">
		<div class="container-fluid  container" style="margin-top: 10px;">
			<div class=" justify-content-center half">
				<div class="" style="border: 1px solid rgba(0, 0, 0, 0.15);">
					<form id="update-form" class="form" method="POST"
						enctype="multipart/form-data">
						<div class="form-block1 mx-auto">
							<div class="form-inline" style="margin-left: 20px;">
								<div class="form-group">
									<c:if test="${avata==null}">
										<img src="form/pic/anhchandung.png" id="myImg" class="rounded"
											alt="your image" height=150 width=170>
									</c:if>
									<c:if test="${avata!=null}">
										<img src="images/${idPhoto}${rolephoto}/${avata}" id="myImg"
											class="rounded" alt="your image" height=150 width=170>
									</c:if>
								</div>
								<div class="content-photo px-3" style="margin-top: 5px;">
									<h6 class="font-weight-bold ">
										<span class="font-weight-light mr-2 text-dark"><i
											class="fas fa-camera mr-1"></i></span>${name}</h6>
									<h6 class="font-weight-bold  ">
										<span class="font-weight-light mr-2 text-dark"><i
											class="fa fa-users mr-1" aria-hidden="true"></i></span>${quymo}</h6>
									<h6 class="font-weight-bold  ">
										<span class="font-weight-light mr-2 text-dark"><i
											class="fa fa-map-marker mr-1" style="margin-right: 3px;"></i></span>${placeOfWork }</h6>
									<h6 class="font-weight-bold  ">
										<span class="font-weight-light mr-2 text-dark"><i
											class="far fa-thumbs-up" aria-hidden="true"
											style="margin-right: 3px;"></i></span>${follow} Người theo dõi.
									</h6>
								</div>

								<div class="col-sm-1 iconshare"
									style="margin-top: -100px; margin-left: 200px;"></div>
								<%-- 	 <div style="padding-top: 10px;">
											<div>
												<br>
												<c:if test="${role==2||role==3}">
													<button id="btnfollow" type="submit" class="btn btn-sm btn-outline-secondary"
														<c:if test="${show=='off'}">disabled="disabled"</c:if>>Theo
														dõi</button>
												</c:if>
												<br> <br>
												<button type="submit" class="btn btn-sm btn-outline-secondary">Liên hệ
													ngay</button>
												<input id="iduser" class="collapse" value="${id}"> <input
													id="idphoto" class="collapse" value="${idPhoto}">

											</div>
										</div> --%>

								<div style="padding-top: 10px;">
									<div>
										<br>

										<%-- 	<c:if test="${showFollowed=='yes' }">
												<button id="btnfollow" type="summit"
													class="btn btn-sm btn-outline-secondary">
													<svg xmlns="http://www.w3.org/2000/svg" width="30"
														height="16" fill="currentColor"
														class="bi bi-bookmark-heart" viewBox="0 0 16 16">
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
											<c:if test="${showFollowed=='no'}">
												<button id="btnfollow" type="summit"
													class="btn btn-sm btn-outline-secondary" disabled>
													<svg xmlns="http://www.w3.org/2000/svg" width="30"
														height="16" fill="currentColor"
														class="bi bi-bookmark-heart" viewBox="0 0 16 16">
  <path fill-rule="evenodd"
															d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
															d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
													Đã theo dõi
												</button>

												<input id="iduser" class="collapse" value="${id}">
												<input id="idphoto" class="collapse" value="${idPhoto}">
											</c:if> --%>
										<c:if test="${role==2||role==3}">
											<button id="btnfollow" type="submit"
												class="btn btn-sm btn-outline-secondary"
												<c:if test="${show=='off'}">disabled="disabled"</c:if>>
												<svg xmlns="http://www.w3.org/2000/svg" width="30"
													height="16" fill="currentColor"
													class="bi bi-bookmark-heart" viewBox="0 0 16 16">
													<path fill-rule="evenodd"
														d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
														d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
											<c:if test="${show=='off'}">Đã </c:if>Theo dõi
											</button>
										</c:if>
										<br> <br>
										<a href="chat.jsp?photographerid=${idPhoto}" type="button" class="btn btn-outline-secondary">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-chat-dots"
												viewBox="0 0 16 16">
  <path
													d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"></path>
  <path
													d="M2.165 15.803l.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z"></path>
</svg>
											Liên hệ
										</a>
										<input id="iduser" class="collapse" value="${id}"> <input
											id="idphoto" class="collapse" value="${idPhoto}"> <br>
										<br>

									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<ul class="nav nav-tabs" style="margin-top: 20px;">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="#thongtinchung" style="margin-right: 10px"><b>Thông
							tin chung</b></a></li>
				<c:if test="${off1 =='no'}">
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#chupchandung" style="margin-right: 10px"><b>Chân
								dung</b></a></li>
				</c:if>
				<c:if test="${off2 =='no'}">
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#chupanhcuoi"><b>Ảnh cưới</b></a></li>
				</c:if>
				<c:if test="${off3 =='no'}">
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#chupkyyeu"><b>Kỷ yếu</b></a></li>
				</c:if>
				<c:if test="${off4 =='no'}">
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#chupgiadinh"><b>Gia đình & bé</b></a></li>
				</c:if>
				<c:if test="${off5 =='no'}">
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#chupsanpham"><b>Sản phẩm</b></a></li>
				</c:if>
				<c:if test="${off6 =='no'}">
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#chupsukien"><b>Sự kiện</b></a></li>
				</c:if>
				<c:if test="${off7 =='no'}">
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#theloaikhac"><b>Thể loại khác</b></a></li>
				</c:if>
			</ul>

			<div class="tab-content">
				<div id="thongtinchung" class="tab-pane active">
					<div class="description-image border content_anh">
							<!-- <h3>
								<b> Thông tin chung của thợ ảnh</b>
							</h3> -->
							<div
								style="margin-left: 40px; margin-right: 40px; margin-bottom: 25px;">
								${decribePhotographer.describe}</div>


					</div>
				</div>
				<div id="chupchandung" class="tab-pane fade">
					<div class="description-image" style="border: none;">
						<div class="col-sm-12">
							<div class="form-inline" style="margin-top: 20px;">
								<c:forEach items="${listA1}" var="list">
									<div class="col-md-3" style="margin-bottom: 20px;">
										<div class="hover_danhgia hover-1_danhgia rounded">
											<img
												src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}">
											<div class="hover-overlay_danhgia"></div>
											<div class="hover-1-noidung_danhgia">
												<div class="form-inline col-16">
													<span class="fa fa-bookmark bookmark px-3 bk_1"
														style="margin-bottom: 53px; font-size: 24px;"></span>
													<p class="hover-1-trichdan_danhgia font-weight-light"
														style="margin-bottom: -15px;">${list.price}đ</p>
												</div>
												<div class="font-weight-light py-0">
													<div class="form-inline col-sm-12"
														style="margin-bottom: -3px;">
														<div class="div1_danhgia">
															<img src="images/${list.photographerID}4/avata.jpg"
																style="margin-left: 10px;" />
														</div>
														<h6 style="font-size: 14px; margin-left: 40px;"
															class="conten_1 px-1">
															<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.photographerID}" style="color: white;">${list.nickName}</a><br>
															<span class="font-weight-light ">${list.provinceName}
															</span>
														</h6>
													</div>
													<div class=""
														style="margin-left: 10px; margin-bottom: -10px;">
														<c:if test="${list.pointRating ==0}">
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<1.5&&list.pointRating>0}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
									</c:if>

									<c:if test="${list.pointRating<2.5&&list.pointRating>=1.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating<3.5&&list.pointRating>=2.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<4.5&&list.pointRating>=3.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating>=4.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>

									</c:if>
														<a class=""
															href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}">xem
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
				</div>
				<div id="chupanhcuoi" class="tab-pane fade">
					<div class="description-image" style="border: none;">
						<div class="col-sm-12">
							<div class="form-inline" style="margin-top: 20px;">
								<c:forEach items="${listA2}" var="list">
									<div class="col-md-3" >
										<div class="hover_danhgia hover-1_danhgia rounded">
											<img
												src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}">
											<div class="hover-overlay_danhgia"></div>
											<div class="hover-1-noidung_danhgia">
												<div class="form-inline col-16">
													<span class="fa fa-bookmark bookmark px-3 bk_1"
														style="margin-bottom: 57px; font-size: 24px;"></span>
													<p class="hover-1-trichdan_danhgia font-weight-light"
														style="margin-bottom: -15px;">${list.price}đ</p>
												</div>
												<div class="font-weight-light py-0">
													<div class="form-inline col-sm-12"
														style="margin-bottom: -3px;">
														<div class="div1_danhgia">
															<img src="images/${list.photographerID}4/avata.jpg"
																style="margin-left: 10px;" />
														</div>
														<h6 style="font-size: 14px; margin-left: 40px;"
															class="conten_1 px-1">
															<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.photographerID}" style="color: white;">${list.nickName}</a><br>
															<span class="font-weight-light ">${list.provinceName}
															</span>
														</h6>
													</div>
													<div class=""
														style="margin-left: 10px; margin-bottom: -10px;">
														<c:if test="${list.pointRating ==0}">
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<1.5&&list.pointRating>0}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
									</c:if>

									<c:if test="${list.pointRating<2.5&&list.pointRating>=1.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating<3.5&&list.pointRating>=2.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<4.5&&list.pointRating>=3.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating>=4.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>

									</c:if>
														<a class=""
															href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}">xem
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
				</div>
				<div id="chupkyyeu" class="tab-pane fade">
					<div class="description-image" style="border: none;">
						<div class="col-sm-12">
							<div class="form-inline" style="margin-top: 20px;">
								<c:forEach items="${listA3}" var="list">
									<div class="col-md-3" style="margin-bottom: 20px;">
										<div class="hover_danhgia hover-1_danhgia rounded">
											<img
												src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}">
											<div class="hover-overlay_danhgia"></div>
											<div class="hover-1-noidung_danhgia">
												<div class="form-inline col-16">
													<span class="fa fa-bookmark bookmark px-3 bk_1"
														style="margin-bottom: 55px; font-size: 24px;"></span>
													<p class="hover-1-trichdan_danhgia font-weight-light"
														style="margin-bottom: -15px;">${list.price}đ</p>
												</div>
												<div class="font-weight-light py-0">
													<div class="form-inline col-sm-12"
														style="margin-bottom: -3px;">
														<div class="div1_danhgia">
															<img src="images/${list.photographerID}4/avata.jpg"
																style="margin-left: 10px;" />
														</div>
														<h6 style="font-size: 14px; margin-left: 40px;"
															class="conten_1 px-1">
															<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.photographerID}" style="color: white;">${list.nickName}</a><br>
															<span class="font-weight-light ">${list.provinceName}
															</span>
														</h6>
													</div>
													<div class=""
														style="margin-left: 10px; margin-bottom: -10px;">
														<c:if test="${list.pointRating ==0}">
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<1.5&&list.pointRating>0}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
									</c:if>

									<c:if test="${list.pointRating<2.5&&list.pointRating>=1.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating<3.5&&list.pointRating>=2.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<4.5&&list.pointRating>=3.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating>=4.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>

									</c:if>
														<a class=""
															href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}">xem
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
				</div>
				<div id="chupgiadinh" class="tab-pane fade">
					<div class="description-image" style="border: none;">
						<div class="col-sm-12">
							<div class="form-inline" style="margin-top: 20px;">
								<c:forEach items="${listA4}" var="list">
									<div class="col-md-3" style="margin-bottom: 20px;">
										<div class="hover_danhgia hover-1_danhgia rounded">
											<img
												src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}">
											<div class="hover-overlay_danhgia"></div>
											<div class="hover-1-noidung_danhgia">
												<div class="form-inline col-16">
													<span class="fa fa-bookmark bookmark px-3 bk_1"
														style="margin-bottom: 55px; font-size: 24px;"></span>
													<p class="hover-1-trichdan_danhgia font-weight-light"
														style="margin-bottom: -15px;">${list.price}đ</p>
												</div>
												<div class="font-weight-light py-0">
													<div class="form-inline col-sm-12"
														style="margin-bottom: -3px;">
														<div class="div1_danhgia">
															<img src="images/${list.photographerID}4/avata.jpg"
																style="margin-left: 10px;" />
														</div>
														<h6 style="font-size: 14px; margin-left: 40px;"
															class="conten_1 px-1">
															<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.photographerID}" style="color: white;">${list.nickName}</a><br>
															<span class="font-weight-light ">${list.provinceName}
															</span>
														</h6>
													</div>
													<div class=""
														style="margin-left: 10px; margin-bottom: -10px;">
														<c:if test="${list.pointRating ==0}">
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<1.5&&list.pointRating>0}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
									</c:if>

									<c:if test="${list.pointRating<2.5&&list.pointRating>=1.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating<3.5&&list.pointRating>=2.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<4.5&&list.pointRating>=3.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating>=4.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>

									</c:if>
														<a class=""
															href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}">xem
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
				</div>
				<div id="chupsanpham" class="tab-pane fade">
					<div class="description-image" style="border: none;">
						<div class="col-sm-12">
							<div class="form-inline" style="margin-top: 20px;">
								<c:forEach items="${listA5}" var="list">
									<div class="col-md-3" style="margin-bottom: 20px;">
										<div class="hover_danhgia hover-1_danhgia rounded">
											<img
												src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}">
											<div class="hover-overlay_danhgia"></div>
											<div class="hover-1-noidung_danhgia">
												<div class="form-inline col-16">
													<span class="fa fa-bookmark bookmark px-3 bk_1"
														style="margin-bottom: 55px; font-size: 24px;"></span>
													<p class="hover-1-trichdan_danhgia font-weight-light"
														style="margin-bottom: -15px;">${list.price}đ</p>
												</div>
												<div class="font-weight-light py-0">
													<div class="form-inline col-sm-12"
														style="margin-bottom: -3px;">
														<div class="div1_danhgia">
															<img src="images/${list.photographerID}4/avata.jpg"
																style="margin-left: 10px;" />
														</div>
														<h6 style="font-size: 14px; margin-left: 40px;"
															class="conten_1 px-1">
															<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.photographerID}" style="color: white;">${list.nickName}</a><br>
															<span class="font-weight-light ">${list.provinceName}
															</span>
														</h6>
													</div>
													<div class=""
														style="margin-left: 10px; margin-bottom: -10px;">
														<c:if test="${list.pointRating ==0}">
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<1.5&&list.pointRating>0}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
									</c:if>

									<c:if test="${list.pointRating<2.5&&list.pointRating>=1.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating<3.5&&list.pointRating>=2.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<4.5&&list.pointRating>=3.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating>=4.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>

									</c:if>
														<a class=""
															href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}">xem
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
				</div>
				<div id="chupsukien" class="tab-pane fade">
					<div class="description-image" style="border: none;">
						<div class="col-sm-12">
							<div class="form-inline" style="margin-top: 20px;">
								<c:forEach items="${listA6}" var="list">
									<div class="col-md-3" style="margin-bottom: 20px;">
										<div class="hover_danhgia hover-1_danhgia rounded">
											<img
												src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}">
											<div class="hover-overlay_danhgia"></div>
											<div class="hover-1-noidung_danhgia">
												<div class="form-inline col-16">
													<span class="fa fa-bookmark bookmark px-3 bk_1"
														style="margin-bottom: 55px; font-size: 24px;"></span>
													<p class="hover-1-trichdan_danhgia font-weight-light"
														style="margin-bottom: -15px;">${list.price}đ</p>
												</div>
												<div class="font-weight-light py-0">
													<div class="form-inline col-sm-12"
														style="margin-bottom: -3px;">
														<div class="div1_danhgia">
															<img src="images/${list.photographerID}4/avata.jpg"
																style="margin-left: 10px;" />
														</div>
														<h6 style="font-size: 14px; margin-left: 40px;"
															class="conten_1 px-1">
															<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.photographerID}" style="color: white;">${list.nickName}</a><br>
															<span class="font-weight-light ">${list.provinceName}
															</span>
														</h6>
													</div>
													<div class=""
														style="margin-left: 10px; margin-bottom: -10px;">
														<c:if test="${list.pointRating ==0}">
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<1.5&&list.pointRating>0}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
									</c:if>

									<c:if test="${list.pointRating<2.5&&list.pointRating>=1.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating<3.5&&list.pointRating>=2.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<4.5&&list.pointRating>=3.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating>=4.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>

									</c:if>
														<a class=""
															href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}">xem
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
				</div>
				<div id="theloaikhac" class="tab-pane fade">
					<div class="description-image" style="border: none;">
						<div class="col-sm-12">
							<div class="form-inline" style="margin-top: 20px;">
								<c:forEach items="${listA7}" var="list">
									<div class="col-md-3">
										<div class="hover_danhgia hover-1_danhgia rounded">
											<img
												src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}">
											<div class="hover-overlay_danhgia"></div>
											<div class="hover-1-noidung_danhgia">
												<div class="form-inline col-16">
													<span class="fa fa-bookmark bookmark px-3 bk_1"
														style="margin-bottom: 55px; font-size: 24px;"></span>
													<p class="hover-1-trichdan_danhgia font-weight-light"
														style="margin-bottom: -15px;">${list.price}đ</p>
												</div>
												<div class="font-weight-light py-0">
													<div class="form-inline col-sm-12"
														style="margin-bottom: -3px;">
														<div class="div1_danhgia">
															<img src="images/${list.photographerID}4/avata.jpg"
																style="margin-left: 10px;" />
														</div>
														<h6 style="font-size: 14px; margin-left: 40px;"
															class="conten_1 px-1">
															<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.photographerID}" style="color: white;">${list.nickName}</a><br>
															<span class="font-weight-light ">${list.provinceName}
															</span>
														</h6>
													</div>
													<div class=""
														style="margin-left: 10px; margin-bottom: -10px;">
														<c:if test="${list.pointRating ==0}">
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<1.5&&list.pointRating>0}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
									</c:if>

									<c:if test="${list.pointRating<2.5&&list.pointRating>=1.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating<3.5&&list.pointRating>=2.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>
									<c:if test="${list.pointRating<4.5&&list.pointRating>=3.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star star " style="font-size: 10px;"></span>

									</c:if>

									<c:if test="${list.pointRating>=4.5}">
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>
										<span class="fa fa-star checked " style="font-size: 10px;"></span>

									</c:if>
														<a class=""
															href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}">xem
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
				</div>

			</div>
		</div>
	</div>
	<div class="bg-light">
		<br>
	</div>

	<%@ include file="include/footer.jsp"%>
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
	</script>
	<script
		src="${pageContext.request.contextPath}/public/js/validate/infousernor.js"></script>
</body>

</html>