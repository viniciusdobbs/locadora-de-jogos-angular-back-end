package com.api.locadoradejogos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_LOCACAO")
public class LocacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_LOCACAO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLocacao;

    @Column(name = "NU_VALOR_DIA")
    private double valorDia;

    @Column(name = "DT_LOCACAO")
    private Date dataLocacao;

    @Column(name = "DT_DEVOLUCAO")
    private Date dataDevolucao;

    @ManyToOne
    @JoinColumn(name="ID_JOGO", referencedColumnName="ID_JOGO")
    private JogosModel jogo;

    @ManyToOne
    @JoinColumn(name="ID_CLIENTE", referencedColumnName="ID_PESSOA")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name="ID_FUNC", referencedColumnName="ID_PESSOA")
    private FuncionarioModel funcionario;
}
