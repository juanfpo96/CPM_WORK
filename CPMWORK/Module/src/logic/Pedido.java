package logic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Pedido {

	private long codigoPedido;
	private int adults;
	private int kids;
	private int menores;
	private long camDobInt;
	private long camDobExt;
	private long camFamInt;
	private long camFamExt;
	private int camasExtra;
	private Cruise crucero;
	private Usuario usuario;
	private ArrayList<Extra> extras;
	private double precioCamarotes;
	private double precioExtras;
	private double precioDescuento;
	private double precioFinal;
	private ArrayList<Room> rooms;

	public Pedido() {
		codigoPedido = new Random().nextLong();
		extras= new ArrayList<>();
		rooms=new ArrayList<>();
	}

	public boolean personasCorrectas() {
		if (kids<camasExtra){
			return false;
		}
		int kids= this.kids - camasExtra;
		long totalPeople = camDobExt * 2 + camDobInt * 2 + camFamExt * 5 + camFamInt * 5;
		
		if ((adults+kids) <= totalPeople) {
			return true;
		} else {
			return false;
		}
	}

	public double precioCamarotes() {
		Ship barco = crucero.getBarco();
		precioCamarotes = (barco.getPrecioCamDobExt() * camDobExt) + (barco.getPrecioCamDobInt() * camDobInt)
				+ (barco.getPrecioCamFamExt() * camFamExt) + (barco.getPrecioCamFamInt() * camFamInt);
		return precioCamarotes;

	}

	public double precioExtras() {
		for (Extra e : extras) {
			precioExtras += e.getPrecio();
		}
		return precioExtras;
	}
	
	public double precioDescuento(){
		if (crucero.isDescuento()){
			return precioCamarotes*0.15;
		}
		else {
			return 0;
		}
	}

	public void addExtra(Extra extra) {
		extras.add(extra);
	}

	public void removeExtra(Extra extra) {
		extras.remove(extra);
	}

	public int getMenores() {
		return menores;
	}

	public void setMenores(int menores) {
		this.menores = menores;
	}

	public long getCamDobInt() {
		return camDobInt;
	}

	public void setCamDobInt(long camDobInt) {
		this.camDobInt = camDobInt;
	}

	public long getCamDobExt() {
		return camDobExt;
	}

	public void setCamDobExt(long camDobExt) {
		this.camDobExt = camDobExt;
	}

	public long getCamFamInt() {
		return camFamInt;
	}

	public void setCamFamInt(long camFamInt) {
		this.camFamInt = camFamInt;
	}

	public long getCamFamExt() {
		return camFamExt;
	}

	public void setCamFamExt(long camFamExt) {
		this.camFamExt = camFamExt;
	}

	public long getCamaExtra() {
		return camasExtra;
	}

	public void addCamaExtra() {
		camasExtra++;
	}

	public Cruise getCrucero() {
		return crucero;
	}

	public void setCrucero(Cruise crucero) {
		this.crucero = crucero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getCodigoPedido() {
		return codigoPedido;
	}
	public void addRoom(Room room){
		rooms.add(room);
		if (room.getCam()==1){
			camDobInt++;
		}
		else if (room.getCam()==2) {
			camDobExt++;
		}
		else if (room.getCam()==3) {
			camFamInt++;
		}
		else if (room.getCam()==4){
			camFamExt++;
		}
		if (room.isCamaExtra()){
			camasExtra++;
		}
		adults=adults+room.getAdults();
		kids=kids+room.getKids();
		extras.addAll(room.getExtras());
		
	}
	public void removeRoom(int index){
		Room room=rooms.remove(index);
		if (room.getCam()==1){
			camDobInt--;
		}
		else if (room.getCam()==2) {
			camDobExt--;
		}
		else if (room.getCam()==3) {
			camFamInt--;
		}
		else if (room.getCam()==4){
			camFamExt--;
		}
		if (room.isCamaExtra()){
			camasExtra--;
		}
		adults=adults-room.getAdults();
		kids=kids-room.getKids();
		extras.removeAll(room.getExtras());
		
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}
	
	
}
