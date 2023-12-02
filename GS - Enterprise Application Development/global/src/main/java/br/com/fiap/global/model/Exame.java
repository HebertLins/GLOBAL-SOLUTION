package br.com.fiap.global.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.global.model.Usuario.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_EXAME")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EXAME")
    @SequenceGenerator(name = "SQ_EXAME", sequenceName = "SQ_EXAME", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_EXAME")
    private Long id_exame;

    @Column(name = "DATA_EXAME")
    @PastOrPresent
    private LocalDate data_exame;

    @Column(name = "TIPO_EXAME")
    private String tipo_exame;

    @Column(name = "CRM_MEDICO_EXAME", nullable = false)
    private String crm_medico_exame;

    @Column(name = "DESCRICAO_EXAME")
    private String descricao_exame;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PACIENTE",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "FK_TB_EXAME_PACIENTE")
    )
    private Paciente paciente;

}
