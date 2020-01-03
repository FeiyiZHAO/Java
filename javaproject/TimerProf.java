package javaproject;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TimerProf extends Thread {
	private JFrame frame;
	private JButton btnProfesseur[];
	private Console cons[];
	private int c;
	private GridBagConstraints gbc_btnProf;
	
	public TimerProf(JFrame f, JButton b[], Console con[], int co ,GridBagConstraints gbc){
		frame = f;
		btnProfesseur=b;
		cons = con;
		c = co;
		gbc_btnProf = gbc;
	}
public void run () {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//le prof disparait 5s
		frame.getContentPane().add(btnProfesseur[cons[c].getNumProf()], gbc_btnProf);
}
}
