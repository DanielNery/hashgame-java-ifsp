package display;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import players.Players;


@SuppressWarnings("serial")
public class playersLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textPassword1;
	private JTextField textUser1;
	private JButton btnJogar;
	private JLabel lblPlayer2;
	private JTextField textPassword2;
	private JTextField textUser2;
	private JLabel lblSenha2;
	

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
	
	public playersLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayer1 = new JLabel("Player1");
		lblPlayer1.setBounds(24, 66, 70, 15);
		contentPane.add(lblPlayer1);
		
		JLabel lblSenha1 = new JLabel("Senha");
		lblSenha1.setBounds(24, 113, 70, 15);
		contentPane.add(lblSenha1);
		
		textPassword1 = new JTextField();
		textPassword1.setBounds(24, 130, 170, 15);
		contentPane.add(textPassword1);
		textPassword1.setColumns(10);
		
		textUser1 = new JTextField();
		textUser1.setColumns(10);
		textUser1.setBounds(24, 87, 170, 15);
		contentPane.add(textUser1);
		
		btnJogar = new JButton("JOGAR");
		btnJogar.setBounds(145, 226, 117, 25);
		contentPane.add(btnJogar);
		
		lblPlayer2 = new JLabel("Player2");
		lblPlayer2.setBounds(224, 66, 70, 15);
		contentPane.add(lblPlayer2);
		
		textPassword2 = new JTextField();
		textPassword2.setColumns(10);
		textPassword2.setBounds(226, 128, 170, 15);
		contentPane.add(textPassword2);
		
		textUser2 = new JTextField();
		textUser2.setColumns(10);
		textUser2.setBounds(224, 85, 170, 15);
		contentPane.add(textUser2);
		
		lblSenha2 = new JLabel("Senha");
		lblSenha2.setBounds(224, 113, 70, 15);
		contentPane.add(lblSenha2);
		btnJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Players player = new Players();
				String player1 = textUser1.getText();
				String player2 = textUser2.getText();
				String password1 = textPassword1.getText();
				String password2 = textPassword1.getText();
				
				System.out.println(player1);
				System.out.println(player2);
				if (player1 == player2) {
					JOptionPane.showMessageDialog(null, "Você não pode jogar contra você mesmo!");
					System.exit(0);
				}
				
				
				try {
					boolean login_ok;
					login_ok = player.Login(player1, player2, password1, password2);
					if (login_ok) {
						gameMatche gamematche = new gameMatche(player1, player2);
						gamematche.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Login ou senha incorretos.");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
						
				
			}
		});
	}

}	

