package pe.edu.upeu.chavez.gestion.mapper;

import pe.edu.upeu.chavez.gestion.dto.ProyectoDTO;
import pe.edu.upeu.chavez.gestion.entity.Proyecto;
import java.math.BigDecimal; // Agregar este import

public class ProyectoMapper {

    public static ProyectoDTO toDTO(Proyecto entity) {
        if (entity == null) return null;

        ProyectoDTO dto = new ProyectoDTO();
        dto.setIdProyecto(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setCuantia(entity.getCuantia()); // Ya es BigDecimal
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());

        if (entity.getCliente() != null) {
            dto.setCliente(ClienteMapper.toDTO(entity.getCliente()));
        }

        return dto;
    }

    public static Proyecto toEntity(ProyectoDTO dto) {
        if (dto == null) return null;

        Proyecto entity = new Proyecto();
        entity.setId(dto.getIdProyecto());
        entity.setDescripcion(dto.getDescripcion());
        entity.setCuantia(dto.getCuantia());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        return entity;
    }
}