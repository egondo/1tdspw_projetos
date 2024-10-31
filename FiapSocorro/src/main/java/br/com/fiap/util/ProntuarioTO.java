package br.com.fiap.util;

import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Triagem;

import java.util.ArrayList;
import java.util.List;

public class ProntuarioTO {

    private PacienteTO paciente;
    private List<TriagemDTO> triagens = new ArrayList<>();
    private List<AtendimentoDTO> atendimentos = new ArrayList<>();

    public PacienteTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteTO paciente) {
        this.paciente = paciente;
    }

    public List<TriagemDTO> getTriagens() {
        return triagens;
    }

    public void setTriagens(List<TriagemDTO> triagens) {
        this.triagens = triagens;
    }

    public List<AtendimentoDTO> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<AtendimentoDTO> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
