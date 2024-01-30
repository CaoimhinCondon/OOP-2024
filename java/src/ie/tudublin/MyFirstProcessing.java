package ie.tudublin;

import processing.core.PApplet;

public class MyFirstProcessing extends PApplet {
    
    public void settings(){

        size(500, 500);
    }

    public void setup(){

    }

    public void draw(){

        background(255, 0, 0);
        circle(250, 300, 400);
        fill(40, 0, 150);
        triangle(250, 50, 50, 450, 450, 450);
        fill(255, 255, 0);
        ellipse(250, 250, 180, 100); //cx, cy
        fill(255, 255, 255);
        circle(250, 250, 80);
        fill(0, 0, 0);
    }
}
