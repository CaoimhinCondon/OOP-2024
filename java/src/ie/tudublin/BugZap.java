package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {

    float playerX;
    float playerY;
    float playerWidth = 40;
    float movementSpeed = 2;

    float bugX;
    float bugY;
    float bugWidth = 30;
    float bugMovementOffset = random(20, 100);
    float bugSpeed = random(10, 50);

    float score;
    boolean drawZapperFlag = false; // Flag to indicate whether to draw the zapper

    public void settings() {

        size(1000, 500);
    }

    public void setup() {

        playerX = width / 2;
        playerY = height - 20;
        score = 0;

        bugX = random(1, width);
        bugY = height - (height-20);
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

        stroke(255);
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

    public void drawBug(float bugX, float bugY, float bugWidth) {
        float bugHeight = bugWidth / 2;
    
        // Set colors for the bug
        fill(0); // Black color for the bug's body
        stroke(255); // White outline
        strokeWeight(1);
    
        // Draw the bug's body as an ellipse
        ellipse(bugX, bugY, bugWidth, bugHeight);
    
        // Draw bug's head as a smaller ellipse
        float headWidth = bugWidth * 0.4f;
        float headHeight = bugHeight * 0.6f;
        ellipse(bugX, bugY - bugHeight / 4, headWidth, headHeight);
    
        // Draw bug's legs
        for (int i = 0; i < 3; i++) {
            float legXOffset = (bugWidth * 0.4f) / 3 * i;
            // Left legs
            line(bugX - legXOffset, bugY, bugX - legXOffset - 10, bugY + 15);
            // Right legs
            line(bugX + legXOffset, bugY, bugX + legXOffset + 10, bugY + 15);
        }
    
        // Draw bug's antennae
        line(bugX - 5, bugY - bugHeight / 4, bugX - 15, bugY - bugHeight / 2);
        line(bugX + 5, bugY - bugHeight / 4, bugX + 15, bugY - bugHeight / 2);
    }

    public void bugMovement() {

        float bugMovementChangeX = random(-bugMovementOffset, bugMovementOffset);
        float bugMovementChangeY = random(1, bugSpeed);

        if((frameCount % 60) == 0){

            bugX += bugMovementChangeX;
            bugY += bugMovementChangeY;
        }
    }

    public void draw() {

        background(0); // Clear the screen every frame

        playerInput(); // Update player position based on input

        drawPlayer(playerX, playerY, playerWidth); // Draw the player
        drawBug(bugX, bugY, bugWidth); // Draw the bug
        bugMovement(); // Move the bug

        if (drawZapperFlag) {
            drawZapper();
            drawZapperFlag = false; // Reset flag after drawing zapper
        }
    }
}
