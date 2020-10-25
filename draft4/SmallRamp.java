package draft4;
import java.awt.*;

public class SmallRamp {
	
	static int x1;   //These should be private, need to do the set and get methods (maybe)
	static int y1;
	
	static int x2;
	static int y2;
	
	//static int x3 = x1 - 20;
	//static int y3 = y1;
	
	//static int x4 = x2 - 20;
	//static int y4 = y2;
	
	static double unitVectorX;
	static double unitVectorY;
	
	public SmallRamp(){
		
	}

	public SmallRamp (int x1, int y1, int x2, int y2)
	{
		SmallRamp.x1 = x1;		
		SmallRamp.y1 = y1;
		SmallRamp.x2 = x2;
		SmallRamp.y2 = y2;
		 System.out.println(" x1 is: "+ x1);
		int dx = x2 - x1;//x2 - x1
		int dy = y2 - y1;
		
		double mag = Math.sqrt(dx*dx + dy*dy); 
		
		unitVectorX = dx/mag;
		unitVectorY = dy/mag;
	}

	
	public double distanceTo(int Wheelx, int Wheely)
	{	//-unitVectorX * (Wheely - y1) + unitVectorY * (Wheelx - x1);
		System.out.println("                                                distanceTo:" + (-unitVectorX * (Wheely - y1) + unitVectorY * (Wheelx - x1)));
		return -unitVectorX * (Wheely - y2) + unitVectorY * (Wheelx - x2);
	}
	
	public boolean hasCollidedWith (MotorCycle motor)
	{
		System.out.println("                                               distance:" + this.distanceTo(motor.frontWheel.x , motor.frontWheel.y));
		//NEW: Here i might need to work with backwheel as well
		if(y2 < y1)
		{
			if(motor.frontWheel.x <= x2)
			{
				System.out.println("                                                 dddddddddddddddddddddddddd hasCollidedWith:                    "+ (distanceTo(motor.frontWheel.x , motor.frontWheel.y) <= motor.frontWheel.r + 20))	;							
				return distanceTo(motor.frontWheel.x , motor.frontWheel.y) <= (motor.frontWheel.r + 20 ) ; 
			}
			else
				return false;
		}
		else
		{
			if(motor.frontWheel.x <= x2 )  //was car.y_Rect <= y2 
				return distanceTo(motor.frontWheel.x, motor.frontWheel.y) <= motor.frontWheel.r; //was -(car.x_Rect +60), car.y_Rect + 20)
			else
				return false;
		}
	}
	
	
	//public void draw (Graphics g)
	//{
		//g.drawLine(x1, y1, x2, y2);
		//System.out.println("   I am in draw" + x1);
		
//	}
	
	public void draw(Graphics g)
	{
	
		g.drawLine(BigRamp.x1 - Camera.x, BigRamp.y1, BigRamp.x2 - Camera.x, BigRamp.y2);
		g.drawLine(BigRamp.x3 - Camera.x, BigRamp.y3, BigRamp.x4 - Camera.x, BigRamp.y4);
		g.drawLine(BigRamp.x4 - Camera.x, BigRamp.y4, BigRamp.x5 - Camera.x, BigRamp.y5);
		g.drawLine(BigRamp.x5 - Camera.x, BigRamp.y5, BigRamp.x6 - Camera.x, BigRamp.y6);
		g.drawLine(BigRamp.x6 - Camera.x, BigRamp.y6, BigRamp.x7 - Camera.x, BigRamp.y7);
		g.drawLine(BigRamp.x8 - Camera.x, BigRamp.y8, BigRamp.x9 - Camera.x, BigRamp.y9);
		g.drawLine(BigRamp.x9 - Camera.x, BigRamp.y9, BigRamp.x10 - Camera.x, BigRamp.y10);
		g.drawLine(BigRamp.x11 - Camera.x, BigRamp.y11, BigRamp.x12 - Camera.x, BigRamp.y12);
		g.drawLine(BigRamp.x13 - Camera.x, BigRamp.y13, BigRamp.x14 - Camera.x, BigRamp.y14);
		g.drawLine(BigRamp.x14 - Camera.x, BigRamp.y14, BigRamp.x15 - Camera.x, BigRamp.y15);
		g.drawLine(BigRamp.x15 - Camera.x, BigRamp.y15, BigRamp.x16 - Camera.x, BigRamp.y16);
		
		g.drawImage(BigRamp.ramp1, BigRamp.x1 - 20 - Camera.x, 350 , 400 , 100 + 40 , null );
		g.drawImage(BigRamp.ramp2, BigRamp.x3 - 50 - Camera.x, 250, 400 , 200 + 40 , null );
		g.drawImage(BigRamp.ramp3, BigRamp.x8 - 5 - Camera.x, 350, 400 , 100 + 40 , null );
		g.drawImage(BigRamp.ramp4, BigRamp.x13 - 25 - Camera.x, 250, 400 , 200 + 40 , null );
		g.drawImage(BigRamp.ramp5, BigRamp.x16 - Camera.x, 250, 400, 50, null);
		
/*
		g.drawImage(BigRamp.ramp1, BigRamp.x1 - 10 - Camera.x, BigRamp.y2, (BigRamp.x2 - BigRamp.x1) - Camera.x, (BigRamp.y1 - BigRamp.y2 + 40) , null );
		g.drawImage(BigRamp.ramp2, BigRamp.x3 - 10 - Camera.x, BigRamp.y4, (BigRamp.x4 - BigRamp.x3) - Camera.x, (BigRamp.y3 - BigRamp.y4 + 40) , null );
		g.drawImage(BigRamp.ramp3, BigRamp.x1 - 10 - Camera.x, BigRamp.y2, (BigRamp.x2 - BigRamp.x1) - Camera.x, (BigRamp.y1 - BigRamp.y2 + 40) , null );
		g.drawImage(BigRamp.ramp4, BigRamp.x1 - 10 - Camera.x, BigRamp.y2, (BigRamp.x2 - BigRamp.x1) - Camera.x, (BigRamp.y1 - BigRamp.y2 + 40) , null );
		
/*
		g.drawLine(x1 + 400, y1, x2 +300, y2);
		g.drawLine(x2 + 300, y2, x2 + 300 + 100, y2 - 200);
		g.drawLine(x2 + 300 + 100, y2 - 200, x2 + 300 + 200, y2);
		g.drawLine(x2 + 300 + 200, y2, x1 + 300 + 600, y1);
*/
		
	}

}
