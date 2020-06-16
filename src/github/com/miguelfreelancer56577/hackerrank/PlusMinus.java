package github.com.miguelfreelancer56577.hackerrank;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * For more details about this problem go to
 * @see <a href="https://www.hackerrank.com/challenges/plus-minus/problem">Plus Minus</a>
 * 
 * @author mangelt
 *
 */
public class PlusMinus {

	public static void main(String[] args) {
		int[] arr = new int[] {-4,3,-9,0,4,1};
		plusMinus(arr);
	}
	
	static void plusMinus(int[] arr) {
		/**
		 *	numberOfPositives: holds the number of positive values 
		 *	numberOfNegatives: holds the number of negative values 
		 *	numberOfZeros: holds the number of zero values.
		 *	lengthOfItems: holds the length of items.
		 */
		
		int numberOfPositives = Arrays.stream(arr).boxed().filter(item->item>0&&item!=0?true:false).collect(Collectors.toList()).size(), 
			numberOfNegatives = Arrays.stream(arr).boxed().filter(item->item<0&&item!=0?true:false).collect(Collectors.toList()).size(),
			numberOfZeros = Arrays.stream(arr).boxed().filter(item->item==0?true:false).collect(Collectors.toList()).size(),
			lengthOfItems = arr.length;
		
		NumberFormat decimalFormat = new DecimalFormat("####.######");
		
//		prints decimal representation of the fraction for positive numbers.
		System.out.println(String.format("%06f", (double)numberOfPositives/lengthOfItems));
//		prints decimal representation of the fraction for negative numbers.
//		System.out.println((double)numberOfNegatives/lengthOfItems);
		System.out.println(String.format("%06f", (double)numberOfNegatives/lengthOfItems));
//		prints decimal representation of the fraction for zero numbers.
//		System.out.println((double)numberOfZeros/lengthOfItems);
		System.out.println(String.format("%06f", (double)numberOfZeros/lengthOfItems));

    }
	
}
