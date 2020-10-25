

public class Projectile {
	
	public static int evaluateAtX (int x, int x1, int y1, int x2, int y2)
	{
		double slope = (y2 - y1)/(x2 - x1);
		int yIntercept = (int) (y2 - slope*x1);
		
		int y = (int)(slope * x + yIntercept);
		
		return y;
	}

}
