package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais06 {

	public static void main(String[] args) {
		// Dados os valores de 1 a 7, imprima se é dia útil ou final de semana
		// Considerando 1 como domingo
		byte dia = 2;
		switch (dia) {
			case 1:
			case 7:
				if (dia == 1) {
					System.out.println("Dom");
				} else if (dia == 7){
					System.out.println("Sab");
				}
				System.out.println("final de semana");
				break;
			case 2:	
			case 3:
			case 4:
			case 5:
			case 6:
				if (dia == 2) {
					System.out.println("Seg");
				} else if (dia == 3) {
					System.out.println("Ter");
				} else if (dia == 4) {
					System.out.println("Qua");
				} else if (dia == 5) {
					System.out.println("Qui");
				} else if (dia == 6) {
					System.out.println("Sex");
				}
				System.out.println("dia útil");
				break;
			default:
				System.out.println("Opção inválida");
				break;
		}
	}
}
