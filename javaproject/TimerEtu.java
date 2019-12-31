package javaproject;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TimerEtu extends Thread {

	private int numEtu;
	private JFrame frame;
	private Etudiant etu[];
	private Console cons[];
	private Niveau niv;
	private JButton btnEtudiant[];
	
	public TimerEtu(JFrame f, JButton btne[],Niveau n,Etudiant e[],Console c[],int num)
	{
		numEtu=num;
		frame=f;
		btnEtudiant=btne;
		niv=n;
		etu=e;
		cons=c;
	}
	
	public void run() {
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        frame.getContentPane().remove(btnEtudiant[numEtu]); //Enlèvement du bouton de l'étudiant si délai dépassé
		frame.repaint();
		if(etu[numEtu].getEtat()==1)//Si l'étudiant avait été placé à un console 
		{
			int i=0;
			while(cons[i].getNumEtu()!=numEtu)//Chercher la console qui était occupé par l'étudiant
			{
				i++;
			}
			cons[i].liberer(); //Et la libérer
		}
		niv.comboInit();//Remettre le combo à 1
		
    }
}
