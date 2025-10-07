package pe.edu.upeu.chavez.gestion.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "CLIENTES")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "DOMICILIO")
    private String domicilio;

    @Column(name = "RAZON_SOCIAL", nullable = false)
    private String razonSocial;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Proyecto> proyectos;
}
