<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
      <link rel="stylesheet" href="form/fontawesome-free-5.15.1-web/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
    </script>
    <link href="form/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="form/jquery/index.js"></script>
</head>

<body>
    <!--navbar-->
    <nav class="navbar navbar-expand-xl bg-dark sticky-top ">
        <a class="navbar-brand mr-5" href="home-page.jsp"><img src="form/pic/logo.png" class="" height="60px"></a>
    </nav>
    <div class="container-fluid bg ">
        <div class="row justify-content-center">
            <div class="col-md-12">
                <div class="form-block mx-auto">
                    <div class="form-group text-center ">
                        <h1>Đăng ký Flash </h1>
                    </div>
                    <div class="form-group text-center ">
                        <h1>Thợ ảnh/người mẫu</h1>
                    </div>
                    <div class="form-row">
                      <div class="form-group col-sm-6">
                        <label class="label">Họ và Tên(*)</label>
                        <input type="password" class="form-control" placeholder="Nhập tên theo CMND" />
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
                    <div class="form-group">
                        <label for="code" class="label">Mã xác thực(*)</label>
                        <input type="code" class="form-control" id="code" placeholder="Nhập mã xác thực">
                        <p class=""></p>
                    </div>
                    <div class="form-group">
                      <label for="code" class="label">SĐT(*)</label>
                      <input type="code" class="form-control" id="code" placeholder="Số điện thoại">
                      <p class=""></p>
                  </div>
                    <div class="form-group">
                        <label class="label">Địa chỉ(*)</label>
                        <input type="text" class="form-control" placeholder="Theo CMND hoặc căn cước công dân" />
                    </div>
                    <!-- <div class=" form-group">
                        <div class="form-row">
                            <div class="form-group col-sm-4">
                                <label for="myCity">Phường/Xã</label>
                                <input type="text" class="form-control" id="myCity">
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="myState">Quận/Huyện</label>
                                <input type="text" class="form-control" id="myCity">
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="myZip">Tỉnh/Thành Phố</label>
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
                            <label class="form-check-label" for="information">Mọi thông tin bạn nhập đã chính xác (chúng
                                tôi sẽ xác minh thông tin của bạn)</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-info btn-block my-3">Tạo tài khoản</button>
                    </div>
                    <div class="form-group">
                        <span class="my-3 d-block">Khi bạn nhấn Đăng ký, bạn đã đồng ý thực hiện mọi giao dịch mua bán
                            theo
                            điều kiện sử dụng và chính sách của Flash.</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
 <%@ include file="form/include/footer.jsp"%>

</body>

</html>