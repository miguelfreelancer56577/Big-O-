package github.com.miguelfreelancer56577.patterns.chainofresponsability.functional;

import java.util.function.Consumer;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;

public class App {

	public static void main(String[] args) {
		
		UserDTO user = UserDTO
			.builder()
			.withAge(34)
			.withFirstName("Pepe")
			.withSecondName("Sanchez")
			.build();
		
		ValidationAvailable validationAvailable = new ValidationAvailable();
		ValidationDuplicated validationDuplicated = new ValidationDuplicated(); 
		ValidationFileds validationFileds = new ValidationFileds(); 
		
		Consumer<UserDTO> chain1 = validationAvailable::validate;
		Consumer<UserDTO> chain2 = validationDuplicated::validate;
		Consumer<UserDTO> chain3 = validationFileds::validate;
		
		chain1
			.andThen(chain3)
			.andThen(chain2)
			.accept(user);
		
	}

}
