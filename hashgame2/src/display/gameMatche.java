package display;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import matches.Matches;
import players.Players;

@SuppressWarnings("serial")
public class gameMatche extends JFrame {
	
	private String player1 = "X";
	private String player2 = "O";
	
	private JPanel contentPane;

	/* Inicia aplicação */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameMatche frame = new gameMatche();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JButton[] bt = new JButton[9];
	JLabel scoreboard = new JLabel("Placar");
	JLabel label_score_x = new JLabel("X -> " + player1 + " = 0");
	JLabel label_score_o = new JLabel("O -> " + player2 + " = 0");
	JButton new_game = new JButton("Novo Jogo");
	JButton restart = new JButton("Reiniciar Placar");
	int score_x = 0;
	int score_o = 0;
	
	boolean xo = false;
	boolean[] click = new boolean[9];
	
	
	/* Frame da aplicação */
	public gameMatche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 700, 500);
		
		setTitle("Jogo da Velha");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
	}
	
	/* Construtor alternativo */
	public gameMatche(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
		
		label_score_x.setText("X -> " + player1 + " = " + score_x);
		label_score_o.setText("O -> " + player2 + " = " + score_o);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 700, 500);
		
		setTitle("Jogo da Velha");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		add(scoreboard);
		add(label_score_x);
		add(label_score_o);
		
		add(new_game);
		add(restart);
		
		scoreboard.setBounds(400,50,100,30);
		label_score_x.setBounds(400,75,100,30);
		label_score_o.setBounds(550,75,100,30);
		
		new_game.setBounds(410,230,140,30);
		restart.setBounds(410,280,180,30);
		
		
		/* Botão para começar nova partida */
		new_game.addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				Matches matche = new Matches();
				// Grava partida
				matche.setPlayers(player1, player2);
				try {
					matche.InsertMatche();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				setScore();
				
				// Limpa botões
				clear();
			}
		});
		
		/* Botão para resetar placar */
		restart.addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				score_x = 0;
				score_o = 0;
				update_scoreboard();
			}
		});
		
		
		int cont = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				bt[cont] = new JButton();
				add(bt[cont]);
				bt[cont].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);
				bt[cont].setFont(new Font("Arial",Font.BOLD,40));
				cont++;
			}
		}
		
		for (int i = 0; i < 9; i++) {
			click[i] = false;
		}
		
		/* Botão com 'X' ou 'O' */
		bt[0].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[0] == false) {
					click[0] = true;
					change(bt[0]);
				}
			}
		});
		
		/* Botão com 'X' ou 'O' */
		bt[1].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[1] == false) {
					click[1] = true;
					change(bt[1]);
				}
			}
		});
		
		/* Botão com 'X' ou 'O' */
		bt[2].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[2] == false) {
					click[2] = true;
					change(bt[2]);
				}
			}
		});
		
		/* Botão com 'X' ou 'O' */
		bt[3].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[3] == false) {
					click[3] = true;
					change(bt[3]);
				}
			}
		});
		
		/* Botão com 'X' ou 'O' */
		bt[4].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[4] == false) {
					click[4] = true;
					change(bt[4]);
				}
			}
		});
		
		/* Botão com 'X' ou 'O' */
		bt[5].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[5] == false) {
					click[5] = true;
					change(bt[5]);
				}
			}
		});
		
		/* Botão com 'X' ou 'O' */
		bt[6].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[6] == false) {
					click[6] = true;
					change(bt[6]);
				}
			}
		});
		
		/* Botão com 'X' ou 'O' */
		bt[7].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[7] == false) {
					click[7] = true;
					change(bt[7]);
				}
			}
		});
		
		/* Botão com 'X' ou 'O' */
		bt[8].addActionListener(new java.awt.event.ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(click[8] == false) {
					click[8] = true;
					change(bt[8]);
				}
			}
		});
		
	}
	
	/* Seta 'X' ou 'O' */
	public void change(JButton btn) {
		if(xo) {
			btn.setText("O");
			xo = false;
		} else {
			btn.setText("X");
			xo = true;
		}
		winner();
	}

	public void setScore() {
		// Grava Pontuação
		Players players = new Players();
		try {
			players.SetScore(player1, this.score_x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			players.SetScore(player2, this.score_o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Atualiza Pontuação */
	public void update_scoreboard() {
		label_score_x.setText("X -> " + player1 + " = " + score_x);
		label_score_o.setText("O -> " + player2 + " = " + score_o);
	}
	
	/* Método para verificar se há vencedor ou empate */
	public void winner() {
		
		/* Se já foram preenchidas todas as posições e não há vencedor, é empate. */
		int cont = 0;
		for (int i = 0; i < 9; i++) {
			if(click[i] == true) {
				cont++;
			}
			
		}
		
		/* Condições de vitória */
		if((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X") 
				|| (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X") 
				|| (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X") 
				|| (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X") 
				|| (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X") 
				|| (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X") 
				|| (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X") 
				|| (bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
			
			JOptionPane.showMessageDialog(null, "X é o vencedor!");
			score_x++;
			update_scoreboard();
			clear();
			
		}else if((bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O") 
				|| (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O") 
				|| (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O") 
				|| (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O") 
				|| (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O") 
				|| (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O") 
				|| (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O") 
				|| (bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
			
			JOptionPane.showMessageDialog(null, "O é o vencedor!");
			score_o++;
			update_scoreboard();
			clear();
			
		} else if (cont == 9){
			JOptionPane.showMessageDialog(null, "Deu velha, empate!!");
			clear();
		}
	}
	
	/* Limpa os botões e inicia nova rodada */
	public void clear() {
		for (int i = 0; i < 9; i++) {
			bt[i].setText("");
			click[i] = false;
			xo = false;
		}
	}
		
}