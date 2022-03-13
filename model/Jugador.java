package E07.model;

import java.util.ArrayList;
import java.util.Stack;

public class Jugador {
	
	private String nombre;
	private Stack<Carta> cartas;

	
	/*CONSTRUCTORES*/

	public Jugador(Baraja cartas, String name) {
		this.nombre= name;
		this.cartas = new Stack <Carta>();
		Carta carta1 = cartas.cogerCarta();
		Carta carta2 = cartas.cogerCarta();
		
		this.cartas.push(carta1);
		this.cartas.push(carta2);
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
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
