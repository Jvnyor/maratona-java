package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {

	public static void main(String[] args) {
		String nome = "Willian Suane";
		nome = nome.concat(" Devdojo");
		nome = nome.substring(0,3);
		System.out.println(nome);
		StringBuilder sb = new StringBuilder("William Suane");
		sb.append(" Devdojo").append(" Academy");
		sb.reverse();
		sb.reverse();
		sb.delete(0, 3);
		System.out.println(sb);
	}	
}
