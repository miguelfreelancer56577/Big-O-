package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.using_function;

import java.util.function.UnaryOperator;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ValidationResult;

public class App {

	public static void main(String[] args) {
		
		final UserDTO user = new UserDTO("L", "Tenteri", 51);
		
		ValidationResult<UserDTO> rs = new ValidationResult<>(user);
		
		UnaryOperator<ValidationResult<UserDTO>> validator = new FirstNameValidator()::apply;
		
		rs = validator
			.andThen(new SecondNameValidator()::apply)
			.andThen(new AgeValidator()::apply)
			.apply(rs);
		
		rs.getErrors().stream().forEach(msg->System.out.println(msg.getMesasage()));
		
	}

}
