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
		public Pole pole1;
		public JPanel panel;
		public JPanel[][] panele;
		public JLabel label1;
		public JLabel label2;
		private Object[] pionekgracza2;
		public Pole [][] pol;
		public List<String> klikniecia;
		
		//majac anonimowe labele a nie anonimowe panele bede mogl sie odniesc do labelki?
		//tablica paneli i pol musi byc widoczna wszedzie
	public void ruch(Pole[][] tab_pole,int x,int y,String nazwa,Color kolorek){
		
		tab_pole[x][y].getPodpis().setText(nazwa);
		tab_pole[x][y].getPodpis().setForeground(kolorek);;
		
	}

	public Pole[][] inicjuj_tablice() {
		JPanel[][] panele = new JPanel[8][8];
		Gracz gracz3=new Gracz("Alan",Color.BLUE);
		Gracz gracz4=new Gracz("Bob",Color.RED);
		int licznik=0;
		Pole[][] tab_pole = new Pole[8][8];
		Color kolor_startu;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if ((i + j) % 2 == 1) {
					kolor_startu = Color.black;
					out.println(+licznik);
					
					
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
			 klikniecia = new ArrayList<String>();
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
			Color kolorek = Color.white;
		
			// TODO Auto-generated method stub
		//	System.out.println(e.getY()+"  "+e.getX());
			int y=e.getY()/100;
			int x=e.getX()/100;
			System.out.println(y+"  "+x);
			String nazwa=pol[y][x].getPodpis().getText();
			klikniecia.add(nazwa);
			int size=klikniecia.size();
			
			if(size>1){
				String gracz=klikniecia.get(size-2).toString();
				if(gracz.equals("Alan")){
					kolorek=Color.blue;}
				else{
				
					kolorek=Color.red;}
				
				ruch(pol,y,x,klikniecia.get(size-2).toString(),kolorek);
				out.println("Size"+size);
				out.println("klikniecia"+klikniecia.get(size-2).toString());
			}
			else{
				ruch(pol,y,x,"",kolorek);
				out.println(size);
			}
			
			
			//out.println(nazwa);
			//ruch(pol,y,x,nazwa);
			
//			for(int i=0;i<12;i++){
//				///
//				
//			}
			
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
	}


