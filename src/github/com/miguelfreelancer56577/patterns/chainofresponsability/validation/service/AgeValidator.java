package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service;

import java.util.Optional;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;

public class AgeValidator extends Validator<UserDTO> {

	@Override
	public Optional<ErrorMessage> verify(UserDTO element) {
		
		if(Optional.ofNullable(element.getAge()).isEmpty()) {
			
			return Optional.of(new ErrorMessage("First name cannot be blank"));
		}
		
		if(element.getAge() > 50) {
			return Optional.of(new ErrorMessage("Your age must be under 50 years old"));
		}
		
		return verifyNext(element);
	}

}
