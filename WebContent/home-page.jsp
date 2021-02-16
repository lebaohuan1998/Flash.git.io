<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Home Page</title>
 
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!--  -->
  <link rel="stylesheet" href="public/css/csshomepage.css">
  <link rel="stylesheet" href="public/fontawesome-free-5.15.1-web/css/all.min.css">
  <!--  -->
  <script src="public/js/jquery.min.js"></script>
  <script src="public/js/jquery.js"></script>
  <!---->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
  <link rel="stylesheet" href="public/css/bootstrap.min.css">
</head>

<body>
<div class="">
    <!--navbar-->
    <nav class="navbar navbar-expand-xl bg-dark sticky-top ">
      <a class="navbar-brand mr-5" href="${pageContext.request.contextPath}/HomePageServlet"><img src="form/pic/logo.png" class="" height="60px"></a>
      <button class="navbar-toggler bg-light btn-outline-dark" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
        aria-label="Toggle navigation">
        <i class="fa fa-bars" aria-hidden="true"></i></span>
      </button>

      <div class="collapse navbar-collapse menu" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item mr-5 active">
            <a id="" class="nav-link"  href="#" >Trang chủ </a>
          </li>
          <li class="nav-item mr-5">
            <a id="a" class="nav-link" href="#photographer">Thợ chụp ảnh</a>
          </li>

          <li class="nav-item mr-5">
            <a id="a" class="nav-link " href="#theloai">Thể loại</a>
          </li>
          <li class="nav-item mr-5">
            <a id="a" class="nav-link " href="#ungtuyen">Ứng tuyển</a>
          </li>
          <li class="nav-item mr-5">
            <a id="a" class="nav-link " href="#xuhuong">Xu hướng</a>
          </li>
          <li class="nav-item mr-5">
            <a id="a" class="nav-link " href="#">Giới thiệu</a>
          </li>
        </ul>
        <ul class="navbar-nav mr-auto">
        
       <!-- ------thay đổi---------->
       <c:choose> 
          <c:when test="${user==null&&role==null}"> 
               <li class="nav-item  mr-4">
                  <div class="dropdown show">
                       <a class="btn btn-outline-dark dropdown-toggle"  role="button" id="dropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                         <i class="fa fa-user mr-2"></i>Đăng nhập
                       </a>
                    <div class="dropdown-menu bg-dark" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item btn" href="${pageContext.request.contextPath}/LoginServlet"><i class="fa fa-sign-in-alt mr-1"></i>Đăng nhập</a>
                      <a class="dropdown-item btn " href="${pageContext.request.contextPath}/RegisterServlet"><i class="fa fa-registered mr-1"></i>Đăng ký</a>
                      <a class="dropdown-item btn " href="${pageContext.request.contextPath}/RegisterPhotographerOrModel"><i class="fa fa-registered mr-1"></i>Đăng ký thợ chụp</a>
                    </div>
                   </div>
               </li>
          </c:when>
          <c:when test="${user!=null&& role=='1'}"> 
               <li class="nav-item  mr-4">
                  <div class="dropdown show">
                       <a class="btn btn-outline-dark dropdown-toggle"  role="button" id="dropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                         <i class="fa fa-user mr-2"></i>${user}${role}
                       </a>
                    <div class="dropdown-menu bg-dark" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item btn " href="${pageContext.request.contextPath}/ProfileUser"><i class="fa fa-info mr-1"></i>Thông tin cá nhân</a>                       
                       <a class="dropdown-item btn" href="${pageContext.request.contextPath}/LogOut"><i class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
                    </div>
                   </div>
               </li>
          </c:when>  
          <c:when test="${user!=null && role=='2'}"> 
               <li class="nav-item  mr-4">
                  <div class="dropdown show">
                       <a class="btn btn-outline-dark dropdown-toggle"  role="button" id="dropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                         <i class="fa fa-user mr-2"></i>${user} ${role}
                       </a>
                    <div class="dropdown-menu bg-dark" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item btn" href="${pageContext.request.contextPath}/LogOut"><i class="fas fa-sign-out-alt mr-1"></i>Đăng xuất</a>
                    </div>
                   </div>
               </li>
          </c:when> 
        </c:choose> 
          
           <!-- ---------------->
          <li class="nav-item">
            <a class="nav-link" href="#">Đặt ngay</a>
          </li>

        </ul>

      </div>
    </nav>


    <div>
      <!--search bar + text bar-->
      <section class="searchbar text-bar  pad ">
        <div class=" col-10 textshow">
          <div class="">
            <h1 class="display-2">Chụp ảnh cưới, ảnh kỷ yếu, sự kiện và hơn thế nữa</h1>
            <h3 class="display-1">Kết nối 10000+ nhiếp ảnh gia toàn quốc</h3>
            <br>
            <br>
          </div>
          <div class="col-lg-9 mx-auto ">
            <form action="#">
              <div>
                  <div class="   ">
                    <div class="dropdown mr-1 aa ">
                      <select class="form-control  form-control-lg mr-2 select-bar">
                        <option class="" selected>Tất cả các địa điểm</option>
                        <option>Hà Nội</option>
                        <option>Nam Định</option>
                        <option>Ba vì</option>
                        <option>Hải Phòng</option>
                        <option>Hồ Chí Minh</option>
                      </select>
                    </div>
                    <div class="dropdown mr-1 aa">
                      <select class="form-control form-control-lg mr-2 select-bar"></i>
                        <option class="" style="display:none" disabled selected>Thể loại</option>
                        <option>Gia đình</option>
                        <option>Đám cưới</option>
                        <option>Sự kiện</option>
                        <option>Phong cách</option>
                        <option>Sản phẩm</option>
                      </select>
                    </div>
                    <div class="dropdown mr-1 aa">
                      <select class="form-control form-control-lg mr-2 select-bar"></i>
                        <option class="" disabled style="display:none" selected>Giá cả</option>
                        <option>Dưới 1 triệu</option>
                        <option>Dưới 2 triệu</option>
                        <option>Dưới 3 triệu</option>
                        <option>Dưới 5 triệu</option>
                        <option>Dưới 10 triệu</option>
                      </select>
                    </div>
                    <button type="submit" class="btn btn-link btn-outline-light btn-lg "><i
                        class="fa fa-search"></i></button>
                  </div>
              </div>
            </form>
          </div>
        </div>
      </section>

      <!--caruosel-->
      <div id="carouselExampleIndicators" class="carousel slide rounded" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner bg-dark">
          <div class="carousel-item ">
            <img class="d-block w-100 slider-home" src="form/pic/9.jpg" alt="First slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100 slider-home" src="form/pic/10.jpg" alt="Second slide">
          </div>
          <div class="carousel-item active ">
            <img class="d-block w-100 slider-home" src="form/pic/12.png" alt="Third slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100 slider-home" src="form/pic/8.jpg" alt="four slide">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
    <!--jumboton-->

    <!---->
    <!--photogarpher-->
    <div id="photographer" class="container-fluid bg-light  ">
      <div class=" text-center">
        <div class="col-12">
          <h1 class=""> Thợ chụp ảnh tiêu biểu</h1>
        </div>
        <!--Horizontal rule-->
        <div class="text-center">
          <p class="col-12">Một nhiếp ảnh gia chuyên nghiệp thường chụp ảnh để kiếm tiền,
            trong khi đó nhiếp ảnh gia nghiệp dư thì chụp ảnh chỉ để vui vẻ và ghi lại các sự kiện,
            cảm xúc, nơi chốn hay nhân vật nào đó.</p>
          <br>
          <br>
        </div>
        <!---->
        <div class="bgphotographer container-fluid container ">
          <!--1 thang-->
          <div class="input-group  ">
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/theloai/chandung1.jpg" alt="">
                <div class="hover-overlay"></div>
                <div class="hover-1-noidung  px-3 py-0  ">
                  <h3 class="hover-1-tieude text-uppercase font-weight-bold "> <span class="font-weight-light">Anh
                    </span>Lê Bảo Huân</h3>
                  <p class="hover-1-trichdan font-weight-light mb-0">20 năm trong ngành chụp ảnh</p>

                  <div class=" hover-1-trichdan font-weight-light mb-0">
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <a class="btn btn-outline-light" href="#">Đặt ngay</a>
                  </div>
                </div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/theloai/chandung1.jpg" alt="">
                <div class="hover-overlay"></div>
                <div class="hover-1-noidung  px-3 py-0  ">
                  <h3 class="hover-1-tieude text-uppercase font-weight-bold "> <span class="font-weight-light">Anh
                    </span>Lê Bảo Huân</h3>
                  <p class="hover-1-trichdan font-weight-light mb-0">20 năm trong ngành chụp ảnh</p>

                  <div class=" hover-1-trichdan font-weight-light mb-0">
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <a class="btn btn-outline-light" href="#">Đặt ngay</a>
                  </div>
                </div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/theloai/chandung1.jpg" alt="">
                <div class="hover-overlay"></div>
                <div class="hover-1-noidung  px-3 py-0  ">
                  <h3 class="hover-1-tieude text-uppercase font-weight-bold "> <span class="font-weight-light">Anh
                    </span>Lê Bảo Huân</h3>
                  <p class="hover-1-trichdan font-weight-light mb-0">20 năm trong ngành chụp ảnh</p>

                  <div class=" hover-1-trichdan font-weight-light mb-0">
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <a class="btn btn-outline-light" href="#">Đặt ngay</a>
                  </div>
                </div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/theloai/chandung1.jpg" alt="">
                <div class="hover-overlay"></div>
                <div class="hover-1-noidung  px-3 py-0  ">
                  <h3 class="hover-1-tieude text-uppercase font-weight-bold "> <span class="font-weight-light">Anh
                    </span>Lê Bảo Huân</h3>
                  <p class="hover-1-trichdan font-weight-light mb-0">20 năm trong ngành chụp ảnh</p>

                  <div class=" hover-1-trichdan font-weight-light mb-0">
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <a class="btn btn-outline-light" href="#">Đặt ngay</a>
                  </div>
                </div>
              </div>
            </div>
            
            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/theloai/chandung1.jpg" alt="">
                <div class="hover-overlay"></div>
                <div class="hover-1-noidung  px-3 py-0  ">
                  <h3 class="hover-1-tieude text-uppercase font-weight-bold "> <span class="font-weight-light">Anh
                    </span>Lê Bảo Huân</h3>
                  <p class="hover-1-trichdan font-weight-light mb-0">20 năm trong ngành chụp ảnh</p>

                  <div class=" hover-1-trichdan font-weight-light mb-0">
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <a class="btn btn-outline-light" href="#">Đặt ngay</a>
                  </div>
                </div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/theloai/chandung1.jpg" alt="">
                <div class="hover-overlay"></div>
                <div class="hover-1-noidung  px-3 py-0  ">
                  <h3 class="hover-1-tieude text-uppercase font-weight-bold "> <span class="font-weight-light">Anh
                    </span>Lê Bảo Huân</h3>
                  <p class="hover-1-trichdan font-weight-light mb-0">20 năm trong ngành chụp ảnh</p>

                  <div class=" hover-1-trichdan font-weight-light mb-0">
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <a class="btn btn-outline-light" href="#">Đặt ngay</a>
                  </div>
                </div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/theloai/chandung1.jpg" alt="">
                <div class="hover-overlay"></div>
                <div class="hover-1-noidung  px-3 py-0  ">
                  <h3 class="hover-1-tieude text-uppercase font-weight-bold "> <span class="font-weight-light">Anh
                    </span>Lê Bảo Huân</h3>
                  <p class="hover-1-trichdan font-weight-light mb-0">20 năm trong ngành chụp ảnh</p>

                  <div class=" hover-1-trichdan font-weight-light mb-0">
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <a class="btn btn-outline-light" href="#">Đặt ngay</a>
                  </div>
                </div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/theloai/chandung1.jpg" alt="">
                <div class="hover-overlay"></div>
                <div class="hover-1-noidung  px-3 py-0  ">
                  <h3 class="hover-1-tieude text-uppercase font-weight-bold "> <span class="font-weight-light">Anh
                    </span>Lê Bảo Huân</h3>
                  <p class="hover-1-trichdan font-weight-light mb-0">20 năm trong ngành chụp ảnh</p>

                  <div class=" hover-1-trichdan font-weight-light mb-0">
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <span class="fa fa-star star"></span>
                    <a class="btn btn-outline-light" href="#">Đặt ngay</a>
                  </div>
                </div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->




          </div>

        </div>


      </div>
    </div>
    <!--Thá» loáº¡i-->
    <div id="theloai" class="container-fluid bg-light khoangcach ">
      <div class=" text-center">
        <div class="col-12">
          <h1 class=""> Thể loại</h1>
        </div>
        <!--Horizontal rule-->
        <div class="col-12 khoangcach  bg-light">
          <p>Thể loại là những hình thức biểu hiện cơ bản của nhiếp ảnh mang tính thẩm mỹ
            nhằm nhận thức và phản ánh thực tại khách quan, được xác định bởi đặc điểm của
            đối tượng, ý đồ và phạm vi phản ánh của tác phẩm, cũng như phương pháp thể hiện.
          </p>
        </div>
      </div>
      <!---->
      <div class="bgphotographer container-fluid container ">
        <!--1 thang-->
        <div class="input-group vitri ">
          <!--chÃ¢n dung-->
          <div class="input-group divtheloai  col-4 bg-dark ">
            <div class=" canle ">
              <!--thÃ´ng tin thá» loáº¡i-->

              <!-- slider-->
              <a class="" href="#">
                <div id="carouselExampleIndicators" class="carousel slide " data-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item ">
                      <img class="trongoc " src="form/pic/theloai/chandung1.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                      <img class="trongoc " src="form/pic/theloai/chandung2.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item active">
                      <img class="trongoc " src="form/pic/theloai/chandung3.jpg" alt="Third slide">
                    </div>
                  </div>
                </div>
              </a>
            </div>
            <div class="input-group ">
              <div class=" ">
                <p class=" vitritext">
                  Chân dung
                </p>
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
                <div id="carouselExampleIndicators" class="carousel slide " data-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item ">
                      <img class="trongoc " src="form/pic/theloai/cuoi1.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                      <img class="trongoc " src="form/pic/theloai/cuoi2.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item active">
                      <img class="trongoc " src="form/pic/theloai/cuoi3.jpg" alt="Third slide">
                    </div>
                  </div>
                </div>
              </a>
            </div>
            <div class="input-group ">
              <div class=" ">
                <p class=" vitritext">
                  Đám cưới
                </p>
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
                <div id="carouselExampleIndicators" class="carousel slide " data-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item ">
                      <img class="trongoc " src="form/pic/theloai/kyyeu1.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                      <img class="trongoc " src="form/pic/theloai/kyyeu2.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item active">
                      <img class="trongoc " src="form/pic/theloai/kyyeu3.jpg" alt="Third slide">
                    </div>
                  </div>
                </div>
              </a>
            </div>
            <div class="input-group ">
              <div class=" ">
                <p class=" vitritext">
                  Kỷ Yếu
                </p>
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
                <div id="carouselExampleIndicators" class="carousel slide " data-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item ">
                      <img class="trongoc " src="form/pic/theloai/giadinh1.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                      <img class="trongoc " src="form/pic/theloai/giadinh2.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item active">
                      <img class="trongoc " src="form/pic/theloai/giadinh3.jpg" alt="Third slide">
                    </div>
                  </div>
                </div>
              </a>
            </div>
            <div class="input-group ">
              <div class=" ">
                <p class=" vitritext">
                  Gia đình
                </p>
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
                <div id="carouselExampleIndicators" class="carousel slide " data-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item ">
                      <img class="trongoc " src="form/pic/theloai/sanpham1.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                      <img class="trongoc " src="form/pic/theloai/diaoc2.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item active">
                      <img class="trongoc " src="form/pic/theloai/sanpham3.jpg" alt="Third slide">
                    </div>
                  </div>
                </div>
              </a>
            </div>
            <div class="input-group ">
              <div class=" ">
                <p class=" vitritext">
                  Sản phẩm
                </p>
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
                <div id="carouselExampleIndicators" class="carousel slide " data-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item ">
                      <img class="trongoc " src="form/pic/theloai/sukien3.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                      <img class="trongoc " src="form/pic/theloai/sukien2.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item active">
                      <img class="trongoc " src="form/pic/theloai/sukien1.jpg" alt="Third slide">
                    </div>
                  </div>
                </div>
              </a>
            </div>
            <div class="input-group ">
              <div class=" ">
                <p class=" vitritext">
                  Sự kiện
                </p>
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
        <div class="bgphotographer container-fluid container ">
          <!--1 thang-->
          <div class="input-group  ">

            <!--tháº±ng 1-->

            <div class="  col-5  ">
              <div class="  "><img class=" img-fluid" src="form/pic/ungtuyen.jpg" alt="">
              </div>
            </div>

            <div class="col-5">
              <p class="display-4 text-uppercase">
                Thợ ảnh hoặc người mẫu ảnh
              </p>
              <br>
              <br>
              <br>
              <a class="btn btn-outline-dark btn-group-lg" href="registerphoto.html">Ứng tuyển</a>

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
          <p class="col-12"> Các xu hướng trong năm</p>

        </div>
        <!---->
        <div class="bgphotographer container-fluid container ">
          <!--1 thang-->
          <div class="input-group  ">

            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/3.jpg" alt="">
                <div class="hover-overlay"></div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/3.jpg" alt="">
                <div class="hover-overlay"></div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/3.jpg" alt="">
                <div class="hover-overlay"></div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
            <!--tháº±ng 1-->

            <div class=" bgimg col-3 bg-dark canle ">
              <div class="hover hover-1 bgimg1  "><img class="" src="form/pic/3.jpg" alt="">
                <div class="hover-overlay"></div>
              </div>
            </div>

            <!--háº¿t tháº±ng 1-->
          </div>

        </div>


      </div>
    </div>
  </div>
  <div class="footer"> <a class="btn-top btn-outline-light " href="javascript:void(0);"><i class="fa fa-chevron-up"
        aria-hidden="true"></i></a> </div>
  <!--footer-->
  <%@ include file="form/include/footer.jsp"%>
  <!--footer -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js "></script>
  
  </body>

</html>