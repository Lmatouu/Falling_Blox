package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	void constructeurTest() {

		Coordonnees test1 = new Coordonnees(10, -10);

		assertEquals(new Coordonnees(10, -10), test1, "Problème constructeur");

	}

	@Test
	void constructeur2Test() {

		Coordonnees test1 = new Coordonnees(10, -10);

		assertEquals(true, test1.equals(new Coordonnees(10, -10)), "Problème constructeur");

	}

	@Test
	void getTest() {

		Coordonnees test1 = new Coordonnees(10, -10);

		assertEquals(10, test1.getAbscisse(), "Problème abscisse");

		assertEquals(-10, test1.getOrdonnee(), "Problème abscisse");

	}

	@Test
	void setAbscisseTest() {

		Coordonnees test1 = new Coordonnees(10, -10);
		
		test1.setAbscisse(12);

		assertEquals(12, test1.getAbscisse(), "Problème Abscisse");

	}
	
	@Test
	void setOrdonneeTest() {

		Coordonnees test1 = new Coordonnees(10, -10);
		
		test1.setOrdonnee(12);
		assertEquals(12, test1.getOrdonnee(), "Problème O");

	}
	
	@Test
	void tostringTest() {

		Coordonnees test1 = new Coordonnees(10, -10);

		assertEquals("(10, -10)", test1.toString(), "Problème string");

	}
	
	@Test
	void hascodeTest() {

		Coordonnees test1 = new Coordonnees(10, -10);

		assertEquals(1261, test1.hashCode(), "Problème hascode");

	}
	
	@Test
	void equalsbrancheTest() {

		Coordonnees test1 = new Coordonnees(10, -10);

		assertEquals(false, test1.equals( null), "Problème equalsbranche");

	}
	
	@Test
	void equalsbranche2Test() {

		Coordonnees test1 = new Coordonnees(10, -10);

		assertEquals(true, test1.equals(test1), "Problème equalsbranche");

	}
	
	@Test
	void equalsbranche3Test() {

		Coordonnees test1 = new Coordonnees(10, -10);
		Puits testt=new Puits();

		assertEquals(false, test1.equals(testt), "Problème equalsbranche");

	}

}
