<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ticket</title>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>


<div class="table-responsive">
	<form
		action="${pageContext.request.contextPath}/TicketServlet?command=SEARCH"
		method="post"
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0 float-right">
		<div class="input-group mb-5">
			<input class="form-control" type="text" placeholder="Customer name"
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
				<th>ID</th>
				<th>Trip</th>
				<th>License Plate</th>
				<th>Customer</th>
				<th>Booking time</th>
				<th>Departure time</th>
				<th>Action</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>ID</th>
				<th>Trip</th>
				<th>License Plate</th>
				<th>Customer</th>
				<th>Booking time</th>
				<th>Departure time</th>
				<th>Action</th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach var="ticket" items="${LIST_TICKET}">
				<c:url var="deleteLink" value="TicketServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="ticketId" value="${ticket.tickedId}" />
				</c:url>
				<tr>
					<td>${ticket.tickedId}</td>
					<td><c:forEach var="trip" items="${LIST_TRIP}">
							<c:if test="${ticket.tripId == trip.tripId}">
							${trip.destination}
						</c:if>
						</c:forEach></td>
					<td>${ticket.licensePlate}</td>
					<td>${ticket.customerName}</td>
					<td>${ticket.bookingTime}</td>
					<td><c:forEach var="trip" items="${LIST_TRIP}">
							<c:if test="${ticket.tripId == trip.tripId}">
							${trip.departureTime}
						</c:if>
						</c:forEach></td>
					<td><a data-toggle="modal"
						data-target="#deleteModal${ticket.tickedId}">Delete</a></td>
				</tr>
				<!-- Modal -->
				<div class="modal fade" id="deleteModal${ticket.tickedId}"
					tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Delete
									ticket</h5>
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