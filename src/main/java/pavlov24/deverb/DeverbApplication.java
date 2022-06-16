package pavlov24.deverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pavlov24.deverb.domain.Category;
import pavlov24.deverb.domain.Verb;
import pavlov24.deverb.domain.VerbType;
import pavlov24.deverb.repository.CategoryRepository;
import pavlov24.deverb.repository.VerbRepository;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DeverbApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DeverbApplication.class, args);

		//VerbRepository repository = context.getBean(VerbRepository.class);
		/*CategoryRepository catrepo = context.getBean(CategoryRepository.class);
		/*List<Verb> verbs = List.of(
				new Verb(0L, "machen", false, VerbType.SCHWACH, "gemacht", "machte", "делать", "machen.jpg"),
				new Verb(0L, "lachen", false, VerbType.SCHWACH, "gelacht", "lachte", "смеяться", "lachen.webp"),
				new Verb(0L, "lieben", false, VerbType.SCHWACH, "geliebt", "liebte", "любить","lieben.jpg"),
				new Verb(0L, "versuchen", false, VerbType.SCHWACH, "versucht", "versuchte", "пробовать", "versuchen.webp"),

				new Verb(0L, "schreiben", true, VerbType.STARK, "geschrieben", "schrieb", "писать", "schreiben.webp"),
				new Verb(0L, "schlafen", true, VerbType.STARK, "geschlafen", "schlief", "спать", "schlafen.webp"),
				new Verb(0L, "trinken", true, VerbType.STARK, "getrunken", "trank", "пить", "trinken.jpg"),
				new Verb(0L, "stehen", true, VerbType.STARK, "gestanden", "stand", "стоять", "stehen.jpg")
		);

		for (int i = 0; i < verbs.size(); i++) {
			Verb current = verbs.get(i);
			repository.save(current);
		}

		List<Category> categories = List.of(
				new Category("базовые"),
				new Category("чувства"),
				new Category("еда"),
				new Category("состояние")
		);

		categories.forEach(catrepo::save);*/


	}

}
