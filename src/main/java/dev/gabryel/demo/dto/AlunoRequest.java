package dev.gabryel.demo.dto;

import dev.gabryel.demo.domain.Aluno;
import dev.gabryel.demo.domain.enums.Sexo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 150, message = "O nome deve tere no máximo 150 caracteres.")
        String nome,

        @Past(message = "A data de nascimento deve estar no passado.")
        LocalDate dataNascimento,

        @Size(max = 1 ,message = "O sexo deve ter apenas 1 caractere.")
        Sexo sexo,

        @Size(max = 30 ,message = "O telefone deve ter no maximo 30 caractere.")
        String telefone,

        @Size(max = 30 ,message = "O celular deve ter no maximo 30 caractere.")
        String celular,

        @Email(message = "E-mail inválido")
        @Size(max = 150,message = "O email deve ter no maximo 150 caracteres")
        String email,

        String observacao,

        @Valid
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
