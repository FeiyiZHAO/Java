package javaproject;

import java.util.Timer;
import java.util.TimerTask;

public class JouerMoyen {

	public static void main(String[] args) {
		//Apr¨¨s choisir console et pro
		Timer t = new Timer();
		t.schedule(new Edisparait(), 7000);//Apr¨¨s 7s, Etudiant satisfait
		
		//
	}


}

//TimerTask : classe abstraite
class Edisparait extends TimerTask{
	public void run() {
		//code pour r¨¦aliser la disparition d'¨¦tudiant
		//code pour librer console et pro
		//code pour ajouter le nombre des edutiants satisfait dans console et pro
		//si le nombre = 2
	}
	
}
