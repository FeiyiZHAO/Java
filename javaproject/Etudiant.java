package javaproject;

public class Etudiant {
	private int num;
	private boolean satisfait;
	private int etat;
	private boolean dansSalle;
	private String major;
	
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
	
	public void choisirUv()
	{
		if (dansSalle == true) {
		try {
			Thread.sleep(7000);
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

	public void finalize(){} //destructeur	
}

