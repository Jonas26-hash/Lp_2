package pe.edu.upeu.chavez.gestion.service;

import pe.edu.upeu.chavez.gestion.dto.ColaboradorDTO;
import java.util.List;

public interface ColaboradorService {
    ColaboradorDTO crear(ColaboradorDTO dto);
    ColaboradorDTO actualizar(Long id, ColaboradorDTO dto);
    ColaboradorDTO buscarPorId(Long id);
    List<ColaboradorDTO> listar();
    void eliminar(Long id);
}
