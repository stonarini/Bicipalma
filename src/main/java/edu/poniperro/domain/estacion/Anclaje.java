package edu.poniperro.domain.estacion;

import edu.poniperro.domain.bicicleta.Movil;

public class Anclaje {
	private boolean ocupado;
	private Movil bici;

	Anclaje() {
	}

	protected boolean isOcupado() {
		return this.ocupado;
	}

	protected Movil getBici() {
		return this.bici;
	}

	protected void anclarBici(Movil bici) {
		this.bici = bici;
		this.ocupado = true;
	}

	protected void liberarBici() {
		this.bici = null;
		this.ocupado = false;
	}

	@Override
	public String toString() {
		return this.isOcupado() ? this.bici.toString() : "Libre";
	}
}
