package pe.edu.upeu.chavez.gestion.dto;

import lombok.*;
import java.util.Date;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProyectoDTO {
    private Long id;
    private String descripcion;
    private BigDecimal cuantia;
    private Date fechaInicio;
    private Date fechaFin;
    private Long clienteId;
}
