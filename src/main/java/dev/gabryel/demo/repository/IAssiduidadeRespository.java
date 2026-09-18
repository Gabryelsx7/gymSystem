package dev.gabryel.demo.repository;

import dev.gabryel.demo.domain.Assiduidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssiduidadeRespository extends JpaRepository<Assiduidade, Long> {
}
