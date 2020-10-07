var fgimage = null;
var bgimage = null;

function greenScreen() {
  if (fgimage == null || ! fgimage.complete()) {
    alert("foreground not loaded");
    return;
  }
  if (bgimage == null || ! bgimage.complete()) {
    alert("background not loaded");
    return;
  }
  clearCanvas();
  makeComposite();
}

function loadForegroundImage() {
  var imgcanvas = document.getElementById("canvasorig");
  var fileinput = document.getElementById("fgfile");
  fgimage = new SimpleImage(fileinput);
  fgimage.drawTo(imgcanvas);
}

function loadBackgroundImage() {
  var imgcanvas = document.getElementById("canvas");
  var fileinput = document.getElementById("bgfile");
  bgimage = new SimpleImage(fileinput);
  bgimage.drawTo(imgcanvas);
}


function makeComposite() {
  var output = new SimpleImage(fgimage.getWidth(),
                              fgimage.getHeight());
  
  for (var pixel of fgimage.values()) {
    if (pixel.getGreen() > pixel.getRed() + pixel.getBlue()) {
        var bgPixel = bgimage.getPixel(pixel.getX(), pixel.getY());
        output.setPixel(pixel.getX(), pixel.getY(), bgPixel);
    } else {
      output.setPixel(pixel.getX(), pixel.getY(), pixel);
    }
  }
  var imgcanvas = document.getElementById("canvasorig");
  output.drawTo(imgcanvas);
}

function clearCanvas() {
  var canvasorig = document.getElementById("canvasorig");
  var canvas = document.getElementById("canvas");
  var context = canvas.getContext("2d");
  context.clearRect(0,0,canvas.width,canvas.height);
  var context2 = canvasorig.getContext("2d");
  context2.clearRect(0,0,canvasorig.width,canvasorig.height);
}