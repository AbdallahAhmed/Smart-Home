<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/style_sign.css">
		<link rel="stylesheet" href="css/animate.css">
		<script type="text/javascript" src="js/scripts.js"></script>
	</head>
	<body>
		<div id="upper" style="background-color: #e6e6e6;">
			<div class="port" id="left">
				<img src="http://i.imgur.com/BuSJYNJ.png">
			</div>
			<form onsubmit="return validateSignin(e);" class="signinf" action="Home.jsp" method="post">
				<button type="submit" class="signin" id="right">Sign in</button>
				<input class="inputin" type="password" id="right" name="password" placeholder="Password" required>
				<input class="inputin" type="text" id="right" name="username" placeholder="Username" required>
			</form>
		</div>
		<div class="inter">
			<form onsubmit="return validate()" name="signup">
				<div class="inputcomp">
					<label id="left">Full Name</label>
					<input class="inputout" id="right"  type="text" name="fullname" required>

				</div>
				<div class="inputcomp">
					<span  class="error"><p id="username_error"></p></span>
					<label id="left">Username</label>
					<input class="inputout" id="right"  type="text" name="newuser">
				</div>
				<div class="inputcomp">
					<label id="left">Password</label>
					<input class="inputout" id="right"  type="password" name="newpass" minlength="8">
				</div>
				<div class="inputcomp">
					<label id="left">Verfiy Password</label>
					<input class="inputout" id="right" type="password" name="renewpass" minlength="8">
				</div>
				<button class="signup" type="submit">Sign Up</button>
			</form>

		</div>
	</body>
</html>

