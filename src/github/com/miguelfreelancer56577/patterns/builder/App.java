package github.com.miguelfreelancer56577.patterns.builder;

import github.com.miguelfreelancer56577.patterns.builder.dto.PersonDTO;
import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;

//Reference https://ranjithraj-d.medium.com/java-8-lambda-enabled-design-patterns-64e0064cf4a5

public class App {
	
	public static void main(String[] args) {
		UserDTO user = UserDTO
						.builder()
						.withAge(23)
						.withFirstName("Pepe")
						.build();
		System.out.println(user);
		
		PersonDTO person = PersonDTO
			.builder()
			.with(builder->{
				builder.firstName = user.getFirstName();
				builder.secondName = user.getSecondName();
				builder.age = user.getAge();
			})
//			.with(builder->builder.firstName = "Paco")
//			.with(builder->builder.secondName = "Solis")
//			.with(builder->builder.age = 34)
			.build();
		System.out.println(person);
		
	}

}
