package javaproject;
import java.lang.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class FenetreMoyen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final Action action = new SwingAction();

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

     		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreMoyen frame = new FenetreMoyen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public FenetreMoyen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblScore = new JLabel("Score");
		contentPane.add(lblScore, "cell 1 0");
		
		JLabel lblChrono = new JLabel("Time");
		contentPane.add(lblChrono, "cell 12 0");
		
		JLabel lblNiveauMoyen = new JLabel("Niveau Moyen");
		contentPane.add(lblNiveauMoyen, "cell 6 1");
		
		JButton btnEtudiant = new JButton("Etudiant1");
		contentPane.add(btnEtudiant, "cell 1 6");
		
		JButton btnEtudiant_1 = new JButton("Etudiant2");
		contentPane.add(btnEtudiant_1, "cell 1 10");
		
		JButton btnConsole = new JButton("Console1");
		contentPane.add(btnConsole, "cell 11 10");
		
		JButton btnEtudiant_2 = new JButton("Etudiant3");
		contentPane.add(btnEtudiant_2, "cell 1 13");
		
		JButton btnProffesseur_1 = new JButton("Proffesseur1");
		contentPane.add(btnProffesseur_1, "cell 5 13");
		
		JButton btnEtudiant_3 = new JButton("Etudiant4");
		contentPane.add(btnEtudiant_3, "cell 1 15");
		
		JButton btnProffesseur = new JButton("Proffesseur2");
		contentPane.add(btnProffesseur, "cell 5 15");
		
		JButton btnEtudiant_4 = new JButton("Etudiant5");
		contentPane.add(btnEtudiant_4, "cell 1 18");
		
		JButton btnConsole_1 = new JButton("Console2");
		contentPane.add(btnConsole_1, "cell 11 18");
		
		JButton btnEtuidiant = new JButton("Etuidiant6");
		contentPane.add(btnEtuidiant, "cell 1 21");
		
		
		Counter c = new Counter(180);
		contentPane.add(c.getJl2(), "cell 12 1");
		contentPane.add(c.getJl3(), "cell 13 1");
		c.start();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String composant = e.getActionCommand();
		if(composant=="Etudiant1") {
			
			}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	



		
}
