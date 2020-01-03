
public class Cube
{
	private int iteration = 0;
	private boolean last = false;
	private char startUp, startDown, startLeft, startRight, startBack, startFront;
	public char up, down, left, right, back, front;
	
	public Cube(char up, char down, char left, char right, char back, char front)
	{
		startUp = up;
		startDown = down;
		startLeft = left;
		startRight = right;
		startBack = back;
		startFront = front;
		initialize();
	}
	
	private void initialize() {
		assign(startUp, startDown, startLeft, startRight, startBack, startFront);
	}
	
	private void assign(char up, char down, char left, char right, char back, char front)
	{
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
		this.back = back;
		this.front = front;
	}
	
	private void pitch() {
		char up, down, back, front;
		front = this.down;
		down = this.back;
		back = this.up;
		up = this.front;
		assign(up, down, left, right, back, front);
	}
	
	private void yaw() {
		char left, right, back, front;
		front = this.right;
		right = this.back;
		back = this.left;
		left = this.front;
		assign(up, down, left, right, back, front);
	}
	
	private void roll() {
		char up, down, left, right;
		up = this.left;
		right = this.up;
		down = this.right;
		left = this.down;
		assign(up, down, left, right, back, front);
	}
	
	public void rotate() {
		if (!last) {
			standardRotate();
		} else {
			lastRotate();
		}
	}
	
	// standard rotate method
	private void standardRotate() {
		iteration++;
		if (iteration == 24) {
			iteration = 0;
			initialize();
		} else {
			pitch();
			if (iteration < 16) {
				if (iteration % 4 == 0)
					yaw();
			} else if (iteration == 16) {
				yaw();
				roll();
			} else if (iteration == 20) {
				roll();
				roll();
			}
		}
	}

	// rotations for the last cube (does not pitch to avoid duplicate solutions)
	private void lastRotate() {
		iteration++;
		if (iteration == 6) {
			iteration = 0;
			initialize();
		} else {
			pitch();
			if (iteration < 4) {
				yaw();
			} else if (iteration == 4) {
				yaw();
				roll();
			} else if (iteration == 5) {
				roll();
				roll();
			}
		}
	}

	public void setLast() {
		last = true;
	}
	
	public void print() {
		System.out.println("\tUp: " + up);
		System.out.println("\tDown: " + down);
		System.out.println("\tLeft: " + left);
		System.out.println("\tRight: " + right);
		System.out.println("\tBack: " + back);
		System.out.println("\tFront: " + front);
		System.out.println("\tIteration: " + iteration);
		System.out.println("\tOrientation instructions: ");
		System.out.print(orientationInstructions());
	}
	
	public boolean isZero() {
		return iteration == 0;
	}
	
	// creates a copy of the cube
	public Cube clone() {
		return new Cube(up, down, left, right, back, front);
	}
	
	// checks if another cube is the same as this one and in the same orientation
	public boolean equals(Cube that) {
		return  this.up == that.up &&
				this.down == that.down &&
				this.left == that.left &&
				this.right == that.right &&
				this.back == that.back &&
				this.front == that.front;
	}
	
	// provide instructions to get to this orientation
	private String orientationInstructions() {
		StringBuilder bldr = new StringBuilder(); // this makes a variable size string
		int numYaw = 0;
		int numRoll = 0;
		int numPitch = 0;
		
		if (!last) {
			numPitch = iteration % 4;
			if (iteration < 16) {
				numYaw = iteration / 4;
			} else if (iteration >= 16 && iteration < 20) {
				numRoll = 1;
			} else {
				numRoll = 3;
			}
		} else {
			if (iteration < 4) {
				numYaw = iteration;
			} else if (iteration == 4) {
				numRoll = 1;
			} else {
				numRoll = 3;
			}
		}
		
		if (numRoll != 0)
			bldr.append("\t\tRoll x" + numRoll + " (clockwise around the front face)\n");
		if (numYaw != 0)
			bldr.append("\t\tYaw x" + numYaw + " (clockwise around the top face)\n");
		if (numPitch != 0)
			bldr.append("\t\tPitch x" + numPitch + " (clockwise around the right face)\n");
		if (bldr.length() == 0)
			bldr.append("\t\tNo rotation\n");
		
		return bldr.toString();
	}
 }
