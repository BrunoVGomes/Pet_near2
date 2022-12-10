package view;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao_view.Conexao;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
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
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelaCadastro() {
		initialize();
		setLocationRelativeTo(null);
		
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar2 = new JButton("");
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
		btnCadastrar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrar2.setContentAreaFilled(false);
		btnCadastrar2.setBorderPainted(false);
		btnCadastrar2.setBounds(624, 522, 157, 53);
		getContentPane().add(btnCadastrar2);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(517, 260, 300, 29);
		contentPane.add(textEmail);
		
		textCelular = new JTextField();
		textCelular.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textCelular.setColumns(10);
		textCelular.setBounds(517, 325, 300, 29);
		contentPane.add(textCelular);
		
		pfSenha2 = new JPasswordField();
		pfSenha2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		pfSenha2.setBounds(517, 381, 300, 29);
		getContentPane().add(pfSenha2);
		
		pfSenha2_2 = new JPasswordField();
		pfSenha2_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		pfSenha2_2.setBounds(517, 449, 300, 29);
		getContentPane().add(pfSenha2_2);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textNome.setBounds(517, 203, 300, 29);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1368, 749);
		lblNewLabel.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imagens/Cadastro.png")));
		getContentPane().add(lblNewLabel);
	}
}