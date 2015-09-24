package pl.com.warcaby2;

import java.awt.Color;

import javax.swing.JLabel;

public class Pionek {
	private Gracz gracz;
	private int pozycjaX;
	private int pozycjaY;
	private JLabel label;
	
	public Pionek(Gracz gracz1,int pozycjaX,int pozycjaY,JLabel label){
		this.gracz=gracz1;
		this.pozycjaX=pozycjaX;
		this.pozycjaY=pozycjaY;
		this.label=label;
		if(gracz1.getNazwa().equals("gracz1")){
		this.label.setForeground(Color.red);}
		else{this.label.setForeground(Color.white);}
		
	}

	public Gracz getGracz() {
		return gracz;
	}

	public void setGracz(Gracz gracz) {
		this.gracz = gracz;
	}

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

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	

}
