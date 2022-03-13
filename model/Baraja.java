package E07.model;

import java.util.Collections;
import java.util.Stack;

import E07.error.ReportErrores;

public class Baraja {

	private Stack<Carta> cartas;

	public Baraja() throws ReportErrores{
		this.cartas = new Stack<Carta>();
		this.generateBaraja();
	}

	
	/* METODOS */
	public void generateBaraja() throws ReportErrores{

		for(int i=0;i<4;i++) {
			for(int j=1;j<14;j++) {
				switch(i) {
					case 0:
						this.cartas.add(new Cor(j));
						break;

					case 1:
						this.cartas.add(new Diamant(j));
						break;
					
					case 2:
						this.cartas.add(new Pica(j));
						break;
					
					case 3:
						this.cartas.add(new Trebol(j));
						break;	
				}
			}
		}
		Collections.shuffle(this.cartas);
	}

	public int size() {
		return this.cartas.size();
	}
	
	
	public Carta cogerCarta() {
		return this.cartas.pop();
	}
	
	
	

}
