package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank //Só pode usar quando não for String e ele valida se o campo está vazio e nulo
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String cpf,

        @NotNull
        @Valid //Aqui estamos passando para que possa ser validado usando o Bean Validation nesse DTO
        // que está sendo passado como endereço
        DadosEndereco endereco ){
}
