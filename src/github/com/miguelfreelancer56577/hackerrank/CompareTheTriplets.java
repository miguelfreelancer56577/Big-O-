package github.com.miguelfreelancer56577.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * For more details about this problem go to
 * @see <a href="https://www.hackerrank.com/challenges/compare-the-triplets/problem">Compare the Triplets</a>
 * 
 * @author mangelt
 *
 */
public class CompareTheTriplets {

	public static void main(String[] args) {
		/**
		 * Test cases to run this fragment of code.
		 */
		List<Integer> a = Arrays.asList(17,28,30);
		List<Integer> b = Arrays.asList(99,16,8);
		System.out.println(compareTriplets(a, b));
	}
	
	
	// Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	/**
    	 * result: gets the final results with the sum by each comparison
    	 * totalPoints: Keeps the total points of each list
    	 * keyA: name of the key to be used as "a"
    	 * keyB: name of the key to be used as "b"
    	 */
    	List<Integer> result = new ArrayList<>();
    	Map<String, Integer> totalPoints = new HashMap<>();
    	final String keyA = "a";
    	final String keyB = "b";
    	
//    	Initializes keys to save the sum between each comparison  
    	totalPoints.put(keyA, 0);
    	totalPoints.put(keyB, 0);
    	
//    	loop though any of the list to start comparison
    	IntStream.range(0, a.size())
    		.forEach(counter->{
    			/**
    			 * Executes the following operation:
    			 * if a[i] > b[i] then 1 point for a
    			 * if a[i] < b[i] then 1 point for b
    			 * if a[i] == b[i] then neither receives point
    			 */
    			if(a.get(counter) > b.get(counter)) {
    				totalPoints.put(keyA, totalPoints.get(keyA)+1);
    			}
    			else if(a.get(counter) < b.get(counter)) {
    				totalPoints.put(keyB, totalPoints.get(keyB)+1);
    			}
    		});
    	
//    	Assigns the result with the sum on each iteration
    	result.add(totalPoints.get(keyA));
    	result.add(totalPoints.get(keyB));
    	
    	return result;

    }
	
}
