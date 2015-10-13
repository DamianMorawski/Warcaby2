
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
		private static int ile;
		
		
	public boolean sprawdz_zmiane(int x1, int x2, int y1, int y2, String gracz) {//checkMove
		boolean czymozna = false;
		// zmienne Y to dla mnie x
		if (gracz.equals("Alan")) {

//			out.println("X" + x1 + "" + x2 + " Y " + y1 + "" + y2);
//			out.println(x2 - x1 + "  " + (y2 - y1));
			// czymozna=true;
			if (y2 - y1 == 1 && (x2 - x1 == 1 || x2 - x1 == -1)) {

				czymozna = true;
			}
			
			
			if (x2 - x1 == 2 && y2 - y1 == 2) {
				Gui.setIle(1);
			

			}
			if (x2 - x1 == -2 && y2 - y1 == 2) {
				Gui.setIle(-1);
				
			}
			if (ile != 0 && pol[x1 + Gui.getIle()][(y1 + 1)].getPodpis().getText().equals("Bob")) {//niesprawdzaj pustego miejsca do poprawy
				// Gui.setile(ile);
			
				ruch(pol, x1 + Gui.getIle(), (y1 + 1), "", null); // usuwanie
																	// gracza
				czymozna = true;
			}
			Gui.setIle(0);//reset pola

		}

		if (gracz.equals("Bob")) {
			
			// czymozna=true;
			if (y2 - y1 == -1 && (x2 - x1 == 1 || x2 - x1 == -1)) {

				czymozna = true;
			}

			// czymozna=true;
			if (x2 - x1 == 2 && y2 - y1 == -2) {
				Gui.setIle(1);
				

			}
			if (x2 - x1 == -2 && y2 - y1 == -2) {
				Gui.setIle(-1);
				
			}
			if (ile != 0 && pol[x1 + Gui.getIle()][(y1 - 1)].getPodpis().getText().equals("Alan")) {
				// Gui.setile(ile);
				
				ruch(pol, x1 + Gui.getIle(), (y1 - 1), "", null); // usuwanie
																	// gracza
				czymozna = true;
			}Gui.setIle(0);//reset pola

		}

		return czymozna;
	}
		
		//majac anonimowe labele a nie anonimowe panele bede mogl sie odniesc do labelki?
		//tablica paneli i pol musi byc widoczna wszedzie
	public void ruch(Pole[][] tab_pole,int x,int y,String nazwa,Color kolorek){//setMove
		
		tab_pole[x][y].getPodpis().setText(nazwa);
		tab_pole[x][y].getPodpis().setForeground(kolorek);;

	}
//-------------------------------------------------------------------------------------------
	public void warunki(int size, int x, int y, Color kolorek) {//checkClick
		if ( (klikNazwa.get(size - 1).toString().length()>0)) {// jesli klikne w
															// puste pole jako 1
															// klik + klikne 2 raz w gracza
			klikNazwa.clear(); // wyzerowanie listy tylko 2 elementy max}
			klikX.clear();
			klikY.clear();
			out.println("Powtórz operacje klik w puste pole badz w gracza "+size);
		} else {
			//out.println(klikNazwa.get(size - 2).toString());
			if(sprawdz_zmiane(klikX.get(0),x, klikY.get(0),y,klikNazwa.get(size - 2).toString())){ //jesli mozna to dokona zmiany
			ruch(pol, x, y, klikNazwa.get(size - 2).toString(), kolorek); //wstawienie pola w nowe miejsce
			//out.println("klikniecia" + klikNazwa.get(size - 2).toString());

			ruch(pol, klikX.get(0), klikY.get(0), "", kolorek);  //skasowanie starej pozycji
			klikNazwa.clear();
			klikX.clear();
			klikY.clear();}
		} // wyzerowanie listy tylko 2 elementy max}
	}
