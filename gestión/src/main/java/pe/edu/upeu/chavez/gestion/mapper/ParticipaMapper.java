package pe.edu.upeu.chavez.gestion.mapper;

import pe.edu.upeu.chavez.gestion.dto.ParticipaDTO;
import pe.edu.upeu.chavez.gestion.entity.Participa;

public class ParticipaMapper {
    public static ParticipaDTO toDTO(Participa p) {
        return new ParticipaDTO(p.getId(), p.getProyecto().getId(), p.getColaborador().getId());
    }
    public static Participa toEntity(ParticipaDTO dto) {
        Participa p = new Participa();
        p.setId(dto.getId());
        return p;
    }
}
