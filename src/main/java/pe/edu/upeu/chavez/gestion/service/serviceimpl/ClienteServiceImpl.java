package pe.edu.upeu.chavez.gestion.service.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.chavez.gestion.dto.ClienteDTO;
import pe.edu.upeu.chavez.gestion.entity.Cliente;
import pe.edu.upeu.chavez.gestion.exception.ResourceNotFoundException;
import pe.edu.upeu.chavez.gestion.mapper.ClienteMapper;
import pe.edu.upeu.chavez.gestion.repository.ClienteRepository;
import pe.edu.upeu.chavez.gestion.service.ClienteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repo;

    @Override
    public ClienteDTO crear(ClienteDTO dto) {
        Cliente entity = Cliente.builder()
                .telefono(dto.getTelefono())
                .domicilio(dto.getDomicilio())
                .razonSocial(dto.getRazonSocial())
                .build();
        return ClienteMapper.toDTO(repo.save(entity));
    }

    @Override
    public ClienteDTO actualizar(Long id, ClienteDTO dto) {
        Cliente c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + id));
        c.setTelefono(dto.getTelefono());
        c.setDomicilio(dto.getDomicilio());
        c.setRazonSocial(dto.getRazonSocial());
        return ClienteMapper.toDTO(repo.save(c));
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        return repo.findById(id).map(ClienteMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + id));
    }

    @Override
    public List<ClienteDTO> listar() {
        return repo.findAll().stream().map(ClienteMapper::toDTO).toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Cliente no encontrado: " + id);
        repo.deleteById(id);
    }
}
