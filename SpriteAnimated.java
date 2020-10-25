
//extends: will have all features of sprite

import java.awt.*;

public class SpriteAnimated extends Sprite 
{
	Animation[] animation;
	
	String[] pose = {"up", "dn", "lt", "rt"};
	
	public SpriteAnimated(int x, int y, String name, int count, int size)
	{
		//call to super class is call to Sprite class constructor
		super(x, y, 0, 0);
		
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
			g.drawImage(animation[dir].currentImage(), x, y, null);
		}
		else
		{
			g.drawImage(animation[dir].staticImage(), x, y, null);
		}
		moving = false;
		
	}
	
	
}
