package E07.model;

public abstract class Carta {

	private int numero;
	private boolean vista;

	public Carta(int pNumero) {
		this.numero = pNumero;
		this.vista = false;
	}

	/* GETTERS & SETTERS */

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setVista(boolean vista) {
		this.vista = vista;
	}

	public boolean getVista() {
		return this.vista = !this.vista;
	}

}
