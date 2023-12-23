package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class LPieceTest {
	@Test
	public void constructeurTest() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		LPiece liste = new LPiece(essaie, couleur);
		assertEquals(new LPiece(essaie, couleur), liste, "test constructeur");

	}

	@Test
	public void testAdd() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[3];

		LPiece liste = new LPiece(essaie, couleur);

		Element[] listeattendue = { new Element(essaie, couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() - 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() - 2), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème élément liste ");

	}

	@Test
	public void testtoString() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[3];

		LPiece liste = new LPiece(essaie, couleur);

		assertEquals("LPiece :\n" + "	(10, -10) - VERT\n" + "	(11, -10) - VERT\n" + "	(10, -11) - VERT\n"
				+ "	(10, -12) - VERT\n", liste.toString(), "Problème élément liste ");

	}

}
