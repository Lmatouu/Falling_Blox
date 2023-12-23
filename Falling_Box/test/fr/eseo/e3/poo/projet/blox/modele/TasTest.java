package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TasTest {

	@Test
	void testconstruucteur1() {
		Tas test = new Tas(new Puits(), 10, 10);
		assertEquals(new Puits(), test.getPuits(), "Problème construucteur1");
	}

	@Test
	void testconstruucteur2() {
		Tas test = new Tas(new Puits());
		assertEquals(new Puits(), test.getPuits(), "Problème construucteur2");
	}

	@Test
	void testconstruucteur3() {
		Tas test = new Tas(new Puits(), 10);
		assertEquals(new Puits(), test.getPuits(), "Problème construucteur3");
	}

	@Test
	void testconstruireTasErreur() {
		assertThrows(IllegalStateException.class, () -> {
			Tas test = new Tas(new Puits(), 100, 10);
		}, "Problème construireTas");
	}

}
