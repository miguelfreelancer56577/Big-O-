package github.com.miguelfreelancer56577.leetcode.twosum;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = new int[]{2,7,11,15};
		int target = 9;
		int[] twoSum = sol.twoSum(nums, target);
		System.out.println("twoSum: "+ Arrays.toString(twoSum));
	}
	
//	Input: nums = [2,7,11,15], target = 9
//	Output: [0,1]
//	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	public int[] twoSum(int[] nums, int target) {
		int sum;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				sum = nums[i] + nums[j];
				if(sum == target) {
					return new int[] {i, j};
				}
			}
		}
        return new int[0];
    }
}
