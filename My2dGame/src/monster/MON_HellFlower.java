package monster;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Rock;

public class MON_HellFlower extends Entity{
	GamePanel gp;
	public MON_HellFlower(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		
		name = "MON_HellFlower";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 4;
		life  = maxLife;
		maxMana = 4;
		mana = maxMana;
		attack = 5;
		defense = 0;
		exp = 2;
		
		projectile = new OBJ_Rock(gp);
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		
	}
	
	public void getImage() {
		up1 = setup("monster\\flower hell",gp.tileSize,gp.tileSize);
		up2 = setup("monster\\flower hell 2",gp.tileSize,gp.tileSize);
		down1 = setup("monster\\flower hell",gp.tileSize,gp.tileSize);
		down2 = setup("monster\\flower hell 2",gp.tileSize,gp.tileSize);
		left1 = setup("monster\\flower hell",gp.tileSize,gp.tileSize);
		left2 = setup("monster\\flower hell 2",gp.tileSize,gp.tileSize);
		right1 = setup("monster\\flower hell",gp.tileSize,gp.tileSize);
		right2 = setup("monster\\flower hell 2",gp.tileSize,gp.tileSize);
	}
	public void setAction() {
    		checkShootOrNot(20, 30);
    		
    		getRandomDirection(10);
    		
	}
	public void update() {
		
    	if(attacking == true) {
    		attacking();
    	}
    	else {
    		setAction();
        	checkColision();
        	
         	// collision = true : entity cant move
        	if(collisionOn == false) {
        		
    			
        	}
        	
        	spriteCount+=1; //+1 frame
    	    //redraw per 10 frames 
    		
    		if(spriteCount > 24) {
    	    	if(spriteNum==1) {
    	    		spriteNum = 2;
    	    	}
    	    	else {
    				spriteNum = 1;
    			}
    	    	spriteCount = 0;
    	    }
    	
    	}

		
		if(invincible ==true) {
    		invincibleCounter++;
    		if(invincibleCounter > 40) {
    			invincible = false;
    			invincibleCounter = 0;
    		}
    	}
    	if(shotAvailableCount < 30) {
    		shotAvailableCount++;
    		
    	}
    	
    	if(offBalance == true) {
    		offBalanceCounter ++;
    		if(offBalanceCounter > 60) {
    			offBalanceCounter = 0;
    			offBalance = false;
    		}
    	}
	}
}
