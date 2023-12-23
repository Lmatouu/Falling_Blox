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

public class OPieceTest {

	@Test
	public void constructeurTest() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		OPiece liste = new OPiece(essaie, couleur);
		assertEquals(new OPiece(essaie, couleur), liste, "test constructeur");

	}

	@Test
	public void testAdd() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];

		OPiece liste = new OPiece(essaie, couleur);

		Element[] listeattendue = { new Element(essaie, couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() - 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee() - 1), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème élément liste ");

	}

	@Test
	public void testtoString() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];

		OPiece liste = new OPiece(essaie, couleur);

		assertEquals("OPiece :\n" + "	(10, -10) - ROUGE\n" + "	(10, -11) - ROUGE\n" + "	(11, -10) - ROUGE\n"
				+ "	(11, -11) - ROUGE\n", liste.toString(), "Problème élément liste ");

	}

	@Test
	public void testdeplaceDeimpossible() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		OPiece liste = new OPiece(essaie, couleur);

		assertThrows(IllegalArgumentException.class, () -> {
			liste.deplacerDe(12, 40);
		}, "Problème déplacement");

	}

	@Test
	public void testdeplaceDepossible() throws IllegalArgumentException, BloxException {

		Coordonnees essaie = new Coordonnees(3, 4);

		Couleur couleur = Couleur.values()[0];

		OPiece liste = new OPiece(essaie, couleur);

		liste.deplacerDe(1, 1);
		Element[] listeattendue = {
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee() + 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 2, essaie.getOrdonnee() + 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 2, essaie.getOrdonnee()), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème déplacement impossible");

	}

	@Test
	public void testTourner() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];

		OPiece liste = new OPiece(essaie, couleur);

		liste.tourner(true);
		Element[] listeattendue = { new Element(essaie, couleur),
				new Element(new Coordonnees(essaie.getAbscisse(), essaie.getOrdonnee() - 1), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee()), couleur),
				new Element(new Coordonnees(essaie.getAbscisse() + 1, essaie.getOrdonnee() - 1), couleur) };

		assertArrayEquals(listeattendue, liste.getElements().toArray(), "Problème tourner impossible");

	}

	@Test
	public void setPuitstest() {
		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		OPiece liste = new OPiece(essaie, couleur);

		liste.setPosition(5, 5);
		liste.setPuits(new Puits());
		assertEquals(new Puits(), liste.getPuits(), "test set Puits");

	}

	@Test
	void equalsbrancheTest() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		OPiece liste = new OPiece(essaie, couleur);

		assertEquals(false, liste.equals(null), "Problème equalsbranche");

	}

	@Test
	void equalsbranche2Test() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		OPiece liste = new OPiece(essaie, couleur);

		assertEquals(true, liste.equals(liste), "Problème equalsbranche");

	}

	@Test
	void equalsbranche3Test() {

		Coordonnees essaie = new Coordonnees(10, -10);

		Couleur couleur = Couleur.values()[0];
		OPiece liste = new OPiece(essaie, couleur);

		Puits testim = new Puits();

		assertEquals(false, liste.equals(testim), "Problème equalsbranche");

	}

	@Test
	void deplacelimitecoteTest() {

		Coordonnees essaie = new Coordonnees(9, 14);

		Couleur couleur = Couleur.values()[0];
		OPiece liste = new OPiece(essaie, couleur);

		liste.setPuits(new Puits(10, 15));

		assertThrows(BloxException.class, () -> {
			liste.deplacerDe(1, 0);
		}, "Problème coté");

	}

	@Test
	void deplacelimitefondTest() throws IllegalArgumentException, BloxException {

		Coordonnees essaie = new Coordonnees(5, 14);

		Couleur couleur = Couleur.values()[0];
		OPiece liste = new OPiece(essaie, couleur);

		liste.setPuits(new Puits(10, 15));
		liste.deplacerDe(1, 0);
		assertThrows(BloxException.class, () -> {
			liste.deplacerDe(0, 1);

		}, "Problème fond");

	}

}
