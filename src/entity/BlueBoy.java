package entity;

import main.GamePanel;

public class BlueBoy extends Entity{

    public BlueBoy(GamePanel gp) {
        super(gp);
        maxHealth = 100;
        health = maxHealth;

        direction = "down";

        getImage();
        
    }

    public void getImage(){
        down1 = setUp("player/boy_down_1");
        down2 = setUp("player/boy_down_1");
    }

    public void setDialogue(){

        dialogues[0] = "I am blue boy";
        dialogues[1] = "I have blue balls too.";
        
    }

    public void attackEnemy(int attackSelected){
        switch (attackSelected){
            case (0):
                System.out.println("Attack 0 was chosen");
                health -= 10;
                System.out.println("Health = "+health);
                break;
            case (1):
                System.out.println("Attack 1 was chosen");
                health -= 20;
                System.out.println("Health = "+health);
                break;
            case (2):
                System.out.println("Attack 2 was chosen");
                System.out.println("Health = "+health);
                break;
        }
    }

    public void speak(){
        super.speak();
    }
    
}
