package classesconexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaTeste extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7895341866511139351L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTeste frame = new TelaTeste();
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
	public TelaTeste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(21, 48, 82, 32);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(21, 150, 82, 32);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(88, 48, 135, 32);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bom dia garoto");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "SELECT * FROM projeto_pi.usuarios";
					
					System.out.println("Cogumelos");
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, txtUsuario.getText());
					stmt.setString(2, new String(pfSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						
						System.out.println("FINALMENTE");
						
						JOptionPane.showMessageDialog(null, "Esse usuario existe!");
					} else {
						JOptionPane.showMessageDialog(null, "Esse usuario não existe!");
					}
					
					stmt.close();
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(284, 181, 113, 48);
		contentPane.add(btnLogin);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(88, 152, 135, 32);
		contentPane.add(pfSenha);
	}

}
