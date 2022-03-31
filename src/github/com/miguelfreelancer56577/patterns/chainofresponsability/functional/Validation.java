package github.com.miguelfreelancer56577.patterns.chainofresponsability.functional;

public interface Validation<T> {

	void validate(T toValidate);
	
}
