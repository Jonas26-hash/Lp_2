package pe.edu.upeu.chavez.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.chavez.gestion.entity.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
