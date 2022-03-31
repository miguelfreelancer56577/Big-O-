package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;

public class SecondNameValidator extends Validator<UserDTO> {

	@Override
	public Optional<ErrorMessage> verify(UserDTO element) {
		
		Predicate<UserDTO> validationNotNull = Objects::isNull;
		validationNotNull.or(user->Objects.isNull(user.getSecondName()));
		
		Predicate<UserDTO> validationName = user->user.getSecondName().startsWith("R");
		validationName.or(user->user.getSecondName().endsWith("X"));
		
		if(validationNotNull.test(element)) {
			return Optional.of(new ErrorMessage("Second name cannot be blank"));
		}
		
		if(validationName.test(element)) {
			return Optional.of(new ErrorMessage("Second name cannot neither start with R nor end with X"));
		}
		
		return verifyNext(element);
	}

}
