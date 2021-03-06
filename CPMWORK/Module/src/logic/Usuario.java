package logic;

import java.util.Arrays;

public class Usuario {

	private char[] password;
	
	private String name;
	private String surname;
	private String ID;
	private String phoneNumber;
	private String email;
	private boolean temporal=false;
	

	public Usuario(String iD, char[] password, String name, String surname, String phoneNumber, String email) {
		super();
		this.password = password;
		//in IGU create another field for password checking, and take into account if they are equal before storing.
		this.name = name;
		this.surname = surname;
		ID = iD;
		this.phoneNumber = phoneNumber;
		this.email = email;
		//Paypal Account is optional.
	}

	
	
	
	public Usuario(String iD,String name, String surname, String phoneNumber,
			String email) {
		super();
		//AutoGenerated password for one time identification.
		/*SecureRandom rSecureRandom = new SecureRandom();
		String password= new BigInteger(130, rSecureRandom).toString(32);
		this.password=password;
		*/
		this.name = name;
		this.surname = surname;
		ID = iD;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.temporal=true;
	}




	public boolean isUserCorrect(String ID, char[] pass){
		return (ID.equalsIgnoreCase(this.ID)&& Arrays.equals(pass,password));
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isTemporal() {
		return temporal;
	}
	@Override
	public String toString(){
		return ID + ";" + String.valueOf(password) + ";" + name +";"+ surname + ";" + phoneNumber + ";" + email;
	}
	
	
}
