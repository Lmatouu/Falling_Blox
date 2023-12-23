package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class JPiece extends Piece {

	public JPiece(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees, couleur);
	}

	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		super.getElements().clear();

		super.getElements().add(new Element(coordonnees, couleur));

		super.getElements()
				.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1), couleur));

		super.getElements()
				.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 2), couleur));

		super.getElements()
				.add(new Element(new Coordonnees(coordonnees.getAbscisse() - 1, coordonnees.getOrdonnee()), couleur));

	}

}
