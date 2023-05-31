package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.Usuario;
import med.voll.api.dto.DadosAutenticacao;
import med.voll.api.dto.DadoTokenJWT;
import med.voll.api.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private AuthenticationManager manager;

    private TokenService service;

    public AutenticacaoController(AuthenticationManager manager, TokenService service) {
        this.manager = manager;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity logar(@RequestBody @Valid DadosAutenticacao dados) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = service.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadoTokenJWT(tokenJWT));
    }
}
