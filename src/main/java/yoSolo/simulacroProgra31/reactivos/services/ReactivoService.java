package yoSolo.simulacroProgra31.reactivos.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yoSolo.simulacroProgra31.exceptions.RecursoNoEncontradoException;
import yoSolo.simulacroProgra31.lotes.services.LoteService;
import yoSolo.simulacroProgra31.reactivos.dtos.ReactivoRequest;
import yoSolo.simulacroProgra31.reactivos.dtos.ReactivoResponse;
import yoSolo.simulacroProgra31.reactivos.mappers.ReactivoMapper;
import yoSolo.simulacroProgra31.reactivos.model.ReactivoEntity;
import yoSolo.simulacroProgra31.reactivos.repository.ReactivoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReactivoService {
    private final ReactivoRepository reactivoRepository;
    private final ReactivoMapper reactivoMapper;

    private final LoteService loteService;

    @Transactional
    public ReactivoResponse crearReactivo(ReactivoRequest request){
        return reactivoMapper.toDto(reactivoRepository.save(reactivoMapper.toEntity(request)));
    }

    @Transactional
    public void eliminarReactivo(Integer id){
        if (!loteService.loteActivo(id)){
            reactivoRepository.deleteById(id);
        }
    }

    @Transactional(readOnly = true)
    public ReactivoEntity findEntityById(Integer id){
        return reactivoRepository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException(("El reactivo de id "+id+"no existe")));
    }

    @Transactional
    public ReactivoResponse modificarReactivo(Integer id, ReactivoRequest request){
        ReactivoEntity entity = reactivoRepository.findById(id)
                .orElseThrow( () -> new RecursoNoEncontradoException("El reactivo de id "+ id + "no fue encontrado"));
        entity.setNombre(request.getNombre());
        entity.setNivelPeligro(request.getNivelPeligro());
        entity.setEsPrecursorQuimico(request.getEsPrecursorQuimico());
        return reactivoMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ReactivoResponse> listarReactivos (String nombre, Integer nivelPeligro, Boolean esPrecursorQuimico){
        Specification<ReactivoEntity> spec = Specification.where(null);
        if (nombre != null){
            spec = spec.and ((root, query, cb) -> cb.like(root.get("nombre"), "%" + nombre + "%"));
        }
        if (nivelPeligro != null){
            spec = spec.and((root, query, cb) -> cb.equal(root.get("nivelPeligro"), nivelPeligro));
        }
        if (esPrecursorQuimico != null){
            spec = spec.and((root, query, cb)-> cb.equal(root.get("esPrecursorQuimico"), esPrecursorQuimico));
        }
        return reactivoRepository.findAll(spec).stream()
                .map(reactivoMapper::toDto)
                .toList();
    }
}
