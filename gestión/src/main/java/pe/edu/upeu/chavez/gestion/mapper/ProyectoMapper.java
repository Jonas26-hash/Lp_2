package pe.edu.upeu.chavez.gestion.mapper;

import pe.edu.upeu.chavez.gestion.dto.ProyectoDTO;
import pe.edu.upeu.chavez.gestion.entity.Proyecto;

public class ProyectoMapper {

    public static ProyectoDTO toDTO(Proyecto p) {
        return new ProyectoDTO(
                p.getId(),
                p.getDescripcion(),
                p.getCuantia(),
                p.getFechaInicio(),
                p.getFechaFin(),
                p.getCliente() != null ? p.getCliente().getId() : null
        );
    }

    public static Proyecto toEntity(ProyectoDTO dto) {
        Proyecto p = new Proyecto();
        p.setId(dto.getId());
        p.setDescripcion(dto.getDescripcion());
        p.setCuantia(dto.getCuantia());
        p.setFechaInicio(dto.getFechaInicio());
        p.setFechaFin(dto.getFechaFin());
        return p;
    }
}
