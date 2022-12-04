package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
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
				//EU FIZ O BOTÃO TER UMA AÇÃO, ASSIM QUE ELE É CLICADO COM O USUARIO CERTO, ELE APARECE A MSG BEM VINDO
				if (checkLogin(txtUsuario.getText(), new String (campoSenha.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem vindo ao sistema garotinho");
				} else {
					//SENÃO VAI DIZER QUE O DADO É INVALIDADO
					JOptionPane.showMessageDialog(null, "Dados Invalidados!","Erro",JOptionPane.ERROR_MESSAGE);
					
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
				setVisible(false);
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
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
	//ISSO É UM EXEMPLO DE UMA "CONTA", POR ENQUANTO NÃO TEM NADA LIGADO AO BANCO DE DADOS
	public boolean checkLogin(String login, String senha) {
		return login.equals("usuario") && senha.equals("12345");
	//O USUARIO É USUARIO E A SENHA É 12345
	}
}