package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {
	public static final int LARGEUR_PAR_DEFAUT = 5;
	public static final int PROFONDEUR_PAR_DEFAUT = 15;

	public static final String MODIFICATION_PIECE_ACTUELLE = "Actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "Suivante";

	private int largeur;
	private int profondeur;
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private Tas tas;

	private PropertyChangeSupport pcs;

	public Puits() {

		this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);

	}

	public Puits(int largeur, int profondeur) {
		if (largeur > 15 || largeur < 5) {
			throw new IllegalArgumentException("en dehors de la largeur");
		}

		if (profondeur > 25 || profondeur < 15) {
			throw new IllegalArgumentException("en dehors de la profondeur");
		}
		this.largeur = largeur;
		this.profondeur = profondeur;

		this.pieceActuelle = null;
		this.pieceSuivante = null;

		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
	}

	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
		if (largeur > 15 || largeur < 5) {
			throw new IllegalArgumentException("en dehors de la largeur");
		}

		if (profondeur > 25 || profondeur < 15) {
			throw new IllegalArgumentException("en dehors de la profondeur");
		}
		this.largeur = largeur;
		this.profondeur = profondeur;

		this.pieceActuelle = null;
		this.pieceSuivante = null;

		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this, nbElements, nbLignes);
	}

	public int getLargeur() {
		return this.largeur;
	}

	public void setLargeur(int largeur) {
		if (largeur > 15 || largeur < 5) {
			throw new IllegalArgumentException("en dehors de la largeur");
		} else {
			this.largeur = largeur;
		}
	}

	public int getProfondeur() {
		return this.profondeur;
	}

	public void setProfondeur(int profondeur) {
		if (profondeur > 25 || profondeur < 15) {
			throw new IllegalArgumentException("en dehors de la profondeur");
		} else {
			this.profondeur = profondeur;
		}
	}

	public Piece getPieceActuelle() {
		return this.pieceActuelle;
	}

	public Piece getPieceSuivante() {
		return this.pieceSuivante;
	}

	public void setPieceSuivante(Piece piecesuivante) {

		if (getPieceSuivante() != null) {
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, this.getPieceActuelle(), this.getPieceSuivante());
			this.pieceActuelle = getPieceSuivante();
			this.pieceActuelle.setPosition((getLargeur() / 2), -4);
			this.pieceActuelle.setPuits(this);

		}

		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, this.getPieceSuivante(), piecesuivante);
		this.pieceSuivante = piecesuivante;

	}

	public String toString() {
		String result = "Puits : Dimension " + getLargeur() + " x " + getProfondeur() + "\n";

		if (getPieceActuelle() == null) {
			result += "Piece Actuelle : <aucune>\n";
		} else {
			result += "Piece Actuelle : " + getPieceActuelle().toString();
		}

		if (getPieceSuivante() == null) {
			result += "Piece Suivante : <aucune>\n";
		} else {
			result += "Piece Suivante : " + getPieceSuivante().toString();
		}

		return result;

	}

	@Override
	public int hashCode() {
		return Objects.hash(largeur, pieceActuelle, pieceSuivante, profondeur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puits other = (Puits) obj;
		return largeur == other.largeur && Objects.equals(pieceActuelle, other.pieceActuelle)
				&& Objects.equals(pieceSuivante, other.pieceSuivante) && profondeur == other.profondeur;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public void deplacerPieceVerticalement(int i) {
		try {
			getPieceActuelle().deplacerDe(0, i);
		} catch (IllegalArgumentException | BloxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deplacerPieceHorizontalement(int i) {
		try {
			getPieceActuelle().deplacerDe(i, 0);
		} catch (IllegalArgumentException | BloxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Tas getTas() {
		return this.tas;
	}

	public void setTas(Tas tas) {
		this.tas = tas;
	}

	private void gererCollision() {
		this.tas.ajouterElements(getPieceActuelle());
		Piece piecenew = UsineDePiece.genererPiece();
		setPieceSuivante(piecenew);

	}

	public void gravite() throws IllegalArgumentException, BloxException {
		try {
			getPieceActuelle().deplacerDe(0, 1);
		} catch (BloxException e) {
			if (e.getType() == BloxException.BLOX_COLLISION) {
				gererCollision();
			}

		}

	}

}
