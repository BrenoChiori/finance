package com.finance.auth.resource;

import com.finance.auth.dto.CadastroDTO;
import com.finance.auth.dto.LoginDTO;
import com.finance.auth.dto.UsuarioResponseDTO;
import com.finance.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    private AuthService authService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody CadastroDTO dto) {
        String token = authService.registrar(dto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
        String token = authService.autenticar(dto);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        return ResponseEntity.ok(authService.listarTodos());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscaporId(@PathVariable Integer id) {
        return ResponseEntity.ok(authService.buscarPorId(id));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Integer id) {
        authService.deletarPorid(id);
        return ResponseEntity.noContent().build();
    }
}