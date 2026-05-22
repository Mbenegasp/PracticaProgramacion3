package yoSolo.simulacroProgra31.reactivos.mappers;

import org.mapstruct.Mapper;
import yoSolo.simulacroProgra31.reactivos.model.ReactivoEntity;
import yoSolo.simulacroProgra31.reactivos.dtos.ReactivoRequest;
import yoSolo.simulacroProgra31.reactivos.dtos.ReactivoResponse;

@Mapper(componentModel = "spring")
public interface ReactivoMapper {
    ReactivoEntity toEntity (ReactivoRequest request);
    ReactivoResponse toDto (ReactivoEntity entity);
}
