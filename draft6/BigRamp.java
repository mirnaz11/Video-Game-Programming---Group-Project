package draft6;




import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;



 public  class  BigRamp {
	
	
	//first ramp
	static int x1 = 420;//470
	static int y1 = 480;//
	
	static int x2 = 670;//720
	static int y2 = 350;//
	
	//second ramp part 1
	static int x3 = x1 + 900;//+650
	static int y3 = y1;
	
	static int x4 = x2 + 770;//770
	static int y4 = y2 ;
	
	// part 2
	
	static int x5 = x4 + 50;
	static int y5 = y4 - 101;
	
	// part 3
	
	static int x6 = x5 + 85;//85
	static int y6 = y5 ;
	
	//part 4
	
	static int x7 = x6 + 95;//x7 = x6 +95
	static int y7 = y3 ;
	
	// third Ramp
	
	static int x8 = x3 + 780;
	static int y8 = y3;
	
	static int x9 = x4 + 810;
	static int y9 = y4 + 40; 
	
	// fourth Ramp
	
	static int x10 = x9 + 100;
	static int y10 = y9 - 40;
	
	static int x11 = x10 + 90;
	static int y11 = y10 + 20;
	
	static int x12 = x11 + 50;
	static int y12 = y8;
	
	// fifth Ramp
	
	//part 1
	static int x13 = x10 + 900;
	static int y13 = y12;
	
	static int x14 = x13 + 100;
	static int y14 = y13 - 100;
	
	//part 2
	static int x15 = x14 + 70;
	static int y15 = y14 - 120;
	
	//part 3
	static int x16 = x15 + 160;
	static int y16 = y13;
	
	static int x17 = x16 - 50;
	static int y17 = y15;
	
	static int x18 = x17 + 500;
	static int y18 = y17;
	
	static Image ramp1;
	static Image ramp2;
	static Image ramp3;
	static Image ramp4;
	static Image ramp5;
	
	static boolean create1 = true;
	static boolean create2 = true;
	static boolean create3 = true;
	static boolean create4 = true;
	static boolean create5 = true;
	static boolean create6 = true;
	static boolean create7 = true;
	static boolean create8 = true;
	static boolean create9 = true;
	static boolean create10 = true;
	static boolean create11 = true;
	
	static SmallRamp ramp;
	//SmallRamp ramp1;
	//SmallRamp ramp2;
	//SmallRamp ramp3;
	//SmallRamp ramp4;
	
	static boolean projectile = false;
 
	
	
	public  static void BigRamp(MotorCycle motor)
	{
		ramp1 = Toolkit.getDefaultToolkit().getImage("r1.png");
		ramp2 = Toolkit.getDefaultToolkit().getImage("r2.png");
		ramp3 = Toolkit.getDefaultToolkit().getImage("r3.png");
		ramp4 = Toolkit.getDefaultToolkit().getImage("r4.png");
		ramp5 = Toolkit.getDefaultToolkit().getImage("r6.png");
		
				
		if(((motor.frontWheel.x + motor.frontWheel.r )<= (x1 - 5)) /*
				|| (((motor.backWheel.x + motor.backWheel.r )>= (x2 + 5)) */
						//&& ((motor.frontWheel.x + motor.frontWheel.r )<= (x3 - 10))
							&& create1 == true ) //(x_Rect + 60)< (x1 - 5)
		{
			projectile = true;
			ramp = new SmallRamp(x1, y1, x2, y2);
			System.out.println(" 																	I am in first");
			create1 = false;
			motor.theta1 = 60;
/*			
			if(((motor.frontWheel.x + motor.frontWheel.r ) >= (x1 - 10))
					&& ((motor.frontWheel.x + motor.frontWheel.r ) <= (x1)))
					
					projectile = true;*/
		}
		//else if((x_Rect + 60) > (x3 - 10) && (x_Rect + 60) < (x4 - 10) && create2 == true)
		else if((((motor.frontWheel.x + motor.frontWheel.r ) > (x3 - 10)) 
				&& ((motor.frontWheel.x + motor.frontWheel.r) <= (x4 - 10)))/*
					|| ((motor.frontWheel.x + motor.frontWheel.r )<=(x4 + 10)
							&& (motor.frontWheel.x + motor.frontWheel.r)>=(x4 - 10) )*/
								&& create2 == true)
		{
			projectile = false;
			ramp = new SmallRamp(x3, y3, x4, y4);
			System.out.println("                                 								  I am in second");
			create2 = false;
		/*	
			if(((motor.frontWheel.x + motor.frontWheel.r )<=(x4 + 10)
							&& (motor.frontWheel.x + motor.frontWheel.r)>(x4-10) ))
				projectile = false;*/
		}
		//else if((x_Rect + 60) > (x4 - 10) && (x_Rect + 60) < (x5 - 10) && create3 == true )
		else if((motor.frontWheel.x + motor.frontWheel.r) > (x4 - 10) 
					&& (motor.frontWheel.x + motor.frontWheel.r) <= (x5 + 5) 
						&& create3 == true )
		//else if (x_Rect > (x3) && x_Rect < (x2 + 600 + 100) )
		{
			projectile = true;
			ramp = new SmallRamp(x4, y4, x5, y5);
			System.out.println(" 															I am in third");
			create3 = false;
			motor.theta1 = 70;
		}
/*			
			if((motor.frontWheel.x + motor.frontWheel.r) > (x5 - 20) 
					&& (motor.frontWheel.x + motor.frontWheel.r) <= (x5 + 5) )
				
				projectile = true;
		}
		//else if ((x_Rect + 60 ) > (x5 - 7) && (x_Rect + 60) < (x6 - 7) && create4 == true)
*/		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x5 + 5) 
					&& (motor.frontWheel.x + motor.frontWheel.r) < (x6 - 5) 
							&& create4 == true)
		//else if (x_Rect > (x2 + 600 + 100) && x_Rect < (x2 + 600 + 200) )
		{
			projectile = true;
			ramp = new SmallRamp(x5, y5, x6, y6);
			System.out.println("									                     I am in fourth");
			create4 = false;
		}

		//else if ((x_Rect + 20) > (x6 - 7) && (x_Rect + 20) < (x7 - 7) && create5 == true)
		else if ((motor.frontWheel.x + motor.frontWheel.r) >= (x6 - 5) 
					&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x7 - 5) 
						&& create5 == true)
		//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			projectile = true;
			ramp = new SmallRamp(x6, y6, x7, y7);
			System.out.println(" 														I am in fifth");
			create5 = false;
		}
		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x8- 10) 
				&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x9 - 5) 
					&& create6 == true)
			//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			projectile = false;
			ramp = new SmallRamp(x8, y8, x9, y9);
			System.out.println(" 														I am in sixth");
			create6 = false;
		}
		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x9- 10) 
				&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x10 + 5) 
					&& create7 == true)
			//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			projectile = true;
			ramp = new SmallRamp(x9, y9, x10, y10);
			System.out.println(" 														I am in seventh");
			create7 = false;
			motor.theta1 = 45;
		}
		
		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x10 + 5) 
				&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x12 + 5)
					&& create8 == true)
			//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			projectile = true;
			ramp = new SmallRamp(x11, y11, x12, y12);
			System.out.println(" 														I am in eighth");
			create8 = false;
			
		}
		
		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x13 - 10) 
				&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x14 + 5)
					&& create9 == true)
			//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			projectile = false;
			ramp = new SmallRamp(x13, y13, x14, y14);
			System.out.println(" 														I am in nineth");
			create9 = false;
			
		}
		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x14 + 5 ) 
				&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x15 - 5)
					&& create10 == true)
			//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			projectile = true;
			ramp = new SmallRamp(x14, y14, x15, y15);
			System.out.println(" 														I am in nineth");
			create10 = false;
