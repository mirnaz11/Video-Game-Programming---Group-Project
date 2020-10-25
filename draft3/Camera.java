package draft3;

public class Camera {
	// based on camera where you see. world is not moving your eye is moving.

	static int x;// why they names static, came from c++ it is a class variable.
					// It does change.
	static int y;
	// static int z;
	// Why they use this ? It is reference to the object itself. Military used
	// it
	// for missile pointing, you use vector to figure out the directions. This
	// is a for loop.
	// i j k was used to nesting the loop. They wanted to mimik real object do,
	// they thought about using the
	// i but it was already used for x dimensions so they did not want to
	// confuse and came up with this.x to refer
	// the object itself. Classes do not have this.


	public static void set(int xp, int yp) {
		x = xp;
		y = yp;

	}

	public static void moveForwardBy(int dx) {
		x += dx;

	}

	public static void moveBackwardBy(int dx) {
		x -= dx;

	}

}