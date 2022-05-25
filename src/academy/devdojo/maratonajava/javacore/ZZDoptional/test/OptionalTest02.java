package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.Optional;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepository;

public class OptionalTest02 {

	public static void main(String[] args) {

//		Manga mangaById = MangaRepository.findById(2).orElseThrow(() -> new IllegalArgumentException("Id not found"));
		Manga mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);

		Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no Hero");
		mangaByTitle.ifPresent(m -> m.setTitle("Boku no Hero 2"));
		System.out.println(mangaByTitle);
		System.out.println(mangaById);

		Manga newManga = MangaRepository.findByTitle("Drifters").orElseGet(() -> new Manga(3, "Drifters", 20));
		System.out.println(newManga);
	}

}
