package draft2;


import java.awt.*;

public class Track {

	int x;
	int y;
	int x1;
	int y1;

	public Track(int x, int y, int x1, int y1) {

		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
	}

	public void draw(Graphics g) {
		g.drawLine(x, y, x1, y1);

	}

}
