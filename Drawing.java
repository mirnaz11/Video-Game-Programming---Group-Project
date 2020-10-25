

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Drawing extends Applet implements KeyListener, Runnable {
	
	Image offScreen;

	Graphics offScreen_g;
	
	Font font = new Font("sans-serif",Font.BOLD,16);
	Font font1 = new Font("Courier",Font.BOLD,22);
	
	//Image gate = Toolkit.getDefaultToolkit().getImage("gate.png");
	Image gate1 = Toolkit.getDefaultToolkit().getImage("gate1.png");
	Image gate2 = Toolkit.getDefaultToolkit().getImage("gate2.png");
	Image flag = Toolkit.getDefaultToolkit().getImage("flag.png");
	
	
	Track track = new Track(0, 480, 1500, 480);
	//Track track2 = new Track(0, 385, 1500, 385);

	MotorCycle motor = new MotorCycle("m_0.png",0,380);
	Coin coin1 = new Coin("coin.png", 490, 390);
	Coin coin2 = new Coin("coin.png", 650, 320);
	
	Coin coin3 = new Coin("coin.png", 1470, 190);
	Coin coin4 = new Coin("coin.png", 1620, 170);
	
	Coin coin5 = new Coin("coin.png", 2280, 290);
	Coin coin6 = new Coin("coin.png", 2480, 390);
	
	
	Coin coin7 = new Coin("coin.png", 3400, 210);
	Coin coin8 = new Coin("coin.png", 3600, 180);
	
	boolean stopBackground=true;
	
	

	boolean[] pressed = new boolean[256];

	ImageLayer background1 = new ImageLayer("grasscopy.png", 0, 50, 0);
	ImageLayer background2 = new ImageLayer("houses1.png", 0, 250, 1);
	ImageLayer background3 = new ImageLayer("houses2.png", 0, 0, 1);
	
	int count = 10;
	boolean slide = false;
	
	BigRamp bigRamp;
	
	SmallRamp ramp = BigRamp.ramp;
	
	AudioClip grabCoin;
	
	AudioClip motorSound;
	
	int score;
	
	public void init()
	{
		setSize(1500,650);//800, 500

		offScreen = createImage(1500, 700);
		offScreen_g = offScreen.getGraphics();
		
		requestFocus();
		addKeyListener(this);
		grabCoin = getAudioClip(getDocumentBase(),"coin_flip.wav");
		motorSound = getAudioClip(getDocumentBase(),"motorcycle2.wav");
		
		
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
			if (pressed[KeyEvent.VK_RIGHT] && stopBackground)
			{
				motor.moveForwardBy(20);
				background1.moveForwardBy(3);
				background2.moveForwardBy(2);
				background3.moveForwardBy(1);
				motorSound.play();
				
			}
			if (pressed[KeyEvent.VK_LEFT]) 
			{
				motor.moveBackwardBy(5);
				background1.moveBackwardBy(3);
				background2.moveBackwardBy(2);
				background3.moveBackwardBy(1);
			}
			
			Camera.x = motor.frontWheel.x - 480;
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
							
					if(pressed[KeyEvent.VK_LEFT] ) // down slide-SmallRamp.y2 > SmallRamp.y1
					{
						motor.downRamp(ramp);
								
						//movingDown = true;
						System.out.println("               I am in paint hasCollidedWith first");
					}
					else if (pressed[KeyEvent.VK_RIGHT]) 
					{
						if(SmallRamp.y2 <= SmallRamp.y1)
							motor.upRamp(ramp); // up slide
						else
						{
							motor.downRamp(ramp);
							
						}
								
					System.out.println("               I am in paint hasCollidedWith second");
					}
					else if(!pressed[KeyEvent.VK_RIGHT] && !pressed[KeyEvent.VK_LEFT] && count != 0) 
					{	
								
						motor.upRamp(ramp);
						count--;
						System.out.println("                                                      count: "+count);
								
					}

					else if(!pressed[KeyEvent.VK_RIGHT] && !pressed[KeyEvent.VK_LEFT] && count == 0)
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
		
		
		//motor.draw(g);
		ramp.draw(g);
		coin1.draw(g);
		coin2.draw(g);
		coin3.draw(g);
		coin4.draw(g);
		coin5.draw(g);
		coin6.draw(g);
		coin7.draw(g);
		coin8.draw(g);
		g.drawImage(gate1,4000-Camera.x,320,null);
		motor.draw(g);
		g.drawImage(gate2,4000-Camera.x,320,null);
		//g.drawImage(motorStop, 5210-Camera.x, 280, null);

		if (motor.hasCollidedWith(coin1.x,coin1.y,coin1.w, coin1.h )){
			score+=coin1.score;
			grabCoin.play();
			coin1.y = 4000;
		}
		if (motor.hasCollidedWith(coin2.x,coin2.y,coin2.w, coin2.h )){
			score+=coin2.score;
			grabCoin.play();
			coin2.y = 5000;
		}
		if (motor.hasCollidedWith(coin3.x,coin3.y,coin3.w, coin3.h )){
			score+=coin3.score;
			grabCoin.play();
			coin3.y = 4000;
		}
		if (motor.hasCollidedWith(coin4.x,coin4.y,coin4.w, coin4.h )){
			score+=coin4.score;
			grabCoin.play();
			coin4.y = 4000;
		}
		if (motor.hasCollidedWith(coin5.x,coin5.y,coin5.w, coin5.h )){
			score+=coin5.score;
			grabCoin.play();
			coin5.y = 4000;
		}
		if (motor.hasCollidedWith(coin6.x,coin6.y,coin6.w, coin6.h )){
			score+=coin6.score;
			grabCoin.play();
			coin6.y = 4000;
		}
		if (motor.hasCollidedWith(coin7.x,coin7.y,coin7.w, coin7.h )){
			score+=coin7.score;
			grabCoin.play();
			coin7.y = 4000;
		}
		if (motor.hasCollidedWith(coin8.x,coin8.y,coin8.w, coin8.h )){
			score+=coin8.score;
			grabCoin.play();
			coin8.y = 4000;
		}
		g.setColor(new Color(13,222,13));
		g.fillRect(40, 25, 160, 40);
		g.setColor(new Color(255,255,255));
		g.setFont(font);
		g.drawString("Your Score: "+score, 60,50);
		
		g.setColor(Color.RED);
		g.fillRect(4500 -Camera.x, 300, 160, 50);
		g.setColor(Color.WHITE);
		g.setFont(font1);
		g.drawString("FINISHED", 4520-Camera.x, 330);
		
		g.setColor(Color.RED);
		g.fillRect(4800 -Camera.x, 300, 100, 50);
		g.setColor(Color.WHITE);
		g.setFont(font1);
		g.drawString("STOP", 4820-Camera.x, 330);
		g.drawImage(flag, 4910-Camera.x, 280, null);
		if(motor.mx-Camera.x >= 5210 -Camera.x){
			stopBackground=false;
		}
		
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
