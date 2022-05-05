package pavlov24.deverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pavlov24.deverb.domain.Verb;
import pavlov24.deverb.domain.VerbType;
import pavlov24.deverb.repository.VerbRepository;

@SpringBootApplication
public class DeverbApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DeverbApplication.class, args);
		VerbRepository repository = context.getBean(VerbRepository.class);
		/*repository.save(new Verb(0L, "machen", false, VerbType.SCHWACH));
		repository.save(new Verb(0L, "lachen", false, VerbType.SCHWACH));
		repository.save(new Verb(0L, "lieben", false, VerbType.SCHWACH));
		repository.save(new Verb(0L, "versuchen", false, VerbType.SCHWACH));

		repository.save(new Verb(0L, "schreiben", true, VerbType.STARK));
		repository.save(new Verb(0L, "schlafen", true, VerbType.STARK));
		repository.save(new Verb(0L, "trinken", true, VerbType.STARK));
		repository.save(new Verb(0L, "stehen", true, VerbType.STARK));*/

	}

}
