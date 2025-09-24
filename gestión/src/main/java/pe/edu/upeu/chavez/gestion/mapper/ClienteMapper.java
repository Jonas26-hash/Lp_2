package pe.edu.upeu.chavez.gestion.mapper;

import pe.edu.upeu.chavez.gestion.dto.ClienteDTO;
import pe.edu.upeu.chavez.gestion.entity.Cliente;

public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente e) {
        return new ClienteDTO(e.getId(), e.getTelefono(), e.getDomicilio(), e.getRazonSocial());
    }
    public static Cliente toEntity(ClienteDTO dto) {
        return new Cliente(dto.getId(), dto.getTelefono(), dto.getDomicilio(), dto.getRazonSocial(), null);
    }
}
