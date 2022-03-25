package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service;

import java.util.Optional;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;

public class FirstNameValidator extends Validator<UserDTO> {

	@Override
	public Optional<ErrorMessage> verify(UserDTO element) {
		
		if(Optional.ofNullable(element).isEmpty()) {
			return Optional.of(new ErrorMessage("First name cannot be blank"));
		}
		
		return verifyNext(element);
	}

}
