package pe.edu.upeu.chavez.gestion.mapper;

import pe.edu.upeu.chavez.gestion.dto.ClienteDTO;
import pe.edu.upeu.chavez.gestion.entity.Cliente;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente entity) {
        if (entity == null) return null;

        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(entity.getId());
        dto.setTelefono(entity.getTelefono());
        dto.setDomicilio(entity.getDomicilio());
        dto.setRazonSocial(entity.getRazonSocial());
        return dto;
    }

    public static Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;

        Cliente entity = new Cliente();
        entity.setId(dto.getIdCliente());
        entity.setTelefono(dto.getTelefono());
        entity.setDomicilio(dto.getDomicilio());
        entity.setRazonSocial(dto.getRazonSocial());
        return entity;
    }
}