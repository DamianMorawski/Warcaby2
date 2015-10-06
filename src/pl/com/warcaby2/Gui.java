package pl.com.warcaby2;
import static java.lang.System.out;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	public class Gui extends JFrame implements MouseListener {
		private Pole pole1;
		private JPanel panel;
		private JPanel[][] panele;
		private JLabel label1;
		private JLabel label2;
		private Object[] pionekgracza2;
		private Pole [][] pol;
		private List<String> klikNazwa;
		private List<Integer> klikX;
		private List<Integer> klikY;
		private Gracz[] tabgraczy;
		public static int kogoruch=1;
		
	public boolean sprawdz_zmiane(int x1, int x2, int y1, int y2, String gracz) {
		boolean czymozna = false;
		// zmienne Y to dla mnie x
		if (gracz.equals("Alan")) {

			out.println("Y" + x1 + "" + x2 + " X " + y1 + "" + y2);
			out.println(y2 - y1 + "  " + (x2 - x1));
			// czymozna=true;
			if (x2 - x1 == 1 && (y2 - y1 == 1 || y2 - y1 == -1)) {

				czymozna = true;
			}
			out.println("Y" + x1 + "" + x2 + " X " + y1 + "" + y2);
			out.println(y2 - y1 + "  " + (x2 - x1));
			//out.print(pol[x1+1][y1+1].getWlasciciel().getNazwa());
			// czymozna=true;
			if (x2 - x1 == 2 && (y2 - y1 == 2 || y2 - y1 == -2) && (pol[x1+1][y1+1].getPodpis().getText().equals("Bob") ||
					pol[x1+1][y1-1].getPodpis().getText().equals("Bob")))  {

				czymozna = true;
			}

		}

		if (gracz.equals("Bob")) {
			out.println("Y" + x1 + "" + x2 + " X " + y1 + "" + y2);
			out.println(y2 - y1 + "  " + (x2 - x1));
			// czymozna=true;
			if (x2 - x1 == -1 && (y2 - y1 == 1 || y2 - y1 == -1)) {

				czymozna = true;
			}
			out.println("Y" + x1 + "" + x2 + " X " + y1 + "" + y2);
			out.println(y2 - y1 + "  " + (x2 - x1));
			//out.print(pol[x1+1][y1+1].getWlasciciel().getNazwa());
			// czymozna=true;
			if (x2 - x1 == -2 && (y2 - y1 == 2 || y2 - y1 == -2) && (pol[x1-1][y1+1].getPodpis().getText().equals("Alan") ||
					pol[x1-1][y1-1].getPodpis().getText().equals("Alan")))  {

				czymozna = true;
			}

		}

		

		out.println(czymozna);
		return czymozna;
	}
		
		//majac anonimowe labele a nie anonimowe panele bede mogl sie odniesc do labelki?
		//tablica paneli i pol musi byc widoczna wszedzie
	public void ruch(Pole[][] tab_pole,int x,int y,String nazwa,Color kolorek){
		
		tab_pole[x][y].getPodpis().setText(nazwa);
		tab_pole[x][y].getPodpis().setForeground(kolorek);;
//		if(tabgraczy[0].getNazwa().equals(nazwa))
//				{
//			tab_pole[x][y].setWlasciciel(tabgraczy[0]);
//		}
//		//
//		if(tabgraczy[1].getNazwa().equals(nazwa))
//		{
//	tab_pole[x][y].setWlasciciel(tabgraczy[0]);
//}
	}
//-------------------------------------------------------------------------------------------
	public void warunki(int size, int x, int y, Color kolorek) {
		if (klikNazwa.get(size - 2).toString().equals("") || (klikNazwa.get(size - 1).toString().length()>0)) {// jesli klikne w
															// puste pole jako 1
															// klik + klikne 2 raz w gracza
			klikNazwa.clear(); // wyzerowanie listy tylko 2 elementy max}
			klikX.clear();
			klikY.clear();
			out.println("Powtórz operacje klik w puste pole badz w gracza "+size);
		} else {
			out.println(klikNazwa.get(size - 2).toString());
			if(sprawdz_zmiane(klikY.get(0),y, klikX.get(0),x,klikNazwa.get(size - 2).toString())){ //jesli mozna to dokona zmiany
			ruch(pol, y, x, klikNazwa.get(size - 2).toString(), kolorek); //wstawienie pola w nowe miejsce
			out.println("Size" + size);
			out.println("klikniecia" + klikNazwa.get(size - 2).toString());

			ruch(pol, klikY.get(0), klikX.get(0), "", kolorek);  //skasowanie starej pozycji
			klikNazwa.clear();
			klikX.clear();
			klikY.clear();}
		} // wyzerowanie listy tylko 2 elementy max}
	}
//-------------------------------------------------------------------------------------------------	
	public boolean  funkcja_ruchu(int x,int y){
		boolean stan=true;
		Color kolorek = Color.white; //kolor na poczatek
		System.out.println(y+"  "+x);
		String nazwa=pol[y][x].getPodpis().getText();//wpisanie 1 lub 2 klikniecia
		klikNazwa.add(nazwa);
		klikX.add(x);
		klikY.add(y);
		int size=klikNazwa.size();
		
		if(size>1  ){
			
			String gracz=klikNazwa.get(size-2).toString();
					if(gracz.equals("Alan")){
						kolorek=Color.blue;}
					else{
					
						kolorek=Color.red;}
					warunki(size, x, y, kolorek);
			
			
		}
		else{
			//ruch(pol,y,x,"",kolorek);
			out.println("Kliknij w wolne pole "+size);
		}
		Gui.setKogoruch(Gui.getKogoruch()+2);
		
return stan;
	}

	public Pole[][] inicjuj_tablice() {
		JPanel[][] panele = new JPanel[8][8];
		Gracz gracz3=new Gracz("Alan",Color.BLUE);
		Gracz gracz4=new Gracz("Bob",Color.RED);
		tabgraczy=new Gracz[2];
		tabgraczy[0]=gracz3;
		tabgraczy[1]=gracz4;
		int licznik=0;
		Pole[][] tab_pole = new Pole[8][8];
		Color kolor_startu;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if ((i + j) % 2 == 1) {
					kolor_startu = Color.black;
					//out.println(+licznik);
					
					
					switch (licznik) {
					  case 0: case 1: case 2: case 3: case 4: case 5:case 6: case 7:case 8: case 9:case 10: case 11:
						  tab_pole[i][j] = new Pole(i, j, kolor_startu,gracz3, new JLabel(gracz3.getNazwa()));
						  licznik++;
						
						  panele[i][j]=new JPanel();	
						  panele[i][j].setBackground(tab_pole[i][j].getColor());
						  panele[i][j].add(tab_pole[i][j].getPodpis());
							add(panele[i][j]);
						  break;

					  case 12: case 13: case 14: case 15: case 16: case 17:case 18: case 19:
						  tab_pole[i][j] = new Pole(i, j, kolor_startu,null, new JLabel(""));
						 
						  licznik++;
						  panele[i][j]=new JPanel();	
						  panele[i][j].setBackground(tab_pole[i][j].getColor());
						  panele[i][j].add(tab_pole[i][j].getPodpis());
							add(panele[i][j]);
						  break;
					  case 20: case 21:case 22: case 23:case 24: case 25: case 26: case 27: case 28: case 29:case 30: case 31:
						tab_pole[i][j] = new Pole(i, j, kolor_startu, gracz4,new JLabel(gracz4.getNazwa()));
						licznik++;
						
						  panele[i][j]=new JPanel();	
						  panele[i][j].setBackground(tab_pole[i][j].getColor());
						  panele[i][j].add(tab_pole[i][j].getPodpis());
							add(panele[i][j]);
						 break;
					default:
						out.println("blad404"+licznik);
						 break;
					}
					
				} else {
					kolor_startu = Color.white;
					tab_pole[i][j] = new Pole(i, j, kolor_startu,null,null);
					  panele[i][j]=new JPanel();	
					  panele[i][j].setBackground(tab_pole[i][j].getColor());
					 // panele[i][j].add(tab_pole[i][j].getPodpis());
						add(panele[i][j]);
					
				}
			}
		}
		//tab_pole[0][5].getPodpis().setText("POP");

		return tab_pole;
	}
		
		
		//-------------------------------------------------------------------------------------------------------------------
		public Gui() {
			super( "Warcaby" );
			//this.pole1=pole1;
			//pole1=new Pole();
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(800, 800);
			setLocation(400,50);
			setLayout(new GridLayout(8, 8));
			 addMouseListener(this);
			//rysuj_szachownice();
			//RYSUJEMY GUI 64 pola
			
			 pol=new Pole[8][8]; //tab pol wszystkich
			pol=inicjuj_tablice();
			
			
			 klikNazwa = new ArrayList<String>();
			 klikX = new ArrayList<Integer>();
			 klikY = new ArrayList<Integer>();
			setVisible(true);
			repaint();
		}
		public static void main(String[] args)
	    { Gui gui=new Gui();
	    
	    }

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			int y=e.getY()/100;
			int x=e.getX()/100;
			// TODO Auto-generated method stub
		//	System.out.println(e.getY()+"  "+e.getX());
			if(pol[x][y].getColor().equals(Color.black)){
				funkcja_ruchu(x, y);}
			
			repaint();
			
		}

		public Object[] getPionekgracza2() {
			return pionekgracza2;
		}

		public void setPionekgracza2(Object[] pionekgracza2) {
			this.pionekgracza2 = pionekgracza2;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public static int getKogoruch() {
			return kogoruch;
		}

		public static void setKogoruch(int kogoruch) {
			Gui.kogoruch = kogoruch;
		}
		
	}


