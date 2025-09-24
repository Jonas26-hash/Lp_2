package pe.edu.upeu.chavez.gestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.chavez.gestion.dto.ColaboradorDTO;
import pe.edu.upeu.chavez.gestion.service.ColaboradorService;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {
    private final ColaboradorService service;

    @PostMapping
    public ResponseEntity<ColaboradorDTO> crear(@RequestBody ColaboradorDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> actualizar(@PathVariable Long id, @RequestBody ColaboradorDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
