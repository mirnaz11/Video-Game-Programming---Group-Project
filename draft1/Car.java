package draft1;

//This should be a sprite

import java.awt.*;

public class Car {
	
	int x_Rect;
	int y_Rect;
	
	
	int dvx;
	int dvy;
	
	//int theta =60;
	int theta1 = 60;
	int theta2 = 60;
	
	double ay = 9.8;
	
	
	public Car()
	{
		x_Rect = 0;
		y_Rect = 480;
		
	}
	
	public void moveForwardBy(int dx)
	{
		System.out.println("                                           " +isFlying);
		if(isFlying == false  )
		{
			x_Rect += dx;
			
		}
		
	}
	
	public void moveBackwardBy(int dx)
	{
		
		if(isFlying == false && (y_Rect + 20) < 500 )
		{
			x_Rect -= dx;
			
		}
	}

	public void draw(Graphics g)
	{
		g.drawRect(x_Rect, y_Rect, 60, 20);
		
			
	}
	
	
	
	boolean slide;
	public void slide (SmallRamp ramp, int count)
	{
		
		
			//double dist = ramp.distanceTo(x_Rect , y_Rect - 20);
			if(ramp.hasCollidedWith(this))
			{//double adj = car.x_Rect - ramp.distanceTo(car.x_Rect, car.y_Rect);
				
					moveForwardBy(5);
				//int adj = (int)(60 - dist);
				//x_Rect += adj*ramp.unitVectorY;
				//y_Rect -= adj*ramp.unitVectorX;
			
		}
/*
		else if(count == 0)
		{
			slide = false;
			if((x_Rect > ramp.x1 - 20))
				moveBackwardBy(5);
		}
*/	
				
	}
		
		//slide = false;
	
	boolean isFallingDown = false;
	boolean isFlying = false;
	
	public void projectileMotion()
	{			
		if(y_Rect + 20 < 500)
		{
				
				
			//if(theta1 > 90 && theta1 < 180) theta1 += 180;
			//else if (theta1 >= 180 && theta1 < 270) theta1 -= 180;
				
			//if(theta2 >= 180 && theta1 < 360) theta1 -= 180;
			if(theta1 > 359) theta1 = 0;
			if(theta2 > 359) theta2 = 0;
				
			if(theta1 > 90 && theta1 < 270) Lookup.cos[theta1] *= (-1);
			if(theta2 > 180 && theta2 < 360) Lookup.sin[theta1] *= (-1);			
				
			double v0x = 5*Lookup.cos[theta1]; 
			double v0y = 5*Lookup.sin[theta2];
			if(  theta1 >= 5 && theta2 >= 5 && isFallingDown == false )
			{
				System.out.println("theta1" +theta1 + " theta2:"+theta2);
				
				
				isFlying = true;
				x_Rect = (int)(x_Rect + Math.ceil(v0x));
				y_Rect = (int)(y_Rect - Math.ceil(v0y));
				theta1 -= 3;
				if(theta1 <0 ) theta1 *= (-1);
				theta2 -= 3;
				if(theta2 <0 ) theta2 *= (-1);
				//System.out.println("x_Rect2: "+ x_Rect);
				//System.out.println("y_Rect2: "+ y_Rect);
				System.out.println("theta1: "+ theta1);
				System.out.println("theta2: "+ theta2);
				System.out.println("flying1:                "+isFlying + isFallingDown);
					
			}
			else 
			{
				isFallingDown = true;
					
				x_Rect = (int)(x_Rect + Math.ceil(v0x));
					
				y_Rect = (int)(y_Rect + Math.ceil(v0y) );
				theta1 += 3;
					
				theta2 += 3;
				//if(theta2 > 90) theta2 = 1;
				//System.out.println("x_Rect2': "+ x_Rect);
				//System.out.println("y_Rect2': "+ y_Rect);
				//System.out.println("theta1: "+ theta1);
				//System.out.println("theta2: "+ theta2);
				System.out.println("flying2:                "+isFlying);
					
			}
		}
		
		else
		{
		
/*
		int dy = ramp.y1 - ramp.y2;
		  //x = x0 + vix*t + ax * t^2 where ax =0
		y_Rect = y_Rect + dy + (int)9.8/2; 
*/
			isFlying = false;// we surely need this
			isFallingDown = false;// I don't think we need this here
		}
		
	}
	
	public void downRamp(SmallRamp ramp)
	{
		double dist = ramp.distanceTo(x_Rect , y_Rect - 20);
	    if((SmallRamp.y2 > y_Rect + 20) ) //&& (SmallRamp.x2  > x_Rect)
		{//double adj = car.x_Rect - ramp.distanceTo(car.x_Rect, car.y_Rect);
					
			int adj = (int)(60 - dist);
			x_Rect += adj*SmallRamp.unitVectorY;
			y_Rect -= adj*SmallRamp.unitVectorX;
			//System.out.println("x_Rect1: "+ car.x_Rect);
			//System.out.println("y_Rect1: "+ car.y_Rect);
			//car.isFlying = false;
				
			
		}
	}
	
	public void upRamp(SmallRamp ramp)
	{
		double dist = ramp.distanceTo(x_Rect , y_Rect - 20);
		if((SmallRamp.y2 < y_Rect + 20) && (SmallRamp.x2 > x_Rect))
		{//double adj = car.x_Rect - ramp.distanceTo(car.x_Rect, car.y_Rect);
			
			int adj = (int)(60 - dist);
			x_Rect += adj*SmallRamp.unitVectorY;
			y_Rect -= adj*SmallRamp.unitVectorX;
			//System.out.println("x_Rect1: "+ car.x_Rect);
			//System.out.println("y_Rect1: "+ car.y_Rect);
			//car.isFlying = false;
		}
	}
		
		
		
			
		
		
		
}
