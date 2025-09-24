package pe.edu.upeu.chavez.gestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.chavez.gestion.dto.ProyectoDTO;
import pe.edu.upeu.chavez.gestion.service.ProyectoService;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@RequiredArgsConstructor
public class ProyectoController {
    private final ProyectoService service;

    @PostMapping
    public ResponseEntity<ProyectoDTO> crear(@RequestBody ProyectoDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO> actualizar(@PathVariable Long id, @RequestBody ProyectoDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
