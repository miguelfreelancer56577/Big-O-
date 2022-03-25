package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo;

import java.util.Objects;

import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service.Validator;

public final class ValidatorBuilder<T> {
	
	private Validator<T> head;
	private Validator<T> tail;
	
	public ValidatorBuilder<T> withValidator(Validator<T> validator){
		if (Objects.isNull(head)) {
			head = validator;
			tail = validator;
            return this;
        }
		tail.setNext(validator);
        tail = validator;
		return this;
	}
	
	public Validator<T> build(){
		return head;
	}
}
