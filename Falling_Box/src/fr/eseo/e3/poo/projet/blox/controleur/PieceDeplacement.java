package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter implements MouseMotionListener {
	private VuePuits vuePuits;
	private Puits puits;
	private int derpos = -1;

	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent event) {
		Piece pieceActuelle = this.puits.getPieceActuelle();
		if (pieceActuelle != null) {
			int positionc = getPositionX(event.getX());
			if (derpos == -1) {
				derpos = positionc;
			} else if (positionc != derpos) {
				try {
					this.vuePuits.getPuits().deplacerPieceHorizontalement(positionc - derpos);
					derpos = positionc;
					this.vuePuits.repaint();
				} catch (IllegalStateException e) {
				}
			}
		}
	}

	private int getPositionX(int x) {
		int colonneLargeur = this.vuePuits.getTaille();
		return (int) Math.floor(x / colonneLargeur);
	}

	public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
		addMouseMotionListener(mouseMotionListener);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Reset last column when mouse enters window
		derpos = -1;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		Piece pieceActuelle = this.puits.getPieceActuelle();

		if (pieceActuelle != null) {
			int rotation = e.getWheelRotation();
			if (rotation > 0) {
				this.vuePuits.getPuits().deplacerPieceVerticalement(1);
				this.vuePuits.repaint();
			}
		}
	}

}
