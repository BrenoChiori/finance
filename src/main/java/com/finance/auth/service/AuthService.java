package com.finance.auth.service;

import com.finance.auth.dto.CadastroDTO;
import com.finance.auth.dto.LoginDTO;
import com.finance.auth.dto.UsuarioResponseDTO;
import com.finance.auth.model.Usuario;
import com.finance.auth.repository.UsuarioRepository;
import com.finance.auth.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String registrar(CadastroDTO dto) {
        if(usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario novoUsuario = new Usuario(dto.getNome(), dto.getEmail(), passwordEncoder.encode(dto.getSenha()), dto.getRole());

        usuarioRepository.save(novoUsuario);
        return jwtService.gerarToken(dto.getEmail());
    }

    public String autenticar(LoginDTO dto) {
        Authentication auth = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());
        authenticationManager.authenticate(auth);
        return jwtService.gerarToken(dto.getEmail());
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioResponseDTO(u.getId(), u.getNome(), u.getEmail(), u.getRole()))
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }

        Usuario u = usuario.get();
        return new UsuarioResponseDTO(u.getId(), u.getNome(), u.getEmail(), u.getRole());
    }

    public void deletarPorid(Integer id) {
        usuarioRepository.deleteById(id);
    }
}