<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="public/fontawesome-free-5.15.1-web/css/all.min.css">
<link rel="stylesheet" href="public/css/style.css">
<link rel="stylesheet" href="public/css/menuver2.css">
<link rel="stylesheet" href="public/css/csshomepage.css">
<link rel="stylesheet" href="public/css/danhgiaalbum.css">
<link rel="stylesheet" href="public/css/danhsachyeuthich.css">
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css"
	rel="stylesheet" />
<script src="public/js/jquery.popup.lightbox.js"></script>
<link href="public/css/popup-lightbox.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="include/navbar.jsp"%>
	<div class="container" style="margin-bottom: 20px;">
		<div class="input-group">
			<div>
				<div style="margin-top: 20px;">
					<label style="font-size: 14px;">Thứ sáu, 16/4/2021, 14:09
						(GMT+7)</label>
				</div>
				<div style="width: 680px;">
					<article>
						<h1 style="font-size: 36px; width: 680px;">${ArticleViewId.title}</h1>
						<div>${ArticleViewId.content}</div>

					</article>

				</div>
				<div style="float: right;">
					<span style="font-weight: bold;">Người đăng bài viết</span><br>
					<p style="">${ArticleViewId.author_article}</p>
				</div>

			</div>
			<div
				style="box-sizing: border-box; padding-left: 40px; margin: 30px 0px 0px 60px; width: 350px;">

				<div>
					<h4>Mới nhất</h4>
					<c:forEach items="${ArticleNewViewId}" var="articlenew">
						<div style="border-bottom: 1px solid rgba(0, 0, 0, 0.15);">
							<a
								href="${pageContext.request.contextPath}/baiviet?id=${articlenew.id}"
								style="color: black; text-decoration: none;"> <%-- 	 <c:if test="${articlenew.id ==max}">
									 <img src="form/pic/quangcaothoitrang.jpg" style="width: 100%;" /> 
								</c:if> --%>
								<p style="margin-top: 10px;">${articlenew.title}</p></a>
						</div>
					</c:forEach>
					<div style="margin-top: 10px;">
						<h4>Các gói dịch vụ</h4>
						<c:forEach items="${ArticleAlbum}" var="art_albm">
							<div class="col-10" style="padding-left: 0px; margin-top: 20px;">
								<div class="hover_danhgia hover-1_danhgia">
									<img
										src="images/${art_albm.photographerID}4/albums/${art_albm.servicepackageName}/${art_albm.coverImage}"
										alt="clgt">
									<div class="hover-overlay_danhgia"></div>
									<div class="hover-1-noidung_danhgia">
										<div class="form-inline col-16">
											<span class="fa fa-bookmark bookmark px-3 bk_1"
												style="margin-bottom: 45px; font-size: 24px;"></span>
											<p class="hover-1-trichdan_danhgia font-weight-light"
												style="margin-left: 120px;">${art_albm.price}.đ</p>
										</div>
										<div class="font-weight-light py-0">
											<div class="form-inline col-sm-12">
												<div class="div1_danhgia">
													<img src="images/${art_albm.photographerID}4/avata.jpg"
														style="margin-left: 10px;" />
												</div>
												<h6 style="font-size: 14px; margin-left: 40px;"
													class="conten_1 px-1">
													<a href="${pageContext.request.contextPath}/photographer?command=VIEWALBUM&photographerId=${art_albm.photographerID}" style="color: white;">${art_albm.nickName}</a><br>
													<span class="font-weight-light ">${art_albm.shootingLocation}</span>
												</h6>
											</div>
											<div class="" style="margin-left: 10px;">
												<c:if test="${art_albm.pointRating ==0}">
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>

												</c:if>
												<c:if
													test="${art_albm.pointRating<1.5&&art_albm.pointRating>0}">
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
												</c:if>

												<c:if
													test="${art_albm.pointRating<2.5&&art_albm.pointRating>=1.5}">
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>

												</c:if>

												<c:if
													test="${art_albm.pointRating<3.5&&art_albm.pointRating>=2.5}">
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>

												</c:if>
												<c:if
													test="${art_albm.pointRating<4.5&&art_albm.pointRating>=3.5}">
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star star " style="font-size: 10px;"></span>

												</c:if>

												<c:if test="${art_albm.pointRating>=4.5}">
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>
													<span class="fa fa-star checked " style="font-size: 10px;"></span>

												</c:if>
												<a class=""
													href="${pageContext.request.contextPath}/servicePackage?spID=${art_albm.id}">xem
													chi tiết</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div>
			<h3 style="margin-bottom: 20px;">Nội dung khác</h3>
			<div class="input-group">
				<c:forEach items="${ArticleRandom}" var="articlerandom">
					<a
						href="${pageContext.request.contextPath}/baiviet?id=${articlerandom.id}"
						style="color: black; text-decoration: none;">
						<div class="baiviet_tc">
							<div style="max-width: 100%; height: 240px;" class="baiviet_tc1">
								<img src="form/pic/${articlerandom.avatar_article}"
									style="width: 100%; height: 150px;" />
								<div style="margin: 20px 20px 0px 20px; font-weight: bold;">
									<span>${articlerandom.title}</span>
								</div>
							</div>
							<div style="margin-left: 20px; margin-bottom: 10px;"
								class="baiviet_tc2">
								<span>${articlerandom.author_article}</span>
							</div>
						</div>
					</a>
				</c:forEach>
			</div>
		</div>
	</div>

	<%@ include file="include/footer.jsp"%>
	<script src="${pageContext.request.contextPath}/public/js/danhgia.js"></script>
</body>