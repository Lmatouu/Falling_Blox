package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	void constructeur1Test() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Element test1 = new Element(essaie);

		assertEquals(new Element(essaie), test1, "Problème constructeur 1");

	}

	@Test
	void constructeur2Test() {

		int abscisse = 10;
		int ordonne = -10;

		Element test1 = new Element(abscisse, ordonne);

		assertEquals(new Element(abscisse, ordonne), test1, "Problème constructeur 2");

	}

	@Test
	void constructeur3Test() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];

		Element test1 = new Element(essaie, couleur);

		assertEquals(new Element(essaie, couleur), test1, "Problème constructeur 3");

	}

	@Test
	void constructeur4Test() {

		int abscisse = 10;
		int ordonne = -10;
		Couleur couleur = Couleur.values()[0];

		Element test1 = new Element(abscisse, ordonne, couleur);

		assertEquals(new Element(abscisse, ordonne, couleur), test1, "Problème constructeur 4");

	}

	@Test
	void constructeur5Test() {

		int abscisse = 10;
		int ordonne = -10;
		Couleur couleur = Couleur.values()[0];

		Element test1 = new Element(abscisse, ordonne, couleur);

		assertEquals(true, test1.equals(new Element(abscisse, ordonne, couleur)), "Problème constructeur");

	}

	@Test
	void constructeur6Test() {

		Couleur couleur = Couleur.ROUGE;
		Coordonnees essaie = new Coordonnees(10, -10);

		Element test1 = new Element(essaie, couleur);

		assertEquals(Objects.hash(essaie, couleur), test1.hashCode(), "Problème HashCode");

	}

	@Test
	void tostringTest() {

		int abscisse = 10;
		int ordonne = -10;
		Couleur couleur = Couleur.values()[0];

		Element test1 = new Element(abscisse, ordonne, couleur);

		assertEquals("(10, -10) - ROUGE", test1.toString(), "Problème string");

	}
	
	@Test
	void setCouleurTest() {

		int abscisse = 10;
		int ordonne = -10;
		Couleur couleur = Couleur.values()[0];

		Element test1 = new Element(abscisse, ordonne, couleur);
		
		test1.setCouleur(Couleur.values()[1]);

		assertEquals(Couleur.values()[1], test1.getCouleur(), "Problème Couleur");

	}
	
	@Test
	void deplacerdeTest() {
		
		Coordonnees essaie = new Coordonnees(10, -10);

		Element test1 = new Element(essaie);
			
		test1.deplacerDe(1, 1);
		
		Coordonnees attendu = new Coordonnees(11, -9);
		Element testattendu = new Element(attendu);
		
		assertEquals(testattendu, test1, "déplacer de");
	}
	
	@Test
	void equalsbrancheTest() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Element test1 = new Element(essaie);

		assertEquals(false, test1.equals( null), "Problème equalsbranche");

	}
	
	@Test
	void equalsbranche2Test() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Element test1 = new Element(essaie);

		assertEquals(true, test1.equals(test1), "Problème equalsbranche");

	}
	
	@Test
	void equalsbranche3Test() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Element test1 = new Element(essaie);
		Puits testnon=new Puits();

		assertEquals(false, test1.equals(testnon), "Problème equalsbranche");

	}
	
	

}
