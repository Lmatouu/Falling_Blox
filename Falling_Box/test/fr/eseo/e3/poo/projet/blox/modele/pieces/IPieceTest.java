package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class IPieceTest {

	@Test
	public void constructeurTest() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		IPiece liste = new IPiece(essaie, couleur);
		assertEquals(new IPiece(essaie, couleur), liste, "test constructeur");

	}

	@Test
	public void testAdd() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];

		IPiece liste = new IPiece(essaie, couleur);

		Element[] listeattendue = { new Element(essaie, couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() + 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() - 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() - 2), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème élément liste ");

	}

	@Test
	public void testtoString() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];

		IPiece liste = new IPiece(essaie, couleur);

		assertEquals("IPiece :\n" + "	(10, -10) - ROUGE\n" + "	(10, -9) - ROUGE\n" + "	(10, -11) - ROUGE\n"
				+ "	(10, -12) - ROUGE\n", liste.toString(), "Problème élément liste ");

	}

	@Test
	public void testdeplaceDeimpossible() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		IPiece liste = new IPiece(essaie, couleur);

		assertThrows(IllegalArgumentException.class, () -> {
			liste.deplacerDe(12, 40);
		}, "Problème déplacement");

	}

	@Test
	public void testdeplaceDepossible() throws IllegalArgumentException, BloxException {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];

		IPiece liste = new IPiece(essaie, couleur);

		liste.deplacerDe(1, 1);
		Element[] listeattendue = {
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee() + 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee() + 2), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee() - 1), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème déplacement impossible");

	}

	@Test
	public void testTourner() throws BloxException {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];

		IPiece liste = new IPiece(essaie, couleur);

		liste.tourner(true);
		Element[] listeattendue = { new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() - 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 2, essaie.getOrdonnee()), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème tourner impossible");

	}

	@Test
	void tournelimitecoteTest() {

		Coordonnees essaie = new Coordonnees(9, 12);

		Couleur couleur = Couleur.values()[0];
		IPiece liste = new IPiece(essaie, couleur);

		liste.setPuits(new Puits(10, 15));

		assertThrows(BloxException.class, () -> {
			liste.tourner(true);
		}, "Problème coté");

	}

	@Test
	void tournelimitefondTest() throws BloxException {

		Coordonnees essaie = new Coordonnees(5, 10);

		Couleur couleur = Couleur.values()[0];
		IPiece liste = new IPiece(essaie, couleur);

		liste.setPuits(new Puits(10, 15));
		liste.tourner(true);
		liste.deplacerDe(0, 1);
		liste.deplacerDe(0, 1);
		liste.deplacerDe(0, 1);
		liste.deplacerDe(0, 1);
		assertThrows(BloxException.class, () -> {
			liste.tourner(false);
		}, "Problème coté");

	}

}
