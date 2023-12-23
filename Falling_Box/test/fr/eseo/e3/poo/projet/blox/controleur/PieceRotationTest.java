package fr.eseo.e3.poo.projet.blox.controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PieceRotationTest {

	@Test
	void testRotationOPieces() {
		Piece piece = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		Piece pieceattendue = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		piece.tourner(true);
		assertEquals(pieceattendue, piece, "Piece Rotation Opiece");
		piece.tourner(false);
		piece.tourner(false);
		assertEquals(pieceattendue, piece, "Piece Rotation Opiece");
	}

	@Test
	void testRotationPieces() {
		Piece piece = new IPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		Piece pieceattendue = new IPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		piece.tourner(true);
		piece.tourner(true);
		piece.tourner(true);
		piece.tourner(true);
		assertEquals(pieceattendue, piece, "Piece Rotation Opiece");

	}
	
	@Test
	void testRotationPiecesbis() {
		Piece piece = new IPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		Piece pieceattendue = new IPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		piece.tourner(false);
		piece.tourner(false);
		piece.tourner(false);
		piece.tourner(false);
		assertEquals(pieceattendue, piece, "Piece Rotation Opiece");

	}

}
