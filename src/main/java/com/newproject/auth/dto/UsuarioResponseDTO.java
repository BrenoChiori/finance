package com.newproject.auth.dto;

import com.newproject.auth.model.enums.TipoRole;

public class UsuarioResponseDTO {
    private Integer id;

    private String nome;

    private String email;

    private TipoRole role;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Integer id, String nome, String email, TipoRole role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoRole getRole() {
        return role;
    }

    public void setRole(TipoRole role) {
        this.role = role;
    }
}
