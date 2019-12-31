package javaproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class NiveauMoyen {

	private JFrame frame;
	private Niveau niv;
	private Professeur prof[];
	private Console cons[];
	private Etudiant etu[];
	private JButton btnConsole[];
	private JButton btnProfesseur[];
	private JButton btnEtudiant[];
	private JButton btnC[];
	private Thread t[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NiveauMoyen window = new NiveauMoyen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public NiveauMoyen() {
		frame = new JFrame();
		niv = new Niveau(2);
		prof=new Professeur[niv.getNbrP()];
		cons=new Console[niv.getNbrC()];
		btnC=new JButton[niv.getNbrC()];
		etu=new Etudiant[niv.getNbrE()];
		t=new TimerEtu[niv.getNbrE()];
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 733, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//Affichage du chronomètre
		GridBagConstraints gbc_btnJl2 = new GridBagConstraints();
    	gbc_btnJl2.gridx = 7;
    	gbc_btnJl2.gridy = 1;
    	GridBagConstraints gbc_btnJl3 = new GridBagConstraints();
    	gbc_btnJl3.gridx = 8;
    	gbc_btnJl3.gridy = 1;
		Counter c = new Counter(60*niv.getTemps());
		frame.getContentPane().add(c.getJl2(), gbc_btnJl2);
		frame.getContentPane().add(c.getJl3(), gbc_btnJl3);
		c.start();
		
		//Affichage du score
		GridBagConstraints gbc_btnScore = new GridBagConstraints();
		gbc_btnScore.gridx = 1;
		gbc_btnScore.gridy = 1;
	    frame.getContentPane().add(niv.getText(),gbc_btnScore);
				
	}
	
}
