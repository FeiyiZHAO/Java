import java.lang.*;

public class professeur {
	private int num;
	private boolean disponible;
	
	public professeur(int n) // constructeur
	{
		num=n;
		disponible=true;
	}
	public void venir() // méthode qui animera un professeur pour le faire rejoindre l'étudiant qui l'a appelé et le rendra indisponible
	{
		disponible=false;
	}
	public void valider() // méthode qui permettra au professeur de valider les UVs
	{

	}
	public void cafe() // méthode qui animera le professeur pour qu'il aille chercher un café et le rendra indisponible
	{
		disponible=false;
	}
	public void attendreEtudiant() // méthode qui animera un professeur pour le faire attendre dans un coin de la salle et le rendra disponible
	{
		disponible=true;
	}
	public void finalize(){} //destructeur
}

