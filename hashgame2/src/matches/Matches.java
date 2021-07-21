package matches;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import players.Players;

public class Matches {
	private String Player1;
	private String Player2;
	
	/* Insere na tabela de partidas registrando as partidas dos jogadores */
	public void InsertMatche() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/hashgame";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
                
        String Sql = "insert into Matches (player1_id, player2_id) values(" + getPlayer1() + "," + getPlayer2() + ")";
        System.out.println(Sql);
        PreparedStatement command = (PreparedStatement) conn.prepareStatement(Sql);
        command.execute();
        command.close();
        JOptionPane.showMessageDialog(null,"Partida gravada!");
    }
	
	
	// carrega atributos da classe
	public void setPlayers(String player1, String player2) {
		this.Player1 = player1;
		this.Player2 = player2;
	}
	
	// função auxiliar para buscar jogador 1
	public int getPlayer1(){
		Players player1 = new Players();
		ArrayList<Integer> player1_ids = new ArrayList<>();
		try {
			player1_ids = player1.Search(this.Player1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return player1_ids.get(0);
	}
	
	// função auxiliar para buscar o jogador 2
	public int getPlayer2() {
		Players player2 = new Players();
		ArrayList<Integer> player2_ids = new ArrayList<>();
		try {
			player2_ids = player2.Search(this.Player2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return player2_ids.get(0);
	}
	
	
}
