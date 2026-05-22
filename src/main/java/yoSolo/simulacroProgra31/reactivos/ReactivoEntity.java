package yoSolo.simulacroProgra31.reactivos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reactivos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class ReactivoEntity {
    @EqualsAndHashCode.Include
    @Column(name = "reactivo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "nivel_peligro", nullable = false)
    private Integer nivelPeligro;
    @Column(name = "es_precursor_quimico", nullable = false)
    private Boolean esPrecursorQuimico;
    @Column(name = "activo", nullable = false)
    private Boolean activo;
}
