import java.lang.System;

public class niveau {
	private int niv;
	private int nbrE;
	private int nbrC;
	private int nbrP;
	private int temps;
	private int score;
	
	public niveau(int n) // contructeur
	{
		niv = n;
		temps=3;
		score=0;
		switch(n)
		{
			case 1 :
				nbrE = 4;
				nbrC = 2;
				nbrP = 2;
			break;
			case 2 : 
				nbrE = 6;
				nbrC = 2;
				nbrP = 2;
			break;
			case 3 : 
				nbrE = 10;
				nbrC = 3;
				nbrP = 3;
			break;
		}
		System.out.println("Nombre étudiants : "+nbrE+". Nombre consoles : "+nbrC+". Nombre professeurs : "+nbrP);
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
	public int getScore() // récupération du score
	{
		return score;
	}
	public void finalize(){} //destructeur
}

