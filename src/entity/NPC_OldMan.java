package entity;

import java.util.Random;

import main.GamePanel;


public class NPC_OldMan extends Entity{


    public NPC_OldMan(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();

    }

     public void getImage(){

        up1 = setUp("npc/oldman_up_1");
        up2 = setUp("npc/oldman_up_2");
        down1 = setUp("npc/oldman_down_1");
        down2 = setUp("npc/oldman_down_2");
        left1 = setUp("npc/oldman_left_1");
        left2 = setUp("npc/oldman_left_2");
        right1 = setUp("npc/oldman_right_1");
        right2 = setUp("npc/oldman_right_2");

    }

    public void setDialogue(){

        dialogues[0] = "hello, Hercules.";
        dialogues[1] = "Please, my son was killed by\na lion.";
        dialogues[2] = "It escaped into the forest\nbut it will be back for more";
        dialogues[3] = "Please, save Nemea";
        dialogues[4] = "we should fuck";
        
    }

    public void setAction(){
        if (actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(4);

            switch (i) {
                case 0:
                    direction = "up";
                    break;
                case 1:
                    direction = "down";
                    break;
                case 2:
                    direction = "right";
                    break;
                case 3:
                    direction = "left";
                    break;
            }
            actionLockCounter = 0;
        }
        actionLockCounter++;
    }

    public void speak(){
        super.speak();
    }
}
