package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

public class GenericsTest01 {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Midoriya");
		lista.add("Midoriya");
		
		for (String str : lista) {
			System.out.println(str);
		}
		
		add(lista, new Consumidor("Midoriya"));
		
		for (Object obj : lista) {
			System.out.println(obj);
		}
	}
	
	private static void add (List lista, Consumidor consumidor) {
		lista.add(consumidor);
	}
	
}
