//This should be a sprite
package draft3;

import java.awt.*;

public class MotorCycle {
	
	Circle frontWheel;
	Circle backWheel;  
	
	Image image;
	
	
	int dvx;
	int dvy;
	
	//int theta =60;
	static int theta1 = 60;
	//static int theta2 = 60;
	
	double ay = 9.8;
	
	
	public MotorCycle(String filename)
	{
		this.image = Toolkit.getDefaultToolkit().getImage(filename);
		
		frontWheel= new Circle(80, 470, 10, 0);
		backWheel = new Circle(20, 470, 10, 0);


		
	}
	
	public void moveForwardBy(int dx)
	{
		System.out.println("                                           " +isFlying);
		if(isFlying == false  )
		{
			frontWheel.x += dx;
			backWheel.x  += dx;
			
		}
		// thinking to do an else 
		// x_Rect -= dx/2;
		
	}
	
	public void moveBackwardBy(int dx)
	{
		
			
		if(isFlying == false )// && (frontWheel.y + frontWheel.r) <= 380 )
		{
			if(backWheel.x >  SmallRamp.x2 && backWheel.x < SmallRamp.x2 + 5)
			{
				frontWheel.x -= 0;
				backWheel.y -= 0;
			}
			else
			{
				frontWheel.x -= dx;
				backWheel.x  -= dx;
			}
			
			
		}
	}

	public void draw(Graphics g)
	{
		
		
			frontWheel.draw(g);
			backWheel.draw(g);
		
			
		g.drawImage(image, 0, 380, null);
			
	}
	
	
/*	
	boolean slide;
	public void slideup (SmallRamp ramp, int count)
	{
		
		
			//double dist = ramp.distanceTo(x_Rect , y_Rect - 20);
			if(ramp.hasCollidedWith(this))
			{//double adj = car.x_Rect - ramp.distanceTo(car.x_Rect, car.y_Rect);
				
					moveForwardBy(5);
				//int adj = (int)(60 - dist);
				//x_Rect += adj*ramp.unitVectorY;
				//y_Rect -= adj*ramp.unitVectorX;
			
			}
	}
	
	public void slidedown (SmallRamp ramp)
	{
		if(ramp.hasCollidedWith(this))
			downRamp(ramp);
		
			//moveBackwardBy(5);
		
		
	
	}
*/
/*
		else if(count == 0)
		{
			slide = false;
			if((x_Rect > ramp.x1 - 20))
				moveBackwardBy(5);
		}
*/	
				
	
		
		//slide = false;
	
	boolean isFallingDown = false;
	boolean isFlying = false;
	//int theta = 0;
	
