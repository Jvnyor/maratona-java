package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.LinkedList;
import java.util.List;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

public class IteratorTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Manga> mangas = new LinkedList<>();
		mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
		mangas.add(new Manga(1L, "Berserk", 9.5, 5));
		mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
		mangas.add(new Manga(3L, "Attack on Titan", 11.20, 2));
		mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));
		
//		Iterator<Manga> mangaIterator = mangas.iterator();
//		while(mangaIterator.hasNext()) {
//			if (mangaIterator.next().getQuantidade() == 0) {
//				mangaIterator.remove();
//			}
//		}
		
		mangas.removeIf(manga -> manga.getQuantidade() == 0);
		System.out.println(mangas);
	}

}
