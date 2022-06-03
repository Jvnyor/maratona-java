package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

public class StreamTest15 {
	private static List<LightNovel> lightNovels = new ArrayList<>(
			List.of(new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
					new LightNovel("Overlord", 10.99, Category.FANTASY),
					new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
					new LightNovel("No Game no life", 2.99, Category.FANTASY),
					new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
					new LightNovel("Kumo Desuga", 1.99, Category.FANTASY),
					new LightNovel("Kumo Desuga", 1.99, Category.FANTASY),
					new LightNovel("Monogatari", 4.00, Category.ROMANCE)));

	public static void main(String[] args) {
		Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream()
				.collect(groupingBy(LightNovel::getCategory, summarizingDouble(LightNovel::getPrice)));

		System.out.println(collect);

		Map<Category, Set<Promotion>> collect1 = lightNovels.stream()
				.collect(groupingBy(LightNovel::getCategory, mapping(StreamTest15::getPromotion, toSet())));

		System.out.println(collect1);

		Map<Category, LinkedHashSet<Promotion>> collect2 = lightNovels.stream().collect(groupingBy(
				LightNovel::getCategory, mapping(StreamTest15::getPromotion, toCollection(LinkedHashSet::new))));

		System.out.println(collect2);
	}

	private static Promotion getPromotion(LightNovel ln) {
		return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
	}
}
