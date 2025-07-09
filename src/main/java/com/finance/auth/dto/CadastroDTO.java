package com.finance.auth.dto;

import com.finance.auth.model.enums.TipoRole;

public class CadastroDTO {

    private String nome;

    private String email;

    private String senha;

    private TipoRole role;

    public CadastroDTO() {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoRole getRole() {
        return role;
    }

    public void setRole(TipoRole role) {
        this.role = role;
    }
}
