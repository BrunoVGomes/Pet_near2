package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import conexao_view.Conexao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

public class PrimeiraTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField campoSenha;


	public static void main(String[] args) {
//ESSE AQUI É PRA DEIXAR A TELA MAIS "BONITA" E NÃO TODA QUADRADA		
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
					PrimeiraTela window = new PrimeiraTela();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PrimeiraTela() {
		initialize();
		setLocationRelativeTo(null);
		
	}


	//AQUI TEM OS NOMES DAS VARIAVEIS DA TELA, TEM O LABEL, O BOTÃO ETC
	private void initialize() {
		setBounds(100, 100, 1382, 798);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtUsuario.setBounds(505, 204, 314, 38);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(505, 286, 314, 38);
		getContentPane().add(campoSenha);
		
		JToggleButton botaoEntrar = new JToggleButton("");
		botaoEntrar.setBorderPainted(false);
		botaoEntrar.setBounds(590, 432, 136, 48);
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = Conexao.faz_conexao();
					String selectSQL = "select * from projeto_pi.usuarios where(email = ? and senha = ?) or"
							+ "(celular = ? and senha = ?)";
					PreparedStatement stmt = conn.prepareStatement(selectSQL);
					stmt.setString(1, txtUsuario.getText());
					stmt.setString(2, new String(campoSenha.getPassword()));
					stmt.setString(3, txtUsuario.getText());
					stmt.setString(4, new String(campoSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
						TelaMenu telamenu = new TelaMenu();
						telamenu.setVisible(true);
						setVisible(false);
						stmt.close();
						conn.close();
					} else {
						JOptionPane.showMessageDialog(null, "Usuario / Senha incorretas!","Erro",JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e2) {
					System.out.println("Kaka");
					e2.printStackTrace();
				}
			}				
		});
		botaoEntrar.setContentAreaFilled(false);
		botaoEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(botaoEntrar);
		
		JButton botaoCadastrar = new JButton("");
		botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoCadastrar.setContentAreaFilled(false);
		botaoCadastrar.setBorderPainted(false);
		botaoCadastrar.setBounds(571, 508, 174, 63);
		getContentPane().add(botaoCadastrar);
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastro cadastrotela = new TelaCadastro();
				cadastrotela.setVisible(true);
			}
		});
		botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(botaoCadastrar);
		botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1390, 747);
		lblNewLabel.setIcon(new ImageIcon(PrimeiraTela.class.getResource("/imagens/Logintela.png")));
		getContentPane().add(lblNewLabel);
	
	}
}