package edu.poniperro.domain.estacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.poniperro.domain.bicicleta.Bicicleta;

public class AnclajeTest {

	private Anclaje anclaje;
	private Bicicleta bici;

	@Before
	public void setup() {
		this.anclaje = new Anclaje();
		this.bici = new Bicicleta(999);
	}

	@Test
	public void createAnclajeTest() {
		assertFalse(this.anclaje.isOcupado());
	}

	// test sin bici
	@Test
	public void anclajeGetBiciSinBiciTest() {
		assertNull(this.anclaje.getBici());
	}

	@Test
	public void anclajeIsOcupadoSinBiciTest() {
		assertFalse(this.anclaje.isOcupado());
	}

	@Test
	public void anclajeLiberarBiciSinBiciTest() {
		this.anclaje.liberarBici();
		assertNull(this.anclaje.getBici());
	}

	@Test
	public void anclajeAnclarBiciSinBiciTest() {
		this.anclaje.anclarBici(this.bici);
		assertEquals(this.bici, this.anclaje.getBici());
	}

	@Test
	public void anclajeToStringSinBiciTest() {
		assertEquals("Libre", this.anclaje.toString());
	}

	// test con bici
	@Test
	public void anclajeGetBiciConBiciTest() {
		this.anclaje.anclarBici(this.bici);
		assertEquals(this.bici, this.anclaje.getBici());
	}

	@Test
	public void anclajeIsOcupadoConBiciTest() {
		this.anclaje.anclarBici(this.bici);
		assertTrue(this.anclaje.isOcupado());
	}

	@Test
	public void anclajeLiberarBiciConBiciTest() {
		this.anclaje.anclarBici(this.bici);
		this.anclaje.liberarBici();
		assertNull(this.anclaje.getBici());
	}

	@Test
	public void anclajeAnclarBiciConBiciTest() {
		this.anclaje.anclarBici(this.bici);
		Bicicleta newBici = new Bicicleta(000);
		this.anclaje.anclarBici(newBici);
		assertEquals(newBici, this.anclaje.getBici());
	}

	@Test
	public void anclajeToStringConBici() {
		this.anclaje.anclarBici(this.bici);
		assertEquals("999", this.anclaje.toString());
	}
}
