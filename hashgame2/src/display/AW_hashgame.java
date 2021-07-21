package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class AW_hashgame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AW_hashgame window = new AW_hashgame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AW_hashgame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jogo da Velha");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(150, 65, 389, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnJogar = new JButton("JOGAR");
		btnJogar.setBounds(150, 135, 117, 25);
		frame.getContentPane().add(btnJogar);
		btnJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				playersLogin pl = new playersLogin();
				pl.setVisible(true);
				
			}
		});
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(150, 168, 117, 25);
		frame.getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				playerRegistration pr = new playerRegistration();
				
				pr.setVisible(true);
				
			}
		});
		
		JButton btnRanking = new JButton("RANKING");
		btnRanking.setBounds(150, 200, 117, 25);
		frame.getContentPane().add(btnRanking);
		btnRanking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				RankingList rl = new RankingList();
				rl.setVisible(true);
				
			}
		});
		
	}
}
