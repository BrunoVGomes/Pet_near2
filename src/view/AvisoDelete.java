package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao_view.Conexao;

public class AvisoDelete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
					AvisoDelete frame = new AvisoDelete();
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
	public AvisoDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSim = new JButton("SIM");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = Conexao.faz_conexao();
					String deleteSQL = "DELETE FROM usuarios WHERE id = ?";
					PreparedStatement stmt = conn.prepareStatement(deleteSQL);
					
					PrimeiraTela primeiratela = new PrimeiraTela();
					primeiratela.setVisible(true);
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Sua conta foi exluida com sucesso!","",JOptionPane.CANCEL_OPTION);
					stmt.execute();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSim.setBounds(27, 89, 89, 23);
		contentPane.add(btnSim);
		
		JButton btnNaum = new JButton("NÃO");
		btnNaum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNaum.setBounds(152, 89, 89, 23);
		contentPane.add(btnNaum);
		
		JLabel lblNewLabel = new JLabel("VOCÊ TEM CERTEZA QUE DESEJA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(42, 11, 186, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("APAGAR ESSA CONTA?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(67, 39, 135, 27);
		contentPane.add(lblNewLabel_1);
	}
}
