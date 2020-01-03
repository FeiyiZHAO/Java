package javaproject;

import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TimerEtu extends Thread {

	private int numEtu;
	private JFrame frame;
	private Etudiant etu[];
	private Console cons[];
	private Niveau niv;
	private JButton btnEtudiant[];
	CountDownLatch latch;
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
        frame.getContentPane().remove(btnEtudiant[numEtu]); //Enl��vement du bouton de l'��tudiant si d�lai d�pass?
        etu[numEtu].sortir();
		frame.repaint();
		if(etu[numEtu].getEtat()==1)//Si l'�tudiant avait �t?plac??un console 
		{
			int i=0;
			while(cons[i].getNumEtu()!=numEtu)//Chercher la console qui �tait occup?par l'�tudiant
			{
				i++;
			}
			cons[i].liberer(); //Et la lib��rer
		}
		niv.comboInit();//Remettre le combo ?1

		 
		
    }
}
