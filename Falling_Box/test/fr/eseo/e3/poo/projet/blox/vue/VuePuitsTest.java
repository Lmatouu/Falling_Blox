package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

	@Test
	void constructeurTest() {
		Puits essaie = new Puits();
		VuePuits test = new VuePuits(essaie);

		assertEquals(essaie, test.getPuits(), "test constructeur");
		assertEquals(test.TAILLE_PAR_DEFAUT, test.getTaille(), "test constructeur");
	}

	@Test
	void constructeur2Test() {
		Puits essaie = new Puits();
		int taille = 50;
		VuePuits test = new VuePuits(essaie, taille);

		assertEquals(essaie, test.getPuits(), "test constructeur");
		assertEquals(taille, test.getTaille(), "test constructeur");
	}

	@Test
	void taillesetTest() {
		Puits essaie = new Puits();
		VuePuits test = new VuePuits(essaie);
		int taille = 100;
		test.setTaille(taille);

		assertEquals(essaie, test.getPuits(), "test constructeur");
		assertEquals(taille, test.getTaille(), "test constructeur");
	}

	@Test
	void puitssetTest() {
		Puits essaie = new Puits();
		VuePuits test = new VuePuits(essaie);

		Puits essaie2 = new Puits(10, 20);
		test.setPuits(essaie2);

		assertEquals(essaie2, test.getPuits(), "test constructeur");
		assertEquals(test.TAILLE_PAR_DEFAUT, test.getTaille(), "test constructeur");
	}

}
