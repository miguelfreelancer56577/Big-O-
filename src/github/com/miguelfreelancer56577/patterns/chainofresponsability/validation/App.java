package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation;

import java.util.Optional;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ValidatorBuilder;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service.AgeValidator;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service.FirstNameValidator;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service.SecondNameValidator;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service.Validator;

public class App {
	public static void main(String[] args) {
		
		UserDTO user = new UserDTO("Miguel", "Tenteria", 45);
		
		Validator<UserDTO> userValidator = new ValidatorBuilder<UserDTO>()
			.withValidator(new FirstNameValidator())
			.withValidator(new SecondNameValidator())
			.withValidator(new AgeValidator())
			.build();
		
		Optional<ErrorMessage> error = userValidator.verify(user);
		
		error.ifPresent(msg->{
			throw new RuntimeException(msg.getMesasage());
		});
		
	}
}
