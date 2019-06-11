package src.model;

import java.io.Serializable;




public class AirDevice  {

	private int idDevice;

	private String country;

	private String date;

	private int number;

	private String state;
	private String latitude;
	private String longitude;

	public AirDevice() {
	}

	public AirDevice(String country,String state,int number, String date) {
		super();
		this.country = country;
		this.state = state;
		this.number=number;
		this.date = date;
	}
	
	public AirDevice(int id ,String country,String state,int number, String date) {
		super();
		this.idDevice=id;
		this.country = country;
		this.state = state;
		this.number=number;
		this.date = date;
	}
	public int getIdDevice() {
		return this.idDevice;
	}

	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}