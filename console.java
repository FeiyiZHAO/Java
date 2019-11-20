import java.lang.*;

public class console {
	private int num;
	private boolean libre;
	private boolean panne;
	
	public console(int n) // constructeur
	{
		num=n;
		libre=true;
		panne=false;
	}
	public void enregistrer() 
	{
		
	}
	public void envoyerUv() 
	{

	}
	public void occuper() 
	{
		libre=false;
	}
	public void liberer() 
	{
		libre=true;
	}
	public void panne() 
	{
		panne=true;
	}
	public void reparer() 
	{
		panne=false;
	}
	public void finalize(){} //destructeur
}

