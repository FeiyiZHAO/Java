package javaproject;

import  javax.swing.*;

import  java.awt.*;
import  java.awt.event.*;

public class FenetreNiv extends JFrame implements ActionListener{
	private JFrame frame;
  public FenetreNiv(){
		
    this.setTitle("Jeu de gestion");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    JPanel p1 = new JPanel();
    Button b1 = new Button("Niveau facile");
    b1.addActionListener(this);
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
    p1.add(b1);
    
    JPanel p2 = new JPanel();
    Button b2 = new Button("Niveau moyen");
    b2.addActionListener(this);
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
    p2.add(b2);
    
    JPanel p3 = new JPanel();
    Button b3 = new Button("Niveau difficile");
    b3.addActionListener(this);
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    p3.setLayout(new BoxLayout(p3, BoxLayout.LINE_AXIS));
    p3.add(b3);   

    JPanel p5 = new JPanel();
    Button b5 = new Button("Retourner");
    b5.addActionListener(this);
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    p5.setLayout(new BoxLayout(p5, BoxLayout.LINE_AXIS));
    p5.add(b5);   

    JPanel p4 = new JPanel();
    //On positionne maintenant ces trois lignes en colonne
    p4.setLayout(new BoxLayout(p4, BoxLayout.PAGE_AXIS));
    p4.add(p1);
    p4.add(p2);
    p4.add(p3);
    p4.add(p5);

    this.getContentPane().add(p4);
    this.setVisible(true);
  }

@Override
public void actionPerformed(ActionEvent e) {
	String composant = e.getActionCommand();
	if(composant=="Niveau facile") {
		NiveauFacile facile = new NiveauFacile();
		facile.main(null);
		this.setVisible(false);
		}
	if(composant=="Niveau moyen") {
		NiveauMoyen moyen = new NiveauMoyen();
		moyen.main(null);
		this.setVisible(false);
	}
		
	if(composant=="Niveau difficile") {
		NiveauDiffi d = new NiveauDiffi();
		d.main(null);
		this.setVisible(false);
	}
	
	if(composant=="Retourner") {
		new Fenetre();
		this.dispose();
	}
		
	
}
  
}