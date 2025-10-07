package pe.edu.upeu.chavez.gestion.dto;


import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ParticipaDTO {
    private Long idParticipa;
    private ProyectoDTO proyecto;
    private ColaboradorDTO colaborador;
}
