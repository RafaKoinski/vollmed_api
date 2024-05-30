package med.voll.api.repository;

import med.voll.api.DTO.ConsultaJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<ConsultaJPA, Long> {
}
