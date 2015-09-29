package pl.com.warcaby2;

import java.awt.Color;

public class Gracz {
	private String nazwa;
	private Color kolor_gracza;
	public Color getKolor_gracza() {
		return kolor_gracza;
	}

	public void setKolor_gracza(Color kolor_gracza) {
		this.kolor_gracza = kolor_gracza;
	}

	public Gracz(String nazwa,Color kolor_gracza){
		this.nazwa=nazwa;
		this.kolor_gracza=kolor_gracza;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	

}
