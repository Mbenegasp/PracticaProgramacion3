package yoSolo.simulacroProgra31.lotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoSolo.simulacroProgra31.lotes.model.LoteEntity;

import java.time.LocalDate;
import java.util.List;

public interface LoteRepository extends JpaRepository<LoteEntity, Integer> {
    Boolean existsByIdAndfechaVencimientoBeforeAndCantidadKgGreaterThan(Integer id, LocalDate fechaVencimiento, Double cantidad);
    List<LoteEntity> findByEstanteId(Integer id);
}
