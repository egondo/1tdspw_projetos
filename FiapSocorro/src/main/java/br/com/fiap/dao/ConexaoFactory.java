package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {

    public Connection getConexao() throws Exception {
        //Class.forName("");
        String s = System.getenv("USER_ORACLE");
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        return DriverManager.getConnection(url, s,
                                        "professor#23");
    }

    public static void main(String[] args) {
        String s = System.getenv("USER_ORACLE");
        System.out.print(s);
    }


}
