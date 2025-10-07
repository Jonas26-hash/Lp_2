package pe.edu.upeu.chavez.gestion.service;

import pe.edu.upeu.chavez.gestion.dto.ProyectoDTO;
import java.util.List;

public interface ProyectoService {
    ProyectoDTO crear(ProyectoDTO dto);
    ProyectoDTO actualizar(Long id, ProyectoDTO dto);
    ProyectoDTO buscarPorId(Long id);
    List<ProyectoDTO> listar();
    void eliminar(Long id);
}
