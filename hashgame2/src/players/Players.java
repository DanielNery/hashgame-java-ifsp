package players;

import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Players {
	private String Username;
	private String Password;
	
	// Registra novos jogadores
	public void Register() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/hashgame";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        String Sql = "insert into Players (name, password) values('" + getName() + "','" + getPassword() + "')";
        System.out.println(Sql);
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        comando.execute();
        comando.close();
        JOptionPane.showMessageDialog(null,"Usuário cadastrado!");
    }
	
	// Faz o login e começa partida
	public boolean Login(String player1, String player2, String password1, String password2) throws SQLException {
		String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/hashgame";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        
        String Sql = "select * from Players where name = '" + player1 + "' and password = '" + password1 + "'";
        PreparedStatement command_player1 = (PreparedStatement) conn.prepareStatement(Sql);
        ResultSet resultset = command_player1.executeQuery();
        
        String Sqlpl2 = "select * from Players where name = '" + player1 + "' and password = '" + password1 + "'";
        PreparedStatement command_player2 = (PreparedStatement) conn.prepareStatement(Sqlpl2);
        ResultSet resultset_player2 = command_player2.executeQuery();
        
        if (resultset.next() && resultset_player2.next()) {
        	return true;
        } else {
        	return false;
        }
        
	}
	
	// Pesquisa jogadores por nome
	public ArrayList<Integer> Search(String name) throws SQLException {
		String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/hashgame";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        
        // busca por players no sistema e retorna uma lista de ids
        String Sql = "select id from Players where name = '" + name + "'";
        System.out.println(Sql);
        PreparedStatement command = (PreparedStatement) conn.prepareStatement(Sql);
        ResultSet resultset = command.executeQuery();
        ArrayList<Integer> records = new ArrayList<>();
        while (resultset.next()) {
        	records.add(resultset.getInt("id"));
        }
        return records;
        
	}
	
	// Pesquisa jogadores por nome
	public String SearchRanking() throws SQLException {
		String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/hashgame";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        
        // busca por players no sistema e retorna uma lista de ids
        String Sql = "select * from Players order by score";
        System.out.println(Sql);
        PreparedStatement command = (PreparedStatement) conn.prepareStatement(Sql);
        ResultSet resultset = command.executeQuery();
        ArrayList<String> records = new ArrayList<>();
        
        while (resultset.next()) {
        	records.add(resultset.getString("name") + " | " + resultset.getInt("score"));
        }
        
        String rankinglist = "";
        int j;
        for(j=0; j<records.size(); j++) {
        	rankinglist = rankinglist + records.get(j) + "\n";
        }
        
        resultset.close();
        command.close();
        conn.close();
        return rankinglist;
        
	}
	
	// Seta a pontuação dos jogadores
	public void SetScore(String name, int score) throws SQLException {
		String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/hashgame";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        String query1 = "select score from Players where name = '" + name + "'" + "limit 1";
        PreparedStatement command = (PreparedStatement) conn.prepareStatement(query1);
        ResultSet resultset = command.executeQuery();
        
        int old_score = 0;
        if (resultset.next()) {
        	old_score = resultset.getInt("score");
        }
        int score_full = old_score + score;
        
        String query2 = "update Players set score = " + score_full + " where name = '" + name + "'";
        System.out.println(query2);
        PreparedStatement command2 = (PreparedStatement) conn.prepareStatement(query2);
        command.execute();
        command.close();
        command2.execute();
        command2.close();
	}
	
	
	public void setUsername(String username) {
		this.Username = username;
	}
	
	public void setPassword(String password) {
		this.Password = password;
	}
	
	public String getName() {
		return Username;
	}
	
	public String getPassword() {
		return Password;
	}
	
}
