function validate() {
	var x = document.forms["signup"]["fullname"].value;
	var y = document.forms["signup"]["newuser"].value;
	var z = document.forms["signup"]["newpass"].value;
	var h = document.forms["signup"]["renewpass"].value;

	var submit = true;

	if( x == null || x == "") {
		alert("Please Fill Full Name");
		return false;
	}
	if (y == null || y == "") {
		alert("Please Fill Username");
		return false;
	}
	if (z == null || z == "") {
		alert("Please Fill Password");
		return false;

	}
	if( z != y) {
		alert("Password doesn't match !!");
		return false;
	}

	return submit;
}
function target_popup(form) {
     var w = window.open('about:blank','formpopup','toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0,width=400,height=300');
    form.target = 'formpopup';
}
function deleteShow() {
 var elements = document.getElementsByClassName("close");
for(var i=0; i<elements.length; i++) {
    elements[i].style.display = "block";
}
}

function deleteHide() {
 var elements = document.getElementsByClassName("close");
for(var i=0; i<elements.length; i++) {
    elements[i].style.display = "none";
}
}
var fn3 = (function() {
  var first = true;
  return function() {
    first ? deleteShow() : deleteHide();
    first = !first;
  }
})();

function themepopup(){
	getElementById("popuptheme").style.display = "none";
}
function changeMain(color) {
	getElementById("uppder").style.backgroundColor = "#" + color;
}
function popup() {
	// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById('myBtn');

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("closebtn")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
}
function changeMain() {
	alert("Done");
	document.getElementById('upper').style.backgroundColor ="red";
}
