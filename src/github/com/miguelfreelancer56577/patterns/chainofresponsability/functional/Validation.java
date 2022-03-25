package github.com.miguelfreelancer56577.patterns.chainofresponsability.functional;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;

public interface Validation {

	void validate(UserDTO user );
	
}
