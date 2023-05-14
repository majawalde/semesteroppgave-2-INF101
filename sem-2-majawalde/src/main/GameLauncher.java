package main;


import main.view.GamePanel;

import javax.swing.*;

/**
 * This class launches the game.
 */
public class GameLauncher {

  public static void main(String[] args) {

    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("Maja Walde - Semesteroppgave 2");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.startGame();
    gamePanel.startGameThread();
  }
}
