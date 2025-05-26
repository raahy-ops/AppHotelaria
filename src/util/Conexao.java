package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    // exemplo private String nome = "algo";
    // driver, url, usuario, senha

    private String driver ;
    //localhost:3306/dbHotel
    private String url ;
    private String usuario ;
    private String senha ;


    /*Inicializar um construtor, de modo que quando essa classe
     Conexão.java for instanciada em um objeto, o construtor será executado e a classe
     Coneao.java inicializada
     */

    public Conexao() {
        carregarConfiguracoes();
    }
    //Metodo com os parametros de configuraçao das variaveis de ambiente

    private void carregarConfiguracoes() {
        Properties props = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream
                ("config.properties")){
            props.load(inputPropsConfig);
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            usuario = props.getProperty("usuario");
            senha = props.getProperty("senha");

        }
        catch (IOException erro){
            System.out.println("Erro ao carregar configurações: " + erro.getMessage());
        }
    }




    public Connection conectar() {
        Connection condb = null;

        try {

            //* Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL //
           Class.forName(driver);


            //* Inicializar Drve já carregado por meio de um método chamado getConnection(IP, porta, nome do banco, usuario, senha) *//
            condb = DriverManager.getConnection(url, usuario, senha);
             return condb;

        } catch (SQLException | ClassNotFoundException erro) {
            System.out.print("Erro ao conectar ao Banco de Dados " + erro);
            return null;

        }

    }
}

