package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {

	public final static double MULTIPLIER_NUANCE = 0.5;
	private final Tas tas;
	private final VuePuits vuePuits;

	public VueTas(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.tas = this.vuePuits.getPuits().getTas();
	}

	public Color nuance(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();

		double cr = r*(1- MULTIPLIER_NUANCE);
		double cg = g*(1-MULTIPLIER_NUANCE);
		double cb = b*(1- MULTIPLIER_NUANCE);

		return new Color((int) cr, (int) cg, (int) cb);

	}

	public VuePuits getVuePuits() {
		return this.vuePuits;
	}

	public void afficher(Graphics2D g2D) {

		for (int i = 0; i < this.tas.getElements().length; i++) {
			for (int j = 0; j < this.tas.getElements()[i].length; j++) {

				if (this.tas.getElements()[i][j] != null) {
					Couleur couleur = this.tas.getElements()[i][j].getCouleur();
					g2D.setColor(nuance(couleur.getCouleurPourAffichage()));

					g2D.fill3DRect(
							this.tas.getElements()[i][j].getCoordonnees().getAbscisse() * getVuePuits().getTaille(),
							this.tas.getElements()[i][j].getCoordonnees().getOrdonnee() * getVuePuits().getTaille(),
							getVuePuits().getTaille(), getVuePuits().getTaille(), true);
				}
			}

		}

	}

}
