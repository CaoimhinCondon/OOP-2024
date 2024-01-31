package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {

    float playerX;
    float playerY;
    float playerWidth = 30;
    float movementSpeed = 2;
    float score;
    boolean drawZapperFlag = false; // Flag to indicate whether to draw the zapper

    public void settings() {

        size(500, 500);
    }

    public void setup() {

        playerX = width / 2;
        playerY = height - 20;
        score = 0;
    }

    public void drawPlayer(float playerX, float playerY, float playerWidth) {

        float playerHeight = playerWidth / 2;

        // Set outline colour to white
        stroke(255);
        strokeWeight(2);

        // Set fill to black
        fill(0);

        // Calculate the top-left corner of the rectangle
        float rectX = playerX - playerWidth / 2;
        float rectY = playerY - playerHeight / 2;

        // Draw the rectangle
        rect(rectX, rectY, playerWidth, playerHeight);
    }

    public void drawZapper() {

        line(playerX, playerY - ((playerWidth / 2) / 2), playerX, 0);
    }

    public void playerInput() {

        if (keyPressed) {
            
            if (keyCode == RIGHT) {
                
                playerX += movementSpeed;
            }

            if (keyCode == LEFT) {

                playerX -= movementSpeed;
            }

            if (key == ' ') {

                drawZapperFlag = true;
            }
        }
    }

    public void draw() {

        background(0); // Clear the screen every frame

        playerInput(); // Update player position based on input

        drawPlayer(playerX, playerY, playerWidth); // Draw the player

        if (drawZapperFlag) {
            drawZapper();
            drawZapperFlag = false; // Reset flag after drawing zapper
        }
    }
}
