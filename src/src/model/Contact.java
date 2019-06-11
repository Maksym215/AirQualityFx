package src.model;



/**
 * The persistent class for the contact database table.
 * 
 */

public class Contact   {


	private int idDevice;

	private int userId;

	public Contact() {
	}

	public int getIdDevice() {
		return this.idDevice;
	}

	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}