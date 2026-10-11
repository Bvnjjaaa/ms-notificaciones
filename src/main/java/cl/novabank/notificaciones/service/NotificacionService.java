package cl.novabank.notificaciones.service;

import cl.novabank.notificaciones.model.Notificacion;
import cl.novabank.notificaciones.repository.NotificacionRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    private static final String ESTADO_ENVIADO = "ENVIADO";

    private final NotificacionRepository notificacionRepository;

    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public Notificacion enviarNotificacion(Notificacion notificacion) {
        notificacion.setId(null);
        notificacion.setFechaEnvio(LocalDateTime.now());
        notificacion.setEstado(ESTADO_ENVIADO);
        return notificacionRepository.save(notificacion);
    }

    public Notificacion obtenerPorId(Long id) {
        return notificacionRepository.findById(id).orElse(null);
    }

    public List<Notificacion> listarPorRutDestinatario(String rutDestinatario) {
        return notificacionRepository.findByRutDestinatario(rutDestinatario);
    }

    public List<Notificacion> listarTodas() {
        return notificacionRepository.findAll();
    }
}
