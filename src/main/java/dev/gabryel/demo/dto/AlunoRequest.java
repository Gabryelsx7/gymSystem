package dev.gabryel.demo.dto;

import dev.gabryel.demo.domain.Aluno;
import dev.gabryel.demo.domain.enums.Sexo;

import java.time.LocalDate;

public record AlunoRequest(
        String nome,
        LocalDate dataNascimento,
        Sexo sexo,
        String telefone,
        String celular,
        String email,
        String observacao,
        EnderecoRequest endereco
) {
    public Aluno toEntity(){
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    public void preencher(Aluno aluno){
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);

        if (endereco != null) {
        aluno.setEndereco(endereco.endereco());
        aluno.setNumero(endereco.numero());
        aluno.setComplemento(endereco.complemento());
        aluno.setBairro(endereco.bairro());
        aluno.setCidade(endereco.cidade());
        aluno.setEstado(endereco.estado());
        aluno.setCep(endereco.cep());
    }
    }
}
