package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter implements MouseListener {

	private VuePuits vuePuits;
	private Puits puits;

	public PieceRotation(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
	}

	@Override
	public void mouseClicked(MouseEvent event) {

		if (SwingUtilities.isRightMouseButton((MouseEvent) event)) {
			try {
				this.vuePuits.getPuits().getPieceActuelle().tourner(true);
			} catch (BloxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (SwingUtilities.isLeftMouseButton((MouseEvent) event)) {
			try {
				this.vuePuits.getPuits().getPieceActuelle().tourner(false);
			} catch (BloxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		this.vuePuits.repaint();
	}

}
