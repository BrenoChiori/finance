package com.finance.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "REGISTROMENSAL")
public class RegistroMensal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "MM/yyyy")
    private Date mesAno;

    @ManyToOne
    private UsuarioDetalhe usuario;

    @OneToMany
    private List<Despesa> despesas;

    public RegistroMensal() {
    }

    public RegistroMensal(Integer id, Date mesAno, UsuarioDetalhe usuario, List<Despesa> despesas) {
        this.id = id;
        this.mesAno = mesAno;
        this.usuario = usuario;
        this.despesas = despesas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMesAno() {
        return mesAno;
    }

    public void setMesAno(Date mesAno) {
        this.mesAno = mesAno;
    }

    public UsuarioDetalhe getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDetalhe usuario) {
        this.usuario = usuario;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}