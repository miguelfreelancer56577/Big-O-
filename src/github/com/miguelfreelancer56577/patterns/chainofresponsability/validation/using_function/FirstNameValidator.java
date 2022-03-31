package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.using_function;

import java.util.Objects;
import java.util.function.Predicate;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ValidationResult;

public class FirstNameValidator implements Validator<UserDTO> {

	@Override
	public ValidationResult<UserDTO> apply(ValidationResult<UserDTO> wrapper) {
		final UserDTO validate = wrapper.toValidate();
		Predicate<UserDTO> isNotValidUser = Objects::isNull;
		isNotValidUser = isNotValidUser
			.or(user->Objects.isNull(user.getFirstName()))
			.or(user->user.getFirstName().isBlank());
		
		boolean test = isNotValidUser.test(validate);
		
		if(test) {
			wrapper.setError(new ErrorMessage("First name cannot be blank"));
		}
		
		return wrapper;
	}

}
