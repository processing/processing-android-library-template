import com.sarah.library.*;

HelloLibrary hello;

void setup() {
  fullScreen();
  
  hello = new HelloLibrary(this);

  
  PFont font = createFont("SansSerif", 40 * displayDensity);
  textFont(font);
}

void draw() {
  background(0);
  fill(255);
  text(hello.sayHello(), mouseX, mouseY);
}