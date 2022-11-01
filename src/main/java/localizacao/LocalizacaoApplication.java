package localizacao;

import localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("INICIALIZANDO APLICAÇÃO");
        repository.findByNome("Natal").forEach(System.out::println);
        repository.findByHabitantes(1000000L).forEach(System.out::println);

        repository.findByNomeStartingWith("Rio").forEach(System.out::println);
        repository.findByNomeLike("Rio%");

        repository.findByNomeEndingWith("o").forEach(System.out::println);
        repository.findByNomeLike("%o");

        repository.findByNomeContaining("al").forEach(System.out::println);
        repository.findByNomeLike("%al%").forEach(System.out::println);

    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class);
    }
}
