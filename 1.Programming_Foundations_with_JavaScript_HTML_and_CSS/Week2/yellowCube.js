var yellow_cube = new SimpleImage(200,200);
print(yellow_cube);
for (var pixel of yellow_cube.values()) {
    pixel.setRed(255);
    pixel.setGreen(255);
    pixel.setBlue(0);
}
print(yellow_cube);