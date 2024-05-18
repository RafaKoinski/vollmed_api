package med.voll.api.repository;

import io.micrometer.observation.ObservationFilter;
import med.voll.api.DTO.PacienteJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteJPA, Long> {
    Page<PacienteJPA> findAllByAtivoTrue(Pageable pag);
}
