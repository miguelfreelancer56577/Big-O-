package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.using_lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO.UserDTOBuilder;
import github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo.ErrorMessage;

public class ValidateUser implements Validation<UserDTO> {

	@Override
	public boolean isValid(UserDTO toValidate) {
		
		Optional<UserDTO> optUser = Optional.ofNullable(toValidate);
		
		Predicate<UserDTO> validationEmpty = u->Objects.nonNull(u.getFirstName());
		validationEmpty = validationEmpty.and(u->Objects.nonNull(u.getSecondName()));
		validationEmpty = validationEmpty.and(u->u.getAge() > 0);
		
		Predicate<UserDTO> validationBlank= u->u.getFirstName().isBlank();
		validationBlank = validationBlank.or(u->u.getSecondName().isBlank());
		
		
		return optUser
					.stream()
					.filter(validationEmpty)
					.filter(validationBlank.negate())
					.map(user->true)
					.findFirst()
					.orElse(false);
		
	}
	
	@Override
	public Optional<ErrorMessage> valid(UserDTO toValidate) {
		
		List<ErrorMessage> errors = new ArrayList<>();
		
		Optional<UserDTO> optUser = Optional.ofNullable(toValidate);
		
		BiPredicate<BooleanSupplier, Supplier<ErrorMessage>> validate = (supp1, supp2)->{
			boolean rs = supp1.getAsBoolean();
			if(!rs) {
				errors.add(supp2.get());
			}
			return rs;
		};
		
		Optional<UserDTO> findFirst = optUser
			.stream()
			.filter(u->
						validate
						.test(()->Objects.nonNull(u.getFirstName()),
								()->new ErrorMessage("First Name cannot be null")))
			.filter(u->
						validate
						.test(()->Objects.nonNull(u.getSecondName()),
								()->new ErrorMessage("Second Name cannot be null")))
			.filter(u->
						validate
						.test(()->u.getAge() > 0,
								()->new ErrorMessage("Your age must be under 50 years old")))
			.filter(u->
						validate
						.test(()->!u.getFirstName().isBlank(),
								()->new ErrorMessage("First Name cannot be blank")))
			.filter(u->
						validate
						.test(()->!u.getSecondName().isBlank(),
								()->new ErrorMessage("Second Name cannot be blank")))
			.findFirst();
		
		
		if(findFirst.isEmpty()) {
			return errors.stream().findFirst();
		}else {
			return Optional.empty();
		}

	}
	
	public static void main(String[] args) {
		
		UserDTO user = new UserDTOBuilder()
							.withAge(3)
							.withFirstName("")
							.withSecondName("E")
							.build();
		
		ValidateUser validateUser = new ValidateUser();
		
		System.out.println("is User valid: " + validateUser.isValid(user));
		
		validateUser
			.valid(user)
			.ifPresent(u->System.out.println("Error message : " + u.getMesasage()));
		
		List<String> names = new ArrayList<>();
		
//		names.stream().collect(Collectors.)
		
	}

}
