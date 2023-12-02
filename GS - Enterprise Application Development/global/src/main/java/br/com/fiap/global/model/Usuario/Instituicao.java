package br.com.fiap.global.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "TB_INSTITUICAO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_INS_CNPJ", columnNames = "CNPJ_INSTITUICAO")
})
@DiscriminatorValue("INSTITUICAO")
public class Instituicao extends Usuario{

    @Column(name = "CNPJ_INSTITUICAO", nullable = false)
    @NotBlank
    @Size(min = 14 ,  max = 14, message = "Um CNPJ deve conter 14 digítos")
    private String cnpj_instituicao;

}
