package edu.poniperro.domain.estacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.poniperro.domain.bicicleta.Bicicleta;
import edu.poniperro.domain.tarjetausuario.TarjetaUsuario;

public class EstacionTest {

	private Bicicleta bici;
	private TarjetaUsuario tarjeta;
	private Estacion estacion;

	@Before
	public void setup() {
		this.bici = new Bicicleta(999);
		this.tarjeta = new TarjetaUsuario("A1", true);
		this.estacion = new Estacion(1, "Lloseta", 3);
	}

	@Test
	public void createEstacionTest() {
		this.estacion.consultarEstacion();
	}

	@Test
	public void estacionAnclajesLibresTest() {
		assertEquals(3, this.estacion.anclajesLibres());
		this.estacion.anclarBicicleta(this.bici);
		assertEquals(2, this.estacion.anclajesLibres());
	}

	@Test
	public void estacionAnclarMaxBicisTest() {
		this.estacion.anclarBicicleta(this.bici);
		this.estacion.anclarBicicleta(this.bici);
		this.estacion.anclarBicicleta(this.bici);
		this.estacion.anclarBicicleta(this.bici);
		assertEquals(0, this.estacion.anclajesLibres());
	}

	@Test
	public void estacionLeerTarjetaUsuarioTest() {
		assertTrue(this.estacion.leerTarjetaUsuario(this.tarjeta));
	}

	@Test
	public void estacionRetirarBiciTest() {
		this.estacion.anclarBicicleta(this.bici);
		assertEquals(2, this.estacion.anclajesLibres());
		this.estacion.retirarBicicleta(this.tarjeta);
		assertEquals(3, this.estacion.anclajesLibres());
		this.estacion.retirarBicicleta(this.tarjeta);

		this.tarjeta.setActivada(false);
		this.estacion.anclarBicicleta(this.bici);
		assertEquals(2, this.estacion.anclajesLibres());
		this.estacion.retirarBicicleta(this.tarjeta);
		assertEquals(2, this.estacion.anclajesLibres());
	}

	@Test
	public void estacionConsultaAnclajesTest() {
		this.estacion.consultarAnclajes();
	}

}
