package br.com.kfw.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.com.kfw.dummy.EscanerDummyClassA;
import br.com.kfw.dummy.EscanerDummyClassB;
import br.com.kfw.dummy.subpackage.EscanerDummyClassC;

public class EscanerPacotesTests {

	private EscanerPacotes target = new EscanerPacotes();
	
	@Test
	public void deveRecuperarClassesDoPacoteRecursivamente() throws Exception {
		
		List<Class<?>> classes = target.listarClasses("br.com.kfw.dummy");
		
		assertThat(classes.size(), is(equalTo(3)));
		assertThat(classes.contains(EscanerDummyClassA.class), is(equalTo(true)));
		assertThat(classes.contains(EscanerDummyClassB.class), is(equalTo(true)));
		assertThat(classes.contains(EscanerDummyClassC.class), is(equalTo(true)));
		
	}
	
	@Test
	public void deveRecuperarClassesGerenciadasDoPacoteRecursivamente() throws Exception {
		
		List<Class<?>> classes = target.listarClassesGerenciadas("br.com.kfw.dummy");
		
		assertThat(classes.size(), is(equalTo(1)));
		assertThat(classes.contains(EscanerDummyClassA.class), is(equalTo(true)));
		
	}
	
	
}
