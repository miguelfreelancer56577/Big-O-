package github.com.miguelfreelancer56577.patterns.builder.dto;

public class UserDTO {

	String firstName; 
	String secondName; 
	int age;
	
	public UserDTO(String firstName, String secondName, int age){
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public int getAge() {
		return age;
	}

	public static final UserDTOBuilder builder() {
		return new UserDTOBuilder();
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", secondName=" + secondName + ", age=" + age + "]";
	}
	
	public static class UserDTOBuilder{
		
		String firstName; 
		String secondName; 
		int age;
		
		public UserDTOBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public UserDTOBuilder withSecondName(String secondName) {
			this.secondName = secondName;
			return this;
		}
		
		public UserDTOBuilder withAge(int age) {
			this.age = age;
			return this;
		}
		
		public UserDTO build() {
			return new UserDTO(firstName, secondName, age);
		}
		
	}
	
}