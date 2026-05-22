package yoSolo.simulacroProgra31.reactivos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import yoSolo.simulacroProgra31.reactivos.model.ReactivoEntity;

@Repository
public interface ReactivoRepository extends JpaRepository<ReactivoEntity, Integer>, JpaSpecificationExecutor<ReactivoEntity> {
}
