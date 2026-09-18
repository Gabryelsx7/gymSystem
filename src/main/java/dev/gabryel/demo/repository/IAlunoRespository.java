package dev.gabryel.demo.repository;

import dev.gabryel.demo.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunoRespository extends JpaRepository<Aluno, Long> {
}
