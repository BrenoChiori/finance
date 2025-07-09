package com.finance.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "DESPESA")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeConta;

    private BigDecimal valor;

    private boolean foiPaga;

    private LocalDate dataPagamento;

    private boolean recorrente;

    private LocalDate dataFim;

    @ManyToOne
    private UsuarioDetalhe usuario;
}
