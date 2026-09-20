package dev.gabryel.demo.dto;

import jakarta.persistence.Column;

public record EnderecoRequest(
         String endereco,
         String numero,
         String complemento,
         String bairro,
         String cidade,
         String estado,
         String cep

) {
}
