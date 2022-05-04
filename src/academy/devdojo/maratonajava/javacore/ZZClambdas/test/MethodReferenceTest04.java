package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

// Reference to an instance method of an arbitrary object of a particular type
public class MethodReferenceTest04 {
	public static void main(String[] args) {
		Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;
		AnimeComparators animeComparators = newAnimeComparators.get();
		List<Anime> animeList = new ArrayList<>(
				List.of(new Anime("Berserk", 43), new Anime("One Piece", 900), new Anime("Naruto", 500)));
		animeList.sort(animeComparators::compareByEpisodesNonStatic);
		System.out.println(animeList);
		
		BiFunction<String, Integer, Anime> animeFunction = (title, episodes) -> new Anime(title, episodes);
		BiFunction<String, Integer, Anime> animeFunction2 = Anime::new;
		System.out.println(animeFunction2.apply("Super Campeões", 36));
	}
}
