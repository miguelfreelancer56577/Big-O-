package github.com.miguelfreelancer56577.java11course.how_to_use_streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO;
import github.com.miguelfreelancer56577.patterns.builder.dto.UserDTO.UserDTOBuilder;

public class App {
	public static void main(String[] args) {
		List<UserDTO> users = createUsers(); 
//		List<UserDTO> users = Collections.emptyList(); 
		
		users
			.stream()
			.collect(Collectors.groupingBy(
											UserDTO::getAge,
											Collectors.counting()))
			.forEach((key,val)->
				System.out.println("There are: " + val + " people with this age: " + key));
		
		
		Map<Integer, Map<String, List<UserDTO>>> collect = users
				.stream()
				.collect(Collectors.groupingBy(
												UserDTO::getAge,
												Collectors.groupingBy(UserDTO::getSecondName)));
			
			System.out.println(collect);
			
			users
				.stream()
				.collect(Collectors.groupingBy(
												UserDTO::getAge))
				.forEach((key,val)->
					System.out.println("USING GROUPBY -> KEY: "+ key + " \n" + "VALUE: " + val));
			
	}
	
	public static List<UserDTO> createUsers() {
		
		List<UserDTO> users = new ArrayList<>();
		
		users.add(new UserDTOBuilder()
					.withAge(45)
					.withFirstName("pepe")
					.withSecondName("Martinez")
					.build());
		users.add(new UserDTOBuilder()
				.withAge(45)
				.withFirstName("Martha")
				.withSecondName("Linares")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(45)
				.withFirstName("Marcos")
				.withSecondName("Linares")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(45)
				.withFirstName("Juan")
				.withSecondName("Linares")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(47)
				.withFirstName("Carlos")
				.withSecondName("Ortiz")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(47)
				.withFirstName("Mike")
				.withSecondName("Torres")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(47)
				.withFirstName("pepe")
				.withSecondName("Martinez")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(40)
				.withFirstName("laura")
				.withSecondName("ortiz")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(40)
				.withFirstName("lalo")
				.withSecondName("Renteria")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(81)
				.withFirstName("mari")
				.withSecondName("Alvarez")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(81)
				.withFirstName("karoly")
				.withSecondName("Solis")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(81)
				.withFirstName("Maria")
				.withSecondName("Solis")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(81)
				.withFirstName("Carlota")
				.withSecondName("Solis")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(81)
				.withFirstName("vane")
				.withSecondName("Sanchez")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(81)
				.withFirstName("Angela")
				.withSecondName("Torres")
				.build());
		users.add(new UserDTOBuilder()
				.withAge(20)
				.withFirstName("Adriana")
				.withSecondName("Gabriel")
				.build());
		
		return users;
	}
	
}
