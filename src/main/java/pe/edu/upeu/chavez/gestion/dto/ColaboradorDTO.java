package pe.edu.upeu.chavez.gestion.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ColaboradorDTO {
    private Long idColaborador;
    private String nif;
    private String nombre;
    private String domicilio;
    private String telefono;
    private String banco;
    private String numCuenta;
}
