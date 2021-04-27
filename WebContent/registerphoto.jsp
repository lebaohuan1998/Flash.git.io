<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Đăng ký thợ ảnh</title>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>  
<link rel="stylesheet" href="public/fontawesome-free-5.15.1-web/css/all.min.css">
  
   <link rel="stylesheet" href="public/css/style.css" >
   <link rel="stylesheet" href="public/css/bootstrap.min.css">
</head>

<body>
    <!--navbar-->
    <nav class="navbar navbar-expand-xl bg-dark sticky-top ">
        <a class="navbar-brand mr-5" href="${pageContext.request.contextPath}/HomePageServlet"><img src="form/pic/logo.png" class="" height="60px"></a>
    </nav>
    <div class="bg-light">
    <div class="container-fluid  ">
      <c:if test="${param.err =='false'}">
		<div class="alert alert-warning">
			<strong>Không thành công</strong> Email đã tồn tại.
		</div>
	</c:if>
        <div class="row justify-content-center">
            <div class="col-md-12">
                <div class="form-block mx-auto" style="padding: 0px 40px;border: 1px solid rgba(0,0,0,0.15);">
                    <div class="form-group text-center ">
                        <h1>Đăng ký Thợ ảnh Flash</h1>
                    </div>
                <form id="registerphotoormodel-form" class="form" action="${pageContext.request.contextPath}/RegisterPhotographerOrModel" method="post">
                    
                   <div class="form-group " style="font-family: 'Helvetica', serif;">
                            <label for="email" style="font-family: 'Helvetica', serif;">Email(*)</label>
                            <input type="text" id="email" name="email" class="form-control col" placeholder="Nhập email" style="font-family: 'Helvetica', serif;">
                   </div>
                    <div class="form-group" style="font-family: 'Helvetica', serif;">
                        <label class="label" style="font-family: 'Helvetica', serif;">Họ và Tên(*)</label>
                        <input type="text" class="form-control" name="fullname" placeholder="Nhập tên theo CMND" style="font-family: 'Helvetica', serif;" />
                  </div>
                  <div class="form-group" style="font-family: 'Helvetica', serif;">
                        <label class="label" style="font-family: 'Helvetica', serif;">Nghệ Danh</label>
                        <input type="text" class="form-control" name="nghedanh" placeholder="Nghệ danh" style="font-family: 'Helvetica', serif;" />
                  </div>
                    <div class="form-group" style="font-family: 'Helvetica', serif;">
                      <label class="label" style="font-family: 'Helvetica', serif;">Mật khẩu(*)</label>
                      <input type="password" class="form-control" name="password" id="password" placeholder="Mật khẩu ít nhất 8-16 ký tự" style="font-family: 'Helvetica', serif;"/>
                    </div>
                    <div class="form-group" style="font-family: 'Helvetica', serif;">
                      <label class="label" style="font-family: 'Helvetica', serif;">Nhập lại mật khẩu(*)</label>
                      <input type="password" class="form-control" name="repassword" placeholder="nhập lại mật khẩu" style="font-family: 'Helvetica', serif;" />
                    </div>
                    <div class="form-group" style="font-family: 'Helvetica', serif;">
                      <label class="label">SĐT(*)</label>
                      <input type="text" class="form-control"  name="phone" placeholder="Số điện thoại" style="font-family: 'Helvetica', serif;">
                  </div>
                   <div class="form-group" style="font-family: 'Helvetica', serif;">
                      <label class="label" style="font-family: 'Helvetica', serif;">Địa chỉ theo CMT/CCCD(*)</label>
                      <input type="text" class="form-control"  name="address" placeholder="địa chỉ" style="font-family: 'Helvetica', serif;">
                  </div>
                  <div class="form-group" style="font-family: 'Helvetica', serif;">
                      <label  class="label" style="font-family: 'Helvetica', serif;">Số Thẻ Căn Cước(*)</label>
                      <input type="text" class="form-control"  name="thecancuoc" placeholder="Số thẻ căn cước" style="font-family: 'Helvetica', serif;">
                  </div>
                    <div class="form-group" style="font-family: 'Helvetica', serif;">
                        <button type="submit" class="btn btn-info btn-block my-3" style="font-family: 'Helvetica', serif;">Tạo tài khoản</button>
                    </div>
                 </form>
                    <div class="form-group" style="font-family: 'Helvetica', serif;">
                        <span class="my-3 d-block" style="font-family: 'Helvetica', serif;">Khi bạn nhấn Đăng ký, bạn đã đồng ý thực hiện mọi giao dịch mua bán
                            theo
                            điều kiện sử dụng và chính sách của Flash.</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
 <%@ include file="form/include/footer.jsp"%>
 </div>
  <script src="${pageContext.request.contextPath}/public/js/validate/registerphoto.js"></script>

</body>

</html>