package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao_view.Conexao;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2680342858987776564L;
	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textCelular;
	public JPasswordField pfSenha2;
	public JPasswordField pfSenha2_2;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
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
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar2 = new JButton("Cadastrar");
		btnCadastrar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textNome.getText().isEmpty() || textEmail.getText().isEmpty() || textCelular.getText().isEmpty() ||
						new String(pfSenha2.getPassword()).isEmpty()){
							JOptionPane.showMessageDialog(null,"Todos os campos devem ser preenchidos","ERRO",JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								Connection conn = Conexao.faz_conexao();
								String insertSQL = "INSERT INTO usuarios (nome, email, celular, senha) value (?,?,?,?)";
								PreparedStatement stmt = conn.prepareStatement(insertSQL);
								stmt.setString(1, textNome.getText());
								stmt.setString(2, textEmail.getText());
								stmt.setString(3, textCelular.getText());
								stmt.setString(4, new String (pfSenha2.getPassword()));
								
								
								if(new String(pfSenha2.getPassword()).equals(new String(pfSenha2_2.getPassword()))){								
									stmt.execute();
									JOptionPane.showMessageDialog(null, "Você foi cadastrado");
									setVisible(false);
									
																		
								}else{
									JOptionPane.showMessageDialog(null, "Senhas não conferem!","",JOptionPane.ERROR_MESSAGE);	
									pfSenha2.setText("");
									pfSenha2_2.setText("");
								}		
								stmt.close();
								conn.close();
								
							} catch (SQLException e2) {
								JOptionPane.showMessageDialog(null, "Ocorreu um erro no cadastro");
								e2.getNextException();
							}
						}
				
			}
		});
		btnCadastrar2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrar2.setBounds(313, 514, 154, 32);
		contentPane.add(btnCadastrar2);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(229, 69, 145, 26);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(229, 149, 45, 26);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(239, 186, 300, 32);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCelular.setBounds(229, 227, 67, 14);
		contentPane.add(lblCelular);
		
		textCelular = new JTextField();
		textCelular.setBounds(239, 252, 171, 32);
		contentPane.add(textCelular);
		textCelular.setColumns(10);
		
		JLabel lblSenha2 = new JLabel("Senha");
		lblSenha2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha2.setBounds(229, 295, 56, 14);
		contentPane.add(lblSenha2);
		
		pfSenha2 = new JPasswordField();
		pfSenha2.setBounds(239, 320, 300, 32);
		contentPane.add(pfSenha2);
		
		JLabel lblconfirmacaoSenha = new JLabel("Confirmar Senha");
		lblconfirmacaoSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblconfirmacaoSenha.setBounds(227, 360, 171, 26);
		contentPane.add(lblconfirmacaoSenha);
		
		pfSenha2_2 = new JPasswordField();
		pfSenha2_2.setBounds(239, 397, 300, 32);
		contentPane.add(pfSenha2_2);
		
		textNome = new JTextField();
		textNome.setBounds(239, 106, 300, 32);
		contentPane.add(textNome);
		textNome.setColumns(10);
	}
}