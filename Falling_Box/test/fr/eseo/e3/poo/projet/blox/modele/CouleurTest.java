package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class CouleurTest {

	@Test
	void testgetCouleurPourAffichage() {
		Couleur couleur = Couleur.ROUGE;
		Color expectedColor = Color.RED;
		assertEquals(expectedColor, couleur.getCouleurPourAffichage());

	}

}
