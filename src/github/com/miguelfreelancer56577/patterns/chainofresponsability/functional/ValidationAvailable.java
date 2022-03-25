package github.com.miguelfreelancer56577.patterns.chainofresponsability.functional;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;

public class ValidationAvailable implements Validation{

	@Override
	public void validate(UserDTO user) {
		System.out.println("Validating user from [ValidationAvailable]");
	}

}
