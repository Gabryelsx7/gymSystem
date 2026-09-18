package dev.gabryel.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "acessos_catraca")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Assiduidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @Column(name = "data_entrada")
    private LocalDateTime dataInico;

    @Column(name = "data_saida")
    private LocalDateTime dataSaida;

    @PrePersist
    public void prePersist(){
        if (dataInico == null){
            dataInico = LocalDateTime.now();
        }
    }
}
