package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {

	private List<Element> elements;
	private Puits puits;

	public Piece(Coordonnees coordonnees, Couleur couleur) {
		this.elements = new ArrayList<Element>();
		setElements(coordonnees, couleur);
		this.puits = null;
	}

	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

	public List<Element> getElements() {
		return this.elements;
	}

	public void setPosition(int abscisse, int ordonnee) {

		if (getElements().isEmpty()) {
			throw new IllegalStateException("la liste est vide");
		} else {
			setElements(new Coordonnees(abscisse, ordonnee), getElements().get(0).getCouleur());

		}
	}

	public Puits getPuits() {
		return this.puits;
	}

	public void setPuits(Puits puit) {
		this.puits = puit;
	}

	public String toString() {
		String res = this.getClass().getSimpleName() + " :\n";
		for (int i = 0; i < getElements().size(); i++) {
			res += "\t" + getElements().get(i).toString() + "\n";
		}
		return res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elements);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		return Objects.equals(elements, other.elements);
	}

	public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException, BloxException {

		if (deltaY > 1 || deltaX > 1 || deltaY < 0 || deltaX < -1) {
			throw new IllegalArgumentException("Déplacement impossible");
		}

		else if (getPuits() != null) {
			verifcollision(deltaX, deltaY);
		}

		for (int i = 0; i < getElements().size(); i++) {
			getElements().get(i).deplacerDe(deltaX, deltaY);

		}

	}

	private void verifcollision(int deltaX, int deltaY) throws BloxException {
		for (int i = 0; i < getElements().size(); i++) {
			int ord = this.getElements().get(i).getCoordonnees().getOrdonnee();
			int abs = this.getElements().get(i).getCoordonnees().getAbscisse();

			if ((abs + deltaX) < 0 || (abs + deltaX) >= this.getPuits().getLargeur()) {
				throw new BloxException("Collision sortie pluit", BloxException.BLOX_SORTIE_PUITS);
			}

			if ((ord + deltaY) >= this.getPuits().getProfondeur()) {
				throw new BloxException("Collision sortie pluit", BloxException.BLOX_COLLISION);
			}

			if (verifTas(deltaX, deltaY, i, ord, abs)) {

				throw new BloxException("Collision Tas Element", BloxException.BLOX_COLLISION);

			}
		}
	}

	private boolean verifTas(int deltaX, int deltaY, int indice, int ord, int abs) throws BloxException {
		boolean etat = false;
		if (this.getPuits().getTas() != null && ord > 0 && abs > 0) {
			if (this.getPuits().getTas().getElements()[this.getElements().get(indice).getCoordonnees().getOrdonnee()
					+ deltaY][this.getElements().get(indice).getCoordonnees().getAbscisse() + deltaX] != null) {
				etat = true;

			}
		}
		return etat;
	}

	public void tourner(boolean sensHoraire) throws BloxException {
		boolean etat = true;
		int dx = this.getElements().get(0).getCoordonnees().getAbscisse();
		int dy = this.getElements().get(0).getCoordonnees().getOrdonnee();

		deplacementorigine(-dx, -dy);

		if (this.getPuits() != null) {

			collisionexception(sensHoraire, dx, dy, etat);
		}
		if (etat) {
			rotationpiece(sensHoraire);
		}

		deplacementorigine(dx, dy);

	}

	private void deplacementorigine(int dx, int dy) {
		for (int i = 0; i < getElements().size(); i++) {
			getElements().get(i).deplacerDe(dx, dy);
		}
	}

	private void rotationpiece(boolean sensHoraire) {
		for (int i = 0; i < getElements().size(); i++) {
			int x = this.getElements().get(i).getCoordonnees().getAbscisse();
			int y = this.getElements().get(i).getCoordonnees().getOrdonnee();

			if (sensHoraire) {
				this.getElements().get(i).setCoordonnees(new Coordonnees(-y, x));
			} else {
				this.getElements().get(i).setCoordonnees(new Coordonnees(y, -x));
			}
		}
	}

	private int novox(boolean sensHoraire, int y) {
		int nouvX;
		if (sensHoraire) {
			nouvX = -y;
		} else {
			nouvX = y;
		}
		return nouvX;
	}

	private int novoy(boolean sensHoraire, int x) {
		int nouvY;
		if (sensHoraire) {
			nouvY = x;
		} else {
			nouvY = -x;
		}
		return nouvY;
	}

	private void collisionexception(boolean sensHoraire, int dx, int dy, boolean etat) throws BloxException {
		for (int i = 0; i < getElements().size(); i++) {
			int x = this.getElements().get(i).getCoordonnees().getAbscisse();
			int y = this.getElements().get(i).getCoordonnees().getOrdonnee();

			int nouvX = novox(sensHoraire, y);
			int nouvY = novoy(sensHoraire, x);

			if (nouvX + dx < 0 || nouvX + dx >= getPuits().getLargeur()) {
				etat = false;
				deplacementorigine(dx, dy);
				throw new BloxException("Collision sortie pluit", BloxException.BLOX_SORTIE_PUITS);

			}
			if (nouvY + dy >= getPuits().getProfondeur()) {
				etat = false;
				deplacementorigine(dx, dy);

				throw new BloxException("Collision sortie pluit", BloxException.BLOX_COLLISION);

			}

			if (verifTasTourner(nouvX, nouvY, dx, dy)) {
				etat = false;
				deplacementorigine(dx, dy);
				throw new BloxException("Collision Tas Element", BloxException.BLOX_COLLISION);
			}

		}
	}

	private boolean verifTasTourner(int nouvX, int nouvY, int dx, int dy) throws BloxException {
		boolean etat = false;
		if (getPuits().getTas() != null && nouvY + dy > 0 && nouvX + dx > 0) {
			if (getPuits().getTas().getElements()[nouvY + dy][nouvX + dx] != null) {
				etat = true;

			}
		}
		return etat;
	}

}
