package github.com.miguelfreelancer56577.hackerrank;

import java.util.PriorityQueue;
import java.util.Queue;

public class JavaStructures {
	public static void main(String[] args) {  
		//Creating Deque and adding elements  
		Queue<A> deque = new PriorityQueue<A>();  
		deque.add(new A("Gautam"));  
		deque.add(new A("Karan"));  
		deque.add(new A("Ajay"));  
		//Traversing elements  
		for (A str : deque) {  
			System.out.println(str.toString());  
		}
		
		Queue<String> deque2 = new PriorityQueue<String>();  
		deque2.add("Gautam");  
		deque2.add("Karan");  
		deque2.add("Ajay");  
		//Traversing elements  
		for (String str : deque2) {  
			System.out.println(str);  
		}
	}   
}

class A implements Comparable<A>{
	String field;
	A(String field){
		this.field = field;
	}
	@Override
	public String toString() {
		return "A [field=" + field + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}
	@Override
	public int compareTo(A o) {
		if(o.field.equals(this.field)) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
