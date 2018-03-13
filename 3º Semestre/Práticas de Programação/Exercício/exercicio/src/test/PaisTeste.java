package test;

import static org.junit.Assert.assertEquals;
import model.Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTeste {
	Pais pais, copia;
	static int id = 0;



@Before
public void setUp() throws Exception {
	System.out.println("setup");
	pais = new Pais( );
	copia = new Pais( );
	System.out.println();
	System.out.println(copia);
	System.out.println(id);
}

@Test
public void test00Carregar() {
	System.out.println("carregar");
	Pais fixture = new Pais( );
	Pais novo = new Pais();
	novo.carregar();
	assertEquals("testa inclusao", novo, fixture);
}

@Test
public void test01Criar() {
	System.out.println("criar");
	pais.criar();
	id = pais.getId();
	System.out.println(id);
	copia.setId(id);
	assertEquals("testa criacao", pais, copia);
}

@Test
public void test02Atualizar() {
	System.out.println("atualizar");
	pais.setPopulacao("999.9");
	copia.setPopulacao("999.9");		
	pais.atualizar();
	pais.carregar();
	assertEquals("testa atualizacao", pais, copia);
}

@Test
public void test03Excluir() {
	System.out.println("excluir");
	copia.setId(-1);
	copia.setNome(null);
	copia.setPopulacao((Long) null);
	copia.setArea((Double) null);
	pais.excluir();
	pais.carregar();
	assertEquals("testa exclusao", pais, copia);
}
}
