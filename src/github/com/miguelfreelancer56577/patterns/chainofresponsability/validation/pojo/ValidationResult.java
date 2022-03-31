package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult<T> {

	final List<ErrorMessage> errors = new ArrayList<>();
	
	final T toValidate;
	
	public ValidationResult(T validationObject) {
		this.toValidate = validationObject;
	}

	public List<ErrorMessage> getErrors() {
		return errors;
	}

	public void setError(ErrorMessage error) {
		this.errors.add(error);
	}

	public T toValidate() {
		return toValidate;
	}
	
}
