<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tìm gói dịch vụ</title>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

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
<link rel="stylesheet" href="public/css/danhsachyeuthich.css">
<link rel="stylesheet" href="public/css/Loctheloaialbum.css">
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css"
	rel="stylesheet" />
<script src="public/js/jquery.popup.lightbox.js"></script>
<script src="public/js/xemnhiepanhgia.js"></script>
<script src="public/js/localbum.js"></script>
<link href="public/css/popup-lightbox.css" rel="stylesheet" />
</head>
<body>
	<c:url var="APIurl" value="/SearchServicePackageByDate" />
	<%@ include file="include/navbar.jsp"%>
	<div class="container container-fluid "
		style="border: 1px solid rgba(0, 0, 0, 0.15);">
		<div class=" justify-content-center half">
			<form
				action="${pageContext.request.contextPath}/searchServicePackage?command=SearchAdvanced"
				method="POST">
				<div class="form-localbum"
					style="padding: 10px 0 10px 0; margin-top: 20px; border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
					<div class="" style="margin-left: 20px; position: relative;">
					<%-- 	<div class="form-inline" style="margin-left: 120px;">
							<div class="input-group-append">
								<input id="textSearch" name="textSearch"
									class="form-control form-control-lg mr-2 select-bar"
									type="text" value="${textSearch}"
									style="width: 800px; height: calc(2.5rem);"
									placeholder="Nhập từ tìm kiếm" />
								<button class="btn btn-info form-control" type="submit"
									style="width: 60px; height: calc(2.5rem);">
									<i class="fa fa-search" style="color: white;"></i>
								</button>
							</div>
						</div> --%>
						<div class="form-inline" style="margin-top: 10px;">
							<div class="dropdown" style="margin-left: 50px;">
								<select id="place"
									class="form-control form-control-lg mr-2 select-bar"
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
								<select id="category"
									class="form-control form-control-lg mr-2 select-bar"
									name="category"></i>
									<option value="0" class="">Tất cả thể loại</option>
									<option ${categoryId=='1'? 'selected="selected"' : ''}
										value="1">Chụp chân dung</option>
									<option ${categoryId=='2'? 'selected="selected"' : ''}
										value="2">Chụp ảnh sự kiện</option>
									<option ${categoryId=='3'? 'selected="selected"' : ''}
										value="3">Chụp ảnh cưới</option>
									<option ${categoryId=='4'? 'selected="selected"' : ''}
										value="4">Chụp kỷ yếu</option>
									<option ${categoryId=='5'? 'selected="selected"' : ''}
										value="5">Chụp ảnh gia đình và bé</option>
									<option ${categoryId=='6'? 'selected="selected"' : ''}
										value="6">Chụp sản phẩm</option>
									<option ${categoryId=='7'? 'selected="selected"' : ''}
										value="7">Chụp Khác.</option>
								</select>
							</div>
							<div class="dropdown" style="margin-left: 20px;">
								<select id="price"
									class="form-control form-control-lg mr-2 select-bar"
									name="price"></i>
									<option ${price=='0'? 'selected="selected"' : ''} value="0">Tất
										cả các mức</option>
									<option ${price=='1000000'? 'selected="selected"' : ''}
										value="1000000">Dưới 1 triệu</option>
									<option ${price=='2000000'? 'selected="selected"' : ''}
										value="2000000">Dưới 2 triệu</option>
									<option ${price=='3000000'? 'selected="selected"' : ''}
										value="3000000">Dưới 3 triệu</option>
									<option ${price=='5000000'? 'selected="selected"' : ''}
										value="5000000">Dưới 5 triệu</option>
									<option ${price=='10000000'? 'selected="selected"' : ''}
										value="10000000">Dưới 10 triệu</option>
								</select>
							</div>
							<div class="input-group-append" style="margin-left: 20px;">
								<input id="textSearch" name="textSearch"
									class="form-control form-control-lg mr-2 select-bar"
									type="text" value="${textSearch}"
									style="width: 200px; height: calc(2.875rem + 2px);"
									placeholder="Nhập từ tìm kiếm" />
								<button class="btn btn-info form-control" type="submit"
									style="width: 60px; height: calc(2.875rem + 2px);">
									<i class="fa fa-search" style="color: white;"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="form-localbum"
				style="padding: 20px 0 20px 0; border-top: none; height: auto; margin-bottom: 10px;">
				<div class="row">
					<div class="col-sm-3 ml"
						style="margin-left: 20px; border-right: 1px solid rgba(0, 0, 0, 0.15);">
						<div class="input-group"
							style="border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
							<h6 style="padding-bottom: 15px;">Sắp xếp theo:</h6>
							<p
								style="font-size: 24px; margin: -10px 0px 10px 10px; cursor: pointer;"
								class="hienthi1">+</p>
							<p
								style="font-size: 24px; margin: -10px 0px 10px 10px; cursor: pointer;"
								class="nohienthi">-</p>
						</div>
						<div class="sapxennangcao">
							<div>
								<input id="cbx" type="radio" name="yesno"
									onchange="handleClick(this)" value="1"
									style="margin-right: 8px;"
									${sort=='1'? 'checked=""checked""' : ''}><label>Được
									quan tâm nhiều nhất</label>
							</div>
							<div>
								<input id="cbx" type="radio" name="yesno"
									onchange="handleClick(this)" value="2"
									style="margin-right: 5px;"
									${sort=='2'? 'checked=""checked""' : ''}> <label>Đánh
									giá cao đến thấp</label>
							</div>
							<div>
								<input id="cbx" type="radio" name="yesno"
									onchange="handleClick(this)" value="3"
									style="margin-right: 5px;"
									${sort=='3'? 'checked=""checked""' : ''}> <label>Giá
									tiền cao đến thấp</label>
							</div>
							<div>
								<input id="cbx" type="radio" name="yesno"
									onchange="handleClick(this)" value="4"
									style="margin-right: 5px;"
									${sort=='4'? 'checked=""checked""' : ''}> <label>Giá
									tiền thấp đến cao</label>
							</div>
						</div>
						<div class="" style="margin-top: 20px; padding: 0 0 10px 0;">
							<h6 style="margin-right: 3px;">Ngày chụp khả dụng</h6>
							<input id="date" type="date" class="form-control"
								value="${dateSearch}" style="height: calc(2.25rem + 2px);" />
							<button id="searchDate" style="margin-top: 20px;"
								class="btn btn-outline-info collapse ">Lọc kết quả</button>
						</div>
						<!-- <div class="me" style="margin-top: 20px; padding: 0 0 10px 0;">
							<h6 style="margin-right: 3px;">Phương tiện di chuyển</h6>
							<input type="radio" name="pt"  class="mr-1" /><label>Có</label><br> <input
								type="radio" name="pt"   class="mr-1"/><label>Không</label>
						</div>
						<div class="me" style="margin-top: 20px; padding: 0 0 10px 0;">
							<h6 style="margin-right: 3px;">Làm khung cho gói chụp</h6>
							<input type="radio" name="lk" class="mr-1" /><label>Có</label><br> <input
								type="radio" name="lk"  class="mr-1" /><label>Không</label><br>
						</div>
						<div class="me" style="margin-top: 20px; padding: 0 0 10px 0;">
							<h6 style="margin-right: 3px;">Trang điểm</h6>
							<input type="radio" name="td"  class="mr-1" /><label>Dịch vụ đám cưới</label><br>
							<input type="radio" name="td"  class="mr-1" /><label>Dịch vụ sự kiện</label><br>

						</div>
						<div class="me" style="margin-top: 20px; padding: 0 0 10px 0;">
							<h6 style="margin-right: 3px;">Hỗ trợ photoshop</h6>
							<input type="radio" name="htp"  class="mr-1" /><label>Có</label><br> <input
								type="radio" name="htp"   class="mr-1"/><label>Không</label><br>

						</div> -->
					</div>
					<div class="col-12 local"
						style="max-width: 70%; border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
						<h6 class="hienthi">Có ${size} kết quả tìm kiếm</h6>
						<div class="form-inline">
							<c:forEach items="${result}" var="list">
								<div class="col-md-4" style="margin-bottom: 20px;">
									<div class="hover_danhgia hover-1_danhgia rounded">
										<img
											src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}">
										<div class="hover-overlay_danhgia"></div>
										<div class="hover-1-noidung_danhgia">
											<div class="form-inline col-16">
												<span class="fa fa-bookmark bookmark px-3 bk_1"
													style="margin-bottom: 35px; font-size: 24px;"></span>
												<p class="hover-1-trichdan_danhgia font-weight-light"
													style="margin-bottom: 10px; margin-left: 80px;">${list.price}đ</p>
											</div>
											<div class="font-weight-light py-0">
												<div class="form-inline col-sm-12">
													<div class="div1_danhgia">
														<img src="images/${list.photographerID}4/avata.jpg"
															style="margin-left: 10px;" />
													</div>
													<h6 style="font-size: 14px; margin-left: 40px;"
														class="conten_1 px-1">
														<a
															href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${list.photographerID}"
															style="color: white;">${list.nickName}</a><br> <span
															class="font-weight-light ">${list.shootingLocation}
														</span>
													</h6>
												</div>
												<div class="" style="margin-left: 10px;">
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
						<c:if test="${size !=0}">
							<div style="margin-left: 45%; margin-top: 10px;">
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<c:if test="${param.page >1}">
											<li class="page-item"><a
												class="page-link btn-outline-dark"
												href="${pageContext.request.contextPath}<c:if test="${param.dateSearch ==null&& dateSearch ==''}">/searchServicePackage?<c:if test="${param.page ==null}">page=1</c:if><c:if test="${param.page >=1}">page=${param.page-1}</c:if></c:if><c:if test="${param.dateSearch !=null||dateSearch !=''}">/SearchServicePackageByDate?command=SearchByDate&<c:if test="${param.page ==null}">page=1</c:if><c:if test="${param.page >=1}">page=${param.page-1}</c:if></c:if>&price=${price}&sort=${sort}&category=${categoryId}&place=${placeId}&textSearch=${textSearch}<c:if test="${param.dateSearch !=null||dateSearch!=''}">&dateSearch=${dateSearch}</c:if>"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>
										</c:if>
										<c:forEach items="${listPage}" var="list">
											<li class="page-item"><a
												class="page-link <c:if test="${param.page ==list+1}">text-white bg-dark</c:if> 
							<c:if test="${param.page ==null&&list==0}">text-white bg-dark</c:if>"
												href="${pageContext.request.contextPath}<c:if test="${param.dateSearch ==null&& dateSearch ==''&&param.sort ==null&& sort ==null}">/searchServicePackage?page=${list+1}</c:if><c:if test="${param.dateSearch !=null||dateSearch !=''||param.sort!=null||sort!=null}">/SearchServicePackageByDate?command=SearchByDate&page=${list+1}</c:if>&price=${price}&sort=${sort}&category=${categoryId}&place=${placeId}&textSearch=${textSearch}<c:if test="${param.dateSearch !=null||dateSearch!=''}">&dateSearch=${dateSearch}</c:if>">${list+1}</a></li>
										</c:forEach>
										<c:if test="${numberPage>1&& param.page!=numberPage}">
											<li class="page-item"><a class="page-link"
												href="${pageContext.request.contextPath}<c:if test="${param.dateSearch ==null&& dateSearch ==''}">/searchServicePackage?<c:if test="${list==null}">page=2</c:if><c:if test="${list!=null}">page=${param.page+1}</c:if></c:if><c:if test="${param.dateSearch !=null||dateSearch !=''}">/SearchServicePackageByDate?command=SearchByDate&page=${param.page+1}</c:if>&price=${price}&sort=${sort}&category=${categoryId}&place=${placeId}&textSearch=${textSearch}<c:if test="${param.dateSearch !=null||dateSearch!=''}">&dateSearch=${dateSearch}</c:if>"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</c:if>

									</ul>
								</nav>
							</div>
						</c:if>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="include/footer.jsp"%>
	<script type="text/javascript">
		$("input[type=date]").click(function() {
			$("#searchDate").show();
		});
		$("#searchDate")
				.click(
						function() {
							var textSearch = document
									.getElementById("textSearch").value;
							var place = document.getElementById("place").value;
							var category = document.getElementById("category").value;
							var price = document.getElementById("price").value;
							var dateSearch = document.getElementById("date").value;
							console
									.log(textSearch + "|" + place + "|"
											+ category + "|" + price + "|"
											+ dateSearch);
							$.ajax({
								url : '${APIurl}?command=SearchByDate',
								type : 'GET',
								contentType : 'application/json',
								data : {
									textSearch : textSearch,
									place : place,
									category : category,
									price : price,
									dateSearch : dateSearch
								},
								success : function(result) {
									window.location.href = "${APIurl}";
								},
								error : function(error) {
									console.log(error);
								}
							});
						});
		function handleClick(myRadio) {
			var textSearch = document.getElementById("textSearch").value;
			var place = document.getElementById("place").value;
			var category = document.getElementById("category").value;
			var price = document.getElementById("price").value;
			var dateSearch = document.getElementById("date").value;
			console.log(myRadio.value);
			$.ajax({
				url : '${APIurl}?command=SearchByDate',
				type : 'GET',
				contentType : 'application/json',
				data : {
					textSearch : textSearch,
					place : place,
					category : category,
					price : price,
					dateSearch : dateSearch,
					sort : myRadio.value
				},
				success : function(result) {
					window.location.href = "${APIurl}";
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
		$('document').ready(function() {
			$(".sapxennangcao").hide();
			$(".nohienthi").hide();
		})
		$(".hienthi1").click(function() {
			$(".sapxennangcao").show("slow");
			$(".nohienthi").show("slow");
			$(".hienthi1").hide("slow");
		})
		$(".nohienthi").click(function() {
			$(".sapxennangcao").hide("slow");
			$(".nohienthi").hide("slow");
			$(".hienthi1").show("slow");
		})
	</script>
</body>