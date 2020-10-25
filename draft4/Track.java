package draft4;

import java.awt.*;

public class Track {
	
		int x;
		int y;
		int x1;
		int y1;
		
		Image track;

		public Track(int x, int y, int x1, int y1) {

			track = Toolkit.getDefaultToolkit().getImage("Track.png");
			
			this.x = x;
			this.y = y;
			this.x1 = x1;
			this.y1 = y1;
		}

		public void draw(Graphics g) {
			
			g.drawImage(track, 0 , 450, 1500 , 450, null);
			g.drawLine(x, y, x1, y1);

		}

	

}
