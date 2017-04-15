<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="style1.css">
	</head>
	<body>
		<div id="upper">
			<form action="Home.jsp" method="post">
				<button class="fill" id="right">Sign in</button>
				<input type="password" id="right" name="pass" placeholder="Password">
				<input type="text" id="right" name="username" placeholder="Username">
			</form>
		</div>
		<div id="inter">
		<div class="register-form" id="right">
				<form action="SignUpCheck.jsp" method="post">
					<div id="comp">
						<label id="left"> Username </label>
						<input type="text" name="newuser" id="right" class="outborder">
					</div>
					<div id="comp">
						<label id="left"> Password </label>
						<input type="text" name="newpass" id="right" class="outborder">
					</div>
					<div id="comp">
						<label id="left"> Re-Enter Password </label>
						<input type="text" name="repass" id="right" class="outborder">
					</div>
					<div id="comp">
						<label id="left"> Mail </label>
						<input type="text" name="mail" id="right" class="outborder">
					</div>
					<button class="bord" id="right">Sign Up</button>
				</form>
			</div>
		
		</div>
	</body>
</html>
