package draft6;

//extends: will have all features of sprite

import java.awt.*;

public class SpriteAnimated extends MotorCycle 
{
	Animation[] animation;
	
	String[] pose = {"rt","up", "dn"};
	
	public SpriteAnimated(int x, int y, String name, int count, int size)
	{
		//call to super class is call to Sprite class constructor
		//super(x, y, 0, 0);
		super(name, x, y);
		
		//create the array here b/c not sure how many animations will need
		animation = new Animation[size];//where does size come from? It's the # of animations
		
		for(int i = 0; i<animation.length; i++)
			animation[i] = new Animation(name+"_"+pose[i], count);
			
	}
	
	public void draw(Graphics g)
	{
		if(moving )
		{
			//draw the next or current image
			g.drawImage(animation[dir].currentImage(), mx - (Camera.x + 200), my - 100, null);
			
		}
		else
		{
			g.drawImage(animation[dir].staticImage(), mx  - (Camera.x + 200), my - 100 , null);
		}
		moving = false;
		
		//g.drawImage(image,mx - (Camera.x), my, w, h,null);
//		if (Camera.x == mx - 480){
//			Camera.x = 480;
//		}
		System.out.println("                                         this is draw motor    mx: "+ mx+" "+my);
		
		frontWheel.draw(g);
		backWheel.draw(g);
		//g.setColor(new Color(255,))
		
	}
	
	
}
