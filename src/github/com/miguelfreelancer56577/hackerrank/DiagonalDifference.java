package github.com.miguelfreelancer56577.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * For more details about this problem go to
 * @see <a href="https://www.hackerrank.com/challenges/diagonal-difference/problem">Diagonal Difference</a>
 * 
 * @author mangelt
 *
 */
public class DiagonalDifference {
	
	public static void main(String[] args) {
		List<Integer> firstLine = Arrays.asList(1,2,3,4,5);
		List<Integer> secondLine = Arrays.asList(6,7,8,9,10);
		List<Integer> thirdLine = Arrays.asList(11,12,13,14,15);
		List<Integer> fourLine = Arrays.asList(16,17,18,19,20);
		List<Integer> fiveLine = Arrays.asList(21,22,23,24,25);
		List<List<Integer>> arr = new ArrayList<>();
		arr.add(firstLine);
		arr.add(secondLine);
		arr.add(thirdLine);
		arr.add(fourLine);
		arr.add(fiveLine);
		System.out.println(diagonalDifference(arr));
	}

	public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
		/**
		 * resultedDifference: holds the value to be returned
		 * flattendList: contains all the items taken as input
		 * differenceOfSides: holds the sum of each integer of the array
		 * numberOfElements: has the length of each side
		 * primarySide: constant with the name of the key from the left diagonal 
		 * secondarySide: constant with the name of the key from the right diagonal 
		 */
		int resultedDifference = 0;
		Integer[] flattedList = null;
		Map<String, Integer> differenceOfSides = new HashMap<>();
		int numberOfElements = arr.get(0).size();
		final String primarySide = "primary.side"; 
		final String secondarySide = "secondary.side";
		
//		Set the keys that will save the sum of each integer
		differenceOfSides.put(primarySide, 0);
		differenceOfSides.put(secondarySide, 0);
		
//		flats each list into an array
		flattedList = arr.stream().flatMap(DiagonalDifference::flatsList).toArray(size -> new Integer[size]);
		
//		loop through each record
		for (int i = 0, leftCounter = 0, rightCounter = 1; i < flattedList.length; i=i+numberOfElements, leftCounter++, rightCounter++) {
			/**
			 * Sum the value of the first element from the left
			 * Sum the value of the first element from the right
			 */
			
			differenceOfSides.put(primarySide, differenceOfSides.get(primarySide) + flattedList[i+leftCounter]);
			differenceOfSides.put(secondarySide, differenceOfSides.get(secondarySide) + flattedList[((i+numberOfElements)-rightCounter)]);
			
		}
		
//		gets the difference between each side
		resultedDifference = differenceOfSides.get(primarySide) - differenceOfSides.get(secondarySide);
		
		if(resultedDifference < 0) {
			resultedDifference = resultedDifference*-1;
		}
		
		return resultedDifference;
    }
	
	public static Stream<Integer> flatsList(List<Integer> list) {
		return list.stream();
	}
	
}
