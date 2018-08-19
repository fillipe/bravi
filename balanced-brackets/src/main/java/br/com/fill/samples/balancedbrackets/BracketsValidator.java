package br.com.fill.samples.balancedbrackets;

import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

@Component
public class BracketsValidator {

	Set<Character> bracketsAbertura = new TreeSet<>(Arrays.asList('{', '(', '['));
	Set<Character> bracketsFechamento = new TreeSet<>(Arrays.asList('}', ')', ']'));

	public boolean isValid(String cenario) {
		if (cenario == null || "".equals(cenario) || cenario.length() % 2 != 0) {
			return false;
		}
		Stack<Character> pilha = new Stack<>();
		for (int i = 0; i < cenario.length(); i++) {
			Character bracket = cenario.charAt(i);
			if (bracketsAbertura.contains(bracket)) {
				pilha.push(bracket);
			} else if (bracketsFechamento.contains(bracket) && !pilha.isEmpty()) {
				if (pilha.peek().equals('{') && bracket.equals('}')
					|| pilha.peek().equals('[') && bracket.equals(']')
					|| pilha.peek().equals('(') && bracket.equals(')')) {
						pilha.pop();
				}
			} else {
				return false;
			}
		}
		return pilha.isEmpty();
	}

}