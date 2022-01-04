import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PannelloGrafico
{	private JFrame frame;
	private JTextField[][] matriceA;
	private JTextField[][] matriceB;
	private JButton[] bottoni;
	private JLabel messaggio;
	private String titoloFinestra;
	private int numeroRigheA;
	private int numeroColonneA;
	private int numeroRigheB;
	private int numeroColonneB;
	private int numeroBottoni;
	
	public PannelloGrafico()
	{	
		titoloFinestra = "2048";
		numeroRigheA = 4 ; 
		numeroColonneA = 4;
		numeroRigheB = 4;
		numeroColonneB = 4;
		numeroBottoni = 9;
		
		inizializza();
		bloccaMatriceA();
		bloccaMatriceB();
	}
	
	

	private void bottonePremuto(int numeroBottone) {
		
		switch(numeroBottone) {
			case 1:
				setMatriceA(convertiDaMatriceIntera(iniziaPartita(convertiInMatriceIntera(getMatriceA()))));
				setMatriceB(convertiDaMatriceIntera(iniziaPartita(convertiInMatriceIntera(getMatriceB()))));
				break;
			case 2:
				setMatriceA(convertiDaMatriceIntera(suGiocatoreA(convertiInMatriceIntera(getMatriceA()))));
				break;
			case 3:
				setMatriceA(convertiDaMatriceIntera(sinistraGiocatoreA(convertiInMatriceIntera(getMatriceA()))));
				break;
			case 4:
				setMatriceA(convertiDaMatriceIntera(destraGiocatoreA(convertiInMatriceIntera(getMatriceA()))));
				break;
			case 5:
				setMatriceA(convertiDaMatriceIntera(giuGiocatoreA(convertiInMatriceIntera(getMatriceA()))));
				break;
			case 6:
				setMatriceB(convertiDaMatriceIntera(suGiocatoreB(convertiInMatriceIntera(getMatriceB()))));
				break;
			case 7:
				setMatriceB(convertiDaMatriceIntera(sinistraGiocatoreB(convertiInMatriceIntera(getMatriceB()))));
				break;
			case 8:
				setMatriceB(convertiDaMatriceIntera(destraGiocatoreB(convertiInMatriceIntera(getMatriceB()))));
				break;
			case 9:
				setMatriceB(convertiDaMatriceIntera(giuGiocatoreB(convertiInMatriceIntera(getMatriceB()))));
				break;
		}
	


		
	}

	public static void main(String[] args) {
	
		PannelloGrafico p = new PannelloGrafico();
		
		p.setEtichettaBottone(1,"Nuova Partita");
		p.setEtichettaBottone(2, "Su");
		p.setEtichettaBottone(3, "Sinistra");
		p.setEtichettaBottone(4, "Destra");
		p.setEtichettaBottone(5, "Gi�");
		p.setEtichettaBottone(6, "Su");
		p.setEtichettaBottone(7, "Sinistra");
		p.setEtichettaBottone(8, "Destra");
		p.setEtichettaBottone(9, "Gi�");
		
	}

	private void setMessaggio(String m)
	{	messaggio.setText(m);
	}

	private void setEtichettaBottone(int numeroBottone, String etichetta)
	{	bottoni[numeroBottone-1].setText(etichetta);
	}

	private String[][] getMatriceA()
	{	String[][] ret = new String[numeroRigheA][numeroColonneA];
		for(int i=0;i<numeroRigheA;i++)
			for(int j=0;j<numeroColonneA;j++)
				ret[i][j] = matriceA[i][j].getText();
		return ret;
	}

	private String[][] getMatriceB()
	{	String[][] ret = new String[numeroRigheB][numeroColonneB];
		for(int i=0;i<numeroRigheB;i++)
			for(int j=0;j<numeroColonneB;j++)
				ret[i][j] = matriceB[i][j].getText();
		return ret;
	}

	private void setMatriceA(String[][] A)
	{	for(int i=0;i<numeroRigheA;i++)
			for(int j=0;j<numeroColonneA;j++)
				matriceA[i][j].setText(A[i][j]);
	}

	private void setMatriceB(String[][] B)
	{	for(int i=0;i<numeroRigheB;i++)
			for(int j=0;j<numeroColonneB;j++)
				matriceB[i][j].setText(B[i][j]);
	}
	
	private void bloccaMatriceA()
	{	for(int i=0;i<numeroRigheA;i++)
			for(int j=0;j<numeroColonneA;j++)
				matriceA[i][j].setEditable(false);;
	}
	private void bloccaMatriceB()
	{	for(int i=0;i<numeroRigheB;i++)
			for(int j=0;j<numeroColonneB;j++)
				matriceB[i][j].setEditable(false);;
	}

	private int[][] convertiInMatriceIntera(String[][] m)
	{	int nRighe=m.length;
		int nColonne=m[0].length;
		int[][] ret = new int[nRighe][nColonne];
		for(int i=0;i<nRighe;i++)
			for(int j=0;j<nColonne;j++)
				if(m[i][j].equals(""))
					ret[i][j]=0;
				else
					ret[i][j]=Integer.parseInt(m[i][j]);
		return ret;
	}

	private String[][] convertiDaMatriceIntera(int[][] m)
	{	int nRighe=m.length;
		int nColonne=m[0].length;
		String[][] ret = new String[nRighe][nColonne];
		for(int i=0;i<nRighe;i++)
			for(int j=0;j<nColonne;j++)
				if(m[i][j] == 0)
					ret[i][j] = "";
				else {
					int v = m[i][j];
					ret[i][j] = String.valueOf(v);
				}
		return ret;
	}

	private void inizializza()
	{	frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{	System.out.println(e);
			System.exit(0);
		}
		frame.setVisible(true);
		frame.setBounds(100, 100, 1200, 480+30*numeroBottoni);
		frame.setTitle(titoloFinestra);

		messaggio = new JLabel("");
		frame.getContentPane().add(messaggio);
		messaggio.setBounds(435, 460, 300, 30);
		messaggio.setHorizontalAlignment(JLabel.CENTER);

		bottoni=new JButton[numeroBottoni];
		ActionListener listener = new PressioneBottoni();
		for(int i=0;i<numeroBottoni;i++)
		{	JButton bottone=new JButton();
		if(i == 0) {
			bottone.setBounds(515, 490+30*i, 150, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}
		if(i == 1) {
			bottone.setBounds(230, 490+30*i, 100, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}
		if( i == 2) {
			bottone.setBounds(160, 500+30*i, 100, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}
		if( i == 3) {
			bottone.setBounds(300, 470+30*i, 100, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}
		if(i == 4) {
			bottone.setBounds(230, 480+30*i, 100, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}
		if( i == 5) {
			bottone.setBounds(860, 370+30*i, 100, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}
		if( i == 6) {
			bottone.setBounds(790, 380+30*i, 100, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}
		if( i == 7) {
			bottone.setBounds(930, 350+30*i, 100, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}
		if( i == 8) {
			bottone.setBounds(860, 360+30*i, 100, 30); //colonna,riga, larghezza
			bottoni[i]=bottone;
			bottone.addActionListener(listener);
			frame.getContentPane().add(bottone);
		}}

		matriceA = new JTextField[numeroRigheA][numeroColonneA];
		for(int i=0;i<numeroRigheA;i++)
			for(int j=0;j<numeroColonneA;j++)
			{	JTextField campoTesto = new JTextField("");
				frame.getContentPane().add(campoTesto);
				campoTesto.setBounds(50+50*j, 60+40*i, 50, 40);
				campoTesto.setHorizontalAlignment(JTextField.CENTER);
				matriceA[i][j] = campoTesto;
			}
		for(int i=0;i<numeroRigheA;i++)
		{	JLabel numeroRigaA = new JLabel(""+i);
			frame.getContentPane().add(numeroRigaA);
			numeroRigaA.setBounds(30, 60+40*i, 50, 40);
		}
		for(int j=0;j<numeroColonneA;j++)
		{	JLabel numeroColonnaA = new JLabel(""+j);
			frame.getContentPane().add(numeroColonnaA);
			numeroColonnaA.setBounds(70+50*j, 30, 50, 40);
		}

		if(numeroRigheB != 0 || numeroColonneB != 0)
		{	matriceB = new JTextField[numeroRigheB][numeroColonneB];
			for(int i=0;i<numeroRigheB;i++)
				for(int j=0;j<numeroColonneB;j++)
				{	JTextField campoTesto = new JTextField("");
					frame.getContentPane().add(campoTesto);
					campoTesto.setBounds(630+50*j, 60+40*i, 50, 40);
					campoTesto.setHorizontalAlignment(JTextField.CENTER);
					matriceB[i][j] = campoTesto;
				}
			for(int i=0;i<numeroRigheB;i++)
			{	JLabel numeroRigaB = new JLabel(""+i);
				frame.getContentPane().add(numeroRigaB);
				numeroRigaB.setBounds(610, 60+40*i, 50, 40);
			}
			for(int j=0;j<numeroColonneB;j++)
			{	JLabel numeroColonnaB = new JLabel(""+j);
				frame.getContentPane().add(numeroColonnaB);
				numeroColonnaB.setBounds(650+50*j, 30, 50, 40);
			}
		}
	}

	private class PressioneBottoni implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	int numeroBottonePremuto = -1;
			for(int i=0;i<numeroBottoni;i++)
				if(e.getSource()==bottoni[i])
					numeroBottonePremuto = i + 1;
			bottonePremuto(numeroBottonePremuto);
		}
	}
	
	private int[][] AzzeraMatrice(int[][] m)
	{
		for(int i=0; i<numeroRigheA; i++)
			for(int j=0; j<numeroRigheB; j++)
				m[i][j]= 0 ;
		return m;
	}
	
	private int[][] iniziaPartita(int[][] m)
	{
		AzzeraMatrice(m);
		int k = 0;
		while(k<4)
		{
			Random r = new Random();
			int i = r.nextInt(numeroRigheA);
			int j = r.nextInt(numeroColonneA);
			if(m[i][j] == 0)
			{
				m[i][j] = 2;
				k++; //contatore dei 4 casuali
			}
			
			setMessaggio("Tocca al giocatore A");
			
			
		}
		
		return m;
	}
	
	private int[][]destraGiocatoreA(int[][]m)
	{	boolean modificata=false;
		for(int i=0;i<numeroRigheA;i++) {
			for(int j=numeroColonneA-1;j>=1;j--) {  // consideriamo gli elementi dall'ultimo al primo a partire da sinistra e sommiamo quelli uguali
				if(m[i][j]!= 0) {                 //ci spostiamo verso sinistra
					for(int k=1;j-k>=0;k++) {
						if(m[i][j-k]!=0 && m[i][j] != m[i][j-k]) {    //se ne incontriamo uno diverso blocchiamo questo ciclo
							break;
						}
						if(m[i][j]==m[i][j-k]) {   //se lo troviamo modifichiamo e blocchiamo questo ciclo
							m[i][j]+=m[i][j-k];
							m[i][j-k]=0;
							modificata=true;
							break;
						}
					}
				}
			}
		}
		
		for(int i=0;i<numeroRigheA;i++) { // conrtrolla se a destra c'� lo zero;
			for(int j=numeroColonneA-2;j>=0;j--) {  // adesso li spostiamo muovendoci sempre verso sinistra
				if(m[i][j]!=0) {
					for(int k=0;j+k<=numeroColonneA-2;k++) {
						if(m[i][j+k+1]==0) {
							m[i][j+k+1]=m[i][j+k];
							m[i][j+k]=0;
							modificata=true;
						}
					}
				}
			}
		}
		if(modificata==false) {    //non abbiamo modificato niente quindi dobbiamo cambiare mossa;
			setMessaggio("Riprova");
			return m;
		}
		
		if (modificata==true) {  //se abbiamo modificato il programma deve generare il 2 in posizione casuale
			genera2(m);
		}
		
		if(modificata==true && cellaVuota(m)==false && celleAdiacenti(m)==false) {//se � stata modificata e non c'� almeno una cella libera
			                                                                    //e se non ci sono nemmeno celle adiacenti, il giocatore b ha vinto 
			setMessaggio("Il giocatore A perde! Premere NUOVA PARTITA per ricominciare");
			return m;
		}
		
		else {
			setMessaggio("Tocca al giocatore B");
			for(int i = 1;i<5;i++)
				bottoni[i].setVisible(false);
			for(int j = 5;j<9;j++)
				bottoni[j].setVisible(true);
			return m;
		}
		
		
		}
		
	private int[][]destraGiocatoreB(int[][]m)
	{	boolean modificata=false;
		for(int i=0;i<numeroRigheB;i++) {
			for(int j=numeroColonneB-1;j>=1;j--) {  // consideriamo gli elementi dal penultimo al primo a partire da sinistra e sommiamo quelli uguali
				if(m[i][j]!= 0) {                 //ci spostiamo verso sinistra
					for(int k=1;j-k>=0;k++) {
						if(m[i][j-k]!=0 && m[i][j] != m[i][j-k]) {    //se ne incontriamo uno diverso blocchiamo questo ciclo
							break;
						}
						if(m[i][j]==m[i][j-k]) {   //se lo troviamo modifichiamo e blocchiamo questo ciclo
							m[i][j]+=m[i][j-k];
							m[i][j-k]=0;
							modificata=true;
							break;
						}
					}
				}
			}
		}
		//for per spostamento
		for(int i=0;i<numeroRigheB;i++) {// controlla se a destra c'� lo zero;
			for(int j=numeroColonneB-2;j>=0;j--) {  // adesso li spostiamo muovendoci sempre verso sinistra
				if(m[i][j]!=0) {
					for(int k=0;j+k<=numeroColonneB-2;k++) {
						if(m[i][j+k+1]==0) {
							m[i][j+k+1]=m[i][j+k]; //se il numero a destra � 0 lo scambia con quello della colonna successiva
							m[i][j+k]=0;
							modificata=true;
						}
					}
				}
			}
		}
		if(modificata==false) {    //non abbiamo modicato nulla dobbiamo cambiare la mossa;
			setMessaggio("Riprova");
			return m;
		}
		
		if (modificata==true) {    //se abbiamo modificato il programma generare il 2 in posizione casuale
			genera2(m);
		}
		
		if(modificata==true && cellaVuota(m)==false && celleAdiacenti(m)==false) {//se � stata modificata e non c'� almeno una cella libera
			                                                                    //e non ci sono celle adiacenti, il giocatore A ha vinto; 
			setMessaggio("Il giocatore B perde! Premere NUOVA PARTITA per ricominciare");
			return m;
		}
		
		else {
			setMessaggio("Tocca al giocatore A");
			for(int i = 5; i<9; i++)
				bottoni[i].setVisible(false);
			for(int j= 1; j < 5; j++)
				bottoni[j].setVisible(true);
			return m;
		}
		
		
		}
		private int[][] sinistraGiocatoreA(int[][] m){
			boolean modificata=false;
			for(int i=0;i<numeroRigheA;i++) {
				for(int j=0;j<numeroColonneA;j++) {  // consideriamo gli elementi dal primo al'ultimo a partire da destra e sommiamo quelli uguali
					if(m[i][j]!= 0) {                 //ci spostiamo verso destra
						for(int k=1;j+k<numeroColonneA;k++) {
							if(m[i][k+j]!=0 && m[i][j] != m[i][k+j]) {    //se ne incontriamo uno diverso blocchiamo questo ciclo
								break;
							}
							if(m[i][j]==m[i][k+j]) {   //se lo troviamo modifichiamo e blocchiamo questo ciclo
								m[i][j]+=m[i][k+j];
								m[i][k+j]=0;
								modificata=true;
								break;
							}
						}
					}
				}
			}
			for(int i=0;i<numeroRigheA;i++) {
				for(int j=1;j<numeroColonneA;j++) {  // adesso li spostiamo muovendoci sempre verso destra
					if(m[i][j]!=0) {
						for(int k=0;j-k>=0;k++) { 
							if(m[i][j-k]==0) {
								m[i][j-k]=m[i][j-k+1];
								m[i][j-k+1]=0;
								modificata=true;
							}
						}
					}
				}
			}
			if(modificata==false) {    //non � stato modificato nulla dobbiamo cambiare mossa;
				setMessaggio("Riprova");
				return m;
			}
			
			if (modificata==true) {    //se abbiamo modificatao il programma deve generare il 2 in posizione casuale
				genera2(m);
			}
			
			if(modificata==true && cellaVuota(m)==false && celleAdiacenti(m)==false) {//se � stata modificata e non c'� almeno una cella libera
				                                                                    //e se non ci sono celle adiacenti, il giocatore B ha  vinto 
				setMessaggio("Il giocatore A perde! Premere NUOVA PARTITA per ricominciare");
				return m;
			}
			
			else {
				setMessaggio("Tocca al giocatore B");
				for(int i = 1;i<5;i++)
					bottoni[i].setVisible(false);
				for(int j = 5;j<9;j++)
					bottoni[j].setVisible(true);
				return m;
			}
			
		}
		
		private int[][] sinistraGiocatoreB(int[][]m)
		{
				boolean modificata=false;
				for(int i=0;i<numeroRigheB;i++) {
					for(int j=0;j<numeroColonneB;j++) {  // consideriamo gli elementi dal primo all'ultimo a partire da destra e sommiamo quelli uguali
						if(m[i][j]!= 0) {                 //ci spostiamo verso destra
							for(int k=1;j+k<numeroColonneB;k++) {
								if(m[i][k+j]!=0 && m[i][j] != m[i][k+j]) {    //se ne incontriamo uno diverso blocchiamo questo ciclo
									break;
								}
								if(m[i][j]==m[i][k+j]) {   //se lo troviamo modifichiamo e blocchiamo questo ciclo
									m[i][j]+=m[i][k+j];
									m[i][k+j]=0;
									modificata=true;
									break;
								}
							}
						}
					}
				}
				for(int i=0;i<numeroRigheB;i++) {
					for(int j=1;j<numeroColonneB;j++) {  // adesso li spostiamo muovendoci sempre verso destra
						if(m[i][j]!=0) {
							for(int k=0;j-k>=0;k++) { 
								if(m[i][j-k]==0) {
									m[i][j-k]=m[i][j-k+1];
									m[i][j-k+1]=0;
									modificata=true;
								}
							}
						}
					}
				}
				if(modificata==false) {    //non � stato modificat nulla si deve cambiare mossa
					setMessaggio("Riprova");
					return m;
				}
				
				if (modificata==true) {    //se abbiamo modificato il programma deve generare il 2 in posizione casuale
					genera2(m);
				}
				
				if(modificata==true && cellaVuota(m)==false && celleAdiacenti(m)==false) {//se � stata modificata e non c'� almeno una cella libera
					                                                                    //e se non ci sono neanche celle adiacenti, il giocatore A ha vinto 
					setMessaggio("Il giocatore B perde! Premere NUOVA PARTITA per ricominciare");
					return m;
				}
				
				else {
					setMessaggio("Tocca al giocatore A");
					for(int i = 5; i<9; i++)
						bottoni[i].setVisible(false);
					for(int j= 1; j < 5; j++)
						bottoni[j].setVisible(true);
					return m;
				}
				
			}
		
		private int[][] suGiocatoreA(int[][]m){
			
			boolean modificata = false;
			for(int i = 0; i < numeroRigheA; i++) {
				for(int j = 0;j< numeroColonneA;j++) { //  ci muoviamo verso il basso e sommiamo verso sopra
					if(m[i][j] != 0) {
						for(int k = 1; k+i< numeroRigheA;k++) {
							if(m[i+k][j]!=0 && m[i+k][j]!= m[i][j])
								break;
							if(m[i+k][j]== m[i][j]) { // se sono le due celle adiacente gli elementi si sommano
								m[i][j]+= m[i+k][j];
								m[i+k][j] = 0;
								modificata = true;
								break;
							}
							
						}
					
						
					}
				}
			} // for per spostamento
			for(int i =1 ; i<numeroRigheA;i++) {
				for(int j = 0; j< numeroColonneA;j++) { 
					if(m[i][j]!= 0) {
						for(int k = 0;i-k>=0;k++) {  // ci muoviamo verso il basso scambiando gli elementi uguali a 0 con quelli diversi posizionandoli verso sopra;
							if(m[i-k][j] == 0) {
								m[i-k][j] = m[i-k+1][j];
								m[i-k+1][j] = 0;
								modificata = true;
							}
						}
					}
					
 				}
			}
			
			if(modificata==false) {    //non � stata modificata e quindi si deve cambiare mosse
				setMessaggio("Riprova");
				return m;
			}
			
			if (modificata==true) {    //se abbiamo modificato il programma deve generare il 2 in posizione casuale
				genera2(m);
			}
			
			if(modificata==true && cellaVuota(m)==false && celleAdiacenti(m)==false) {//se � stata modificato e non c'� nemmeno una cella libera
				                                                                    //e non ci sono neanche celle adiacenti, il giocatore B ha vinto 
				setMessaggio("Il giocatore A perde! Premere NUOVA PARTITA per ricominciare");
				return m;
			}
			
			else {
				setMessaggio("Tocca al giocatore B");
				for(int i = 1;i<5;i++)
					bottoni[i].setVisible(false);
				for(int j = 5;j<9;j++)
					bottoni[j].setVisible(true);
				return m;
			}
		}
		
		private int[][] suGiocatoreB(int[][]m){
			
			boolean modificata = false;
			for(int i = 0; i < numeroRigheB; i++) {
				for(int j = 0;j< numeroColonneB;j++) { //  ci muoviamo verso il basso
					if(m[i][j] != 0) {
						for(int k = 1; k+i< numeroRigheB;k++) {
							if(m[i+k][j]!=0 && m[i+k][j]!= m[i][j])
								break;
							if(m[i+k][j]== m[i][j]) { // se sono le due celle adiacente gli elementi si sommano
								m[i][j]+= m[i+k][j];
								m[i+k][j] = 0;
								modificata = true;
								break;
							}
							
						}
					
						
					}
				}
			} // for per spostamento
			for(int i =1 ; i<numeroRigheB;i++) {
				for(int j = 0; j< numeroColonneB;j++) { 
					if(m[i][j]!= 0) {
						for(int k = 0;i-k>=0;k++) {  // ci muoviamo verso il basso scambiando gli elementi uguali a 0 con quelli diversi posizionandoli verso sopra;
							if(m[i-k][j] == 0) {
								m[i-k][j] = m[i-k+1][j];
								m[i-k+1][j] = 0;
								modificata = true;
							}
						}
					}
					
				}
			}
			
			if(modificata==false) {    //non � stata modificato nulla quindi si deve cambiare mosse
				setMessaggio("Riprova");
				return m;
			}
			
			if (modificata==true) {    //se abbiamo modificato il programma deve generare il 2 in posizione casuale
				genera2(m);
			}
			
			if(modificata==true && cellaVuota(m)==false && celleAdiacenti(m)==false) {//se � stata modificata e non c'� almeno una cella libera
				                                                                    //e se non ci sono neanche celle adiacenti, il giocatore A ha vinto 
				setMessaggio("Il giocatore B perde! Premere NUOVA PARTITA per ricominciare");
				return m;
			}
			
			else {
				setMessaggio("Tocca al giocatore A");
				for(int i = 5; i<9; i++)
					bottoni[i].setVisible(false);
				for(int j= 1; j < 5; j++)
					bottoni[j].setVisible(true);
				return m;
			}
		}
		
		private int[][] giuGiocatoreA(int[][]m){
			boolean modificata = false;
			for(int i = numeroRigheA-1;i>= 0; i--) { 
				for(int j = 0; j< numeroColonneA;j++){// ci muoviamo verso sopra
					if(m[i][j]!=0) {
						for(int k = 1; i- k >= 0;k++) {
							if(m[i-k][j]!=0 && m[i-k][j] != m[i][j])
								break;
							if(m[i-k][j] == m[i][j]) {
								m[i][j] += m[i-k][j]; // sommiamo gli elementi uguali diversi da 0 adiacenti fra di loro
								m[i-k][j] = 0;
								modificata = true;
								break;
							}
								
							
						}
					}
					
				}
			}
			//  for per spostamento
			for(int i = numeroRigheA-2; i >= 0; i--) {
				for(int j = 0; j < numeroColonneA; j++) {
					if(m[i][j] != 0) {
						for(int k = 0; i+k < numeroRigheA-1; k++) {// ci spostiamo verso il basso scambiando gli elementi uguali a 0 con quelli diversi posizionandoli verso il basso;
							if(m[i+k+1][j] == 0) {
								m[i+k+1][j] = m[i+k][j];
								m[i+k][j] = 0;
								modificata = true;
							}
						}
					}
				}
			}
			
			if(modificata==false) {    //non � stata modificato nulla quindi si deve cambiare mosse
				setMessaggio("Riprova");
				return m;
			}
			
			if (modificata==true) {    //se abbiamo  modificato il programma deve generare il 2 in posizione casuale
				genera2(m);
			}
			
			if(modificata==true && cellaVuota(m)==false && celleAdiacenti(m)==false) {//se � stata modificata e non c'� almeno una cella libera
				                                                                    //e non ci sono neanche celle adiacenti, il giocatore B ha vinto 
				setMessaggio("Il giocatore A perde! Premere NUOVA PARTITA per ricominciare");
				return m;
			}
			
			else {
				setMessaggio("Tocca al giocatore B");
				for(int i = 1;i<5;i++)
					bottoni[i].setVisible(false);
				for(int j = 5;j<9;j++)
					bottoni[j].setVisible(true);
				return m;
			}
				
		}
		
		private int[][] giuGiocatoreB(int[][]m){
			boolean modificata = false;
			for(int i = numeroRigheB-1;i>= 0; i--) { 
				for(int j = 0; j< numeroColonneB;j++){// ci muoviamo verso sopra
					if(m[i][j]!=0) {
						for(int k = 1; i- k >= 0;k++) {
							if(m[i-k][j]!=0 && m[i-k][j] != m[i][j])
								break;
							if(m[i-k][j] == m[i][j]) {
								m[i][j] += m[i-k][j]; // sommiamo gli elementi uguali diversi da 0 adiacenti fra di loro
								m[i-k][j] = 0;
								modificata = true;
								break;
							}
								
							
						}
					}
					
				}
			}
			//  for per spostamento
			for(int i = numeroRigheB-2; i >= 0; i--) {
				for(int j = 0; j < numeroColonneA; j++) {// ci spostiamo verso il basso scambiando gli elementi uguali a 0 con quelli diversi posizionandoli verso il basso;
					if(m[i][j] != 0) {
						for(int k = 0; i+k < numeroRigheB-1; k++) {
							if(m[i+k+1][j] == 0) {
								m[i+k+1][j] = m[i+k][j];
								m[i+k][j] = 0;
								modificata = true;
							}
						}
					}
				}
			}
			
			if(modificata==false) {    //non � stata modificata nessuna mossa quindi si deve cambiare mosse
				setMessaggio("Riprova");
				return m;
			}
			
			if (modificata==true) {    //se abbiamo modificato il programma deve generare il 2 in posizione casuale
				genera2(m);
			}
			
			if(modificata==true && cellaVuota(m)==false && celleAdiacenti(m)==false) {//se � stata modificata e non c'� almeno una cella libera
				                                                                    //e non ci sono neanche delle celle adiacenti, il giocatore A ha vinto 
				setMessaggio("Il giocatore B perde! Premere NUOVA PARTITA per ricominciare");
				return m;
			}
			
			else {
				setMessaggio("Tocca al giocatore A");
				for(int i = 5; i<9; i++)
					bottoni[i].setVisible(false);
				for(int j= 1; j < 5; j++)
					bottoni[j].setVisible(true);
				return m;
			}
				
		}
					
					
			
			
		
		
			
		private int[][] genera2(int[][] m){ //genera un 2 appena trova una posizione casuale libera;
			
			boolean modificata = false;
			Random r = new Random();
			while(modificata == false) {
				int i= r.nextInt(numeroRigheA);
				int j= r.nextInt(numeroColonneA);
				if(m[i][j] == 0) {
					m[i][j] = 2;
					modificata = true;
					return m;
				}
			}
			return m;
				
				
			
		}
		
	
		private boolean cellaVuota(int[][] m) {
			for(int i=0; i<numeroRigheA;i++)
				for(int j=0; j<numeroColonneA;j++)
					if(m[i][j]== 0)
						return true;
			return false;
		}
		
		
		private boolean celleAdiacenti(int[][]m) {
			for(int i=0;i<numeroRigheA;i++) {
				for(int j=0;j<numeroColonneA;j++) {
					if(i>0 && m[i-1][j]==m[i][j])     //alto
						return true;
					if(i<numeroRigheA-1 && m[i+1][j] == m[i][j])    //basso
						return true;
					if(j>0 && m[i][j-1] == m[i][j])           //sx
						return true;
					if(j<numeroColonneA-1 && m[i][j+1] == m[i][j])     //dx
						return true;
				}
			}
			return false;
		}
}
		


