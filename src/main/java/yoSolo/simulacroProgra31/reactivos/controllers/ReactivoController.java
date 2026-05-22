package yoSolo.simulacroProgra31.reactivos.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoSolo.simulacroProgra31.reactivos.dtos.ReactivoRequest;
import yoSolo.simulacroProgra31.reactivos.dtos.ReactivoResponse;
import yoSolo.simulacroProgra31.reactivos.services.ReactivoService;

import java.util.List;

@RestController
@RequestMapping("/api/reactivos")
@RequiredArgsConstructor
public class ReactivoController {
    private final ReactivoService reactivoService;

    @PostMapping
    public ResponseEntity<ReactivoResponse> registrarReactivo(@Valid @RequestBody ReactivoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(reactivoService.crearReactivo(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReactivoResponse> modificarReactivo(@PathVariable Integer id,
                                                              @Valid @RequestBody ReactivoRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(reactivoService.modificarReactivo(id,request));
    }

    @GetMapping
    public ResponseEntity<List<ReactivoResponse>> obtenerReactivos(@RequestParam(required = false) String nombre,
                                                                   @RequestParam(required = false) Integer nivelPeligro,
                                                                   @RequestParam(required = false) Boolean esPrecursorQuimico){
        return ResponseEntity.status(HttpStatus.OK).body(reactivoService.listarReactivos(nombre,nivelPeligro,esPrecursorQuimico));
    }
}
