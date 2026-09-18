package dev.gabryel.demo.repository;

import dev.gabryel.demo.domain.Graduacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGraduacaoRespository extends JpaRepository<Graduacao, Long> {
}
