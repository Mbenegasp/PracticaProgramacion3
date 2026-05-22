package yoSolo.simulacroProgra31.reactivos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactivoRequest {
    @NotBlank
    private String nombre;
    @PositiveOrZero
    private Integer nivelPeligro;
    @NotNull
    private Boolean esPrecursorQuimico;
}
