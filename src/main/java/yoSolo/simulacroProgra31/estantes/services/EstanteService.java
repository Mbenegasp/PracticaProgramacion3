package yoSolo.simulacroProgra31.estantes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yoSolo.simulacroProgra31.estantes.mappers.EstanteMapper;
import yoSolo.simulacroProgra31.estantes.model.EstanteEntity;
import yoSolo.simulacroProgra31.estantes.repository.EstanteRepository;
import yoSolo.simulacroProgra31.exceptions.RecursoNoEncontradoException;

@Service
@RequiredArgsConstructor
public class EstanteService {
    private final EstanteRepository estanteRepository;
    private final EstanteMapper estanteMapper;

    @Transactional(readOnly = true)
    public EstanteEntity findEntityById(Integer id){
        return estanteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("El estante de id" +id+ "no existe"));
    }

}
