package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.RentavelService;

public class ClasseGenericaTest03 {

	public static void main(String[] args) {
		List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca")));
		List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
		RentavelService<Carro> carroRentavelService = new RentavelService<>(carrosDisponiveis);
		Carro carro = carroRentavelService.buscarObjetoDisponivel();
		System.out.println("Usando o barco por um mês...");
		carroRentavelService.retornarObjetoAlugado(carro);
		
		System.out.println("-------------------");
		
		RentavelService<Barco> barcoRentavelService = new RentavelService<>(barcosDisponiveis);
		Barco barco = barcoRentavelService.buscarObjetoDisponivel();
		System.out.println("Usando o carro por um mês...");
		barcoRentavelService.retornarObjetoAlugado(barco);
	}

}
