<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Parking lot</title>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>

<c:if test="${not empty param.message}">
	<span class="row alert alert-danger"> ${param.message} </span>
</c:if>
<c:if test="${not empty param.success}">
	<span class="row alert alert-success"> ${param.success} </span>
</c:if>

<div class="table-responsive">
<form action="${pageContext.request.contextPath}/ParkingLotServlet?command=SEARCH" method="post"
	class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0 float-right">
	<div class="input-group mb-5">
		<input class="form-control" type="text" placeholder="Parking name"
			aria-label="Search" aria-describedby="basic-addon2" name="nameSearch" />
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
				<th>ID</th>
				<th>Parking lot</th>
				<th>Place</th>
				<th>Area</th>
				<th>Price</th>
				<th>Status</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>ID</th>
				<th>Parking lot</th>
				<th>Place</th>
				<th>Area</th>
				<th>Price</th>
				<th>Status</th>
				<th colspan="2">Action</th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach var="parkingLot" items="${LIST_PARKING_LOT}">

				<c:url var="deleteLink" value="ParkingLotServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="parkingLotID" value="${parkingLot.parkId}" />
				</c:url>
				<c:url var="updateLink" value="ParkingLotServlet">
					<c:param name="command" value="LOAD_UPDATE" />
					<c:param name="parkingLotID" value="${parkingLot.parkId}" />
				</c:url>
				<tr>
					<td>${parkingLot.parkId}</td>
					<td>${parkingLot.parkName}</td>
					<td>${parkingLot.parkArea}</td>
					<td>${parkingLot.parkPlace}</td>
					<td>${parkingLot.parkPrice}</td>
					<td>${parkingLot.parkStatus}</td>
					<td><a data-toggle="modal" data-target="#deleteModal${parkingLot.parkId}">Delete</a></td>
					<td><a href="${updateLink}">Update</a></td>
				</tr>
					<!-- Modal -->
				<div class="modal fade" id="deleteModal${parkingLot.parkId}"
					tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Delele parking lot</h5>
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
</body>
</html>