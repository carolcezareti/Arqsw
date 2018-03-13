package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Pais;
import service.PaisService;;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTeste {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;


@Before
public void setUp() throws Exception {
	System.out.println("setup");
	pais = new Pais( );
	pais.setId(id);
	pais.setNome("Brasil");
	pais.setPopulacao("207.1");
	pais.setArea("8.515.767,049");
	copia = new Pais( );
	copia.setId(id);
	copia.setNome("Brasil");
	copia.setPopulacao("207.1");
	copia.setArea ("8.515.767,049");
	paisService = new PaisService ();
	System.out.println(pais);
	System.out.println(copia);
	System.out.println(id);

}

@Test
public void test00Carregar() {
	System.out.println("carregar");
	Pais fixture = new Pais( );
	fixture.setId (1);
	fixture.setNome("Brasil");
	fixture.setPopulacao("207.1");
	fixture.setArea ("8.515.767,048");
	PaisService novoService = new PaisService ();
	Pais novo = novoService.carregar(1);
	assertEquals("testa inclusao", novo, fixture);
}

@Test
public void test01Criar() {
	System.out.println("criar");
	id = paisService.criar(pais);
	System.out.println(id);
	copia.setId(id);
	assertEquals("testa criacao", pais, copia);
}

@Test
public void test02Atualizar() {
	System.out.println("atualizar");
	pais.setPopulacao("9999");
	copia.setPopulacao("9999");		
	paisService.atualizar(pais);
	pais = paisService.carregar(pais.getId());
	assertEquals("testa atualizacao", pais, copia);
}

@Test
public void test03Excluir() {
	System.out.println("excluir");
	copia.setId(-1);
	copia.setNome(null);
	copia.setPopulacao(null);
	copia.setArea(null);
	paisService.excluir(id);
	pais = paisService.carregar(id);
	assertEquals("testa exclusao", pais, copia);
}
}
