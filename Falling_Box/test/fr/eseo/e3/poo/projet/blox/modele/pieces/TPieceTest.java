package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class TPieceTest {
	@Test
	public void constructeurTest() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		TPiece liste = new TPiece(essaie, couleur);
		assertEquals(new TPiece(essaie, couleur), liste, "test constructeur");

	}

	@Test
	public void testAdd() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[2];

		TPiece liste = new TPiece(essaie, couleur);

		Element[] listeattendue = { new Element(essaie, couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() - 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() + 1), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème élément liste ");

	}

	@Test
	public void testtoString() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[2];

		TPiece liste = new TPiece(essaie, couleur);

		assertEquals("TPiece :\n" + "	(10, -10) - BLEU\n" + "	(11, -10) - BLEU\n" + "	(9, -10) - BLEU\n"
				+ "	(10, -9) - BLEU\n", liste.toString(), "Problème élément liste ");

	}

}
