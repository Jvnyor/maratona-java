package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

public class MangaSortTest01 {
	public static void main(String[] args) {
		List<Manga> mangas = new ArrayList<>(6);
		mangas.add(new Manga(1L ,"Hellsing Ultimate", 0));
		mangas.add(new Manga(2L ,"Berserk", 0));
		mangas.add(new Manga(3L ,"Pokemon", 0));
		mangas.add(new Manga(4L ,"Attack on Titan", 0));
		mangas.add(new Manga(5L ,"Dragon Ball Z", 0));
		
	}
}
