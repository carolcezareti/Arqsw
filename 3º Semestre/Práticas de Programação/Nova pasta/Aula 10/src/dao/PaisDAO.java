package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {

public int criar(Pais pais) {
	String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
	try (Connection conn = ConnectionFactory.obterConexao();
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
	
	return pais.getId();
}

public void atualizar(Pais pais) {
	String sqlUpdate = "UPDATE cliente SET nome=?, populacao=?, area=? WHERE id=?";
	try (Connection conn = ConnectionFactory.obterConexao();
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
	String sqlDelete = "DELETE FROM pais WHERE id = ?";
	try (Connection conn = ConnectionFactory.obterConexao();
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
	try (Connection conn = ConnectionFactory.obterConexao();
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

public ArrayList<Pais> listarPais() {
	Pais pais;
ArrayList<Pais> lista = new ArrayList<>();
String sqlSelect = "SELECT id, nome, fone, email FROM cliente";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = ConnectionFactory.obterConexao();
PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
try (ResultSet rs = stm.executeQuery();) {
while (rs.next()) {
pais = new Pais();
pais.setId(rs.getInt("id"));
pais.setNome(rs.getString("nome"));
pais.setPopulacao(rs.getString("populacao"));
pais.setArea(rs.getString("area"));
lista.add(pais);
}
} catch (SQLException e) {
e.printStackTrace();
}
} catch (SQLException e1) {
System.out.print(e1.getStackTrace());
}
return lista;
}

public void criar(int id, String nome, long populacao, double area) {
	// TODO Auto-generated method stub
	
}

public void atualizar(int id, String nome, long populacao, double area) {
	// TODO Auto-generated method stub
	
}


}

