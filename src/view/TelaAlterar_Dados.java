package view;


import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conexao_view.Conexao;

public class TelaAlterar_Dados extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textCelular;
	private JPasswordField pfSenha;
	private JButton btnPerfil;
	private JButton btnDeletar;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterar_Dados window = new TelaAlterar_Dados();
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
	public TelaAlterar_Dados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 828, 626);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNome.getText().isEmpty() || textEmail.getText().isEmpty() || textCelular.getText().isEmpty() ||
						new String(pfSenha.getPassword()).isEmpty()){
					JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos","ERRO",JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null,"Caso queira mudar apenas uma coluna, repita as outras","ERRO",JOptionPane.INFORMATION_MESSAGE);

				}else {
					try {
						Connection conn = Conexao.faz_conexao();
						String updateSQL = "UPDATE usuarios SET nome = ?, email = ?, celular = ?, senha = ?"
								+ " WHERE id = id";
						
						PreparedStatement stmt = conn.prepareStatement(updateSQL);
						
						stmt.setString(1, textNome.getText());
						stmt.setString(2, textEmail.getText());
						stmt.setString(3, textCelular.getText());
						stmt.setString(4, new String (pfSenha.getPassword()));
						
						stmt.executeUpdate();
						stmt.close();
						conn.close();
						JOptionPane.showMessageDialog(null, "Campos alterados com sucesso");
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setBounds(413, 478, 114, 35);
		getContentPane().add(btnAlterar);
		
		textNome = new JTextField();
		textNome.setBounds(321, 105, 381, 35);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(321, 176, 381, 35);
		getContentPane().add(textEmail);
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(321, 248, 381, 35);
		getContentPane().add(textCelular);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(321, 319, 381, 35);
		getContentPane().add(pfSenha);
		
		btnPerfil = new JButton("");
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBounds(0, 208, 89, 23);
		getContentPane().add(btnPerfil);
		
		btnDeletar = new JButton("");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvisoDelete avisodelete = new AvisoDelete();
				avisodelete.setVisible(true);
			}
		});
		btnDeletar.setContentAreaFilled(false);
		btnDeletar.setBorderPainted(false);
		btnDeletar.setBounds(0, 308, 89, 23);
		getContentPane().add(btnDeletar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAlterar_Dados.class.getResource("/imagens/4b187e8e-188d-4193-8436-6b1c1534c863.png")));
		lblNewLabel.setBounds(0, 0, 812, 587);
		getContentPane().add(lblNewLabel);
	}
}