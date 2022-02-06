package edu.poniperro.domain.bicicleta;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BicicletaTest {

	private Bicicleta bici;

	@Before
	public void setup() {
		this.bici = new Bicicleta(999);
	}

	@Test
	public void createBiciTest() {
		assertEquals(999, this.bici.getId());
	}

	@Test
	public void biciToStringTest() {
		assertEquals("999", this.bici.toString());
	}
}
