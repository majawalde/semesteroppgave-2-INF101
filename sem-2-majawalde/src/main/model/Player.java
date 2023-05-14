package main.model;

import main.controller.Controller;
import main.view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * @author RyiSnow on YouTube.
 */

public class Player extends Entity {

    GamePanel gamePanel;
    Controller keyHandler;
    public final int screenX;
    public final int screenY;

    /**
     * This constructor sets the player's position on the screen.
     * @param gamePanel
     * @param keyHandler
     */
    public Player(GamePanel gamePanel, Controller keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth/2 - gamePanel.TILE_SIZE /2;
        screenY = gamePanel.screenHeight/2 - gamePanel.TILE_SIZE /2;

        objectArea = new Rectangle();
        objectArea.x = 8;
        objectArea.y = 16;
        objectAreaDefaultX = objectArea.x;
        objectAreaDefaultY = objectArea.y;
        objectArea.width = 32;
        objectArea.height = 32;

        setDefaultPosition();
        getPlayerSprite();
    }

    /**
     * This method gets the player's sprite from the resources folder.
     */
    public void getPlayerSprite() {
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/up1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/up3.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/down1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/down3.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/left1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/left3.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/right1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/right3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method sets the player's position to the default position.
     */
    public void setDefaultPosition() {
        mapX = gamePanel.TILE_SIZE *23;
        mapY = gamePanel.TILE_SIZE *21;
        speed = 4;
        direction = "down";
    }

    /**
     * This method is called every frame.
     * It checks if the player is moving and updates the sprite accordingly.
     * @author RyiSnow
     */
    public void update() {
        if (keyHandler.wKey == true || keyHandler.sKey == true || keyHandler.aKey == true || keyHandler.dKey == true) {
            if (keyHandler.wKey) {
                direction = "up";
                mapY -= speed;
            }
            if (keyHandler.sKey) {
                direction = "down";
                mapY += speed;
            }
            if (keyHandler.aKey) {
                direction = "left";
                mapX -= speed;
            }
            if (keyHandler.dKey) {
                direction = "right";
                 mapX += speed;
            }
            spriteCounter++;
            if (spriteCounter == 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    /**
     * This method draws the player's sprite on the screen.
     * @param g2 Graphics2D
     */
    public void draw(Graphics2D g2) {
        if (direction.equals("up")) {
            if (spriteNumber == 1)
                g2.drawImage(up1, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            if (spriteNumber == 2)
                g2.drawImage(up2, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
        if (direction.equals("down")) {
            if (spriteNumber == 1)
                g2.drawImage(down1, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            if (spriteNumber == 2)
                g2.drawImage(down2, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
        if (direction.equals("left")) {
            if (spriteNumber == 1)
                g2.drawImage(left1, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            if (spriteNumber == 2)
                g2.drawImage(left2, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
        if (direction.equals("right")) {
            if (spriteNumber == 1)
                g2.drawImage(right1, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            if (spriteNumber == 2)
                g2.drawImage(right2, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
    }
}
