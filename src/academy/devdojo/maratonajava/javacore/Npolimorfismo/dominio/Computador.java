package academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio;

public class Computador extends Produto {

	public static final double IMPOSTO_POR_CENTO = 0.21;
	public Computador(String nome, double valor) {
		super(nome, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularImposto() {
		// TODO Auto-generated method stub
		System.out.println("Calculando imposto do Computador");
		return this.valor * IMPOSTO_POR_CENTO;
	}
	
}