//-------------------------------------------------------------------------------------------------	
	public boolean  funkcja_ruchu(int x,int y){//Move
		boolean stan=true;
		Color kolorek = Color.white; //kolor na poczatek
		
		String nazwa=pol[x][y].getPodpis().getText();//wpisanie 1 lub 2 klikniecia
		klikNazwa.add(nazwa);
		klikX.add(x);
		klikY.add(y);
		int size=klikNazwa.size();
		if(klikNazwa.get(0).toString().equals("")){
		klikNazwa.clear(); // wyzerowanie listy tylko 2 elementy max}
		klikX.clear();
		klikY.clear();
		out.println("Powtórz operacje klik w puste pole badz w gracza "+klikNazwa.size());}
		 size=klikNazwa.size();
		if(size>1  ){
			//out.println(klikNazwa.get(size-2).toString());
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
		
		
return stan;
	}

	public Pole[][] inicjuj_tablice() {//setBoard
		JPanel[][] panele = new JPanel[8][8];
		Gracz gracz3=new Gracz("Alan",Color.BLUE);
		Gracz gracz4=new Gracz("Bob",Color.RED);
		tabgraczy=new Gracz[2];
		tabgraczy[0]=gracz3;
		tabgraczy[1]=gracz4;
		int licznik=0;
		Pole[][] tab_pole = new Pole[8][8];
		Color kolor_startu;
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {

				if ((x + y) % 2 == 1) {
					kolor_startu = Color.black;
					//out.println(+licznik);
					
					
					switch (licznik) {
					  case 0: case 1: case 2: case 3: case 4: case 5:case 6: case 7:case 8: case 9:case 10: case 11:
						  tab_pole[x][y] = new Pole(x, y, kolor_startu,gracz3, new JLabel(gracz3.getNazwa()));
						  licznik++;
						
						  panele[x][y]=new JPanel();	
						  panele[x][y].setBackground(tab_pole[x][y].getColor());
						  panele[x][y].add(tab_pole[x][y].getPodpis());
							add(panele[x][y]);
						  break;

					  case 12: case 13: case 14: case 15: case 16: case 17:case 18: case 19:
						  tab_pole[x][y] = new Pole(x, y, kolor_startu,null, new JLabel(""));
						 
						  licznik++;
						  panele[x][y]=new JPanel();	
						  panele[x][y].setBackground(tab_pole[x][y].getColor());
						  panele[x][y].add(tab_pole[x][y].getPodpis());
							add(panele[x][y]);
						  break;
					  case 20: case 21:case 22: case 23:case 24: case 25: case 26: case 27: case 28: case 29:case 30: case 31:
						tab_pole[x][y] = new Pole(x, y, kolor_startu, gracz4,new JLabel(gracz4.getNazwa()));
						licznik++;
						
						  panele[x][y]=new JPanel();	
						  panele[x][y].setBackground(tab_pole[x][y].getColor());
						  panele[x][y].add(tab_pole[x][y].getPodpis());
							add(panele[x][y]);
						 break;
					default:
						out.println("blad404"+licznik);
						 break;
					}
					
				} else {
					kolor_startu = Color.white;
					tab_pole[x][y] = new Pole(x, y, kolor_startu,null,null);
					  panele[x][y]=new JPanel();	
					  panele[x][y].setBackground(tab_pole[x][y].getColor());
					 // panele[i][j].add(tab_pole[i][j].getPodpis());
						add(panele[x][y]);
					
				}
			}
		}
		

		return tab_pole;
	}
		
		
		//-------------------------------------------------------------------------------------------------------------------
		public Gui() {
			super( "Warcaby" );
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(800, 800);
			setLocation(400,50);
			setLayout(new GridLayout(8, 8));
			 addMouseListener(this);
		
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
		
			if(pol[x][y].getColor().equals(Color.black)){
				//System.out.println(" Mouse "+x+"  "+y);
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

		public static int getIle() {
			return ile;
		}

		public static void setIle(int ile) {
			Gui.ile = ile;
		}


	}


