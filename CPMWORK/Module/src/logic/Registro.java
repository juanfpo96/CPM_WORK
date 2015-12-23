package logic;

import java.util.ArrayList;

public class Registro {

	private ArrayList<Usuario> users;
	
	public void addUser(Usuario user){
		users.add(user);
	}
	
	public void deleteAllTemporal(){
		for (Usuario user : users){
			if (user.isTemporal()){
				deleteUser(user);
			}
		}
	}
	
	public void deleteUser(Usuario user){
		users.remove(user);
	}
}
