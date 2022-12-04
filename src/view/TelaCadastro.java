package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2680342858987776564L;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

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
				setVisible(false);
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(239, 186, 300, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCelular.setBounds(229, 227, 67, 14);
		contentPane.add(lblCelular);
		
		textField = new JTextField();
		textField.setBounds(239, 252, 171, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha2 = new JLabel("Senha");
		lblSenha2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha2.setBounds(229, 295, 56, 14);
		contentPane.add(lblSenha2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(239, 320, 300, 32);
		contentPane.add(passwordField);
		
		JLabel lblconfirmacaoSenha = new JLabel("Confirmar Senha");
		lblconfirmacaoSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblconfirmacaoSenha.setBounds(227, 360, 171, 26);
		contentPane.add(lblconfirmacaoSenha);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(239, 397, 300, 32);
		contentPane.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(239, 106, 300, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}