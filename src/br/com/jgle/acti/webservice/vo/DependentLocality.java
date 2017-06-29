package br.com.jgle.acti.webservice.vo;

public class DependentLocality {

	private String dependentLocalityName;
	private Thoroughfare thoroughfare;
	private PostalCode postalCode;

	public String getDependentLocalityName() {
		return dependentLocalityName;
	}

	public void setDependentLocalityName(String dependentLocalityName) {
		this.dependentLocalityName = dependentLocalityName;
	}

	public Thoroughfare getThoroughfare() {
		return thoroughfare;
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		this.thoroughfare = thoroughfare;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

}
