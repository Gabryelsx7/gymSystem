package dev.gabryel.demo.repository;

import dev.gabryel.demo.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatriculaRespository extends JpaRepository<Matricula, Long> {
}
