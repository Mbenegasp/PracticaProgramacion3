package yoSolo.simulacroProgra31.lotes.mappers;

import org.mapstruct.Mapper;
import yoSolo.simulacroProgra31.estantes.model.EstanteEntity;
import yoSolo.simulacroProgra31.lotes.dtos.LoteRequest;
import yoSolo.simulacroProgra31.lotes.dtos.LoteResponse;
import yoSolo.simulacroProgra31.lotes.model.LoteEntity;
import yoSolo.simulacroProgra31.reactivos.model.ReactivoEntity;

@Mapper(componentModel = "spring", uses = {ReactivoEntity.class, EstanteEntity.class})
public interface LoteMapper {
    LoteEntity toEntity (LoteRequest request);
    LoteResponse toDto (LoteEntity entity);
}
