package github.com.miguelfreelancer56577.patterns.chainofresponsability.functional;

import java.util.function.Consumer;
import java.util.function.Function;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;

public class App {

	public static void main(String[] args) {
		
		Function t = null;
		
		UserDTO user = UserDTO
			.builder()
			.withAge(34)
			.withFirstName("Pepe")
			.withSecondName("Sanchez")
			.build();
		
		Consumer<UserDTO> chain1 = new ValidationAvailable()::validate;
		
		chain1
			.andThen(new ValidationDuplicated()::validate)
			.andThen(new ValidationFileds()::validate)
			.accept(user);
		
	}

}
