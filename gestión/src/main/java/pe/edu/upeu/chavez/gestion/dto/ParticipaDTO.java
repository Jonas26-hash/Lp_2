package pe.edu.upeu.chavez.gestion.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ParticipaDTO {
    private Long id;
    private Long proyectoId;
    private Long colaboradorId;
}
