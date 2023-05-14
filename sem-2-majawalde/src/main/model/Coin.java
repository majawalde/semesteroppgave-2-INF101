package main.model;


import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class creates a coin object.
 */
public class Coin extends Item {


    public Coin() {
        this.name = "Coin";

        try {
            this.image = ImageIO.read(new File("res/items/coin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
