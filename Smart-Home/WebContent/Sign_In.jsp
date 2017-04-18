<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/style_sign.css">
		<link rel="stylesheet" href="css/animate.css">
		<script type="text/javascript" src="js/scripts.js"></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<link rel="stylesheet" href="v.0.3/css/animate.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
	</head>
		<style type="text/css">
		body {
			background-color: #e6e6e6;
			margin: 0;
			padding: 0;
		}
		#sAll{
		visibility: visible;
		}
		#all{
		visibility: hidden;
		}
		#mainbox {
			position: fixed;
			left: 0;
			top: 0;
			margin: auto;
			margin-top: 40px;
			width: 100%;
			height: 100%;
			background-color: none;
		}
		#largebox {
			position: relative;
			margin: auto;
			padding: auto;
			width: 400px;
			height: 400px;
			background-color: #165258;
		}
	
		#largebox label {
			font-family: 'Righteous', cursive;
			position: absolute;
			opacity: 0;
			color: white;
			bottom: 0;
			left: 0;
			margin: 10px;
			font-size: 100px;
			animation: loading 5s infinite;
		}
		#mainbox #line1 {
			//bottom: 0;
			z-index: 1;
			position: absolute;
			width: 180px;
			height: 5px;
			margin: 4px;
			background-color: #70f3ff;
			animation: moveH 6s infinite;
		}
		#mainbox #line2 {
			right: 34.5%;
			z-index: 1;
			position: absolute;
			width: 5px;
			height: 180px;
			background-color: #00ddf2;
			animation: moveV 6s infinite;
		}
		#mainbox #triangle {
			z-index: 2;
			position: absolute;
    		width: 0;
    		height: 0;
    		left: 62%;
    		top: 60%;
    		border-bottom: 65px solid #292f36;
    		border-left: 35px solid transparent;
    		border-right: 35px solid transparent;
    		animation: pulse 1s infinite;
    		//animation: moveUp 6s infinite;
		}
		#mainbox #triangle2 {
			z-index: 2;
			position: absolute;
    		width: 0;
    		height: 0;
    		left: 35%;
    		top: 10%;
    		border-bottom: 65px solid #70f3ff;
    		border-left: 10px solid transparent;
    		border-right: 30px solid transparent;
    		animation: spin 6s infinite;
    		//animation: moveUp 6s infinite;
		}
		#l {
			font-family: 'Righteous', cursive;
			position: absolute;
			opacity: 1;
			z-index: 8;
			color: #292f36;
			margin: 50px 47%;
			font-size: 25px;
			animation: bounce 5s infinite;
		}
		@keyframes moveUp {
			0% { bottom: 10% }
			100% { bottom: 10% }
			50% { bottom: 15% }
		}
		@keyframes loading {
			0% { opacity: 0; }
			100% { opacity: 0; }
			50% { opacity: 1; }
		}
		@keyframes moveV {
			0% { height: 50px; bottom: 30% }
			100% { height: 50px; bottom: 30% }
			50% { height: 180px; bottom: 60% }
		}
		@keyframes moveH {
			0% { width: 50px; right: 35% }
			100% { width: 50px; right: 35% }
			50% { width: 180px; right: 50% }
		}
		@keyframes wiggle {
	    	0% { transform: rotate(0deg); }
   			80% { transform: rotate(0deg); }
   			85% { transform: rotate(5deg); }
   			95% { transform: rotate(-5deg); }
	  		100% { transform: rotate(0deg); }
		}
		@keyframes spin {
    		from {transform:rotate(0deg);}
 		   to {transform:rotate(360deg);}
		}

	</style>
	<body>
	<div id="all">
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
<div id="sAll">
				<div class="inputcomp">
		<div id="upper" style="background-color: #e6e6e6;">
			<div class="port" id="left">
				<img src="http://i.imgur.com/BuSJYNJ.png">
			</div>
			<form id="ho" onsubmit="return validateSignin(e);" class="signinf" action="SignInCheck.jsp" method="post">
				<button type="submit" class="signin" id="right">Sign in</button>
				<input class="inputin" type="password" id="right" name="password" placeholder="Password" required>
				<input class="inputin" type="text" id="right" name="username" placeholder="Username" required>
			</form>
		</div>
	<script type="text/javascript">
    $('#ho').submit(function() {
    	$('#all').css('visibility', 'visible');
    	$('#sAll').css('visibility', 'hidden');
    });
</script>
		<div class="inter">
			<form onsubmit="return validate()" name="signup" action="SignUpCheck.jsp" method="post">
				<div class="inputcomp">
					<label id="left">Full Name</label>
					<input class="inputout" id="right"  type="text" name="fullname" required>

				</div>
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
	</body>
</html>

