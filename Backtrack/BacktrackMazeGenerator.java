import java.util.Arrays;
import java.util.Random;

public class BacktrackMazeGenerator {

	// Feel free to test with different values
	private static int height = 7, width = 5;
	private static int maxCalls = 50;
	
	private static int[][] maze = new int[width][height];
	private static boolean[][] visited = new boolean[width][height];
	private static Random random = new Random();
	
	private static final int WALL = 1;
	private static final int EMPTY = 0;
	private static final int EXIT = -99;
	
	public static void main(String[] args) {

		fillMatrix();
		
		// Set start and exit values
		int x = 0, y = 0;
		maze[x][y] = EMPTY;
		maze[width-1][height-1] = EXIT;
		
		generatePath(x, y, random.nextInt(4));
		
		print();
	}

	private static void print() {
		System.out.println(width + " " + height);

		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) 
				System.out.printf("%1$5d", maze[i][j]);
			System.out.println();
		}
	}
	
	// Fill matrix with number 1 - WALL
	private static void fillMatrix() {
		for (int i = 0; i < width; i++)
			Arrays.fill(maze[i], WALL);
	}

	// Makes path by inputing number 0 - EMPTY in one of the four directions
	private static boolean generatePath(int x, int y, int direction) {
		
		if (maxCalls-- == 0) 
			throw new IllegalStateException("Too many calls of the recursive method! "
					+ "Restart the program.");
		
		if (x < 0 || x >= width || y < 0 || y >= height) return false;
		
		if (visited[x][y]) return false;
		
		if (maze[x][y] == EXIT) return true;

		direction = random.nextInt(4);
		visited[x][y] = true;
		maze[x][y] = EMPTY;

		System.out.println("Direction: " + direction);
		
		switch (direction) {
		case 0:
			if (generatePath(x + 1, y, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x - 1, y, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x, y + 1, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x, y - 1, direction)) {
				maxCalls++;
				return true;
			}
			break;
		case 1:
			if (generatePath(x - 1, y, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x + 1, y, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x, y + 1, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x, y - 1, direction)) {
				maxCalls++;
				return true;
			}
			break;
		case 2:
			if (generatePath(x, y + 1, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x + 1, y, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x - 1, y, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x, y - 1, direction)) {
				maxCalls++;
				return true;
			}
			break;
		case 3:
			if (generatePath(x, y - 1, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x + 1, y, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x - 1, y, direction)) {
				maxCalls++;
				return true;
			}
			if (generatePath(x, y + 1, direction)) {
				maxCalls++;
				return true;
			}
			break;
		default:
			System.out.println("Something went wrong!");
		}
		visited[x][y] = false;
		
		return false;
	}
}