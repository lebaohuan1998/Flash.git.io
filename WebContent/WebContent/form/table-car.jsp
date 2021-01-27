<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Car</title>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>

<c:if test="${not empty param.message}">
	<span class="row alert alert-danger"> ${param.message} </span>
</c:if>
<c:if test="${not empty param.success}">
	<span class="row alert alert-success"> ${param.success} </span>
</c:if>

<div class="table-responsive">
	<form
		action="${pageContext.request.contextPath}/CarServlet?command=SEARCH"
		method="post"
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0 float-right">
		<div class="input-group mb-5">
			<input class="form-control" type="text" placeholder="License plate"
				aria-label="Search" aria-describedby="basic-addon2"
				name="nameSearch" />
			<div class="input-group-append">
				<button class="btn btn-primary" type="submit">
					<i class="fa fa-search"></i>
				</button>
			</div>
		</div>
	</form>
	<table class="table table-bordered" id="dataTable" width="100%"
		cellspacing="0">
		<thead>
			<tr>
				<th>Lisence Plate</th>
				<th>Color</th>
				<th>Car type</th>
				<th>Car company</th>
				<th>Car parking lot</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>License Plate</th>
				<th>Color</th>
				<th>Car type</th>
				<th>Car company</th>
				<th>Car parking lot</th>
				<th colspan="2">Action</th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach var="car" items="${LIST_CAR}">
				<c:url var="deleteLink" value="CarServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="licensePlate" value="${car.licensePlate}" />
				</c:url>
				<c:url var="updateLink" value="CarServlet">
					<c:param name="command" value="LOAD_UPDATE" />
					<c:param name="licensePlate" value="${car.licensePlate}" />
				</c:url>
				<tr>
					<td>${car.licensePlate}</td>
					<td>${car.carColor}</td>
					<td>${car.carType}</td>
					<td>${car.company}</td>
					<td>
					<c:forEach var="park" items="${LIST_PARKING_LOT}">
						<c:if test="${car.parkId == park.parkId}">
							${park.parkName}
						</c:if>
					</c:forEach>
					</td>
					<td><a data-toggle="modal"
						data-target="#deleteModal${car.licensePlate}">Delete</a></td>
					<td><a href="${updateLink}">Update</a></td>
				</tr>
				<!-- Modal -->
				<div class="modal fade" id="deleteModal${car.licensePlate}"
					tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Delele car</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">Do you want to delete?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<a class="btn btn-primary" href="${deleteLink}">Delete</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="include/footer.jsp"%>
<script src="${pageContext.request.contextPath}/public\js\jquery-3.4.1.js"></script>
	<script src="${pageContext.request.contextPath}/public\js\bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/public\js\scripts.js"></script>
    <script src="${pageContext.request.contextPath}/public\js/validate/jquery.validate.min.js"></script>
  	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>

</body>
</html>