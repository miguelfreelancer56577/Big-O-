package github.com.miguelfreelancer56577.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
	public static void main(String[] args) {
		int[] a = new int[] {1,5,5,8,9};
		int[] b = new int[] {1,5,6,7,8,8,8,8,9};
		
		Integer[] array = Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
                .toArray(Integer[]::new);
				
		
		List<Integer> asList = Arrays.asList(array);
		
		Collections.sort(asList);
		
		asList.forEach((ele)->System.out.println(ele));
		
	}
    public int solution(int a, int b) {
        // write your code in Java SE 8
    	//Get result of multiplying A and B
    	final int rsMultiplication = multiplyVariables(a, b);
    	//return the number of bits set to 1
//    	return getNumberOfBits(rsMultiplication);
    	return getNumberOfBits(Integer.toBinaryString(rsMultiplication));
    }
    private int multiplyVariables(int a, int b) {
    	return a*b;
    }
    private int getNumberOfBits(int number) {
    	int count = 0;
    	
//    	it returns 0 bits if number is equal to 0 
    	if(number == 0 ) {
    		return 0;
    	}
    	
//    	it counts the number of bits set to 1
        while (number > 0) {
            count += number & 1;
            number >>= 1;
        }
        
        return count;
    	
    }
    
    private int getNumberOfBits(String binaryString) {
    	return (int)Stream
    		.of(binaryString.split(""))
    		.filter(value->value.equals("1"))
    		.count();
    }
 
}
