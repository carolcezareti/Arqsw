package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Livro;

public class LivroDAO {

public int criar(Livro livro) {
	String sqlInsert = "INSERT INTO livro(nome, autor, ano) VALUES (?, ?, ?)";
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setString  (1,   livro.getNome());
		stm.setString  (2,   livro.getAutor());
		stm.setString  (3,   livro.getAno());
		stm.execute();
		String sqlQuery  = "SELECT LAST_INSERT_ID()";
		try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
			ResultSet rs = stm2.executeQuery();) {
			if(rs.next()){
				livro.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return livro.getId();
}

public void atualizar(Livro livro) {
	String sqlUpdate = "UPDATE livro SET nome=?, autor=?, ano=? WHERE id=?";
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		stm.setString  (1, livro.getNome());
		stm.setString  (2, livro.getAutor());
		stm.setString  (3, livro.getAno());
		stm.setInt     (4, livro.getId());
		stm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void excluir(int id) {
	String sqlDelete = "DELETE FROM livro WHERE id = ?";
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		stm.setInt(1, id);
		stm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public Livro carregar(int id) {
	Livro livro = new Livro ();
	livro.setId(id);
	String sqlSelect = "SELECT nome, autor, ano FROM livro WHERE livro.id = ?";
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setInt(1, livro.getId());
		try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				livro.setNome (rs.getString("nome"));
				livro.setAutor(rs.getString("autor"));
				livro.setAno  (rs.getString("ano"));
			} else {
				livro.setId(-1);
				livro.setNome(null);
				livro.setAutor(null);
				livro.setAno(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
	}
	return livro;
}

public void criar(int id, String nome, String autor, String ano) {
	// TODO Auto-generated method stub
	
}

public void atualizar(int id, String nome, String autor, String ano) {
	// TODO Auto-generated method stub
	
}


}

