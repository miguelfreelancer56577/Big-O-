package github.com.miguelfreelancer56577.codility.BinaryGap;

import java.util.HashMap;
import java.util.Map;


public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int longestBinaryGap = solution.solution(1610612737);
		System.out.println("longestBinaryGap: " + longestBinaryGap);
	}
	
	public int solution(int n) {
		final String binaryString = getBinaryString(n);
		return getLongestBinaryGap(binaryString);
	}
	
	String getBinaryString(final int number){
		return Integer.toBinaryString(number);
	}
	
	int getLongestBinaryGap(final String binaryStrings) {
		Map<Integer, Integer> lengthGaps = new HashMap<>();
		int currentGap = 0;
		int nextGap = 1;
		String toCheckGap;
		int indexOfNextGap;
		for (int i = 0; i < binaryStrings.length(); i++) {
			char charAt = binaryStrings.charAt(i);
			if(charAt == '1') { 
				toCheckGap = binaryStrings.substring(i+1, binaryStrings.length());
				indexOfNextGap = toCheckGap.indexOf('1');
				if(indexOfNextGap != -1 ) {
					currentGap = nextGap;
					lengthGaps.put(currentGap, 0);
					nextGap++;
				}else {
					break;
				}
			}else{
				if(lengthGaps.containsKey(currentGap)) {
					lengthGaps.put(currentGap, lengthGaps.get(currentGap) + 1);
				}
			}
		}
		return lengthGaps
			.values()
			.stream()
			.max(Integer::compare)
			.orElseGet(()->0);
	}
	
}
