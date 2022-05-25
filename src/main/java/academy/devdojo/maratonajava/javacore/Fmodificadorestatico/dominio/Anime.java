package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio;

public class Anime {

	private String nome;
	private static int[] episodios;
	// 0 - Bloco de inicialização estático é executado quando a JVM carregar a classe
	// 1 - Alocado espaço em memória pro objeto
	// 2 - Cada atributo da classe é criado e inicializado com valores default ou o que for passado
	// 3 - Bloco de inicialização é executado
	// 4 - Construtor é executado
	static {
		System.out.println("Dentro do bloco de inicialização estático");
		episodios = new int[100];
		for (int i = 0; i < episodios.length; i++) {
			episodios[i] =i+1;
		}
	}
	
	static {
		System.out.println("Dentro do bloco de inicialização estático 2");
		
	}
	
	static {
		System.out.println("Dentro do bloco de inicialização estático 3");
		
	}
	{
		System.out.println("Dentro do bloco de inicialização não estático");
	}
	public Anime(String nome) {
		super();
		this.nome = nome;
	}

	public Anime() {
		
		for(int episodio:Anime.episodios) {
			System.out.print(episodio+" ");
		}
		System.out.println();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getEpisodios() {
		return Anime.episodios;
	}
	
}
