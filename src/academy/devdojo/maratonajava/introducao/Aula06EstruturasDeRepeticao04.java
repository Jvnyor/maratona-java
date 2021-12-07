package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepeticao04 {
	// Dado um valor de um carro, descubra em quantas vezes ele pode ser parcelado
	public static void main(String[] args) {
		double valorCarro = 50000;
		for(int i=1;i<=12;i++) {
			System.out.println("O valor do carro de "+valorCarro+" pode ser parcelado em "+i+"x no valor de "+valorCarro / i);
		}
	}
}
