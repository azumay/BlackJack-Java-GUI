package E07.model;

import java.util.Collections;
import java.util.Stack;

public class Baraja {

	private Stack<Carta> cartas;

	public Baraja() {
		this.cartas = new Stack<Carta>();
		generateBaraja();
	}

	
	/* METODOS */
	public void generateBaraja() {

		for (int i = 1; i < 14; i++) {

			this.generateCartas(i, "Cor");
			this.generateCartas(i, "Diamant");
			this.generateCartas(i, "Pica");
			this.generateCartas(i, "Trebol");

		}
		Collections.shuffle(cartas);

	}

	public void generateCartas(int num, String tipo) {
		switch (tipo) {
		case "Cor":
			this.cartas.add(new Cor(num));
			break;
		case "Diamant":
			this.cartas.add(new Diamant(num));
			break;
		case "Pica":
			this.cartas.add(new Pica(num));
			break;
		case "Trebol":
			this.cartas.add(new Trebol(num));
			break;
		default:
			break;
		}
		
	}

	
	public Carta cogerCarta() {
		return cartas.pop();
	}
	
	
	
	public Stack<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(Stack<Carta> cartas) {
		this.cartas = cartas;
	}

}
