
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--  -->
<link rel="stylesheet" href="public/css/csshomepage.css">
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<!--  -->
<script src="public/js/jquery.min.js"></script>
<script src="public/js/jquery.js"></script>
<!---->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<link rel="stylesheet" href="public/css/bootstrap.min.css">
</head>

<body>
	<div class="">
		<!--navbar-->
		<nav class="navbar navbar-expand-xl bg-dark sticky-top ">
			<a class="navbar-brand mr-5"
				href="${pageContext.request.contextPath}/HomePageServlet"><img
				src="form/pic/logo.png" class="" height="60px"></a>
			<button class="navbar-toggler bg-light btn-outline-dark"
				type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fa fa-bars" aria-hidden="true"></i></span>
			</button>

			<div class="collapse navbar-collapse menu"
				id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item mr-5 active"><a id="" class="nav-link"
						href="#">Trang chủ </a></li>
					<li class="nav-item mr-5"><a id="a" class="nav-link"
						href="#photographer">Thợ chụp ảnh</a></li>

					<li class="nav-item mr-5"><a id="a" class="nav-link "
						href="#theloai">Thể loại</a></li>
					<li class="nav-item mr-5"><a id="a" class="nav-link "
						href="#ungtuyen">Ứng tuyển</a></li>
					<li class="nav-item mr-5"><a id="a" class="nav-link "
						href="#xuhuong">Xu hướng</a></li>
					<li class="nav-item mr-5"><a id="a" class="nav-link " href="#">Giới
							thiệu</a></li>
				</ul>
				<ul class="navbar-nav mr-auto">

					<!-- ------thay đổi---------->
					<c:choose>
						<c:when test="${user==null&&role==null}">
							<li class="nav-item  mr-4">
								<div class="dropdown show">
									<a class="btn btn-outline-dark dropdown-toggle" role="button"
										id="dropdownMenuLink" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"> <i
										class="fa fa-user mr-2"></i>Đăng nhập
									</a>
									<div class="dropdown-menu bg-dark"
										aria-labelledby="dropdownMenuLink">
										<a class="dropdown-item btn"
											href="${pageContext.request.contextPath}/LoginServlet"><i
											class="fa fa-sign-in-alt mr-1"></i>Đăng nhập</a> <a
											class="dropdown-item btn "
											href="${pageContext.request.contextPath}/RegisterServlet"><i
											class="fa fa-registered mr-1"></i>Đăng ký</a> <a
											class="dropdown-item btn "
											href="${pageContext.request.contextPath}/RegisterPhotographerOrModel"><i
											class="fa fa-registered mr-1"></i>Đăng ký thợ chụp</a>
									</div>
								</div>
							</li>
						</c:when>
						<c:when test="${user!=null&& role=='1'}">
							<li class="nav-item  mr-4">
								<div class="dropdown show">
									<a class="btn btn-outline-dark dropdown-toggle" role="button"
										id="dropdownMenuLink" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"> <i
										class="fa fa-user mr-2"></i>${user}
									</a>
									<div class="dropdown-menu bg-dark"
										aria-labelledby="dropdownMenuLink">
										<a class="dropdown-item btn "
											href="${pageContext.request.contextPath}/ProfileUser?flag=1"><i
											class="fa fa-info mr-1"></i>Thông tin cá nhân</a> <a
											class="dropdown-item btn"
											href="${pageContext.request.contextPath}/LogOut"><i
											class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
									</div>
								</div>
							</li>
						</c:when>
						<c:when test="${user!=null && role=='2'}">
							<li class="nav-item  mr-4">
								<div class="dropdown show">
									<a class="btn btn-outline-dark dropdown-toggle" role="button"
										id="dropdownMenuLink" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"> <i
										class="fa fa-user mr-2"></i>${user}
									</a>
									<div class="dropdown-menu bg-dark"
										aria-labelledby="dropdownMenuLink">
										<a class="dropdown-item btn "
											href="${pageContext.request.contextPath}/ProfilePhoto?flag=1"><i
											class="fa fa-info mr-1"></i>Thông tin cá nhân</a>
											<a class="dropdown-item btn "
											href="${pageContext.request.contextPath}/GoiDichVu_LichBan?flag=3"><i
											class="fa fa-info mr-1"></i>Gói dịch vụ, lịch bận</a>
											 <a
											class="dropdown-item btn"
											href="${pageContext.request.contextPath}/LogOut"><i
											class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
									</div>
								</div>
							</li>
						</c:when>
					</c:choose>

					<!-- ---------------->
					<li class="nav-item"><a class="nav-link" href="#">Đặt ngay</a>
					</li>

				</ul>

			</div>
		</nav>


		<div>
			<!--search bar + text bar-->
			<section class=" text-bar  pad ">
				<div class=" col-10 textshow">
					<div class="">
						<h1 class="display-2">Chụp ảnh cưới, ảnh kỷ yếu, sự kiện và
							hơn thế nữa</h1>
						<h3 class="display-1">Kết nối 10000+ nhiếp ảnh gia toàn quốc</h3>
						<br> <br>
					</div>
					<div class="col-lg-12 mx-auto ">
						<form action="#">
							<div>
								<div class="   ">
									<div class="dropdown mr-2 aa ">
										<select class="form-control  form-control-lg mr-2 select-bar">
											<option ${workplace=='An Giang'? 'selected="selected"' : ''}>An
										Giang</option>
									<option
										${workplace=='Bà Rịa-Vũng Tàu'? 'selected="selected"' : ''}>Bà
										Rịa-Vũng Tàu</option>
									<option ${workplace=='Bạc Liêu'? 'selected="selected"' : ''}>Bạc
										Liêu</option>
									<option ${workplace=='Bắc Kạn'? 'selected="selected"' : ''}>Bắc
										Kạn</option>
									<option ${workplace=='Bắc Giang'? 'selected="selected"' : ''}>Bắc
										Giang</option>
									<option ${workplace=='Bắc Ninh'? 'selected="selected"' : ''}>Bắc
										Ninh</option>
									<option ${workplace=='Bến Tre'? 'selected="selected"' : ''}>Bến
										Tre</option>
									<option ${workplace=='Bình Dương'? 'selected="selected"' : ''}>Bình
										Dương</option>
									<option ${workplace=='>Bình Định'? 'selected="selected"' : ''}>Bình
										Định</option>
									<option ${workplace=='Bình Thuận'? 'selected="selected"' : ''}>Bình
										Phước</option>
									<option ${workplace=='Bình Dương'? 'selected="selected"' : ''}>Bình
										Thuận</option>
									<option ${workplace=='Cà Mau'? 'selected="selected"' : ''}>Cà
										Mau</option>
									<option ${workplace=='Cao Bằng'? 'selected="selected"' : ''}>Cao
										Bằng</option>
									<option ${workplace=='Cần Thơ'? 'selected="selected"' : ''}>Cần
										Thơ</option>
									<option ${workplace=='Đà Nẵng'? 'selected="selected"' : ''}>Đà
										Nẵng</option>
									<option ${workplace=='Đắk Lắk'? 'selected="selected"' : ''}>Đắk
										Lắk</option>
									<option ${workplace=='Đắk Nông'? 'selected="selected"' : ''}>Đắk
										Nông</option>
									<option ${workplace=='Điện Biên'? 'selected="selected"' : ''}>Điện
										Biên</option>
									<option ${workplace=='Đồng Nai'? 'selected="selected"' : ''}>Đồng
										Nai</option>
									<option ${workplace=='Đồng Tháp'? 'selected="selected"' : ''}>Đồng
										Tháp</option>
									<option ${workplace=='Gia Lai'? 'selected="selected"' : ''}>Gia
										Lai</option>
									<option ${workplace=='Hà Giang'? 'selected="selected"' : ''}>Hà
										Giang</option>
									<option ${workplace=='Hà Nam'? 'selected="selected"' : ''}>Hà
										Nam</option>
									<option ${workplace=='Hà Nội'? 'selected="selected"' : ''}>Hà
										Nội</option>
									<option ${workplace=='Hà Tây'? 'selected="selected"' : ''}>Hà
										Tây</option>
									<option ${workplace=='Hà Tĩnh'? 'selected="selected"' : ''}>Hà
										Tĩnh</option>
									<option ${workplace=='Hải Dương'? 'selected="selected"' : ''}>Hải
										Dương</option>
									<option ${workplace=='Hải Phòng'? 'selected="selected"' : ''}>Hải
										Phòng</option>
									<option ${workplace=='Hòa Bình'? 'selected="selected"' : ''}>Hòa
										Bình</option>
									<option ${workplace=='Hồ Chí Minh'? 'selected="selected"' : ''}>Hồ
										Chí Minh</option>
									<option ${workplace=='Hậu Giang'? 'selected="selected"' : ''}>Hậu
										Giang</option>
									<option ${workplace=='Hưng Yên'? 'selected="selected"' : ''}>Hưng
										Yên</option>
									<option ${workplace=='Khánh Hòa'? 'selected="selected"' : ''}>Khánh
										Hòa</option>
									<option ${workplace=='Kiên Giang'? 'selected="selected"' : ''}>Kiên
										Giang</option>
									<option ${workplace=='Kon Tum'? 'selected="selected"' : ''}>Kon
										Tum</option>
									<option ${workplace=='Lai Châu'? 'selected="selected"' : ''}>Lai
										Châu</option>
									<option ${workplace=='Lào Cai'? 'selected="selected"' : ''}>Lào
										Cai</option>
									<option ${workplace=='Lạng Sơn'? 'selected="selected"' : ''}>Lạng
										Sơn</option>
									<option ${workplace=='Lâm Đồng'? 'selected="selected"' : ''}>Lâm
										Đồng</option>
									<option ${workplace=='Long An'? 'selected="selected"' : ''}>Long
										An</option>
									<option ${workplace=='Nam Định'? 'selected="selected"' : ''}>Nam
										Định</option>
									<option ${workplace=='Nghệ An'? 'selected="selected"' : ''}>Nghệ
										An</option>
									<option ${workplace=='Ninh Bình'? 'selected="selected"' : ''}>Ninh
										Bình</option>
									<option ${workplace=='Ninh Thuận'? 'selected="selected"' : ''}>Ninh
										Thuận</option>
									<option ${workplace=='Phú Thọ'? 'selected="selected"' : ''}>Phú
										Thọ</option>
									<option ${workplace=='Phú Yên'? 'selected="selected"' : ''}>Phú
										Yên</option>
									<option ${workplace=='Quảng Bình'? 'selected="selected"' : ''}>Quảng
										Bình</option>
									<option ${workplace=='Quảng Nam'? 'selected="selected"' : ''}>Quảng
										Nam</option>
									<option ${workplace=='Quảng Ngãi'? 'selected="selected"' : ''}>Quảng
										Ngãi</option>
									<option ${workplace=='Quảng Ninh'? 'selected="selected"' : ''}>Quảng
										Ninh</option>
									<option ${workplace=='Quảng Trị'? 'selected="selected"' : ''}>Quảng
										Trị</option>
									<option ${workplace=='Sóc Trăng'? 'selected="selected"' : ''}>Sóc
										Trăng</option>
									<option ${workplace=='Sơn La'? 'selected="selected"' : ''}>Sơn
										La</option>
									<option ${workplace=='Tây Ninh'? 'selected="selected"' : ''}>Tây
										Ninh</option>
									<option ${workplace=='Thái Bình'? 'selected="selected"' : ''}>Thái
										Bình</option>
									<option ${workplace=='Thái Nguyên'? 'selected="selected"' : ''}>Thái
										Nguyên</option>
									<option ${workplace=='Thanh Hóa'? 'selected="selected"' : ''}>Thanh
										Hóa</option>
									<option
										${workplace=='Thừa Thiên – Huế'? 'selected="selected"' : ''}>Thừa
										Thiên – Huế</option>
									<option ${workplace=='Tiền Giang'? 'selected="selected"' : ''}>Tiền
										Giang</option>
									<option ${workplace=='Trà Vinh'? 'selected="selected"' : ''}>Trà
										Vinh</option>
									<option ${workplace=='Tuyên Quang'? 'selected="selected"' : ''}>Tuyên
										Quang</option>
									<option ${workplace=='Vĩnh Long'? 'selected="selected"' : ''}>Vĩnh
										Long</option>
									<option ${workplace=='Vĩnh Phúc'? 'selected="selected"' : ''}>Vĩnh
										Phúc</option>
									<option ${workplace=='Yên Bái'? 'selected="selected"' : ''}>Yên
										Bái</option>
										</select>
									</div>
									<div class="dropdown mr-2 aa">
										<select class="form-control form-control-lg mr-2 select-bar"></i>
											<option class="" style="display: none" disabled selected>Thể
												loại</option>
											<option>Gia đình</option>
											<option>Đám cưới</option>
											<option>Sự kiện</option>
											<option>Phong cách</option>
											<option>Sản phẩm</option>
										</select>
									</div>
									<div class="dropdown mr-2 aa">
										<select class="form-control form-control-lg mr-2 select-bar"></i>
											<option class="" disabled style="display: none" selected>Giá
												cả</option>
											<option>Dưới 1 triệu</option>
											<option>Dưới 2 triệu</option>
											<option>Dưới 3 triệu</option>
											<option>Dưới 5 triệu</option>
											<option>Dưới 10 triệu</option>
										</select>
									</div>
									<button type="submit" class="btn  btn-outline-light btn-lg ">
										Tìm Kiếm <i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</section>

			<!--caruosel-->
			<div id="carouselExampleIndicators" class="carousel slide rounded"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
				</ol>
				<div class="carousel-inner bg-dark">
					<div class="carousel-item ">
						<img class="d-block w-100 slider-home" src="form/pic/9.jpg"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100 slider-home" src="form/pic/10.jpg"
							alt="Second slide">
					</div>
					<div class="carousel-item active ">
						<img class="d-block w-100 slider-home" src="form/pic/12.png"
							alt="Third slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100 slider-home" src="form/pic/8.jpg"
							alt="four slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<!--jumboton-->

		<!---->
		<!--photogarpher-->
		<div id="photographer" class="container-fluid bg-light  ">
			<div class=" text-center">
				<div class="col-12">
					<h1 class="">Thợ chụp ảnh tiêu biểu</h1>
				</div>
				<!--Horizontal rule-->
				<div class="text-center">
					<p class="col-12">Một nhiếp ảnh gia chuyên nghiệp thường chụp
						ảnh để kiếm tiền, trong khi đó nhiếp ảnh gia nghiệp dư thì chụp
						ảnh chỉ để vui vẻ và ghi lại các sự kiện, cảm xúc, nơi chốn hay
						nhân vật nào đó.</p>
					<br> <br>
				</div>
				<!---->
				<div class="bgphotographer bg-light container-fluid container ">
					<!--1 thang-->
					<div class="input-group  ">
						<!--tháº±ng 1-->
						<c:forEach items="${listPhotoView}" var="photo">
							<div class=" bgimg col-3 col-photo bg-dark canle ">
								<div class="hover hover-1 bgimg1  ">
								<c:if test="${photo.avata ==null}">
								<img class="" src="images/anhchandung.PNG" alt="">
								</c:if>
								<c:if test="${photo.avata !=null}">
								<img class="" src="images/${photo.email}2/${photo.avata}" alt="">
								</c:if>
									<div class="hover-overlay"></div>
									<div class="hover-1-noidung  px-3 py-0  ">
										<h3 class="hover-1-tieude text-uppercase font-weight-bold ">
											<span class="font-weight-light"></span>${photo.ngheDanh}
										</h3>
										<h5 class="hover-1-trichdan font-weight-bold  mb-0">
										<span class="font-weight-light mr-2 text-primary">Hoạt Động:</span>${photo.noilamviec}</h5>

										<div class=" hover-1-trichdan font-weight-light  mb-0">
											<span class="fa fa-star star"></span> <span
												class="fa fa-star star"></span> <span
												class="fa fa-star star"></span> <span
												class="fa fa-star star"></span> <span
												class="fa fa-star star"></span> <a
												class="btn btn-outline-light" href="#">Đặt ngay</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

						<!-- hết -->

					</div>

				</div>


			</div>
		</div>
		<!--Thá» loáº¡i-->
		<div id="theloai" class="container-fluid bg-light khoangcach ">
			<div class=" text-center">
				<div class="col-12">
					<h1 class="">Thể loại</h1>
				</div>
				<!--Horizontal rule-->
				<div class="col-12 khoangcach  bg-light">
					<p>Thể loại là những hình thức biểu hiện cơ bản của nhiếp ảnh
						mang tính thẩm mỹ nhằm nhận thức và phản ánh thực tại khách quan,
						được xác định bởi đặc điểm của đối tượng, ý đồ và phạm vi phản ánh
						của tác phẩm, cũng như phương pháp thể hiện.</p>
				</div>
			</div>
			<!---->
			<div class="bgphotographer bg-light container-fluid container ">
				<!--1 thang-->
				<div class="input-group vitri ">
					<!--chÃ¢n dung-->
					<div class="input-group divtheloai  col-4 bg-dark ">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class="" href="#">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item ">
											<img class="trongoc " src="form/pic/theloai/chandung1.jpg"
												alt="First slide">
										</div>
										<div class="carousel-item">
											<img class="trongoc " src="form/pic/theloai/chandung2.jpg"
												alt="Second slide">
										</div>
										<div class="carousel-item active">
											<img class="trongoc " src="form/pic/theloai/chandung3.jpg"
												alt="Third slide">
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="input-group ">
							<div class=" ">
								<p class=" vitritext">Chân dung</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light ">Tìm Hiểu Thêm</button>
							</div>

						</div>
					</div>
					<!--Sá»± kiá»n-->
					<div class="input-group divtheloai  col-4 bg-dark ">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class="" href="#">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item ">
											<img class="trongoc " src="form/pic/theloai/cuoi1.jpg"
												alt="First slide">
										</div>
										<div class="carousel-item">
											<img class="trongoc " src="form/pic/theloai/cuoi2.jpg"
												alt="Second slide">
										</div>
										<div class="carousel-item active">
											<img class="trongoc " src="form/pic/theloai/cuoi3.jpg"
												alt="Third slide">
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="input-group ">
							<div class=" ">
								<p class=" vitritext">Đám cưới</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light ">Tìm hiểu thêm</button>
							</div>

						</div>
					</div>
					<!--Gia ÄÃ¬nh-->
					<div class="input-group divtheloai col-4 bg-dark">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class="" href="#">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item ">
											<img class="trongoc " src="form/pic/theloai/kyyeu1.jpg"
												alt="First slide">
										</div>
										<div class="carousel-item">
											<img class="trongoc " src="form/pic/theloai/kyyeu2.jpg"
												alt="Second slide">
										</div>
										<div class="carousel-item active">
											<img class="trongoc " src="form/pic/theloai/kyyeu3.jpg"
												alt="Third slide">
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="input-group ">
							<div class=" ">
								<p class=" vitritext">Kỷ Yếu</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light ">Tìm hiểu thêm</button>
							</div>

						</div>
					</div>
					<!--Äá»a á»c-->
					<div class="input-group divtheloai col-4 bg-dark">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class="" href="#">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item ">
											<img class="trongoc " src="form/pic/theloai/giadinh1.jpg"
												alt="First slide">
										</div>
										<div class="carousel-item">
											<img class="trongoc " src="form/pic/theloai/giadinh2.jpg"
												alt="Second slide">
										</div>
										<div class="carousel-item active">
											<img class="trongoc " src="form/pic/theloai/giadinh3.jpg"
												alt="Third slide">
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="input-group ">
							<div class=" ">
								<p class=" vitritext">Gia đình</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light ">Tìm hiểu thêm</button>
							</div>

						</div>
					</div>
					<!--Sáº£n pháº©m-->
					<div class="input-group divtheloai col-4 bg-dark ">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class="" href="#">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item ">
											<img class="trongoc " src="form/pic/theloai/sanpham1.jpg"
												alt="First slide">
										</div>
										<div class="carousel-item">
											<img class="trongoc " src="form/pic/theloai/diaoc2.jpg"
												alt="Second slide">
										</div>
										<div class="carousel-item active">
											<img class="trongoc " src="form/pic/theloai/sanpham3.jpg"
												alt="Third slide">
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="input-group ">
							<div class=" ">
								<p class=" vitritext">Sản phẩm</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light ">Tìm hiểu thêm</button>
							</div>

						</div>
					</div>
					<!--Ká»· yáº¿u-->
					<div class="input-group divtheloai bg-dark col-4">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class="" href="#">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item ">
											<img class="trongoc " src="form/pic/theloai/sukien3.jpg"
												alt="First slide">
										</div>
										<div class="carousel-item">
											<img class="trongoc " src="form/pic/theloai/sukien2.jpg"
												alt="Second slide">
										</div>
										<div class="carousel-item active">
											<img class="trongoc " src="form/pic/theloai/sukien1.jpg"
												alt="Third slide">
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="input-group ">
							<div class=" ">
								<p class=" vitritext">Sự kiện</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light ">Tìm hiểu thêm</button>
							</div>

						</div>
					</div>

				</div>

			</div>


		</div>
		<!--á»©ng tuyá»n -->
		<div id="ungtuyen" class="container-fluid bg-light  ">
			<div class=" text-center">
				<div class="col-12">
					<h1 class="">Ứng tuyển</h1>
				</div>
				<!--Horizontal rule-->
				<!---->
				<div class="bgphotographer bg-light container-fluid container ">
					<!--1 thang-->
					<div class="input-group  ">

						<!--tháº±ng 1-->

						<div class="  col-5  ">
							<div class="  ">
								<img class=" img-fluid" src="form/pic/ungtuyen.jpg" alt="">
							</div>
						</div>

						<div class="col-5">
							<p class="display-4 text-uppercase">Thợ ảnh hoặc người mẫu
								ảnh</p>
							<br> <br> <br> <a
								class="btn btn-outline-dark btn-group-lg"
								href="registerphoto.jsp">Ứng tuyển</a>

						</div>


					</div>

				</div>


			</div>
		</div>
		<!--Xu hÆ°á»ng-->
		<div id="xuhuong" class="container-fluid bg-light  ">
			<div class=" text-center">
				<div class="col-12">
					<h1 class="">Xu hướng hiện tại</h1>
				</div>
				<!--Horizontal rule-->
				<div class="text-center">
					<p class="col-12">Các xu hướng trong năm</p>

				</div>
				<!---->
				<div class="bgphotographer bg-light container-fluid container ">
					<!--1 thang-->
					<div class="input-group  ">

						<!--tháº±ng 1-->

						<div class=" bgimg col-3 bg-dark canle ">
							<div class="hover hover-1 bgimg1  ">
								<img class="" src="form/pic/3.jpg" alt="">
								<div class="hover-overlay"></div>
							</div>
						</div>

						<!--háº¿t tháº±ng 1-->
						<!--tháº±ng 1-->

						<div class=" bgimg col-3 bg-dark canle ">
							<div class="hover hover-1 bgimg1  ">
								<img class="" src="form/pic/3.jpg" alt="">
								<div class="hover-overlay"></div>
							</div>
						</div>

						<!--háº¿t tháº±ng 1-->
						<!--tháº±ng 1-->

						<div class=" bgimg col-3 bg-dark canle ">
							<div class="hover hover-1 bgimg1  ">
								<img class="" src="form/pic/3.jpg" alt="">
								<div class="hover-overlay"></div>
							</div>
						</div>

						<!--háº¿t tháº±ng 1-->
						<!--tháº±ng 1-->

						<div class=" bgimg col-3 bg-dark canle ">
							<div class="hover hover-1 bgimg1  ">
								<img class="" src="form/pic/3.jpg" alt="">
								<div class="hover-overlay"></div>
							</div>
						</div>

						<!--háº¿t tháº±ng 1-->
					</div>

				</div>


			</div>
		</div>
	</div>
	<div class="footer">
		<a class="btn-top btn-outline-light " href="javascript:void(0);"><i
			class="fa fa-chevron-up" aria-hidden="true"></i></a>
	</div>
	<!--footer-->
	<%@ include file="form/include/footer.jsp"%>
	<!--footer -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js "></script>

</body>

</html>