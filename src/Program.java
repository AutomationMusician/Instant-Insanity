
public class Program
{
	Cube[] cubes;
	
	public static void main(String[] args) 
	{
		//testUniqueRotations();
		
		Cube cube1 = new Cube('w', 'g', 'u', 'r', 'r', 'r');
		Cube cube2 = new Cube('w', 'u', 'g', 'w', 'r', 'u');
		Cube cube3 = new Cube('w', 'g', 'u', 'u', 'g', 'r');
		Cube cube4 = new Cube('w', 'u', 'r', 'w', 'r', 'g');
		Group group = new Group(new Cube[] { cube1, cube2, cube3, cube4 });
		group.loop();
	}
	
	// function that runs sanity checks on the rotations
	public static void testUniqueRotations() {
		Cube cube = new Cube('u', 'd', 'l', 'r', 'b', 'f');
		
		// capture cubes and rotate
		Cube[] rotations = new Cube[24];
		for (int i=0; i<rotations.length; i++) {
			// print cubes
			System.out.println("Cube " + i + ": ");
			cube.print();
			
			// capture and rotate
			rotations[i] = cube.clone();
			cube.rotate();
		}
		
		for (int i=0; i<rotations.length; i++) {
			// print cubes
			System.out.println("Cube " + i + ": ");
			cube.print();
			if (!cube.equals(rotations[i]))
				System.out.println("Does not equal original rotations");
			cube.rotate();
		}
		
		// check if any are equal
		boolean equal = false;
		for (int i=0; i<rotations.length; i++) {
			for (int j=i+1; j<rotations.length; j++) {
				if (rotations[i].equals(rotations[j])) {
					equal = true;
					System.out.println("rotations " + i + " and " + j + " are equal");
				}
			}
		}
		if (!equal)
			System.out.println("All rotations are unique");
	}
}
