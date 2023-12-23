package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class JPieceTest {
	@Test
	public void constructeurTest() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		JPiece liste = new JPiece(essaie, couleur);
		assertEquals(new JPiece(essaie, couleur), liste, "test constructeur");

	}

	@Test
	public void testAdd() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[4];

		JPiece liste = new JPiece(essaie, couleur);

		Element[] listeattendue = { new Element(essaie, couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() - 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() - 2), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() - 1, essaie.getOrdonnee()), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème élément liste ");

	}

	@Test
	public void testtoString() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[4];

		JPiece liste = new JPiece(essaie, couleur);

		assertEquals("JPiece :\n" + "	(10, -10) - JAUNE\n" + "	(10, -11) - JAUNE\n" + "	(10, -12) - JAUNE\n"
				+ "	(9, -10) - JAUNE\n", liste.toString(), "Problème élément liste ");

	}

}
