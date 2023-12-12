package br.com.adopet.domain.abrigo;

import br.com.adopet.domain.abrigo.dto.DadosCadastroAbrigo;
import br.com.adopet.domain.pet.Pet;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "abrigos")
@Entity(name = "Abrigo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Abrigo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localidade;

    @OneToMany(mappedBy = "abrigo")
    private List<Pet> pets;
    private boolean ativo;

    public Abrigo(DadosCadastroAbrigo dados) {
        this.localidade = dados.localidade();
        this.ativo = true;
    }
}
