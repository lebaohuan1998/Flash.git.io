<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
<%-- <fmt:formatNumber  value="${list.price}"   --%>
<%--                 type="number" maxIntegerDigits = "3" /> --%>

<%@page import="java.text.DecimalFormat"%>

<div class="container col-9" style="border: 1px solid rgba(0, 0, 0, 0.15);margin-top: 10vh;height: 600px;">



	<c:if test="${hide !='yes'}">
		<h3 class="text-center" style="margin-top: 20px;">Danh sách gói
			dịch vụ yêu thích</h3>
<%-- 			<c:set var="price" value="${list.price}" /> --%>
			<fmt:formatNumber  value="${list.price}"  
                type="number" maxFractionDigits = "3" />
			
	</c:if>

	<h3 class=" text-center" style="margin-top: 12px;">
		${notificationFollowSV}</h3>

	<div class="col-sm-12">
		<div class="form-inline" style="margin-top: 10px;">
			<c:forEach items="${listAll}" var="list">
				<div class="col-md-4" style="margin-top: 15px;">
					<div class="hover_2 hover-1_2">
						<img src="images/${list.photographerID}${rolePhotographer}/albums/${list.servicepackageName}/${list.coverImage}" alt="">


						<div class="hover-overlay_2"></div>
						<div class="hover-1-noidung_2">
							<div id="tenvovan" class="form-inline col-16 ">
							
								<a id="btnUNFOLLOW" onclick="unFollow(${list.id})" data-toggle="tooltip" data-placement="left" title="Bỏ theo dõi" href="#" class="fa fa-bookmark bookmark px-3 bk_2" "></a>
									
									
									<input id="iduser" class="collapse" value="${id}">
					 				<input	id="idServicePackage" class="collapse" value="${list.id}">

								
								
								
								<p style ="text-align:right;" "class="hover-1-trichdan_2 font-weight-light ">${list.convertPrice} Đ</p>
							</div>
							<div class="font-weight-light py-0">
								<div class="form-inline col-sm-12">
									<div class="div1_2"
										style="margin-right: 10px; margin-left: 10px;">
										<c:if test="${list.avatar!=null}">
											<img src="images/${list.photographerID}${rolePhotographer}/${list.avatar}"
												style="margin-left: 13px; margin-top: 9px;">
										</c:if>
										<c:if test="${list.avatar==null}">
											<img src="form/pic/anhchandung.png" style="margin-left: 13px; margin-top: 9px;">
										</c:if>

									</div>
									<h6 style="font-size: 11px;" class="conten_2 px-1">
										<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.photographerID}" style="color: white;">${list.nickName}</a><br>
										<a class="diachi" style="color: white; font-size: 10px;">
											${list.provinceName}</a>
									</h6>

								</div>
							<div class="khong" style="margin-left:1px">
							
							
							<c:if test="${list.pointRating ==0}">
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							
							</c:if>
							<c:if test="${list.pointRating<1.5&&list.pointRating>0}">
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							</c:if>
							
							<c:if test="${list.pointRating<2.5&&list.pointRating>=1.5}">
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							
							</c:if>
										
							<c:if test="${list.pointRating<3.5&&list.pointRating>=2.5}">
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							
							</c:if>		
							<c:if test="${list.pointRating<4.5&&list.pointRating>=3.5}">
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star star " style="font-size: 10px;"></span>
							
							</c:if>			
							
							<c:if test="${list.pointRating>=4.5}">
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							<span class="fa fa-star checked " style="font-size: 10px;"></span>
							
							</c:if>				
<%-- 									<button onclick="window.location.href='${pageContext.request.contextPath}/servicePackage?id=${list.id}' class="theodoi" style="font-size: 12px;">Xem chi tiết</button> --%>
									<a class="btn btn-default btn-sm" style="font-size: 11px;margin-left: 1px;" href="${pageContext.request.contextPath}/servicePackage?spID=${list.id}">Xem chi tiết</a>
<%-- 										<a class="theodoi" style="font-size: 12px;" href="${pageContext.request.contextPath}/servicePackage?id=${list.id}">Xem chi tiết</a> --%>
								</div>

							</div>
						</div>
					</div>
				</div>
				<br>
			</c:forEach>



		</div>
	</div>
</div>





<c:if test="${hide !='yes'}">
	<div style="margin-left: 59%; margin-top: 30px;">

		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link btn-outline-dark"
					href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach items="${page}" var="list">
					<li class="page-item"><a
						class="page-link <c:if test="${param.page ==list}">text-white bg-dark</c:if> 
							<c:if test="${param.page ==null&&list==1}">text-white bg-dark</c:if>"
						href="${pageContext.request.contextPath}/followServicePackage?flag=2&page=${list}">${list}</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>

	</div>

</c:if>


<script type="text/javascript"> 
 $(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})

 </script> 


<script type="text/javascript">
$("#btnUNFOLLOW").click(function($val) {
	//var idServicePackage = document.getElementById("idServicePackage").value;
	//var idUser = document.getElementById("iduser").value;
	//console.log(idUser);
	$.ajax({
		url : '${APIurl}?command=UNFOLLOW',
		type : 'GET',
		data : {
			id1 : $val,
			
		},
		success : function(result) {
			window.location.reload();
		},
		error : function(error) {
			console.log(error);
		}
	});
});

</script>



<script type="text/javascript">
    function unFollow($val) {
        $.ajax({
          
            url:  '${APIurl}?command=UNFOLLOW',
            type: "GET",  
            data : {
    			id1 : $val,
    			
    		},
            success: function(result) {
            	
            	window.location.reload();
               
            }
            ,
    		error : function(error) {
    			alert("error unfollow");
    		}
        });
    }               
</script>