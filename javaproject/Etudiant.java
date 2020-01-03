package javaproject;

public class Etudiant {
	private int num;
	private boolean satisfait;
	private int etat;
	private boolean dansSalle;
	
	public Etudiant(int n)
	{
		num=n;
		satisfait=false;
		etat=0;
		dansSalle=false;
	}
	public void choisirUv()
	{
		if (dansSalle == true) {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	public void satisfait()
	{
		satisfait=true;
	}
	public int getEtat()
	{
		return etat;
	}
	public void etatPlus()
	{
		etat++;
	}
	public void entree() {
		dansSalle = true;
	}
	public void sortir() {
		dansSalle = false;
	}
	public boolean getDansSalle() {
		return dansSalle;
	}
	public void finalize(){} //destructeur	
}

