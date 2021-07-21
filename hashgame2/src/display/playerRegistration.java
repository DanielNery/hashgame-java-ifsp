package display;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import players.Players;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class playerRegistration extends JFrame {
	
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPassword;
	private JButton btnRegistrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playerRegistration frame = new playerRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public playerRegistration() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(172, 80, 70, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(172, 180, 70, 15);
		contentPane.add(lblSenha);
		
		textUser = new JTextField();
		textUser.setBounds(110, 200, 170, 15);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(110, 100, 170, 15);
		contentPane.add(textPassword);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(145, 226, 117, 25);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Players player = new Players();
				player.setUsername(textUser.getText());
				player.setPassword(textPassword.getText());
				try {
		            player.Register();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
						
			}
		});
	}
		

}
