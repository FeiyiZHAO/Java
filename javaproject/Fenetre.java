package javaproject;

import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.applet.*;

public class Fenetre extends JFrame implements ActionListener{

  public Fenetre(){
		
    this.setTitle("Jeu de gestion");
    this.setSize(300, 120);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    JPanel p1 = new JPanel();
    Button b1 = new Button("Jouer");
    b1.addActionListener(this);
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
    p1.add(b1);
    
    JPanel p2 = new JPanel();
    Button b2 = new Button("R¨¨gles");
    b2.addActionListener(this);
    //Idem pour cette ligne
    p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
    p2.add(b2);
    
    JPanel p3 = new JPanel();
    //On positionne maintenant ces trois lignes en colonne
    p3.setLayout(new BoxLayout(p3, BoxLayout.PAGE_AXIS));
    p3.add(p1);
    p3.add(p2);

    this.getContentPane().add(p3);
    this.setVisible(true);
  }

@Override
public void actionPerformed(ActionEvent e) {
	String composant = e.getActionCommand();
	if(composant=="Jouer") {
		new FenetreNiv();
		this.dispose();}
	if(composant=="R¨¨gles")
		System.out.println("non");
	
}
  
}