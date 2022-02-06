package edu.poniperro.domain.estacion;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

import edu.poniperro.domain.bicicleta.Movil;
import edu.poniperro.domain.tarjetausuario.Autenticacion;

public class Estacion {
	private final int id;
	private final String direccion;
	private Anclajes anclajes;

	public Estacion(int id, String direccion, int numAnclajes) {
		this.id = id;
		this.direccion = direccion;
		this.anclajes = new Anclajes(numAnclajes);
	}

	private int getId() {
		return this.id;
	}

	private String getDireccion() {
		return this.direccion;
	}

	@Override
	public String toString() {
		return "Estacion de " + this.getDireccion() + "\nCon ID " + this.getId();
	}

	private Anclaje[] anclajes() {
		return this.anclajes.anclajes();
	}

	private int numAnclajes() {
		return this.anclajes.numAnclajes();
	}

	public void consultarEstacion() {
		System.out.println(this);
		this.consultarAnclajes();
	}

	public int anclajesLibres() {
		long anclajesLibres = Arrays.stream(this.anclajes()).filter(a -> !a.isOcupado()).count();
		return Math.toIntExact(anclajesLibres);
	}

	public void anclarBicicleta(Movil bici) {
		Optional<Anclaje> anclajeLibre = Arrays.stream(this.anclajes()).filter(a -> !a.isOcupado()).findFirst();
		if (anclajeLibre.isPresent()) {
			anclajeLibre.get().anclarBici(bici);
			this.mostrarAnclaje(anclajeLibre.get().getBici());
		} else {
			System.out.println("Ningun anclaje disponible.");
		}
	}

	public boolean leerTarjetaUsuario(Autenticacion tarjeta) {
		return tarjeta.isActivada();
	}

	public void retirarBicicleta(Autenticacion tarjeta) {
		if (leerTarjetaUsuario(tarjeta)) {
			Optional<Anclaje> anclajeOcupado = Arrays.stream(this.anclajes()).filter(a -> a.isOcupado()).findFirst();
			if (anclajeOcupado.isPresent()) {
				this.mostrarBicicleta(anclajeOcupado.get().getBici());
				anclajeOcupado.get().liberarBici();
			} else {
				System.out.println("No hay bicicletas disponibles.");
			}
		} else {
			System.out.println("Tarjeta no activada.");
		}
	}

	private void mostrarBicicleta(Movil bici) {
		System.out.println("Bicicleta retirada: " + bici.getId());
	}

	private void mostrarAnclaje(Movil bici) {
		System.out.println("Bicicleta anclada: " + bici.getId());
	}

	public void consultarAnclajes() {
		IntStream.range(0, this.numAnclajes())
				.mapToObj(i -> String.format("Anclaje %d -> %s", i, this.anclajes()[i]))
				.forEach(System.out::println);
	}
}
