package br.com.fiap.util;

import br.com.fiap.model.Funcionario;
import br.com.fiap.model.Paciente;

public class AtendimentoDTO extends AtendimentoTO {

    private String dataHora;
    private Funcionario funcionario;
    private Paciente paciente;

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
