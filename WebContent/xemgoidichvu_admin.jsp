<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid container"
	style="margin-top: 10px; padding-left: 8rem; padding-right: -30rem;">
	<div class="card mb-4" style="margin-right: -120px;">
		<h2 style="text-align: center;">Quản lý gói dịch vụ</h2>

		<div class="input-group dv_lb" style="margin-top: 20px;">
			<c:forEach items="${listServicePackage}" var="list">
				<c:url var="viewalbum" value="/photographer">
					<c:param name="command" value="VIEWALBUM" />
					<c:param name="photographerId" value="${list.photographerID}" />
				</c:url>
				<div class="col-3" style="margin-top: 20px;">
					<div class="hover_danhgia hover-1_danhgia">
						<img
							src="images/${list.photographerID}4/albums/${list.servicepackageName}/${list.coverImage}"
							alt="">
						<div class="hover-overlay_danhgia"></div>
						<div class="hover-1-noidung_danhgia">
							<div class="form-inline col-16">

								<p style="margin-left: 150px;"
									class="hover-1-trichdan_danhgia font-weight-light ">${list.price}.đ</p>
							</div>
							<div class="font-weight-light py-0">
								<div class="form-inline col-sm-12">
									<div class="div1_danhgia">
										<img src="images/${list.photographerID}4/avata.jpg"
											style="margin-left: 10px;" />
									</div>
									<h6 style="font-size: 14px; margin-left: 40px;"
										class="conten_1 px-1">
										<a href="${viewalbum}" style="color: white;">${list.nickName }</a><br>
										<span class="font-weight-light ">${list.provinceName} </span>
									</h6>
									<div class="input-group">
										<a class=""
											href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}"
											style="color: #fff;">xem chi tiết</a>
										<button class="btn btn-outline-success"
											style="margin-right: 3px; margin-left: 3px;">khóa</button>
										<button class="btn btn-outline-info">mở</button>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

			<div id="" style="margin-top: 20px;"
				class="tab-pane <c:if test="">active</c:if>">
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