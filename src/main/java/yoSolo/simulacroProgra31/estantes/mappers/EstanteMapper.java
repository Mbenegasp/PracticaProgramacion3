package yoSolo.simulacroProgra31.estantes.mappers;

import org.mapstruct.Mapper;
import yoSolo.simulacroProgra31.estantes.dtos.EstanteRequest;
import yoSolo.simulacroProgra31.estantes.dtos.EstanteResponse;
import yoSolo.simulacroProgra31.estantes.model.EstanteEntity;

@Mapper(componentModel = "spring")
public interface EstanteMapper {
    EstanteEntity toEntity(EstanteRequest request);
    EstanteResponse toResponse(EstanteEntity entity);
}
