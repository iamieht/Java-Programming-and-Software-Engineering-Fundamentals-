var img_hilton = new SimpleImage("hilton.jpg");
var img_hilton_width = img_hilton.getWidth();
var img_hilton_third = img_hilton_width / 3;
// Print original image
print(img_hilton)

for (var pixel of img_hilton.values() ) {
    if (pixel.getX() < img_hilton_third) {
        pixel.setRed(255);
    } else if (pixel.getX() < img_hilton_third * 2) {
        pixel.setGreen(255);
    } else {
        pixel.setBlue(255);
    }
}

//Print modified image
print(img_hilton)
