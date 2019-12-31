package javaproject;

public class Etudiant {
	private int num;
	private boolean satisfait;
	private int etat;
	
	public Etudiant(int n)
	{
		num=n;
		satisfait=false;
		etat=0;
	}
	public void choisirUv()
	{
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
	public void finalize(){} //destructeur	
}

