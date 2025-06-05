package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CargosDAO {

    //Objeto para instanciar classe Conexão para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirCargos(/*Usuario usuario*/) {
        try {

            Connection conndb = conexao.conectar();
            PreparedStatement novoCargo = conndb.prepareStatement("INSERT INTO cargos  " + "(nome) VALUES (?);");

            //Setar os Parâmetros
            novoCargo.setString(1, "TI");




            int linhaAfetada = novoCargo.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {

            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }

}
