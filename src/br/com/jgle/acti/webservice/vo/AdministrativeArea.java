package br.com.jgle.acti.webservice.vo;

public class AdministrativeArea {

	private String administrativeAreaName;
	private Locality locality;

	public String getAdministrativeAreaName() {
		return administrativeAreaName;
	}

	public void setAdministrativeAreaName(String administrativeAreaName) {
		this.administrativeAreaName = administrativeAreaName;
	}

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

}
