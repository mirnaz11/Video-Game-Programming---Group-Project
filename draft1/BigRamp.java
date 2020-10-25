package draft1;



import java.awt.Graphics;



 public  class  BigRamp {
	
	
	//first ramp
	static int x1 = 200;
	static int y1 = 500;
	
	static int x2 = 400;
	static int y2 = 400;
	
	//second ramp part 1
	static int x3 = x1 + 450;
	static int y3 = y1;
	
	static int x4 = x2 + 450;
	static int y4 = y2;
	
	// part 2
	
	static int x5 = x4 + 100;
	static int y5 = y4 - 200;
	
	// part 3
	
	static int x6 = x5 + 100;
	static int y6 = y4;
	
	//part 4
	
	static int x7 = x6 + 200;
	static int y7 = y3;
	
	
	static boolean create1 = true;
	static boolean create2 = true;
	static boolean create3 = true;
	static boolean create4 = true;
	static boolean create5 = true;
	
	static SmallRamp ramp;
	//SmallRamp ramp1;
	//SmallRamp ramp2;
	//SmallRamp ramp3;
	//SmallRamp ramp4;
	
	
	public  static void BigRamp(int x_Rect, int y_Rect)
	{
		
		
		
		
		if((x_Rect + 60)< (x1 - 5) && create1 == true )
		{
			ramp = new SmallRamp(x1, y1, x2, y2);
			System.out.println(" I am in first");
			create1 = false;
		}

		else if((x_Rect + 60) > (x3 - 10) && (x_Rect + 60) < (x4 - 10) && create2 == true)
		{
			ramp = new SmallRamp(x3, y3, x4, y4);
			System.out.println("                                   I am in second");
			create2 = false;
		}
		
		else if((x_Rect + 60) > (x4 - 10) && (x_Rect + 60) < (x5 - 10) && create3 == true )
		//else if (x_Rect > (x3) && x_Rect < (x2 + 600 + 100) )
		{
			ramp = new SmallRamp(x4, y4, x5, y5);
			System.out.println(" 									I am in third");
			create3 = false;
		}
/*
		else if ((x_Rect + 60 ) > (x5 - 7) && (x_Rect + 60) < (x6 - 7) && create4 == true)
		//else if (x_Rect > (x2 + 600 + 100) && x_Rect < (x2 + 600 + 200) )
		{
			ramp = new SmallRamp(x5, y5, x6, y6);
			System.out.println("									 I am in fourth");
			create4 = false;
		}
		else if ((x_Rect + 20) > (x6 - 7) && (x_Rect + 20) < (x7 - 7) && create5 == true)
		//else if(x_Rect > (x2 + 600 + 200) && x_Rect < (x1 + 600 + 600))
		{
			ramp = new SmallRamp(x6, y6, x7, y7);
			System.out.println(" 											I am in fifth");
			create5 = false;
		}
*/
		
		
			
		
		
		
		
		
		
		
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
