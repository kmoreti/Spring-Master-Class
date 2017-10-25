package br.com.kfw.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.kfw.dummy.EscanerDummyClassA;
import br.com.kfw.dummy.EscanerDummyClassB;
import br.com.kfw.dummy.subpackage.EscanerDummyClassC;

public class FabricaBeansTests {

	private FabricaBeans target = new FabricaBeans();
	
	private EscanerPacotes escaner = new EscanerPacotes();
	
	@Test
	public void deveCriarInstanciasDeClassesGerenciadas() throws Exception {
		
		Contexto contexto = target.inicializarContexto(escaner.listarClassesGerenciadas("br.com.kfw.dummy"));
		
		assertThat(contexto.totalDeBeans(), is(equalTo(1)));
		assertThat(contexto.recuperarBean(EscanerDummyClassA.class), is(notNullValue()));
		assertThat(contexto.contemBean(EscanerDummyClassB.class), is(equalTo(false)));
		assertThat(contexto.contemBean(EscanerDummyClassC.class), is(equalTo(false)));
		
	}
	
}
