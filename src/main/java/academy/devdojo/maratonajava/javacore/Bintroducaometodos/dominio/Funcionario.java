package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Funcionario {

	private String nome;
	private int idade;
	private double[] salarios;
	private double media;
	
	public double getMedia() {
		return media;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double[] getSalarios() {
		return salarios;
	}

	public void setSalarios(double[] salarios) {
		this.salarios = salarios;
	}

	public void imprime() {
		System.out.println(nome);
		System.out.println(idade);
		if (salarios == null ) {
			return;
		}
		for (double salario : salarios) {
			System.out.print(salario+" ");
		}
		imprimeMediaSalario();

	}
	
	public void imprimeMediaSalario() {
		if (salarios==null) {
			return;
		}
		
		for (double salario : salarios) {
			this.media += salario;
		}
		this.media /= salarios.length;
		System.out.println("\nMedia salarial: "+this.media);
	}
}
