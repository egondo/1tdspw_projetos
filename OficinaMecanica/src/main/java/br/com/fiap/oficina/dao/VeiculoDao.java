package br.com.fiap.oficina.dao;

import br.com.fiap.oficina.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VeiculoDao {

    public void insere(Veiculo v) throws Exception {
        String ins = "INSERT into t_veiculo(placa, modelo, marca, dono, ano) " +
                "values(?, ?, ? ,?, ?)";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(ins, new String[]{"id"});) {

            pstmt.setString(1, v.getPlaca());
            pstmt.setString(2, v.getModelo());
            pstmt.setString(3, v.getMarca());
            pstmt.setString(4, v.getDono());
            pstmt.setInt(5, v.getAno());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                v.setId(rs.getBigDecimal(1).longValue());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
