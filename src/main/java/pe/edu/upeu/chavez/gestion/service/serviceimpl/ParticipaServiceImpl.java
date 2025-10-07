package pe.edu.upeu.chavez.gestion.service.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.chavez.gestion.dto.ParticipaDTO;
import pe.edu.upeu.chavez.gestion.entity.Participa;
import pe.edu.upeu.chavez.gestion.entity.Proyecto;
import pe.edu.upeu.chavez.gestion.entity.Colaborador;
import pe.edu.upeu.chavez.gestion.exception.ResourceNotFoundException;
import pe.edu.upeu.chavez.gestion.mapper.ParticipaMapper;
import pe.edu.upeu.chavez.gestion.repository.ParticipaRepository;
import pe.edu.upeu.chavez.gestion.repository.ProyectoRepository;
import pe.edu.upeu.chavez.gestion.repository.ColaboradorRepository;
import pe.edu.upeu.chavez.gestion.service.ParticipaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipaServiceImpl implements ParticipaService {

    private final ParticipaRepository repo;
    private final ProyectoRepository proyectoRepo;
    private final ColaboradorRepository colaboradorRepo;

    @Override
    public ParticipaDTO crear(ParticipaDTO dto) {
        if (dto.getProyecto() == null || dto.getProyecto().getIdProyecto() == null)
            throw new IllegalArgumentException("Participa debe tener proyecto.id");
        if (dto.getColaborador() == null || dto.getColaborador().getIdColaborador() == null)
            throw new IllegalArgumentException("Participa debe tener colaborador.id");

        Proyecto proyecto = proyectoRepo.findById(dto.getProyecto().getIdProyecto())
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado: " + dto.getProyecto().getIdProyecto()));

        Colaborador colaborador = colaboradorRepo.findById(dto.getColaborador().getIdColaborador())
                .orElseThrow(() -> new ResourceNotFoundException("Colaborador no encontrado: " + dto.getColaborador().getIdColaborador()));

        Participa p = Participa.builder()
                .proyecto(proyecto)
                .colaborador(colaborador)
                .build();

        return ParticipaMapper.toDTO(repo.save(p));
    }

    @Override
    public ParticipaDTO actualizar(Long id, ParticipaDTO dto) {
        Participa p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Participa no encontrado: " + id));
        if (dto.getProyecto() != null && dto.getProyecto().getIdProyecto() != null) {
            Proyecto proyecto = proyectoRepo.findById(dto.getProyecto().getIdProyecto())
                    .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado: " + dto.getProyecto().getIdProyecto()));
            p.setProyecto(proyecto);
        }
        if (dto.getColaborador() != null && dto.getColaborador().getIdColaborador() != null) {
            Colaborador colaborador = colaboradorRepo.findById(dto.getColaborador().getIdColaborador())
                    .orElseThrow(() -> new ResourceNotFoundException("Colaborador no encontrado: " + dto.getColaborador().getIdColaborador()));
            p.setColaborador(colaborador);
        }
        return ParticipaMapper.toDTO(repo.save(p));
    }

    @Override
    public ParticipaDTO buscarPorId(Long id) {
        return repo.findById(id).map(ParticipaMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Participa no encontrado: " + id));
    }

    @Override
    public List<ParticipaDTO> listar() {
        return repo.findAll().stream().map(ParticipaMapper::toDTO).toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Participa no encontrado: " + id);
        repo.deleteById(id);
    }
}
