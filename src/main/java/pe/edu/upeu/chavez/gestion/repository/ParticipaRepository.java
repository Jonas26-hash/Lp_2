package pe.edu.upeu.chavez.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.chavez.gestion.entity.Participa;

@Repository
public interface ParticipaRepository extends JpaRepository<Participa, Long> {
}
