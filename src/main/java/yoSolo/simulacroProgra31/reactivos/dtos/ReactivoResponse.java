package yoSolo.simulacroProgra31.reactivos.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactivoResponse {
    private Integer id;
    private String nombre;
    private Integer nivelPeligro;
    private Boolean esPrecursorQuimico;
    private Boolean activo;
}
