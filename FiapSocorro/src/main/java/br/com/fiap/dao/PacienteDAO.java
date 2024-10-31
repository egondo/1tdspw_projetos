package br.com.fiap.dao;

import br.com.fiap.model.Paciente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacienteDAO {

    public void insert(Paciente pac) throws Exception {
        String sql = "insert into tbw_paciente(nome, documento, nascimento, " +
                "telefone) values(?, ?, ?, ?)";
        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, pac.getNome());
            pstmt.setString(2, pac.getDocumento());
            pstmt.setDate(3, Date.valueOf(pac.getNascimento()));
            pstmt.setString(4, pac.getTelefone());
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Paciente recuperaPorId(long id) throws Exception {
        String sql = "select id, nome, documento, telefone, nascimento from tbw_paciente where id=?";
        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getLong("id"));
                p.setTelefone(rs.getString("telefone"));
                p.setDocumento(rs.getString("documento"));
                p.setNome(rs.getString("nome"));
                p.setNascimento(rs.getDate("nascimento").toLocalDate());
                return p;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
}
