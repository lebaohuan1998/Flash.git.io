<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<title>Nhiếp ảnh gia</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<link rel="stylesheet" href="public/css/style.css">
<link rel="stylesheet" href="public/css/menuver2.css">
<link rel="stylesheet" href="public/css/csshomepage.css">
<link rel="stylesheet" href="public/css/danhgiaalbum.css">
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="public/css/xemnhiepanhgia.css">
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css"
	rel="stylesheet" />
<script src="public/js/jquery.popup.lightbox.js"></script>
<script src="public/js/xemnhiepanhgia.js"></script>
<link href="public/css/popup-lightbox.css" rel="stylesheet" />
<style type="text/css">
#map {
	height: 400px;
	width: 460px;
}
</style>
</head>
<body>
	<%@ include file="include/navbar.jsp"%>
	<c:url var="APIurl" value="/SearchPhotographer" />
	<c:url var="APIurl1" value="/photographer" />
	<div class="container container-fluid ">
		<div class=" justify-content-center half">
			<form action="${pageContext.request.contextPath}/SearchPhotographer"
				method="POST">
				<div class="form-nhiepanhgia"
					style="padding: 10px 0 10px 0; margin-top: 20px;">
					<div class="form-inline"
						style="margin-left: 20px; position: relative;">
						<div class="dropdown" style="margin-left: 200px;">
							<select id="place" class="form-control mr-2 select-bar"
								name="place">
								<option value="0" ${placeId==0? 'selected="selected"' : ''}>Tất
									cả địa điểm</option>
								<c:forEach items="${listLocation}" var="listLocation">
									<option
										${listLocation.locationId==placeId? 'selected="selected"' : ''}
										value="${listLocation.locationId}">
										${listLocation.locationName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="dropdown" style="margin-left: 20px;">
							<select id="category" class="form-control mr-2 select-bar"
								name="category"></i>
								<option value="0" class="">Tất cả thể loại</option>
								<option ${categoryId=='1'? 'selected="selected"' : ''} value="1">Chụp
									chân dung</option>
								<option ${categoryId=='2'? 'selected="selected"' : ''} value="2">Chụp
									ảnh sự kiện</option>
								<option ${categoryId=='3'? 'selected="selected"' : ''} value="3">Chụp
									ảnh cưới</option>
								<option ${categoryId=='4'? 'selected="selected"' : ''} value="4">Chụp
									kỷ yếu</option>
								<option ${categoryId=='5'? 'selected="selected"' : ''} value="5">Chụp
									ảnh gia đình và bé</option>
								<option ${categoryId=='6'? 'selected="selected"' : ''} value="6">Chụp
									sản phẩm</option>
								<option ${categoryId=='7'? 'selected="selected"' : ''} value="7">Chụp
									Khác.</option>
							</select>
						</div>
						<div class="form-inline" style="margin-left: 20px;">
							<input id="textsearch" class="form-control" type="text"
								name="textsearch"
								style="width: 250px; height: calc(2.25rem + 2px);"
								placeholder="Tìm kiếm theo tên nhiếp ảnh gia"
								value="${textSearch}" />
							<div class="input-group-append">
								<button class="btn btn-primary form-control" type="submit"
									style="width: 40px; height: calc(2.25rem + 2px);">
									<i class="fa fa-search" style="color: white;"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="form-nhiepanhgia"
				style="padding: 20px 0 20px 0; border-top: none;">
				<div class="form-inline" style="margin-left: 20px;">
					<h6 style="margin-right: 200px;">Sắp xếp theo:</h6>
					<input type="radio" name="yesno" id="noCheck"
						style="margin-right: 5px;" value="1"
						<c:if test="${care=='1'}">checked="checked"</c:if>><label
						style="margin-right: 150px;">Được quan tâm nhiều nhất</label> <input
						type="radio" name="yesno" id="yesCheck" style="margin-right: 5px;"
						value="2" <c:if test="${care=='2'}">checked="checked"</c:if>>
					<label class="mr-2">Danh sách nhiếp ảnh gia xung quanh bạn</label>
					<div>
						<button class="form-control btn btn-outline-primary" id="openmap"
							data-toggle="modal" data-target="#mapphotographer">Tìm
							từ vị trí khác</button>
					</div>
					<div class="modal fade" id="mapphotographer" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">Hãy chọn vị trí tìm kiếm</div>
								<div class="modal-body">
									<div id="map"></div>
								</div>
								<div class="modal-footer">
									<a type="button" id="btnsearchPhotographer"
										class="btn btn-info" data-dismiss="modal">Tìm</a>
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Đóng</button>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

			<div class="form-nhiepanhgia"
				style="padding: 20px 0 0 0; border-top: none; margin-bottom: 20px;">
				<h6 style="padding: 0 0 20px 20px">Có ${count} kết quả tìm kiếm
					:</h6>
				<div class="container form-inline xha row"
					style="margin-left: 10px;">

					<c:forEach items="${listPhotographer}" begin="0" end="0"  var="list">
						<div class="col-4" style="padding-left: 0px; padding-right: 0px;">
							<div class="form-inline"
								style="margin-left: 5px; margin-bottom: 10px; border: 1px solid rgba(0, 0, 0, 0.15);">
								<c:if test="${list.avata==null}">
									<img src="form/pic/anhchandung.png" id="myImg" class=""
										alt="your image">
								</c:if>
								<c:if test="${list.avata!=null}">
									<img src="images/${list.id}4/${list.avata}" id="myImg" class=""
										alt="your image">
								</c:if>
								<div style="margin-left: 16px;">
									<a
										href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${list.id}"
										style="color: black; font-weight: bold; font-size: 17px;">${list.nickName }</a>
									<br> <i class="fa fa-map-marker-alt" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.provinceName}
									</span> <br> <i class="far fa-thumbs-up" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.countFollower }
										theo dõi </span><br> <br>
									<c:if test="${role==2||role==3}">
										<button id="btnfollow1" type="submit"
											class="btn btn-sm btn-outline-secondary"
											<c:if test="${list.follow==false}">disabled="disabled"</c:if> value="${id}\${list.id}">
											<svg xmlns="http://www.w3.org/2000/svg" width="30"
												height="16" fill="currentColor" class="bi bi-bookmark-heart"
												viewBox="0 0 16 16">
													<path fill-rule="evenodd"
													d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
													d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
											<c:if test="${list.follow==false}">Đã </c:if>
											Theo dõi
										</button>
									</c:if>
								</div>
								<input id="iduser" class="collapse" value="${id}"> 
								<input id="idphoto1" class="collapse" value="${list.id}">
							</div>
						</div>
					</c:forEach>
					<c:forEach items="${listPhotographer}" begin="1" end="1" var="list">
						<div class="col-4" style="padding-left: 0px; padding-right: 0px;">
							<div class="form-inline"
								style="margin-left: 5px; margin-bottom: 10px; border: 1px solid rgba(0, 0, 0, 0.15);">
								<c:if test="${list.avata==null}">
									<img src="form/pic/anhchandung.png" id="myImg" class=""
										alt="your image">
								</c:if>
								<c:if test="${list.avata!=null}">
									<img src="images/${list.id}4/${list.avata}" id="myImg" class=""
										alt="your image">
								</c:if>
								<div style="margin-left: 16px;">
									<a
										href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${list.id}"
										style="color: black; font-weight: bold; font-size: 17px;">${list.nickName }</a>
									<br> <i class="fa fa-map-marker-alt" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.provinceName}
									</span> <br> <i class="far fa-thumbs-up" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.countFollower }
										theo dõi </span><br> <br>
									<c:if test="${role==2||role==3}">
										<button id="btnfollow2" type="submit"
											class="btn btn-sm btn-outline-secondary"
											<c:if test="${list.follow==false}">disabled="disabled"</c:if> value="${id}\${list.id}">
											<svg xmlns="http://www.w3.org/2000/svg" width="30"
												height="16" fill="currentColor" class="bi bi-bookmark-heart"
												viewBox="0 0 16 16">
													<path fill-rule="evenodd"
													d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
													d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
											<c:if test="${list.follow==false}">Đã </c:if>
											Theo dõi
										</button>
									</c:if>
								</div>
								<input id="iduser" class="collapse" value="${id}"> 
								<input id="idphoto2" class="collapse" value="${list.id}">
							</div>
						</div>
					</c:forEach>
					<c:forEach items="${listPhotographer}" begin="2" end="2" step="1" var="list">
						<div class="col-4" style="padding-left: 0px; padding-right: 0px;">
							<div class="form-inline"
								style="margin-left: 5px; margin-bottom: 10px; border: 1px solid rgba(0, 0, 0, 0.15);">
								<c:if test="${list.avata==null}">
									<img src="form/pic/anhchandung.png" id="myImg" class=""
										alt="your image">
								</c:if>
								<c:if test="${list.avata!=null}">
									<img src="images/${list.id}4/${list.avata}" id="myImg" class=""
										alt="your image">
								</c:if>
								<div style="margin-left: 16px;">
									<a
										href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${list.id}"
										style="color: black; font-weight: bold; font-size: 17px;">${list.nickName }</a>
									<br> <i class="fa fa-map-marker-alt" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.provinceName}
									</span> <br> <i class="far fa-thumbs-up" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.countFollower }
										theo dõi </span><br> <br>
									<c:if test="${role==2||role==3}">
										<button id="btnfollow3" type="submit"
											class="btn btn-sm btn-outline-secondary"
											<c:if test="${list.follow==false}">disabled="disabled"</c:if> value="${id}\${list.id}">
											<svg xmlns="http://www.w3.org/2000/svg" width="30"
												height="16" fill="currentColor" class="bi bi-bookmark-heart"
												viewBox="0 0 16 16">
													<path fill-rule="evenodd"
													d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
													d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
											<c:if test="${list.follow==false}">Đã </c:if>
											Theo dõi
										</button>
									</c:if>
								</div>
								<input id="iduser" class="collapse" value="${id}"> 
								<input id="idphoto3" class="collapse" value="${list.id}">
							</div>
						</div>
					</c:forEach>
					<c:forEach items="${listPhotographer}" begin="3" end="3" step="1" var="list">
						<div class="col-4" style="padding-left: 0px; padding-right: 0px;">
							<div class="form-inline"
								style="margin-left: 5px; margin-bottom: 10px; border: 1px solid rgba(0, 0, 0, 0.15);">
								<c:if test="${list.avata==null}">
									<img src="form/pic/anhchandung.png" id="myImg" class=""
										alt="your image">
								</c:if>
								<c:if test="${list.avata!=null}">
									<img src="images/${list.id}4/${list.avata}" id="myImg" class=""
										alt="your image">
								</c:if>
								<div style="margin-left: 16px;">
									<a
										href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${list.id}"
										style="color: black; font-weight: bold; font-size: 17px;">${list.nickName }</a>
									<br> <i class="fa fa-map-marker-alt" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.provinceName}
									</span> <br> <i class="far fa-thumbs-up" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.countFollower }
										theo dõi </span><br> <br>
									<c:if test="${role==2||role==3}">
										<button id="btnfollow4" type="submit"
											class="btn btn-sm btn-outline-secondary"
											<c:if test="${list.follow==false}">disabled="disabled"</c:if> value="${id}\${list.id}">
											<svg xmlns="http://www.w3.org/2000/svg" width="30"
												height="16" fill="currentColor" class="bi bi-bookmark-heart"
												viewBox="0 0 16 16">
													<path fill-rule="evenodd"
													d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
													d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
											<c:if test="${list.follow==false}">Đã </c:if>
											Theo dõi
										</button>
									</c:if>
								</div>
								<input id="iduser" class="collapse" value="${id}"> 
								<input id="idphoto4" class="collapse" value="${list.id}" >
							</div>
						</div>
					</c:forEach>
					<c:forEach items="${listPhotographer}" begin="4" end="4" step="1" var="list">
						<div class="col-4" style="padding-left: 0px; padding-right: 0px;">
							<div class="form-inline"
								style="margin-left: 5px; margin-bottom: 10px; border: 1px solid rgba(0, 0, 0, 0.15);">
								<c:if test="${list.avata==null}">
									<img src="form/pic/anhchandung.png" id="myImg" class=""
										alt="your image">
								</c:if>
								<c:if test="${list.avata!=null}">
									<img src="images/${list.id}4/${list.avata}" id="myImg" class=""
										alt="your image">
								</c:if>
								<div style="margin-left: 16px;">
									<a
										href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${list.id}"
										style="color: black; font-weight: bold; font-size: 17px;">${list.nickName }</a>
									<br> <i class="fa fa-map-marker-alt" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.provinceName}
									</span> <br> <i class="far fa-thumbs-up" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.countFollower }
										theo dõi </span><br> <br>
									<c:if test="${role==2||role==3}">
										<button id="btnfollow5" type="submit"
											class="btn btn-sm btn-outline-secondary"
											<c:if test="${list.follow==false}">disabled="disabled"</c:if> value="${id}\${list.id}">
											<svg xmlns="http://www.w3.org/2000/svg" width="30"
												height="16" fill="currentColor" class="bi bi-bookmark-heart"
												viewBox="0 0 16 16">
													<path fill-rule="evenodd"
													d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
													d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
											<c:if test="${list.follow==false}">Đã </c:if>
											Theo dõi
										</button>
									</c:if>
								</div>
								<input id="iduser" class="collapse" value="${id}"> 
								<input id="idphoto5" class="collapse" value="${list.id}" >
							</div>
						</div>
					</c:forEach>
					<c:forEach items="${listPhotographer}" begin="5" end="5" step="1" var="list">
						<div class="col-4" style="padding-left: 0px; padding-right: 0px;">
							<div class="form-inline"
								style="margin-left: 5px; margin-bottom: 10px; border: 1px solid rgba(0, 0, 0, 0.15);">
								<c:if test="${list.avata==null}">
									<img src="form/pic/anhchandung.png" id="myImg" class=""
										alt="your image">
								</c:if>
								<c:if test="${list.avata!=null}">
									<img src="images/${list.id}4/${list.avata}" id="myImg" class=""
										alt="your image">
								</c:if>
								<div style="margin-left: 16px;">
									<a
										href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${list.id}"
										style="color: black; font-weight: bold; font-size: 17px;">${list.nickName }</a>
									<br> <i class="fa fa-map-marker-alt" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.provinceName}
									</span> <br> <i class="far fa-thumbs-up" aria-hidden="true"
										style="margin-right: 3px;"></i> <span style="font-size: 16px;">${list.countFollower }
										theo dõi </span><br> <br>
									<c:if test="${role==2||role==3}">
										<button id="btnfollow6" type="submit"
											class="btn btn-sm btn-outline-secondary"
											<c:if test="${list.follow==false}">disabled="disabled"</c:if> value="${id}\${list.id}">
											<svg xmlns="http://www.w3.org/2000/svg" width="30"
												height="16" fill="currentColor" class="bi bi-bookmark-heart"
												viewBox="0 0 16 16">
													<path fill-rule="evenodd"
													d="M8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z" />
  <path
													d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
