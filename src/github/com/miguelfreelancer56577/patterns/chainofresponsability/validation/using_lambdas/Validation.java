package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.using_lambdas;

import java.util.Optional;

import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;

public interface Validation<T> {
	boolean isValid(T toValidate);
	Optional<ErrorMessage> valid(T toValidate);
}
