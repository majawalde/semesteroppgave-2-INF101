package main.model;

import main.view.GamePanel;


import java.util.Random;


/**
 * This class is responsible for placing objects in the map
 */
public class ObjectPlacer {

    GamePanel gamePanel;

    /**
     * Constructor
     * @param gamePanel
     */
    public ObjectPlacer(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * This method places the objects in the map
     */
    public void setObject(){
        gamePanel.item[0] = new Coin();
        Random random = new Random();
        int randomX = random.nextInt(gamePanel.mapCol);
        int randomY = random.nextInt(gamePanel.mapRow);

        gamePanel.item[0].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[0].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[1] = new Coin();
        gamePanel.item[1].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[1].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[2] = new Coin();
        gamePanel.item[2].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[2].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[3] = new Coin();
        gamePanel.item[3].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[3].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[4] = new Coin();
        gamePanel.item[4].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[4].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[5] = new Coin();
        gamePanel.item[5].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[5].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[6] = new Coin();
        gamePanel.item[6].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[6].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[7] = new Coin();
        gamePanel.item[7].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[7].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[8] = new Coin();
        gamePanel.item[8].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[8].mapY = randomY * gamePanel.TILE_SIZE;

        randomX = random.nextInt(gamePanel.mapCol);
        randomY = random.nextInt(gamePanel.mapRow);
        gamePanel.item[9] = new Coin();
        gamePanel.item[9].mapX = randomX * gamePanel.TILE_SIZE;
        gamePanel.item[9].mapY = randomY * gamePanel.TILE_SIZE;

    }
}

