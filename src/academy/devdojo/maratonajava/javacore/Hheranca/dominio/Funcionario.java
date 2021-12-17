package academy.devdojo.maratonajava.javacore.Hheranca.dominio;

public class Funcionario extends Pessoa {
	
	private double salario;
	static {
		System.out.println("Dentro do bloco de inicialização estático de funcionario");
	}
	{
		System.out.println("Dentro do bloco de inicialização de funcionario 1");
	}
	{
		System.out.println("Dentro do bloco de inicialização de funcionario 2");
	}
	public Funcionario(String nome) {
		super(nome);
	}
	
	public void imprime() {
		super.imprime();
		System.out.println(this.salario);
	}
	
	public void relatorioPagamento() {
		System.out.println("Eu "+this.nome+" Recebi o salário "+this.salario);
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
