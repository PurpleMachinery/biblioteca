package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import model.Livro;
import persistence.LivrosJdbcDao;

public class App {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Livro livro = new Livro();
		livro.setId(1);
		livro.setNome("Burrice");
		livro.setEditora("None");
		livro.setAutor("Wexley");
		Connection conn = persistence.JdbcUtil.getConnection();
		LivrosJdbcDao livroJdbcDao = new LivrosJdbcDao(conn);
		livroJdbcDao.Listar();
	}
}
