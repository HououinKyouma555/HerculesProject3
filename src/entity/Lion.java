package entity;

import main.GamePanel;

public class Lion extends Entity {

    public Lion(GamePanel gp){
        super(gp);

        name = "Lion";
        maxHealth = 600;
        health = maxHealth;

        direction = "down";
        appears = 2;

        getImage();
    }

    public void getImage(){
       
        up1 = setUp("lion/LionDownLeft");
        up2 = setUp("lion/LionDownRight");
        down1 = setUp("lion/LionDownLeft");
        down2 = setUp("lion/LionDownRight");
        left1 = setUp("lion/LionLeft1");
        left2 = setUp("lion/LionLeft2");
        right1 = setUp("lion/LionRight1");
        right2 = setUp("lion/LionRight2");

    }
    
}
