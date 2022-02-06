package edu.poniperro.domain.estacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.poniperro.domain.bicicleta.Bicicleta;

public class AnclajesTest {

	private Anclajes anclajes;
	private Bicicleta bici;

	@Before
	public void setup() {
		this.anclajes = new Anclajes(3);
		this.bici = new Bicicleta(999);
	}

	@Test
	public void createAnclajesTest() {
		assertTrue(this.anclajes.anclajes() instanceof Anclaje[]);
	}

	@Test
	public void anclajesNumAnclajesTest() {
		assertEquals(3, this.anclajes.numAnclajes());
	}

	@Test
	public void anclajesOcuparAnclajeTest() {
		this.anclajes.ocuparAnclaje(this.bici, 2);
		assertEquals(this.bici, this.anclajes.getBiciAt(2));
	}

	@Test
	public void anclajesIsAnclajeOcupadoTest() {
		this.anclajes.ocuparAnclaje(this.bici, 2);
		assertTrue(this.anclajes.isAnclajeOcupado(2));
		assertFalse(this.anclajes.isAnclajeOcupado(1));
	}

	@Test
	public void anclajesLiberarAnclajeTest() {
		this.anclajes.ocuparAnclaje(this.bici, 2);
		this.anclajes.liberarAnclaje(2);
		assertNull(this.anclajes.getBiciAt(2));
	}

	@Test
	public void anclajesGetBiciAtTest() {
		this.anclajes.ocuparAnclaje(this.bici, 2);
		assertEquals(this.bici, this.anclajes.getBiciAt(2));
		assertNull(this.anclajes.getBiciAt(1));
	}

	@Test
	public void anclajesSeleccionarAnclajesTest() {
		assertEquals(0, this.anclajes.seleccionarAnclaje());
	}

	@Test
	public void anclajesToStringTest() {
		assertEquals("Anclaje con 3 Anclajes", this.anclajes.toString());
	}
}
