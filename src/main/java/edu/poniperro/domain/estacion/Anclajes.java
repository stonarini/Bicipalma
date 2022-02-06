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

	protected Anclaje[] anclajes() {
		return this.anclajes;
	}

	protected int numAnclajes() {
		return this.anclajes.length;
	}

	protected void ocuparAnclaje(Movil bici, int anclaje) {
		this.anclajes[anclaje].anclarBici(bici);
	}

	protected boolean isAnclajeOcupado(int anclaje) {
		return this.anclajes[anclaje].isOcupado();
	}

	protected void liberarAnclaje(int anclaje) {
		this.anclajes[anclaje].liberarBici();
	}

	protected Movil getBiciAt(int anclaje) {
		return this.anclajes[anclaje].getBici();
	}

	protected int seleccionarAnclaje() {
		return 0;
	}

	@Override
	public String toString() {
		return "Anclaje con " + this.numAnclajes() + " Anclajes";
	}
}
