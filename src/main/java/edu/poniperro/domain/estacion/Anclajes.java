package edu.poniperro.domain.estacion;

import edu.poniperro.domain.bicicleta.Movil;

public class Anclajes {
	private Anclaje[] anclajes;

	Anclajes(int numAnclajes) {
		this.anclajes = new Anclaje[numAnclajes];
		this.crearAnclajes();
	}

	private void crearAnclajes() {
		for (int i = 0; i < this.numAnclajes(); i++) {
			this.anclajes[i] = new Anclaje();
		}
	}

	Anclaje[] anclajes() {
		return this.anclajes;
	}

	int numAnclajes() {
		return this.anclajes.length;
	}

	void ocuparAnclaje(Movil bici, int anclaje) {
		this.anclajes[anclaje].anclarBici(bici);
	}

	boolean isAnclajeOcupado(int anclaje) {
		return this.anclajes[anclaje].isOcupado();
	}

	void liberarAnclaje(int anclaje) {
		this.anclajes[anclaje].liberarBici();
	}

	Movil getBiciAt(int anclaje) {
		return this.anclajes[anclaje].getBici();
	}

	int seleccionarAnclaje() {
		return 0;
	}

	@Override
	public String toString() {
		return "Anclaje con " + this.numAnclajes() + " Anclajes";
	}
}
