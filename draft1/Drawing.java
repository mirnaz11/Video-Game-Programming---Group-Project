package draft1;



import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Drawing extends Applet implements KeyListener, Runnable {
	
	Image offScreen;

	Graphics offScreen_g;
	
	int count = 10;
	boolean slide = false;
	Track track = new Track();
	Car car = new Car();
	
	boolean[] pressed = new boolean[256];
	
	
	
	BigRamp bigRamp;
	
	
	SmallRamp ramp = BigRamp.ramp;
	
	
	
	
	public void init()
	{
		offScreen = createImage(1500, 700);
		offScreen_g = offScreen.getGraphics();
		
		requestFocus();
		addKeyListener(this);
		
		Thread t = new Thread(this);
		t.start();
		
		 
		
		
	}

	public void run() {
		
		while(true)
		{	
			//if(BigRamp.check(car.x_Rect) == true)
				//if(BigRamp.create == true)
					
			BigRamp.BigRamp(car.x_Rect, car.y_Rect);
			ramp = BigRamp.ramp;
			
			System.out.println("car.x_Rect           "+ car.x_Rect );
/*	
			if(car.x_Rect < 400)
			{
				x1 = 400;
				y1 = 500;
				x2 = 600;
				y2 = 400;
				
				small = true;
				
				repaint();
			}

			
			 if(car.x_Rect < 700 && car.x_Rect > 600)
			{
				x1 = 700;
				y1 = 500;
				x2 = 900;
				y2 = 400;
				
				small = false;
				
				repaint();
			}
			else
			{
				x1 = 700;
				y1 = 500;
				x2 = 900;
				y2 = 400;
				
				small = true;
				
			}
	*/
			//ramp = new BigRamp(x1, y1, x2, y2, small);
			
			if(pressed[KeyEvent.VK_RIGHT])  
			{
				//if(car.isFlying == false)
					car.moveForwardBy(6);
				
			}
				
			if(pressed[KeyEvent.VK_LEFT])    car.moveBackwardBy(3);
			
			if(!pressed[KeyEvent.VK_RIGHT] && !pressed[KeyEvent.VK_LEFT] && count != 0) 
			{	
				
				car.slide(ramp, count);
				count--;
				
			}
			
			if(!pressed[KeyEvent.VK_RIGHT] && !pressed[KeyEvent.VK_LEFT] && count == 0)
			{
				if(((car.x_Rect + 60) > SmallRamp.x1 ) && ((car.x_Rect + 60) < SmallRamp.x2))
					car.moveBackwardBy(2);
			}
			
			
			
			repaint();
			
			try{
				Thread.sleep(16);
			}
			catch(Exception x){};
		}
	}
	
	//BigRamp ramp = new BigRamp(x1, y1, x2, y2, small);
	
	public void position()
	{
		
	}
	boolean movingDown = false;
	
	public void paint(Graphics g)
	{
		track.draw(g);
		car.draw(g);
		ramp.draw(g);
		System.out.println("ramp.x1: "+SmallRamp.x1);
		//bigRamp.draw(g);
		
		
		//System.out.println(ramp.x2 < (car.x_Rect + 60));
		//System.out.println(car.hasCollidedWith(ramp));
		
		if(ramp.hasCollidedWith(car))
		{		 
			if(SmallRamp.y2 > SmallRamp.y1)
			{
				car.downRamp(ramp);
				movingDown = true;
			}
			else
				car.upRamp(ramp);
			
			
		 }
		else if ((SmallRamp.x2 < (car.x_Rect + 60) || ((car.y_Rect + 20) < 500)) && movingDown == false) // since your changing ramp all the time
			// this thing is not being entered
		{
			car.projectileMotion();
		}
		
	}
	
public void positionWithRespectToRamps(){
		
		
}
/*	
	public void update(Graphics g)
	   {
		  offScreen_g.clearRect(0, 0, 1500, 700);
		  
	      paint(offScreen_g);

	      g.drawImage(offScreen, 0, 0, this);
	   }


	public void repaint()
	   {
	      Graphics g = getGraphics();

	      if(g == null);
	      else
	      {
	    	  update(g);

	    	  g.dispose();
	      }
	   }
*/
				
/*
				double slope = (double)(ramp.y1 - ramp.y2)/(double)(ramp.x2 - ramp.x1); 
				System.out.println("slope: "+slope);
				car.y_Rect =(int) (car.y_Rect + slope + (1/2)*(-10));
				System.out.println("x_Rect2: "+ car.x_Rect);
				System.out.println("y_Rect2: "+ car.y_Rect + " " + slope);
/*
			for(int i = 1; car.y_Rect < 500; i+=3)
			{
				int y;
				y = Projectile.evaluateAtX(ramp.x2 + i, ramp.x1, ramp.y1, ramp.x2, ramp.y2);
				System.out.println("Y: "+y );
				car.y_Rect += 500 - y;
				car.draw(g);
				System.out.println("x_Rect2: "+ car.x_Rect);
				System.out.println("y_Rect2: "+ car.y_Rect);
				
			}
*/				//car.projectileMotion(ramp);
				
			
		
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
			pressed[e.getKeyCode()] = true;
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		pressed[e.getKeyCode()] = false;
		
		if(ramp.hasCollidedWith(car) && count == 0 )
		{
			count+=10;
			
		}
		
		//if(ramp.distanceTo(car.x_Rect , car.y_Rect + 20) <= 60)
		//	car.slide(ramp);
		
		
				
				
				
			}
/*
			for(int i = 10; i!=0 && car.x_Rect < 400; i -= 2 )
			{
				car.moveBackwardBy(i);
				
				int adj = (int)(60 - dist);
				car.x_Rect += adj*ramp.unitVectorY;
				car.y_Rect -= adj*ramp.unitVectorX;
				repaint();
			}
*/	
				//}
				
				//car.moveBackwardBy((car.x_Rect + 60) - ramp.x1);
			
			
		
		//System.out.println("get: "+e.getKeyCode()+" key: "+KeyEvent.VK_LEFT);
	//}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
