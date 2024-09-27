package br.com.fiap.persistencia.app;

import br.com.fiap.persistencia.util.Conexao;

import java.sql.Connection;
import java.sql.Statement;

public class InserePaciente {
//create table T_paciente(id number generated by default as identity,nome varchar2(100),telefone varchar2(50),email varchar2(100),responsavel varchar2(70),
//cpf number(14),
//nascimento date,
//primary key(id))
    public static void main(String[] args) {
        Conexao c = new Conexao();
        try(Connection con = c.getConexao();
            Statement stmt = con.createStatement();) {

            String sql = "insert into T_paciente(nome, email, telefone) " +
                    "values('Raul', 'raul@fiap.com.br', '92840922')";

            stmt.executeUpdate(sql);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}