package br.com.fiap.persistencia.dao;

import br.com.fiap.persistencia.model.Paciente;
import br.com.fiap.persistencia.util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class PacienteDao {

    public void inclui(Paciente pac) throws Exception {
        Conexao c = new Conexao();
        String sql = "insert into t_paciente (nome, telefone, email, responsavel, cpf, nascimento) " +
                "values(? , ?, ?, ?, ?, ?)";

        try (Connection con = c.getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, pac.getNome());
            pstmt.setString(2, pac.getTelefone());
            pstmt.setString(3, pac.getEmail());
            pstmt.setString(4, pac.getResponsavel());
            pstmt.setLong(5, pac.getCpf());
            pstmt.setDate(6, Date.valueOf(pac.getNascimento()));
            pstmt.executeUpdate();
        }
    }


    public static void main(String[] args) {
        Paciente p = new Paciente();
        p.setNascimento(LocalDate.of(2004, 8, 23));
        p.setCpf(234938928);
        p.setNome("Abel Ferreira");
        p.setEmail("abel@fiap.com.br");
        p.setTelefone("234230494");
        p.setResponsavel(null);

        PacienteDao pdao = new PacienteDao();
        try {
            pdao.inclui(p);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
