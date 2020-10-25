//This should be a sprite
package draft4;

import java.awt.*;

public class MotorCycle {

	Circle frontWheel;
	Circle backWheel;

	Image image;
	
	int mx= 0;// mx is the co-ordinate for motorcyle
	int my = 380;
	int w = 99;
	int h = 106;
	
	

	int dvx;
	int dvy;

	// int theta =60;
	int theta1 = 60;
	// static int theta2 = 60;

	double ay = 9.8;

	public MotorCycle(String filename,int mx,int my) {
		this.mx =mx;
		this.my = my;
		this.image = Toolkit.getDefaultToolkit().getImage(filename);

		frontWheel = new Circle(80, 470, 10, 0);
		backWheel = new Circle(20, 470, 10, 0);

	}

	public void moveForwardBy(int dx) {
		System.out.println("    " + isFlying);
		if (isFlying == false) {
			frontWheel.x += dx;
			backWheel.x += dx;
			mx+=dx;
		}

	}

	public void moveBackwardBy(int dx) {

		if (isFlying == false)// && (frontWheel.y + frontWheel.r) <= 380 )
		{
			if (backWheel.x > SmallRamp.x2 && backWheel.x < SmallRamp.x2 + 5) {
				mx -= 0;
				my -= 0;
				frontWheel.x -= 0;
				backWheel.y -= 0;
			} else {
				mx -= dx;
				
				frontWheel.x -= dx;
				backWheel.x -= dx;
			}

		}
	}

	public void draw(Graphics g) {
		g.drawImage(image,mx - Camera.x, my, w, h,null);
		frontWheel.draw(g);
		backWheel.draw(g);
		//g.setColor(new Color(255,))

	}

	
	boolean isFallingDown = false;
	boolean isFlying = false;

	// int theta = 0;
	
	int theta = 300;
	boolean finishedCircle = false;

	public void projectileMotion() {
		if ((frontWheel.y + frontWheel.r) < 480) {

			System.out.println("IS FALLING DOWN:"+ isFallingDown);
			System.out.println("                         BigRamp.create9: "+BigRamp.create9+" finishedCirlce "+finishedCircle);
			
			if (theta1 > 359)
				theta1 = 0;

			double v0x = 8 * Math.abs(Lookup.cos[theta1]);
			double v0y = 8 * Math.abs(Lookup.sin[theta1]);
			if (theta1 >= 6 && isFallingDown == false && BigRamp.create9 == true)// && theta2 >= 6
			{
				System.out.println("theta1" + theta1);

				isFlying = true;
				mx = (int) (mx + Math.ceil(v0x));
				my = (int) (my - Math.ceil(v0y));
				
				frontWheel.x = (int) (frontWheel.x + (Math.ceil(v0x)));
				frontWheel.y = (int) (frontWheel.y - (Math.ceil(v0y)));

				backWheel.x = (int) (backWheel.x + (Math.ceil(v0x)));
				backWheel.y = (int) (backWheel.y - (Math.ceil(v0y)));
				
				
				
				theta1 -= 3;
				if (theta1 < 0)
					theta1 *= (-1);
				
				System.out.println("theta1: " + theta1);
				System.out.println("flying1:" + isFlying + isFallingDown);

			} 
/*
				
				if(BigRamp.create9 == false && finishedCircle == false)
				{
					frontWheel.x =(int) (frontWheel.x*Lookup.cos[theta] - frontWheel.y*Lookup.sin[theta]);
					frontWheel.y = (int)(frontWheel.x*Lookup.cos[theta] + frontWheel.y*Lookup.cos[theta]);
					
					System.out.println("                                         frontWheel.x: in circle"+frontWheel.x);
					backWheel.x =(int) (backWheel.x*Lookup.cos[theta] - backWheel.y*Lookup.sin[theta]);
					backWheel.y = (int)(backWheel.x*Lookup.cos[theta] + backWheel.y*Lookup.cos[theta]);
					
					mx =(int) (mx*Lookup.cos[theta] - my*Lookup.sin[theta]);
					my = (int)(mx*Lookup.cos[theta] + my*Lookup.cos[theta]);
					
					theta+=2;
					if(theta > 359) theta = 0;
					if(theta > 250 && theta < 300)
						finishedCircle = true;*/
/*
								
					
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

					
					
				}*/

					
					
			else
				{

				isFallingDown = true;
					
				frontWheel.x = (int)(frontWheel.x + ((Math.ceil(v0x)/2)) );					
				frontWheel.y = (int)(frontWheel.y + (Math.ceil(v0y) ));
				
				backWheel.x = (int)(backWheel.x + ((Math.ceil(v0x)/2) ));					
				backWheel.y = (int)(backWheel.y + (Math.ceil(v0y)));
				
				mx = (int)(mx + ((Math.ceil(v0x)/2)) );					
				my = (int)(my + (Math.ceil(v0y) ));
				theta1 += 2;
					
				System.out.println("theta1: "+ theta1);
				System.out.println("flying2:"+isFlying);
				}
					
			
		}
		
		else
		{
		
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
			{//double adj = car.x_Rect - ramp.distanceTo(car.x_Rect, car.y_Rect);
				System.out.println(" I am in downRamp");
			
				int adj = Math.abs((int)(frontWheel.r - dist)) ;
				//if(adj < 7)
				if(ramp.y2 < ramp.y1)
				{
					frontWheel.x +=  adj*SmallRamp.unitVectorY % 2; //+ 1;// + slope*SmallRamp.unitVectorY ;// was +
					System.out.println("                        adj*SmallRamp.unitVectorY;" + adj*SmallRamp.unitVectorY +"  adj"+adj + "SmallRamp.unitVectorX"+SmallRamp.unitVectorX);
					frontWheel.y += adj*SmallRamp.unitVectorX + SmallRamp.unitVectorX ;// was -
			
					backWheel.x += adj*SmallRamp.unitVectorY % 2;//+1;//slope*SmallRamp.unitVectorY;
					backWheel.y += adj*SmallRamp.unitVectorX +  SmallRamp.unitVectorX ;
					
					mx += adj*SmallRamp.unitVectorY % 2;//+1;//slope*SmallRamp.unitVectorY;
					my += adj*SmallRamp.unitVectorX +  SmallRamp.unitVectorX ;
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
					
					mx -= adj*SmallRamp.unitVectorY + 2;
					my += adj*SmallRamp.unitVectorX + SmallRamp.unitVectorX ;
					
					BigRamp.create3 = true;
				}
			}
			
			
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
			mx += adj*SmallRamp.unitVectorY + 2;
			my -= adj*SmallRamp.unitVectorX + 2;
			
		}
		
	
	}
		
}
