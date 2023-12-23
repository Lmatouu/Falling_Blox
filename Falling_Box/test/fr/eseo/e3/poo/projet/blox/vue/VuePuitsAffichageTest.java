package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuitsAffichageTest {

	private void testConstructeurPuits() {
		UsineDePiece.setMode(UsineDePiece.CYCLIC);
		Piece piece = UsineDePiece.genererPiece();

		Puits puits = new Puits();

		VuePuits affichage = new VuePuits(puits);
		// affichage.getPuits().addPropertyChangeListener(affichage);

		PanneauInformation panneau = new PanneauInformation(affichage.getPuits());

		affichage.getPuits().setPieceSuivante(piece);
		affichage.getPuits().setPieceSuivante(piece);

		piece.setPosition(3, 3);

		JFrame frame = new JFrame("Puits");
		frame.add(affichage, BorderLayout.CENTER);
		frame.add(panneau, BorderLayout.EAST);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private void testConstructeurPuitsTaille() {
		UsineDePiece.setMode(UsineDePiece.CYCLIC);
		Piece piece2 = UsineDePiece.genererPiece();

		Puits puits = new Puits();

		VuePuits affichage2 = new VuePuits(puits, 40);
		// affichage2.getPuits().addPropertyChangeListener(affichage2);
		
		PanneauInformation panneau = new PanneauInformation(affichage2.getPuits());
		
		affichage2.getPuits().setPieceSuivante(piece2);

		affichage2.getPuits().setPieceSuivante(piece2);

		piece2.setPosition(3, 3);

		JFrame frame2 = new JFrame("Puits et taille");
		frame2.add(affichage2, BorderLayout.CENTER);
		frame2.add(panneau, BorderLayout.EAST);
		frame2.pack();
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);

	}

	private void testtas() {
		UsineDePiece.setMode(UsineDePiece.CYCLIC);
		Piece piece2 = UsineDePiece.genererPiece();

		Puits puits = new Puits(10, 20, 10, 3);

		VuePuits affichage2 = new VuePuits(puits, 40);
		// affichage2.getPuits().addPropertyChangeListener(affichage2);

		affichage2.getPuits().setPieceSuivante(piece2);

		affichage2.getPuits().setPieceSuivante(piece2);

		piece2.setPosition(3, 3);

		JFrame frame2 = new JFrame("Puits Avec Tas aléatoire");
		frame2.add(affichage2);
		frame2.pack();
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);

	}

	public static void main(String[] args) {
		VuePuitsAffichageTest test = new VuePuitsAffichageTest();
		test.testConstructeurPuits();

		 VuePuitsAffichageTest test2 = new VuePuitsAffichageTest();
		 test2.testConstructeurPuitsTaille();

		// VuePuitsAffichageTest test3 = new VuePuitsAffichageTest();
		// test3.testtas();
	}

}