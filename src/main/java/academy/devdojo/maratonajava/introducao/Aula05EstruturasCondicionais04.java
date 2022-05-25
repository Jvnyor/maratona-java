package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais04 {

	public static void main(String[] args) {
		// exercicio
		double salarioAnual = 70000;
		double primeiraFaixa = 9.70 / 100;
		double segundaFaixa = 37.35 / 100;
		double terceiraFaixa = 49.50 / 100;
		double impostoDeRendaAnual;
		if (salarioAnual > 0 && salarioAnual <= 34712) {
			impostoDeRendaAnual = primeiraFaixa * salarioAnual;
		} else if (salarioAnual > 34712 && salarioAnual <= 68507) {
			impostoDeRendaAnual = segundaFaixa * salarioAnual;
		} else {
			impostoDeRendaAnual = terceiraFaixa * salarioAnual;
		}
				
		System.out.println("O imposto de renda anual da Holanda será "+impostoDeRendaAnual+" devido ao salário ser no valor de "+salarioAnual);
	}
}
