<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>index</title>
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="public/css/mystyle.css">
</head>
<body>
	<div class="container-fluid" align="center">
		<!-- nav -->
		<nav class="navbar navbar-light bg-light">
			<a href="<c:url value="/"/>"><img alt="logo" src="public/images/spring_50x50.png"></a>
			<a href="form" class="btn btn-outline-success my-2 my-sm-0">Save new employee</a>
		</nav>
		<!-- header -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12" align="center">
					<img alt="logo" src="public/images/logo.png">
				</div>
			</div>
		</div>
		<div class="main">
			<div class="col-lg-9" style="margin-top: 50px;">
				<h2 class="bg-primary text-white">List of employees</h2>
				<table class="table">
					<thead class="thead-dark">
						<tr align="center">
							<th scope="col">ID</th>
							<th scope="col">NAME</th>
							<th scope="col">E-MAIL</th>
							<th scope="col">EDIT</th>
							<th scope="col">DELETE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="employee">
							<tr align="center">
								<td>${employee.id}</td>
								<td>${employee.firstName} ${employee.lastName}</td>
								<td>${employee.email}</td>
								<td><a href="update?id=${employee.id}"><i class="fa fa-edit"></i></a></td>
								<td><a href="delete?id=${employee.id}"><i class="fa fa-times"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- jQuery core JavaScript -->
    <script src="public/js/jquery.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script src="public/js/bootstrap.min.js"></script>
</body>
</html>