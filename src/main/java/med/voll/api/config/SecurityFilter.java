package med.voll.api.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private  TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recuperaToken(request);
        var subjeto = tokenService.getSubject(token);
        System.out.println(subjeto);

        filterChain.doFilter(request, response);
    }

    private String recuperaToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null){
            throw new RuntimeException("Token não enviado no cabeçalho");
        }
        return authHeader.replace("Bearer ", "");
    }
}
