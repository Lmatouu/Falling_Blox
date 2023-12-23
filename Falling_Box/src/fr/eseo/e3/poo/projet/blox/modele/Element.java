package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {

	private Coordonnees coordonnees;

	private Couleur couleur;

	private int abscisse;

	private int ordonnee;

	public Element(Coordonnees coordonnees) {
		// TODO Auto-generated constructor stub
		this.coordonnees = coordonnees;
		this.couleur = Couleur.values()[0];
	}

	public Element(int abscisse, int ordonnee) {
		// TODO Auto-generated constructor stub
		this.coordonnees = new Coordonnees(abscisse, ordonnee);
		this.couleur = Couleur.values()[0];
	}

	public Element(int abscisse, int ordonnee, Couleur couleur) {
		// TODO Auto-generated constructor stub
		this.coordonnees = new Coordonnees(abscisse, ordonnee);
		this.couleur = couleur;
	}

	public Element(Coordonnees coordonnees, Couleur couleur) {
		// TODO Auto-generated constructor stub
		this.coordonnees = coordonnees;
		this.couleur = couleur;
	}

	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return getCoordonnees().toString() + " - " + getCouleur();
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return abscisse == other.abscisse && Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur
				&& ordonnee == other.ordonnee;
	}
	
	public void deplacerDe (int deltaX, int deltaY) {
		setCoordonnees(new Coordonnees(getCoordonnees().getAbscisse()+deltaX,getCoordonnees().getOrdonnee()+deltaY));
	}

}