/*			if(motor.frontWheel.x >= x16)
			{
				ramp = new SmallRamp(x16, y16, x17, y17);
				create10 = false;
			}*/
			
		}
		
		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x15 - 5 ) 
				&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x17 +120)
					&& create10 == true)
			//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			projectile = true;
			ramp = new SmallRamp(x15, y15, x16, y16);
			System.out.println(" 														I am in nineth");
			create10 = false;
		/*
			if(motor.frontWheel.x >= x17)
			{
				System.out.println(" 														I am in tenth");
				projectile = false;
				ramp = new SmallRamp(x17, y17, x18, y18);
				create11 = false;
			}*/
			
		}
	
		
		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x17 + 120 ) 
				&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x18 + 5 )
					&& create11 == true)
			//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			
			System.out.println(" 														I am in tenth");
			
				projectile = false;
				ramp = new SmallRamp(x17, y17, x18, y18);
				create11 = false;
			
			
		}

		
		
		
/*		
		else if ((motor.frontWheel.x + motor.frontWheel.r) > (x14 + 5 ) 
				&& (motor.frontWheel.x + motor.frontWheel.r) <=  (x15 - 5)
					&& create10 == true)
			//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			projectile = true;
			ramp = new SmallRamp(x14, y14, x15, y15);
			System.out.println(" 														I am in nineth");
			create10 = false;
			
		}*/
		
		
		
			
		
		
		
		
		
		
		
	}
