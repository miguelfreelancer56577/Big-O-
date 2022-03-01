package github.com.miguelfreelancer56577.patterns.prototype.entity;

public class User implements Cloneable{

	private String name;
	private Integer id;
	
	public User(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new User("new", 0);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
	
}
