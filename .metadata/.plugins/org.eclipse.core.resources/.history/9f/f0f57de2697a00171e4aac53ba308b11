<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style type="text/css">
/* body { 
  background: url(http://lorempixel.com/1920/1920/city/9/) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
} */
body {
	background:
		url(https://cloudfront.ualberta.ca/-/media/medicine/departments/medicine/divisions/cardiology/cardimage.jpg?w=1200)
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

.panel-default {
	opacity: 0.9;
	margin-top: 30px;
}

.form-group.last {
	margin-bottom: 0px;
}

.panel-default {
	opacity: 0.9;
	margin-top: 30px;
}

.form-group.last {
	margin-bottom: 0px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-7">
				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-lock"></span> Login
					</div>
					<div class="panel-body">
						<form action="saveUser/loginsuccess" method="POST" class="form-horizontal"
							role="form">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">
									Username</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="inputEmail3"
										placeholder="Username" name="username" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">
									Password</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="Password" name="password" required>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<div class="checkbox">
										<label> <input type="checkbox" name="remember" />
											Remember me
										</label>
									</div>
								</div>
							</div>
							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-success btn-sm">
										Sign in</button>
									<button type="reset" class="btn btn-default btn-sm">
										Reset</button>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-footer">
						Not Registred? <input type="button" value = "Register here" onclick="window.location.href='saveUser/register';return false;"></input>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>