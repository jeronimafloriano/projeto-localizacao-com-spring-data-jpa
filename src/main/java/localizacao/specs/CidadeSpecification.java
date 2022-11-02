package localizacao.specs;

import localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public class CidadeSpecification {

    public static Specification<Cidade> idEqual(Long id){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id));
    }

    public static Specification<Cidade> nomeLike(String nome){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), nome);
    }

    public static Specification<Cidade> habitantesGreaterThanOrEqual(Long value){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("habitantes"), value);
    }
}
