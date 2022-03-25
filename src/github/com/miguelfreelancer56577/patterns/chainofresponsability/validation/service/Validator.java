package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.service;

import java.util.Optional;

import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;

public abstract class Validator<T> {
	
	private Validator<T> next;
	
	public void setNext(Validator<T> next){
		this.next = next;
	}
	
	public abstract Optional<ErrorMessage> verify(T element);
	
	protected Optional<ErrorMessage> verifyNext(T element) {
		if(Optional.ofNullable(next).isEmpty()) {
			return Optional.empty();
		}
		return next.verify(element);
	}

}
