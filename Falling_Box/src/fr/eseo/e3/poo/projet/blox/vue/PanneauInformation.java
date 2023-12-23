package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

	private VuePiece vuePiece;
	private Puits puits;

	public PanneauInformation(Puits puits) {
		this.puits = puits;
		this.puits.addPropertyChangeListener(this);
		setPreferredSize(new Dimension(70, 70));
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (Puits.MODIFICATION_PIECE_SUIVANTE.equals(evt.getPropertyName())) {
			vuePiece = new VuePiece((Piece) evt.getNewValue(), 10);
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g.create();
		if (vuePiece != null) {
			vuePiece.afficherPiece(g2D);
		}
		this.repaint();
	}

}