</svg>
											<c:if test="${list.follow==false}">Đã </c:if>
											Theo dõi
										</button>
									</c:if>
								</div>
								<input id="iduser" class="collapse" value="${id}"> 
								<input id="idphoto6" class="collapse" value="${list.id}" >
							</div>
						</div>
					</c:forEach>
				</div>
				<div style="margin-left: 45%; margin-top: 10px;">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:forEach items="${listPage}" var="list">
								<li class="page-item"><a
									class="page-link <c:if test="${param.page ==list+1}">text-white bg-dark</c:if> 
							<c:if test="${param.page ==null&&list==0}">text-white bg-dark</c:if>"
									href="${pageContext.request.contextPath}/SearchPhotographer?command=<c:if test="${searchbylocation==null}">SearchPhotographerBy</c:if><c:if test="${searchbylocation=='yes'}">SearchPhotographer</c:if>&page=${list+1}<c:if test="${care=='1'}">&care=${care}</c:if><c:if test="${placeId !=null}">&place=${placeId}</c:if><c:if test="${textSearch !=null}">&textsearch=${textSearch}</c:if><c:if test="${categoryId !=null}">&category=${categoryId}</c:if><c:if test="${searchbylocation=='yes'}">&searchByLocation=yes&care=2</c:if>">${list+1}</a></li>
							</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="include/footer.jsp"%>
	<script type="text/javascript" charset="utf-8"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAk8Xn53w2vnsRoQ_Zvuyl3NuhuYNvsHWE&callback=initMap&libraries=places"
		async defer></script>
	<script type="text/javascript">
		var x = 0;
		var y = 0;
		var str;
		function initMap() {
			navigator.geolocation.watchPosition(showPosition);
			function showPosition(position) {
				x = position.coords.latitude;
				y = position.coords.longitude;
			
			const map = new google.maps.Map(document.getElementById("map"), {
			    zoom: 12,
			    center: { lat: Number(x), lng:  Number(y) },
			  });
			    let infoWindow = new google.maps.InfoWindow({
			    content: "Vị trí hiện tại",
			    position: { lat: Number(x), lng:  Number(y) },
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
			    		"Tìm xung quanh vị trí này"
			    );
			    str =JSON.stringify(mapsMouseEvent.latLng.toJSON(), null, 2);
			    infoWindow.open(map);
			    
			  });
		    }
		}
		$("#btnsearchPhotographer").click(function() {
			var place=document.getElementById("place").value;
			var category=document.getElementById("category").value;
			var textsearch=document.getElementById("textsearch").value;
			var subDes;
			var splitted;
			if(str !=null){
				subDes= str.slice(11,str.length-2);
			    splitted= subDes.split(",\n"
						+ "  \"lng\": ", 2);
			    x=splitted[0];
			    y=splitted[1];
			}
			$.ajax({
				url : '${APIurl}?command=SearchPhotographer',
				type : 'GET',
				contentType : 'application/json',
				data : {
					place : place,
					category : category,
					textsearch : textsearch,
					x : x,
					y : y,
				},
				success : function(result) {
					window.location.href = "${APIurl}?command=showSearch";
				},
				error : function(error) {
					console.log(error);
				}
			});
			
		});
		var loadFile = function(event) {
		    var output = document.getElementById('myImg');
		    output.src = URL.createObjectURL(event.target.files[0]);
		    output.onload = function() {
		      URL.revokeObjectURL(output.src) // free memory
		    }
		  };
		$("#noCheck").click(function() {
			var x=document.getElementById("place").value;
			var y=document.getElementById("category").value;
			var z=document.getElementById("textsearch").value;
			var w=document.getElementById("noCheck").value;
			$.ajax({
				url : '${APIurl}?command=SearchPhotographerBy',
				type : 'GET',
				contentType : 'application/json',
				data : {
					place : x,
					category : y,
					textsearch : z,
					care : w
				},
				success : function(result) {
					window.location.href = "${APIurl}?command=showSearch";
				},
				error : function(error) {
					console.log(error);
				}
			});
		});
		
		$("#yesCheck").click(function() {
			var place=document.getElementById("place").value;
			var category=document.getElementById("category").value;
			var textsearch=document.getElementById("textsearch").value;
			var w=document.getElementById("yesCheck").value;
			$.ajax({
				url : '${APIurl}?command=SearchPhotographer',
				type : 'GET',
				contentType : 'application/json',
				data : {
					place : place,
					category : category,
					textsearch : textsearch,
					x : x,
					y : y,
					care :w
				},
				success : function(result) {
					window.location.href = "${APIurl}?command=showSearch";
				},
				error : function(error) {
					console.log(error);
				}
			});
		});
	</script>
	<script type="text/javascript">
		$("#btnfollow1").click(function() {
			var idPhoto = document.getElementById("idphoto1").value;
			var idUser = document.getElementById("iduser").value;
			console.log(idUser+"|"+idPhoto);
			$.ajax({
				url : '${APIurl1}?command=FOLLOW',
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
		$("#btnfollow2").click(function() {
			var idPhoto = document.getElementById("idphoto2").value;
			var idUser = document.getElementById("iduser").value;
			console.log(idUser+"|"+idPhoto);
			$.ajax({
				url : '${APIurl1}?command=FOLLOW',
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
		$("#btnfollow3").click(function() {
			var idPhoto = document.getElementById("idphoto3").value;
			var idUser = document.getElementById("iduser").value;
			console.log(idUser+"|"+idPhoto);
			$.ajax({
				url : '${APIurl1}?command=FOLLOW',
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
		$("#btnfollow4").click(function() {
			var idPhoto = document.getElementById("idphoto4").value;
			var idUser = document.getElementById("iduser").value;
			console.log(idUser+"|"+idPhoto);
			$.ajax({
				url : '${APIurl1}?command=FOLLOW',
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
		$("#btnfollow5").click(function() {
			var idPhoto = document.getElementById("idphoto5").value;
			var idUser = document.getElementById("iduser").value;
			console.log(idUser+"|"+idPhoto);
			$.ajax({
				url : '${APIurl1}?command=FOLLOW',
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
		$("#btnfollow6").click(function() {
			var idPhoto = document.getElementById("idphoto6").value;
			var idUser = document.getElementById("iduser").value;
			console.log(idUser+"|"+idPhoto);
			$.ajax({
				url : '${APIurl1}?command=FOLLOW',
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
</body>