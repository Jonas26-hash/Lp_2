package pe.edu.upeu.chavez.gestion.service;

import pe.edu.upeu.chavez.gestion.dto.ParticipaDTO;
import java.util.List;

public interface ParticipaService {
    ParticipaDTO crear(ParticipaDTO dto);
    ParticipaDTO actualizar(Long id, ParticipaDTO dto);
    ParticipaDTO buscarPorId(Long id);
    List<ParticipaDTO> listar();
    void eliminar(Long id);
}
