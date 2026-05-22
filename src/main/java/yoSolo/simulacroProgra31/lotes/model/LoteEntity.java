package yoSolo.simulacroProgra31.lotes.model;

import jakarta.persistence.*;
import lombok.*;
import yoSolo.simulacroProgra31.estantes.model.EstanteEntity;
import yoSolo.simulacroProgra31.reactivos.model.ReactivoEntity;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class LoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "lote_id")
    private Integer id;
    @Column(name = "nro_lote", nullable = false)
    private String nroLote;
    @Column(name="fecha_recepcion", nullable = false)
    private LocalDate fechaRecepcion;
    @Column(name="fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;
    @Column(name="cantidad_kg", nullable = false)
    private Double cantidadKg;
    @ManyToOne
    @JoinColumn(name="reactivo_id", nullable = false)
    private ReactivoEntity reactivo;
    @ManyToOne
    @JoinColumn(name="estante_id", nullable = false)
    private EstanteEntity estante;

    @PrePersist
    protected void onCreate(){
        this.fechaRecepcion = LocalDate.now();
    }
}
