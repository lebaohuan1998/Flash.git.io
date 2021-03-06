<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cập nhật thông tin thợ ảnh</title>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>  
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
        <div class="row justify-content-center">
            <div class="col-md-12">
                <div class="form-block mx-auto" style="padding: 0px 40px 40px 40px;">
                    <div class="form-group text-center ">
                        <h2>Cập nhật thông tin thợ ảnh</h2>
                    </div>
                <form id="registerphotoormodel-form" class="form" action="${pageContext.request.contextPath}/LoginPhotographerGoogle" method="post">
                    
                   <div class="form-group " >
                            <label for="email" >Email</label>
                            <input type="text" id="email" name="email" class="form-control col" placeholder="Nhập email" value="${email }" readonly="readonly" >
                   </div>
                    <div class="form-group" >
                        <label class="label" >Họ và Tên(*)</label>
                        <input type="text" class="form-control" name="fullname" placeholder="Nhập tên theo CMND"  />
                  </div>
                  <div class="form-group">
                        <label class="label" >Nghệ Danh</label>
                        <input type="text" class="form-control" name="nghedanh" placeholder="Nghệ danh" />
                  </div>
                    <div class="form-group" >
                      <label class="label" >Mật khẩu(*)</label>
                      <input type="password" class="form-control" name="password" id="password" placeholder="Mật khẩu ít nhất 8-16 ký tự" />
                    </div>
                    <div class="form-group" >
                      <label class="label" >Nhập lại mật khẩu(*)</label>
                      <input type="password" class="form-control" name="repassword" placeholder="nhập lại mật khẩu"  />
                    </div>
                    <div class="form-group" >
                      <label class="label">SĐT(*)</label>
                      <input type="text" class="form-control"  name="phone" placeholder="Số điện thoại" >
                  </div>
                   <div class="form-group" >
                      <label class="label">Địa chỉ theo CMT/CCCD(*)</label>
                      <input type="text" class="form-control"  name="address" placeholder="địa chỉ" >
                  </div>
                  <div class="form-group" >
                      <label  class="label" >Số Thẻ Căn Cước(*)</label>
                      <input type="text" class="form-control"  name="thecancuoc" placeholder="Số thẻ căn cước">
                  </div>
                    <div class="form-group" >
                        <button type="submit" class="btn btn-info btn-block my-3" >Cập nhật thông tin</button>
                    </div>
                 </form>
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