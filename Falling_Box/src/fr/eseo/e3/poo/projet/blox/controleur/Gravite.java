package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener {

	private final VuePuits vuePuits;
	private final Puits puits;
	private int periodicite;
	private Timer timer;
	
	public Gravite (VuePuits vuePuits){
		this.vuePuits=vuePuits;
		this.puits=this.vuePuits.getPuits();
		this.periodicite=5000;
        this.timer = new Timer(this.periodicite, this);
        this.timer.start();
	}
	
	public int getPeriodicite ( ) {
		return this.periodicite;
	}
	public void setPeriodicite (int periodicite) {
		this.periodicite=periodicite;
		this.timer.setDelay(this.periodicite);
	}
	
	@Override 
	public void actionPerformed ( ActionEvent event) {
		try {
			this.puits.gravite();
		} catch (IllegalArgumentException | BloxException e) {
		
		}
        vuePuits.repaint();
	}

}
