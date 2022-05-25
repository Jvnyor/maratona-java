package academy.devdojo.maratonajava.javacore.Kenum.test;

import academy.devdojo.maratonajava.javacore.Kenum.dominio.Cliente;
import academy.devdojo.maratonajava.javacore.Kenum.dominio.TipoPagamento;
import academy.devdojo.maratonajava.javacore.Kenum.dominio.TipoCliente;

public class ClienteTest01 {
	public static void main(String[] args) {
		Cliente cliente = new Cliente("Tsusaba", TipoCliente.PESSOA_FISICA,TipoPagamento.DEBITO);
		Cliente cliente2 = new Cliente("Tsusaba 2", TipoCliente.PESSOA_JURIDICA,TipoPagamento.CREDITO);
		System.out.println(cliente);
		System.out.println(cliente2);
		System.out.println(TipoPagamento.DEBITO.calcularDesconto(126));
		System.out.println(TipoPagamento.CREDITO.calcularDesconto(150));
		TipoCliente tipoCliente = TipoCliente.valueOf("PESSOA_FISICA");
		System.out.println(tipoCliente.getNomeRelatorio());
		TipoCliente tipoCliente2 = TipoCliente.tipoClientePorNomeRelatorio("Pessoa Física");
		System.out.println(tipoCliente2);
	}
}
