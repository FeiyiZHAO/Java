package javaproject;


import javax.swing.JLabel;

public class Niveau {
	private int niv;
	private int nbrE;
	private int nbrC;
	private int nbrP;
	private int temps;
	private int score;
	private int combo;
	private JLabel text;
	
	public Niveau(int n) // contructeur
	{
		niv = n;
		temps=3;
		text = new JLabel();
		score=0;
		combo=1;
		switch(n)
		{
			case 1 :
				nbrE = 4;
				nbrC = 2;
				nbrP = 2;
				temps = 60;
				break;
			case 2 : 
				nbrE = 6;
				nbrC = 2;
				nbrP = 2;
				temps = 90;
			break;
			case 3 : 
				nbrE = 10;
				nbrC = 3;
				nbrP = 3;
				temps = 150;
			break;
		}
	}
	public int getNiv() {
		return niv;
	}
	public int getNbrE() // récupération du nombre d'étudiants
	{
		return nbrE;
	}
	public int getNbrC()// récupération du nombre de consoles
	{
		return nbrC;
	}
	public int getNbrP() // récupération du nombre de professeurs
	{
		return nbrP;
	}
	public int getTemps() // récupération du temps
	{
		return temps;
	}
	public void comboPlus()
	{
		combo++;
	}
	
	public void comboInit()
	{
		combo=1;
	}
	public void ajoutScore()
	{
		score=score+20*combo;
		text.setText("Score : "+score);
	}
	
	public int getScore()
	{
		return score;
	}
	
	public JLabel getText()
	{
		text.setText("Score : "+score);
		return text;
	}

	public void finalize(){} //destructeur
}


