package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

public class PuitsTest {

	@Test
	public void testConstructeur() {

		Puits puit = new Puits();

		assertEquals(new Puits(), puit, "Problème constructeur ");

	}

	@Test
	public void testConstructeur2() {
		int largeur = 10;
		int profondeur = 20;
		Puits puit = new Puits(largeur, profondeur);
		assertEquals(largeur, puit.getLargeur(), "Problème constructeur2");
		assertEquals(profondeur, puit.getProfondeur(), "Problème constructeur2");
	}

	@Test
	public void testConstructeur2ProblemeP() {
		int largeur = 10;
		int profondeur = 40;
		assertThrows(IllegalArgumentException.class, () -> {
			Puits puit = new Puits(largeur, profondeur);
		}, "Problème profondeur dépasser");

	}

	@Test
	public void testConstructeur2ProblemeL() {
		int largeur = 0;
		int profondeur = 20;
		assertThrows(IllegalArgumentException.class, () -> {
			Puits puit = new Puits(largeur, profondeur);
		}, "Problème largeur dépasser");

	}

	@Test
	public void testConstructeur3() {
		int largeur = 10;
		int profondeur = 20;
		int nbElements = 5;
		int nbLignes = 5;
		Puits puit = new Puits(largeur, profondeur, nbElements, nbLignes);
		assertEquals(new Puits(largeur, profondeur, nbElements, nbLignes), puit, "test constructeur 3");
	}

	@Test
	public void testConstructeur3ProblemeL() {
		int largeur = 30;
		int profondeur = 20;
		int nbElements = 5;
		int nbLignes = 5;
		assertThrows(IllegalArgumentException.class, () -> {
			Puits puit = new Puits(largeur, profondeur, nbElements, nbLignes);
		}, "Problème largeur dépasser");

	}

	@Test
	public void testConstructeur3ProblemeP() {
		int largeur = 10;
		int profondeur = 50;
		int nbElements = 5;
		int nbLignes = 5;
		assertThrows(IllegalArgumentException.class, () -> {
			Puits puit = new Puits(largeur, profondeur, nbElements, nbLignes);
		}, "Problème largeur dépasser");

	}

	@Test
	public void testLargeurdepasser() {
		Puits puit = new Puits();
		assertThrows(IllegalArgumentException.class, () -> {
			puit.setLargeur(50);
		}, "Problème largeur dépasser");

	}

	@Test
	public void testProfondeurdepasser() {
		Puits puit = new Puits();
		assertThrows(IllegalArgumentException.class, () -> {
			puit.setProfondeur(50);
		}, "Problème largeur dépasser");

	}

	@Test
	public void testsetProfondeur() {
		int largeur = 10;
		int profondeur = 20;
		Puits puit = new Puits(largeur, profondeur);
		puit.setProfondeur(19);
		assertEquals(19, puit.getProfondeur(), "Problème set Profondeur");
	}

	@Test
	public void testsetLargeur() {
		int largeur = 10;
		int profondeur = 20;
		Puits puit = new Puits(largeur, profondeur);
		puit.setLargeur(11);
		assertEquals(11, puit.getLargeur(), "Problème set Largeur");
	}

	@Test
	public void testPieceSuivante() {
		Puits puit = new Puits();

		assertEquals(null, puit.getPieceActuelle(), "Piece Actuelle nul");

		assertEquals(null, puit.getPieceSuivante(), "Piece Suivante nul");

		Coordonnees essaie = new Coordonnees(10, -10);
		Couleur couleur = Couleur.values()[0];

		OPiece piecesuivante = new OPiece(essaie, couleur);
		puit.setPieceSuivante(piecesuivante);

		assertEquals(null, puit.getPieceActuelle(), "Piece Actuelle non nul");
		assertEquals(piecesuivante, puit.getPieceSuivante(), "Piece Suivante nul");

		Coordonnees essaie2 = new Coordonnees(20, -20);
		Couleur couleur2 = Couleur.values()[1];
		IPiece piecesuivante2 = new IPiece(essaie2, couleur2);
		puit.setPieceSuivante(piecesuivante2);

		assertEquals(piecesuivante, puit.getPieceActuelle(), "Piece Actuelle non nul");
		assertEquals(piecesuivante2, puit.getPieceSuivante(), "Piece Suivante nul");

	}

	@Test
	public void testtoString() {
		int largeur = 10;
		int profondeur = 20;
		Puits puit = new Puits(largeur, profondeur);
		String chaine = "Puits : Dimension 10 x 20\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>\n";
		assertEquals(chaine, puit.toString(), "Problème toString");

	}

	@Test
	public void testhashCode() {
		int largeur = 10;
		int profondeur = 20;
		Puits puit = new Puits(largeur, profondeur);
		assertEquals(1221451, puit.hashCode(), "Problème toString");
	}

	@Test
	void equalsbrancheTest() {

		Puits puit = new Puits(10, 20);

		assertEquals(false, puit.equals(null), "Problème equalsbranche");

	}

	@Test
	void equalsbranche2Test() {
		Puits puit = new Puits(10, 20);

		Coordonnees essaie = new Coordonnees(10, -10);

		assertEquals(true, puit.equals(puit), "Problème equalsbranche");

	}

	@Test
	void equalsbranche3Test() {

		Puits puit = new Puits(10, 20);

		Coordonnees essaie = new Coordonnees(10, -10);

		assertEquals(false, puit.equals(essaie), "Problème equalsbranche");

	}

	@Test
	void tasTest() {
		Puits puit = new Puits(10, 20);
		Tas tas = new Tas(puit);
		puit.setTas(tas);
		assertEquals(tas, puit.getTas(), "Problème Tas");
	}

	@Test
	void deplacementHorizontaleTest() throws IllegalArgumentException, BloxException {
		Puits puit = new Puits(10, 20);
		puit.setPieceSuivante(new OPiece(new Coordonnees(3, 3), Couleur.ROUGE));
		puit.setPieceSuivante(new OPiece(new Coordonnees(3, 3), Couleur.ROUGE));

		puit.deplacerPieceHorizontalement(1);
		puit.deplacerPieceVerticalement(1);
		puit.gravite();

		assertEquals(20, puit.getProfondeur(), "Problème déplacement");
	}

}
