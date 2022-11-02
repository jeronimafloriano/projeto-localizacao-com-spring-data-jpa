package localizacao.service;

import localizacao.domain.entity.Cidade;
import localizacao.domain.repository.CidadeRepository;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static localizacao.specs.CidadeSpecification.*;

@Service
public class CidadeService {

    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    public void listarPorNome(){
        System.out.println("findByNome: " + repository.findByNome("Natal"));
        System.out.println("findByNomeStartingWith: " + repository.findByNomeStartingWith("Rio"));
        System.out.println("findByNomeLike: " + repository.findByNomeLike("Rio%"));
        System.out.println("findByNomeEndingWith: " + repository.findByNomeEndingWith("o"));
        System.out.println("findByNomeLike: " + repository.findByNomeLike("%o"));
        System.out.println("findByNomeContaining: " + repository.findByNomeContaining("al"));
        System.out.println("findByNomeLike: " + repository.findByNomeLike("%al%"));
    }

    public void listarPorNomeComSortEPaginacao(){
        System.out.println("findByNomeLike com Sort Decrescente: " +
                repository.findByNomeLike("%na%", Sort.by("nome")
                .descending()));

        System.out.println("findByNomeLike com Sort Crescente: " +
                repository.findByNomeLike("%na%", Sort.by("nome")
                        .ascending()));


        Pageable pageable = PageRequest.of(0, 2);
        repository.findByNomeLike("%%%%",pageable).forEach(System.out::println);
    }

    public void listarPorHabitantes(){
        System.out.println("findByHabitantes: " + repository.findByHabitantes(1000000L));
        System.out.println("findByHabitantesLessThan: " + repository.findByHabitantesLessThan(32396372L));
        System.out.println("findByHabitantesLessThanAndNomeLike: " + repository.findByHabitantesLessThanAndNomeLike(32396372L,"Rio%"));
        System.out.println("findByHabitantesLessThanEqual: " + repository.findByHabitantesLessThanEqual(32396372L));
        System.out.println("findByHabitantesGreaterThan: " + repository.findByHabitantesGreaterThan(32396372L));

    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

    public void listarComSpecification(){
        Specification<Cidade> specs = nomeLike("Rio%%")
                .and(habitantesGreaterThanOrEqual(100L))
                .or(idEqual(1L));

        repository.findAll(specs).forEach(System.out::println);
    }

    public void listarComSpecificationFiltroDinamico(Cidade filtro){
        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());

        //cb.conjunction() : select * from cidade where 1 = 1, adiciona essa expressão
        //que torna a condição verdadeira e irá retornar o select

        if(filtro.getId() != null){
            specs = specs.and(idEqual(filtro.getId()));
        }
        if (filtro.getNome() != null){
            specs = specs.and(nomeLike(filtro.getNome()));
        }

        if(filtro.getHabitantes() != null){
            specs = specs.and(habitantesGreaterThanOrEqual(filtro.getHabitantes()));
        }

        repository.findAll(specs).forEach(System.out::println);
    }

    public void listarComSqlNativo(){
        repository.findByNomeSqlNativo("Natal").forEach(System.out::println);
    }

    public void listarComSqlNativoMapeandoProjection(){
        repository.findByNomeSqlNativo("Natal")
                .stream().map(cidadeProjection ->
                        new Cidade(cidadeProjection.getId(), cidadeProjection.getNome(), null))
                .forEach(System.out::println);
    }
}
