package pe.edu.upeu.chavez.gestion.service;

import pe.edu.upeu.chavez.gestion.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {
    ClienteDTO crear(ClienteDTO dto);
    ClienteDTO actualizar(Long id, ClienteDTO dto);
    ClienteDTO buscarPorId(Long id);
    List<ClienteDTO> listar();
    void eliminar(Long id);
}
