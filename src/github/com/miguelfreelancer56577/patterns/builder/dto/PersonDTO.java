package github.com.miguelfreelancer56577.patterns.builder.dto;

import java.util.function.Consumer;

public class PersonDTO {

	String firstName; 
	String secondName; 
	int age;
	
	public PersonDTO(String firstName, String secondName, int age){
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}
	
	public static final PersonDTOBuilder builder() {
		return new PersonDTOBuilder();
	}

	@Override
	public String toString() {
		return "PersonDTO [firstName=" + firstName + ", secondName=" + secondName + ", age=" + age + "]";
	}
	
	public static class PersonDTOBuilder{
		
		public String firstName; 
		public String secondName; 
		public int age;
		
		public PersonDTOBuilder with(Consumer<PersonDTOBuilder> builderFunc) {
			builderFunc.accept(this);
			return this;
		}
		
		public PersonDTO build() {
			return new PersonDTO(firstName, secondName, age);
		}
		
	}
	
}