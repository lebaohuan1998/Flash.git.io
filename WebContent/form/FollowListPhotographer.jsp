<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
<div class="container col-9" style="border: 1px solid rgba(0, 0, 0, 0.15);margin-top: 10vh;height: 740px;">

 <c:if test="${hide !='yes'}">
	<h3 class=" text-center" style="margin-top: 10px;">Danh sách nhiếp	ảnh gia yêu thích</h3>
</c:if>

		 <h3 class=" text-center" style="margin-top: 20px;"> ${notification}</h3>

	<div class="form-inline" style="margin-top: 10px;">
	
	<c:forEach items="${listAll}" var="list">	
	
		<div class="form-inline col-6 content_ds" style="margin-bottom: 10px;">

			<div class="ds_photo" style="margin-left: 30px;">
			<c:if test="${list.avata!=null}">
				<img src="images/${list.id}${rolePhotographer}/${list.avata}" style="positon:relative;border-radius: 10px;" id="myImg" src="#">
				</c:if>
				<c:if test="${list.avata==null}">
				<img src="form/pic/anhchandung.png" id="myImg" src="#">
				</c:if>
			</div>
			<div style="margin-left: 20px;">
				<a href="${pageContext.request.contextPath}/photographer?photographerId=${list.id}" style="color: black; font-weight: bold;">${list.nickName}</a><br> <span>
				<i class="far fa-thumbs-up"  aria-hidden="true" style="margin-right: 3px;"></i> ${list.countFollower} người theo
					dõi</span><br> <span><i class="fa fa-map-marker-alt"
					aria-hidden="true" style="margin-right: 3px;"></i>${list.provinceId}</span>
					<br>
					<br>
					<button onclick="unFollow(${list.id})" class="btn btn-outline-secondary btn-sm " id="btnunfollow">      <span class="bi bi-heart"></span>
                                                    Bỏ theo dõi
                                                </button>
					
					
					
					
			</div>
		</div>
		
		</c:forEach>
		
		</div>

	</div>
	
	
</div>

<c:if test="${hide !='yes'}">
<div style="margin-left: 59%; margin-top: 10px;">
	
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link btn-outline-dark"
					href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach items="${page}" var="list">
					<li class="page-item"><a
						class="page-link <c:if test="${param.page ==list}">text-white bg-dark</c:if> 
							<c:if test="${param.page ==null&&list==1}">text-white bg-dark</c:if>"
						href="${pageContext.request.contextPath}/followPhotographer?flag=3&page=${list}">${list}</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>

</div>

</c:if>





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
