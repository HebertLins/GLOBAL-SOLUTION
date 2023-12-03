package br.com.fiap.global.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.global.model.Usuario.Paciente;
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
@Table(name = "TB_LEMBRETE")
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LEMBRETE")
    @SequenceGenerator(name = "SQ_LEMBRETE", sequenceName = "SQ_LEMBRETE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_LEMBRETE")
    private Long id_lembrete;

    @Column(name = "CONTEUDO_LEMBRETE")
    private String conteudo_lembrete;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
            name = "PACIENTE",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "FK_TB_LEMBRETE_PACIENTE")
    )
    private Paciente paciente;
}
