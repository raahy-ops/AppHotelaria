package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // exemplo private String nome = "algo";
    // driver, url, usuario, senha

    private String driver = "com.mysql.cj.dbc.Driver";
    //localhost:3306/dbHotel
    private String url = "jdbc:myslq://127.0.0.1:3306/hotelaria";
    private String usuario = "dbaHotel";
    private String senha = "dbahotel123";

    public Connection conectar() {
        Connection condb = null;

        try {

            //* Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL //
           Class.forName(driver);


            //* Inicializar Drve já carregado por meio de um método chamado getConnection(IP, porta, nome do banco, usuario, senha) *//
            condb = DriverManager.getConnection(url, usuario, senha);
             return condb;

        } catch (SQLException erro) {
            System.out.print("Erro ao conectar ao Banco de Dados " + erro);
            return null;
        }

    }
}

