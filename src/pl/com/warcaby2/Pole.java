package pl.com.warcaby2;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
//ujednolic x,y pobrawic, zmienic wlascicieli pol i liczyc punkty
public class Pole extends JPanel {
	private int pozycjaX;
	private int pozycjaY;
	private Color color;
	private Gracz wlasciciel;
	private JLabel podpis;
	
	public Pole(int pozycjaX,int pozycjaY,Color color,Gracz wlasciciel,JLabel podpis){
		this.pozycjaX=pozycjaX;
		this.pozycjaY=pozycjaY;
		
		//this.setBackground(color);
		this.color=color;
		this.wlasciciel=wlasciciel;
		this.podpis=podpis;
		if(podpis!= null && wlasciciel != null)
		this.podpis.setForeground(wlasciciel.getKolor_gracza());
	}
public JLabel getPodpis() {
		return podpis;
	}
	public void setPodpis(JLabel podpis) {
		this.podpis = podpis;
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


	public Color getColor() {
		return color;
	}
	public Gracz getWlasciciel() {
		return wlasciciel;
	}
	public void setWlasciciel(Gracz wlasciciel) {
		this.wlasciciel = wlasciciel;
	}



}
