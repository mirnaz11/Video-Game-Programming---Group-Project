//this should be a sprite
package draft4;
import java.awt.*;

public class Car2 {
	
	Image image;
	
	int x;
	int y;
	
	int w;
	int h;
	
	public Car2 (String filename, int x, int y, int w, int h )
	{
		this.image = Toolkit.getDefaultToolkit().getImage(filename);
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

}
