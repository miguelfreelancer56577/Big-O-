package github.com.miguelfreelancer56577.hackerrank;

import java.util.Arrays;

/**
 * For more details about this problem go to
 * @see <a href="https://www.hackerrank.com/challenges/compare-the-triplets/problem">A Very Big Sum</a>
 * 
 * @author mangelt
 *
 */
public class VeryBigSum {

	public static void main(String[] args) {
//		Test cases
		long[] ar = new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
		System.out.println(aVeryBigSum(ar));
	}
	
	// Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
    	return Arrays.stream(ar).boxed().reduce(0L, Long::sum);
    }
	
}
