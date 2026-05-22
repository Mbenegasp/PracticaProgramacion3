package yoSolo.simulacroProgra31.estantes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstanteRequest {
    @NotBlank
    private String codigoAlmacen;
    @PositiveOrZero
    private Double capacidadMaxKg;
    @PositiveOrZero
    private Integer riegoLimite;
}
