// Green Screen
var fgImage = new SimpleImage("drewRobert.png");
var bgImage = new SimpleImage("dinos.png");
var output = new SimpleImage(fgImage.getWidth(), fgImage.getHeight());

for (var pixel of fgImage.values()) {
    if (pixel.getGreen() > pixel.getRed() + pixel.getBlue()) {
        var bgPixel = bgImage.getPixel(pixel.getX(), pixel.getY());
        output.setPixel(pixel.getX(), pixel.getY(), bgPixel);
    }
    else {
        output.setPixel(pixel.getX(), pixel.getY(), pixel);
    }
}
print(output)