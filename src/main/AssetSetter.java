package main;

import entity.BlueBoy;
import entity.NPC_OldMan;
import object.OBJ_Door;

public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    // Sets the positions of various objects.
    public void setObject(){
        gp.obj[0] = new OBJ_Door(gp);
        gp.obj[0].worldX = gp.tileSize*10;
        gp.obj[0].worldY = gp.tileSize*6;

    }

    public void setNPC(){
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;
        
    }

    public void setEnemy(){
        gp.enemy[0] = new BlueBoy(gp);
        gp.enemy[0].worldX = gp.tileSize*25;
        gp.enemy[0].worldY = gp.tileSize*21;

        gp.enemy[1] = new NPC_OldMan(gp);
        gp.enemy[1].worldX = gp.tileSize*12;
        gp.enemy[1].worldY = gp.tileSize*11;
    }

}
