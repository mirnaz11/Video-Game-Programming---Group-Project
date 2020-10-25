package draft3;

import java.awt.Graphics;


public class Circle 
{
	//x, y represents center of circle
	int x;
	int y;
	
	int r;
	
	//here down is up and up is down
	int angle; // =45 (in my code)
	
	

	public Circle( int x, int y, int r, int angle)
	{
		this.y = y;
		this.x = x;
		
		this.r = r;
		this.angle = angle;
		
	}
	
	//t for target x, target y
	public double distanceTo(int tx, int ty) //tx : target x value
	{	
		return (tx -x) * Lookup.sin[angle] - (ty -y) * Lookup.cos[angle];		 
		
	}
	
	
	public void draw(Graphics g)
	{
		//this x and y represent the upper left corner of bounding rectangle of oval.
		g.drawOval(x-r - Camera.x, y-r, 2*r, 2*r);
		
		//points of circle are(rcos(theta)+x), (rsin(theta)+y)
		//it draws the radius detecting the direction of the circle
		
/*
		g.drawLine
		(
			x, y, 
			x + (int)(r * Lookup.cos[angle]), // line from x(origin) to r*cos(theta)
			y + (int)(r * Lookup.sin[angle])  // and from y to r*sin(theta)
		);
*/
	}
	
	public void moveForwardBy(int dist)  // i think we don't need this
	{
		x += dist  * Math.cos(angle * Math.PI/180);
		
		y += dist * Math.sin(angle * Math.PI/180);
		
		//c.moveTo(x, y);
	}
	
	public void moveBackwardBy(int dist)
	{
		x -= dist  * Math.cos(angle * Math.PI/180);
		
		y -= dist * Math.sin(angle * Math.PI/180);
		
		//c.moveTo(x, y);
	}
	
	
	public void rotateLeftBy(int dangle)
	{
		angle -= dangle;
		
		if (angle < 0) angle = 359;
	}
	

	public void rotateRightBy(int dangle)
	{
		angle += dangle;
		
		if (angle > 359) angle = 0;
	}
	
	public boolean contains(int mx, int my)
	{
		return((x-mx) * (x-mx) + (y-my)*(y-my) < r * r);
	}
	
	public void moveTo(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	}
}
