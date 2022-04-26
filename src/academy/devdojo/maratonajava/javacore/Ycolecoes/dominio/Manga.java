package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga> {

	private Long id;
	private String nome;
	private double preco;

	public Manga(Long id, String nome, double preco) {
		Objects.requireNonNull(id, "Id não pode ser null");
		Objects.requireNonNull(nome, "Nome não pode ser null");
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manga other = (Manga) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

	@Override
	public String toString() {
		return "Manga [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}

	@Override
	public int compareTo(Manga outroManga) {
		// negativo se o this < outroManga
		// se this == outroManga, return 0
		// positivo se this > outroManga
		
//		if (this.id < outroManga.getId()) {
//			return -1;
//		} else if (this.id.equals(outroManga.getId())) {
//			return 0;
//		} else {
//			return 1;
//		}
		
		return this.nome.compareTo(outroManga.getNome());
				
//		return Double.compare(this.preco, outroManga.getPreco());
//		return Double.valueOf(this.preco).compareTo(outroManga.getPreco());
		
//		return this.id.compareTo(outroManga.getId());
	}

}
