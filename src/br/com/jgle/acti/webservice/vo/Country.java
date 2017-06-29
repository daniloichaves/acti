package br.com.jgle.acti.webservice.vo;

public class Country {

	private String CountryNameCode;
	private String CountryName;
	private AdministrativeArea administrativeArea;

	public String getCountryNameCode() {
		return CountryNameCode;
	}

	public void setCountryNameCode(String countryNameCode) {
		CountryNameCode = countryNameCode;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public AdministrativeArea getAdministrativeArea() {
		return administrativeArea;
	}

	public void setAdministrativeArea(AdministrativeArea administrativeArea) {
		this.administrativeArea = administrativeArea;
	}

}
