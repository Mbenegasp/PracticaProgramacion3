package yoSolo.simulacroProgra31.estantes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estantes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class EstanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estante_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "codigo_almacen", nullable = false)
    private String codigoAlmacen;
    @Column(name ="capacidad_max_kg", nullable = false)
    private Double capacidadMaxKg;
    @Column(name = "riesgo_limite", nullable = false)
    private Integer riesgoLimite;
}
