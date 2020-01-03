package javaproject;

import java.awt.Color;

import javax.swing.JButton;

public class TimerCons extends Thread{
	private JButton btnConsole[];
	private int con;
	private Console cons[];
	
	public TimerCons(JButton btn[], int c, Console console[]){
		btnConsole=btn;
		con=c;
		cons=console;
	}
public void run () {

	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
	btnConsole[con].setForeground(Color.BLACK);
	btnConsole[con].setBackground(new Color(255, 255 , 255));
	cons[con].reparer();
	cons[con].rzUtiEtu();
}
}
