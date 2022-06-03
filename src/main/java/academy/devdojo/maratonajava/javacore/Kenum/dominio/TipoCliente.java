package academy.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoCliente {

	PESSOA_FISICA(1, "Pessoa F�sica"),
	PESSOA_JURIDICA(2, "Pessoa Jur�dica");
	
	private int valor;
	private String nomeRelatorio;
	
	private TipoCliente(int valor, String nomeRelatorio) {
		this.valor = valor;
		this.nomeRelatorio = nomeRelatorio;
	}

	public static TipoCliente tipoClientePorNomeRelatorio(String nomeRelatorio) {
		for (TipoCliente tipoCliente : values()) {
			if(tipoCliente.getNomeRelatorio().equals(nomeRelatorio)) {
				return tipoCliente;
			}
		}
		return null;
	}
	
	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public int getValor() {
		return valor;
	}
	
	

}
