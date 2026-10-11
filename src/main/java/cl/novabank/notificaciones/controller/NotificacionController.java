package cl.novabank.notificaciones.controller;

import cl.novabank.notificaciones.model.Notificacion;
import cl.novabank.notificaciones.service.NotificacionService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @PostMapping("/enviar")
    public ResponseEntity<Notificacion> enviar(@Valid @RequestBody Notificacion notificacion) {
        Notificacion creada = notificacionService.enviarNotificacion(notificacion);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Notificacion>> listarTodas() {
        return ResponseEntity.ok(notificacionService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> obtenerPorId(@PathVariable Long id) {
        Notificacion notificacion = notificacionService.obtenerPorId(id);
        if (notificacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notificacion);
    }

    @GetMapping("/destinatario/{rut}")
    public ResponseEntity<List<Notificacion>> listarPorDestinatario(@PathVariable String rut) {
        return ResponseEntity.ok(notificacionService.listarPorRutDestinatario(rut));
    }
}
