function changeColor() {
  var de1 = document.getElementById("div1");
  var de2 = document.getElementById("div2");
  
  de1.className = "blueback";
  de2.className = "greenback";
  
}

function changeText() {
  var de1 = document.getElementById("div1");
  var de2 = document.getElementById("div2");
  
  de1.innerHTML = "Hier ist div1";
  de2.innerHTML = "Hier ist div2";
}