package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais(/*Adicionais adicionais*/) {

        try {

            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement("INSERT INTO adicionais" + "(nome,preco) VALUES (?,?);");

            //Setar os Parâmetros
            novoAdicional.setString(1, "Tudo Incluso");
            novoAdicional.setDouble(2, 600.00);

            int linhaAfetada = novoAdicional.executeUpdate();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicionais: " + erro);
            return false;
        }
    }

}
