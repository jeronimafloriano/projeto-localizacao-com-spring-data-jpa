package localizacao.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidade")
@Data
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    private Long id;

    @Column(length = 50, unique = true) //definindo tamanho 50 e que não pode ter outra cidade com msm nome
    private String nome;

    @Column(name = "qtd_habitantes")
    private Long habitantes;
}
