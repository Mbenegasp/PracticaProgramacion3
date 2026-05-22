package yoSolo.simulacroProgra31.lotes.dtos;

import lombok.*;
import yoSolo.simulacroProgra31.estantes.model.EstanteEntity;
import yoSolo.simulacroProgra31.reactivos.model.ReactivoEntity;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoteResponse {
    private Integer id;
    private String nroLote;
    private LocalDate fechaRecepcion;
    private LocalDate fechaVencimiento;
    private Double cantidadKg;
    private ReactivoEntity reactivo;
    private EstanteEntity estante;
}
