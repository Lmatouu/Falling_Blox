package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {

	public static final double MULTIPLIER_TEINTE = 0.7;
	private final int taille;
	private final Piece piece;

	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.taille = taille;

	}

	public Color teinte(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();

		double cr = r + (255 - r) * MULTIPLIER_TEINTE;
		double cg = g + (255 - g) * MULTIPLIER_TEINTE;
		double cb = b + (255 - b) * MULTIPLIER_TEINTE;

		return new Color((int) cr, (int) cg, (int) cb);

	}

	public void afficherPiece(Graphics2D g2D) {
		Couleur couleur = this.piece.getElements().get(0).getCouleur();

		for (int i = 0; i < this.piece.getElements().size(); i++) {
			if (i == 0) {
				g2D.setColor(teinte(couleur.getCouleurPourAffichage()));
			} else {
				g2D.setColor(couleur.getCouleurPourAffichage());
			}

			g2D.fill3DRect(this.piece.getElements().get(i).getCoordonnees().getAbscisse() * this.taille,
					this.piece.getElements().get(i).getCoordonnees().getOrdonnee() * this.taille, this.taille,
					this.taille, true);
		}
	}

}
