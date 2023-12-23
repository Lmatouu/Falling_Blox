package fr.eseo.e3.poo.projet.blox.controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PieceDeplacementTest {

	@Test
	void testDeplacementtropgrand() {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);

		assertThrows(IllegalArgumentException.class, () -> {
			piece.deplacerDe(10, 0);
		}, "Problème déplace Piece");

	}

	@Test
	void testDeplacementverslehaut() {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);

		assertThrows(IllegalArgumentException.class, () -> {
			piece.deplacerDe(0, -1);
		}, "Problème déplace Piece");

	}

	@Test
	void testDeplacementversbas() {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		Piece pieceattendue = new OPiece(new Coordonnees(2, 4), Couleur.ROUGE);
		piece.deplacerDe(0, 1);
		assertEquals(pieceattendue, piece, "Piece vers le bas");

	}

	@Test
	void testDeplacementversdroite() {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		Piece pieceattendue = new OPiece(new Coordonnees(3, 3), Couleur.ROUGE);
		piece.deplacerDe(1, 0);
		assertEquals(pieceattendue, piece, "Piece vers le bas");

	}

	@Test
	void testDeplacementversgauche() {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		Piece pieceattendue = new OPiece(new Coordonnees(1, 3), Couleur.ROUGE);
		piece.deplacerDe(-1, 0);
		assertEquals(pieceattendue, piece, "Piece vers le bas");

	}

}
