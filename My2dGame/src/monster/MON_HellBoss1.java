package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_Mana;

public class MON_HellBoss1 extends Entity{
	GamePanel gp;
	public MON_HellBoss1(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		
		name = "MON_HellBoss1";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 10;
		life  = maxLife;
		maxMana = 4;
		mana = maxMana;
		attack = 8;
		defense = 2;
		exp = 10;
		knockBackPower = 5;
		motion1_duration = 40;
		motion2_duration = 85;
		
		solidArea.x = 4;
		solidArea.y = 4;
		solidArea.width = 40;
		solidArea.height = 44;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		attackArea.width = 48;
		attackArea.height = 48;
		getImage();
		getAttackImage();
	}
	
	public void getImage() {
		up1 = setup("monster\\boss up 1",gp.tileSize,gp.tileSize);
		up2 = setup("monster\\boss up 2",gp.tileSize,gp.tileSize);
		down1 = setup("monster\\boss down 1",gp.tileSize,gp.tileSize);
		down2 = setup("monster\\boss down 2",gp.tileSize,gp.tileSize);
		left1 = setup("monster\\boss left 1",gp.tileSize,gp.tileSize);
		left2 = setup("monster\\boss left 2",gp.tileSize,gp.tileSize);
		right1 = setup("monster\\boss right 1",gp.tileSize,gp.tileSize);
		right2 = setup("monster\\boss right 2",gp.tileSize,gp.tileSize);
	}
	public void getAttackImage() {
		attackDown1 = setup("monster\\boss down atk 1",gp.tileSize,gp.tileSize*2);
    	attackDown2 = setup("monster\\boss down atk 2",gp.tileSize,gp.tileSize*2);
    	attackUp1 = setup("monster\\boss up atk 1",gp.tileSize,gp.tileSize*2);
    	attackUp2 = setup("monster\\boss up atk 2",gp.tileSize,gp.tileSize*2);
    	attackRight1 = setup("monster\\boss right atk 1",gp.tileSize*2,gp.tileSize);
    	attackRight2 = setup("monster\\boss right atk 2",gp.tileSize*2,gp.tileSize);
    	attackLeft1 = setup("monster\\boss left atk 1",gp.tileSize*2,gp.tileSize);
    	attackLeft2 = setup("monster\\boss left atk 2",gp.tileSize*2,gp.tileSize);
	}
	public void setAction() {

		
		if(onPath == true) {
			
			//CHECK if IT STOPS CHASING
			checkStopChasingOrNot(gp.player, 15,100);
			
			//SEARCH THE DIRECTION TO G0
    		searchPath(getGoalCol(gp.player),getGoalRow(gp.player));
    		
    		
		}
		else {
			
			//CHECK IF IT STARTS CHASING
			checkStartChasingOrNot(gp.player, 5, 100);
			
			//GET RANDOM DIRECTION 
			getRandomDirection(120);
		}
		
		//CHECK ATTACK OR NOT
		if(attacking == false) {
			
			checkAttackOrNot(30, gp.tileSize*4, gp.tileSize);
		}
	}

	public void damageReaction() {
		
		actionLookCounter = 0;
//		direction = gp.player.direction;
		onPath = true; 
	}
	public void checkDrop() {
		
		dropItem(new OBJ_Key(gp));
		
	}
}
