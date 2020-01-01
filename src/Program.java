
public class Program
{
	Cube[] cubes;
	
	public static void main(String[] args) 
	{
		System.out.println("Running...");
		Cube cube1 = new Cube('w', 'g', 'u', 'r', 'r', 'r');
		Cube cube2 = new Cube('w', 'u', 'g', 'w', 'r', 'u');
		Cube cube3 = new Cube('w', 'g', 'u', 'u', 'g', 'r');
		Cube cube4 = new Cube('w', 'u', 'r', 'w', 'r', 'g');
		Group group = new Group(new Cube[] { cube1, cube2, cube3, cube4 });
		group.loop();
	}
	
	
// josh.a.fishman@gmail.com
}
