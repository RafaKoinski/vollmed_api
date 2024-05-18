package med.voll.api.repository;

import med.voll.api.DTO.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<UsuarioJPA, Long> {
    UserDetails findByLogin(String login);
}
