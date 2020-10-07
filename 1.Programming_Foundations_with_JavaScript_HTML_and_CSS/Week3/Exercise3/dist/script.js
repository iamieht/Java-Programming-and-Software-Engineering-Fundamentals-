function doBlue() {
  var canv1 = document.getElementById("div1");
  var context = canv1.getContext("2d");
  context.clearRect(0,0,canv1.width,canv1.height);
  canv1.style.backgroundColor = "blue"; 
  
}

function doOrange() {
  var canv1 = document.getElementById("div1");
  canv1.style.backgroundColor = "orange";
  var context = canv1.getContext("2d");
  context.fillStyle = "yellow";
  context.fillRect(10,10,60,60);
  context.fillRect(80,10,60,60);
  context.fillStyle = "black";
  context.font = "20px Arial";
  context.fillText("Hello", 15, 45);
  
}

function doFuchsia() {
  var canv2 = document.getElementById("div2");
  canv2.style.backgroundColor = "fuchsia";
}