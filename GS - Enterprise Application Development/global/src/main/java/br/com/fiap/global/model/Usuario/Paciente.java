package br.com.fiap.global.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.fiap.global.model.Comprovante;
import br.com.fiap.global.model.Exame;
import br.com.fiap.global.model.Lembrete;
import br.com.fiap.global.validation.SexoPaciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PACIENTE", uniqueConstraints = {
        @UniqueConstraint(name = "UK_PAC_CPF", columnNames = "CPF_PACIENTE")
})
@DiscriminatorValue("PACIENTE")
public class Paciente extends Usuario {

    @Column(name = "CPF_PACIENTE", nullable = false)
    @NotBlank
    @Size(min = 11 ,  max = 11, message = "Um CPF deve conter 11 digítos")
    private String cpf_paciente;

    @Column(name = "IDADE_PACIENTE")
    private String idade_paciente;

    @SexoPaciente
    @Column(name = "SEXO_PACIENTE")
    private String sexo_paciente;

}
