<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Đăng nhập</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
  </script>
    <link rel="stylesheet" href="public/fontawesome-free-5.15.1-web/css/all.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
  </script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="public/css/style.css" >
   <link rel="stylesheet" href="public/css/bootstrap.min.css">
   
</head>

<body>
  <!--navbar-->
  <nav class="navbar navbar-expand-xl bg-dark sticky-top ">
    <a class="navbar-brand mr-5" href="${pageContext.request.contextPath}/HomePageServlet"><img src="form/pic/logo.png" class="" height="60px"></a>
  </nav>

  <div>
    <div class="container-fluid bg-light">
      <div class="row justify-content-center half">
        <div class="col-md-12">
          <!-- <div class="bg order-1 order-md-2 bg1"> </div> -->
          <div class="form-block mx-auto">
            <div class="form-group text-center mb-5">
              <h1>Đăng nhập</h1>
            </div>
            <form id="login-form" class="form" action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <div class="form-group">
              <label for="email">Email/SĐT</label>
              <input type="text" class="form-control" name="username" id="username" placeholder="Đăng nhập email hoặc số điện thoại">
              <span id="username_error"></span>
            <!--   <c:choose> 
          			<c:when test="${bug=='false'}"> 
              			<p class="bg-dark">tài khoản hoạc mật khẩu không đúng</p>
          			</c:when>
          		</c:choose>-->
            </div>
            <div class="form-group">
              <label for="password" class="label">Mật khẩu</label>
              <input type="password" class="form-control" name="password" id="password" placeholder="nhập mật khẩu">
              <span id="password_error"></span>
            </div>
            <div class="form-group d-sm-flex mb-5 align-items-center">
              <span class="ml-auto"><a href="#" class="forgot-pass">Quên mật khẩu</a></span>
            </div>
            <div class="form-group">
              <button type="submit" class="btn btn-info btn-block my-3 form-group">Đăng nhập</button>
            </div>
            </form>
            
            <div class="form-group">
              <span class="text-center my-3 d-block">or</span>
              <div class="">
                <a href="#" class="btn btn-block py-2 btn-facebook">
                  <i class="fa fa-facebook-square"></i>Đăng nhập với facebook
                </a>
                <a href="#" class="btn btn-block py-2 btn-google">
                  <i class="fa fa-google-plus-square"></i> Đăng nhập Google</a>
              </div>
              <span class="text-center my-3 d-block ">Nếu bạn chưa có tài khoản
                <a href="${pageContext.request.contextPath}/RegisterServlet">Tại đây</a>
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
      <%@ include file="form/include/footer.jsp"%>
  </body>

</html>