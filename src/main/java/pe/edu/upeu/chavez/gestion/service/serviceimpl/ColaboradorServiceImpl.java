package pe.edu.upeu.chavez.gestion.service.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.chavez.gestion.dto.ColaboradorDTO;
import pe.edu.upeu.chavez.gestion.entity.Colaborador;
import pe.edu.upeu.chavez.gestion.exception.ResourceNotFoundException;
import pe.edu.upeu.chavez.gestion.mapper.ColaboradorMapper;
import pe.edu.upeu.chavez.gestion.repository.ColaboradorRepository;
import pe.edu.upeu.chavez.gestion.service.ColaboradorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColaboradorServiceImpl implements ColaboradorService {

    private final ColaboradorRepository repo;

    @Override
    public ColaboradorDTO crear(ColaboradorDTO dto) {
        Colaborador c = Colaborador.builder()
                .nif(dto.getNif())
                .nombre(dto.getNombre())
                .domicilio(dto.getDomicilio())
                .telefono(dto.getTelefono())
                .banco(dto.getBanco())
                .numCuenta(dto.getNumCuenta())
                .build();
        return ColaboradorMapper.toDTO(repo.save(c));
    }

    @Override
    public ColaboradorDTO actualizar(Long id, ColaboradorDTO dto) {
        Colaborador c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Colaborador no encontrado: " + id));
        c.setNif(dto.getNif());
        c.setNombre(dto.getNombre());
        c.setDomicilio(dto.getDomicilio());
        c.setTelefono(dto.getTelefono());
        c.setBanco(dto.getBanco());
        c.setNumCuenta(dto.getNumCuenta());
        return ColaboradorMapper.toDTO(repo.save(c));
    }

    @Override
    public ColaboradorDTO buscarPorId(Long id) {
        return repo.findById(id).map(ColaboradorMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Colaborador no encontrado: " + id));
    }

    @Override
    public List<ColaboradorDTO> listar() {
        return repo.findAll().stream().map(ColaboradorMapper::toDTO).toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Colaborador no encontrado: " + id);
        repo.deleteById(id);
    }
}
