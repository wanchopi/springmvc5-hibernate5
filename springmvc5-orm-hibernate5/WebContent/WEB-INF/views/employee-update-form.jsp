<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>employee update form</title>
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
		<div class="col-lg-10" style="margin-bottom: 100px">
			<h1>Employee Manager</h1>
		</div>
		<div class="col-lg-6" style="margin-top: 50px;">
			<div class="card" align="left">
				<h5 class="card-title p-3 mb-2 text-light bg-dark">Update employee</h5>
				<div class="card-body">
					<form:form action="save" method="post" modelAttribute="employee" cssClass="form-horizontal">
						<!-- ID -->
		   				<div class="form-group">
		   					<label for="id" class="sr-only">ID</label>
		   					<div class="col-md-9">
		     					<form:input path="id" type="text" cssClass="form-control" readonly="true"/>
		   					</div>
		  				</div>
						<!-- first name -->
		   				<div class="form-group">
		   					<label for="firstName" class="col-md-3 control-label font-weight-bold">First Name</label>
		   					<div class="col-md-9">
		     					<form:input path="firstName" type="text" cssClass="form-control" />
		     					<form:errors path="firstName" cssClass="errors" />
		   					</div>
		  				</div>
		  				<!-- last name -->
		   				<div class="form-group">
		   					<label for="lastName" class="col-md-3 control-label font-weight-bold">Last Name</label>
		   					<div class="col-md-9">
		     					<form:input path="lastName" type="text" cssClass="form-control" />
		     					<form:errors path="lastName" cssClass="errors" />
		   					</div>
		  				</div>
		  				<!-- email -->
		  				<div class="form-group">
		   					<label for="email" class="col-md-3 control-label font-weight-bold">Email</label>
		   					<div class="col-md-9">
		     					<form:input path="email" type="email" cssClass="form-control" />
		     					<form:errors path="email" cssClass="errors" />
		   					</div>
		  				</div>
		  				<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button type="Submit" class="btn btn-primary">Save</form:button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery core JavaScript -->
    <script src="public/js/jquery.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script src="public/js/bootstrap.min.js"></script>
</body>
</html>