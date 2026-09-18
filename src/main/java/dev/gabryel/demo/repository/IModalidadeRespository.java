package dev.gabryel.demo.repository;

import dev.gabryel.demo.domain.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModalidadeRespository extends JpaRepository<Modalidade, Long> {
}
