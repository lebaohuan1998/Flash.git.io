<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trip</title>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>


<div class="table-responsive">
<form action="${pageContext.request.contextPath}/TripServlet?command=SEARCH" method="post"
	class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0 float-right">
	<div class="input-group mb-5">
		<input class="form-control" type="text" placeholder="Driver"
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
				<th>No</th>
				<th>Trip</th>
				<th>Car type</th>
				<th>Departure date</th>
				<th>Departure time</th>
				<th>Destination</th>
				<th>Driver</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>No</th>
				<th>Trip</th>
				<th>Car type</th>
				<th>Departure date</th>
				<th>Departure time</th>
				<th>Maximum ticket</th>
				<th>Driver</th>
				<th colspan="2">Action</th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach var="trip" items="${LIST_TRIP}">
				<c:url var="deleteLink" value="TripServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="tripID" value="${trip.tripId}" />
				</c:url>
				<tr>
					<td>${trip.tripId}</td>
					<td>${trip.destination}</td>
					<td>${trip.carType}</td>
					<td>${trip.departureDate}</td>
					<td>${trip.departureTime}</td>
					<td>${trip.maximumOnlineTicketNumber}</td>
					<td>${trip.driver}</td>
					<td><a data-toggle="modal" data-target="#deleteModal${trip.tripId}">Delete</a></td>
				</tr>
					<!-- Modal -->
				<div class="modal fade" id="deleteModal${trip.tripId}"
					tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Delele trip</h5>
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