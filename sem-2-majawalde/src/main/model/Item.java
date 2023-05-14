package main.model;

import main.view.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author RyiSnow on YouTube
 */
public class Item {

    public BufferedImage image;
    public String name;
    public int mapX, mapY;

    public void drawItem(Graphics2D g2, GamePanel gamePanel) {
        int screenX = mapX - gamePanel.player.mapX + gamePanel.player.screenX;
        int screenY = mapY - gamePanel.player.mapY + gamePanel.player.screenY;

        if (mapX + gamePanel.TILE_SIZE > gamePanel.player.mapX - gamePanel.player.mapX &&
                mapX - gamePanel.TILE_SIZE < gamePanel.player.mapX + gamePanel.player.screenX &&
                mapY + gamePanel.TILE_SIZE > gamePanel.player.mapY - gamePanel.player.screenY &&
                mapY - gamePanel.TILE_SIZE < gamePanel.player.mapY + gamePanel.player.screenY) {

            g2.drawImage(image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
    }
}
