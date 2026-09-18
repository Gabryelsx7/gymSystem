package dev.gabryel.demo.repository;

import dev.gabryel.demo.domain.MatriculaModalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatriculaModalideRespository extends JpaRepository<MatriculaModalidade, Long> {
}
