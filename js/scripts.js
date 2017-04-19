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
	
var modal = document.getElementById('myModal');


var btn = document.getElementById("myBtn");


var span = document.getElementsByClassName("closebtn")[0];


btn.onclick = function() {
    modal.style.display = "block";
}


span.onclick = function() {
    modal.style.display = "none";
}


window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
}