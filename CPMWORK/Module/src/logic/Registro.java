package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Registro {

	private ArrayList<Usuario> users;

	public Registro() {
		users = new ArrayList<>();
		leerFichero();
	}

	public void addUser(Usuario user) {
		users.add(user);
	}

	public void deleteUser(Usuario user) {
		users.remove(user);
	}

	public void leerFichero() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("data/users.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(";");
				users.add(new Usuario(trozos[0], trozos[1].toCharArray(), trozos[2], trozos[3], trozos[4], trozos[5]));

			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "The file wasn't found");
		} catch (IOException ioe) {
			new RuntimeException("Input/Output error");
		}
	}

	public void grabarFichero() {
		for (Usuario user : users) {
			if (user.isTemporal()) {
				deleteUser(user);
			} else {
				grabarFichero(user.toString());
			}
		}
	}

	private void grabarFichero(String linea) {
		String nombreFichero = "data/users.dat";
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
			fichero.write(linea);
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "File couldn't be saved");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Input/Output error");
		}
	}

	public Usuario getUser(String ID, char[] password) {
		for (Usuario user : users) {
			if (user.getID().equals(ID)) {
				if (user.isUserCorrect(ID, password)) {
					return user;
				}
				JOptionPane.showMessageDialog(null, "User exists in our database");
			}
		}
		return null;
	}

}
