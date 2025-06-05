package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ClientesDAO {

    //Objeto para instanciar classe Conexão para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirCliente(/*Cliente Cliente*/) {
        try {

            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes " + "(nome, email, telefone, cpf) VALUES (?,?,?,?);");

            //Setar os Parâmetros
            novoCliente.setString(1, "Cleiton");
            novoCliente.setString(2, "Cleiton@gmail.com");
            novoCliente.setString(3, "(15)23598828");
            novoCliente.setString(4, "195.870.158-00");


            int linhaAfetada = novoCliente.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {

            System.out.println("Erro ao inserir clientes: " + erro);
            return false;
        }
    }
}
