package github.com.miguelfreelancer56577.hackerrank;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class contains the solution for the problem
 * @see <a href="https://www.hackerrank.com/challenges/staircase/problem?h_r=internal-search">Solve Me First</a>
 * 
 * @author mangelt
 *
 */
public class Staircase {

	/**
	 * y = holds the number of iterations done
	 * z = holds the number of stair to be printed
	 */
	private int y;
	private int z;
	
	/**
	 * WILDCARD_STAIRS = holds the wild card use for each stair 
	 * WILDCARD_SPACES = holds the wild card used to print spaces
	 * lastStair = holds a representation of the last stairs that would be printed  
	 */
	private static final String WILDCARD_STAIRS = "#";
	private static final String WILDCARD_SPACES = " ";
	private String lastStair;
	
	Staircase(int z) {
		this.z = z;
		this.y = 0;
		lastStair = getLastStair();
	}
	
	public static void main(String[] args) {
		staircase(100000);
	}
	
	static void staircase(int n) {
		
//		create a bean which contains all the logic to print each stair
		final Staircase staircase = new Staircase(n);
		
//		checks for no 0 input
		if(n > 0){
//			print each stair 
			IntStream.range(0, n)
				.forEach(staircase::printStair);
		}

    }
	
	/**
	 * Method use to print the current stair  
	 * 
	 * @param val The current position of the stair to get printed
	 */
	private void printStair(int val) {
//			get the number of space to add for this current stair 
		int numberOfSpaces = this.getNumberOfSpaces();
		String spaces = this.createSpaces(numberOfSpaces);
		String createStair = this.createStair();
		System.out.println(spaces+createStair);
	}
	
	/**
	 * Create the required stair depending on the number of positions
	 * 
	 * Gets the lastStair
	 * Gets a substring from the begging to the {@link numberOfSpaces} position
	 * From substring replaces the # from " " spaces  
	 * 
	 * 
	 * @param numberOfSpaces Number of position to be used to create the stair
	 */
	private String createSpaces(int numberOfSpaces) {
		String stairs = lastStair.substring(0, numberOfSpaces);
		return stairs.replace(WILDCARD_STAIRS, WILDCARD_SPACES);
	}
	
	/**
	 * Create the required stair depending on the number iterations
	 * 
	 * Gets the lastStair
	 * Gets a substring from the begging to the {@link Staircase#y} position
	 * 
	 * @return String Containing the stairs to be printed
	 * 
	 */
	private String createStair() {
		return lastStair.substring(0, this.y);
	}

	/**
	 * 
	 * @param n The longer stair to be printed 
	 * @return {@link String} which contains a representation of the last stair to be printed 
	 */
	private String getLastStair() {
		return IntStream.range(0, z)
			.boxed()
			.map(val->WILDCARD_STAIRS)
			.collect(Collectors.joining());
	}

	/**
	 * This method executes the following operation
	 * 
	 * x = z - y;
	 * 
	 * where "x" is the number of stairs to be printed as a result of the operation
	 * of "z" that is top of stairs minus "y" the number of iteration done until now
	 * 
	 * decrease "x" - 1 since it starts to count from 0 
	 * 
	 * At the end it increases "y" for the next stair 
	 * 
	 * @return x Number of spaces to be added
	 */
	private int getNumberOfSpaces() {
		int x = this.z - this.y;
		this.y++;
		return (x-1);
	}
}
