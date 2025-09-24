package pe.edu.upeu.chavez.gestion.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PARTICIPA")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Participa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARTICIPA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO", nullable = false)
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "ID_COLABORADOR", nullable = false)
    private Colaborador colaborador;
}
