package br.com.jgle.acti.webservice.vo;

public class Locality {

	private String localityName;
	private DependentLocality dependentLocality;

	public String getLocalityName() {
		return localityName;
	}

	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}

	public DependentLocality getDependentLocality() {
		return dependentLocality;
	}

	public void setDependentLocality(DependentLocality dependentLocality) {
		this.dependentLocality = dependentLocality;
	}

}
