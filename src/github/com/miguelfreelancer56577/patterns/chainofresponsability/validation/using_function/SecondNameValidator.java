package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.using_function;

import java.util.Objects;
import java.util.function.Predicate;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ValidationResult;

public class SecondNameValidator implements Validator<UserDTO> {

	@Override
	public ValidationResult<UserDTO> apply(ValidationResult<UserDTO> wrapper) {
		
		final UserDTO validate = wrapper.toValidate();
		
		Predicate<UserDTO> validationNotNull = Objects::isNull;
		validationNotNull = validationNotNull.or(user->Objects.isNull(user.getSecondName()));
		
		Predicate<UserDTO> validationName = user->user.getSecondName().startsWith("R");
		validationName = validationName.or(user->user.getSecondName().endsWith("X"));
		
		if(validationNotNull.test(validate)) {
			wrapper.setError(new ErrorMessage("Second name cannot be blank"));
		}
		
		if(validationName.test(validate)) {
			wrapper.setError(new ErrorMessage("Second name cannot neither start with R nor end with X"));
		}
		
		return wrapper;
	}

}
