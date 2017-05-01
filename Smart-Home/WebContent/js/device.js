function updateSwitch(elem) {
	var value = elem.value;
	var lamp = document.getElementById("lamp");
	var dev = document.getElementById("dev");
	var light = document.getElementById("light");
    if(value == "ON"){
    elem.value = "OFF";
    lamp.style.background = "linear-gradient(#ff7777, #ff0000)";
    lamp.style.boxShadow= "0px 0px 10px #ff0000";
    dev.style.overflow = "hidden";
    light.style.zIndex = "100";
    light.style.opacity = "0.5";
    }else{
    elem.value = "ON";
    lamp.style.background = "linear-gradient(#88ff88,#00ff00)";
    lamp.style.boxShadow= "0px 0px 10px #00ff00";
    dev.style.overflowY = "scroll";
    light.style.zIndex = "-1";
    light.style.opacity = "0.0";
    
    }
}

function updateChosen(elem){
	var value = elem.value;
	var ch = document.getElementById("chosen");
	ch.innerHTML = value;
}

function updateMode(){
	var value = document.getElementById("mode").value;
	var chosen = document.getElementById("chosenMode");
	chosen.innerHTML = value;
	var light = document.getElementById("light");
	light.style.zIndex = "-1";
    light.style.opacity = "0.0";
}