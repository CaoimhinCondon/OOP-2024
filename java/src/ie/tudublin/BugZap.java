package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet{

    float playerX;
    float playerY;
    float playerWidth = 30;
    float movementSpeed = 2;
    float zapFireTime = 1;

    public void settings(){

        size(500, 500);
    }

    public void setup(){

        playerX = width/2;
        playerY = height - 20;

        background(0);
        drawPlayer(playerX, playerY, playerWidth);
    }

    public void drawPlayer(float playerX, float playerY, float playerWidth){

        float playerHeight = playerWidth/2;

        //Set outline colour to white
        stroke(255);
        strokeWeight(2);

        //Set fill to black
        fill(0);

        // Calculate the top-left corner of the rectangle
        float rectX = playerX - playerWidth / 2;
        float rectY = playerY - playerHeight / 2;

        // Draw the rectangle
        rect(rectX, rectY, playerWidth, playerHeight);
    }

    public void drawZapper(){

        line(playerX, playerY-((playerWidth/2)/2), playerX, 0);
    }

    public void playerInput(){

        if (keyCode == RIGHT && keyPressed == true){

            background(0);
            playerX += movementSpeed;
            drawPlayer(playerX, playerY, playerWidth);
        }
        
        if (keyCode == LEFT && keyPressed == true){

            background(0);
            playerX -= movementSpeed;
            drawPlayer(playerX, playerY, playerWidth);
        }

        if (keyCode == ' '){

            //Draws zapper
            drawZapper();
        }
    }

    public void draw(){

        playerInput();
    }
}
