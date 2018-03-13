package model;

import java.io.Serializable;

import dao.PaisDAO;
import javabean.PaisTO;

public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private long populacao;
	private double area;

	public Object paisService;
	
	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
		
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

public long getPopulacao() {
	return populacao;
}

public void setPopulacao(long populacao) {
	this.populacao = populacao;
}

public double getArea() {
	return area;
}

public void setArea(double area) {
	this.area = area;
}


public void criar() {
	PaisDAO dao = new PaisDAO();
	PaisTO to = new PaisTO();
	to.setId(id);
	to.setNome(nome);
	to.setPopulacao(populacao);
	to.setArea(area);
	dao.criar (id, nome, populacao, area);	
}


public void atualizar() {
	PaisDAO dao = new PaisDAO();
	PaisTO to = new PaisTO();
	to.setId(id);
	to.setNome(nome);
	to.setPopulacao(populacao);
	to.setArea(area);
	dao.atualizar (id, nome, populacao, area);	
}

public void excluir() {
	PaisDAO dao = new PaisDAO();
	PaisTO to = new PaisTO();
	to.setId(id);
	dao.excluir (id);	
	
}

public void carregar() {
	new PaisDAO();
	PaisTO to = new PaisTO();
	nome = to.getNome();
	populacao = to.getPopulacao();
	
}

@Override
public String toString() {
return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao + "]";
}

public Pais() {
	// TODO Auto-generated constructor stub
}

public void setPopulacao(String pPopulacao) {
	// TODO Auto-generated method stub
	
}


public void setArea(String pArea) {
	// TODO Auto-generated method stub
	
}

}


