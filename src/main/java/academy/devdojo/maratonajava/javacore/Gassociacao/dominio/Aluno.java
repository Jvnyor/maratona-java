package academy.devdojo.maratonajava.javacore.Gassociacao.dominio;

public class Aluno {
	private String nome;
	private int idade;
	
	private Seminario seminario;

	public void imprime() {
		System.out.println(this.nome);
		System.out.println(this.idade);
		if(this.seminario==null) return;
		System.out.println(this.seminario.getTitulo());
		System.out.println(this.seminario.getLocal().getEndereco());
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

	public Seminario getSeminario() {
		return seminario;
	}

	public void setSeminario(Seminario seminario) {
		this.seminario = seminario;
	}
	
	public Aluno(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public Aluno(String nome, int idade, Seminario seminario) {
		this.nome = nome;
		this.idade = idade;
		this.seminario = seminario;
	}
	
	
}
