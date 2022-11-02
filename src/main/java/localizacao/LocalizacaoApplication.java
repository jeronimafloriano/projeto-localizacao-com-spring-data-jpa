package localizacao;

import localizacao.domain.entity.Cidade;
import localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    @Override
    public void run(String... args) throws Exception {
        var cidade = new Cidade(null, "%Rio%", null);
        service.filtroDinamico(cidade).forEach(System.out::println);
        service.listarComSpecification();
        service.listarComSpecificationFiltroDinamico(cidade);
        service.listarComSqlNativo();
        service.listarComSqlNativoMapeandoProjection();
        service.listarPorNomeComSortEPaginacao();
        service.listarPorNome();
        service.listarPorHabitantes();
    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class);
    }
}
