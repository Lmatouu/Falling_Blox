package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePiece {

	public static final int ALEATOIRE_COMPLET = 1;
	public static final int ALEATOIRE_PIECE = 0;
	public static final int CYCLIC = 2;
	public static final int NB_PIECE = 7;
	public static final int NB_COULEUR = 7;
	private static int compteur = 0;
	private static int mode;

	private UsineDePiece() {
	}

	public static void setMode(int modee) {
		mode = modee;
	}

	public static int getMode() {
		return mode;
	}

	public static Piece genererPiece() {

		Random random = new Random();

		switch (mode) {
		case ALEATOIRE_COMPLET:
			Couleur couleur = Couleur.values()[random.nextInt(NB_COULEUR)];
			int nbalea = random.nextInt(NB_PIECE);
			return creerPiece(nbalea, couleur);
		case CYCLIC:
			if (compteur == NB_PIECE) {
				compteur = 0;
			}

			Couleur couleurc = Couleur.values()[compteur];
			compteur += 1;
			return creerPiece(compteur - 1, couleurc);
		default:
			int nbaled = random.nextInt(NB_PIECE);
			Couleur couleurd = Couleur.values()[nbaled];
			return creerPiece(nbaled, couleurd);
		}

	}

	private static Piece creerPiece(int nbalea, Couleur couleur) {
		Piece piece = null;
		switch (nbalea) {
		case 0:
			piece = new OPiece(new Coordonnees(2, 3), couleur);
			break;
		case 1:
			piece = new IPiece(new Coordonnees(2, 3), couleur);
			break;
		case 2:
			piece = new TPiece(new Coordonnees(2, 3), couleur);
			break;
		case 3:
			piece = new LPiece(new Coordonnees(2, 3), couleur);
			break;
		case 4:
			piece = new JPiece(new Coordonnees(2, 3), couleur);
			break;
		case 5:
			piece = new ZPiece(new Coordonnees(2, 3), couleur);
			break;
		default:
			piece = new SPiece(new Coordonnees(2, 3), couleur);
			break;

		}
		return piece;
	}
}
