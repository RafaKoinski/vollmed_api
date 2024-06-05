package med.voll.api.repository;

import io.micrometer.observation.ObservationFilter;
import med.voll.api.DTO.MedicoJPA;
import med.voll.api.model.Especialidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<MedicoJPA, Long> {
    Page<MedicoJPA> findAllByAtivoTrue(Pageable pag);
    @Query("""
            select m from Medicos m
            where
            m.ativo = true
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consultas c
                where
                c.data = :data
            )
            order by rand()
            limit 1                        
            """)
    MedicoJPA escolherAleatMedicoLivreData(Especialidade especialidade, LocalDateTime data);
}
