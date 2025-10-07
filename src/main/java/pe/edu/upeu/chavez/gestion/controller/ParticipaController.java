package pe.edu.upeu.chavez.gestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.chavez.gestion.dto.ParticipaDTO;
import pe.edu.upeu.chavez.gestion.service.ParticipaService;

import java.util.List;

@RestController
@RequestMapping("/participa")
@RequiredArgsConstructor
public class ParticipaController {

    private final ParticipaService service;

    @PostMapping
    public ResponseEntity<ParticipaDTO> crear(@RequestBody ParticipaDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<ParticipaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipaDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipaDTO> actualizar(@PathVariable Long id, @RequestBody ParticipaDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
