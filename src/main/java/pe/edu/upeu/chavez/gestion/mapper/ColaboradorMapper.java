package pe.edu.upeu.chavez.gestion.mapper;

import pe.edu.upeu.chavez.gestion.dto.ColaboradorDTO;
import pe.edu.upeu.chavez.gestion.entity.Colaborador;

public class ColaboradorMapper {

    public static ColaboradorDTO toDTO(Colaborador entity) {
        if (entity == null) return null;

        ColaboradorDTO dto = new ColaboradorDTO();
        dto.setIdColaborador(entity.getId());
        dto.setNif(entity.getNif());
        dto.setNombre(entity.getNombre());
        dto.setDomicilio(entity.getDomicilio());
        dto.setTelefono(entity.getTelefono());
        dto.setBanco(entity.getBanco());
        dto.setNumCuenta(entity.getNumCuenta());
        return dto;
    }

    public static Colaborador toEntity(ColaboradorDTO dto) {
        if (dto == null) return null;

        Colaborador entity = new Colaborador();
        entity.setId(dto.getIdColaborador());
        entity.setNif(dto.getNif());
        entity.setNombre(dto.getNombre());
        entity.setDomicilio(dto.getDomicilio());
        entity.setTelefono(dto.getTelefono());
        entity.setBanco(dto.getBanco());
        entity.setNumCuenta(dto.getNumCuenta());
        return entity;
    }
}