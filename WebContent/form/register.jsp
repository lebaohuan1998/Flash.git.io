<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login Flash</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
  </script>
    <link rel="stylesheet" href="fontawesome-free-5.15.1-web/css/all.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
  </script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <link href="css/style.css" rel="stylesheet">
  <script type="text/javascript" src="jquery/index.js"></script>
</head>

<body>
  <!--navbar-->
  <nav class="navbar navbar-expand-xl bg-dark sticky-top ">
    <a class="navbar-brand mr-5" href="home-page.jsp"><img src="pic/logo.png" class="" height="60px"></a>
    </div>
  </nav>
  <div class="container-fluid bg">
    <div class="row justify-content-center">
      <div class="col-md-12">
        <div class="form-block mx-auto">
          <div class="form-group text-center ">
            <h1>Đăng ký Flash</h1>
          </div>

          <div class="form-row">
            <div class="form-group col-sm-6">
              <label class="label">Họ và Tên(*)</label>
              <input type="password" class="form-control" placeholder="Nhập họ và tên" />
            </div>
            <div class="form-group col-sm-6">
                <label class="label">Tên tài khoản</label>
                <input type="text" class="form-control" placeholder="Nhập tài khoản" />
            </div>
        </div>
          <div class="form-group">
            <label class="label">Mật khẩu(*)</label>
            <input type="password" class="form-control" placeholder="Mật khẩu ít nhất 8-16 ký tự" />
            <p class=""></p>
          </div>
          <div class="form-group">
            <label class="label">Nhập lại mật khẩu(*)</label>
            <input type="password" class="form-control" placeholder="Mật khẩu ít nhất 8-16 ký tự" />
            <p class=""></p>
          </div>
          <div class="form-row">
            <div class="form-group col-sm-8">
              <label for="email">Email(*)</label>
              <input type="email" id="email" class="form-control col" placeholder="Nhập email">
            </div>
            <div class="form-group col-sm-4">
              <label class="dot">.</label>
              <input type="button" class="form-control codeemail" value="Gửi mã xác thực" />
            </div>
          </div>

          <!-- <div class="form-group">
                        <div class="form-row">
                            <label for="email">Email</label>
                        </div>
                        <div class="form-row">
                            <input type="email" id="email" class="form-control col" placeholder="Nhập email">
                            <button class="btn col-sm-4 bg-warning codeemail">Gửi mã xác nhận</button>
                        </div>
                    </div> -->
          <div class="form-group">
            <label for="code" class="label">Mã xác thực(*)</label>
            <input type="code" class="form-control" id="code" placeholder="Nhập mã xác thực">
            <p class=""></p>
          </div>

          <!-- <div class="form-group ">
                        <div class="form-row">
                            <div class="form-group ">
                                <label for="gender" class="label">Giới tính</label>
                            </div>
                            <div class="col"></div>
                            <div class="col-sm-4">
                                <input type="radio" class="form-check-input" id="male" name="gender">
                                <label class="form-check-label" for="male">Nam</label>
                            </div>
                            <div class="col-sm-4">
                                <input type="radio" class="form-check-input" id="female" name="gender">
                                <label class="form-check-label" for="female">Nữ</label>
                            </div>
                        </div>
                    </div> -->
          <div class="form-group">
            <label class="label">SĐT</label>
            <input type="phone" class="form-control" />
          </div>
          <div class="form-group">
            <label class="label">Ngày Sinh</label>
            <input type="date" class="form-control" />
          </div>
          <!-- <div class="form-group">
            <label class="label">Địa chỉ</label>
            <input type="text" class="form-control" />
          </div> -->
          <!-- <div class=" form-group">
                        <div class="form-row">
                            <div class="form-group col-sm-4">
                                <label for="myCity">Xã</label>
                                <input type="text" class="form-control" id="myCity">
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="myState">Quận/Huyện</label>
                                <input type="text" class="form-control" id="myCity">
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="myZip">Thành Phố</label>
                                <input type="text" class="form-control" id="myZip">
                            </div>
                        </div>
                    </div> -->
          <div class="form-group">
            <label class="label" id="dt1" hidden>Thông tin liên hệ</label>
            <input type="text" class="form-control" id="dt2" onchange="myclick1();"
              placeholder="Bạn có bao nhiêu năm kinh nghiệm" hidden />
          </div>
          <div class="form-group">
            <label class="label" id="dt3" hidden>Ở đâu</label>
            <input type="text" class="form-control" id="dt4" onchange="myclick1();"
              placeholder="Bạn đã từng làm tại công ty" hidden />
          </div>
          <div class="form-group ">
            <div class="form-check">
              <input type="checkbox" class="form-check-input" id="information">
              <label class="form-check-label" for="information">Nhận thông tin về trang web qua
                email</label>
            </div>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-info btn-block my-3">Tạo tài khoản</button>
          </div>
          <div class="form-group mb-0">
            <span class="my-3 d-block">Khi bạn nhấn Đăng ký, bạn đã đồng ý thực hiện mọi giao dịch mua bán
              theo
              điều kiện sử dụng và chính sách của Flash.</span>
          </div>
          <div class="form-group mb-0">
            <span class="my-3 d-block">Nếu bạn muốn đăng ký là người chụp ảnh hay người mẫu
              <!-- <button class="here" id="ndt" onclick="myclick();">tại đây</button> -->
              <a href="registerphoto.jsp">tại đây</a>
            </span>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@ include file="include/footer.jsp"%>
</body>

</html>