<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form add office</title>
<%@ include file="include/header.jsp"%>
<%@ include file="include/sidebar.jsp"%>
<form action="${pageContext.request.contextPath}/BookingOfficeServlet?command=ADD" method="post" id="bookingOfficeForm">
	<div class="form-group row">
		<label for="" class="col-md-3 col-form-label">Add booking
			office name</label>
		<div class="col-md-9">
			<input type="text" placeholder="Enter booking office name"
				class="form-control" name="bookingofficename">
		</div>
	</div>
	<div class="form-group row">
		<label for="" class="col-md-3 col-form-label">Trip</label>
		<div class="col-md-9">
			<select id="" class="form-control" name="trip">
				<option value="">Choose...</option>
				<c:forEach var="trip" items="${LIST_TRIP}">
					<option value="${trip.tripId}">${trip.destination}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group row">
		<label for="" class="col-md-3 col-form-label">Phone number</label>
		<div class="col-md-9">
			<input type="text" placeholder="Enter your phone number"
				class="form-control" name="phonenumber">
		</div>
	</div>

	<div class="form-group row">
		<label for="" class="col-md-3 col-form-label">Place</label>
		<div class="col-md-9">
			<select id="" class="form-control" name="place">
				<option value="">Choose...</option>
				<option value="Quay1">Quay so 1</option>
				<option value="Quay2">Quay so 2</option>
				<option value="Quay3">Quay so 3</option>
				<option value="Quay4">Quay so 4</option>
				<option value="Quay5">Quay so 5</option>
				

			</select>
		</div>
	</div>
	<div class="form-group row">
		<label for="" class="col-md-3 col-form-label">Price</label>
		<div class="col-md-9">
			<input type="text" placeholder="Enter price" class="form-control"
				name="price">
		</div>
	</div>
	<div class="form-group row">
		<label for="" class="col-md-3 col-form-label">Contract
			deadline</label>
		<div class="col-md-9">
			<div>
				<div class="input-group mb-2">
					<div class="input-group-prepend">
						<div class="input-group-text">From date</div>
					</div>
					<input type="date" class="form-control pick-date"
						name="contractdeadlineFrom" id="StartDate">
				</div>
				<div class="input-group mb-2">
					<div class="input-group-prepend">
						<div class="input-group-text">To date</div>
					</div>
					<input type="date" class="form-control pick-date"
						name="contractdeadlineTo">
				</div>
			</div>
		</div>
	</div>
	<div class="form-row">
		<label for="" class="col-md-3 col-form-label"></label>
		<div class="col-md-9">
			<button class="btn btn-primary" type="submit">OK</button>
		</div>
	</div>
</form>
<%@ include file="include/footer.jsp"%>

<script
	src="${pageContext.request.contextPath}/public/js/validate/BookingOffice.js"></script>
</body>

</html>