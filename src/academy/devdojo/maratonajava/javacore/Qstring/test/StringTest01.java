package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {

	public static void main(String[] args) {
		String nome = "William"; //String constant pool
		String nome2 = "William";
		nome = nome.concat(" Suane");
		System.out.println(nome);
		System.out.println(nome == nome2);
		String nome3 = new String("William"); // 1 variavel de refer�ncia, 2 objeto tipo string, uma string no pool de string
		System.out.println(nome2 == nome3);
		System.out.println(nome2 == nome3.intern());
	}
}