package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao04 {
	
	public static void main(String[] args) {
		// Solução do exercício minha
		double valorCarro = 50000;
		double valorMinimoParcela = 1000;
		for(int i=1;i<=(valorCarro / valorMinimoParcela);i++) {
			System.out.println("O valor do carro de "+valorCarro+" pode ser parcelado em "+i+"x no valor de "+valorCarro / i);
		}
		
		// Dado um valor de um carro, descubra em quantas vezes ele pode ser parcelado
		// Condição valorParcela >= 1000
		double valorTotal = 30000;
		for(int parcela = 1;parcela <= valorTotal;parcela++) {
			double valorParcela = valorTotal / parcela;
			if (valorParcela < 1000) {
				break;
			}
			System.out.println("Parcela "+parcela+" de R$ "+valorParcela);
		}
	}
}
