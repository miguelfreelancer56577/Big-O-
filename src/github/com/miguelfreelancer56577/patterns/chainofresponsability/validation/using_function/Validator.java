package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.using_function;

import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ValidationResult;

interface Validator<T> {
	
	ValidationResult<T> apply(ValidationResult<T> wrapper);
	
}
