package test;

import org.junit.*;
import static org.junit.Assert.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import main.view.TileMap;

/**
 * This class tests the Map
 */
public class MapShould {
    TileMap tileMap;
    BufferedImage[] tiles;

    @Before
    public void setUp() throws IOException {
        tileMap = new TileMap(null);
        tiles = new BufferedImage[4];
        tiles[0] = ImageIO.read(new File("res/tiles/terrain0.png"));
        tiles[1] = ImageIO.read(new File("res/tiles/terrain2.png"));
        tiles[2] = ImageIO.read(new File("res/tiles/terrain1.png"));
        tiles[3] = ImageIO.read(new File("res/tiles/water.png"));
    }

    @Test
    public void mapShouldBeCreated() {
        assertNotNull(tileMap);
    }
}

