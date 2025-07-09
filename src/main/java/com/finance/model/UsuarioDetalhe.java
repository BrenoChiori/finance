package com.finance.model;

import com.finance.auth.model.Usuario;
import com.finance.auth.model.enums.TipoRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIODETALHE")
public class UsuarioDetalhe extends Usuario {

    public UsuarioDetalhe() {
    }

    public UsuarioDetalhe(String nome, String email, String senha, TipoRole role) {
        super(nome, email, senha, role);
    }
}
