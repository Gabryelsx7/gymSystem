package dev.gabryel.demo.repository;

import dev.gabryel.demo.domain.FaturaMatricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFaturaRespository extends JpaRepository<FaturaMatricula, Long> {
}
