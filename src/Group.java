import java.util.HashSet;

public class Group {
	Cube[] cubes;
	
	public Group(Cube[] cubes) 
	{
		this.cubes = cubes;
	}
	
	public void loop() {
		boolean reachedEnd = false;
		while (!reachedEnd) {
			// rotate cubes
			for (int i=0; i<cubes.length; i++) {
				cubes[i].rotate();
				if (!cubes[i].isZero())
					break;
			}
			
			// have we found a solution?
			if (isSolution()) {
				for (int i=0; i<cubes.length; i++) {
					System.out.println("Cube " + (i+1) + ": ");
					cubes[i].print();
				}
			}
			
			// determine if we have reached the end
			reachedEnd = true;
			for (Cube cube : cubes) {
				if (!cube.isZero())
				{
					reachedEnd = false; 
					break;
				}
			}
		}
	}
	
	public boolean isSolution() {
		HashSet<Character> colors = new HashSet<Character>();
		
		for (Cube cube : cubes) 
		{
			if (colors.contains(cube.front)) {
				return false;
			} else {
				colors.add(cube.front);
			}
		}
		

		colors.clear();
		for (Cube cube : cubes) 
		{
			if (colors.contains(cube.back)) {
				return false;
			} else {
				colors.add(cube.back);
			}
		}
		

		colors.clear();
		for (Cube cube : cubes) 
		{
			if (colors.contains(cube.up)) {
				return false;
			} else {
				colors.add(cube.up);
			}
		}

		colors.clear();
		for (Cube cube : cubes) 
		{
			if (colors.contains(cube.down)) {
				return false;
			} else {
				colors.add(cube.down);
			}
		}
		
		return true;
	}
}
