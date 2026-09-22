package dev.gabryel.demo.dto;

import dev.gabryel.demo.domain.Aluno;
import dev.gabryel.demo.domain.enums.Sexo;

import java.time.LocalDate;

public record AlunoResponse(
        Long id,
        String nome,
        LocalDate dataNascimento,
        Sexo sexo,
        String telefone,
        String celular,
        String email,
        String observacao,
        EnderecoRequest endereco
) {
    public static AlunoResponse fromEntity(Aluno aluno) {
        EnderecoRequest enderecoDto = null;

        if (aluno.getCep() != null || aluno.getEndereco() != null) {
            enderecoDto = new EnderecoRequest(
                    aluno.getEndereco(),
                    aluno.getNumero(),
                    aluno.getComplemento(),
                    aluno.getBairro(),
                    aluno.getCidade(),
                    aluno.getEstado(),
                    aluno.getCep()
            );
        }

        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getSexo(),
                aluno.getTelefone(),
                aluno.getCelular(),
                aluno.getEmail(),
                aluno.getObservacao(),
                enderecoDto
        );
    }
}