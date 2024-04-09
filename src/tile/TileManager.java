package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager (GamePanel gp){
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/maps/nemea.txt");
    }

    public void getTileImage(){

            // setUp(0, "tiles/grass", false);
            // setUp(1, "tiles/wall", true);
            // setUp(2, "tiles/water", true);
            // setUp(3, "tiles/earth", false);
            // setUp(4, "tiles/tree", true);
            // setUp(5, "tiles/sand", false);

            setUp(0, "duodecimTiles/brush", false);
            setUp(1, "duodecimTiles/stone", false);
            setUp(2, "duodecimTiles/wood", true);
            setUp(3, "duodecimTiles/door", true);
            setUp(4, "duodecimTiles/tree", true);
            setUp(5, "duodecimTiles/sand", false);
            setUp(6, "duodecimTiles/PillarMid", true);
            setUp(7, "duodecimTiles/PillarTop", true);
            setUp(8, "duodecimTiles/PillarBottom", true);
            setUp(9, "duodecimTiles/earth", false);

    }

    public void setUp(int index, String filePath, boolean collision){
        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/" + filePath + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while (col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();


        } catch (Exception e) {
            
        }
    }

    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY
                ) {
                
                    g2.drawImage(tile[tileNum].image, screenX, screenY, null);
                }
                worldCol++;
                if (worldCol == gp.maxWorldCol){
                    worldCol = 0;
                    worldRow++;
            } 
        } 
    }
}
