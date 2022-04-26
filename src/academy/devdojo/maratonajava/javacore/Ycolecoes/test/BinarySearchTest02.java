package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

public class BinarySearchTest02 {

	public static void main(String[] args) {
		List<Manga> mangas = new ArrayList<>(6);
		MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();
		mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9));
		mangas.add(new Manga(1L, "Berserk", 9.5));
		mangas.add(new Manga(4L, "Pokemon", 3.2));
		mangas.add(new Manga(3L, "Attack on Titan", 11.20));
		mangas.add(new Manga(2L, "Dragon Ball Z", 2.99));
//		Collections.sort(mangas);
		mangas.sort(new MangaByIdComparator());
		for (Manga manga : mangas) {
			System.out.println(manga);
		}
		
		Manga mangaToSearch = new Manga(2L, "Dragon Ball Z", 2.99);
		System.out.println(Collections.binarySearch(mangas, mangaToSearch, mangaByIdComparator));
	}

}
