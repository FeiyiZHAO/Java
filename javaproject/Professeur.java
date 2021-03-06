package javaproject;


public class Professeur {
	private int num;
	private boolean disponible;
	private int guideE;
	private String major;
	
	public Professeur(int n) // constructeur
	{
		setNum(n);
		disponible=true;
		guideE=0;
	}
	public Professeur(int n, String major) // constructeur
	{
		setNum(n);
		disponible=true;
		guideE=0;
		this.major = major;
	}
	public void venir() // m��thode qui animera un professeur pour le faire rejoindre l'��tudiant qui l'a appel�� et le rendra indisponible
	{
		disponible=false;
	}
	public void cafe() // m��thode qui animera le professeur pour qu'il aille chercher un caf�� et le rendra indisponible
	{
		disponible=false;
	}
	public void attendreEtudiant() // méthode qui animera un professeur pour le faire attendre dans un coin de la salle et le rendra disponible
	{
		disponible=true;
	}
	public boolean getDispo()
	{		
		return disponible;
	}
	public void finalize(){} //destructeur
	
	public void guideEPlus() {
		guideE++;
	}
	public int getguideE() {
	    return guideE;
	}
	public int rzguideE() {
		guideE=0;
		return guideE;
	}
	public String getMajor() {
		return major;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}


