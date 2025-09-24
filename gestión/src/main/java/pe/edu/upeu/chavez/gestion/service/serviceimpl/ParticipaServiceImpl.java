package pe.edu.upeu.chavez.gestion.service.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.chavez.gestion.dto.ParticipaDTO;
import pe.edu.upeu.chavez.gestion.entity.Colaborador;
import pe.edu.upeu.chavez.gestion.entity.Participa;
import pe.edu.upeu.chavez.gestion.entity.Proyecto;
import pe.edu.upeu.chavez.gestion.exception.ResourceNotFoundException;
import pe.edu.upeu.chavez.gestion.mapper.ParticipaMapper;
import pe.edu.upeu.chavez.gestion.repository.ColaboradorRepository;
import pe.edu.upeu.chavez.gestion.repository.ParticipaRepository;
import pe.edu.upeu.chavez.gestion.repository.ProyectoRepository;
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
        Proyecto proyecto = proyectoRepo.findById(dto.getProyectoId())
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado"));
        Colaborador colaborador = colaboradorRepo.findById(dto.getColaboradorId())
                .orElseThrow(() -> new ResourceNotFoundException("Colaborador no encontrado"));
        Participa p = ParticipaMapper.toEntity(dto);
        p.setProyecto(proyecto);
        p.setColaborador(colaborador);
        return ParticipaMapper.toDTO(repo.save(p));
    }

    @Override
    public ParticipaDTO actualizar(Long id, ParticipaDTO dto) {
        Participa p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Participación no encontrada"));
        Proyecto proyecto = proyectoRepo.findById(dto.getProyectoId())
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado"));
        Colaborador colaborador = colaboradorRepo.findById(dto.getColaboradorId())
                .orElseThrow(() -> new ResourceNotFoundException("Colaborador no encontrado"));
        p.setProyecto(proyecto);
        p.setColaborador(colaborador);
        return ParticipaMapper.toDTO(repo.save(p));
    }

    @Override
    public ParticipaDTO buscarPorId(Long id) {
        return repo.findById(id).map(ParticipaMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Participación no encontrada"));
    }

    @Override
    public List<ParticipaDTO> listar() {
        return repo.findAll().stream().map(ParticipaMapper::toDTO).toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Participación no encontrada");
        repo.deleteById(id);
    }
}
