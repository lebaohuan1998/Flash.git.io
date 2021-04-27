<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="public/js/jquery.popup.lightbox.js"></script>
<link href="public/css/popup-lightbox.css" rel="stylesheet" />
<div class="container-fluid container"
	style="margin-top: 10px; padding-left: 8rem; padding-right: -30rem;">
	<div class="card mb-4" style="margin-right: -120px;">
		<h2 style="text-align: center;">Quản lý tất cả ảnh của gói dịch
			vụ</h2>


		<div class="img-container2">
			<div class="form-inline"
				style="border-bottom: 0px solid rgba(0, 0, 0, 0.15); margin-top: 10px;">
				<div class=" form-inline" style="margin-top: 20px;">
					<div class="container2 form-inline col-12"
						style="margin-top: 20px; margin-left: 30px;">
						<div class="img-container1 input-group">
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br>
								<a href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br><a
									href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br><a
									href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br><a
									href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br><a
									href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br><a
									href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br><a
									href="#" class="hello">xem chi tiết</a>
							</div>
							<div>
								<img class="" src="form/pic/6.jpg" alt="chan dung" /><br><a
									href="#" class="hello">xem chi tiết</a>
							</div>
						</div>
					</div>
				</div>

			</div>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:forEach items="${page}" var="list">
								<li class="page-item"><a
									class="page-link <c:if test="${param.page ==list}">text-white bg-dark</c:if> 
							<c:if test="${param.page ==null&&list==1}">text-white bg-dark</c:if>"
									href="${pageContext.request.contextPath}/followServicePackage?flag=2&page=${list}">${list}</a></li>
							</c:forEach>
						</ul>
					</nav>
			
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/public/js/danhgia.js"></script>