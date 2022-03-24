package github.com.miguelfreelancer56577.codility.toptal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a = new int[]{5,19,8,1};
		sol.solution(a);
		
	}
	
	public String solution(String message, int K) {
		K = (K-1);
		final int msgLength = message.length();
		if(msgLength == K || K > msgLength) {
			return message;
		}else {
//			check the letter of K position
			char charAt = message.charAt(K);
			String letter = Character.toString(charAt);
			if(letter.equals(" ")) {
				return message.substring(0, K);
			}else {
//				check the position of the next char to see if this is the end of a word
				charAt = message.charAt((K+1));
				letter = Character.toString(charAt);
				if(letter.equals(" ")) {
					return message.substring(0, (K + 1));
				}else {
//					return the cropping message when K is in the middle of a word
					String[] split = message.substring(0, (K + 1)).split(" ");
					String[] copyOf = Arrays.copyOf(split, split.length - 1);
					return String.join(" ", copyOf);
				}
			}
		}
    }
	
	public int solution(int[] A) {
		final int totalFumeEmition = Arrays
				.stream(A)
				.boxed()
				.reduce(0, (a, b) -> a + b);
		final float halfEEmition = totalFumeEmition / 2f;
		
		List<Float> factories = Arrays
		.stream(A)
		.boxed()
		.map(Integer::floatValue)
		.collect(Collectors.toList());
		
		Collections.sort(factories);
        Collections.reverse(factories);
        
        
	
		float rs;
		int filters = 1;
		float totalTmp = totalFumeEmition;
		for (int i = 0; i < factories.size(); i++) {
			rs = factories.get(0) / 2f;
			if(rs < 0) {
				continue;
			}
        	totalTmp = totalTmp - rs;
        	if(totalTmp <= halfEEmition) {
        		return filters;
        	}else {
        		i = 0;
        		factories.set(i, rs);
        		filters++;
        	}
		}
        return 0;
    }

}
