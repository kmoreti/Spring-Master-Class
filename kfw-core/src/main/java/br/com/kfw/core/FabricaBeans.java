package br.com.kfw.core;

import java.util.List;

public class FabricaBeans {

	public Contexto inicializarContexto(List<Class<?>> classes) {

		Contexto contexto = new Contexto();
		
		for (Class<?> clazz : classes) {
			try {
				Object instance = clazz.newInstance();
				contexto.adicionar(instance);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
		return contexto;
	}

	
	
}
