package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion1 {

	public static void main(String args[]) {
		FallingBloxVersion1 jeux = new FallingBloxVersion1();
		jeux.jeu(args);

	}

	private void jeu(String args[]) {
		Puits puits = new Puits();
		if (args.length == 0) {
			puits = new Puits();

		}

		else if (args.length == 1) {

			puits.setTas(new Tas(puits, Integer.parseInt(args[0])));

		}

		else if (args.length == 2) {

			puits.setTas(new Tas(puits, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
		}

		UsineDePiece.setMode(UsineDePiece.CYCLIC);

		VuePuits affichage2 = new VuePuits(puits, 40);
		PanneauInformation panneau = new PanneauInformation(affichage2.getPuits());

		affichage2.getPuits().setPieceSuivante(UsineDePiece.genererPiece());

		affichage2.getPuits().setPieceSuivante(UsineDePiece.genererPiece());

		JFrame frame2 = new JFrame("Falling Blox");
		frame2.add(panneau, BorderLayout.EAST);
		frame2.add(affichage2, BorderLayout.CENTER);
		frame2.pack();
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
	}

}
