package br.com.fiap.enquete.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.enquete.model.Enquete;

public class EnqueteDao {

	
	public List<Enquete> recupera() throws Exception {
		String sql = "select id, nome, descricao, criador, datacriacao from tb_enquete order by datacriacao";
		List<Enquete> retorno = new ArrayList<>();
		
		try(Connection con = new Conexao().getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Enquete enq = new Enquete();
				enq.setId(rs.getLong("id"));
				enq.setNome(rs.getString("nome"));
				enq.setDescricao(rs.getString("descricao"));
				enq.setCriador(rs.getString("criador"));
				enq.setDataCriacao(rs.getDate("datacriacao").toLocalDate());
				
				retorno.add(enq);			
			}
			return retorno;			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void altera(Enquete enq) throws Exception {
		String upd = "update tb_enquete set nome=?, descricao=?, criador=?, datacriacao=? where id=?";
		try(Connection con = new Conexao().getConexao();
			PreparedStatement pstmt = con.prepareStatement(upd);) {
			
			
			pstmt.setString(1, enq.getNome());
			pstmt.setString(2, enq.getDescricao());
			pstmt.setString(3, enq.getCriador());
			pstmt.setDate(4, Date.valueOf(enq.getDataCriacao()));
			pstmt.setLong(5, enq.getId());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	
	}
}








