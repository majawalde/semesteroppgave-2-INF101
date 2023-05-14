package main.model;


import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class creates an entity object.
 * @author RyiSnow on Youtube.
 */

public class Entity {
    public int mapX, mapY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    public String direction;
    public Rectangle objectArea;
    public int objectAreaDefaultX, objectAreaDefaultY;

    public int spriteCounter = 0;
    public int spriteNumber = 1;
}
