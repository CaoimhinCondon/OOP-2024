package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {

    float score;
    boolean gameStart = false;

    float playerX;
    float playerY;
    float playerWidth = 40;
    float movementSpeed = 2;

    float bugX;
    float bugY;
    float bugWidth = 30;
    float bugMovementOffset = random(20, 100);
    float bugSpeed = random(10, 50);

    boolean firingZapperFlag = false; // Flag to indicate whether the zapper is activated

    public void settings() {

        size(1000, 500);
    }

    public void setup() {

        playerX = width / 2;
        playerY = height - 20;
        score = 0;

        bugX = random(30, width-30);
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

        if (keyPressed && (gameStart == true)) {
            
            if (keyCode == RIGHT && ((playerX<(width-playerWidth/2)))) {

                playerX += movementSpeed;
            }

            if (keyCode == LEFT && (playerX>playerWidth/2)) {

                playerX -= movementSpeed;
            }

            if (key == ' ') {

                firingZapperFlag = true;
            }
        }else if(keyPressed && (gameStart == false)){

            if (key == ' ') {

                gameStart = true;
                score = 0;
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

        float bugMovementChangeX;
        float bugMovementChangeY;

        if (bugX > (width-bugWidth)){

            bugMovementChangeX = -bugMovementOffset;
            bugMovementChangeY = random(1, bugSpeed);
        } else if((bugX < bugWidth)) {

            bugMovementChangeX = bugMovementOffset;
            bugMovementChangeY = random(1, bugSpeed);
        }else{

            bugMovementChangeX = random(-bugMovementOffset, bugMovementOffset);
            bugMovementChangeY = random(1, bugSpeed);
        }

        if((frameCount % 30) == 0){

            bugX += bugMovementChangeX;
            bugY += bugMovementChangeY;
        }
    }

    public void bugHitDetection() {

        if (firingZapperFlag == true){

            
            if (((bugX-bugWidth/2) < playerX) && ((bugX+bugWidth/2) > playerX)){

                score += 1;
                bugX = random(30, width-30);
                bugY = height - (height-20);
            }
        }

        if (bugY > height - (playerWidth/2)){

            //Reset Player
            playerX = width / 2;
            playerY = height - 20;

            //Reset Bug
            bugX = random(30, width-30);
            bugY = height - (height-20);

            gameStart = false;
        }
    }

    public void displayScore() {

        fill(255);  // Set text color to white
        textSize(20); // Set text size
        text("Score: " + score, 10, 20);
    }

    public void displayStartScreen() {

        background(0);
        fill(255); // Set text color
        text("BugZap", width / 2, height / 3); // Display the game title
        textAlign(CENTER, CENTER);
        textSize(20); // Smaller text for score and instructions
        text("Previous Score: " + score, width / 2, height / 2); // Display previous score
        text("Press SPACE to play", width / 2, 2 * height / 3); // Display the prompt
    
    }

    public void draw() {

        displayStartScreen();
        playerInput();

        if (gameStart == true){

            textAlign(LEFT, BASELINE);
            background(0); // Clear the screen every frame

            playerInput(); // Update player position based on input

            drawPlayer(playerX, playerY, playerWidth); // Draw the player
            drawBug(bugX, bugY, bugWidth); // Draw the bug
            bugMovement(); // Move the bug
            bugHitDetection(); // Check if bug is being hit by zapper or has killed player
            displayScore(); // Display the players score

            if (firingZapperFlag) {
                drawZapper();
                firingZapperFlag = false; // Reset flag after drawing zapper
            }
        }
    }
}