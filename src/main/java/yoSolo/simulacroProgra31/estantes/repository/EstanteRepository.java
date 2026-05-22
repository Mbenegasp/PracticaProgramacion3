package yoSolo.simulacroProgra31.estantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoSolo.simulacroProgra31.estantes.model.EstanteEntity;

public interface EstanteRepository extends JpaRepository<EstanteEntity, Integer> {
}
