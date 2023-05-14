package main.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class controls the player's movement.
 */
public class Controller implements KeyListener {

    public boolean wKey, sKey, aKey, dKey;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * This method checks if the player presses the WASD keys.
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            wKey = true;
        }
        if (code == KeyEvent.VK_S) {
            sKey = true;
        }
        if (code == KeyEvent.VK_A) {
            aKey = true;
        }
        if (code == KeyEvent.VK_D) {
            dKey = true;
        }
    }

    /**
     * This method checks if the player releases the WASD keys.
     * @param e KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wKey = false;
        }
        if (code == KeyEvent.VK_S) {
            sKey = false;
        }
        if (code == KeyEvent.VK_A) {
            aKey = false;
        }
        if (code == KeyEvent.VK_D) {
            dKey = false;
        }
    }
}
