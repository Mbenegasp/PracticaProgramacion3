package yoSolo.simulacroProgra31.estantes.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstanteResponse {
    private Integer id;
    private String codigoAlmacen;
    private Double capacidadMaxKg;
    private Integer riegoAcumulado;
}
