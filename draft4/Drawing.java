package draft4;

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

	MotorCycle motor = new MotorCycle("m_rt_0.png",0,380);
	Coin coin1 = new Coin("coin.png", 490, 390);
	Coin coin2 = new Coin("coin.png", 650, 320);
	
	Coin coin3 = new Coin("coin.png", 1470, 190);
	Coin coin4 = new Coin("coin.png", 1620, 170);
	
	Coin coin5 = new Coin("coin.png", 2280, 290);
	Coin coin6 = new Coin("coin.png", 2480, 390);
	
	
	Coin coin7 = new Coin("coin.png", 3400, 210);
	Coin coin8 = new Coin("coin.png", 3600, 180);
	
	

	boolean[] pressed = new boolean[256];

	ImageLayer background1 = new ImageLayer("grasscopy.png", 0, 50, 0);
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
			BigRamp.BigRamp(motor);
			ramp = BigRamp.ramp;
			
			System.out.println("motor.frontWheel.x"+ motor.frontWheel.x );
			if (pressed[KeyEvent.VK_F] ) 	motor.moveForwardBy(10);
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
								
				}
						
			
			repaint();
			
			try{
				Thread.sleep(15);
			}
			catch(Exception x){};
	}
	}
	
	boolean movingDown = false;
	
	public void paint(Graphics g)
	{
		
		background1.draw(g);
		background3.draw(g);
		background2.draw(g);
		track.draw(g);
		
		g.setColor(Color.BLACK); //was ORANGE
		motor.draw(g);
		ramp.draw(g);
		
		coin1.draw(g);
		coin2.draw(g);
		coin3.draw(g);
		coin4.draw(g);
		coin5.draw(g);
		coin6.draw(g);
		coin7.draw(g);
		coin8.draw(g);
		
		if (coin1.hasCollidedWith(motor.mx,motor.my,motor.w, motor.h ))
			//g.drawString("Collision Detected", 800, 40);
			System.out.println("collision");
		else
			g.drawString("No Collision", 0, 60);
		
		
		
		System.out.println("ramp.x1: "+SmallRamp.x1);
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
		
	}

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
		
				
			}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