/*	
	public static void check(int x_Rect)
	{
		if((x_Rect< x1 )
				|| ((x_Rect + 60) > x2 && (x_Rect + 60) < x3)
				|| ((x_Rect + 60) > (x4 - 10) && (x_Rect + 60) < (x5 - 10) )
				|| ((x_Rect + 60) > (x5 - 10) && (x_Rect + 60) < (x6 - 10))
				|| ((x_Rect + 60) > (x6 - 10) && (x_Rect + 60) < (x7 - 10)))
				
				create = true;
		//return create;
	}
*/
	public void set(int x1, int y1, int x2, int y2) {
		
		/*
			bigRamp[0] = new SmallRamp(x1, y1, x2, y2);
			
			bigRamp[1] = new SmallRamp(x2, y2, x2 + 100, y2 - 200);
			bigRamp[2] = new SmallRamp(x2 + 100, y2 - 200, x2 + 200, y2);
			bigRamp[3] = new SmallRamp(x2 + 200, y2, x1 + 600, y1);
		*/	
	
		
	}
	
	//public void draw(Graphics g)
	//{
		
		
		
		//rotateLine(20, x2 + 200, y2 + 200, 0, 0);
		//rotateLine(10, x1, y1, x2, y2);
		
		//g.drawLine(xBottom, yBottom, xTop, yTop);
		//rotateLine(30, x1, y1, x2, y2);
		
		//g.drawLine(xBottom, yBottom, xTop, yTop);
		//rotateLine(40, x1, y1, x2, y2);
		
		//g.drawLine(xBottom, yBottom, xTop, yTop);
		//System.out.println("xBottom: "+xBottom+" yBottom: "+ yBottom+" xTop: "+xTop+" yTop: "+yTop);
		
		//rotateLine(90, x2, y2, x1, y1);
		//g.drawLine(xBottom, yBottom, xTop, yTop);
			
	//}
/*
	public void rotateLine(int angle, int x1, int y1, int x2, int y2 )
	{		
		xBottom = (int)(x1 * Lookup.cos[angle] - y1 * Lookup.sin[angle] + this.x1) ;
		yBottom = (int)(x1 * Lookup.sin[angle] + y1* Lookup.cos[angle]  );	
		
		xTop = (int)(x2 * Lookup.cos[angle] - y2  * Lookup.sin[angle] + this.x1);
		yTop = (int)(x2 * Lookup.sin[angle] + y2  * Lookup.cos[angle] );
		
	}
*/
	
	

}
