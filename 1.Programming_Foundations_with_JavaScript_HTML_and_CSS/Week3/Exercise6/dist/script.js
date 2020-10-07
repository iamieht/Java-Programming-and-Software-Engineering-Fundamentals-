function upload() {
  var imgcanvas = document.getElementById("canvas");
  var fileinput = document.getElementById("finput");
  var image = new SimpleImage(fileinput);
  image.drawTo(imgcanvas);
}