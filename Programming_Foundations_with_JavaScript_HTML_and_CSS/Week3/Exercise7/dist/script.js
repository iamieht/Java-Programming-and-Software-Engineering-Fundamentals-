var imageorig;
var image;

function upload() {
  var imgcanvas = document.getElementById("canvasorig");
  var fileinput = document.getElementById("finput");
  imageorig = new SimpleImage(fileinput);
  image = new SimpleImage(fileinput);
  image.drawTo(imgcanvas);
}

function makeGray() {
  for (var pixel of image.values()) {
    var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    pixel.setRed(avg);
    pixel.setGreen(avg);
    pixel.setBlue(avg);
  }
  var imgcanvas = document.getElementById("canvas");
  image.drawTo(imgcanvas);
}