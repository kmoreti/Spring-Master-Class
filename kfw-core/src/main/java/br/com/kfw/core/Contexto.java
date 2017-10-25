package br.com.kfw.core;

import java.util.HashMap;
import java.util.Map;

public class Contexto {

	Map<Class<?>, Object> contexto;
	
	public Contexto() {
		contexto = new HashMap<>();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T recuperarBean(Class<T> clazz) {
		if (!contexto.containsKey(clazz)) {
			System.err.printf("Contexto não possui nenhuma instância do tipo [%s]\n", clazz.getName());
		}
		
		return (T) contexto.get(clazz);
	}
	
	public <T> boolean contemBean(Class<T> t) {
		return contexto.containsKey(t);
	}
	
	public <T> void adicionar(T t) {
		contexto.put(t.getClass(), t);
	}
	
	public int totalDeBeans() {
		return contexto.size();
	}
	
}
