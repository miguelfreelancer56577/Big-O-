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
    	ListNode dummy_head=new ListNode(0); // create a dummy node to return result
        ListNode l3=dummy_head;
        int carry=0;
        while(l1!=null ||  l2!=null){
            //These two line specify that if any list having less number of node than other, then zero will be                      placed in that position
            int l1_val=(l1!=null)?l1.val:0;
            int l2_val=(l2!=null)?l2.val:0;
            
            //System.out.println(l1_val+","+l2_val);
           // Logic For Sum
            int current_sum=l1_val+l2_val+carry;
            carry=current_sum/10;
            int last_digit=current_sum%10;
            //System.out.println(last_digit);
            
            ListNode new_node=new ListNode(last_digit);
            l3.next=new_node;
            
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            l3=l3.next;
            
        }
        if(carry>0){
            ListNode new_node=new ListNode(carry);
            l3.next=new_node;
            l3=l3.next;
        }
        
        return dummy_head.next;
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
 