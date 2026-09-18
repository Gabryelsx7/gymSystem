package dev.gabryel.demo.repository;

import dev.gabryel.demo.domain.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlanoRespository extends JpaRepository<Plano, Long> {
}
