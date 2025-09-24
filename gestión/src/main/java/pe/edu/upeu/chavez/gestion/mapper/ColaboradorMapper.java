package pe.edu.upeu.chavez.gestion.mapper;

import pe.edu.upeu.chavez.gestion.dto.ColaboradorDTO;
import pe.edu.upeu.chavez.gestion.entity.Colaborador;

public class ColaboradorMapper {
    public static ColaboradorDTO toDTO(Colaborador c) {
        return new ColaboradorDTO(c.getId(), c.getNif(), c.getNombre(), c.getDomicilio(), c.getTelefono(), c.getBanco(), c.getNumCuenta());
    }
    public static Colaborador toEntity(ColaboradorDTO dto) {
        return new Colaborador(dto.getId(), dto.getNif(), dto.getNombre(), dto.getDomicilio(), dto.getTelefono(), dto.getBanco(), dto.getNumCuenta(), null);
    }
}
