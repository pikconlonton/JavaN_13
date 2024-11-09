package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_Mana;
import object.OBJ_Rock;

public class MON_HellGhost extends Entity {
	GamePanel gp;
	public MON_HellGhost(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		
		name = "MON_HellGhost";
		defaultSpeed = 2;
		speed = defaultSpeed;
		maxLife = 7;
		life  = maxLife;
		maxMana = 4;
		mana = maxMana;
		attack = 5;
		defense = 0;
		exp = 7;
		
		projectile = new OBJ_Rock(gp);
		
		solidArea.x = 3;
		solidArea.y = 15;
		solidArea.width = 42;
		solidArea.height = 21;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	
	public void getImage() {
		up1 = setup("monster\\ma trơi up 1",gp.tileSize,gp.tileSize);
		up2 = setup("monster\\ma trơi up 2",gp.tileSize,gp.tileSize);
		down1 = setup("monster\\ma trơi 1",gp.tileSize,gp.tileSize);
		down2 = setup("monster\\ma trơi 2",gp.tileSize,gp.tileSize);
		left1 = setup("monster\\ma trơi left 1",gp.tileSize,gp.tileSize);
		left2 = setup("monster\\ma trơi left 2",gp.tileSize,gp.tileSize);
		right1 = setup("monster\\ma trơi right 1",gp.tileSize,gp.tileSize);
		right2 = setup("monster\\ma trơi right 2",gp.tileSize,gp.tileSize);
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
			//checkStartChasingOrNot(gp.player, 5, 100);
			
			//GET RANDOM DIRECTION 
			getRandomDirection(10);
		}
		
	}

	public void damageReaction() {
		
		actionLookCounter = 0;
//		direction = gp.player.direction;
		onPath = true; 
	}
	public void checkDrop() {
		//CAST A DIE
		int i = new Random().nextInt(100)+1;
		//SET THE MOSNTER DROP
		if(i < 50) {
			dropItem(new OBJ_Coin_Bronze(gp));
		}
		if(i >= 50 && i < 75) {
			dropItem(new OBJ_Heart(gp));
		}
		if(i >= 75 && i < 100) {
			dropItem(new OBJ_Mana(gp));
		}
	}
}
