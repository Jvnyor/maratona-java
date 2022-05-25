package academy.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoPagamento {
	DEBITO {

		@Override
		public double calcularDesconto(double valor) {
			// TODO Auto-generated method stub
			return valor * 0.1;
		}
		
	},
	CREDITO {

		@Override
		public double calcularDesconto(double valor) {
			// TODO Auto-generated method stub
			return valor * 0.05;
		}
		
	};
	
	public abstract double calcularDesconto(double valor);
}