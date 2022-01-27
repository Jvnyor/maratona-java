package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest02 {

	public static void main(String[] args) {
		try {
			divisao(1,0);
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param a
	 * @param b não pode ser 0
	 * @return a / b
	 * @throws IllegalArgumentException caso b seja 0
	 */
	private static int divisao(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Argumento ilegal, não pode ser 0");
		}
		return a/b;
	}
}
