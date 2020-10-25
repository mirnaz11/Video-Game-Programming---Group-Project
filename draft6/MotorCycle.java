package draft6;
//This should be a sprite


import java.awt.*;

public class MotorCycle {

	Circle frontWheel;
	Circle backWheel;

	Image image;
	
	int mx= 0;// mx is the co-ordinate for motorcyle
	int my = 380;//380
	int w = 99;
	int h = 106;
	
	boolean moving = false;

	int dvx;
	int dvy;
	
	 int dir = RT;
	
	 final static int RT = 0;
	 final static int UP = 1;
	  final static int DN = 2;
	  
	   
	   

	// int theta =60;
	 int theta1 = 60;
	// static int theta2 = 60;

	double ay = 9.8;

	public MotorCycle(String filename,int mx,int my) {
		this.mx =mx;
		this.my = my;
		this.image = Toolkit.getDefaultToolkit().getImage(filename);

		frontWheel = new Circle(78 , 470, 10, 0);
		backWheel = new Circle(20, 470, 10, 0);

	}

	public void moveUpBy()
	   {
	      //frontWheel.y -= dy;
	     // backWheel.y -= dy;
	     // my -= dy;
	      
	      dir = UP;
	      
	     

	      moving = true;
	   }

	   public void moveDownBy()
	   {
	      //frontWheel.y += dy;
	    //  backWheel.y += dy;
	      
	    //  my += dy;
	      
	      dir = DN;

	   

	      moving = true;
	   }
	public void moveForwardBy(int dx) {
		System.out.println("    " + isFlying);
		if (isFlying == false) {
			frontWheel.x += dx;
			backWheel.x += dx;
			mx+=dx;
			
			dir = RT;
			
			moving = true;
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
				
				dir = RT;
				moving = true;
			} else {
				mx -= dx;
				
				frontWheel.x -= dx;
				backWheel.x -= dx;
				
				dir = RT;
				moving = true;
			}

		}
	}

	/*
	public void draw(Graphics g) {
		g.drawImage(image,mx - (Camera.x), my, w, h,null);
//		if (Camera.x == mx - 480){
//			Camera.x = 480;
//		}
		System.out.println("                                         this is draw motor    mx: "+ mx+" "+my);
		//frontWheel.x = frontWheel.x - (Camera.x );
		//backWheel.x = backWheel.x - (Camera.x );
		frontWheel.draw(g);
		backWheel.draw(g);
		//g.setColor(new Color(255,))

	}*/

	
	boolean isFallingDown = false;
	boolean isFlying = false;

	// int theta = 0;
	static int v0;

	public void projectileMotion() {
		if ((frontWheel.y + frontWheel.r) < 480) {

			System.out.println("IS FALLING DOWN:"+ isFallingDown);
			
			if (theta1 > 359)
				theta1 = 0;

			double v0x = v0 * Math.abs(Lookup.cos[theta1]);//v0 = 10
			double v0y = v0 * Math.abs(Lookup.sin[theta1]) ;//v0 = 7
			if (theta1 >= 6 && isFallingDown == false)// && theta2 >= 6
			{
				moveUpBy();
				
				
				System.out.println("theta1" + theta1);

				isFlying = true;
				mx = (int) (mx + Math.ceil(v0x)) ;
				my = (int) (my - Math.ceil(v0y)) ;
				
				
				
				frontWheel.x = (int) (frontWheel.x + (Math.ceil(v0x)));
				frontWheel.y = (int) (frontWheel.y - (Math.ceil(v0y)));

				backWheel.x = (int) (backWheel.x + (Math.ceil(v0x)));
				backWheel.y = (int) (backWheel.y - (Math.ceil(v0y)));
				
				
				
				theta1 -= 3;
				if (theta1 < 0)
					theta1 *= (-1);
				
				System.out.println("theta1: " + theta1);
				System.out.println("flying1:" + isFlying + isFallingDown);

			} else {
				
				moveDownBy();
				isFallingDown = true;
					
				frontWheel.x = (int)(frontWheel.x + ((Math.ceil(v0x)/2)) );					
				frontWheel.y = (int)(frontWheel.y + (Math.ceil(v0y) ));
				
				backWheel.x = (int)(backWheel.x + ((Math.ceil(v0x)/2) ));					
				backWheel.y = (int)(backWheel.y + (Math.ceil(v0y)));
				
				mx = (int)(mx + ((Math.ceil(v0x)/2)) );					
				my = (int)(my + (Math.ceil(v0y) )) ;
				
			
				
				theta1 +=1;
					
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
		if((frontWheel.y + frontWheel.r) < 480 && SmallRamp.y1 != SmallRamp.y2)
		{
			moveDownBy();
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
				moveDownBy();
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
	{	System.out.println("         condition for final Ramp: "+ (SmallRamp.y1 == SmallRamp.y2));
		double dist = ramp.distanceTo(frontWheel.x , frontWheel.y );
		if(((SmallRamp.y2 ) < frontWheel.y ) && ((SmallRamp.x2)  > frontWheel.x))
		{//double adj = car.x_Rect - ramp.distanceTo(car.x_Rect, car.y_Rect);
			moveUpBy();
			
			System.out.println("                             I am in upRamp");
			int adj = (int)(frontWheel.r - dist);
			frontWheel.x += adj*SmallRamp.unitVectorY +2;
			System.out.println("                        adj*SmallRamp.unitVectorY up;" + adj*SmallRamp.unitVectorY);
			frontWheel.y -= adj*SmallRamp.unitVectorX +2;
			
			backWheel.x +=  adj*SmallRamp.unitVectorY +2;
			backWheel.y -=  adj*SmallRamp.unitVectorX +2;
			
			mx += adj*SmallRamp.unitVectorY + 2 ;
			my -= adj*SmallRamp.unitVectorX + 2 ;
			
			
		}
		else if (SmallRamp.y1 == SmallRamp.y2)
		{ 
			System.out.println("         condition for final Ramp: ");
			if(mx < BigRamp.x18)
			{
				isFlying = false;
				moveForwardBy(3);
			}
			else
			{

				isFallingDown = true;
				
				projectileMotion();
				
			}
		}
		
	
	}
	
	public boolean hasCollidedWith(int ox,int oy,int ow,int oh)
	{
		System.out.println("hit");
		
		return
			((mx+w >= ox) && 
			(ox + ow >= mx) &&
			(oy + oh >= my) &&
			(my+h >= oy));
	}
		
}
