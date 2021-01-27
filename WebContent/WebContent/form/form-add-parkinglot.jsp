<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form add parkinglot</title>
    <%@ include file="include/header.jsp" %>
    <%@ include file="include/sidebar.jsp" %>
        <c:if test="${not empty param.message}">
	   	<span class="row alert alert-danger">
			${param.message}
        </span>
		</c:if>
		<c:if test="${PARKING_LOT == null}">
			<form action="${pageContext.request.contextPath}/ParkingLotServlet?command=ADD" method="post" id="parkingLotForm">
	    </c:if>
	    <c:if test="${PARKING_LOT != null}">
			<form action="${pageContext.request.contextPath}/ParkingLotServlet?command=UPDATE" method="post" id="parkingLotForm">
			<input type="hidden" name="parkingID" value="${PARKING_LOT.parkId }"/>
	    </c:if> 
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Parking name</label>
            <div class="col-md-9">
                <input type="text" placeholder="Enter your Parking name" class="form-control" name="parkingName" value="${PARKING_LOT.parkName }">
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Place</label>
            <div class="col-md-9">
                <select id="" class="form-control" name="place">
                    <option value ="">Choose...</option>
                    <option value="My dinh">My dinh</option>
                    <option value="Dong da">Dong da</option>
                    <option value="Cau Giay">Cau Giay</option>
                    <option value="Thanh Xua">Thanh Xuan</option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Area(mÂ²)</label>
            <div class="col-md-9">
                <input type="number" class="form-control" name="area" value="${PARKING_LOT.parkArea }">
            </div>
        </div>
        <div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Price</label>
            <div class="col-md-9">
                <input type="number" placeholder="Enter price (VND)" class="form-control" name="price" value="${PARKING_LOT.parkPrice }">
            </div>
        </div>
         <c:if test="${PARKING_LOT != null}">
			<div class="form-group row">
            <label for="" class="col-md-3 col-form-label">Status</label>
            <div class="col-md-9">
                <input type="text" placeholder="Enter status" class="form-control" name="parkStatus" value="${PARKING_LOT.parkStatus }">
            </div>
        </div>			
	    </c:if>     
        <div class="form-row">
            <label for="" class="col-md-3 col-form-label"></label>
            <div class="col-md-9">
                <button class="btn btn-primary" type="submit">OK</button>
            </div>
        </div>         
    </form>
 <%@ include file="include/footer.jsp" %>
    <script src="${pageContext.request.contextPath}/public/js/validate/ParkinglotValidate.js"></script>

</body>
</html>