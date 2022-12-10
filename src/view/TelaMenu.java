package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import conexao_view.Conexao;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
					TelaMenu window = new TelaMenu();
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
	public TelaMenu() {
		initialize();
		setLocationRelativeTo(null);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 1366, 798);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		
		JButton btnAlterar_Dados = new JButton("");
		btnAlterar_Dados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlterar_Dados AlterarDadosTela = new TelaAlterar_Dados();
				AlterarDadosTela.setVisible(true);
			}
		});
		btnAlterar_Dados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar_Dados.setContentAreaFilled(false);
		btnAlterar_Dados.setBorderPainted(false);
		btnAlterar_Dados.setBounds(20, 310, 141, 47);
		getContentPane().add(btnAlterar_Dados);
		
		JButton btnDeletar = new JButton("");
		btnDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Sim", "Cancelar" };
				int opcao = JOptionPane.showOptionDialog(null, "Quer excluir a sua conta ?", "Informação",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);				
				
				if(opcao == 0) {
					try {
						Connection conn = Conexao.faz_conexao();
						String deleteSQL = "DELETE FROM usuarios";
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
		btnDeletar.setBorderPainted(false);
		btnDeletar.setContentAreaFilled(false);
		btnDeletar.setBounds(20, 400, 141, 47);
		getContentPane().add(btnDeletar);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraTela primeiratela = new PrimeiraTela();
				primeiratela.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setVerifyInputWhenFocusTarget(false);
		btnVoltar.setBounds(33, 658, 52, 47);
		getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaMenu.class.getResource("/imagens/MENU.png")));
		lblNewLabel.setBounds(0, 0, 1368, 745);
		getContentPane().add(lblNewLabel);
	}
}