
public class Cube
{
	char up, down, left, right, back, front;
	int iteration = 0;
	
	public Cube(char up, char down, char left, char right, char back, char front)
	{
		assign(up, down, left, right, back, front);
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
	
	public void pitch() {
		char up, down, back, front;
		front = this.up;
		down = this.front;
		back = this.back;
		up = this.up;
		assign(up, down, left, right, back, front);
	}
	
	public void yaw() {
		char left, right, back, front;
		front = this.right;
		right = this.back;
		back = this.left;
		left = this.front;
		assign(up, down, left, right, back, front);
	}
	
	public void roll() {
		char up, down, left, right;
		up = this.left;
		right = this.up;
		down = this.right;
		left = this.down;
		assign(up, down, left, right, back, front);
	}
	
	public void rotate() {
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
		iteration++;
		iteration %= 24;
	}
	
	public void print() {
		System.out.println("\tUp: " + up);
		System.out.println("\tDown: " + down);
		System.out.println("\tLeft: " + left);
		System.out.println("\tRight: " + right);
		System.out.println("\tBack: " + back);
		System.out.println("\tFront: " + front);
	}
	
	public boolean isZero() {
		return iteration == 0;
	}
 }
