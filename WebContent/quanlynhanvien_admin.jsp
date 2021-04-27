<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid container"
	style="margin-top: 10px; padding-left: 8rem; padding-right: -30rem;">
	<div class="card mb-4" style="margin-right: -120px;">
		<h2 style="text-align: center;">Quản lý thành viên</h2>
		<div class="form-inline">
			<ul class="nav nav-tabs"
				style="margin-top: 20px; border-bottom: 1px solid #dee2e6;; color: black;">
				<li class="nav-item"><a
					class=" nav-link <c:if test="${show =='3'||show ==null}">active</c:if>"
					data-toggle="tab" href="#nguoidung" style="margin-right: 10px;"><b>Người
							dùng (${numberuser})</b></a></li>
				<li class="nav-item"><a
					class=" nav-link <c:if test="${show =='1'}">active</c:if>"
					data-toggle="tab" href="#nhiepanhgia" style="margin-right: 10px;"><b>Nhiếp
							ảnh gia (${numberphoto})</b></a></li>

				<li class="nav-item"><a
					class=" nav-link <c:if test="${show =='2'}">active </c:if>"
					data-toggle="tab" href="#quanly" style="margin-right: 10px;"><b>Quản
							lý (${numberadmin})</b></a></li>
			</ul>
			<div class="form-inline"
				style="margin-left: 170px; margin-top: 23px;">
				<input class="btn nav-item" type="text"
					style="height: 46px; width: 200px; border: 1px solid rgba(0, 0, 0, 0.15);"
					placeholder="tìm kiếm theo tên,email" />
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit"
						style="height: 46px; width: 50px;">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
			<c:if test="${role ==1}">
				<div class="form-inline"
					style="margin-bottom: 20px; margin-top: 20px; margin-left: 10px;">
					<select name="managermentrole" id="managermentrole" class="btn btn-outline-dark">
						<option value="2">Quản lý</option>
						<option value="3">Người dùng</option>
					</select>
					<button id="changerole" class="btn btn-info"
						style="margin-left: 10px;">Thay đổi</button>
				</div>
			</c:if>
		</div>

		<div class="tab-content"
			style="margin-left: 0.5rem; margin-right: 0.5rem;">

			<div id="quanly"
				class="tab-pane <c:if test="${show =='2'}">active </c:if>">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead style="background-color: #3385ff;">
						<tr>
							<th style="color: white;">Chọn</th>
							<th style="color: white;">ID</th>
							<th style="color: white;">Tên người dùng</th>
							<th style="color: white;">Email</th>
							<th style="color: white;">Vai trò</th>
							<th style="color: white;">Ngày đăng ký tài khoản</th>
							<th style="color: white;">Trạng thái tài khoản</th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<c:forEach items="${listAdmin}" var="list">
						<c:url var="lockLink" value="ManagermentAdminSystem">
							<c:param name="cmd" value="LOCKADMIN" />
							<c:param name="idadmin" value="${list.id}" />
							<c:param name="statusId" value="3" />
							<c:url var="unlockLink" value="ManagermentAdminSystem">
								<c:param name="cmd" value="LOCKADMIN" />
								<c:param name="idadmin" value="${list.id}" />
								<c:param name="statusId" value="1" />
							</c:url>
						</c:url>
						<thead style="font-weight: normal;">
							<tr>
								<th style="text-align: center;"><c:if test="${role !='2'}">
										<input type="checkbox" name="vechicle" value="${list.id}" />
									</c:if></th>
								<th>${list.id}</th>
								<th>${list.fullName}</th>
								<th>${list.email}</th>
								<th>Quản lý</th>
								<th>${list.createdDate}</th>
								<th>${list.statusName}</th>
								<th colspan="2"><c:if test="${role !='2'}">
										<c:if test="${list.status =='1'}">
											<a class="btn btn-info" type="submit" href="${lockLink}">
												khóa</a>
										</c:if>
										<c:if test="${list.status =='3'}">
											<a class="btn btn-info" type="submit" href="${unlockLink}">mở
												khóa</a>
										</c:if>
									</c:if></th>

							</tr>
						</thead>
					</c:forEach>
				</table>

				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<c:forEach items="${listPageAdmin}" var="list">
							<li class="page-item"><a
								class="page-link <c:if test="${param.pageadmin ==list+1}">text-white bg-dark</c:if> <c:if test="${param.pageadmin ==null&&list==0}">text-white bg-dark</c:if>"
								href="${pageContext.request.contextPath}/ManagermentAdminSystem?cmd=Employee&pageadmin=${list+1}">${list+1}</a></li>
						</c:forEach>

					</ul>
				</nav>

			</div>
			<div id="nhiepanhgia"
				class="tab-pane <c:if test="${show =='1'}">active</c:if>">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead style="background-color: #007bff;">
						<tr>
							<th style="color: white;">Chọn</th>
							<th style="color: white;">ID</th>
							<th style="color: white;">Tên người dùng</th>
							<th style="color: white;">Email</th>
							<th style="color: white;">Vai trò</th>
							<th style="color: white;">Ngày đăng ký tài khoản</th>
							<th style="color: white;">Trạng thái tài khoản</th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<c:forEach items="${listPhoto}" var="list">
						<c:url var="lockLink" value="ManagermentAdminSystem">
							<c:param name="cmd" value="LOCKPHOTO" />
							<c:param name="idphoto" value="${list.id}" />
							<c:param name="statusId" value="3" />
							<c:url var="unlockLink" value="ManagermentAdminSystem">
								<c:param name="cmd" value="LOCKPHOTO" />
								<c:param name="idphoto" value="${list.id}" />
								<c:param name="statusId" value="1" />
							</c:url>
						</c:url>
						<thead style="font-weight: normal;">
							<tr>
								<th><c:if test="${list.roleId !='4'}">
										<input type="checkbox" name="vechicle" value="${list.id}" />
									</c:if></th>
								<th>${list.id}</th>
								<th>${list.fullName}</th>
								<th>${list.email}</th>
								<th>Thợ ảnh</th>
								<th>${list.createdDate}</th>
								<th>${list.statusAccountName}</th>
								<th colspan="2"><c:if test="${list.statusAccountId =='1'}">
										<a class="btn btn-info" type="submit" href="${lockLink}">
											khóa</a>
									</c:if> <c:if test="${list.statusAccountId =='3'}">
										<a class="btn btn-info" type="submit" href="${unlockLink}">mở
											khóa</a>
									</c:if></th>
							</tr>
						</thead>
					</c:forEach>
				</table>

				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<c:forEach items="${listPagePhoto}" var="list">
							<li class="page-item"><a
								class="page-link <c:if test="${param.pagephoto ==list+1}">text-white bg-dark</c:if> <c:if test="${param.pagephoto ==null&&list==0}">text-white bg-dark</c:if>"
								href="${pageContext.request.contextPath}/<c:if test="${opera!='yes'}">ManagermentAdminSystem</c:if><c:if test="${opera=='yes'}">ManagermentAdminOperator</c:if>?cmd=Employee&pagephoto=${list+1}">${list+1}</a></li>
						</c:forEach>
					</ul>
				</nav>

			</div>
			<div id="nguoidung"
				class="tab-pane <c:if test="${show =='3'||show ==null}">active</c:if>">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead style="background-color: #007bff;">
						<tr>
							<th style="color: white;">Chọn</th>
							<th style="color: white;">ID</th>
							<th style="color: white;">Tên người dùng</th>
							<th style="color: white;">Email</th>
							<th style="color: white;">Vai trò</th>
							<th style="color: white;">Ngày đăng ký tài khoản</th>
							<th style="color: white;">Trạng thái tài khoản</th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<c:forEach items="${listUser}" var="list">
						<c:url var="lockLink" value="ManagermentAdminSystem">
							<c:param name="cmd" value="LOCKUSER" />
							<c:param name="iduser" value="${list.id}" />
							<c:param name="statusId" value="3" />
						</c:url>
						<c:url var="unlockLink" value="ManagermentAdminSystem">
							<c:param name="cmd" value="LOCKUSER" />
							<c:param name="iduser" value="${list.id}" />
							<c:param name="statusId" value="1" />
						</c:url>
						<thead style="font-weight: normal;">
							<tr>
								<th><c:if test="${list.status =='1'&& role !='2'}">
										<input type="checkbox" name="vechicle" value="${list.id}" />
									</c:if></th>
								<th>${list.id}</th>
								<th>${list.fullName}</th>
								<th>${list.email}</th>
								<th>Người dùng</th>
								<th>${list.createdDate}</th>
								<th>${list.statusName}</th>
								<th colspan="2"><c:if test="${list.status =='1'}">
										<a class="btn btn-info" type="submit" href="${lockLink}">
											khóa</a>
									</c:if> <c:if test="${list.status =='3'}">
										<a class="btn btn-info" type="submit" href="${unlockLink}">mở
											khóa</a>
									</c:if></th>
							</tr>
						</thead>
					</c:forEach>
				</table>

				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<c:forEach items="${listPageUser}" var="list">
							<li class="page-item"><a
								class="page-link <c:if test="${param.pageuser ==list+1}">text-white bg-dark</c:if><c:if test="${param.pageuser ==null&&list==0}">text-white bg-dark</c:if>"
								href="${pageContext.request.contextPath}/ManagermentAdminSystem?cmd=Employee&pageuser=${list+1}">${list+1}</a></li>
						</c:forEach>

					</ul>
				</nav>

			</div>
		</div>
	</div>
</div>
