package github.com.miguelfreelancer56577.leetcode.addtwonumbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
	
	BiConsumer<ListNode, List<String>> populateList = (lstNode, lstString) -> {
		ListNode iterator = lstNode;
    	while(Objects.nonNull(iterator)) {
    		lstString.add(Integer.toString(iterator.val));
    		iterator = iterator.next;
    	}
    	Collections.reverse(lstString);
	};
	
	Function<List<String>, String> numberCollector = lstString -> lstString.stream().collect(Collectors.joining(""));
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
			
		ListNode l1 = new ListNode(9);
		ListNode firstNode;
		ListNode l2 = new ListNode(1);
		firstNode = l2;
		for (int i = 0; i < 99; i++) {
			l2 = l2.next = new ListNode(9);
		}
		
		ListNode addTwoNumbers = sol.addTwoNumbers(l1, firstNode);
		
		ListNode iterator = addTwoNumbers;
		while(Objects.nonNull(iterator)) {
    		System.out.println("number: " + iterator.val);
    		iterator = iterator.next;
    	}
		
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	final List<String> firstList = new ArrayList<>();
    	final List<String> secondList = new ArrayList<>();
    	String firstNumber; 
    	String secondNumber; 
    	String total;
    	
    	populateList.accept(l1, firstList);
    	populateList.accept(l2, secondList);
    	
    	firstNumber = numberCollector.apply(firstList); 
    	secondNumber = numberCollector.apply(secondList);
    	
    	total = new BigInteger(firstNumber).add(new BigInteger(secondNumber)).toString();
    	
    	ListNode flag = null;
    	for (int i = 0; i < total.length(); i++) {
    		String currentNum = String.valueOf(total.charAt(i));
    		if(Objects.isNull(flag)) {
    			flag = new ListNode(Integer.parseInt(currentNum));
    		}else {
    			flag = new ListNode(Integer.parseInt(currentNum), flag);
    		}
		}
        return flag;
    }
    
}

//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
      
}
 