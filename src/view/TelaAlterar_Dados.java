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


	public static void main (String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
        	System.err.println(ex);
        } catch (IllegalAccessException ex) {
        	System.err.println(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
		
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
		setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 1382, 833);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		
		JButton btnAlterar = new JButton("");
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNome.getText().isEmpty() || textEmail.getText().isEmpty() || textCelular.getText().isEmpty() ||
						new String(pfSenha.getPassword()).isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos","*AVISO*",JOptionPane.ERROR_MESSAGE);
					JOptionPane.showMessageDialog(null, "Caso queira mudar apenas um campo repita os outros","*AVISO*",JOptionPane.DEFAULT_OPTION);

				}else {
					try {
						Connection conn = Conexao.faz_conexao();
						String updateSQL = "UPDATE usuarios SET nome = ?, email = ?, celular = ?, senha = ?";
						
						PreparedStatement stmt = conn.prepareStatement(updateSQL);
						
						
						stmt.setString(1, textNome.getText());
						stmt.setString(2, textEmail.getText());
						stmt.setString(3, textCelular.getText());
						stmt.setString(4, new String (pfSenha.getPassword()));
						
						
						stmt.executeUpdate();
						stmt.close();
						conn.close();
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Campos alterados com sucesso");
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setBounds(641, 581, 157, 65);
		getContentPane().add(btnAlterar);
		
		textNome = new JTextField();
		textNome.setBounds(435, 193, 532, 35);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(435, 282, 532, 35);
		getContentPane().add(textEmail);
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(435, 364, 532, 35);
		getContentPane().add(textCelular);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(435, 455, 532, 35);
		getContentPane().add(pfSenha);
		
		btnPerfil = new JButton("");
		btnPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnPerfil.setBorderPainted(false);
		btnPerfil.setBounds(36, 220, 121, 44);
		getContentPane().add(btnPerfil);
		
		btnDeletar = new JButton("");
		btnDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Confirmar", "Cancelar" };
				int opcao = JOptionPane.showOptionDialog(null, "Você tem certeza ?", "Informação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);				
				
				if(opcao == 0) {
					try {
						Connection conn = Conexao.faz_conexao();
						String deleteSQL = "DELETE * From usuarios";
						PreparedStatement stmt = conn.prepareStatement(deleteSQL);
						
						PrimeiraTela primeiratela = new PrimeiraTela();
						primeiratela.setVisible(true);
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Sua conta foi exluida com sucesso!","",JOptionPane.YES_OPTION);
						stmt.execute();
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnDeletar.setContentAreaFilled(false);
		btnDeletar.setBorderPainted(false);
		btnDeletar.setBounds(36, 403, 121, 44);
		getContentPane().add(btnDeletar);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela primeiratela = new PrimeiraTela();
				primeiratela.setVisible(true);
				setVisible(false); 
			}
		});
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBounds(36, 658, 52, 50);
		getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAlterar_Dados.class.getResource("/imagens/Alterar_Dados.png")));
		lblNewLabel.setBounds(0, 0, 1366, 749);
		getContentPane().add(lblNewLabel);
	}
}