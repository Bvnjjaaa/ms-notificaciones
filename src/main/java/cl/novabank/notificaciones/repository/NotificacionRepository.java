package cl.novabank.notificaciones.repository;

import cl.novabank.notificaciones.model.Notificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    List<Notificacion> findByRutDestinatario(String rutDestinatario);

    List<Notificacion> findByCanal(String canal);

    List<Notificacion> findByEstado(String estado);
}
