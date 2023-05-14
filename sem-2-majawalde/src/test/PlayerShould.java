package test;

import main.controller.Controller;
import main.model.Player;
import main.view.GamePanel;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * This class tests the Player position
 */
public class PlayerShould {


    //test if the map moves according to the player's movement
    @Test
    public void playerShouldMoveUp(){
        GamePanel gamePanel = new GamePanel();
        Controller controller = new Controller();
        Player player = new Player(gamePanel, controller);

        int mapX = gamePanel.player.mapX;
        int mapY = gamePanel.player.mapY;

        player.update();
        controller.wKey = true;
        player.update();

        assertEquals(mapX, gamePanel.player.mapX);
        assertEquals(mapY, gamePanel.player.mapY);
    }
}






