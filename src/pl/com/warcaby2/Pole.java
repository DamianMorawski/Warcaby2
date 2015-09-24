package pl.com.warcaby2;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Pole extends JPanel {
	private int pozycjaX;
	private int pozycjaY;
	private Color color;
	
	public Pole(int pozycjaX,int pozycjaY,Color color){
		this.pozycjaX=pozycjaX;
		this.pozycjaY=pozycjaY;
		
		//this.setBackground(color);
		this.color=color;
	}
//gettery settery
	public int getPozycjaX() {
		return pozycjaX;
	}

	public void setPozycjaX(int pozycjaX) {
		this.pozycjaX = pozycjaX;
	}

	public int getPozycjaY() {
		return pozycjaY;
	}

	public void setPozycjaY(int pozycjaY) {
		this.pozycjaY = pozycjaY;
	}

//	public JPanel getPole() {
//		return pole;
//	}
//
//	public void setPole(JPanel pole) {
//		this.pole = pole;
//	}

	public Color getColor() {
		return color;
	}
//
//	public void setColor(Color color) {
//		this.color = color;
//	}



}
