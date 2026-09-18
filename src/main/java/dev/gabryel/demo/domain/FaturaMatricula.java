package dev.gabryel.demo.domain;

import dev.gabryel.demo.domain.enums.StatusFatura;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "faturas_matriculas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FaturaMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    private BigDecimal valor;

    @Column(name = "data_vencimento")
    private LocalDate vencimento;

    @Column(name = "data_cancelamento")
    private LocalDate cancelamento;

    @Column(name = "data_pagamento")
    private LocalDateTime pagamento;

    @Enumerated(EnumType.STRING)
    private StatusFatura status = StatusFatura.ABERTA;


}
