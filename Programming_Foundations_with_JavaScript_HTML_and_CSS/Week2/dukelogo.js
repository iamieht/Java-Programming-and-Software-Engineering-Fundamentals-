// Duke Blue to Duke Yellow
var img_duke = new SimpleImage("duke_blue_devil.png")

//print original image
print(img_duke)

for (var pixel of img_duke.values()) {
    if (pixel.getBlue() != 255) {
        pixel.setRed(255);
        pixel.setGreen(255);
        pixel.setBlue(0);
    }
}

//Print modified image
print(img_duke)