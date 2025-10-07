package pe.edu.upeu.chavez.gestion.service.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.chavez.gestion.dto.ProyectoDTO;
import pe.edu.upeu.chavez.gestion.dto.ClienteDTO;
import pe.edu.upeu.chavez.gestion.entity.Cliente;
import pe.edu.upeu.chavez.gestion.entity.Proyecto;
import pe.edu.upeu.chavez.gestion.exception.ResourceNotFoundException;
import pe.edu.upeu.chavez.gestion.mapper.ProyectoMapper;
import pe.edu.upeu.chavez.gestion.repository.ClienteRepository;
import pe.edu.upeu.chavez.gestion.repository.ProyectoRepository;
import pe.edu.upeu.chavez.gestion.service.ProyectoService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository repo;
    private final ClienteRepository clienteRepo;

    @Override
    public ProyectoDTO crear(ProyectoDTO dto) {
        if (dto.getCliente() == null || dto.getCliente().getIdCliente() == null) {
            throw new IllegalArgumentException("Proyecto debe tener cliente (cliente.id).");
        }
        Cliente cliente = clienteRepo.findById(dto.getCliente().getIdCliente())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + dto.getCliente().getIdCliente()));

        Proyecto p = new Proyecto();
        p.setDescripcion(dto.getDescripcion());
        p.setCuantia(dto.getCuantia());
        p.setFechaInicio(dto.getFechaInicio());
        p.setFechaFin(dto.getFechaFin());
        p.setCliente(cliente);

        return ProyectoMapper.toDTO(repo.save(p));
    }

    @Override
    public ProyectoDTO actualizar(Long id, ProyectoDTO dto) {
        Proyecto p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado: " + id));
        p.setDescripcion(dto.getDescripcion());
        p.setCuantia(dto.getCuantia());
        p.setFechaInicio(dto.getFechaInicio());
        p.setFechaFin(dto.getFechaFin());
        if (dto.getCliente() != null && dto.getCliente().getIdCliente() != null) {
            Cliente cliente = clienteRepo.findById(dto.getCliente().getIdCliente())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + dto.getCliente().getIdCliente()));
            p.setCliente(cliente);
        }
        return ProyectoMapper.toDTO(repo.save(p));
    }
    @Override
    public ProyectoDTO buscarPorId(Long id) {
        return repo.findById(id)
                .map(ProyectoMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado: " + id));
    }

    @Override
    public List<ProyectoDTO> listar() {
        return repo.findAll().stream().map(ProyectoMapper::toDTO).toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Proyecto no encontrado: " + id);
        repo.deleteById(id);
    }
}
