function doOrange() {
  var canv1 = document.getElementById("canvas");
  canv1.style.backgroundColor = "orange";
}

function doColor() {
  var canvas = document.getElementById("canvas");
  var colorinput = document.getElementById("b2");
  canvas.style.backgroundColor = colorinput.value;
}