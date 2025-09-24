package pe.edu.upeu.chavez.gestion.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ClienteDTO {
    private Long id;
    private String telefono;
    private String domicilio;
    private String razonSocial;
}
