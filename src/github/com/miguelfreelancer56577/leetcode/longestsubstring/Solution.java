package github.com.miguelfreelancer56577.leetcode.longestsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String string = "pwwkew";
//		abcdh
		int lengthOfLongestSubstring = sol.lengthOfLongestSubstring2(string);
		System.out.println("Longest substring: " + lengthOfLongestSubstring);
	}
	
    public int lengthOfLongestSubstring(String s) {
        int[] character = new int[128];
        int result = 0;
        int j = 0;
        int temp = 0;
        for(int i = 0; i < s.length(); i++){
            if(character[s.charAt(i)] == 0){
                character[s.charAt(i)] = 1;
                temp = temp + 1;
                result = Math.max(result, temp);
            }else{
                while(character[s.charAt(i)] == 1){
                    character[s.charAt(j)] = 0;
                    temp = temp - 1;
                    j++;
                }
                character[s.charAt(i)] = 1;
                temp = temp + 1;
            }
        }
        return result;
    }
    
    public int myLengthOfLongestSubstring(String s) {
    	List<String> collect = s
        		.chars()
        		.mapToObj(String::valueOf)
        		.collect(Collectors.toList());
    	long realLength = collect.stream().distinct().count();
    	if(realLength == 0) {
    		return 0;
    	}
    	else if(realLength == collect.size()) {
    		return collect.size();
    	}
    	Set<String> longestSubstring = new LinkedHashSet<>(collect.subList(1, collect.size()));
    	
    	return longestSubstring.size();
    }
    
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right),right);
            maxLen = Math.max(maxLen, right-left + 1);
            right++;
        }
        return maxLen;
    }
}