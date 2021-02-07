<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Đăng nhập</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>  <link rel="stylesheet" href="public/fontawesome-free-5.15.1-web/css/all.min.css">
  
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
             <c:if  test="${param.Register =='success'}" >
                <div class="alert alert-success in">
                      <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                      <strong>Thành công!</strong> bạn đã đăng ký thành công.
                </div>              
             </c:if>
      <div class="row justify-content-center half">
        <div class="col-md-12">
          <!-- <div class="bg order-1 order-md-2 bg1"> </div> -->
          <div class="form-block mx-auto">
            <div class="form-group text-center mb-5">
              <h1>Đăng nhập</h1>
            </div>
            <form id="login-form" class="form" action="${pageContext.request.contextPath}/LoginServlet" method="POST">
            <div class="form-group">
              <label for="email">Email</label>
              <input type="text" class="form-control" name="username" id="username" placeholder="Đăng nhập email hoặc số điện thoại">
              <c:choose>
              <c:when test="${param.login =='false' }">
                     <p id="password_error" class="alert alert-danger p-1 my-1"> Sai email hoặc mật khẩu</p>
              </c:when>
              </c:choose>
            </div>
            <div class="form-group">
              <label for="password" class="label">Mật khẩu</label>
              <input type="password" class="form-control" name="password" id="password" placeholder="nhập mật khẩu">
              <span id="password_error"></span>
            </div>
            <div class="form-group">
              <label class="label">Chọn Quyền</label>
            </div>
            <div class="form-group  align-items-center">
               <input name="user" type="radio" value="1"  class="mr-3" checked="checked" />Người dùng
               <input name="user" type="radio" value="2" class="mr-3" />Người cung cấp   
            </div>
             
            <div class="form-group d-sm-flex mb-5 align-items-center">
              <span class="ml-auto"><a href="#" class="forgot-pass">Quên mật khẩu</a></span>
            </div>
            
            <div class="form-group">
            <button type="submit" class="btn btn-info btn-block my-3">Đăng nhập</button>
          </div>
            </form>
            
            <div class="form-group">
              <span class="text-center my-3 d-block">or</span>
              <div class="">
                <a href="#" class="btn btn-block py-2 btn-facebook">
                  <i class="fa fa-facebook-square"></i>Đăng nhập với facebook
                </a>
                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Flash/GoogleLogin&response_type=code
    &client_id=457798901989-9ujt0a30a9t04709cotfav8er631bbf0.apps.googleusercontent.com&approval_prompt=force" class="btn btn-block py-2 btn-google">
                  <i class="fa fa-google-plus-square" ></i> Đăng nhập Google</a>
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
     <script src="${pageContext.request.contextPath}/public/js/validate/login.js"></script>
     
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js "></script>
 
  </body>

</html>