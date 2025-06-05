package dao;

import model.Usuario;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {

    //Objeto para instanciar classe Conexão para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario(/*Usuario usuario*/) {
        try {

            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios" + "(nome, email, senha, cargo_id) VALUES (?,?, md5(?),?);");

            //Setar os Parâmetros
            novoUsuario.setString(1, "Rayssa");
            novoUsuario.setString(2, "Rayssa@gmail.com");
            novoUsuario.setString(3, "123");
            novoUsuario.setInt(4, 1);


            int linhaAfetada = novoUsuario.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {

            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}
