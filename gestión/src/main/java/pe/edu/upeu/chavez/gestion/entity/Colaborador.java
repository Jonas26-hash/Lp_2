package pe.edu.upeu.chavez.gestion.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "COLABORADORES")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COLABORADOR")
    private Long id;

    @Column(name = "NIF", nullable = false, unique = true)
    private String nif;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DOMICILIO")
    private String domicilio;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "BANCO")
    private String banco;

    @Column(name = "NUM_CUENTA")
    private String numCuenta;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Participa> participaciones;
}
