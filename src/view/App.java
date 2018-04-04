package view;

import java.sql.Connection;
import java.sql.SQLException;

import model.Livro;
import persistence.LivrosJdbcDao;

public class App {
	private Livro livro;
	
	public void Testar() throws ClassNotFoundException, SQLException {
		livro.setNome("Burrice");
		livro.setEditora("None");
		livro.setAutor("Wexley");
		Connection conn = persistence.JdbcDao.getConnection();
		LivrosJdbcDao livroJdbcDao = new LivrosJdbcDao();
	}
	public static void main(String args[]) {
		
	}
}
