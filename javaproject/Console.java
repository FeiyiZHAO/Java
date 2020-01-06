package javaproject;


public class Console {
	@SuppressWarnings("unused")
	private int num;
	private boolean libreEtu;
	private boolean libreProf;
	private boolean panne;
	private int numEtu;
	private int numProf;
	private int utiEtu;
	
	public Console(int n) // constructeur
	{
		num=n;
		libreEtu=true;
		libreProf=true;
		panne=false;
	}
	public void occuperEtu() 
	{
		libreEtu=false;
	}
	public void occuperProf() 
	{
		libreProf=false;
	}
	public void liberer() 
	{
		libreEtu=true;
		libreProf=true;
	}
	public void panne() 
	{
		panne=true;
	}
	public void reparer() 
	{
		panne=false;
	}
	public boolean getLibreEtu()
	{
		return libreEtu;
	}
	public boolean getLibreProf()
	{
		return libreProf;
	}
	public void setNumEtu(int num)
	{
		numEtu=num;
	}
	public int getNumEtu()
	{
		return numEtu;
	}
	public int getNumProf()
	{
		return numProf;
	}
	public void setNumProf(int num)
	{
		numProf=num;
	}
	public int getutiEtu() {
		return utiEtu;
	}
	public void utiEtuPlus() {
		utiEtu++;
	}
	public int rzUtiEtu() {
		utiEtu = 0;
		return utiEtu;
	}
	public boolean etatPanne() {
		return panne;
	}
	public void finalize(){} //destructeur
}

