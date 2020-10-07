var image = null
var image_gray = null
var image_red = null
var image_rainbow = null

function checkImage() {
  if (image == null || ! image.complete()) {
    alert("Image not loaded");
    return;
  }
}

function loadImage() {
  var imgcanvas = document.getElementById("canvas");
  var fileinput = document.getElementById("file");
  image = new SimpleImage(fileinput);
  image_gray = new SimpleImage(fileinput);
  image_red = new SimpleImage(fileinput);
  image_rainbow = new SimpleImage(fileinput);
  image.drawTo(imgcanvas);
}

function makeGray() {
  checkImage();
  for (var pixel of image_gray.values()) {
    var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    pixel.setRed(avg);
    pixel.setGreen(avg);
    pixel.setBlue(avg);
  }
  var imgcanvas = document.getElementById("canvas");
  image_gray.drawTo(imgcanvas);
}

function makeRed() {
  checkImage();
  for (var pixel of image_red.values()) {
    var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    if (avg < 128) {
      pixel.setRed(avg * 2);
      pixel.setGreen(0);
      pixel.setBlue(0);
    } else {
      pixel.setRed(255);
      pixel.setGreen(avg * 2 - 255);
      pixel.setBlue(avg * 2 - 255);
    }
  }
  var imgcanvas = document.getElementById("canvas");
  image_red.drawTo(imgcanvas);
}

function makeRainbow() {
  checkImage();
  var image_rainbow_width = image_rainbow.getHeight();
  var image_rainbow_seventh = image_rainbow_width / 7;
  
  for (var pixel of image_rainbow.values()) {
    var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    if (pixel.getY() < image_rainbow_seventh) {
      if (avg < 128) {
        pixel.setRed(2*avg);
        pixel.setGreen(0);
        pixel.setBlue(0);
      } else {
        pixel.setRed(255);
        pixel.setGreen(2*avg - 255);
        pixel.setBlue(2*avg - 255);
      }
    } else if (pixel.getY() < image_rainbow_seventh * 2) {
      if (avg < 128) {
        pixel.setRed(2*avg);
        pixel.setGreen(0.8*avg);
        pixel.setBlue(0);
      } else {
        pixel.setRed(255);
        pixel.setGreen(1.2*avg - 51);
        pixel.setBlue(2*avg - 255);
      }      
    } else if (pixel.getY() < image_rainbow_seventh * 3) {
      if (avg < 128) {
        pixel.setRed(2*avg);
        pixel.setGreen(2*avg);
        pixel.setBlue(0);
      } else {
        pixel.setRed(255);
        pixel.setGreen(255);
        pixel.setBlue(2*avg - 255);
      }
    } else if (pixel.getY() < image_rainbow_seventh * 4) {
      if (avg < 128) {
        pixel.setRed(0);
        pixel.setGreen(2*avg);
        pixel.setBlue(0);
      } else {
        pixel.setRed(2*avg -255);
        pixel.setGreen(255);
        pixel.setBlue(2*avg - 255);
      }
    } else if (pixel.getY() < image_rainbow_seventh * 5) {
      if (avg < 128) {
        pixel.setRed(0);
        pixel.setGreen(0);
        pixel.setBlue(2*avg);
      } else {
        pixel.setRed(2*avg -255);
        pixel.setGreen(2*avg - 255);
        pixel.setBlue(255);
      }
    } else if (pixel.getY() < image_rainbow_seventh * 6) {
      if (avg < 128) {
        pixel.setRed(0.8*avg);
        pixel.setGreen(0);
        pixel.setBlue(2*avg);
      } else {
        pixel.setRed(1.2*avg -51);
        pixel.setGreen(2*avg - 255);
        pixel.setBlue(255);
      }
    } else {
      if (avg < 128) {
        pixel.setRed(1.6*avg);
        pixel.setGreen(0);
        pixel.setBlue(1.6*avg);
      } else {
        pixel.setRed(0.4*avg +153);
        pixel.setGreen(2*avg - 255);
        pixel.setBlue(0.4*avg +153);
      }
    }
  }
  var imgcanvas = document.getElementById("canvas");
  image_rainbow.drawTo(imgcanvas);
}

function clearCanvas() {
  var canvas = document.getElementById("canvas");
  var context = canvas.getContext("2d");
  context.clearRect(0,0,canvas.width,canvas.height);
  var imgcanvas = document.getElementById("canvas");
  image.drawTo(imgcanvas);
  image_red = new SimpleImage(image);
  image_gray = new SimpleImage(image);
  image_rainbow = new SimpleImage(image);
}