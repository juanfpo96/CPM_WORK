package logic;

import java.util.Date;

public class Cruise {

	public final static boolean UNDER16 = true;
	public final static boolean NOTUNDER16 = false;

	private String codigoCrucero;
	private String zona;
	private String denominacion;
	private String puertoSalida;
	private String itinerario;
	private String descripcion;
	private boolean aptoMenores;
	private int duration; // in days
	private Date[] fechasSalida;
	private Ship barco;
	private boolean descuento;
	private String[][] reservas;
	private String imgRoute;

	public Cruise(String codigoCrucero, String zona, String denominacion, String puertoSalida, String itinerario,
			String descripcion, boolean aptoMenores, int duration, Date[] fechasSalida, Ship barco,
			String[][] reservas) {
		super();
		this.codigoCrucero = codigoCrucero;
		this.zona = zona;
		this.denominacion = denominacion;
		this.puertoSalida = puertoSalida;
		this.itinerario = itinerario;
		this.descripcion = descripcion;
		this.aptoMenores = aptoMenores;
		this.duration = duration;
		this.fechasSalida = fechasSalida;
		this.barco = barco;
		this.reservas = reservas;
		imgRoute = "/img/" + codigoCrucero + ".jpg";
	}

	public String getCodigoCrucero() {
		return codigoCrucero;
	}

	public void setCodigoCrucero(String codigoCrucero) {
		this.codigoCrucero = codigoCrucero;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public String getPuertoSalida() {
		return puertoSalida;
	}

	public void setPuertoSalida(String puertoSalida) {
		this.puertoSalida = puertoSalida;
	}

	public String getItinerario() {
		return itinerario;
	}

	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isAptoMenores() {
		return aptoMenores;
	}

	public void setAptoMenores(boolean aptoMenores) {
		this.aptoMenores = aptoMenores;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date[] getFechasSalida() {
		return fechasSalida;
	}

	public void setFechasSalida(Date[] fechasSalida) {
		this.fechasSalida = fechasSalida;
	}

	public Ship getBarco() {
		return barco;
	}

	public void setBarco(Ship barco) {
		this.barco = barco;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public boolean isDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}

	public String getImgRoute() {
		return imgRoute;
	}

	/*
	 * ///////////////////////////////////////// //END SETTERS AND
	 * GETTERS//////////////// /////////////////////////////////////////
	 */

	@Override
	public String toString() {
		return denominacion;
	}

	public String[][] getReservas() {
		return reservas;
	}

	public void addReserva(String[] reserva) {
		String date = reserva[1];
		for (int i=0; i<reservas.length;i++){
			if (reservas[i][1].equals(date)){
				reservas[i]=reserva;
			}
		}
	}

	public String[] getReserva(String date) {
		for (String[] r : reservas) {
			if (r[1].equals(date)) {
				return r;
			}
		}
		System.out.println("There are not previously reserved cabins");
		return null;
	}
	
	public int[] returnFree(String date){
		String[] reservados = new String[6];
		int[] freeCabins=new int[4];
		for (String[] r : reservas) {
			if (r[1].equals(date)) {
				reservados=r;
			}
		}
		freeCabins[0]=(int) (getBarco().getCamDobInt()-Integer.parseInt(reservados[2]));
		freeCabins[1]= (int) (getBarco().getCamDobExt()-Integer.parseInt(reservados[3]));
		freeCabins[2]=(int) (getBarco().getCamFamInt()-Integer.parseInt(reservados[4]));
		freeCabins[3]=(int) (getBarco().getCamFamExt()-Integer.parseInt(reservados[5]));
		
		return freeCabins;
	}

	public void setReservas(String[][] reservas) {
		this.reservas = reservas;
	}

}
