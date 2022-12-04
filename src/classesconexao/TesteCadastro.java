package classesconexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TesteCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JPasswordField pfSenha2;
	private JTextField textEmail;
	private JTextField textCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteCadastro frame = new TesteCadastro();
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
	public TesteCadastro() {
		setTitle("CADASTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(76, 53, 142, 35);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		pfSenha2 = new JPasswordField();
		pfSenha2.setBounds(75, 99, 143, 35);
		contentPane.add(pfSenha2);
		
		textEmail = new JTextField();
		textEmail.setBounds(76, 145, 142, 35);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textCelular = new JTextField();
		textCelular.setBounds(76, 191, 142, 35);
		contentPane.add(textCelular);
		textCelular.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setBounds(10, 63, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SENHA");
		lblNewLabel_1.setBounds(10, 109, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL");
		lblNewLabel_2.setBounds(10, 155, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CELULAR");
		lblNewLabel_3.setBounds(10, 201, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton bntCadastrar = new JButton("CADASTRAR");
		bntCadastrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = new Conexao.faz_conexao();
					String sql = "insert into usuarios (nome, senha, email, celular) values (?,?,?,?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1,textNome.getText());
					stmt.setString(2, pfSenha2.getText());
					
					
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();		
				}
			}
		});
		bntCadastrar.setBounds(259, 125, 150, 44);
		contentPane.add(bntCadastrar);
	}
}
