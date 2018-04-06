package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Livro;

public class LivrosJdbcDao {
	private Connection conn;

	public LivrosJdbcDao(Connection conn) {
		this.conn = conn;
	}

	public void Salvar(Livro l) throws SQLException {
		String sql = "insert into livros (nome, autor, editora) values ('" + l.getNome() + "','" + l.getAutor() + "','"
				+ l.getEditora() + "')";
		System.out.println(sql);
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}

	public void Alterar(Livro l) throws SQLException {
		String sql = "update from livros set where pk_idLivro = " + l.getId();
		System.out.println(sql);
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}

	public void Deletar(Livro l) throws SQLException {
		String sql = "delete from livros where pk_idLivro = " + l.getId();
		System.out.println(sql);
		PreparedStatement comando = this.conn.prepareStatement(sql);
		comando.executeUpdate();
		comando.close();
	}

	public List<Livro> Listar() throws SQLException {
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "select * from livros";
		System.out.println(sql);
		PreparedStatement comando = this.conn.prepareStatement(sql);
		ResultSet data = comando.executeQuery();
		while (data.next()) {
			Livro livro = new Livro();
			livro.setId(data.getInt("pk_idLivro"));
			livro.setAutor(data.getString("autor"));
			livro.setEditora(data.getString("editora"));
			livro.setNome(data.getString("nome"));
			livros.add(livro);
			
			
			System.out.println("#"+livro.getId()+": "+livro.getNome()+" / "+livro.getAutor()+" / "+livro.getEditora());
		}
		comando.close();
		return livros;		
	}
}
