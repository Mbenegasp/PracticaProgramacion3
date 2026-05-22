package yoSolo.simulacroProgra31.lotes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yoSolo.simulacroProgra31.estantes.model.EstanteEntity;
import yoSolo.simulacroProgra31.estantes.services.EstanteService;
import yoSolo.simulacroProgra31.exceptions.RecursoNoEncontradoException;
import yoSolo.simulacroProgra31.exceptions.ReglaDeNegocioException;
import yoSolo.simulacroProgra31.lotes.dtos.LoteRequest;
import yoSolo.simulacroProgra31.lotes.dtos.LoteResponse;
import yoSolo.simulacroProgra31.lotes.mappers.LoteMapper;
import yoSolo.simulacroProgra31.lotes.model.LoteEntity;
import yoSolo.simulacroProgra31.lotes.repository.LoteRepository;
import yoSolo.simulacroProgra31.reactivos.model.ReactivoEntity;
import yoSolo.simulacroProgra31.reactivos.services.ReactivoService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LoteService {
    private final LoteRepository loteRepository;
    private final LoteMapper loteMapper;

    private final ReactivoService reactivoService;
    private final EstanteService estanteService;

    @Transactional(readOnly = true)
    public Boolean loteActivo(Integer id){
        return loteRepository.existsByIdAndfechaVencimientoBeforeAndCantidadKgGreaterThan(id, LocalDate.now(), 0.0);
    }

    @Transactional
    public LoteResponse registrarLote(LoteRequest request){
        LoteEntity lote = loteMapper.toEntity(request);
        ReactivoEntity reactivo = reactivoService.findEntityById(request.getReactivoId());
        EstanteEntity estante = estanteService.findEntityById(request.getEstanteId());
        lote.setReactivo(reactivo);
        lote.setEstante(estante);
        if (lote.getFechaVencimiento().isBefore(LocalDate.now().plusMonths(6))){
            throw new ReglaDeNegocioException("La fecha de vencimiento del lote ingresado es menor a 6 meses");
        }
        if (reactivo.getEsPrecursorQuimico() && !estante.getCodigoAlmacen().equals("SEC-01")) {
            throw new ReglaDeNegocioException("El reactivo es precursor quimico, debe ir en estante SEC-01");
        }
        LoteEntity save = loteRepository.saveAndFlush(lote);
        double peligrosidad = loteRepository.findByEstanteId(request.getEstanteId()).stream()
                .mapToDouble(x-> x.getReactivo().getNivelPeligro() * x.getCantidadKg())
                .sum();
        if (peligrosidad > estante.getRiesgoLimite()){
            throw new ReglaDeNegocioException("Con el ingreso del lote el estante superaria su riego limite");
        }
        return loteMapper.toDto(save);
    }

    @Transactional
    public LoteResponse modificarLote(Integer id, LoteRequest request){
        LoteEntity lote = loteRepository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("El lote de id "+id+" no existe"));
        lote.setNroLote(request.getNroLote());
        if (lote.getFechaVencimiento().isBefore(LocalDate.now().plusMonths(6))){
            throw new ReglaDeNegocioException("La fecha modificada es menor a 6 meses");
        }
        lote.setFechaVencimiento(request.getFechaVencimiento());
        lote.setReactivo(reactivoService.findEntityById(request.getReactivoId()));
        lote.setEstante(estanteService.findEntityById(request.getEstanteId()));
        if(lote.getReactivo().getEsPrecursorQuimico() && lote.getEstante().getCodigoAlmacen().equals("SEC-01")){
            throw new ReglaDeNegocioException ("El reactivo es precursorquimico, debe ir en estante SEC-01");
        }
        double peligrosidad = loteRepository.findByEstanteId(lote.getEstante().getId()).stream()
                .mapToDouble(x-> x.getReactivo().getNivelPeligro() * x.getCantidadKg())
                .sum();
        if (peligrosidad > lote.getEstante().getRiesgoLimite();
    }



}
