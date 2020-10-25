package draft3;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Drawing extends Applet implements KeyListener, Runnable {
	
	Image offScreen;

	Graphics offScreen_g;
	
	Track track = new Track(0, 480, 1500, 480);
	//Track track2 = new Track(0, 385, 1500, 385);

	MotorCycle motor = new MotorCycle("m_0.png");

	boolean[] pressed = new boolean[256];

	//ImageLayer background1 = new ImageLayer("mountains.gif", 0, 0, 100);
	ImageLayer background1 = new ImageLayer("grasscopy.png", 0, 50, 0);
	//ImageLayer background2 = new ImageLayer("trees.gif", 0, 50, 1);
	//ImageLayer background2 = new ImageLayer("houses.png", 0, 0, 1);
	ImageLayer background2 = new ImageLayer("houses1.png", 0, 250, 1);
	ImageLayer background3 = new ImageLayer("houses2.png", 0, 0, 1);


	
	int count = 10;
	boolean slide = false;
	
	
	
	
	
	
	
	BigRamp bigRamp;
	
	
	SmallRamp ramp = BigRamp.ramp;
	
	
	
	
	public void init()
	{
		setSize(1500,650);//800, 500

		offScreen = createImage(1500, 700);
		offScreen_g = offScreen.getGraphics();
		
		requestFocus();
		addKeyListener(this);
		
		Thread t = new Thread(this);
		t.start();
		Camera.set(0, 0);

		 
		
		
	}

	public void run() {
		
		while(true)
		{	
			//if(BigRamp.check(car.x_Rect) == true)
				//if(BigRamp.create == true)
					
			BigRamp.BigRamp(motor);
			ramp = BigRamp.ramp;
			
			System.out.println("motor.frontWheel.x           "+ motor.frontWheel.x );

			
			//ramp = new BigRamp(x1, y1, x2, y2, small);
			
			// To move forward
			if (pressed[KeyEvent.VK_F] ) 	motor.moveForwardBy(8);
			if (pressed[KeyEvent.VK_B]) 	motor.moveBackwardBy(3);
			if (pressed[KeyEvent.VK_RIGHT])
			{
				background1.moveForwardBy(3);
				background2.moveForwardBy(2);
				background3.moveForwardBy(1);
				Camera.moveForwardBy(10);
			}
			if(pressed[KeyEvent.VK_LEFT])
				Camera.moveBackwardBy(7);
					
			if(SmallRamp.y1 == SmallRamp.y2 || (SmallRamp.y2 > SmallRamp.y1))// && motor.frontWheel.y < SmallRamp.y1 + 100)) 
			{
				motor.projectileMotion();
						
			} 
			else if(((SmallRamp.x2 + 10) >= (motor.frontWheel.x + motor.frontWheel.r) ) //
					&& (SmallRamp.x1  < motor.frontWheel.x + motor.frontWheel.r)
						|| ((motor.frontWheel.y < 480) 
							&& (SmallRamp.x1  < motor.frontWheel.x + motor.frontWheel.r) 
								&& BigRamp.projectile == false))
									
				//if(ramp.hasCollidedWith(motor))
				{		 
					System.out.println("                             cout:"+ count);		
							
					if(pressed[KeyEvent.VK_B] ) // down slide-SmallRamp.y2 > SmallRamp.y1
					{
						motor.downRamp(ramp);
								
						//movingDown = true;
						System.out.println("               I am in paint hasCollidedWith first");
					}
					else if (pressed[KeyEvent.VK_F]) 
					{
						if(SmallRamp.y2 <= SmallRamp.y1)
							motor.upRamp(ramp); // up slide
						else
						{
							motor.downRamp(ramp);
							
						}
								
					System.out.println("               I am in paint hasCollidedWith second");
					}
					else if(!pressed[KeyEvent.VK_F] && !pressed[KeyEvent.VK_B] && count != 0) 
					{	
								
						motor.upRamp(ramp);
						count--;
						System.out.println("                                                      count: "+count);
								
					}

					else if(!pressed[KeyEvent.VK_F] && !pressed[KeyEvent.VK_B] && count == 0)
					{
						if(((motor.frontWheel.x) > SmallRamp.x1 ) && ((motor.frontWheel.x) < SmallRamp.x2))
						{
							//slide = true;
							//motor.moveBackwardBy(2);
							if((motor.frontWheel.x )<=(BigRamp.x4 + 40))
								BigRamp.create2 = true;
							motor.downRamp(ramp);
							System.out.println("                                                                                             count: "+count);
						}
						
					}
							
				}
				else if ((((SmallRamp.x2 + 10 )< (motor.frontWheel.x + motor.frontWheel.r) 
							&& ((motor.frontWheel.y) < 480) && BigRamp.projectile == true )) ) // since your changing ramp all the time
					// this thing is not being entered    //&& movingDown == false
				{
					System.out.println("               I am in paint hasCollidedWith third");
					//if(BigRamp.projectile == true)
						motor.projectileMotion();
								
							//else
								//motor.upRamp(ramp);
				}
						
						

						// to move backward.
						//if (pressed[KeyEvent.VK_LEFT]) car.moveBackwardBy(1);
						//if (pressed[KeyEvent.VK_LEFT]) background1.moveBackwardBy(3);
						//if (pressed[KeyEvent.VK_LEFT]) background2.moveBackwardBy(1);

			
			
			

			
			
			repaint();
			
			try{
				Thread.sleep(15);
			}
			catch(Exception x){};
	}
	}
	
	//BigRamp ramp = new BigRamp(x1, y1, x2, y2, small);
	
	
	boolean movingDown = false;
	
	public void paint(Graphics g)
	{
		
		background1.draw(g);
		
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 360, 1500, 35);
		
		background3.draw(g);
		background2.draw(g);
		track.draw(g);

		//g.setColor(Color.BLACK);//was YELLOW
		
		//track2.draw(g);
		
		g.setColor(Color.BLACK); //was ORANGE
		motor.draw(g);


	
		
		ramp.draw(g);
		
		
		System.out.println("ramp.x1: "+SmallRamp.x1);
		//bigRamp.draw(g);
		
		
		//System.out.println(ramp.x2 < (car.x_Rect + 60));
		//System.out.println(car.hasCollidedWith(ramp));
		
		//it is not entering this 4.28

		
	}
	
	public void repaint()  // do this to avoid waiting for the O.S to repaint for you.
	{
		/*Create a new graphics object every time I call repaint, 
		 * so I will need to dispose it*/
		Graphics g;
		g = this.getGraphics();// get graphics object from applet.
		if(g == null);// I did this if statement b/c when I was exiting the applet, 
		else		// the game loop would still call the repaint method for the last time	
		{			// which was causing the g to be null, and thus a nullPointerException would appear.	
			update(g);
			g.dispose();
		}// if you don't do that the program would crash. (run out of memory)
	}
	
	public void update(Graphics g)
	{
		offScreen_g.clearRect(0,  0,  1500, 700); //clears the back buffer/ check width=500
		paint(offScreen_g); //paints the new image to the back buffer
		g.drawImage(offScreen, 0, 0, null); // draws the new image on the screen
		
		//g.clearRect(0, 0, 1000, 700);  //it is going to clear 3/4 of the screen. put (2000) 
		
		//paint(g);  // this was drawing directly to the screen which caused flickering
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
		
		if(ramp.hasCollidedWith(motor) && count == 0 )
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
