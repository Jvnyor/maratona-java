package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais01 {

	public static void main(String[] args) {
		int idade = 15;
		// !
		boolean isAutorizadoComprarBebida = idade >= 18;
		if(isAutorizadoComprarBebida != false) {
			System.out.println("Autorizado a comprar bebida alc�lica");
		} else {
			System.out.println("N�o autorizado a comprar bebida alc�lica");
		}
		
		if(!isAutorizadoComprarBebida) {
			System.out.println("N�o autorizado a comprar bebida alc�lica");
		}
		boolean c = false;
		if (c == true) {
			System.out.println("Dentro de algo que nunca deve ser feito");
		}
		System.out.println("Fora do if");
	}
}