	public void projectileMotion()
	{			
		if((frontWheel.y + frontWheel.r) < 480)
		{
				
				System.out.println("                                   IS FALLING DOWN:" + isFallingDown);												
			//if(theta1 > 90 && theta1 < 180) theta1 += 180;
			//else if (theta1 >= 180 && theta1 < 270) theta1 -= 180;
				
			//if(theta2 >= 180 && theta1 < 360) theta1 -= 180;
			if(theta1 > 359) theta1 = 0;
			//if(theta2 > 359) theta2 = 0;
				
			//if(theta1 > 90 && theta1 < 270) Lookup.cos[theta1] *= (-1);
			//if(theta2 > 180 && theta2 < 360) Lookup.sin[theta1] *= (-1);			
				
			double v0x = 8*Math.abs(Lookup.cos[theta1]); 
			double v0y = 8*Math.abs(Lookup.sin[theta1]);
			if(  theta1 >= 6  && isFallingDown == false )//&& theta2 >= 6
			{
				System.out.println("theta1" +theta1);
				
				
				isFlying = true;
				frontWheel.x = (int)(frontWheel.x + (Math.ceil(v0x) ));
				frontWheel.y = (int)(frontWheel.y -( Math.ceil(v0y) ));
				
				backWheel.x = (int)(backWheel.x + (Math.ceil(v0x) ));
				backWheel.y = (int)(backWheel.y - (Math.ceil(v0y)));
				theta1 -= 3;
				if(theta1 <0 ) theta1 *= (-1);
				//theta2 -= 3;
			//	if(theta2 <0 ) theta2 *= (-1);
				//System.out.println("x_Rect2: "+ x_Rect);
				//System.out.println("y_Rect2: "+ y_Rect);
				System.out.println("theta1: "+ theta1);
				//System.out.println("theta2: "+ theta2);
				System.out.println("flying1:                "+isFlying + isFallingDown);
					
			}
			else 
			{
/*
				if(BigRamp.create10 == false)
				{
					if(theta > 359) theta = 0;
					//if( theta >= 270 || theta < 360)
					{
						frontWheel.x = SmallRamp.x2 + (int) ( 20*Lookup.cos[theta]);					
						frontWheel.y = SmallRamp.y2 - 20 + (int) (20*Lookup.sin[theta]);
					
						backWheel.x = SmallRamp.x2 + (int) ( 20*Lookup.cos[theta]);				
						backWheel.y = SmallRamp.y2 - 20 + (int) (20* Lookup.sin[theta]) ;
					}
/*					else if (theta >= 0 || theta < 90)
					{
						frontWheel.x = SmallRamp.x2 + (int) ( Math.abs(Lookup.cos[theta]));					
						frontWheel.y = SmallRamp.y2 - 20 + (int) ( Math.abs(Lookup.sin[theta])) ;
					
						backWheel.x = SmallRamp.x2 + (int) ( Math.abs(Lookup.cos[theta]));			
						backWheel.y =SmallRamp.y2 - 20 + (int) ( Math.abs(Lookup.sin[theta])) ;
					}
					else if (theta >= 90 || theta < 180)
					{
						frontWheel.x = SmallRamp.x2 + (int) (10* Math.abs(Lookup.cos[theta]));					
						frontWheel.y = SmallRamp.y2 - 20 + (int) (10* Math.abs(Lookup.sin[theta])) ;
					
						backWheel.x = SmallRamp.x2 + (int) (10* Math.abs(Lookup.cos[theta]));			
						backWheel.y = SmallRamp.y2 - 20 + (int) (10* Math.abs(Lookup.sin[theta])) ;
					}
					else if (theta >= 180 || theta < 270)
					{
						frontWheel.x =SmallRamp.x2 + (int) (10* Math.abs(Lookup.cos[theta]));				
						frontWheel.y = SmallRamp.y2 - 20 + (int) (10* Math.abs(Lookup.sin[theta])) ;
					
						backWheel.x =SmallRamp.x2 + (int) (10* Math.abs(Lookup.cos[theta]));			
						backWheel.y = SmallRamp.y2 - 20 + (int) (10* Math.abs(Lookup.sin[theta])) ;
					}
					theta += 5;

					
					
				}
*/
				isFallingDown = true;
					
				frontWheel.x = (int)(frontWheel.x + ((Math.ceil(v0x)/2)) );					
				frontWheel.y = (int)(frontWheel.y + (Math.ceil(v0y) ));
				
				backWheel.x = (int)(backWheel.x + ((Math.ceil(v0x)/2) ));					
				backWheel.y = (int)(backWheel.y + (Math.ceil(v0y)));
				theta1 += 2;
					
				//theta2 += 2;
				//if(theta2 > 90) theta2 = 1;
				//System.out.println("x_Rect2': "+ x_Rect);
				//System.out.println("y_Rect2': "+ y_Rect);
				System.out.println("theta1: "+ theta1);
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
		if((frontWheel.y + frontWheel.r) < 480)
		{
			double dist = ramp.distanceTo(frontWheel.x , frontWheel.y);
			if((SmallRamp.y2 > frontWheel.y ) && (SmallRamp.x1  < frontWheel.x)) //&& SmallRamp.x2 > frontWheel.x ))
				// if((SmallRamp.y2 > frontWheel.y ) && (SmallRamp.x2  > frontWheel.x))
			{//double adj = car.x_Rect - ramp.distanceTo(car.x_Rect, car.y_Rect);
				System.out.println("                             I am in downRamp");
			
				int adj = Math.abs((int)(frontWheel.r - dist)) ;
				//if(adj < 7)
				if(ramp.y2 < ramp.y1)
				{
					frontWheel.x +=  adj*SmallRamp.unitVectorY % 2; //+ 1;// + slope*SmallRamp.unitVectorY ;// was +
					System.out.println("                        adj*SmallRamp.unitVectorY;" + adj*SmallRamp.unitVectorY +"  adj"+adj + "SmallRamp.unitVectorX"+SmallRamp.unitVectorX);
					frontWheel.y += adj*SmallRamp.unitVectorX + SmallRamp.unitVectorX ;// was -
			
					backWheel.x += adj*SmallRamp.unitVectorY % 2;//+1;//slope*SmallRamp.unitVectorY;
					backWheel.y += adj*SmallRamp.unitVectorX +  SmallRamp.unitVectorX ;
				}
			}
			else if((SmallRamp.y2 < frontWheel.y ) && (SmallRamp.x1  < frontWheel.x))
				{
				if((frontWheel.x )<=(BigRamp.x4 + 50))
					BigRamp.create2 = true;
				int adj = Math.abs((int)(frontWheel.r - dist)) ;
					frontWheel.x -=  adj*SmallRamp.unitVectorY + 2; //+ 1;// + slope*SmallRamp.unitVectorY ;// was +
					System.out.println("                        adj*SmallRamp.unitVectorY;" + adj*SmallRamp.unitVectorY +"  adj"+adj + "SmallRamp.unitVectorX"+SmallRamp.unitVectorX);
					frontWheel.y += adj*SmallRamp.unitVectorX + SmallRamp.unitVectorX ;// was -
			
					backWheel.x -= adj*SmallRamp.unitVectorY + 2;//+1;//slope*SmallRamp.unitVectorY;
					backWheel.y += adj*SmallRamp.unitVectorX +  SmallRamp.unitVectorX ;
					
					BigRamp.create3 = true;
				}
			}
/*
			else
			{
				frontWheel.x +=  adj*SmallRamp.unitVectorY % 7;  //+ 2*adj;// + slope*SmallRamp.unitVectorY ;// was +
				System.out.println("                        adj*SmallRamp.unitVectorY;" + adj*SmallRamp.unitVectorY +"  adj"+adj + "SmallRamp.unitVectorX"+adj*SmallRamp.unitVectorX);
				frontWheel.y += adj*SmallRamp.unitVectorX + SmallRamp.unitVectorX ;// was -
				
				backWheel.x += adj*SmallRamp.unitVectorY % 7;// + 2*adj;//slope*SmallRamp.unitVectorY;
				backWheel.y += adj*SmallRamp.unitVectorX +  SmallRamp.unitVectorX ;
			}
			
/*
 * else
			{
				frontWheel.x +=  adj*SmallRamp.unitVectorY  + 2*adj;// + slope*SmallRamp.unitVectorY ;// was +
				System.out.println("                        adj*SmallRamp.unitVectorY;" + adj*SmallRamp.unitVectorY +"  adj"+adj + "SmallRamp.unitVectorX"+adj*SmallRamp.unitVectorX);
				frontWheel.y += adj*SmallRamp.unitVectorX + SmallRamp.unitVectorX ;// was -
				
				backWheel.x += adj*SmallRamp.unitVectorY  + 2*adj;//slope*SmallRamp.unitVectorY;
				backWheel.y += adj*SmallRamp.unitVectorX +  SmallRamp.unitVectorX ;
			}
 */
			//System.out.println("x_Rect1: "+ car.x_Rect);
			//System.out.println("y_Rect1: "+ car.y_Rect);
			//car.isFlying = false;
				
			
		}
	
	boolean projectile2 = false;
	public void upRamp(SmallRamp ramp)
	{
		double dist = ramp.distanceTo(frontWheel.x , frontWheel.y );
		if(((SmallRamp.y2 ) < frontWheel.y ) && ((SmallRamp.x2)  > frontWheel.x))
		{//double adj = car.x_Rect - ramp.distanceTo(car.x_Rect, car.y_Rect);
			System.out.println("                             I am in upRamp");
			int adj = (int)(frontWheel.r - dist);
			frontWheel.x += adj*SmallRamp.unitVectorY +2;
			System.out.println("                        adj*SmallRamp.unitVectorY up;" + adj*SmallRamp.unitVectorY);
			frontWheel.y -= adj*SmallRamp.unitVectorX +2;
			
			backWheel.x +=  adj*SmallRamp.unitVectorY +2;
			backWheel.y -=  adj*SmallRamp.unitVectorX +2;
			//System.out.println("x_Rect1: "+ car.x_Rect);
			//System.out.println("y_Rect1: "+ car.y_Rect);
			//car.isFlying = false;
		}
		
	
	}
		
		
		
			
		
		
		
}
