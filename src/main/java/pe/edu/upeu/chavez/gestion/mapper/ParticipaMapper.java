package pe.edu.upeu.chavez.gestion.mapper;

import pe.edu.upeu.chavez.gestion.dto.ParticipaDTO;
import pe.edu.upeu.chavez.gestion.entity.Participa;

public class ParticipaMapper {

    public static ParticipaDTO toDTO(Participa entity) {
        if (entity == null) return null;

        ParticipaDTO dto = new ParticipaDTO();
        dto.setIdParticipa(entity.getId());

        if (entity.getProyecto() != null) {
            dto.setProyecto(ProyectoMapper.toDTO(entity.getProyecto()));
        }

        if (entity.getColaborador() != null) {
            dto.setColaborador(ColaboradorMapper.toDTO(entity.getColaborador()));
        }

        return dto;
    }

    public static Participa toEntity(ParticipaDTO dto) {
        if (dto == null) return null;

        Participa entity = new Participa();
        entity.setId(dto.getIdParticipa());
        return entity;
    }
}