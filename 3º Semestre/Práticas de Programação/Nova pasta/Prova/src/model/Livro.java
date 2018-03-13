package model;

import java.io.Serializable;

import dao.LivroDAO;
import javabean.LivroTO;

public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String autor;
	private String ano;

	public Object paisService;
	
	public Livro(int id, String nome, String autor, String ano) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
		
	}


public Livro() {
		// TODO Auto-generated constructor stub
	}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getAutor() {
	return autor;
}

public void setAutor(String autor) {
	this.autor = autor;
}

public String getAno() {
	return ano;
}

public void setAno(String ano) {
	this.ano = ano;
}


public void criar() {
	LivroDAO dao = new LivroDAO();
	LivroTO to = new LivroTO();
	to.setId(id);
	to.setNome(nome);
	to.setAutor(autor);
	to.setAno(ano);
	dao.criar (id, nome, autor, ano);	
}


public void atualizar() {
	LivroDAO dao = new LivroDAO();
	LivroTO to = new LivroTO();
	to.setId(id);
	to.setNome(nome);
	to.setAutor(autor);
	to.setAno(ano);
	dao.atualizar (id, nome, autor, ano);	
}

public void excluir() {
	LivroDAO dao = new LivroDAO();
	LivroTO to = new LivroTO();
	to.setId(id);
	dao.excluir (id);	
	
}

public void carregar() {
	new LivroDAO();
	LivroTO to = new LivroTO();
	nome = to.getNome();
	autor = to.getAutor();
	
}

@Override
public String toString() {
return "Livro [id=" + id + ", nome=" + nome + ", autor=" + autor + "]";
}

}


