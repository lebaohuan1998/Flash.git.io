<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Quản lý tài khoản</title>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
            </script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
            </script>

            <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
            <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>  
            <link rel="stylesheet" href="public/fontawesome-free-5.15.1-web/css/all.min.css">
            <link rel="stylesheet" href="public/css/style.css">
            <link rel="stylesheet" href="public/css/csshomepage.css">
            <link rel="stylesheet" href="public/css/bootstrap.min.css">

        </head>

        <body>
            <%@ include file="include/navbar.jsp" %>
             <c:if  test="${param.update =='true'}" >
                <div class="alert alert-success in">
                      <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                      <strong>Thành công!</strong> bạn đã cập nhật thông tin.
                </div>              
             </c:if>
              <c:if  test="${param.err =='true'}" >
                <div class="alert alert-success in">
                      <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                      <strong>Thành công!</strong> bạn đã thay đổi mật khẩu.
                </div>              
             </c:if>
             <c:if  test="${param.errdupplicate =='true'}" >
                <div class="alert alert-warning">
                      <strong>Không thành công</strong> Mật khẩu mới không được trùng với mật khẩu cũ.
                </div>             
             </c:if>
             <c:if  test="${param.err =='false'}" >
                <div class="alert alert-warning">
                      <strong>Không thành công</strong> Sai mật khẩu.
                </div>             
             </c:if>
             
            
            
                <div class="cachbar">
                    <div class="container ">
                      
                        <div class="row justify-content-center half">
                            <div class="col-md-12">
                            <form id="update-form" class="form " action="${pageContext.request.contextPath}/ProfileUser?cmd=ChangeInfo"
                                method="post"  enctype="multipart/form-data">                            
                                <div class="form-block1 mx-auto">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <div class="form-group">

                                            <c:choose>
                                               <c:when test="${imgname!='null'}">
                                                   <img src="form/pic/imageuser/${email}/${imgname}" id="myImg" src="#" alt="your image" name='filename' height=130 width=190 >
                                               </c:when>
                                               <c:otherwise>
                                                    <img src="form/pic/anhchandung.PNG" id="myImg" alt="your image" name='filename' height=130 width=190 >
                                               </c:otherwise>
                                            </c:choose>
                                                <input type="file" name="file">
                                            </div>
                                        </div>

                                
                                        <div class="col-sm-8">
                                            <div class="form-group">
                                                <h4 class="col-sm-6">${user}</h4>
                                                <h4 class="col-sm-6">${gender}</h4>
                                                <h4 class="col-sm-6">${bod}</h4>
                                                <h4 class="col-sm-6">${address}</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- <label type="text" class=" up">Cập nhật tài khoản</label> -->
                                
                                    <div class="form-block1 mx-auto mb-0">
                                        <!-- <div class="form-block mx-auto"> -->
                                        <div class="form-group up1">
                                            <label type="text" class="up">Thông tin cá nhân</label>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-2">
                                                <div class="form-group ">
                                                    <label class="form-group">Email:</label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="form-group">Họ và Tên:</label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="">Ngày sinh:</label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="">Địa chỉ:</label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="">Số điện thoại:</label>
                                                </div>
                                                <div class="form-group">
                                                    <label class="">Giới tính:</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group ">
                                                    <input type="text" class="form-control" value="${email}"
                                                        disabled="disabled">
                                                </div>
                                                <div class="form-group">
                                                    <input type="text" class="form-control " value="${user}"
                                                        name="user">
                                                </div>
                                                <div class="form-group">
                                                    <input type="date" class="form-control " name="dob" value="${bod}"
                                                        >
                                                </div>
                                                <div class="form-group">
                                                    <input type="text" class="form-control " name="address" value="${address}">
                                                </div>
                                                <div class="form-group">
                                                    <input type="text" class="form-control " value="${phone}"
                                                        name="phone">
                                                </div>
                                                <div class="form-group ">
                                                    <input name="gender" type="radio" value="Nam" class="gender"  ${gender=='Nam'?'checked':''} /> Nam
                                                    <input name="gender" type="radio" value="Nữ" class="gender female" ${gender=='Nữ'?'checked':''}  /> Nữ                                                </div>
                                                <button type="submit" class="btn btn-outline-dark">Lưu</button>
                                                
                                            </div>
                                        </div>
                                </form>
                            </div>
                            <form id="update-pass" class="form " action="${pageContext.request.contextPath}/ProfileUser?cmd=ChangePassword"
                            method="post">
                                <div class="form-block1 mx-auto">
                                    <div class="form-group up1">
                                        <label type="text" class="up">Đổi mật khẩu</label>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2">
                                            <div class="form-group">
                                                <label for="email" class="form-group">Nhập mật khẩu hiện tại:</label>
                                            </div>
                                            <div class="form-group">
                                                <label class="form-group">Nhập mật khẩu mới:</label>
                                            </div>
                                            <div class="form-group">
                                                <label for="email" class="">Xác nhân mật khẩu mới:</label>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group ">
                                                <input type="password" class="form-control " name="oldpass">
                                                <c:if  test="${param.err =='false'}" >
                                                       <p id="password_error" class="alert alert-danger p-1 my-1"> Sai mật khẩu</p>
                                                </c:if>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" id="password" class="form-control"
                                                    placeholder="Mật khẩu ít từ 8-16 ký tự" name="newpass">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control"
                                                    placeholder="Mật khẩu ít từ 8-16 ký tự" name="renewpass">
                                            </div>
                                            <c:if  test="${param.errdupplicate =='true'}" >
                                                       <p id="password_error" class="alert alert-danger p-1 my-1"> Mật khẩu mới không được giống mật khẩu cũ</p>
                                                </c:if>
                                            <button type="submit" class="btn btn-outline-dark">Thay đổi mật khẩu</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    </div>
                </div>
                <%@ include file="include/footer.jsp" %>
                <script src="${pageContext.request.contextPath}/public/js/validate/infousernor.js"></script>
        </body>

        </html>