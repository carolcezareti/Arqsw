package service;

import dao.LivroDAO;
import model.Livro;

public class LivroService {
	
	LivroDAO dao = new LivroDAO();
	
	public int criar(Livro livro) {
		return dao.criar(livro);
	}
	
	public void atualizar(Livro livro){
		dao.atualizar(livro);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Livro carregar(int id){
		return dao.carregar(id);
	}


}
