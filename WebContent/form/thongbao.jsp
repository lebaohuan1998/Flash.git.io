<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->

	
<div class="container col-9">


<body onload="loadPagexx()">
	<div style="margin-top: 10px;">
		<h4>Thông báo của tôi</h4>
	</div>
</body>



	<div class=""
		style="margin-top: 10px;background: #fff; height: 700px; max-width: 100%;">
		<div
			style="font-size: 13px; color: rgb(102, 102, 102); padding: 15px 20px;padding-top:10px;">
			<div class="form-inline" style="border-bottom: 1px solid rgba(0,0,0,0.15);padding-bottom: 2x;">
				<div style="margin-bottom:15px;padding-top:-10px;">
					<span margin-top:20px; ><b>Gợi ý bảo mật</b></span>
				</div>
				<div style="width:640px; margin-left: 30px;margin-top:5px;marin-bottom: 8px;">
					<span>Hãy thay đổi mật khẩu thường xuyên để nâng cao bảo
						mật. Ngoài ra: <br> 1) Không nên sử dụng chung mật khẩu của email với
						mật khẩu của các tài khoản khác. <br> 2) Luôn đăng xuất các tài
						khoản sau khi sử dụng trên thiết bị công cộng hoặc thiết bị không
						phải của bạn</span>
				</div>
				
			</div>
			
			
			
				<c:forEach items="${listAll}" var="list">	
			
			<div class="form-inline" style="margin-top: 20px;border-bottom: 1px solid rgba(0,0,0,0.15);padding-bottom: 20px;">
				<div >
					<span>${list.convertCreatedDate}</span>
				</div>
				<div style="margin-left: 30px;width: 450px;">
				<span>${list.content}</span>
				</div>
				<div style="margin-left: 10px;">
				
					<button onclick="deletex(${list.id})" class="btn" style="background: #fff;border: none;color: red;font-size: 13px;">Xóa</button>
					<a href="${list.detailLink}" class="btn" style="background: #fff;border: none;color: red;font-size: 13px;">Xem chi tiết</a>
				
				
				
				</div>
			</div>
			</c:forEach>
		
		
		
		</div>
	</div>
	
	
	
			<c:if test="${hidePageBooking =='no'}">
				<div style="margin-left: 45%; margin-top: 10px;">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link btn-outline-dark"
								href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<c:forEach items="${page}" var="list">
								<li class="page-item"><a
									class="page-link <c:if test="${param.page ==list}">text-white bg-dark</c:if> 
							<c:if test="${param.page ==null&&list==1}">text-white bg-dark</c:if>"
									href="${pageContext.request.contextPath}/ManageNotification?flag=5&page=${list}">${list}</a></li>
							</c:forEach>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</c:if>

	
</div>


<script type="text/javascript">
    function deletex($val) {
    	
        $.ajax({
            url:  'ManageNotification?command=DELETE',
            type: "GET",  
            data : {
    			notificationId : $val,
    			
    		},
            success: function(result) {
           	window.location.reload();
               
            },
    		error : function(error) {
    		
    			alert("error");
    		}
        });
    }               
</script>


