package draft1;


import java.awt.*;

public class SmallRamp {
	
	static int x1;   //These should be private, need to do the set and get methods (maybe)
	static int y1;
	
	static int x2;
	static int y2;
	
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
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		double mag = Math.sqrt(dx*dx + dy*dy); 
		
		unitVectorX = dx/mag;
		unitVectorY = dy/mag;
	}

	
	public double distanceTo(int x_Rect, int y_Rect)
	{
		return -unitVectorX * (y_Rect - y1) + unitVectorY * (x_Rect - x1);
	}
	
	public boolean hasCollidedWith (Car car)
	{
		//System.out.println(ramp.distanceTo(x_Rect , y_Rect + 20));
		if(y2 < y1)
		{
			if(car.x_Rect + 60 <= x2)
				return distanceTo(car.x_Rect , car.y_Rect + 20) <= 60; 
			else
				return false;
		}
		else
		{
			if(car.y_Rect <= y2 )
				return distanceTo(-(car.x_Rect +60), car.y_Rect + 20) <= 60; 
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
		g.drawLine(BigRamp.x1, BigRamp.y1, BigRamp.x2, BigRamp.y2);
		g.drawLine(BigRamp.x3, BigRamp.y3, BigRamp.x4, BigRamp.y4);
		g.drawLine(BigRamp.x4, BigRamp.y4, BigRamp.x5, BigRamp.y5);
		g.drawLine(BigRamp.x5,  BigRamp.y5,  BigRamp.x6,  BigRamp.y6);
		g.drawLine( BigRamp.x6,  BigRamp.y6,  BigRamp.x7,  BigRamp.y7);
/*
		g.drawLine(x1 + 400, y1, x2 +300, y2);
		g.drawLine(x2 + 300, y2, x2 + 300 + 100, y2 - 200);
		g.drawLine(x2 + 300 + 100, y2 - 200, x2 + 300 + 200, y2);
		g.drawLine(x2 + 300 + 200, y2, x1 + 300 + 600, y1);
*/
		
	}

}
