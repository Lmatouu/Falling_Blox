package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends javax.swing.JPanel implements PropertyChangeListener {

	public static final int TAILLE_PAR_DEFAUT = 15;
	private Puits puits;
	private int taille;
	private VuePiece vuePiece;
	private PieceDeplacement pieceDeplacement;
	private PieceRotation pieceRotation;
	private final VueTas vueTas;
	private Gravite gravite;

	public VuePuits(Puits puits, int taille) {
		this.puits = puits;
		this.taille = taille;
		setPreferredSize(
				new Dimension(getPuits().getLargeur() * this.taille, getPuits().getProfondeur() * this.taille));
		setBackground(java.awt.Color.WHITE);

		this.puits.addPropertyChangeListener((PropertyChangeListener) this);

		this.pieceDeplacement = new PieceDeplacement(this);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);

		this.pieceRotation = new PieceRotation(this);
		this.vueTas = new VueTas(this);
		this.addMouseListener(pieceRotation);

		this.gravite = new Gravite(this);

	}

	public VuePuits(Puits puits) {
		this(puits, TAILLE_PAR_DEFAUT);

	}

	public Puits getPuits() {
		return this.puits;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
		setPreferredSize(
				new Dimension(getPuits().getLargeur() * this.taille, getPuits().getProfondeur() * this.taille));
	}

	public void setTaille(int taille) {
		this.taille = taille;
		setPreferredSize(
				new Dimension(getPuits().getLargeur() * this.taille, getPuits().getProfondeur() * this.taille));

	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}

	public VuePiece getVuePiece() {
		return this.vuePiece;
	}

	@Override
	public void propertyChange(java.beans.PropertyChangeEvent event) {
		if (event.getPropertyName().equals("Actuelle")) {
			setVuePiece(new VuePiece((Piece) event.getNewValue(), this.getTaille()));
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g.create();

		g2D.setColor(java.awt.Color.LIGHT_GRAY);

		for (int i = 0; i < getPuits().getProfondeur(); i++) {
			g2D.drawLine(0, i * this.getTaille(), getPuits().getLargeur() * this.getTaille(), i * this.getTaille());
		}
		for (int j = 0; j < getPuits().getLargeur(); j++) {
			g2D.drawLine(j * this.getTaille(), 0, j * this.getTaille(), getPuits().getProfondeur() * this.getTaille());
		}

		// for (int i = 0; i < puits.getProfondeur(); i++) {
		// g2D.drawRect(0, i * this.getTaille(), puits.getLargeur() * this.getTaille(),
		// this.getTaille());
		// }
		// for (int j = 0; j < puits.getLargeur(); j++) {
		// g2D.drawRect(j * this.getTaille(), 0, this.getTaille(), puits.getProfondeur()
		// * this.getTaille());
		// }

		if (getVuePiece() != null) {
			getVuePiece().afficherPiece(g2D);
		}

		if (getVueTas() != null) {
			getVueTas().afficher(g2D);
		}
		g2D.dispose();

	}

	public VueTas getVueTas() {
		return this.vueTas;
	}

}
