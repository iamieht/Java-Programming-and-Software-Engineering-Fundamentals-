function dochange() {
  var msg;
  var choice = confirm("Press a button!\nEither OK or Cancel.");
  if (choice == true) {
    msg = "You pressed OK";
  }
  else {
    msg = "Are you sure you want to cancel?";
  }
  alert(msg)
}