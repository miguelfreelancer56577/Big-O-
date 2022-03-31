package github.com.miguelfreelancer56577.patterns.chainofresponsability.validation.pojo;

public class ErrorMessage {
	
	String mesasage;

	public ErrorMessage(String mesasage) {
		super();
		this.mesasage = mesasage;
	}

	public String getMesasage() {
		return mesasage;
	}

	public void setMesasage(String mesasage) {
		this.mesasage = mesasage;
	}

	@Override
	public String toString() {
		return "ErrorMessage [mesasage=" + mesasage + "]";
	}
	
}
