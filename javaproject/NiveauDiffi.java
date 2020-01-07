package javaproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class NiveauDiffi {
	
	private JFrame frame;
	private Niveau niv;
	private Professeur prof[];
	private Console cons[];
	private Etudiant etu[];
	private JButton btnConsole[];
	private JButton btnProfesseur[];
	private JButton btnEtudiant[];
	private JButton btnC[];
	private Thread t[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NiveauDiffi window = new NiveauDiffi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NiveauDiffi() {
		frame = new JFrame();
		niv = new Niveau(3);
		prof=new Professeur[niv.getNbrP()];
		cons=new Console[niv.getNbrC()];
		btnC=new JButton[niv.getNbrC()];
		etu=new Etudiant[niv.getNbrE()];
		t=new TimerEtu[niv.getNbrE()];
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Niveau Difficile");
		frame.setBounds(100, 100, 733, 508);
		
		frame.getContentPane().setBackground(new Color(255,239,213));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	// 10
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	//18
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//Affichage du chronom��tre
		GridBagConstraints gbc_btnJl2 = new GridBagConstraints();
    	gbc_btnJl2.gridx = 14;
    	gbc_btnJl2.gridy = 1;
    	GridBagConstraints gbc_btnJl3 = new GridBagConstraints();
    	gbc_btnJl3.gridx = 15;
    	gbc_btnJl3.gridy = 1;
		Counter c = new Counter(niv);
		frame.getContentPane().add(c.getJl2(), gbc_btnJl2);
		frame.getContentPane().add(c.getJl3(), gbc_btnJl3);
		c.start();
		
		//Affichage du score
		GridBagConstraints gbc_btnScore = new GridBagConstraints();
    	gbc_btnScore.gridx = 1;
    	gbc_btnScore.gridy = 1;
		frame.getContentPane().add(niv.getText(),gbc_btnScore);
		
		//Cr��ation automatis��e des boutons de consoles
		btnConsole = new JButton[niv.getNbrC()];		
		for(int i = 0; i<niv.getNbrC();i++)
	    {
			btnConsole[i]=new JButton("Console "+(i+1));
	    	cons[i]=new Console(i);
	    	GridBagConstraints gbc_btnConsole = new GridBagConstraints();
	    	gbc_btnConsole.gridx = 3+i;
	    	gbc_btnConsole.gridy = 4;
	    	btnConsole[i].setBackground(new Color(255, 255, 255));
	    	frame.getContentPane().add(btnConsole[i], gbc_btnConsole);
	    }
		
		//Cr��ation automatis��e des boutons des professeurs
		btnProfesseur = new JButton[niv.getNbrP()];		
		for(int j = 0; j<niv.getNbrP();j++)
	    {
			if(j%2==0)	
			{
				btnProfesseur[j]=new JButton("INFO Professeur "+(j+1));
				prof[j]=new Professeur(j, "INFO");
			}
			else 
			{
				btnProfesseur[j]=new JButton("IMSI Professeur "+(j+1));
				prof[j]=new Professeur(j, "IMSI");
			}
			
	    	GridBagConstraints gbc_btnProf = new GridBagConstraints();
	    	gbc_btnProf.gridx = 12;
	    	//gbc_btnProf.gridy = 2+(j*niv.getNbrC());
	    	gbc_btnProf.gridy = 2+j;
	    	btnProfesseur[j].setBackground(new Color(255, 255, 255));
	    	frame.getContentPane().add(btnProfesseur[j], gbc_btnProf);
			for(int k = 0; k<niv.getNbrE();k++)
			{
				if(k%2==0)	etu[k]=new Etudiant(k, "INFO");
				else etu[k]=new Etudiant(k, "IMSI");
				
				if(k%5==0)	etu[k].setDifficile(true);
				else etu[k].setDifficile(false);
				
				deplacementProf(k, j);	// Action associ��e aux boutons professeurs
			}
	    }
		
		//Cr��ation automatis��e des boutons des ��tudiants 
		btnEtudiant = new JButton[niv.getNbrE()];		
	    new	Thread(new	Runnable()	{ 
			@Override
			public void	run()	{
				for(int k = 0; k<niv.getNbrE();k++)
				{
					String typeEtuString = "";
					if(k%5==0)	typeEtuString += "Difficile ";
					else typeEtuString += "Pas Difficile ";
					
					if(k%2==0)
						typeEtuString += "INFO Etudiant "+(k+1);
					else
						typeEtuString += "IMSI Etudiant "+(k+1);
					
					btnEtudiant[k]=new JButton(typeEtuString);
					
					/*
					if(k%2==0)
						btnEtudiant[k]=new JButton("INFO Etudiant "+(k+1));
					else
						btnEtudiant[k]=new JButton("IMSI Etudiant "+(k+1));
					*/
					
					GridBagConstraints gbc_btnEtu = new GridBagConstraints();
					gbc_btnEtu.gridx = 1;
			    	//gbc_btnEtu.gridy = 2+(niv.getNbrC()*k);
					gbc_btnEtu.gridy = 2+k;
			    	frame.getContentPane().add(btnEtudiant[k], gbc_btnEtu);
			    	etu[k].entree();
			    	btnEtudiant[k].setForeground(Color.WHITE);
			    	btnEtudiant[k].setBackground(new Color(0, 225, 0));
			    	actionEtudiant(k); // Fonction associant les actions aux boutons
			    	t[k]=new TimerEtu(frame,btnEtudiant,niv,etu,cons,k); // Permet de cr��er le timer de 25 secondes 
			        													// et les actions qui en d��coulent
					t[k].start();
					try {
						Thread.sleep(10000); // attente de 10 secondes entre chaque entr��e d'��tudiants
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
				}
				try {
					Thread.sleep(50000); // attente de 10 secondes entre chaque entr�e d'�tudiants
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				frame.setVisible(false);
			}
	    }).start();	
	    
	    //Initialisation des boutons consoles temporaires pour les choix
	    for(int m=0;m<niv.getNbrC();m++)
	    {
	    	btnC[m]=new JButton ("");
	    }
	}
	
	public void deplacementProf(int k, int p)
	{
		btnProfesseur[p].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    		if((etu[k].getEtat())==1 && prof[p].getDispo() && etu[k].getMajor().equals(prof[p].getMajor())) //Si un ��tudiant est d��j?plac?et que le professeur est disponible
		    		{
		    			for(int i=0;i<niv.getNbrC();i++)
		    			{
		    				if(cons[i].getLibreProf() && !cons[i].getLibreEtu()) // Si la console est libre pour le professeur et occup?par un ��tudiant
		    				{
								afficheCons(p,i); // Affichage du choix des consoles
		    					btnProfesseur[p].setForeground(Color.BLACK);
			    				btnProfesseur[p].setBackground(new Color(255, 255, 255));
		    				}	
		    			}	
		    		
		    	}		
		    }
		});
	}
	public void afficheCons(int p,int c)
	{
		frame.getContentPane().remove(btnC[c]); // Enlever les boutons s'ils ��taient d��j?affich?pour un autre bouton
		frame.repaint(); //Mise ?jour de la fen��tre
		btnC[c]=new JButton("Console "+(c+1));
		
		GridBagConstraints gbc_btnb = new GridBagConstraints();
		gbc_btnb.gridx = 12;
	    gbc_btnb.gridy = 6+c+(niv.getNbrC()*p);  
	    btnC[c].setForeground(Color.WHITE);
	    btnC[c].setBackground(new Color(0, 225, 0));
	    frame.getContentPane().add(btnC[c], gbc_btnb);
	    frame.setBounds(100, 100, 734, 508);// Lors de l'ajout d'un bouton, mise ?jour par agrandissement et rapetissage de la fen��tre
	    
	    btnC[c].addActionListener(new ActionListener() { // action associ��e pour chacun des boutons
			 public void actionPerformed(ActionEvent e)
			 {
			    cons[c].setNumProf(p); // Ajout du num��ro du professeur au niveau de la console
			    for(int i=0;i<niv.getNbrC();i++)
			    {
			    	frame.getContentPane().remove(btnC[i]); // Enl��vement des boutons temporaires de choix
			    }
			    frame.repaint();
				GridBagConstraints gbc_btnProf = new GridBagConstraints();// D��placement du bouton du professeur ?la console
				gbc_btnProf.gridx = 3+c;
				gbc_btnProf.gridy = 6;
				frame.remove(btnProfesseur[p]);
				frame.getContentPane().add(btnProfesseur[p], gbc_btnProf);
				for(int i=0;i<niv.getNbrP();i++)
	    		{
					if(i!=p)
					{
						btnProfesseur[i].setForeground(Color.BLACK);
						btnProfesseur[i].setBackground(new Color(255, 255, 255));
					}
	    				
	    		}
				frame.setBounds(100, 100, 734, 508);
				
				prof[p].venir(); // M��thode pour mettre le professeur en occup?
				cons[c].occuperProf(); // M��thode pour dire que la console est prise par un professeur
				new	Thread(new	Runnable()	{
					@SuppressWarnings("deprecation")
					@Override
	    			public void	run()	{
	    				etu[cons[c].getNumEtu()].etatPlus(); // L'��tudiant a un ��tat en plus
	    				t[cons[c].getNumEtu()].stop(); // Stop des 25 secondes de satisfaction de l'��tudiant
	    				if(etu[cons[c].getNumEtu()].getDifficile())	etu[cons[c].getNumEtu()].choisirUv(10000);
	    				else etu[cons[c].getNumEtu()].choisirUv(7000);
	    				//etu[cons[c].getNumEtu()].choisirUv(); // M��thode d'attente de 7 secondes pour choisir les UVs
	    				
	    				frame.getContentPane().remove(btnEtudiant[cons[c].getNumEtu()]); //Supprimer une fois fait le bouton de l'��tudiant
	    				frame.repaint();
	    				etu[cons[c].getNumEtu()].sortir();
	    				cons[c].liberer(); //Lib��rer la console
	    				niv.ajoutScore(); //Calcul du score
	    				niv.comboPlus(); // Ajout au combo de 1
	    				
	    				frame.getContentPane().remove(btnProfesseur[cons[c].getNumProf()]);
	    				GridBagConstraints gbc_btnProf = new GridBagConstraints();//D��|placement du professeur ���� sa place d'origine
	    				gbc_btnProf.gridx = 12;
	    				//gbc_btnProf.gridy = 2+(niv.getNbrC()*cons[c].getNumProf());
	    				gbc_btnProf.gridy = 2+cons[c].getNumProf();
	    				prof[cons[c].getNumProf()].guideEPlus();
	    				//avoir termin��| le guide de 2 ��|tudiants
	    				if ( prof[cons[c].getNumProf()].getguideE() == 2) {
	    					TimerProf p=new TimerProf(frame, btnProfesseur, cons, c, gbc_btnProf);
	    					p.start();
	    					prof[cons[c].getNumProf()].rzguideE(); 
	    				}
	    				else {
		    				frame.getContentPane().add(btnProfesseur[cons[c].getNumProf()], gbc_btnProf);
	    				}
	    					    				
	    				// avoir ��|t��| utilis��|e par trois ��|tudiant
	    				cons[c].utiEtuPlus();
	    				int m = cons[c].getutiEtu();
	    				if (m==3) {
	    					cons[c].panne();
	    					btnConsole[c].setBackground(new Color(255, 0 , 0));
	    					reparerConsole(c);
	    						}
	    				

	    				frame.setBounds(100, 100, 734, 508);
	    				
	    				prof[cons[c].getNumProf()].attendreEtudiant();// Remettre le professeur en disponible
	    				for(int j=0;j<niv.getNbrE();j++)
	    				{
	    					if(etu[j].getEtat()==1 && prof[cons[c].getNumProf()].getMajor().equals(etu[j].getMajor())) //Si le professeur peut effectuer une action pour un eudiant mise en couleur du bouton
	    					{
	    						btnProfesseur[cons[c].getNumProf()].setForeground(Color.WHITE);
	    						btnProfesseur[cons[c].getNumProf()].setBackground(new Color(0, 225, 0));
	    					}
	    				}
	    			}
	    		}).start();
			 }
		});
	}
	
	public void apparitionChoixCons(int et,int c)
	{
		frame.getContentPane().remove(btnC[c]); // Enlever les boutons s'ils ��taient d��j?affich?pour un autre bouton
		frame.repaint(); //Mise ?jour de la fen��tre
		btnC[c]=new JButton("Console "+(c+1));
		GridBagConstraints gbc_btnb = new GridBagConstraints();
		gbc_btnb.gridx = 12;
	    gbc_btnb.gridy = 6+c+(niv.getNbrC()*et);  
	    btnC[c].setForeground(Color.WHITE);
	    btnC[c].setBackground(new Color(0, 225, 0));
	    frame.getContentPane().add(btnC[c], gbc_btnb);
	    frame.setBounds(100, 100, 734, 508);
	    
	    btnC[c].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
		    {
				for(int i=0;i<niv.getNbrC();i++)
			   	{
			   		frame.getContentPane().remove(btnC[i]);
			   	}
			   	frame.repaint();
			   	
			   	if (etu[et].getDansSalle()==true){
				cons[c].setNumEtu(et);// Ajout du num��ro de l'��tudiant au niveau de la console
			   
				GridBagConstraints gbc_btnEtu = new GridBagConstraints(); //D��placement du bouton de l'��tudiant pr��s de la console s��lectionn��e
				gbc_btnEtu.gridx = 3+c;
				gbc_btnEtu.gridy = 3;
				frame.remove(btnEtudiant[et]);
				frame.getContentPane().add(btnEtudiant[et], gbc_btnEtu);
				frame.setBounds(100, 100, 734, 508);
				
				for(int j=0;j<niv.getNbrP();j++)
				{
					if(prof[j].getDispo()==true && prof[j].getMajor().equals(etu[et].getMajor()))// Si les professeur sont libre les afficher en couleur pour montrer qu'une action est possible sur eux
					{
						btnProfesseur[j].setForeground(Color.WHITE);
				    	btnProfesseur[j].setBackground(new Color(0, 225, 0));
					}
				}
				cons[c].occuperEtu(); //M��thode pour montrer que la console n'est plus libre pour un ��tudiant
				etu[et].etatPlus(); //L'��tat de l'��tudiant augmente de 1
			 }
		    }
		});
	}

	public void actionDeplacementEtuCons(int etu)
	{
		for(int i=0;i<niv.getNbrC();i++)
		{
			if(cons[i].getLibreEtu() && !cons[i].etatPanne()) //Si la console est libre et pas en panne 
			{	
				apparitionChoixCons(etu,i);// faire appara?tre la console dans les choix de placement	
			}
		}
	}

	public void actionEtudiant(int et) {
		btnEtudiant[et].addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(etu[et].getEtat()==0) {
					btnEtudiant[et].setForeground(Color.BLACK);
			    	btnEtudiant[et].setBackground(new Color(255, 255, 255));
					actionDeplacementEtuCons(et); //Affichage du choix des consoles
				}
		    }
		});
	}

	public void reparerConsole(int con) {
 		btnConsole[con].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cons[con].etatPanne()==true) {
					TimerCons c= new TimerCons(btnConsole,con,cons);
					c.start();
				}
			}
		});
	}

}
