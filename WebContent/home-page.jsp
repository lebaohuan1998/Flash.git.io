
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
				<i class="fa fa-bars" aria-hidden="true"></i>
			</button>

			<div class="collapse navbar-collapse menu"
				id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item mr-5"><a id="#" class="nav-link"
						href="${pageContext.request.contextPath}/SearchPhotographer">Tìm
							thợ ảnh</a></li>
					<li class="nav-item mr-5"><a id="a" class="nav-link"
						href="#photographer">Thợ ảnh tiêu biểu</a></li>

					<li class="nav-item mr-5"><a id="a" class="nav-link "
						href="#theloai">Thể loại</a></li>
					<li class="nav-item mr-5"><a id="a" class="nav-link "
						href="#ungtuyen">Ứng tuyển</a></li>
					<li class="nav-item mr-5"><a id="a" class="nav-link "
						href="#xuhuong">Tin nổi bật</a></li>
					<li class="nav-item mr-5"><a id="a" class="nav-link " href="#">
					Trang bài viết</a></li>
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
										<a class="dropdown-item btn"
											href="${pageContext.request.contextPath}/LogOut"><i
											class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
									</div>
								</div>
							</li>
						</c:when>
						<c:when test="${user!=null&& role=='3'||user!=null&& role=='2'}">
							<li class="nav-item  mr-4">
								<div class="dropdown show">
									<a class="btn btn-outline-dark dropdown-toggle" role="button"
										id="dropdownMenuLink" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"> <i
										class="fa fa-user mr-2""></i>${user}
									</a>
									<div class="dropdown-menu bg-dark"
										aria-labelledby="dropdownMenuLink">
										<a class="dropdown-item btn "
											href="${pageContext.request.contextPath}/ProfileUser?flag=1"><i
											class="fa fa-info mr-1"></i>Thông tin Tài khoản</a> <a
											class="dropdown-item btn "
											href="${pageContext.request.contextPath}/followServicePackage?flag=2"><i
											class="fa fa-info mr-1"></i>Gói chụp yêu thích</a> <a
											class="dropdown-item btn "
											href="${pageContext.request.contextPath}/followPhotographer?flag=3"><i
											class="fa fa-info mr-1"></i>Thợ chụp ảnh yêu thích</a> <a
											class="dropdown-item btn "
											href="${pageContext.request.contextPath}/manageBooking?flag=4"><i
											class="fa fa-info mr-1"></i>Quản lý đặt chụp</a> <a
											class="dropdown-item btn"
											href="${pageContext.request.contextPath}/LogOut"><i
											class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
									</div>
								</div>
							</li>
						</c:when>
						<c:when test="${user!=null && role=='4'}">
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
											class="fa fa-info mr-1"></i>Thông tin tài khoản</a> <a
											class="dropdown-item btn "
											href="${pageContext.request.contextPath}/GoiDichVuLichBan?flag=3"><i
											class="fa fa-info mr-1"></i>Quản lý gói dịch vụ</a> <a
											class="dropdown-item btn "
											href="${pageContext.request.contextPath}/DescribePhotographer?flag=5"><i
											class="fa fa-info mr-1"></i>Mô tả thợ ảnh</a> <a
											class="dropdown-item btn"
											href="${pageContext.request.contextPath}/LogOut"><i
											class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
									</div>
								</div>
							</li>
						</c:when>
					</c:choose>

					<!-- ---------------->
					<li><c:if test="${role =='3'}">
							<div id="spoiler" style="position: relative; display: block"
								class="dropdown show ">
								<body onLoad="loadByUser()">
									<a onclick="clickh()"
										href="${pageContext.request.contextPath}/ManageNotification?flag=5">
										<i class="fa fa-bell"
										style="font-size: 24px; color: #fff; margin-top: 7px; position: absolute;"></i>
										<div id="NotificationBadge"
											style="color: white; display: none; position: absolute; border-radius: 50%; background: red; width: 23px; height: 23px; z-index: 999; text-align: center; margin-left: 10px; box-sizing: border-box;">
											<span style="font-size: 15px; color: white;"></span>
										</div>
									</a>
								</body>
							</div>
						</c:if> <c:if test="${role =='4'}">
							<div id="spoiler" style="position: relative; display: block"
								class="dropdown show ">
								<body onLoad="toggle()">
									<a onclick="clickh()"
										href="${pageContext.request.contextPath}/ManageNotificationPhotographer?flag=7">
										<i class="fa fa-bell"
										style="font-size: 24px; color: #fff; margin-top: 7px; position: absolute;"></i>
										<div id="NotificationBadge"
											style="color: white; display: none; position: absolute; border-radius: 50%; background: red; width: 23px; height: 23px; z-index: 999; text-align: center; margin-left: 10px; box-sizing: border-box;">
											<span style="font-size: 15px; color: white;"></span>
										</div>
									</a>
								</body>
							</div>
						</c:if></li>
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
					<form
						action="${pageContext.request.contextPath}/searchServicePackage?command=Search"
						method="POST">
						<div class="col-lg-12 mx-auto ">
							<div>
								<div class="   ">
									<div class="dropdown mr-2 aa ">
										<select class="form-control  form-control-lg mr-2 select-bar"
											name="place">
											<option value="0" selected>Tất cả địa điểm</option>
											<c:forEach items="${listLocation}" var="listLocation">
												<option
													${listLocation.locationId==locationId? 'selected="selected"' : ''}
													value="${listLocation.locationId}">
													${listLocation.locationName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="dropdown mr-2 aa">
										<select class="form-control form-control-lg mr-2 select-bar"
											name="category"></i>
											<option value="0" class="" selected>Tất cả thể loại</option>
											<option value="1">Chân dung</option>
											<option value="2">Sự kiện</option>
											<option value="3">Đám cưới</option>
											<option value="4">Kỷ yếu</option>
											<option value="5">Gia đình và bé</option>
											<option value="6">Chụp sản phẩm</option>
											<option value="7">Khác</option>
										</select>
									</div>
									<div class="dropdown mr-2 aa">
										<select class="form-control form-control-lg mr-2 select-bar"
											name="price"></i>
											<option value="0" selected>Tất cả các mức</option>
											<option value="1000000">Dưới 1 triệu</option>
											<option value="2000000">Dưới 2 triệu</option>
											<option value="3000000">Dưới 3 triệu</option>
											<option value="5000000">Dưới 5 triệu</option>
											<option value="10000000">Dưới 10 triệu</option>
										</select>
									</div>
									<button type="submit" class="btn  btn-outline-light btn-lg ">
										Tìm Kiếm <i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</section>

			<!--caruosel-->
			<div id="carouselExampleIndicators" class="carousel slide rounded"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"
						class="active"></li>
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
		<c:url var="APIurl" value="/searchphotographer" />
		<div id="photographer" class="container-fluid"
			style="border-top: 1px solid rgba(0, 0, 0, 0.15); background-image: linear-gradient(180deg, hsla(0, 0%, 100%, 0.75), hsla(0, 0%, 100%, 0.75)), linear-gradient(90deg, #fff, #fff 0%, hsla(0, 0%, 100%, 0)), url(form/pic/anhnendep1.jpg); background-repeat: no-repeat; background-size: 100% 100%;">
			<div class="border-bottom border-top">
				<div class="col-12 text-center">
					<h1 class="">Thợ chụp ảnh tiêu biểu</h1>
				</div>
				<!--Horizontal rule-->
				<!---->
				<div class="bgphotographer container">
					<!--1 thang-->
					<div class="input-group"
						style="margin-top: 50px; border-top-left-radius: 10px; border-top-right-radius: 10px; margin-left: 50px;">
						<!--tháº±ng 1-->

						<c:forEach items="${listPhotoView}" var="photo">
							<c:url var="viewalbum" value="/photographer">
								<c:param name="command" value="VIEWALBUM" />
								<c:param name="photographerId" value="${photo.id}" />
							</c:url>

							<a href="${viewalbum}" style="text-decoration: none;">
								<div
									style="margin-right: 60px; border-radius: 5px; margin-bottom: 50px;">
									<div>
										<c:if test="${photo.avata ==null}">
											<img src="form/pic/anhchandung.png"
												style="width: 150px; height: 150px; border-radius: 5px;" />
											<div class="noibat">
												<span class="noibat1">Nổi bật</span>
											</div>
										</c:if>
										<c:if test="${photo.avata !=null}">
											<img class="bg-dark" src="images/${photo.id}4/${photo.avata}"
												style="width: 150px; height: 150px; border-radius: 5px;" />
											<div class="noibat">
												<span class="noibat1">Nổi bật</span>
											</div>
										</c:if>


									</div>
									<div style="margin-left: 0px;">
										<h3 class=""
											style="font-size: 16px; font-weight: normal; margin-top: 10px;">
											<span class=""></span>${photo.nickName}
										</h3>
									</div>
								</div>
							</a>

							<%-- 	<div class=" col-3">
								<a href="${viewalbum}" style="text-decoration: none;">
									<div class="hover hover-1 bgimg1  ">
										<c:if test="${photo.avata ==null}">
											<img class="bg-dark" src="images/anhchandung.PNG" alt="">
										</c:if>
										<c:if test="${photo.avata !=null}">
											<img class="bg-dark" src="images/${photo.id}4/${photo.avata}"
												alt="">
										</c:if>
										<div class="hover-overlay"></div>
										<div class="hover-1-noidung  px-3 py-0  ">
											<h3 class="hover-1-tieude text-uppercase font-weight-bold ">
												<span class="font-weight-light"></span>${photo.nickName}
											</h3>
											<h5 class="hover-1-trichdan font-weight-bold  mb-0">
												<span class="font-weight-light mr-2 text-white">Hoạt
													Động:</span>${photo.provinceId}</h5>
											<div class=" hover-1-trichdan font-weight-light  mb-0">
												<a class="btn btn-outline-light" href="#">Theo dõi</a>
											</div>
										</div>
									</div>
								</a>
							</div> --%>


						</c:forEach>
						<!-- hết -->
					</div>
				</div>
			</div>
		</div>
		<!--Thá» loáº¡i-->
		<div id="theloai"
			class="container-fluid bg-light  border-bottom border-top ">
			<div class=" text-center">
				<div class="col-12">
					<h1 class="">Thể loại</h1>
				</div>
				<!--Horizontal rule-->
			</div>
			<!---->
			<div
				class="bgphotographer bg-light container-fluid container border-info ">
				<!--1 thang-->
				<div class="input-group  ">
					<!--chÃ¢n dung-->
					<div class="input-group divtheloai col-4 ">
						<div class="canle">
							<!--thÃ´ng tin thá» loáº¡i-->
							<!-- slider-->
							<a class=""
								href="${pageContext.request.contextPath}/searchServicePackage?page=1&price=0&category=1&place=0">
								<div id="carouselExampleIndicators" class="carousel slide  "
									data-ride="carousel">
									<div class="carousel-inner bg-dark">
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
						<div class="input-group bg-dark ">
							<div class="mr-2"></div>
							<div class=" ">
								<p class=" vitritext" style="margin-top: 10px;">Chân dung</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light "
									style="font-family: 'Helvetica', serif; margin-left: 60px;"
									onclick="document.getElementById('id01').style.display='block'">Tìm
									Hiểu Thêm</button>
							</div>
							<div id="id01" class="modal" style="overflow: auto;">
								<form class="modal-content animate" style="width: 80%;">
									<span
										onclick="document.getElementById('id01').style.display='none'"
										class="close" title="Close Modal">&times;</span>
									<div style="padding: 30px 30px;">
										<article>
											<h3 style="font-size: 32px;">Ảnh chân dung</h3>
											<p>
												<span style="font-weight: bold;">Ảnh chân dung</span> là
												dạng nhiếp ảnh được sử dụng nhiều trong đời sống với mục
												đích ghi lại chân dung của con người, qua đó lột tả được sắc
												thái, biểu cảm hoặc sâu hơn nữa là tác động đến suy nghĩ của
												người xem. Để chụp được tấm hình chân dung không đơn giản,
												nó đòi hỏi sự kết hợp của rất nhiều yếu tố.
											</p>
											<p>Về cơ bản, chụp chân dung có 3 kiểu là: chụp đầu và
												vai, chụp 3/4 cơ thể và chụp toàn thân. Trong bài biết này,
												chúng tôi xin chia sẻ với bạn đọc một vài hướng dẫn cơ bản
												trong thể loại chụp ảnh này.</p>
											<p style="font-weight: bold;">Bố cục ảnh chân dung</p>
											<p>
												<span style="font-weight: bold;">- Quy luật 1/3:</span> Đây
												là một trong những quy luật căn bản nhất để điều chỉnh bố
												cục bức ảnh. Người chụp sẽ chia khung ảnh ra thành 9 phần
												bằng nhau tạo bởi hai đường ngang và hai đường dọc. Điểm
												giao nhau giữa các đường thẳng là điểm gây chú ý nhất trên
												một bức ảnh nên ta có thể đặt điểm nhấn của chủ thể vào các
												vị trí này. Thông thường vị trí này là hai điểm giao nhau ở
												2/3 bức ảnh tính từ cạnh dưới lên.
											</p>
											<p>
												<span style="font-weight: bold;">- Hướng chụp:</span> Chụp
												với khoảng trống trước mặt chủ đề nhiều hơn so với phía sau
												lưng, khi đó nhìn chủ thể sẽ có phương hướng và tránh cảm
												giác cứng cáp như trong chụp ảnh thẻ.
											</p>
											<p>
												<span style="font-weight: bold;">- Đường thực và
													đường ảo:</span> Đường thực là đường hướng mắt của chủ thể, còn
												đường ảo là đường chéo phá đi tính chất thụ động dọc ngang
												của khung hình chữ nhật, khi đó nhìn ảnh sẽ hướng vào chủ đề
												và sinh động hơn.
											</p>
											<p>
												<span style="font-weight: bold;">- Bố cục:</span> Hình dạng
												tam giác hoặc hình thang với đáy lớn nằm dưới tạo cảm giác
												chắc chắn. Ngoài ra còn có các dạng bố cục sau để tạo bức
												ảnh dễ nhìn và nhấn mạnh vào chủ thể: dạng chữ L ngược, S
												ngược, Z ngược và C ngược. Trong đó, bố cục tam giác và hình
												thang được áp dụng nhiều và dễ dàng hơn với chủ thể là từ
												hai người trở lên, trong khi dạng chữ S sẽ tạo cảm giác dễ
												chịu nhất và thích hợp với chụp một chủ thể. Về cơ bản,
												những đường cong hay góc nhọn mà những hình này tạo ra sẽ
												thu hút ánh mắt người xem đến chủ thể cần nhấn mạnh ở khu
												vực các đường thẳng trong quy luật kinh điển 1/3.
											</p>
										</article>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!--Sá»± kiá»n-->
					<div class="input-group divtheloai  col-4  ">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->
							<!-- slider-->
							<a class=""
								href="${pageContext.request.contextPath}/searchServicePackage?page=1&price=0&category=3&place=0">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner bg-dark">
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
						<div class="input-group bg-dark">
							<div class="mr-2"></div>
							<div class=" ">
								<p class=" vitritext" style="margin-top: 10px;">Đám cưới</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light"
									style="font-family: 'Helvetica', serif; margin-left: 60px;"
									onclick="document.getElementById('id02').style.display='block'">Tìm
									hiểu thêm</button>
							</div>
							<div id="id02" class="modal" style="overflow: auto;">
								<form class="modal-content animate" style="width: 80%;">
									<span
										onclick="document.getElementById('id02').style.display='none'"
										class="close" title="Close Modal">&times;</span>
									<div style="padding: 30px 30px;">
										<article>
											<h3 style="font-size: 32px;">Ảnh đám cưới</h3>
											<p>
												<span style="font-weight: bold;"> Chụp ảnh cưới</span> là
												chụp ảnh các hoạt động liên quan đến lễ cưới. Bao gồm các
												bức ảnh của các cặp vợ chồng trước khi kết hôn, cũng như các
												hoạt động trong lễ cưới như ăn cỗ, tổ chức lễ… Chụp ảnh cưới
												là các nỗ lực về công nghệ cũng như nỗ lực của các studio và
												các nhiếp ảnh gia độc lập.
											</p>

											<p style="font-weight: bold;">Lịch sử</p>
											<p>Giống như các công nghệ chụp tương tự, chụp ảnh cưới
												đã phát triển và trưởng thành kể từ khi phát minh ra hình
												thức nghệ thuật nhiếp ảnh bởi Joseph Nicéphore Niépce[1].
												Thực tế, bức ảnh cưới được ghi lại đầu tiên 14 năm sau đó,
												có thể là một máy ảnh giải trí trong đám cưới năm 1840 của
												Nữ hoàng Victoria Prince Albert. Cho đến nửa sau của thế kỷ
												19, hầu hết mọi người đã không đặt ra hình ảnh đám cưới
												chính thức trong các đám cưới. Thay vào đó, họ có thể đặt ra
												cho một bức ảnh chính thức trong bộ quần áo đẹp của họ trước
												khi hoặc sau khi tổ chức đám cưới. Trong những năm cuối thập
												niên 1860, nhiều cặp vợ chồng bắt đầu đặt ra với trang phục
												cưới của họ hoặc đôi khi thuê một nhiếp ảnh gia đến thực
												hiện chụp ảnh cưới.</p>
											<p style="font-weight: bold;">Công nghệ</p>
											<p>Trong thời kỳ sử dụng máy cuộn phim, nhiếp ảnh gia ưa
												chuộng định dạng máy ảnh màu sắc âm cực, đặc biệt là của
												Hasselblad. Ngày nay, nhiều lễ cưới được chụp ảnh với máy
												ảnh SLR kỹ thuật số. Máy ảnh kỹ thuật số với sự tiện lợi cho
												phép phát hiện các ánh sáng lỗi và cho phép tiếp cận ánh
												sáng nhân tạo. Mặc dù giảm bớt sử dụng phim, một số nhiếp
												ảnh gia vẫn bấm máy với phim cuộn bởi họ thích sự thẩm mỹ
												phim đem lại, vài người có quan điểm rằng phim âm cực ghi
												nhiều thông tin hơn so với công nghệ kỹ thuật số. Điều này
												là đúng trong một số trường hợp, cần lưu ý rằng việc bề rộng
												phơi sáng vốn có trong bản của máy ảnh RAW (cho phép phơi
												sáng sâu hơn so với JPEG) các nhà sản xuất. Tất cả các dạng
												RAW có một mức độ bề rộng phơi sáng vượt máy phim - chụp mà
												kỹ thuật số thường được so sánh.</p>
										</article>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!--Gia ÄÃ¬nh-->
					<div class="input-group divtheloai col-4 ">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class=""
								href="${pageContext.request.contextPath}/searchServicePackage?page=1&price=0&category=4&place=0">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner bg-dark">
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
						<div class="input-group bg-dark">
							<div class="mr-2"></div>
							<div class=" ">
								<p class=" vitritext" style="margin-top: 10px;">Kỷ Yếu</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light "
									style="font-family: 'Helvetica', serif; margin-left: 60px;"
									onclick="document.getElementById('id03').style.display='block'">Tìm
									hiểu thêm</button>
							</div>
							<div id="id03" class="modal" style="overflow: auto;">
								<form class="modal-content animate" style="width: 80%;">
									<span
										onclick="document.getElementById('id03').style.display='none'"
										class="close" title="Close Modal">&times;</span>
									<div style="padding: 30px 30px;">
										<article>
											<h3 style="font-size: 32px;">Ảnh kỷ yếu</h3>
											<p style="font-weight: bold;">Chụp ảnh kỷ yếu là gì?</p>
											<p>Dịch vụ “Chụp ảnh kỷ yếu” hay còn gọi là dịch vụ chụp
												ảnh tốt nghiệp, chụp ảnh cuối khóa đang được các bạn học
												sinh – sinh viên cuối cấp hết sức ưa chuộng. Bộ ảnh này sẽ
												bao gồm những tấm hình lưu giữ lại những khoảnh khắc của cả
												tập thể lớp và ảnh chụp cá nhân của từng thành viên.</p>
											<p>Ảnh kỷ yếu thường được chụp vào khoảng tháng 10, tháng
												11 hàng năm - khi tiết trời vào lúc giao mùa với chút nắng
												hiếm hoi cuối thu hòa vào những cơn gió se lạnh đầu đông.
												Lớp học, sân trường là những địa điểm đầu tiên được lưu giữ
												trong bộ ảnh kỷ yếu bởi nơi đây đã chứng kiến, lưu giữ, gắn
												bó thân thiết với các bạn học sinh, sinh viên trong suốt
												quãng thời gian còn đi học. Ngoài ra, các bạn học sinh, sinh
												viên ngày càng có những yêu cầu cao hơn với bộ ảnh kỷ niệm
												của lớp với việc chú trọng vào sự sáng tạo trong từng
												concept, đổi mới trang phục hay tư thế tạo dáng chụp ảnh để
												có những bộ ảnh kỷ yếu đẹp và độc đáo hơn. Đôi khi để tăng
												thêm những trải nghiệm thú vị, việc kết hợp những chuyến đi
												xa để chụp ảnh kỷ yếu cũng là một lựa chọn tuyệt vời mà CỘNG
												STUDIO thường nhận được yêu cầu từ các bạn.</p>
											<p style="font-weight: bold;">Ý nghĩa của việc chụp ảnh
												kỷ yếu</p>
											<p>Chụp ảnh kỷ yếu để lưu những kỷ niệm đẹp của thời học
												sinh – sinh viên trước khi ra trường. Sau khoảng thời gian
												học chung lớp, mỗi người sẽ có những lựa chọn riêng của
												mình, đi tìm cho mình những công việc mới, môi trường học
												tập làm việc mới, biết đến khi nào mới có thể gặp nhau…
												Những kỉ niệm đẹp dưới mái trường là những phút giây chứa
												đựng nhiều cảm xúc vui, buồn vô cùng quý giá mà ai cũng muốn
												lưu lại. Những nụ cười hạnh phúc, những trò đùa tinh nghịch,
												giọt nước mắt, những ôm thât chặt… đều được lưu giữ trong bộ
												ảnh kỷ yếu của lớp. Không chỉ có vậy, bộ ảnh kỷ yếu cũng là
												để đánh dấu bước trưởng thành, đánh dấu một mốc quan trọng
												trong thời thanh xuân của mỗi chúng ta.</p>
										</article>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!--Äá»a á»c-->
					<div class="input-group divtheloai col-4 ">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class=""
								href="${pageContext.request.contextPath}/searchServicePackage?page=1&price=0&category=5&place=0">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner bg-dark">
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
						<div class="input-group bg-dark ">
							<div class="mr-2"></div>
							<div class=" ">
								<p class=" vitritext" style="margin-top: 10px;">Gia đình</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light "
									style="font-family: 'Helvetica', serif; margin-left: 60px;"
									onclick="document.getElementById('id04').style.display='block'">Tìm
									hiểu thêm</button>
							</div>
							<div id="id04" class="modal" style="overflow: auto;">
								<form class="modal-content animate" style="width: 80%;">
									<span
										onclick="document.getElementById('id04').style.display='none'"
										class="close" title="Close Modal">&times;</span>
									<div style="padding: 30px 30px;">
										<article>
											<h3 style="font-size: 32px;">Ảnh gia đình</h3>
											<p>
												<span style="font-weight: bold;"> Chụp ảnh gia đình</span>
												là chụp ảnh các hoạt động liên quan đến lễ cưới. Bao gồm các
												bức ảnh của các cặp vợ chồng trước khi kết hôn, cũng như các
												hoạt động trong lễ cưới như ăn cỗ, tổ chức lễ… Chụp ảnh cưới
												là các nỗ lực về công nghệ cũng như nỗ lực của các studio và
												các nhiếp ảnh gia độc lập.Chụp ảnh gia đình là một nhu cầu
												cần thiết của mỗi đời người. Hãy thực hiện ý tưởng tuyệt vời
												đó và tạo nên cuốn album về gia đình, những tấm ảnh rất giản
												dị nhưng lại chứa đựng ý nghĩa của cả nghìn từ yêu thương về
												gia đình. Ảnh Viện Piano sẽ giúp bạn lưu giữ những khoảnh
												khắc tuyệt vời nhất của gia đình bạn.
											</p>

											<p style="font-weight: bold;">Chụp ảnh gia đình lưu giữ
												thanh âm ngày xưa</p>
											<p>Bức ảnh gia đình là minh chứng rõ nhất cho hạnh phúc
												trọn vẹn của cả nhà, đồng thời là biểu hiện cho sự trưởng
												thành của mỗi thành viên qua từng giai đoạn. Nhìn những bức
												hình của ngày xưa và thấy mình của hiện tại, chắc chắn ai
												cũng sẽ mỉm cười hạnh phúc. Thanh âm của ngày xưa vì thế như
												được làm sống dậy, cho ta cảm giác ngỡ như mới đây thôi.</p>
											<p>Thông thường, hình ảnh gia đình được chụp vào những
												dịp đặc biệt như kỉ niệm ngày cưới, sinh nhật các thành viên
												và có thể là bức hình được chụp vào đêm 30 tết khi tiếng
												chuông giao thừa vang lên. Những bức hình sau đó đó được
												đóng khung và treo cẩn thận, ngay ngắn trên tường hoặc lưu
												giữ thật kĩ trong album.</p>
											<p style="font-weight: bold;">Hình thành tình yêu thương
												trong trẻ</p>
											<p>Chụp hình gia đình luôn là những bức ảnh đẹp để cùng
												gia đình đi qua thời gian và trở thành những kỉ niệm không
												thể quên. Với những đứa trẻ, bức hình gia đình sẽ giúp chúng
												ghi lại hành trình khôn lớn của chính mình, dạy chúng biết
												cách yêu thương và trân trọng giây phút hạnh phúc đang có.
												Mỗi lúc cha mẹ vắng nhà, đứa trẻ có thể ngắm nghía những bức
												hình, ghi nhớ từng khuôn mặt và nhớ về những câu chuyện ngộ
												nghĩnh liên quan đến các nhân vật trong ảnh. Nhờ đó khoảng
												cách sẽ không còn quá xa, trẻ cũng có thể rời xa smartphone
												như mong muốn của nhiều cha mẹ hiện đại.</p>
											<p>Bức ảnh xúc động có ý nghĩa hơn vạn lời nói. Vì thế
												hãy dùng những bức hình chụp cả gia đình ấm cúng và hạnh
												phúc để giáo dục nhân cách, tình yêu thương trong mỗi đứa
												trẻ.</p>
										</article>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!--Sáº£n pháº©m-->
					<div class="input-group divtheloai col-4  ">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class=""
								href="${pageContext.request.contextPath}/searchServicePackage?page=1&price=0&category=6&place=0">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner bg-dark">
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
						<div class="input-group bg-dark">
							<div class="mr-2"></div>
							<div class=" ">
								<p class=" vitritext" style="margin-top: 10px;">Sản phẩm</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light "
									style="font-family: 'Helvetica', serif; margin-left: 60px;"
									onclick="document.getElementById('id05').style.display='block'">Tìm
									hiểu thêm</button>
							</div>
							<div id="id05" class="modal" style="overflow: auto;">
								<form class="modal-content animate" style="width: 80%;">
									<span
										onclick="document.getElementById('id05').style.display='none'"
										class="close" title="Close Modal">&times;</span>
									<div style="padding: 30px 30px;">
										<article>
											<h3 style="font-size: 32px;">Ảnh sản phẩm</h3>
											<p>
												<span style="font-weight: bold;">Chụp ảnh sản phẩm</span> là
												một nhánh của nhiếp ảnh thương mại, Chụp hình sản phẩm là
												công việc giới thiệu hình ảnh sản phẩm một cách chính xác và
												làm nổi bật những khía cạnh hấp dẫn của chính sản phẩm đó.
												Công việc chụp hình sản phẩm cho ra đời những hình ảnh mang
												tính thương mại có thể sử dụng vào trong quảng cáo, thiết kế
												catalogue, brochure,v.v….
											</p>
											<p>Ngày nay, đập vào mắt chúng ta là những hình ảnh sản
												phẩm xuất hiện khắp nơi trên internet, báo chí, tờ rơi, các
												chương trình quảng cáo trên TV,… những hình ảnh sản phẩm đẹp
												mắt tạo ra sự hấp dẫn với người tiêu dùng. Tuy nhiên, đây
												không chỉ đơn thuần là việc cầm máy ảnh lên và bấm nút chụp
												sản phẩm, chụp hình sản phầm đòi hỏi rất nhiều kỹ thuật
												nhiếp ảnh, tư duy sáng tạo nhằm giúp cho sản phẩm trở nên
												cuốn hút với khách hàng.</p>
											<p>Và cuối cùng, chụp ảnh sản phẩm chính là công việc áp
												dụng tinh túy của nhiếp ảnh vào kinh doanh, giúp làm tăng
												thêm sự chuyên nghiệp cho sản phẩm của bạn trong con mắt
												khách hàng và phát triển công việc kinh doanh của bạn.</p>
										</article>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!--Ká»· yáº¿u-->
					<div class="input-group divtheloai  col-4">
						<div class=" canle ">
							<!--thÃ´ng tin thá» loáº¡i-->

							<!-- slider-->
							<a class=""
								href="${pageContext.request.contextPath}/searchServicePackage?page=1&price=0&category=2&place=0">
								<div id="carouselExampleIndicators" class="carousel slide "
									data-ride="carousel">
									<div class="carousel-inner bg-dark">
										<div class="carousel-item ">
											<img class="trongoc " src="form/pic/theloai/sukien2.jpg"
												alt="First slide">
										</div>
										<div class="carousel-item">
											<img class="trongoc " src="form/pic/theloai/sukien1.jpg"
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
						<div class="input-group bg-dark ">
							<div class="mr-2"></div>
							<div class=" ">
								<p class=" vitritext" style="margin-top: 10px;">Sự kiện</p>
							</div>

							<div class="vitribtn">
								<button class="btn btn-outline-light "
									style="font-family: 'Helvetica', serif; margin-left: 60px;"
									onclick="document.getElementById('id06').style.display='block'">Tìm
									hiểu thêm</button>
							</div>
							<div id="id06" class="modal" style="overflow: auto;">
								<form class="modal-content animate" style="width: 80%;">
									<span
										onclick="document.getElementById('id06').style.display='none'"
										class="close" title="Close Modal">&times;</span>
									<div style="padding: 30px 30px;">
										<article>
											<h3 style="font-size: 32px;">Ảnh sự kiện</h3>
											<p>
												<span style="font-weight: bold;">Chụp ảnh sự kiện</span> là
												ghi lại những hình ảnh chân thực, sắc nét đến những câu
												chuyện, thông điệp cần được truyền tải qua hình ảnh để người
												xem nắm bắt được sự kiện này đang được diễn ra ở đâu? địa
												chỉ nào? doanh nghiệp hay công ty nào... Tất cả những điều
												đó được thể hiện trong những tấm hình sự kiện nhằm quảng bá
												công ty, sản phẩm hay đơn giản chỉ là để lưu lại những hình
												ảnh chân thực làm tấm hình kỷ niệm. Ngày nay, với xu hướng
												quảng bá thương hiệu cá nhân hay thương hiệu cho công ty thì
												việc chụp ảnh sự kiện ngày càng cần thiết.
											</p>
											<p style="font-weight: bold;">Những lợi ích khi chụp ảnh
												sự kiện.</p>
											<p>Cùng với chụp ảnh quảng cáo, chụp ảnh sản phẩm, chụp
												ảnh sự kiện tại những sự kiện được tổ chức tại doanh nghiệp,
												cá nhân sẽ là một trong những trợ giúp để truyền thông và
												quảng bá cho doanh nghiệp. Việc chụp ảnh sẽ giúp mang lại
												những ấn phẩm ảnh đẹp, chất lượng để ghi lại những hình ảnh
												tại sự kiện, quảng bá cho người xem, người tiêu dùng cùng
												những đối tác của doanh nghiệp. Với những doanh nghiệp tổ
												chức sự kiện thì việc có đội ngũ chụp ảnh sẽ thể hiện được
												sự chuyên nghiệp trong khâu tổ chức của doanh nghiệp, ghi
												được ấn tượng tốt với những vị khách hàng, đối tác và người.</p>
											<p>Sử dụng những hình ảnh tại sự kiện để quảng bá cho
												doanh nghiệp, tổ chức hay cá nhân. Sử dụng những hình ảnh
												được chụp tại sự kiện để làm tư liệu cho truyền thống phát
												triển của doanh nghiệp, cũng như đánh dấu những mốc lịch sử
												phát triển của doanh nghiệp. Với những doanh nghiệp có nhiều
												tư liệu và sự phát triển, tham gia nhiều sự kiện quan trọng
												và uy tín sẽ luôn là cách để quảng bá tốt nhất cũng như tạo
												được uy tín với người tiêu dùng. Lựa chọn chụp ảnh tại sự
												kiện sẽ giúp doanh nghiệp tiếp cận tốt hơn đến với người
												tiêu dùng, khách hàng và các đối tác làm ăn. Hoặc lưu giữ
												lại những hình ảnh đẹp trong những sự kiện trong đại như
												chụp ảnh sự kiện cưới, chụp ảnh sự kiện sinh nhật,…</p>
										</article>
									</div>
								</form>
							</div>
						</div>
					</div>

				</div>

			</div>


		</div>
		<!--á»©ng tuyá»n -->
		<div id="ungtuyen"
			class="container-fluid bg-light border-bottom border-top">
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
							<p class="display-4 text-uppercase">Đăng ký làm thợ ảnh ngay
								bây giờ</p>
							<br> <br> <br> <a
								class="btn btn-outline-dark btn-group-lg"
								href="${pageContext.request.contextPath}/RegisterPhotographerOrModel">Ứng
								tuyển</a>

						</div>


					</div>

				</div>


			</div>
		</div>
		<!--Xu hÆ°á»ng-->
		<div id="xuhuong" class="container-fluid bg-light  ">
			<div class="">
				<div class="col-12  text-center">
					<h1 class="">Tin nổi bật</h1>
				</div>
				<!--Horizontal rule-->
				<!---->
				<div class="bgphotographer bg-light container-fluid container ">
					<!--1 thang-->
					<div class="input-group">
						<c:forEach items="${listArticleView}" var="article">
							<a
								href="${pageContext.request.contextPath}/baiviet?id=${article.id}"
								style="color: black; text-decoration: none;">
								<div class="baiviet_tc">
									<div style="max-width: 100%; height: 240px;"
										class="baiviet_tc1">
										<c:if test="${article.avatar_article ==null}">
											<img src="form/pic/anh_article.jpg"
												style="width: 100%; height: 150px;" />
										</c:if>
										<c:if test="${article.avatar_article !=null}">
											<img src="form/pic/${article.avatar_article}"
												style="width: 100%; height: 150px;">
										</c:if>
										<div style="margin: 20px 20px 0px 20px; font-weight: bold;">
											<span>${article.title}</span>
										</div>
									</div>
									<div style="margin-left: 20px; margin-bottom: 10px;"
										class="baiviet_tc2">
										<span>${article.author_article}</span>
									</div>
								</div>
							</a>
						</c:forEach>
					</div>

					<br>
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
		<script type="text/javascript">
			var modal = document.getElementById('id01_admin');
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		</script>
</body>

</html>