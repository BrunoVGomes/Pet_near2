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
import javax.swing.JButton;
import java.awt.Color;

public class PrimeiraTela {

	private JFrame frame;
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
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PrimeiraTela() {
		initialize();
		
	}


	//AQUI TEM OS NOMES DAS VARIAVEIS DA TELA, TEM O LABEL, O BOTÃO ETC
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 887, 659);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Email ou Celular");
		lblUsuario.setBounds(316, 231, 200, 14);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(316, 256, 200, 28);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(316, 354, 200, 28);
		frame.getContentPane().add(campoSenha);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(316, 329, 54, 14);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblSenha);
		
		JToggleButton botaoEntrar = new JToggleButton("Entrar");
		botaoEntrar.setBounds(342, 418, 150, 25);
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = Conexao.faz_conexao();
					String sql = "select * from projeto_pi.usuarios where (email = ? and senha = ?)";
					
					PreparedStatement stmt = conn.prepareStatement(sql);
					
					stmt.setString(1, txtUsuario.getText());
					stmt.setString(2, new String(campoSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
						
						JOptionPane.showMessageDialog(null, "Esse usuario existe!");
					} else {
						JOptionPane.showMessageDialog(null, "Usuario / Senha incorretas!","Erro 404",JOptionPane.ERROR_MESSAGE);
					}
					
					stmt.close();
					conn.close();
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}				
		});
		botaoEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(botaoEntrar);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(422, 481, 112, 23);
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// A FUNÇÃO DO BOTÃO É CHAMAR UMA TELA E DEIXAR ELA VISIVEL;
				TelaCadastro cadastrotela = new TelaCadastro();
				cadastrotela.setVisible(true);
				
			}
		});
		botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(botaoCadastrar);
		
		JLabel lblNewLabel = new JLabel("Voce ainda não tem uma conta?");
		lblNewLabel.setBounds(229, 487, 183, 14);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().add(lblNewLabel);
	
	}
}
