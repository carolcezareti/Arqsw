package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Livro;
import service.LivroService;;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LivroTeste {
	Livro livro, copia;
	LivroService livroService;
	static int id = 0;


@Before
public void setUp() throws Exception {
	System.out.println("setup");
	livro = new Livro(0, null, null, null );
	livro.setId(id);
	livro.setNome("A Guerra Dos Tronos - As Crônicas de Gelo e Fogo - Livro Um");
	livro.setAutor("Martin, George R. R.");
	livro.setAno("2015");
	copia = new Livro(0, null, null, null );
	copia.setId(id);
	copia.setNome("A Guerra Dos Tronos - As Crônicas de Gelo e Fogo - Livro Um");
	copia.setAutor("Martin, George R. R.");
	copia.setAno ("2015");
	livroService = new LivroService ();
	System.out.println(livro);
	System.out.println(copia);
	System.out.println(id);

}

@Test
public void test00Carregar() {
	System.out.println("carregar");
	Livro fixture = new Livro(0, null, null, null );
	fixture.setId (1);
	fixture.setNome("A Guerra Dos Tronos - As Crônicas de Gelo e Fogo - Livro Um");
	fixture.setAutor("Martin, George R. R.");
	fixture.setAno ("2015");
	LivroService novoService = new LivroService ();
	Livro novo = novoService.carregar(1);
	assertEquals("testa inclusao", novo, fixture);
}

@Test
public void test01Criar() {
	System.out.println("criar");
	id = livroService.criar(livro);
	System.out.println(id);
	copia.setId(id);
	assertEquals("testa criacao", livro, copia);
}

@Test
public void test02Atualizar() {
	System.out.println("atualizar");
	livro.setAutor("xxxx");
	copia.setAutor("xxxx");		
	livroService.atualizar(livro);
	livro = livroService.carregar(livro.getId());
	assertEquals("testa atualizacao", livro, copia);
}

@Test
public void test03Excluir() {
	System.out.println("excluir");
	copia.setId(-1);
	copia.setNome(null);
	copia.setAutor(null);
	copia.setAno(null);
	livroService.excluir(id);
	livro = livroService.carregar(id);
	assertEquals("testa exclusao", livro, copia);
}
}
