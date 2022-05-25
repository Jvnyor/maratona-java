package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

public class QueueTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator());
		mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
		mangas.add(new Manga(1L, "Berserk", 9.5, 5));
		mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
		mangas.add(new Manga(3L, "Attack on Titan", 11.20, 2));
		mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));
		mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));
		
		while (!mangas.isEmpty()) {
			System.out.println(mangas.poll());
		}
	}

}
