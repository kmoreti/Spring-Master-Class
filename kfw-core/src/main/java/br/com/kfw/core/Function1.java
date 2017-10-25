package br.com.kfw.core;
@FunctionalInterface
public interface Function1 <T, R> {
	R process(T t);
}
