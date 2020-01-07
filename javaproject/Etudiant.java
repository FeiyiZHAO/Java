package javaproject;

public class Etudiant {
	@SuppressWarnings("unused")
	private int num;
	@SuppressWarnings("unused")
	private boolean satisfait;
	private int etat;
	private boolean dansSalle;
	private String major;
	private boolean selectif;
	
	public Etudiant(int n)
	{
		num=n;
		satisfait=false;
		etat=0;
		dansSalle=true;

	}
	public Etudiant(int n, String major)
	{
		num=n;
		satisfait=false;
		etat=0;
		dansSalle=true;
		this.major = major;
	}
	
	public void choisirUv(int time_interval)
	{
		if (dansSalle == true) {
		try {
			Thread.sleep(time_interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dansSalle = false;
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
	public String getMajor() {
		return major;
	}
	
	public void setDifficile(boolean selectif) {
		this.selectif = selectif;
	}
	
	public boolean getDifficile() {
		return selectif;
	}

	public void finalize(){} //destructeur	
}

