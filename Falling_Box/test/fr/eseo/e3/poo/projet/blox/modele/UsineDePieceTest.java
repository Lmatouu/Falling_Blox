package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePieceTest {
	
	@Test
	public void testSetMode() {
	    UsineDePiece.setMode(UsineDePiece.CYCLIC);
	    assertEquals(UsineDePiece.CYCLIC, UsineDePiece.getMode());
	}

	@Test
	public void testmodeCyclique() {
		UsineDePiece.setMode(UsineDePiece.CYCLIC);

		
		assertEquals(new OPiece(new Coordonnees(2, 3), Couleur.ROUGE), UsineDePiece.genererPiece(),"test Mode Cycle");
		assertEquals(new IPiece(new Coordonnees(2, 3), Couleur.ORANGE), UsineDePiece.genererPiece(),"test Mode Cycle");
		assertEquals(new TPiece(new Coordonnees(2, 3), Couleur.BLEU), UsineDePiece.genererPiece(),"test Mode Cycle");
		assertEquals(new LPiece(new Coordonnees(2, 3), Couleur.VERT), UsineDePiece.genererPiece(),"test Mode Cycle");
		assertEquals(new JPiece(new Coordonnees(2, 3), Couleur.JAUNE), UsineDePiece.genererPiece(),"test Mode Cycle");
		assertEquals(new ZPiece(new Coordonnees(2, 3), Couleur.CYAN), UsineDePiece.genererPiece(),"test Mode Cycle");
		assertEquals(new SPiece(new Coordonnees(2, 3), Couleur.VIOLET), UsineDePiece.genererPiece(),"test Mode Cycle");
		
		assertEquals(new OPiece(new Coordonnees(2, 3), Couleur.ROUGE), UsineDePiece.genererPiece(),"test Mode Cycle");
		
	}

}
