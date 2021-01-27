<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form add ticket</title>
<%@ include file="include/header.jsp"%>
<!-- -------------------------------- -->

<%@ include file="include/sidebar.jsp"%>

<!-- form content -->


<c:if test="${not empty param.message}">
	<span class="row alert alert-danger"> ${param.message} </span>
</c:if>

	<form action="${pageContext.request.contextPath}/TicketServlet?command=ADD"
		method="post" id="ticketForm">


<div class="form-group row">
	<label for="" class="col-md-3 col-form-label">Enter your name</label>
	<div class="col-md-9">
		<input type="text" placeholder="Enter your name"
			class="form-control" name="customerName">
		
	</div>
</div>
<div class="form-group row">
	<label for="" class="col-md-3 col-form-label">Choose car</label>
	<div class="col-md-9">
		<select id="" class="form-control" name="licensePlate">
			<option value="" selected>Choose...</option>
			<c:forEach var="car" items="${LIST_CAR}">
				<option value="${car.licensePlate}">${car.licensePlate}</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-group row">
	<label for="" class="col-md-3 col-form-label">Trip</label>
	<div class="col-md-9">
		<select id="" class="form-control" name="trip">
			<option value="" selected>Choose...</option>
			<c:forEach var="trip" items="${LIST_TRIP}">
				<option value="${trip.tripId}">${trip.destination}</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-row">
	<label for="" class="col-md-3 col-form-label"></label>
	<div class="col-md-9">
		<button class="btn btn-primary" type="submit">OK</button>
	</div>
</div>
</form>
<!-- end form content -->

<%@ include file="include/footer.jsp"%>

<script
	src="${pageContext.request.contextPath}/public/js/validate/TicketValidate.js"></script>
</body>

</html>