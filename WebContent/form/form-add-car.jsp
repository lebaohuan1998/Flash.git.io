<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form add car</title>
    <%@ include file="include/header.jsp" %>
<!-- -------------------------------- -->

    <%@ include file="include/sidebar.jsp" %>
	
    <!-- form content -->
    	
    
	    <c:if test="${not empty param.message}">
	   	<span class="row alert alert-danger">
			${param.message}
        </span>
		</c:if>
	<c:if test="${CAR == null}">
		<form action="${pageContext.request.contextPath}/CarServlet?command=ADD" method="post" id="carForm">
    </c:if>
    <c:if test="${CAR != null}">
		<form action="${pageContext.request.contextPath}/CarServlet?command=UPDATE" method="post" id="carForm">
    </c:if>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Car license plate</label>
            <div class="col-md-9">
            <c:if test="${CAR != null}">
                <input readonly type="text" placeholder="Enter Car license plate" class="form-control" name="licensePlate" value="${CAR.licensePlate}">
            </c:if>
            <c:if test="${CAR == null}">
            <input type="text" placeholder="Enter Car license plate" class="form-control" name="licensePlate" value="${CAR.licensePlate}">
            </c:if>
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Car type</label>
            <div class="col-md-9">
                <input type="text" placeholder="Enter Car type" class="form-control" name="carType" value="${CAR.carType}">
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Car color</label>
            <div class="col-md-9">
                <input type="text" class="form-control" placeholder="Enter car color" name="carColor" value="${CAR.carColor}">
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Company</label>
            <div class="col-md-9">
                <select id="" class="form-control" name="company">
                    <option value="" selected>Choose...</option>
                    <option value="Company 1">Company 1</option>
                    <option value="Company 2">Company 2</option>
                    <option value="Company 3">Company 3</option>
                    <option value="Company 4">Company 4</option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Parking lot</label>
            <div class="col-md-9">
                <select id="" class="form-control" name="parkingLot">
                    <option value="" selected>Choose...</option>
                     <c:forEach var="parkLot" items="${LIST_PARKING_LOT}">
                     	<option value="${parkLot.parkId}">${parkLot.parkName}</option>
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

    <%@ include file="include/footer.jsp" %>
    
    <script src="${pageContext.request.contextPath}/public/js/validate/CarValidate.js"></script>

</body>

</html>