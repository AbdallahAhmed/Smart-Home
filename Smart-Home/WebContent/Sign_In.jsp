<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
	<head>
		<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/style_sign.css">
		<link rel="stylesheet" type="text/css" href="css/load.css">
		<link rel="stylesheet" type="text/css" href="css/animate_load.css">
		<link rel="stylesheet" href="css/animate.css">
		<script type="text/javascript" src="js/scripts.js"></script>
		<script type="text/javascript" src="js/scripts0.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		<link rel="stylesheet" href="v.0.3/css/animate.css">
		<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
		<style type="text/css">
			.spass{
	position: relative;
  margin: 100px 2px;
  color: #165258;
  font-size: 15px;
  cursor: pointer;    
}
		</style>
	</head>
	<body>
<div id="sAll">
		<div id="upper" style="background-color: #e6e6e6;">
			<div class="port" id="left">
				<img src="http://i.imgur.com/BuSJYNJ.png">
			</div>
			<form id="ho" onsubmit="loading()" class="signinf" action="SignInCheck.jsp" method="post">
				<button type="submit" onsubmit="loading()" class="signin" id="right">Sign in</button>
				<label onmouseover="showPass()" onmouseout="hidePass()" style="position: relative; float:right; font-size: 20px; margin-top: 70px; cursor: pointer;">Show Password</label>
				<input class="inputin" type="text" id="" name="username" placeholder="Username" required>
				<input class="inputin" type="password" id="pass" name="password" placeholder="Password" required>
			</form>
		</div>
		<div class="inter">
			<form onsubmit="return validate()" name="signup" action="SignUpCheck.jsp" method="post">
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
	</div>
	<div id="all" style="visibility: hidden; z-index: 99;">
		<div id="mainbox">
			<div id="line2"></div>
			<div id="largebox">
				<label>SHCS</label>
			</div>
			<div id="line1"></div>
			<div id="triangle"></div>
			<div id="triangle2"></div>
			<label id="l">Loading</label>
		</div>
	</div>
	
	</body>
</html>

