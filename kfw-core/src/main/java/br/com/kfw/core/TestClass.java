package br.com.kfw.core;

import java.util.function.Consumer;

public class TestClass implements Function1<Integer,String>{

	@Override
	public String process(Integer t) {
		String r = "";
		if (t == 5) {
			return "cinco";
		}
		return "ABC";
	}

	public static void main(String[] args) {
		TestClass tclass = new TestClass();
		int w = 6;
	    Function1<Integer, String> f = (Integer x) -> (tclass.process(x));
	    			 
	    System.out.println(f.process(w));
	    
	    RuleTest r1 = new RuleTest(10);
	    RuleTest r2 = new RuleTest(2);
	    RuleTest r3 = new RuleTest(10);
	    
	    System.out.println(r1.and(r2).evaluate());
	    System.out.println(r1.and(r3).evaluate());
	    System.out.println(r2.or(r1).evaluate());
	    System.out.println(r2.evaluate());
	}
}

class RuleTest implements Rule{
	int x = 0;
	
	public RuleTest(int x) {
		this.x = x;
	}

	@Override
	public boolean evaluate() {
		if (x == 10) {
			return true;
		}
		return false;
	}
	
}