package learnData;

import java.util.*;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class LearnString {
	
	public int reverseNumber(int number){
		
		int reverse = 0;
		while(number != 0){
			reverse = (reverse*10)+(number%10);
			number = number/10;
		}
		return reverse;
	}

	@Test
	public void mainString() {
		
		LearnString l = new LearnString();
		System.out.println(l.reverseNumber(15));
	
		String s = new String("jagan");
		char[] cs = s.toLowerCase().toCharArray();
		for(int i=cs.length-1; i>=0; i--) {

			System.out.print(cs[i]);
		}
		System.out.println("\n");
	
		StringBuffer sb = new StringBuffer(s);
		System.out.print(sb.reverse());
	
		System.out.println("\n");
		
		StringBuilder stb = new StringBuilder(s);
		System.out.print(stb.reverse());
		
		System.out.println("\n");
		
		Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();
		for(char a : cs) {
			if(m.containsKey(a))
				m.put(a, m.get(a)+1);
			else
				m.put(a, 1);
		}
		System.out.println(m);
	
	
	}
	
	
	
	
	
}
