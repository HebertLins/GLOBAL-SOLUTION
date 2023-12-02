package br.com.fiap.global.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.global.model.Usuario.Paciente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_COMPROVANTE")
public class Comprovante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COMPROVANTE")
    @SequenceGenerator(name = "SQ_COMPROVANTE", sequenceName = "SQ_COMPROVANTE", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_COMPROVANTE")
    private Long id_comprovante;

    @Column(name = "DATAPLI_COMPROVANTE")
    @PastOrPresent
    private LocalDate data_aplicacao_comprovante;
    
    @Column(name = "LOTE_COMPROVANTE")
    private String lote_comprovante;

    @Column(name = "NOME_FABRICANTE")
    private String nome_fabricante;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PACIENTE",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "FK_TB_COMPROVANTE_PACIENTE")
    )
    private Paciente paciente;

}
