package E07.model;

import java.util.ArrayList;
import java.util.Stack;

public class Jugador {
	
	private Stack<Carta> cartas;

	
	/*CONSTRUCTORES*/

	public Jugador(Baraja cartas) {
		this.cartas.add(cartas.cogerCarta());
		
		
	}

	public Jugador(Stack<Carta> cartas) {
		for (int i = 0; i < cartas.size(); i++) {
			this.cartas.add(cartas.get(i));
		}

	}
	
	/*METODO PARA COGER CARTA*/
	
	public Carta cogerCarta(Baraja cartas) {
		return cartas.cogerCarta();
	}
	
	

	/* GETTERS & SETTERS */
	
	public Stack<Carta> getCartas() {
		return cartas;
	}

	public Carta getCarta(int i) {
		return this.cartas.get(i);
	}

	public void setCartas(Carta carta) {
		this.cartas.add(carta);
	}

	@Override
	public String toString() {
		return "Jugador [cartas=" + cartas + "]";
	}

}
