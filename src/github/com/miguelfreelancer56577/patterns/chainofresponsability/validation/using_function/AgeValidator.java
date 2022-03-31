package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.using_function;

import java.util.Objects;
import java.util.Optional;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ValidationResult;

public class AgeValidator implements Validator<UserDTO> {

	@Override
	public ValidationResult<UserDTO> apply(ValidationResult<UserDTO> wrapper) {
		Objects.requireNonNull(wrapper);
		final UserDTO validate = wrapper.toValidate();
		
		if(Optional.ofNullable(validate.getAge()).isEmpty()) {
			wrapper.setError(new ErrorMessage("Age cannot be blank"));
		}
		
		if(validate.getAge() > 50) {
			wrapper.setError(new ErrorMessage("Your age must be under 50 years old"));
		}
		
		return wrapper;
	}

}
