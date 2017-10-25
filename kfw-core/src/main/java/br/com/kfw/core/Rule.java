package br.com.kfw.core;

import java.util.Objects;

@FunctionalInterface
public interface Rule {
	
	boolean evaluate();
	
	default Rule and(Rule other) {
		Objects.requireNonNull(other);
		return () -> evaluate() && other.evaluate();
	}
	
	default Rule negate() {
        return () -> !evaluate();
    }
	
	default Rule or(Rule other) {
		Objects.requireNonNull(other);
        return () -> evaluate() || other.evaluate();
    }

}
