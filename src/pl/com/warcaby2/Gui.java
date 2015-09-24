package pl.com.warcaby2;
import static java.lang.System.out;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	public class Gui extends JFrame implements MouseListener {
		public Pole pole1;
		public JPanel panel;
		public JPanel[] panele;
		public JLabel label1;
		public JLabel label2;
		private Object[] pionekgracza2;
		
//		public enum Kolor_Pola{
//			czarny,bialy;
//			}
//		 Gui.Kolor_Pola kolor1 = Gui.Kolor_Pola.czarny;
//		 Gui.Kolor_Pola kolor2 = Gui.Kolor_Pola.bialy;
	Pole[][] inicjuj_tablice(){
			
			 Pole[][] tab_pole=new Pole[8][8];
			 Color kolor_startu;
			 for(int i=0; i<8;i++)
			 {
				 		if(i==0 || i==2 || i==4 || i==6){//kolor startu
				 				kolor_startu=Color.white;
				 		}else{
				 				kolor_startu=Color.black;
				 		}//koniec kolor staru
					 
				 for(int j=0; j<8; j++){
					 tab_pole[i][j]=new Pole(i,j,kolor_startu);
					 		if(kolor_startu==Color.white){
					 				kolor_startu=Color.black;
					 		}else{
					 				kolor_startu=Color.white;
					 				
					 			 }
				 					   }
			  }
			 
	 return tab_pole;
		 }
		
		void rysuj_szachownice(){
		setLayout(new GridLayout(8, 8));
		//JPanel panel=new JPanel();
		for(int i=1; i<9; i++){
		pole1=new Pole(1,i,Color.white);
		//pole1.setBackground(Color.white);
		add(pole1);
		i++;
		pole1=new Pole(1,i,Color.black);
		//pole1.setBackground(Color.black);
		add(pole1);
		}
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
			
			Pole [][] pol=new Pole[8][8]; //tab pol wszystkich
			pol=inicjuj_tablice();
			panele=new JPanel[32];//tablica czarnych pol
			int k=0;
			for(int i=0;i<8 ; i++){
				for(int j=0;j<8;j++){
					System.out.println(pol[i][j].getPozycjaX()+"  "+pol[i][j].getPozycjaY()+"  "+pol[i][j].getColor());
					if(pol[i][j].getColor()==Color.black){
					panel=new JPanel();	
					panel.setBackground(pol[i][j].getColor());
					panele[k]=panel;
					add(panel);
					k++;
					}
					else{
					panel=new JPanel();
					panel.setBackground(pol[i][j].getColor());
					add(panel);
					}
				}
			}
			
			
			//tworzymy graczy i pionki
			Gracz Gracz1=new Gracz("gracz1");
			Gracz Gracz2=new Gracz("gracz2");
			 Pionek[] pionekgracza1 = new Pionek[12];
			for(int i = 0, j=1; i<4; i++, j+=2){
				pionekgracza1[i] = new Pionek(Gracz1, 0,j, new JLabel(Gracz1.getNazwa()) );
				panele[i].add(pionekgracza1[i].getLabel());
			}
			for(int i = 4, j=0; i<8; i++, j+=2){
				pionekgracza1[i] = new Pionek(Gracz1, 1,j, new JLabel(Gracz1.getNazwa()) );
				panele[i].add(pionekgracza1[i].getLabel());
			}
			for(int i = 8, j=2; i<12; i++, j+=2){
				pionekgracza1[i] = new Pionek(Gracz1, 2,j, new JLabel(Gracz1.getNazwa()) );
				panele[i].add(pionekgracza1[i].getLabel());
			}
//2 gracz
		
			Pionek[] pionekgracza2 = new Pionek[12];
			for(int i = 0, j=6; i<4; i++, j-=2){
				pionekgracza2[i] = new Pionek(Gracz2, 7,j, new JLabel(Gracz2.getNazwa()) );
				panele[31-i].add(pionekgracza2[i].getLabel());
		
			}
			
			for(int i = 4, j=7; i<8; i++, j-=2){
				pionekgracza2[i] = new Pionek(Gracz2, 6,j, new JLabel(Gracz2.getNazwa()) );
				panele[31-i].add(pionekgracza2[i].getLabel());
			
			}
			
			for(int i = 8, j=6; i<12; i++, j-=2){
				pionekgracza2[i] = new Pionek(Gracz2, 5,j, new JLabel(Gracz2.getNazwa()) );
				panele[31-i].add(pionekgracza2[i].getLabel());
			
			}

			out.println(pionekgracza2[10].getPozycjaX()+"  "+(pionekgracza2[10].getPozycjaY()));
			
			pionekgracza2[10].setPozycjaX(4);
			pionekgracza2[10].setPozycjaY(1);
			out.println(pionekgracza2[10].getPozycjaX()+"  "+(pionekgracza2[10].getPozycjaY()));
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
			// TODO Auto-generated method stub
			System.out.println(e.getX()+"  "+e.getY());
			int x=e.getX()/100;
			int y=e.getY()/100;
			System.out.println(x+"  "+y);
			for(int i=0;i<12;i++){
				///
				
			}
			
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


