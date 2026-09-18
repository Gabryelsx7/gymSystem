package dev.gabryel.demo.domain;

import dev.gabryel.demo.domain.enums.StatusMatricula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "matriculas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column(name = "data_matricula")
    private LocalDateTime dataMatricula;

    @Column(name = "dia_vencimento")
    private LocalDateTime diaVencimento;

    @Column(name = "data_encerramento")
    private LocalDateTime dataEncerramento;

    @Enumerated(EnumType.STRING)
    private StatusMatricula status = StatusMatricula.ATIVA;

    @PrePersist
    public void prePersist(){
        if (dataMatricula == null){
            dataMatricula = LocalDateTime.now();
        }
    }
}
