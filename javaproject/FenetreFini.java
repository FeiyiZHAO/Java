package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class FenetreFini extends JFrame {
	private static int score;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreFini frame = new FenetreFini(score);
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
	public FenetreFini(int s) {
		setTitle("Fini");
		score = s;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 508);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblFini = new JLabel("FINI !");
		lblFini.setHorizontalAlignment(SwingConstants.CENTER);
		lblFini.setFont(new Font("Arial", Font.BOLD, 40));
		GridBagConstraints gbc_lblFini = new GridBagConstraints();
		gbc_lblFini.insets = new Insets(0, 0, 5, 0);
		gbc_lblFini.gridx = 2;
		gbc_lblFini.gridy = 0;
		getContentPane().add(lblFini, gbc_lblFini);
		
		JLabel lblScore = new JLabel("Score ");
		GridBagConstraints gbc_lblScore = new GridBagConstraints();
		gbc_lblScore.insets = new Insets(0, 0, 5, 0);
		gbc_lblScore.gridx = 2;
		gbc_lblScore.gridy = 3;
		getContentPane().add(lblScore, gbc_lblScore);
				
		JButton btnNewButton = new JButton("Retourner");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 7;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	setVisible(false);
		    	Fenetre fen=new Fenetre();
		    }});
		
		//Affichage du score
		String str = String.valueOf(score);
		JLabel ss =new JLabel(str);
		GridBagConstraints gbc_btnScore = new GridBagConstraints();
    	gbc_btnScore.gridx = 2;
    	gbc_btnScore.gridy = 5;
		getContentPane().add(ss,gbc_btnScore);
	}
	


}


