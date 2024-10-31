package br.com.fiap.util;

import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Funcionario;
import br.com.fiap.model.Paciente;

import java.time.LocalDateTime;

public class AtendimentoTO {

    private long id;
    private String tipo;
    private String descricao;
    private long idFuncionario;
    private long idDoente;

    public Atendimento toAtendimento() {
        Atendimento ate = new Atendimento();
        ate.setId(id);
        ate.setTipo(tipo);
        ate.setDescricao(descricao);

        ate.setDataHora(LocalDateTime.now());

        Paciente p = new Paciente();
        p.setId(idDoente);

        Funcionario f = new Funcionario();
        f.setId(idFuncionario);

        ate.setFuncionario(f);
        ate.setDoente(p);

        return ate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public long getIdDoente() {
        return idDoente;
    }

    public void setIdDoente(long idDoente) {
        this.idDoente = idDoente;
    }
}
