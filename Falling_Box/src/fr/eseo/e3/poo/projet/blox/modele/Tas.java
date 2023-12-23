package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {

	private Puits puits;
	private Element[][] elements;

	public Tas(Puits puits, int nbElements, int nbLignes) {

		this.puits = puits;
		this.elements = new Element[this.puits.getProfondeur()][this.puits.getLargeur()];
		for (int i = 0; i < this.puits.getProfondeur(); i++) {
			for (int j = 0; j < this.puits.getLargeur(); j++) {
				this.elements[i][j] = null;
			}
		}
		Random random = new Random();
		construireTas(nbElements, nbLignes, random);

	}

	public Tas(Puits puits) {
		this.puits = puits;
		this.elements = new Element[this.puits.getProfondeur()][this.puits.getLargeur()];
		for (int i = 0; i < this.puits.getProfondeur(); i++) {
			for (int j = 0; j < this.puits.getLargeur(); j++) {
				this.elements[i][j] = null;
			}
		}
	}

	public Tas(Puits puits, int nbElements) {
		this(puits, nbElements, (nbElements / puits.getLargeur()) + 1);

	}

	public Puits getPuits() {
		return this.puits;
	}

	public Element[][] getElements() {
		return this.elements;
	}

	private void construireTas(int nbElements, int nbLignes, Random rand) {
		if (nbElements != 0 && nbElements >= this.getPuits().getLargeur() * nbLignes) {
			throw new IllegalStateException("exception ");
		}
		int nbElementsplace = 0;
		int ordon;
		int absci;

		while (nbElementsplace < nbElements) {
			ordon = this.getPuits().getProfondeur() - (rand.nextInt(nbLignes) + 1);
			absci = rand.nextInt(this.getPuits().getLargeur());

			if (this.getElements()[ordon][absci] == null) {
				int indiceCouleur = rand.nextInt(Couleur.values().length);
				this.getElements()[ordon][absci] = new Element(absci, ordon, Couleur.values()[indiceCouleur]);
				nbElementsplace += 1;

			}
		}
	}

	public void ajouterElements(Piece piece) {
		for (int i = 0; i < piece.getElements().size(); i++) {
			getElements()[piece.getElements().get(i).getCoordonnees().getOrdonnee()][piece.getElements().get(i)
					.getCoordonnees().getAbscisse()] = piece.getElements().get(i);
		}

	}

}
