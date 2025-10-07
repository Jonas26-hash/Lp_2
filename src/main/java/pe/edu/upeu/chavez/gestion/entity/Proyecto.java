package pe.edu.upeu.chavez.gestion.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PROYECTOS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROYECTO")
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CUANTIA", precision = 12, scale = 2)
    private BigDecimal cuantia;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_FIN")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Participa> participaciones;
}
