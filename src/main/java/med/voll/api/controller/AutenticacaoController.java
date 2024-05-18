package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.DTO.UsuarioJPA;
import med.voll.api.config.TokenService;
import med.voll.api.model.DadosAutenticacao;
import med.voll.api.model.DadosTokenJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authent = manager.authenticate(authToken);
        var token = tokenService.gerarToken((UsuarioJPA) authent.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(token));
    }
}
