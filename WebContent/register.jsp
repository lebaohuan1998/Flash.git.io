<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Register Flash</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
  </script>
    <link rel="stylesheet" href="public/fontawesome-free-5.15.1-web/css/all.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
  </script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <link rel="stylesheet" href="public/css/style.css" >
</head>

<body>
  <!--navbar-->
  <nav class="navbar navbar-expand-xl bg-dark sticky-top ">
    <a class="navbar-brand mr-5" href="${pageContext.request.contextPath}/HomePageServlet"><img src="form/pic/logo.png" class="" height="60px"></a>
    </div>
  </nav>
  <div class="container-fluid bg-light ">
    <div class="row justify-content-center">
      <div class="col-md-12">
        <div class="form-block mx-auto">
          <div class="form-group text-center ">
            <h1>Đăng ký Flash</h1>
          </div>

 <form id="login-form" class="form" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
          <div class="form-row">
            <div class="form-group col-sm-6">
              <label class="label">Họ và Tên(*)</label>
              <input type="" class="form-control" name="fullName"  placeholder="Nhập họ và tên" />
            </div>
        </div>
          <div class="form-group">
            <label class="label">Mật khẩu(*)</label>
            <input type="password" class="form-control"  placeholder="Mật khẩu ít nhất 8-16 ký tự" />
            <p class=""></p>
          </div>
          <div class="form-group">
            <label class="label">Nhập lại mật khẩu(*)</label>
            <input type="password" class="form-control" name="password" placeholder="Mật khẩu ít nhất 8-16 ký tự" />
            <p class=""></p>
          </div>
          <div class="form-row">
            <div class="form-group col-sm-8">
              <label for="email">Email(*)</label>
              <input type="email" id="email" name ="email" class="form-control col" placeholder="Nhập email">
            </div>
          </div>
          
          <div class="form-group">
            <label class="label">SĐT</label>
            <input type="phone"  class="form-control" name="phone" />
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-info btn-block my-3">Tạo tài khoản</button>
          </div>
          
       </form>
        
          <div class="form-group mb-0">
            <span class="my-3 d-block">Khi bạn nhấn Đăng ký, bạn đã đồng ý thực hiện mọi giao dịch mua bán
              theo
              điều kiện sử dụng và chính sách của Flash.</span>
          </div>
          <div class="form-group mb-0">
            <span class="my-3 d-block">Nếu bạn muốn đăng ký là người chụp ảnh hay người mẫu
              <a href="registerphoto.jsp">tại đây</a>
            </span>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@ include file="form/include/footer.jsp"%>
</body>

</html>