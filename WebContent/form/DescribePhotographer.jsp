<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">


<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT"
	crossorigin="anonymous"></script>




<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/public/js/ckeditor/ckeditor.js"></script>

<script
	src="${pageContext.request.contextPath}/public/js/ckfinder/ckfinder.js"></script>
	
<div class="container-fluid col-9">
	<div class=" justify-content-center half">
		<div class="col-md-12">
			<form id="describe" class="form"
				action="${pageContext.request.contextPath}/DescribePhotographer?flag=5&cmd=describe"
				method="post" enctype="multipart/form-data">


				<div class="form-block4 mx-auto">

					<h4 style="text-align: center;">Cập nhập thông tin chung thợ ảnh</h4>
					<div class="form-block5 mx-auto" style="border: 0.5px solid;">
						<textarea name="editor1" id="editor1">
						<c:out value="${describeText}" /> </textarea>


						<script>
							CKEDITOR.replace('editor1', {
								language : 'vi'
							});
							
							CKFinder.setupCKEditor(editor1,'<%=request.getContextPath()%>/public/js/ckfinder/');
						</script>
					</div>


					<div  style="border: 1px;">
						<button type="submit" class="btn btn-outline-success"
							style="margin-left: 400px; margin-top: 10px">Lưu Lại</button>


						<!-- Extra large modal -->

						<button type="button" id="xemthu" class="btn btn-outline-success"
							data-toggle="modal" data-target=".bd-example-modal-xl"
							style="margin-left: 50px;margin-top: 10px;">Xem Thử</button>
						<br>

						<div class="modal fade bd-example-modal-xl" tabindex="1"
							role="dialog" aria-labelledby="myLargeModalLabel"
							aria-hidden="true">
							<div class="modal-dialog modal-xl">
								<div class="modal-content">
									<br>
									<p style="margin-left: 40px;">
										<b> Thông tin chung của thợ ảnh</b>
									</p>
									<br>
									<div
										style="margin-left: 40px; margin-right: 40px; margin-bottom: 25px;">
										${describeText}</div>
								</div>
							</div>
						</div>

						<hr>

					</div>

				</div>
			</form>
		</div>





		<div class=" justify-content-center half">
		
		<span style="margin-left: 20px; margin-top: -10px;font-size: 25px;"><b>Tải ảnh chèn vào bài viết</b> </span>
			<form id="describes" class="form"
				action="${pageContext.request.contextPath}/DescribePhotographer?flag=5&cmd=uploadImage"
				method="post" enctype="multipart/form-data">


				<div class="col-md-12">

					<div class="form-inline">
						<c:if test="${imgname1==null}">
							<img src="form/pic/anhchandung.png" class="image1dvx" id="myImg"
								style="height: 100px; width: 140px">
								
							<input type="file" class="btn" name="file1">
							<input type="text" id="myInput1" class="btn btn-sm"
								value=" ${pageContext.request.contextPath}/images/${id}${role}/${imgname1}"
								style="border: solid; margin-left: -10px;" disabled>
							<button onclick="myFunction1()"
								class="btn btn-outline-secondary"
								style="margin-left: 2px; font-size: 15px;" disabled>Sao
								chép</button>
						</c:if>

						<c:if test="${imgname1!=null}">
							<img src="images/${id}${role}/${imgname1}?t=${urlAdd}" class="image1dvx"
								id="myImg" src="#" alt="your image" height=100px width=140px>
							<input type="file" class="btn" name="file1">
							<input type="text" id="myInput1" class="btn btn-sm "
								value=" ${pageContext.request.contextPath}/images/${id}${role}/${imgname1}?t=${urlAdd}"
								style="border: 1px solid #ccc!important; margin-left: -10px;">
							<a onclick="myFunction1()"
								class="btn btn-outline-primary"
								style="margin-left: 2px; font-size: 15px;">Sao chép</a>
						</c:if>




						<br>


						<c:if test="${imgname2==null}">
							<img src="form/pic/anhchandung.png" class="image1dvx"
								height=100px width=140px>

							<input type="file" class="btn" name="file2">
							<input type="text" id="myInput" class="btn btn-sm"
								value=" ${pageContext.request.contextPath}/images/${id}${role}/${imgname2}?t=${urlAdd}"
								style="border: solid; margin-left: -10px;" disabled>
							<button class="btn btn-outline-secondary"
								style="margin-left: 2px; font-size: 15px;" disabled>Sao
								chép</button>

						</c:if>


						<c:if test="${imgname2!=null}">
							<img src="images/${id}${role}/${imgname2}?t=${urlAdd}" class="image1dvx"
								id="myImg" src="#" alt="your image" height=100px width=140px>

							<input type="file" class="btn" name="file2">
							<input type="text" id="myInput" class="btn btn-sm"
								value=" ${pageContext.request.contextPath}/images/${id}${role}/${imgname2}?t=${urlAdd}"
								style="border: 1px solid #ccc!important; margin-left: -10px;">
							<a class="btn  btn-outline-primary"
								style="margin-left: 2px; font-size: 15px;"
								onclick="myFunction()">Sao chép</a>
						</c:if>

					</div>



					<button type="submit" class="btn btn-outline-success"
						style="margin-left: 600px; margin-top: 40px">Tải ảnh lên</button>

				</div>

			</form>
			
			<hr>
		</div>

	</div>

</div>




<script type="text/javascript">
	function myFunction() {
		var copyText = document.getElementById("myInput");
		copyText.select();
		copyText.setSelectionRange(0, 99999); /* For mobile devices */
		document.execCommand("copy");
		alert("Bạn đã copy link ảnh: " + copyText.value);
	}
</script>

<script type="text/javascript">
	function myFunction1() {
		var copyText = document.getElementById("myInput1");
		copyText.select();
		copyText.setSelectionRange(0, 99999); /* For mobile devices */
		document.execCommand("copy");
		alert("Bạn đã copy link ảnh: " + copyText.value);
	}
</script>

