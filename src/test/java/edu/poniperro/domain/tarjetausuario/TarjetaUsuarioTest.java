package edu.poniperro.domain.tarjetausuario;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TarjetaUsuarioTest {

	private TarjetaUsuario tarjeta;

	@Before
	public void setup() {
		this.tarjeta = new TarjetaUsuario("A12", true);
	}

	@Test
	public void tarjetaActivadaTest() {
		assertEquals(true, this.tarjeta.isActivada());
	}

	@Test
	public void cambiarActivacionTest() {
		this.tarjeta.setActivada(false);
		assertEquals(false, this.tarjeta.isActivada());
	}

	@Test
	public void tarjetaToStringTest() {
		assertEquals("ID A12\nActivada: true", this.tarjeta.toString());
	}
}
