package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service;

import java.util.Objects;
import java.util.Optional;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;

public class SecondNameValidator extends Validator<UserDTO> {

	@Override
	public Optional<ErrorMessage> verify(UserDTO element) {
		
		if(Objects.isNull(element) || Objects.isNull(element.getSecondName())) {
			return Optional.of(new ErrorMessage("Second name cannot be blank"));
		}
		
		if(element.getSecondName().startsWith("R")) {
			return Optional.of(new ErrorMessage("Second name cannot start with R"));
		}
		
		return verifyNext(element);
	}

}
