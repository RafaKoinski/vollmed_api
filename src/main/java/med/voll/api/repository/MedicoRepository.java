package med.voll.api.repository;

import io.micrometer.observation.ObservationFilter;
import med.voll.api.DTO.MedicoJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoJPA, Long> {
    Page<MedicoJPA> findAllByAtivoTrue(Pageable pag);
}
