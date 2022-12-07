package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu window = new TelaMenu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 828, 626);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnAlterar_Dados = new JButton("");
		btnAlterar_Dados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlterar_Dados AlterarDadosTela = new TelaAlterar_Dados();
				AlterarDadosTela.setVisible(true);
			}
		});
		btnAlterar_Dados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar_Dados.setContentAreaFilled(false);
		btnAlterar_Dados.setBorderPainted(false);
		btnAlterar_Dados.setBounds(20, 240, 109, 39);
		getContentPane().add(btnAlterar_Dados);
		
		JButton btnDeletar = new JButton("");
		btnDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvisoDelete avisodelete = new AvisoDelete();
				avisodelete.setVisible(true);
			}
		});
		btnDeletar.setBorderPainted(false);
		btnDeletar.setContentAreaFilled(false);
		btnDeletar.setBounds(20, 319, 103, 33);
		getContentPane().add(btnDeletar);
		
		JButton btnVoltarTela = new JButton("");
		btnVoltarTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
			}
		});
		btnVoltarTela.setBorderPainted(false);
		btnVoltarTela.setContentAreaFilled(false);
		btnVoltarTela.setBounds(10, 444, 33, 39);
		getContentPane().add(btnVoltarTela);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaMenu.class.getResource("/imagens/1cb579e6-2aa3-4198-adee-39989eaab118.jpg")));
		lblNewLabel.setBounds(0, 0, 812, 587);
		getContentPane().add(lblNewLabel);
	}
}