package yoSolo.simulacroProgra31.lotes.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoteRequest {
    @NotBlank
    private String nroLote;
    @Future
    private LocalDate fechaVencimiento;
    @PositiveOrZero
    private double cantidadKg;
    @NotNull
    private Integer reactivoId;
    @NotNull
    private Integer estanteId;
}
