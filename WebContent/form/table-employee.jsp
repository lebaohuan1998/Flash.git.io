<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee</title>
<%@ include file="include/header.jsp"%>

<%@ include file="include/sidebar.jsp"%>



<div class="table-responsive">
<form action="${pageContext.request.contextPath}/EmployeeServlet?command=SEARCH" method="post"
	class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0 float-right">
	<div class="input-group mb-5">
		<input class="form-control" type="text" placeholder="Employee name"
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
				<th>Name</th>
				<th>Account</th>
				<th>Department</th>
				<th>Address</th>
				<th>Birth date</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Gender</th>
				<th>Action</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Name</th>
				<th>Account</th>
				<th>Department</th>
				<th>Address</th>
				<th>Birth date</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Gender</th>
				<th>Action</th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach var="emp" items="${LIST_EMP}">
				<!-- set up a link to delete a emp -->
				<c:url var="deleteLink" value="EmployeeServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="empID" value="${emp.employeeId}" />
				</c:url>
				<tr>
					<td>${emp.employeeName}</td>
					<td>${emp.account}</td>
					<td>${emp.department}</td>
					<td>${emp.employeeAddress}</td>
					<td>${emp.employeeBirthDate}</td>
					<td>${emp.employeeEmail}</td>
					<td>${emp.employeePhone}</td>
					<c:if test="${emp.sex == 1}">
						<td>Male</td>
					</c:if>
					<c:if test="${emp.sex == 0}">
						<td>Female</td>
					</c:if>
					<c:if test="${emp.sex == 2}">
						<td>Other</td>
					</c:if>
					<td><a data-toggle="modal" data-target="#deleteModal${emp.employeeId}">Delete</a></td>
				</tr>
					<!-- Modal -->
				<div class="modal fade" id="deleteModal${emp.employeeId}"
					tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Delele employee</h5>
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