package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class PaisDAO {

public void criar(Pais pais) {
	String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
	try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setString(1,   pais.getNome());
		stm.setLong  (2,   pais.getPopulacao());
		stm.setDouble(3,   pais.getArea());
		stm.execute();
		String sqlQuery  = "SELECT LAST_INSERT_ID()";
		try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
			ResultSet rs = stm2.executeQuery();) {
			if(rs.next()){
				pais.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return;
}

private Connection obtemConexao() {
	// TODO Auto-generated method stub
	return null;
}

public void atualizar(Pais pais) {
	String sqlUpdate = "UPDATE cliente SET nome=?, fone=?, email=? WHERE id=?";
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		stm.setString(1, pais.getNome());
		stm.setLong  (2, pais.getPopulacao());
		stm.setDouble(3, pais.getArea());
		stm.setInt   (4, pais.getId());
		stm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void excluir(int id) {
	String sqlDelete = "DELETE FROM cliente WHERE id = ?";
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		stm.setInt(1, id);
		stm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@SuppressWarnings("null")
public Pais carregar(int id) {
	Pais pais = new Pais(id, null, id, id);
	pais.setId(id);
	String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
	try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setInt(1, pais.getId());
		try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
			} else {
				pais.setId(-1);
				pais.setNome(null);
				pais.setPopulacao((Long) null);
				pais.setArea((Double) null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
	}
	return pais;
}

public void criar(int id, String nome, long populacao, double area) {
	// TODO Auto-generated method stub
	
}

public void atualizar(int id, String nome, long populacao, double area) {
	// TODO Auto-generated method stub
	
}


}

