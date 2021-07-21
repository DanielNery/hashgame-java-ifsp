package display;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import players.Players;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RankingList extends JFrame {
	
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingList frame = new RankingList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RankingList() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ranking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(165, 65, 180, 100);
		contentPane.add(lblNewLabel);
		
		JButton btnGerar = new JButton("Gerar Ranking");
		btnGerar.setBounds(130, 150, 150, 50);
		contentPane.add(btnGerar);
		btnGerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Players players = new Players();
				String RankingList = "";
				try {
					RankingList = players.SearchRanking();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, RankingList);				
			}
		});
	
		}

}
