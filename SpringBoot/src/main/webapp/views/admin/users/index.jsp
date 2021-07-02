<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css" ></link>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light px-5">
	  <a class="navbar-brand" href="#">Navbar</a>
	
	  <div class="collapse navbar-collapse">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Users</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Categories</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Products</a>
	      </li>
	    </ul>
	  </div>
	</nav>

	<div class="mt-5 col-10 offset-1">
		<div class="">
			<a
				class="btn btn-success col-1"
				href="${ pageContext.request.contextPath }/admin/users/create">Create</a>
		</div>
		<table class="table table-strip table-dark">
				<thead>
					<tr>
						<td>Id</td>
						<td>Họ tên</td>
						<td>Username</td>
						<td>Email</td>
						<td>Tai khoan</td>
						<td colspan="2">Thao tác</td>
					</tr>
				</thead>
				
				<tbody>
				<c:for items=${ listUser } var"user">
					<tr>
						<td>${user.id }</td>
						<td>${user.username }</td>
						<td>${user.email }</td>
						<td>${user.admin == 1? "Admin" : "User" }</td>
						<td>${user.id }</td>
						<td>
							<a
								class="btn btn-primary"
								href="${ pageContext.request.contextPath }/admin/users/edit/1">Update</a>
						</td>
						<td>
							<form action="${ pageContext.request.contextPath }/admin/users/delete/1" method="POST">
								<button class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
					</c:for>
				</tbody>
			</table>
	</div>
	<script src="${ pageContext.request.contextPath }/js/hello.js"></script>
</body>
</html>