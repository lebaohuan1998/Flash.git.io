<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form add trip</title>
    <%@ include file="include/header.jsp" %>
    <%@ include file="include/sidebar.jsp" %>
    <form action="${pageContext.request.contextPath}/TripServlet?command=ADD" method="post" id="tripForm">
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Destination</label>
            <div class="col-md-9">
                <input type="text" placeholder="Enter your Destination" class="form-control" name="destination">
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Departure time</label>
            <div class="col-md-9">
                <input type="time" placeholder="Enter departure time" class="form-control" name="departureTime">
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Driver</label>
            <div class="col-md-9">
                <input type="text" placeholder="Enter driver name" class="form-control" name ="driver">
            </div>
        </div>
        
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Car type</label>
            <div class="col-md-9">
                <input type="text" placeholder="Enter your car type" class="form-control" name="carType">
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Max slot</label>
            <div class="col-md-9">
                <input type="number" class="form-control" name="maximumOnlineTicketNumber">
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Departure date</label>
            <div class="col-md-9">
                <input type="date" placeholder="Enter your Departure date" class="form-control" name="departureDate">
            </div>
        </div>
        <div class="form-row">
            <label for="" class="col-md-3 col-form-label"></label>
            <div class="col-md-9">
                <button class="btn btn-primary" type="submit">OK</button>
            </div>
        </div>   
    </form>
 <%@ include file="include/footer.jsp" %>
    <script src="${pageContext.request.contextPath}/public/js/validate/TripValidate.js"></script>
</body>
</html>