
package main.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import main.controller.Controller;
import main.model.ObjectPlacer;
import main.model.Item;
import main.model.Player;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class creates the game panel.
 */
public class GamePanel extends JPanel implements Runnable {

    public final int TILE_SIZE = 48;
    public final int columns = 16;
    public final int rows = 12;
    public final int screenWidth = TILE_SIZE * columns;
    public final int screenHeight = TILE_SIZE * rows;
    public final int mapCol = 50;
    public final int mapRow = 50;
    int FPS = 60;
    public TileMap tileMap;
    Controller controller = new Controller();
    Thread gameThread;
    ObjectPlacer objectPlacer = new ObjectPlacer(this);
    public Player player = new Player(this, controller);
    BufferedImage heart1, heart2, heart3;
    private int coinCount = 0;
    public Item[] item = new Item[10];


    /**
     * Constructor
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(controller);
        this.setFocusable(true);
        tileMap = new TileMap(this);

    }

    /**
     * This method draws the game panel.
     * @param g Graphics
     */
    private void drawCoinCounter(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monaco", Font.BOLD, 20));
        g.drawString("Coins: " + coinCount, 10, 30);
    }

    /**
     * This method draws the game panel.
     * @param g2 Graphics
     */
    private void drawHearts(Graphics2D g2) {
        try {
            heart1 = ImageIO.read(new File("res/player/heart1.png"));
            heart2 = ImageIO.read(new File("res/player/heart1.png"));
            heart3 = ImageIO.read(new File("res/player/heart1.png"));

            g2.setColor(Color.white);
            g2.drawString("Lives: ", 130, 30);
            g2.drawImage(heart1, 220, 15, null);
            g2.drawImage(heart2, 240, 15, null);
            g2.drawImage(heart3, 260, 15, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method places the objects in the game.
     *
     */
    public void startGame() {
        objectPlacer.setObject();
    }

    /**
     * Starts the game thread.
     *
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * This method is called by the thread to run the game.
     * @author RyiSnow on YouTube
     */
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method updates the game and player moves.
     */
    public void update() {
        player.update();
    }

    /**
     * This method paints the game panel.
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileMap.paintComponent(g2);

        for (Item coin : item) {
            coin.drawItem(g2, this);
        }

        player.draw(g2);
        drawCoinCounter(g2);
        drawHearts(g2);
        collectCoins();
        g2.dispose();
    }

    /**
     * This method collects the coins.
     */
    private void collectCoins() {
        for (Item coin : item) {
            if (player.mapX == coin.mapX && player.mapY == coin.mapY && coinCount < item.length && coinCount < 10) {
                coinCount++;
            }
        }
    }
}
