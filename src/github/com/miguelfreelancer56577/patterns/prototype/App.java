package github.com.miguelfreelancer56577.patterns.prototype;

import github.com.miguelfreelancer56577.patterns.prototype.entity.User;

public class App {
	public static void main(String[] args) {
		User user = new User("Luis", 1);
		System.out.println(user);
		try {
			Object clone = user.clone();
			user.setId(2);
			System.out.println(clone);
			System.out.println(user);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
